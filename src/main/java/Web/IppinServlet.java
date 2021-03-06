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

	protected void doPost( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException
	{
		//List<String> userList2 = getIppinVoList();

		IppinBean bean = new IppinBean();
		
		//文字化け防止
		request.setCharacterEncoding("UTF-8");
		
		//画面から入力したデータを取得する
		String tzStr = request.getParameter("TimeZone"); 
		String amStr = request.getParameter("Amount");
		String crStr = request.getParameter("CookTime");
				
		List<String> ippinList = null;
		DBUtil dbUtil = new DBUtil();
		
		//session取得
		HttpSession session =request.getSession();
		UserVo username =(UserVo)session.getAttribute("UserName");
		int id =(int)session.getAttribute("ID");
		
		bean.setUserName(username.getUserName());
		
		bean.setMsg("【今日の逸品】");
		
		// コネクションを取得
		try (Connection con = dbUtil.getConnection();)
		{
			FoodDao fdao = new FoodDao(con);
			FoodHistoryDao ehdao = new FoodHistoryDao(con);
			
			// もっとも更新が最近のfoodidを取得
			int foodid = ehdao.getFoodid();
			
			ippinList = fdao.getZyoukentukiName(tzStr, amStr, crStr,id);
			
			//前回選んだ逸品を取得
			String nearlyIppin = fdao.getNearlyIppin(foodid);
			//String nearlyIppin = getNearlyIppin(con);

			//条件に合う逸品がなかった場合
			if(ippinList.size() == 0)
			{
				RecomBean rebean = new RecomBean();
				rebean.setMsg("【条件に合う逸品がありません。オススメから逸品を追加してみては？】");
				request.setAttribute("bean", rebean);
				RequestDispatcher disp = request.getRequestDispatcher("/RecomServlet");
				disp.forward(request, response);
			}

			System.out.println(ippinList);
	
			//もし条件で絞られたリストの中に前回食べた物があったらそれを一番最後にやる
			if( ippinList.indexOf(nearlyIppin) != -1)
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

		int i = 0;
		String ippin = ippinList.get(i);
		i += 1;
		bean.setIppin(ippin);

		//sessionに保存
		session.setAttribute("ListNumber", i); // 取得する配列の番地
		session.setAttribute("IPPINList", ippinList);// 配列の中身
		session.setAttribute("IPPINName", ippin);// 逸品の名前
//		session.setAttribute("UserName", username);// ユーザーの名前
//		session.setAttribute("id", id);// ユーザーid

		request.setAttribute("bean", bean);

		// JSPに遷移する
		RequestDispatcher disp = request.getRequestDispatcher("/ippin.jsp");
		disp.forward(request, response);
	}

	// DBから更新が一番最近の逸品を取得する
//	private static String getNearlyIppin(Connection con)
//	{
//		FoodHistoryDao ehdao = new FoodHistoryDao(con);
//		int foodid = ehdao.getFoodid();
//
//		FoodDao fdao = new FoodDao(con);
//
//		String nearlyname = fdao.getNearlyIppin(foodid);
//
//		System.out.println(nearlyname);
//
//		return nearlyname;
//	
//	}

}