package com.brainmentors.chatapp.dao;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.brainmentors.chatapp.dto.UserDTO;
import com.brainmentors.chatapp.utilis.Encryption;

//User CRUD operation
public class UserDAO1 {
	public boolean isLogin(UserDTO userDTO) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		final String SQL="select userid from users where userid=? and password=?";
        try {
        	con=UserDAO.createConnection();
        	pstmt=con.prepareStatement(SQL);
            pstmt.setString(1,userDTO.getUserid());
        	String encryptedPwd=Encryption.passwordEncrypt(new String(userDTO.getPassword()));
            pstmt.setString(2,encryptedPwd);
            rs=pstmt.executeQuery();
            return rs.next();
        	
        }
        finally
        {
        	if(pstmt!=null)
        	{
        		pstmt.close();
        	}
        	if(rs!=null)
        	{
        		rs.close();
        	}
        	if(con!=null)
        	{
        		con.close();
        	}
        }
	}
	

	public int add(UserDTO userDTO) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException
	{
		Connection connection=null;
		Statement stmt=null;
		try {//guarded region
		connection=UserDAO.createConnection();//step-1 Connection create
	    //step-2 we do a query
		stmt=connection.createStatement();
		//insert into users(userid,password) values('ram',ram123');
		int record=stmt.executeUpdate("insert into users(userid,password,emailid,city,Phoneno) values('"+userDTO.getUserid()+"','"+Encryption.passwordEncrypt(new String (userDTO.getPassword()))+"','"+userDTO.getEmailid()+"','"+userDTO.getCity()+"','"+userDTO.getPhoneNo()+"')");
		return record;
		}
		finally {//always execute whether there is exception or not (Resource cleaning code is put in this finally block)
			if(stmt!=null)
			{
				stmt.close();
			}
			if(connection!=null)
			{
		       connection.close();
			}
		}
	}
	public static int ChangePasswordUser(String user,char[] CP) throws SQLException, NoSuchAlgorithmException, ClassNotFoundException
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		int rs=0;
		final String SQL="update users set password=? where userid=?";
		try {
			con=UserDAO.createConnection();
			pstmt=con.prepareStatement(SQL);
        	String encryptedPwd=Encryption.passwordEncrypt(new String(CP));
            pstmt.setString(1,encryptedPwd);
            pstmt.setString(2,user);
            rs=pstmt.executeUpdate();
            return rs;
			}
		finally
		{
			if(pstmt!=null)
			{
				pstmt.close();
			}
			if(con!=null)
			{
				con.close();
			}
		}
		
	}


	
}
