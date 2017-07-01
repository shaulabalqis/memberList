package com.shaulabalqis.memberList;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class memberListEdit
 */
@WebServlet("/memberListEditServlet")
public class memberListEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public memberListEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s=request.getSession();
		memberList user=(memberList) s.getAttribute("user");
		System.out.println("masuk get, username :"+user.getNama());
		request.setAttribute("user", user);
		getServletContext().getRequestDispatcher("/editUser.jsp").forward(request, response);
		
	    // TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s=request.getSession();
		memberList user=(memberList) s.getAttribute("user");
		String namaDariForm = request.getParameter("nama");
    	String passwordDariForm = request.getParameter("password");
    	String alamatDariForm=request.getParameter("alamat");
    	String tanggalLahirDariForm=request.getParameter("tanggalLahir");
    	String teleponDariForm=request.getParameter("telepon");
    	String emailDariForm=request.getParameter("email");
    	try {
			@SuppressWarnings("unused")
			String dataUser=user.updateUser(namaDariForm, passwordDariForm, alamatDariForm, tanggalLahirDariForm, teleponDariForm, emailDariForm, user.getNama());
			user.setNama(namaDariForm);
	    	user.setPassword(passwordDariForm);
	    	user.setAlamat(alamatDariForm);
	    	user.setTanggalLahir(tanggalLahirDariForm);
	    	user.setTelepon(teleponDariForm);
	    	user.setEmail(emailDariForm);
			String a="false";
			request.setAttribute("user", user);
			request.setAttribute("newlyLogIn", a);
	    	getServletContext().getRequestDispatcher("/login").forward(request, response);
    	} 
    	catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
    		System.out.println("ClassNotFoundException: "+e.getMessage());
		}
    	// TODO Auto-generated method stub
    	catch (SQLException e) {
			// TODO Auto-generated catch block
    		System.out.println("SQLException: "+e.getMessage());
			System.out.println("SQLState: "+e.getSQLState());
			System.out.println("VendorError: "+e.getErrorCode());
		}
	}

}
