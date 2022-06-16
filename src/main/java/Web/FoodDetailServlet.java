<<<<<<< HEAD:src/main/java/Web/FoodDetailServlet.java
package Web;

import java.io.IOException;

=======
package controller;

import java.io.IOException;
>>>>>>> 06c4df1bc68c8f08be8574d8913b9d29f607462f:src/main/java/controller/FoodDetailServlet.java
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

<<<<<<< HEAD:src/main/java/Web/FoodDetailServlet.java
}
=======
}
>>>>>>> 06c4df1bc68c8f08be8574d8913b9d29f607462f:src/main/java/controller/FoodDetailServlet.java
