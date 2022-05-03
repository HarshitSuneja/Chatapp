package com.brainmentors.chatapp.network;

import java.awt.TextArea;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JTextArea;

import com.brainmentors.chatapp.utilis.ConfigReader;

public class client {
	Socket socket;
	InputStream in;
	OutputStream out;
	JTextArea textArea; 
	ClientWorker clientworker;
    public client(JTextArea textArea) throws UnknownHostException, IOException
    {
    	int PORT=Integer.parseInt(ConfigReader.getValue("PORTNO"));
		socket=new Socket(ConfigReader.getValue("SERVER_IP"),PORT);
		out=socket.getOutputStream();
		in=socket.getInputStream();
		
		this.textArea=textArea;
		readMessages();
    }
	public void sendMessage(String message) throws IOException
	{
		message=message + "\n";
	    out.write(message.getBytes());
	}
	public void readMessages()
	{
		clientworker=new ClientWorker(in,textArea);
		
		clientworker.start();
	}
//	public static void main(String args[]) {
//		client cl = new client();
//	}
}
	
	
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*public client() throws UnknownHostException, IOException
	{
		int PORT=Integer.parseInt(ConfigReader.getValue("PORTNO"));
		socket=new Socket(ConfigReader.getValue("SERVER_IP"),PORT);
		System.out.println("Client comes......");
		System.out.println("Enter the Message Send To the server.......");
		Scanner sc=new Scanner(System.in);
		String message=sc.nextLine();
		OutputStream out=socket.getOutputStream();//write bytes on network
		out.write(message.getBytes());
		System.out.println("Message Send to server");
		sc.close();
		out.close();
		socket.close();
	}
	public static void main(String[]args) throws UnknownHostException, IOException
	{
		client cl =new client();
	}

}*/
 