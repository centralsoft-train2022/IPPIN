package Web;

import Bean.UserAddFoodBean;
import Dao.DBUtil;
import Dao.FoodDao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
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
		request.setCharacterEncoding( "UTF-8" );// 文字化け防止
		String fromStr = request.getParameter( "from1" );

		if( fromStr != null )
		{
			// 画面から入力したデータを取得する

			String	ippinName		= request.getParameter( "IppinName" );
			String	timeZone		= request.getParameter( "TimeZone" );
			String	amount			= request.getParameter( "Amount" );
			String	cookTime		= request.getParameter( "CookTime" );
			String	photoFileName	= request.getParameter( "PhotoFileName" );

			System.out.println( ippinName );
			System.out.println( timeZone );
			System.out.println( amount );
			System.out.println( cookTime );
			System.out.println( photoFileName );

			registFood( 11, ippinName, timeZone, amount, cookTime, photoFileName, 1 );

			RequestDispatcher disp = request.getRequestDispatcher( "/userList.jsp" );
			disp.forward( request, response );
		}
		else
		{
			UserAddFoodBean bean = new UserAddFoodBean( );

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

	private void registFood(
	        int foodid, String ippinName, String timeZone, String amount, String cookTime, String photoFileName,
	        int userid
	)
	{

		// DBから従業員を取得 仮実装
		// emp = new EmployeesVo();
		// emp.setEmployeename();

		DBUtil db = new DBUtil( );

		try( Connection c = db.getConnection( ); )
		{

			FoodDao dao = new FoodDao( c );
			dao.insert( foodid, ippinName, timeZone, amount, cookTime, photoFileName, userid );

			c.commit( );
			c.setAutoCommit( true );
		}
		catch( SQLException e )
		{
			throw new RuntimeException( e );
		}
	}

}
