package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.EmplyoeeService;

/**
 * Servlet implementation class DeleteClt
 */
@WebServlet("/DeleteClt")
public class DeleteClt extends HttpServlet {
	private static final long serialVersionUID = 1L;
     EmplyoeeService service =  new  EmplyoeeService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteClt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id= Integer.parseInt(request.getParameter("id"));
		service.delete(id);
		response.sendRedirect(request.getContextPath()+"/home.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
