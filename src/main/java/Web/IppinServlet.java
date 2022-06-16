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
import Bean.RecomBean;
import Dao.DBUtil;
import Dao.FoodDao;
import Dao.FoodHistoryDao;
import Dao.UserVo;

@WebServlet("/IppinServlet")
public class IppinServlet extends HttpServlet
{

	@SuppressWarnings("unlikely-arg-type")
	protected void doPost( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException
	{
		// 社員リストwoDBから取得 課題
		//List<String> userList2 = getIppinVoList();

		IppinBean bean = new IppinBean();
		
		request.setCharacterEncoding("UTF-8");
		
		//画面から入力したデータを取得する
		String tzStr = request.getParameter("TimeZone");
		String amStr = request.getParameter("Amount");
		String crStr = request.getParameter("CookTime");
		
	
		
		
		
		
		List<String> ippinList = null;
		DBUtil dbUtil = new DBUtil();

		// コネクションを取得
		try (Connection con = dbUtil.getConection();)
		{
			FoodDao edao = new FoodDao(con);

			ippinList = edao.getZyoukentukiName(tzStr, amStr, crStr);

			if(ippinList.size() == 0)
			{
				RecomBean rebean = new RecomBean();
				rebean.setMsg("【条件に合う逸品がありません。オススメから逸品を追加してみては？】");
				request.setAttribute("bean", rebean);
				RequestDispatcher disp = request.getRequestDispatcher("/recom.jsp");
				disp.forward(request, response);
			}
			//Collections.shuffle(ippinList);

			String nearlyIppin = getNearlyIppin();

			System.out.println(ippinList);
			
			// 前回食べた物を最後に移動
			//もし条件で絞られたリストの中に前回食べた物があったらそれを一番最後にやる
			if( ippinList.indexOf(ippinList) != -1)
			{
				ippinList.remove(ippinList.lastIndexOf(nearlyIppin));
				ippinList.add(nearlyIppin);
			}
			// 取得したデータを表示する
			System.out.println(ippinList);

		}catch (SQLException e)
		{
			throw new RuntimeException(e);// ランタイム例外に載せ替えて再スロー
		}
	    
		
		//session取得
		HttpSession session =request.getSession();
		UserVo username =(UserVo)session.getAttribute("UserName");
		int id =(int)session.getAttribute("ID");
		
		bean.setUserName(username.getUserName());
		
		bean.setMsg("【今日の逸品】");

		int i = 0;
		String ippin = ippinList.get(i);
		i += 1;
		bean.setIppin(ippin);

		//sessionに保存
		session.setAttribute("ListNumber", i); // 取得する配列の番地
		session.setAttribute("IPPINList", ippinList);// 配列の中身
		session.setAttribute("IPPINName", ippin);// 逸品の名前
		session.setAttribute("UserName", username);// ユーザーの名前
		session.setAttribute("id", id);// ユーザーid

		request.setAttribute("bean", bean);

		// JSPに遷移する
		RequestDispatcher disp = request.getRequestDispatcher("/ippin.jsp");
		disp.forward(request, response);
	}

	// DBから逸品リストを取得する
//	private static List<String> getIppinVoList()
//	{
//		List<String> ippinList = null;
//		DBUtil dbUtil = new DBUtil();
//
//		// コネクションを取得
//		try (Connection con = dbUtil.getConection();)
//		{
//			FoodDao edao = new FoodDao(con);
//
//			ippinList = edao.getIppin();
//
//			//Collections.shuffle(ippinList);
//
//			String nearlyIppin = getNearlyIppin();
//
//			System.out.println(ippinList);
//
//			// 前回食べた物を最後に移動
//			ippinList.remove(ippinList.lastIndexOf(nearlyIppin));
//			ippinList.add(nearlyIppin);
//
//			// 取得したデータを表示する
//			System.out.println(ippinList);
//
//		} catch (SQLException e)
//		{
//			throw new RuntimeException(e);// ランタイム例外に載せ替えて再スロー
//		}
//
//		return ippinList;
//	}

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