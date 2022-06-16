package Web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.IppinBean;
import Dao.DBUtil;
import Dao.FoodDao;


@WebServlet("/NoServlet")
public class NoServlet extends HttpServlet{

	protected void doPost(
			HttpServletRequest request,
			HttpServletResponse response
			) throws ServletException, IOException
	{

		IppinBean bean = new IppinBean();

		bean.setMsg(			"【今日の逸品】");
		
		//sessionの呼び出し
		HttpSession session =request.getSession();
		int i =(int)session.getAttribute("ListNumber");
		String ippinname =(String)session.getAttribute("IPPINName");
		
		//ランダムで生成したリスト引継ぎ
		@SuppressWarnings("unchecked")
		List<String> ippinList =(List<String>)session.getAttribute("IPPINList");
		
		
		//リストの中身がなくなったらrecomに飛ぶ
		try
		{
			String ippin2 = ippinList.get(i);
			
			System.out.println(ippinname);
			
			//選択された逸品のippingoodcountを-1する
			subippingoodcount(ippinname);
			
			bean.setIppin( 		ippin2 );
			i += 1;
			session.setAttribute( "IPPINName", ippin2 );
			//session保存
			session.setAttribute( "ListNumber", i );
			session.setAttribute( "IPPINList", ippinList );
			

			request.setAttribute("bean", bean);

			//JSPに遷移する
			RequestDispatcher disp = request.getRequestDispatcher("/ippin.jsp");
			disp.forward(request, response);
		}
		catch(Exception e)
		{
			RequestDispatcher disp = request.getRequestDispatcher("/recom.jsp");
			disp.forward(request, response);
		}
				
	}
	
	//選択された逸品のippingoodcountを-1する
		private static void subippingoodcount(String foodname)
		{
			DBUtil dbUtil = new DBUtil();

			// コネクションを取得
			try (Connection con = dbUtil.getConection();)
			{
				FoodDao fdao = new FoodDao( con );
				int foodid = fdao.getFoodid(foodname);
			
				fdao.subIppinGoodCount(foodid);
				con.commit();

			} catch (SQLException e)
			{
				throw new RuntimeException(e);// ランタイム例外に載せ替えて再スロー
			}
			
		}
		
		
		
		


}
