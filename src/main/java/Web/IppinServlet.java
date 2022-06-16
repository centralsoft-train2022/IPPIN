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
import Dao.FoodHistoryDao;

@WebServlet("/IppinServlet")
public class IppinServlet extends HttpServlet
{

	protected void doPost( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException
	{
		// 社員リストwoDBから取得 課題
		List<String> userList2 = getIppinVoList();

		IppinBean bean = new IppinBean();

		bean.setMsg("【今日の逸品】");

		int i = 0;
		String ippin = userList2.get(i);
		i += 1;
		bean.setIppin(ippin);

		HttpSession session = request.getSession();
		session.setAttribute("ListNumber", i); // 取得する配列の番地
		session.setAttribute("IPPINList", userList2);// 配列の中身
		session.setAttribute("IPPINName", ippin);// 逸品の名前

		request.setAttribute("bean", bean);

		// JSPに遷移する
		RequestDispatcher disp = request.getRequestDispatcher("/ippin.jsp");
		disp.forward(request, response);
	}

	// DBから逸品リストを取得する
	private static List<String> getIppinVoList()
	{
		List<String> ippinList = null;
		DBUtil dbUtil = new DBUtil();

		// コネクションを取得
		try (Connection con = dbUtil.getConection();)
		{
			FoodDao edao = new FoodDao(con);

			ippinList = edao.getIppin();

			//Collections.shuffle(ippinList);

			String nearlyIppin = getNearlyIppin();

			System.out.println(ippinList);

			// 前回食べた物を最後に移動
			ippinList.remove(ippinList.lastIndexOf(nearlyIppin));
			ippinList.add(nearlyIppin);

			// 取得したデータを表示する
			System.out.println(ippinList);

		} catch (SQLException e)
		{
			throw new RuntimeException(e);// ランタイム例外に載せ替えて再スロー
		}

		return ippinList;
	}

	// DBから更新が一番最近の逸品を取得する
	private static String getNearlyIppin()
	{
		DBUtil dbUtil = new DBUtil();

		// コネクションを取得
		try (Connection con = dbUtil.getConection();)
		{
			FoodHistoryDao ehdao = new FoodHistoryDao(con);
			int foodid = ehdao.getFoodid();

			FoodDao fdao = new FoodDao(con);

			String nearlyname = fdao.getNearlyIppin(foodid);

			System.out.println(nearlyname);

			return nearlyname;

		} catch (SQLException e)
		{
			throw new RuntimeException(e);// ランタイム例外に載せ替えて再スロー
		}
	}

}