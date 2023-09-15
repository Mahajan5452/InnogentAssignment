package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entity.Employee;
import service.EmplyoeeService;
import service.intiserv;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id= Integer.parseInt(request.getParameter("id"));
	Employee employee=	service.editEmployee(id);
	request.setAttribute("emp", employee);
	requestDispatcher=request.getRequestDispatcher("adminuserEdit.jsp");
	requestDispatcher.include(request, response);
		
	   
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String fname=request.getParameter("firstName");
	    String lname=request.getParameter("lastName");
	    String userName= request.getParameter("userName");
		String password=request.getParameter("password");
		boolean isadmin=Boolean.parseBoolean(request.getParameter("isAdmin"));
		double salary=Double.parseDouble(request.getParameter("salary"));
		
		Employee tempEmployee= new Employee(id,fname,lname,userName,password,isadmin,salary);
		System.out.println(tempEmployee);
		  service.updateUserEmployee(tempEmployee);
		  requestDispatcher=request.getRequestDispatcher("home.jsp");
			
			requestDispatcher.include(request, response);
		
	}

}
