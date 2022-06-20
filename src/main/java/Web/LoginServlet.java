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

import Bean.UserHomeBean;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet
{
	protected void doPost(
			HttpServletRequest request,
			HttpServletResponse response
			) throws ServletException, IOException
	{
		// 文字コードの設定
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		//画面から入力したデータを取得する
		String idStr = request.getParameter("ID");
		String pwStr = request.getParameter("PW");
		
		try
		{
			int id = Integer.parseInt(idStr);
			
			Dao.UserVo  username = getUserNameVo( id );

			//セッションに保存
			HttpSession session =request.getSession();
			session.setAttribute( "UserName", username );
			session.setAttribute( "ID", id );
			session.setAttribute( "PASSWORD", pwStr );
			
			//次の画面遷移の処理
			UserHomeBean bean = new UserHomeBean();

			request.setAttribute("bean", bean);
			
			
			if (username != null & id == username.getUserid() && pwStr.equals(username.getPassword()) ) 
			{
				bean.setUserName( username.getUserName() );
				RequestDispatcher disp = request.getRequestDispatcher("/userHome.jsp");
				disp.forward(request, response);
			} else {

				RequestDispatcher disp = request.getRequestDispatcher("relogin.jsp");
				disp.forward(request, response);
			}
			
		
		}catch (NullPointerException e) {

			RequestDispatcher disp = request.getRequestDispatcher("relogin.jsp");
			disp.forward(request, response);
		}

		catch (NumberFormatException e)

		{
			RequestDispatcher disp = request.getRequestDispatcher("relogin.jsp");
			disp.forward(request, response);
		}
	}

	//DBからユーザーを取得する
	private Dao.UserVo getUserNameVo( int id )
	{
		Dao.UserVo emp = null;
		Dao.DBUtil dbUtil = new  Dao.DBUtil();

		//コネクションを取得
		try( Connection  con = dbUtil.getConnection(); )
		{
			Dao.UserDao edao = new Dao.UserDao( con );

			//DBからユーザーを取得
			emp = edao.getUserName( id );

			//取得したデータを表示する
			System.out.println( emp );

		}
		catch( SQLException e )
		{
			throw new RuntimeException( e );//ランタイム例外に載せ替えて再スロー
		}

		return emp;
	}


}