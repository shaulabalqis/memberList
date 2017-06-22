package com.shaulabalqis.memberList;

/*import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Scanner;*/
import java.sql.ResultSet;
import java.sql.Statement;
//import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class signUp {
	/*memberList user=new memberList();
	String nama, alamat, tanggalLahir, nomorTelepon, email;
	void inputData(String nama, String alamat,String tanggalLahir,String nomorTelepon,String email){
		user.setNama(nama);
		user.setAlamat(alamat);
		user.setTanggalLahir(tanggalLahir);
		user.setNomorTelepon(nomorTelepon);
		user.setEmail(email);
	}*/
	String connectDB(String commandInputDB,String driver, String url, String user, String pass, boolean update)throws ClassNotFoundException{
		Connection conn;
		ResultSet rs=null;
		String ans="";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pass);
			Statement stmt=conn.createStatement();
			if (update==true){
				int x=stmt.executeUpdate(commandInputDB);
				ans=Integer.toString(x);
				System.out.println("masuk update");
			}
			else{
				rs=stmt.executeQuery(commandInputDB);
				while (rs.next()){
					ans=ans+rs.getString("nama")+" ";
				}
				
				System.out.println("masuk Query");
			}
			conn.close();
		} 
		catch (SQLException e) {
			System.out.println("SQLException: "+e.getMessage());
			System.out.println("SQLState: "+e.getSQLState());
			System.out.println("VendorError: "+e.getErrorCode());
		}
		System.out.println(ans);
		return ans;
		//bikin connection
		//open connection
	}
}
