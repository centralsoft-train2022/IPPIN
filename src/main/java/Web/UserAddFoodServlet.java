package Web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserAddFoodServlet
 */
@WebServlet("/UserAddFoodServlet")
public class UserAddFoodServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserAddFoodServlet()
	{
		super( );
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet( HttpServletRequest request, HttpServletResponse response )
	        throws ServletException, IOException
	{

		String fromStr = request.getParameter( "from1" );

		if( fromStr != null )
		{

			RequestDispatcher disp = request.getRequestDispatcher( "/userList.jsp" );
			disp.forward( request, response );
		}
		else
		{
			Bean.UserAddFoodBean bean = new Bean.UserAddFoodBean( );

			// セッションにユーザー情報保存してsetする

			bean.setUserName( "國井さん" );
			request.setAttribute( "bean", bean );
			// JSPに遷移する
			RequestDispatcher disp = request.getRequestDispatcher( "/userAddFood.jsp" );
			disp.forward( request, response );
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost( HttpServletRequest request, HttpServletResponse response )
	        throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		doGet( request, response );
	}

//	 private void registFood( FoodVo foodVo ) 作ってよびだし←まだ
//	 {
//
//	 }
}
