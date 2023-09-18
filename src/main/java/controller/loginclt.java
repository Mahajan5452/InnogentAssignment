package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entity.Employee;
import service.EmplyoeeService;

/**
 * Servlet implementation class loginclt
 */
@WebServlet("/loginclt")
public class loginclt extends HttpServlet {
	private static final long serialVersionUID = 1L;
     EmplyoeeService service = new EmplyoeeService();
     RequestDispatcher requestDispatcher;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginclt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect(request.getContextPath()+"/login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   String typeString= request.getParameter("submit");
	  // System.out.println(typeString);
	   String userName= request.getParameter("username");
		String password=request.getParameter("password");
		//System.out.println(userName+" "+password);
	  if(typeString.equals("login")) {
		Employee emp=service.login(userName,password);
		if(emp!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("emp", emp);

			session.setAttribute("list", service.getEmployeeList());
//			requestDispatcher=request.getRequestDispatcher("home.jsp");
//			requestDispatcher.forward(request, response);
			response.sendRedirect("home.jsp");

		}else {
			request.setAttribute("msg", "Invalid Credentials");
			requestDispatcher= request.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(request, response);
		}
	  }else {
		System.out.println("nO Functionalti yet");
	}

	}

}
