package com.shaulabalqis.memberList;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class memberListDeleteServlet
 */
@WebServlet("/memberListDeleteServlet")
public class memberListDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public memberListDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s=request.getSession();
		memberList user=(memberList) s.getAttribute("user");
    	 String command="delete from dataUser where `nama`='"+user.getNama()+"'";
    	signUp session=new signUp();
    	try {
			@SuppressWarnings("unused")
			String dataUser=session.connectDB (command, user.getDriver(), user.getUrl(), user.getUser(), user.getPass(),true);
			getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
    	} 
    	catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
    		System.out.println("ClassNotFoundException: "+e.getMessage());
		}
	}

}
