package com.shaulabalqis.memberList;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class memberListLogInServlet
 */
@WebServlet("/memberListLogInServlet")
public class memberListLogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public memberListLogInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
    	request.getAttribute("username");
    	memberList user=new memberList();
    	String username = (String)request.getAttribute("username");
    	String command="select * from dataUser where `nama`='"+username+"'";
    	signUp session=new signUp();
    	try {
			String dataUser=session.connectDB (command, user.getDriver(), user.getUrl(), user.getUser(), user.getPass(),false);
			char[] dataUserPart=dataUser.toCharArray();
			String [] dataUserTemp=new String[6];String temp="";int k=0;
			for (int i=0; i<dataUserPart.length; i++){
				if (dataUserPart[i]==' '){
					System.out.println(temp);
					dataUserTemp[k]=temp;
					temp="";
					k++;
				}
				else
					temp=temp+dataUserPart[i];
			}
			user.setNama(dataUserTemp[0]);
			user.setPassword(dataUserTemp[1]);
			user.setAlamat(dataUserTemp[2]);
			user.setTanggalLahir(dataUserTemp[3]);
			user.setTelepon(dataUserTemp[4]);
			user.setEmail(dataUserTemp[5]);
			request.setAttribute("user", user);
			//getServletContext().getRequestDispatcher("/loginPage.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: "+e.getMessage());
		}
    	//request.setAttribute("user", user);
    	getServletContext().getRequestDispatcher("/loginPage.jsp").forward(request,response);	
    	
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
    
    }	
    

}
