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
    private String messageLogIn="";
    private String messageSignUp="";
    public String getMessageLogIn() {
		 return messageLogIn;
	 }
	 public String getMessageSignUp() {
		 return messageSignUp;
	 }
	 private memberList user;
	 public memberList getUser() {
		 return user;
	 }
    //@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
    	user=new memberList();
    	//getServletContext().getRequestDispatcher("/home.jsp");//.forward(request, response);
    	String namaDariForm = request.getParameter("nama");
    	String passwordDariForm = request.getParameter("password");
    	//String messageLogIn="";
    	try {
			if (user.checkLogInDB(namaDariForm, passwordDariForm)==false){
				messageLogIn="Login berhasil";
				request.setAttribute("username", user.getNama());
		    	getServletContext().getRequestDispatcher("/loginPage.jsp").forward(request, response);
				//response.sendRedirect("/loginPage.jsp");
				//do login page view here
				}
			else{
				messageLogIn="Login gagal";
				request.setAttribute("user", user);
				getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
				//do error login handling here
			}
			System.out.println(messageLogIn);
		} 
    	catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: "+e.getMessage());
		}
    	catch (SQLException e) {
    		System.out.println("SQLException: "+e.getMessage());
			System.out.println("SQLState: "+e.getSQLState());
			System.out.println("VendorError: "+e.getErrorCode());
		}
    		
    	//user.setNama(namaDariForm);
    	//user.setPassword(passwordDariForm);
    	//request.setAttribute("user", user);
    	//getServletContext().getRequestDispatcher("/home.jsp").forward(request,response);
    }
    //@SuppressWarnings("unused")
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
    	user=new memberList();
    	request.setAttribute("user", user);
    	getServletContext().getRequestDispatcher("/home.jsp").forward(request,response);
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
    	//String messageSignUp="";
    	try {
    		System.out.println(user.getNama());
    		if (user.checkSignUpDB(user.getNama())==true){
    			user.inputDB();
    			messageSignUp="Pendaftaran berhasil";
    		}
    		else
    			messageSignUp="Pendaftaran gagal";
    		
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
