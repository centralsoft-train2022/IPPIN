package Web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.YesBean;
import Dao.DBUtil;
import Dao.FoodDao;
import Dao.FoodHistoryDao;
import Dao.UserVo;


@WebServlet("/YesServlet")
public class YesServlet extends HttpServlet{

	protected void doPost(
			HttpServletRequest request,
			HttpServletResponse response
			) throws ServletException, IOException
	{
		YesBean bean = new YesBean();
		bean.setMsg("【決まってよかったね】");
		
		//session取得
		HttpSession session =request.getSession();
		String ippinname =(String)session.getAttribute("IPPINName");
		UserVo username =(UserVo)session.getAttribute("UserName");
		int id =(int)session.getAttribute("ID");
		
		//逸品goodカウントを＋１とYESを押した時間を登録するメソッド
		addippingoodcount(id,ippinname);
		
		bean.setUserName(username.getUserName());
				
		request.setAttribute("bean", bean);

		//JSPに遷移する
		RequestDispatcher disp = request.getRequestDispatcher("/yes.jsp");
		disp.forward(request, response);
	}
	
	private static void addippingoodcount(int id, String username)
	{
		DBUtil dbUtil = new  DBUtil();
	
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());

		//コネクションを取得
		try( Connection  con = dbUtil.getConnection(); )
		{
			FoodDao fdao = new FoodDao( con );
			FoodHistoryDao fhdao = new FoodHistoryDao(con);
			
			int foodid = fdao.getFoodid(username);
			
			//選択された逸品のippingoodcountを＋1する
	        fdao.sumIppinGoodCount(foodid);
	        
	        //YESボタンを押した時間を追加
			fhdao.insert(timestamp,id,foodid);
			
			con.commit();
		}
		catch( SQLException e )
		{
			throw new RuntimeException( e );//ランタイム例外に載せ替えて再スロー
		}	
	}

}
