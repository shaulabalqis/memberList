package com.shaulabalqis.memberList;

import java.sql.SQLException;

public class memberList2 {
	 private String nama="";
	 private String idUser="";
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
	 
	 public String getidUser() {
		 return idUser;
	 }
	 public void setidUser(String Password) {
		 this.idUser = Password;
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
		 String commandInputDB = "insert into dataMember values('"+getNama()+"','"+getidUser()+"','"+getAlamat()+"','"+getTanggalLahir()+"','"+getTelepon()+"','"+getEmail()+"')";
		 signUp session=new signUp();
		 session.connectDB (commandInputDB, getDriver(), getUrl(), getUser(), getPass(),true);
	 }
	 
	 public String getMemberInfo(String username)throws ClassNotFoundException, SQLException{
		 String commandGetUserInfo="select * from dataMember where `nama`='"+username+"'";
		 signUp session=new signUp();
		 String ans=session.connectDB(commandGetUserInfo, getDriver(), getUrl(), getUser(), getPass(), false);
		 return ans;
	 }
	 public String getMemberPerUser(String idUser)throws ClassNotFoundException, SQLException{
		 String commandGetUserInfo="select `nama` from dataMember where `idUser`='"+idUser+"'";
		 signUp session=new signUp();
		 String ans=session.connectDB(commandGetUserInfo, getDriver(), getUrl(), getUser(), getPass(), false);
		 return ans;
	 }
	 
}
