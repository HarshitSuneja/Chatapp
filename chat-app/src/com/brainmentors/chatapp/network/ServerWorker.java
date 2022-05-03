package com.brainmentors.chatapp.network;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

import com.brainmentors.chatapp.utilis.UserInfo;

public class ServerWorker extends Thread {
	private Socket clientSocket;
	private InputStream in;
	private OutputStream out;
	private server serve;
	ServerWorker(Socket clientSocket,server serve) throws IOException
	{
		this.serve=serve;
		this.clientSocket=clientSocket;
		in=clientSocket.getInputStream();
		out=clientSocket.getOutputStream();
		System.out.println("New Client Comes");
	}
	@Override
	public void run()
	{
		//Read Data from the client and broadcast the data to all
		BufferedReader br=new BufferedReader(new InputStreamReader(in));
		String line;
		try {
		while(true)
		{
		    line=br.readLine();
		    System.out.println("Line read " + line);
		    if(line.equalsIgnoreCase("quit"))
		    {
			   break;
		    }
		    //out.write(line.getBytes());//client send
		    //broadcast to all client
	        for(ServerWorker serverworker:serve.workers)
	        {
	        	line=line+"\n";
		        serverworker.out.write(line.getBytes());
	        }
		}
		}
        catch(IOException e)
		{
        	e.printStackTrace();
		}
		finally
		{
			try {
			if(br!=null)
			{
				br.close();
			}
			if(in!=null)
			{
			  in.close();	
		    }
			if(out!=null)
			{
				out.close();
			} 
			if(clientSocket!=null)
			{
				clientSocket.close();
			}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
     }
}

