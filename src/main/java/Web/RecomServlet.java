package Web;

import Bean.RecomBean;
import Bean.RecomSubBean;
import Dao.DBUtil;
import Dao.FoodDao;
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

@WebServlet("/RecomServlet")

public class RecomServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

    public RecomServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RecomBean bean =getRecomBeanList();
		request.setAttribute("bean", bean);
		RequestDispatcher disp = request.getRequestDispatcher("/recom.jsp");
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
	
	private RecomBean getRecomBeanList() 
	{
		
		DBUtil dbutil = new DBUtil();
		List<RecomSubBean> list = null;
		RecomBean bean = new RecomBean();
		
		try(Connection c = dbutil.getConnection())
		{
			FoodDao foodDao = new FoodDao(c);
			list = foodDao.getRecomSubBeanList();
			bean.setList(list);
		} catch (SQLException e)
		{
			throw new RuntimeException(e);

		
//		RecomBean bean = new RecomBean();
//		List<RecomSubBean> list = bean.getList();
//		RecomSubBean bean0 = new RecomSubBean();
//		RecomSubBean bean1 = new RecomSubBean();
//		RecomSubBean bean2 = new RecomSubBean();
//		RecomSubBean bean3 = new RecomSubBean();
//		RecomSubBean bean4 = new RecomSubBean();
//		RecomSubBean bean5 = new RecomSubBean();
//		
//		bean0.setFoodID("000");
//		bean1.setFoodID("111");
//		bean2.setFoodID("222");
//		bean3.setFoodID("333");
//		bean4.setFoodID("444");
//		bean5.setFoodID("555");
//		
//		bean0.setPhotoFileName("takenoko.jpg");
//		bean1.setPhotoFileName("kinoko.jpg");
//		bean2.setPhotoFileName("takenoko.jpg");
//		bean3.setPhotoFileName("kinoko.jpg");
//		bean4.setPhotoFileName("kinoko.jpg");
//		bean5.setPhotoFileName("takenoko.jpg");
//		
//		list.add(bean0);
//		list.add(bean1);
//		list.add(bean2);
//		list.add(bean3);
//		list.add(bean4);
//		list.add(bean5);
		
		}
		return bean;
	}
}
