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

import Bean.SearchBean;
import Dao.DBUtil;
import Dao.FoodDao;
import Dao.FoodVo;

//食べる時間、量、手間から文字を出す

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {

	protected void doGet(
			HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException

	{
		String fromJsp = request.getParameter("from jsp");

		if (fromJsp != null) {
			SearchBean bean;

			String AM = request.getParameter("Amount");
			String TZ = request.getParameter("TimeZone");
			String CT = request.getParameter("CookTime");

			bean = searchFood(AM, TZ, CT);
			request.setAttribute("bean", bean);
		}

		else {
			//新しいbean　からっぽ
			SearchBean bean = new SearchBean();
			List<FoodVo> list = new ArrayList<FoodVo>();
			bean.setFoodList(list);
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
		try (Connection con = dbUtil.getConection();) {
			FoodDao edao = new FoodDao(con);

			//osusumeList = edao.getFoodname(AM, TZ, CT);
			bean.setFoodList(edao.getZyoukentukiFoodVo(tz, am, ct));
			// 取得したデータを表示する
			//System.out.println(osusumeList);

		} catch (SQLException e) {
			throw new RuntimeException(e);// ランタイム例外に載せ替えて再スロー
		}
		return bean;
		//		List<FoodVo> list = new ArrayList<FoodVo>();
		//		FoodVo fv = new FoodVo();
		//		fv.setFoodid(0);
		//		fv.setFoodName("ちょこ");
		//
		//		list.add(fv);
		//
		//		fv = new FoodVo();
		//		fv.setFoodid(1);
		//		fv.setFoodName("らーめん");
		//		list.add(fv);
		//
		//		SearchBean sb = new SearchBean();
		//		sb.setFoodList(list);
		//		sb.setAmount(am);
		//		sb.setTimeZone(tz);
		//		sb.setCookTime(ct);
		//		return sb;
	}
}