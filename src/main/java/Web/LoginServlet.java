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
		//画面から入力したデータを取得する
		String idStr = request.getParameter("ID");
		//String peStr = request.getParameter("PW");
		System.out.println(idStr);
		int id = Integer.parseInt(idStr);
		
		

		//とりあえずPwはつかわない
		Dao.UserVo  username = getUserNameVo( id );

		//パスワードチェック　実装しない　オプション課題

		//セッションに保存
		HttpSession session =request.getSession();
		session.setAttribute( "UserName", username );
		session.setAttribute( "ID", id );

		//次の画面遷移の処理
		UserHomeBean bean = new UserHomeBean();
		bean.setUserName( username.getUserName() );

		request.setAttribute("bean", bean);

		//JSPに遷移する
		RequestDispatcher disp = request.getRequestDispatcher("/userHome.jsp");
		disp.forward(request, response);
	}

	//DBから従業員を取得する
	private Dao.UserVo getUserNameVo( int id )
	{
		Dao.UserVo emp = null;
		Dao.DBUtil dbUtil = new  Dao.DBUtil();

		//コネクションを取得
		try( Connection  con = dbUtil.getConnection(); )
		{
			Dao.UserDao edao = new Dao.UserDao( con );

			//DBから従業員を取得
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