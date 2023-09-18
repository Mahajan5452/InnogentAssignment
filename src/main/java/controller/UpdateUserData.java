package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.Employee;
import service.EmplyoeeService;


/**
 * Servlet implementation class UpdateUserData
 */
@WebServlet("/UpdateUserData")
public class UpdateUserData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmplyoeeService service = new EmplyoeeService();
	RequestDispatcher requestDispatcher;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String fname=request.getParameter("firstName");
	    String lname=request.getParameter("lastName");
	    String userName= request.getParameter("userName");
		String password=request.getParameter("password");
		boolean isadmin=Boolean.parseBoolean(request.getParameter("isAdmin"));
		double salary=Double.parseDouble(request.getParameter("salary"));
		Employee tempEmployee= new Employee(id,fname,lname,userName,password,isadmin,salary);
		System.out.println("hiii user data update");
		  service.updateUserEmployee(tempEmployee);
			/*
			 * requestDispatcher=request.getRequestDispatcher("home.jsp");
			 *
			 * requestDispatcher.include(request, response);
			 */
		  response.sendRedirect("home.jsp");
	}

}
