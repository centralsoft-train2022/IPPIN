package Web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.FoodDetailBean2;
import Dao.DBUtil;
import Dao.FoodDao;
import Dao.FoodVo;
import Dao.UserVo;


@WebServlet("/FoodDetailServlet2")
public class FoodDetailServlet2 extends HttpServlet {

	protected void doPost(
			HttpServletRequest request,
			HttpServletResponse response
			) throws ServletException, IOException
	{
		FoodDetailBean2 bean = new FoodDetailBean2();
		FoodVo foodDetail = null;
		
		// 文字コードの設定
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		//選択した逸品名を取得
		String naStr = request.getParameter("NAME");
		System.out.println(naStr);
		
		foodDetail = getFoodDetail(naStr);
		
		HttpSession session = request.getSession();		
		UserVo username =(UserVo)session.getAttribute("UserName");	
		
		//beanにセット
		bean.setUserName(username.getUserName());
		bean.setIppin(foodDetail.getFoodName());
		bean.setCookTime(foodDetail.getCookTime());
		bean.setAmount(foodDetail.getAmount());
		bean.setTimezone(foodDetail.getTimeZone());
		bean.setFileName(foodDetail.getFilename());
	
		
		request.setAttribute("bean", bean);

		//JSPに遷移する
		RequestDispatcher disp = request.getRequestDispatcher("/foodDetail2.jsp");
		disp.forward(request, response);
	}
	
	//DBから従業員を取得する
	private static FoodVo getFoodDetail(String name)
	{
		FoodVo ippinDetail = null;
		DBUtil dbUtil = new  DBUtil();

		//コネクションを取得
		try( Connection  con = dbUtil.getConnection(); )
		{
			FoodDao edao = new FoodDao( con );

			//DBから詳細を取得
			ippinDetail = edao.getFoodDetail(name);

			//取得したデータを表示する
			//System.out.println( emp );

		}
		catch( SQLException e )
		{
			throw new RuntimeException( e );//ランタイム例外に載せ替えて再スロー
		}

		return ippinDetail;
	}

}


