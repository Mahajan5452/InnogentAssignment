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
 * Servlet implementation class UpdateData
 */
@WebServlet("/UpdateData")
public class UpdateData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmplyoeeService service = new EmplyoeeService();
	RequestDispatcher requestDispatcher;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id= Integer.parseInt(request.getParameter("id"));
	Employee employee=	service.editEmployee(id);
	request.setAttribute("emp", employee);
	/*
	 * requestDispatcher=request.getRequestDispatcher("adminuserEdit.jsp");
	 * requestDispatcher.include(request, response);
	 */
    response.sendRedirect("adminuserEdit.jsp");
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
		boolean isadmin=true;
		double salary=Double.parseDouble(request.getParameter("salary"));
		System.out.println("hi this is admin update");
		System.out.println(isadmin);
		Employee tempEmployee= new Employee(id,fname,lname,userName,password,isadmin,salary);

		  service.updateUserEmployee(tempEmployee);
			/*
			 * requestDispatcher=request.getRequestDispatcher("home.jsp");
			 *
			 * requestDispatcher.include(request, response);
			 */
       response.sendRedirect("home.jsp");
	}

}
