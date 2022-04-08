package com.brainmentors.chatapp.network;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.brainmentors.chatapp.utilis.ConfigReader;

public class client {
	Socket socket;
	public client() throws UnknownHostException, IOException
	{
		int PORT=Integer.parseInt(ConfigReader.getValue("PORTNO"));
		socket=new Socket(ConfigReader.getValue("SERVER_IP"),PORT);
		System.out.println("Client comes......");
	}
	public static void main(String[]args) throws UnknownHostException, IOException
	{
		client cl =new client();
	}

}
 