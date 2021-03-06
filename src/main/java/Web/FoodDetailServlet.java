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

import Bean.FoodDetailBean;
import Dao.DBUtil;
import Dao.FoodDao;
import Dao.UserVo;


/**
 * Servlet implementation class FoodDetailServlet
 */
@WebServlet("/FoodDetailServlet")
public class FoodDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fromStr = request.getParameter( "from1" );
		
		String strfoodID = request.getParameter("foodID");
		int foodID = Integer.parseInt(strfoodID);
		FoodDetailBean bean = getBean(foodID);
		//session取得
		HttpSession session =request.getSession();

		if(fromStr != null)
		{
			sumGoodCount(foodID);
		}
		
		UserVo username =(UserVo)session.getAttribute("UserName");		
		bean.setUserName(username.getUserName());
		request.setAttribute("bean", bean);
		RequestDispatcher disp = request.getRequestDispatcher("/foodDetail.jsp");
		disp.forward(request, response);
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private FoodDetailBean getBean(int foodID) 
	{
		DBUtil dbutil = new DBUtil();
		FoodDetailBean bean=null;
		try(Connection c = dbutil.getConnection())
		{
			FoodDao foodDao = new FoodDao(c);
			bean = foodDao.getFoodDetailBean(foodID);
		} catch (SQLException e)
		{
			throw new RuntimeException(e);
		}
		return bean;
	}
	
	//オススメリストから逸品追加
	private static void sumGoodCount(int foodid)
	{
		DBUtil dbUtil = new  DBUtil();

		//コネクションを取得
		try( Connection  con = dbUtil.getConnection(); )
		{
			FoodDao edao = new FoodDao( con );
			
			//GOODカウント＋１
			edao.sumGoodCount(foodid);

		}
		catch( SQLException e )
		{
			throw new RuntimeException( e );//ランタイム例外に載せ替えて再スロー
		}

	}
	
}
