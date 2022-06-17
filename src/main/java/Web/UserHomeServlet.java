package Web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.UserHomeBean;
import Dao.UserVo;

@WebServlet("/UserHomeServlet")
public class UserHomeServlet extends HttpServlet
{
	protected void doPost(
			HttpServletRequest request,
			HttpServletResponse response
			) throws ServletException, IOException
	{
		UserHomeBean bean = new UserHomeBean();

		//session取得
		HttpSession session =request.getSession();
		UserVo username =(UserVo)session.getAttribute("UserName");
//		int id =(int)session.getAttribute("ID");
				
		bean.setUserName(username.getUserName());
				
//		session.setAttribute( "UserName", username );
//		session.setAttribute( "ID", id );
		
		//次の画面遷移の処理
		bean.setUserName( username.getUserName() );

		request.setAttribute("bean", bean);

		//JSPに遷移する
		RequestDispatcher disp = request.getRequestDispatcher("/userHome.jsp");
		disp.forward(request, response);
	}
}