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
 * Servlet implementation class memberListLogInServlet
 */
@WebServlet("/memberListLogInServlet")
public class memberListLogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private String messageLogIn="";
    private memberList user;
	 public memberList getUser() {
		 return user;
	 }
    public memberListLogInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
    		
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
    	HttpSession s=request.getSession();
		String newlyLogIn=(String) s.getAttribute("newlyLogIn");
    	if (newlyLogIn.equals("false")){
    		memberList user=(memberList) request.getAttribute("user");
    		request.setAttribute("user", user);
    		getServletContext().getRequestDispatcher("/loginPage.jsp").forward(request, response);
		}
    	else{
    		user=new memberList();
    		request.setAttribute("messageLogIn", messageLogIn);
    		String namaDariForm = request.getParameter("nama");
    		String passwordDariForm = request.getParameter("password");
    		try {
    			if (user.checkLogInDB(namaDariForm, passwordDariForm)==false){
    				messageLogIn="Login berhasil";
    				user.setNama(namaDariForm);
    				user.setPassword(passwordDariForm);
    				request.setAttribute("username", user.getNama());
    				String username = (String) request.getAttribute("username");
    				String dataUser=user.getUserInfo(username);
    				char[] dataUserPart=dataUser.toCharArray();
    				String [] dataUserTemp=new String[6];String temp="";int k=0;
    				for (int i=0; i<dataUserPart.length; i++){
    					if (dataUserPart[i]=='|'){
    						System.out.println(temp);
    						dataUserTemp[k]=temp;
    						temp="";
    						k++;
    					}
    					else
    						temp=temp+dataUserPart[i];
    				}
    				dataUserTemp[k]=temp;
    				user.setNama(dataUserTemp[0]);
    				user.setPassword(dataUserTemp[1]);
    				user.setAlamat(dataUserTemp[2]);
    				user.setTanggalLahir(dataUserTemp[3]);
    				user.setTelepon("0"+dataUserTemp[4]);
    				user.setEmail(dataUserTemp[5]);
    				request.setAttribute("user", user);
    				getServletContext().getRequestDispatcher("/loginPage.jsp").forward(request, response);
				}
    			else{
    				messageLogIn="Login gagal";
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
    	}
    }
    

}
