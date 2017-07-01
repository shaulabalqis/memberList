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
		 String commandCheckSignUpDB="select * from dataUser where `nama`='"+nama+"'";
		 signUp session=new signUp();
		 boolean notExist=session.connectDB (commandCheckSignUpDB, getDriver(), getUrl(), getUser(), getPass(), false).isEmpty();
		 //System.out.println(exist);
		 return notExist;
		 
	 }
	 public String getUserInfo(String username)throws ClassNotFoundException, SQLException{
		 String commandGetUserInfo="select * from dataUser where `nama`='"+username+"'";
		 signUp session=new signUp();
		 String ans=session.connectDB(commandGetUserInfo, getDriver(), getUrl(), getUser(), getPass(), false);
		 return ans;
	 }
	 public String getMemberPerUser(String idUser)throws ClassNotFoundException, SQLException{
		 String commandGetUserInfo="select * from dataMember where `idUser`='"+idUser+"'";
		 signUp2 session=new signUp2();
		 String ans=session.connectDB(commandGetUserInfo, getDriver(), getUrl(), getUser(), getPass(), false);
		 return ans;
	 }
	 public String updateUser(String nama, String password, String alamat, String tanggalLahir, String telepon, String email, String username) throws ClassNotFoundException, SQLException{
		 String commandUpdateUser="UPDATE `datauser` SET `nama`='"+nama+"',`password`='"+password+"',`alamat`='"+alamat+"',`tanggal lahir`='"+tanggalLahir+"',`nomor telepon`='"+telepon+"',`email`='"+email+"' where `nama`='"+username+"'";
		 signUp session=new signUp();
		 String ans=session.connectDB(commandUpdateUser, getDriver(), getUrl(), getUser(), getPass(), true);
		 return ans;
	 }
	 public boolean checkLogInDB(String nama, String password)throws ClassNotFoundException, SQLException{
		 String commandCheckLogInDB="select * from dataUser where `nama`='"+nama+"' and `password`='"+password+"'";
		 signUp session=new signUp();
		 boolean notExist=session.connectDB (commandCheckLogInDB, getDriver(), getUrl(), getUser(), getPass(),false).isEmpty();
	     return notExist;
	 }
	 

}
