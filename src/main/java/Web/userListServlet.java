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

import Bean.userListBean;
import Dao.DBUtil;
import Dao.FoodDao;
import Dao.FoodVo;
import Dao.UserVo;


@WebServlet("/userListServlet")
public class userListServlet extends HttpServlet {

	protected void doPost(
			HttpServletRequest request,
			HttpServletResponse response
			) throws ServletException, IOException
	{
		request.setCharacterEncoding( "UTF-8" );// 文字化け防止
		HttpSession session = request.getSession();
		String fromStr = request.getParameter( "from1" );
		String strfoodID = request.getParameter("foodID");
		
		UserVo username =(UserVo)session.getAttribute("UserName");
		int id =(int)session.getAttribute("ID");
		
		if(fromStr != null)
		{
			int foodID = Integer.parseInt(strfoodID);
			updateUserID(foodID);
		}
		List<FoodVo>  ippinNameList = getEmployeesVoList(id);

		userListBean bean = new userListBean();

		bean.setMsg("逸品リストを表示します");
		bean.setIppinList( ippinNameList );

		bean.setUserName(username.getUserName());

		request.setAttribute("bean", bean);

		//JSPに遷移する
		RequestDispatcher disp = request.getRequestDispatcher("/userList.jsp");
		disp.forward(request, response);
	}

	//DBから逸品名を取得する
	private static List<FoodVo> getEmployeesVoList(int id)
	{
		List<FoodVo> ippinList = null;
		DBUtil dbUtil = new  DBUtil();

		//コネクションを取得
		try( Connection  con = dbUtil.getConnection(); )
		{
			FoodDao edao = new FoodDao( con );

			//DBから逸品名を取得
			ippinList = edao.getIppinname(id);

			//取得したデータを表示する
			//System.out.println( emp );

		}
		catch( SQLException e )
		{
			throw new RuntimeException( e );//ランタイム例外に載せ替えて再スロー
		}

		return ippinList;
	}
	
	
	//オススメリストから逸品追加
	private static void updateUserID(int foodid)
	{
		DBUtil dbUtil = new  DBUtil();

		//コネクションを取得
		try( Connection  con = dbUtil.getConnection(); )
		{
			FoodDao edao = new FoodDao( con );
			
			//オススメリストから逸品追加
			edao.updateUserID(foodid);

		}
		catch( SQLException e )
		{
			throw new RuntimeException( e );//ランタイム例外に載せ替えて再スロー
		}

		
	}

}
