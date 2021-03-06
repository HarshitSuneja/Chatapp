package com.brainmentors.chatapp.dto;

public class UserDTO {

	private String userid;
	private char[] password; 
	private String emailid;
	private String city;
	private String Phoneno;
	public UserDTO(String userid,char []password)
	{
		this.userid=userid;
		this.password=password;
	}
	public UserDTO(String userid,char []password,String emailid,String city,String Phoneno)
	{
		this.userid=userid;
		this.password=password;
		this.emailid=emailid;
		this.city=city;
		this.Phoneno=Phoneno;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public char[] getPassword() {
		return password;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPhoneNo() {
		return Phoneno;
	}
	public void setPhoneNo(String Phoneno) {
		Phoneno = Phoneno;
	}
	public void setPassword(char[] password) {
		this.password = password;
	}
	
}
 