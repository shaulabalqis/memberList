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
 * Servlet implementation class memberListViewMemberServlet
 */
@WebServlet("/memberListViewMemberServlet")
public class memberListViewMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public memberListViewMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s=request.getSession();
		memberList user=(memberList) s.getAttribute("user");
		//System.out.println(user.getNama());
		try {
			String memberPerUser=user.getMemberPerUser(user.getNama());
			int k=0; 
			char [] memberPerUserPart=memberPerUser.toCharArray();
			for (int i=0; i<memberPerUserPart.length; i++){//hitung jumlah member
				if (memberPerUserPart[i]=='\n')
					k++;
			}
			String temp="";int m=0;
			String [] member=new String [k];
			//System.out.println(k);
			String[][] memberDetail = new String [k][6];
			for (int i=0; i<memberPerUserPart.length; i++){
				if (memberPerUserPart[i]=='\n'){
					//System.out.println(temp);
					member[m]=temp;
					temp="";
					m++;
				}
				else
					temp=temp+memberPerUserPart[i];
			}
			memberList2[] memberTotal = new memberList2[k];
			char[] memberPart;
			for (int i=0; i<k; i++){
				temp="";
				memberPart=member[i].toCharArray();
				int n=0;
				for (int j=0; j<memberPart.length; j++){
					if (memberPart[j]=='|'){
						memberDetail[i][n]=temp;
						temp="";
						n++;
					}
					else
						temp=temp+memberPart[j];
				}
				memberTotal[i].setNama(memberDetail[i][0]);
				//System.out.println(memberTotal[i].getNama());
				memberTotal[i].setidUser(memberDetail[i][1]);
				memberTotal[i].setAlamat(memberDetail[i][2]);
				memberTotal[i].setTanggalLahir(memberDetail[i][3]);
				memberTotal[i].setTelepon(memberDetail[i][4]);
				memberTotal[i].setEmail(memberDetail[i][5]);
			}
			request.setAttribute("memberTotal", memberTotal);
			request.setAttribute("jumlahMember",k);
			getServletContext().getRequestDispatcher("/viewMember.jsp").forward(request, response);
		} 
		catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: "+e.getMessage());
    	} 
		catch (SQLException e) {
			System.out.println("SQLException: "+e.getMessage());
			System.out.println("SQLState: "+e.getSQLState());
			System.out.println("VendorError: "+e.getErrorCode());
		}
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
