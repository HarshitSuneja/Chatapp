package com.brainmentors.chatapp.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.brainmentors.chatapp.dao.UserDAO1;
import com.brainmentors.chatapp.dto.UserDTO;
import com.brainmentors.chatapp.utilis.UserInfo;

public class UserScreen extends JFrame {
	private JTextField userIdtxt;
	private JPasswordField PasswordField;

	
	public static void main(String[] args) {
		
		UserScreen window = new UserScreen();
					
		
		
	}
	UserDAO1 userDAO1=new UserDAO1();
	private JTextField EmailID;
	private JTextField City;
	private JTextField PhoneNo;
	private void doLogin()
	{
		String userid=userIdtxt.getText(); 
		char []password=((JPasswordField) PasswordField).getPassword();
	    //UserDAO1 userDAO1=new UserDAO1();
	    UserDTO userDTO=new UserDTO(userid,password);
	    String message="";
	    try {
	    if(userDAO1.isLogin(userDTO))
	    {
	    	message="Welcome"+" "+userid;
	    	UserInfo.USER_NAME=userid;
	    	JOptionPane.showMessageDialog(this, message);
	    	setVisible(false);
	    	dispose();
	    	DashBoard dashBoard=new DashBoard(message);
	    	dashBoard.setVisible(true);
	    }
	    else
	    {
	    	message="Invalid userid or password";
	    	JOptionPane.showMessageDialog(this, message);
	    }
	    
	    }
	    catch(ClassNotFoundException e) {
	    	e.printStackTrace();
	    }
	    catch(SQLException e)
	    {
	    	e.printStackTrace();
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	}
	private void register()
	{
		String userid=userIdtxt.getText(); 
		char []password=PasswordField.getPassword();
		String emailid=EmailID.getText();
		String city=City.getText();
		String Phoneno=PhoneNo.getText();
	    //UserDAO1 userDAO1=new UserDAO1();
	    UserDTO userDTO=new UserDTO(userid,password,emailid,city,Phoneno);
	    
	    try {
	    int result=userDAO1.add(userDTO);
	    		if(result>0)
	    		{
	    			JOptionPane.showMessageDialog(this,"Registered Successfully" );
	    		}
	    		else
	    		{
	    			JOptionPane.showMessageDialog(this,"Registration Failed" );
	    		}
	    }
	    catch(SQLException |ClassNotFoundException ex) {
	    	System.out.println("DB ISSUE......");
	    	 ex.printStackTrace();//this tells where is the exception
	    }
	    catch(Exception ex)
	    {
	    	System.out.println("Some Generic exception Raised...");
	    	ex.printStackTrace();
	    }
	}   
	/**
	 * Create the application.
	 */
	public UserScreen() {
		setResizable(false);
		setTitle("                                                                  LOGIN");
		setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblNewLabel.setBounds(246, 38, 132, 47);
		getContentPane().add(lblNewLabel);
		
		userIdtxt = new JTextField();
		userIdtxt.setBounds(192, 95, 242, 34);
		getContentPane().add(userIdtxt);
		userIdtxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("User ID");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14)); 
		lblNewLabel_1.setBounds(89, 97, 104, 26);
		getContentPane().add(lblNewLabel_1);
		
		PasswordField = new JPasswordField();
		PasswordField.setBounds(192, 149, 242, 32);
		getContentPane().add(PasswordField);
		PasswordField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(75, 147, 74, 32);
		getContentPane().add(lblNewLabel_2);
		
		JButton loginbt = new JButton("Log In");
		loginbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  doLogin();
			}
		});
		loginbt.setFont(new Font("Times New Roman", Font.BOLD, 14));
		loginbt.setBounds(192, 191, 96, 32);
		getContentPane().add(loginbt);
		
		JButton registerbt = new JButton("Register");
		registerbt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				register();
			}
		});
		registerbt.setFont(new Font("Times New Roman", Font.BOLD, 14));
		registerbt.setBounds(202, 372, 96, 32);
		getContentPane().add(registerbt);
		
		JLabel emailID = new JLabel("Email ID");
		emailID.setHorizontalAlignment(SwingConstants.CENTER);
		emailID.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		emailID.setBounds(75, 246, 74, 26);
		getContentPane().add(emailID);
		
		EmailID = new JTextField();
		EmailID.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		EmailID.setBounds(192, 238, 242, 32);
		getContentPane().add(EmailID);
		EmailID.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("City");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(75, 291, 74, 26);
		getContentPane().add(lblNewLabel_3);
		
		City = new JTextField();
		City.setBounds(192, 289, 242, 26);
		getContentPane().add(City);
		City.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Phone No.");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(75, 341, 74, 26);
		getContentPane().add(lblNewLabel_4);
		
		PhoneNo = new JTextField();
		PhoneNo.setBounds(192, 327, 242, 26);
		getContentPane().add(PhoneNo);
		PhoneNo.setColumns(10);
		
		JButton ChangePassword = new JButton("Change Password");
		ChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePassword frame = new changePassword();
				frame.setVisible(true);
			}
		});
		ChangePassword.setFont(new Font("Times New Roman", Font.BOLD, 14));
		ChangePassword.setBounds(312, 192, 162, 30);
		getContentPane().add(ChangePassword);
		
		JButton reset = new JButton("Reset");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userIdtxt.setText("");
				PasswordField.setText("");
			}
		});
		reset.setFont(new Font("Times New Roman", Font.BOLD, 14));
		reset.setBounds(348, 372, 126, 30);
		getContentPane().add(reset);
		setSize(627, 453);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
}
