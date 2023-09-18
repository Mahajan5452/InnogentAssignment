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
 * Servlet implementation class addData
 */
@WebServlet("/addData")
public class addData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmplyoeeService service = new EmplyoeeService();
	private static int lastAssignedId = 2;
	RequestDispatcher requestDispatcher;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addData() {
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

	    String fname=request.getParameter("firstName");
	    String lname=request.getParameter("lastName");
	    String userName= request.getParameter("username");
		String password=request.getParameter("password");
		String isadmin=request.getParameter("isAdmin");
		String salary=request.getParameter("salary");


		//int id = Integer.parseInt(request.getParameter("id"));
		//System.out.println(id);
		 lastAssignedId++;
		Employee tempEmployee= new Employee( lastAssignedId,fname,lname,userName,password,Boolean.parseBoolean(isadmin),Double.parseDouble(salary));
		  service.addData(tempEmployee);

		response.sendRedirect(request.getContextPath()+"/home.jsp");

	}

}
