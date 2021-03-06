package com.brainmentors.chatapp.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.brainmentors.chatapp.dao.UserDAO1;
import com.brainmentors.chatapp.dto.UserDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class changePassword extends JFrame {

	private JPanel contentPane;
	private JTextField userId;
	private JPasswordField NewPassword;
	private JPasswordField ConfirmPassword;

	/**
	 * Launch the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws NoSuchAlgorithmException 
	 */
	
	
    public void updatePassword(String user,char []NP,char []CP) throws NoSuchAlgorithmException, ClassNotFoundException, SQLException
    {
    	try {
    	if((new String(NP)).equals(new String(CP)))
    	{
    		int ans=UserDAO1.ChangePasswordUser(user,CP);
    		if(ans==1)
    		{
    			JOptionPane.showMessageDialog(this, "Password update successfully");
    		}
    		else
    		{
    			JOptionPane.showMessageDialog(this, "Password update Failed");
    		}
    	}
    	else
    	{
    		System.out.println(new String(NP)+new String(CP));
    		JOptionPane.showMessageDialog(this, "Renter the password");
    	}
    	}
    	catch(NoSuchAlgorithmException e)
    	{
    		System.out.println("ISSUE");
    	}
    	catch(SQLException e)
    	{
    		System.out.println("DBMS ISSUE"+e);
    	}
    	catch(ClassNotFoundException e)
    	{
    		System.out.println("CLASS ISSUE");
    	}
    }
	/**
	 * Create the frame.
	 */
	public changePassword() {
		setTitle("Change Password");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New Password");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setBounds(75, 87, 102, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Confirm Password");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(75, 147, 119, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("User ID");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(79, 29, 90, 29);
		contentPane.add(lblNewLabel_2);
		
		userId = new JTextField();
		userId.setBounds(219, 29, 141, 25);
		contentPane.add(userId);
		userId.setColumns(10);
		
		NewPassword = new JPasswordField();
		NewPassword.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		NewPassword.setBounds(219, 88, 141, 29);
		contentPane.add(NewPassword);
		
		ConfirmPassword = new JPasswordField();
		ConfirmPassword.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		ConfirmPassword.setBounds(226, 151, 141, 29);
		contentPane.add(ConfirmPassword);
		
		JButton confirm = new JButton("Confirm");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String user=userId.getText();
				char []NP=NewPassword.getPassword();
				char []CP=ConfirmPassword.getPassword();
				updatePassword(user,NP,CP);
				}
				catch(Exception ex)
				{
					System.out.println("Exception");
				}
			}
		});
		confirm.setFont(new Font("Times New Roman", Font.BOLD, 14));
		confirm.setBounds(164, 209, 96, 29);
		contentPane.add(confirm);
	}
}
