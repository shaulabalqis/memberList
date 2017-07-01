package com.shaulabalqis.memberList;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class memberListServlet
 */
@WebServlet("/memberListServlet")
public class memberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	* @see HttpServlet#HttpServlet()
	*/
    public memberListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
    * @throws ServletException 
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
    private String messageSignUp="";
    private memberList user;
	 public memberList getUser() {
		 return user;
	 }
	 
    //@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
    		
    }
	
	//@SuppressWarnings("unused")
		protected void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
			messageSignUp="";
			user=new memberList();
	    	//System.out.println("masuk post");
	    	request.setAttribute("user", user);
	    	request.setAttribute("messageSignUp", messageSignUp);
	    	//getServletContext().getRequestDispatcher("/home.jsp");
	    	String namaDariForm = request.getParameter("nama");
	    	String passwordDariForm = request.getParameter("password");
	    	String alamatDariForm=request.getParameter("alamat");
	    	String tanggalLahirDariForm=request.getParameter("tanggalLahir");
	    	String teleponDariForm=request.getParameter("telepon");
	    	String emailDariForm=request.getParameter("email");
	    	user.setNama(namaDariForm);
	    	user.setPassword(passwordDariForm);
	    	user.setAlamat(alamatDariForm);
	    	user.setTanggalLahir(tanggalLahirDariForm);
	    	user.setTelepon(teleponDariForm);
	    	user.setEmail(emailDariForm);
	    	try {
	    		if (user.checkSignUpDB(user.getNama())==true){
	    			user.inputDB();
	    			messageSignUp="Pendaftaran berhasil. Silahkan log in.";
	    		}
	    		else{
	    			messageSignUp="Pendaftaran gagal.";
	    		}
	    		System.out.println(messageSignUp);
	    		getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
	    	} 
	    	catch (ClassNotFoundException e) {
				System.out.println("ClassNotFoundException: "+e.getMessage());
			}
	    	catch (SQLException e) {
	    		System.out.println("SQLException: "+e.getMessage());
				System.out.println("SQLState: "+e.getSQLState());
				System.out.println("VendorError: "+e.getErrorCode());
			}
	    }
	
    protected void messageContent(boolean succeded){
    	
    }

}
