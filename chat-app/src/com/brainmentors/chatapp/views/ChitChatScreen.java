package com.brainmentors.chatapp.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.brainmentors.chatapp.network.client;
import com.brainmentors.chatapp.utilis.UserInfo;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

public class ChitChatScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea ;
	private client client ;
	
	public static void main(String[] args) {
		
					try {
						ChitChatScreen frame = new ChitChatScreen();
						frame.setVisible(true);
					} catch (UnknownHostException e) {
						
						e.printStackTrace();
					} catch (IOException e) {
						
						e.printStackTrace();
					}
					
	}
	private void sendIt() {
			String message = textField.getText();
			message=UserInfo.USER_NAME+"-"+message;
			try {
				client.sendMessage(message);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
	}
	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public ChitChatScreen() throws UnknownHostException, IOException {
		textArea = new JTextArea();
		client = new client(textArea);
		setTitle("Chit Chat");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 799, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 6, 768, 313);
		contentPane.add(scrollPane);
		
		
		textArea.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		textArea.setBounds(10, 24, 713, 280);
		scrollPane.setViewportView(textArea);
		
		textField = new JTextField();
		textField.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		textField.setBounds(10, 339, 612, 39);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton sendMsg = new JButton("Send Message");
		sendMsg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendIt();
			}
		});
		sendMsg.setBounds(627, 339, 132, 39);
		contentPane.add(sendMsg);
		setVisible(true);
	}
	
}