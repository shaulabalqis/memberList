package com.shaulabalqis.memberList;

import java.sql.SQLException;

public class memberList {
	 private String nama="";
	 private String password="";
	 private String alamat="";
	 private String tanggalLahir="";
	 private String telepon="";
	 private String email="";
	 private String dbName="memberList";
	 private String driver = "com.mysql.jdbc.Driver";
	 private String url = "jdbc:mysql://localhost:3306/"+dbName; // sesuaikan dengan nama database anda
	 private String user = "root"; //user mysql 
     private String pass = "";
     
	 public String getNama() {
		 return nama;
	 }
	 public void setNama(String nama) {
		 this.nama = nama;
	 }
	 
	 public String getPassword() {
		 return password;
	 }
	 public void setPassword(String Password) {
		 this.password = Password;
	 }
	 
	 public String getAlamat() {
		 return alamat;
	 }
	 public void setAlamat(String alamat) {
		 this.alamat = alamat;
	 }
	 
	 public String getTanggalLahir() {
		 return tanggalLahir;
	 }
	 public void setTanggalLahir(String tanggalLahir) {
		 this.tanggalLahir = tanggalLahir;
	 }
	 
	 public String getTelepon() {
		 return telepon;
	 }
	 public void setTelepon(String telepon) {
		 this.telepon = telepon;
	 }
	 
	 public String getEmail() {
		  return email;
	 }
	 public void setEmail(String email) {
		  this.email = email;
	 }
	 
	 public String getDriver() {
		 return driver;
	 }
	 public String getUrl() {
		 return url;
	 }
	 public String getUser() {
		 return user;
	 }
	 public String getPass() {
		 return pass;
	 }
	 
	 
	 public void inputDB() throws ClassNotFoundException{
		 String commandInputDB = "insert into dataUser values('"+getNama()+"','"+getPassword()+"','"+getAlamat()+"','"+getTanggalLahir()+"','"+getTelepon()+"','"+getEmail()+"')";
		 signUp session=new signUp();
		 session.connectDB (commandInputDB, getDriver(), getUrl(), getUser(), getPass(),true);
	 }
	 public boolean checkSignUpDB(String nama)throws ClassNotFoundException, SQLException{
		 String commandCheckSignUpDB="select `nama` from dataUser where `nama`='"+nama+"'";
		 signUp session=new signUp();
		 boolean notExist=session.connectDB (commandCheckSignUpDB, getDriver(), getUrl(), getUser(), getPass(), false).isEmpty();
		 //System.out.println(exist);
		 return notExist;
		 
	 }
	 public boolean checkLogInDB(String nama, String password)throws ClassNotFoundException, SQLException{
		 String commandCheckLogInDB="select `nama` from dataUser where `nama`='"+nama+"' and `password`='"+password+"'";
		 signUp session=new signUp();
		 boolean notExist=session.connectDB (commandCheckLogInDB, getDriver(), getUrl(), getUser(), getPass(),false).isEmpty();
	     return notExist;
	 }
	 

}
