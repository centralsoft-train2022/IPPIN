package Web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.SearchBean;
import Dao.DBUtil;
import Dao.FoodDao;
import Dao.FoodVo;
import Dao.UserVo;

//食べる時間、量、手間から文字を出す

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {

	protected void doGet( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException
	{
		String fromJsp = request.getParameter("from jsp");
		//session取得
		HttpSession session =request.getSession();
		UserVo username =(UserVo)session.getAttribute("UserName");
		
		if (fromJsp != null) {
			SearchBean bean;

			//文字化け防止
			request.setCharacterEncoding("utf-8");
			
			String AM = request.getParameter("Amount");
			String TZ = request.getParameter("TimeZone");
			String CT = request.getParameter("CookTime");
			
			bean = searchFood(AM, TZ, CT);
			// セッションにユーザー情報保存してsetする
			bean.setUserName(username.getUserName());
			request.setAttribute("bean", bean);
			System.out.println(bean.toString());
		}

		else {
			//新しいbean　からっぽ
			SearchBean bean = new SearchBean();
			List<FoodVo> list = new ArrayList<FoodVo>();
			bean.setFoodList(list);
			// セッションにユーザー情報保存してsetする
			bean.setUserName(username.getUserName());
			request.setAttribute("bean", bean);
		}

		//JSPに遷移する
		RequestDispatcher disp = request.getRequestDispatcher("/search.jsp");
		disp.forward(request, response);

	}

	private SearchBean searchFood(String am, String tz, String ct) {
		// コネクションを取得
		SearchBean bean = new SearchBean();
		bean.setAmount(am);
		bean.setTimeZone(tz);
		bean.setCookTime(ct);
		DBUtil dbUtil = new DBUtil();
		try (Connection con = dbUtil.getConnection();) {
			FoodDao dao = new FoodDao(con);

			//osusumeList = edao.getFoodname(AM, TZ, CT);
			bean.setFoodList(dao.getZyoukentukiFoodVo(tz, am, ct));

		} catch (SQLException e) {
			throw new RuntimeException(e);// ランタイム例外に載せ替えて再スロー
		}
		return bean;

	}
}
