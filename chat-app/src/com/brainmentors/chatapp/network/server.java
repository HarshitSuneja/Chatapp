package  com.brainmentors.chatapp.network;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.brainmentors.chatapp.utilis.ConfigReader;
import com.brainmentors.chatapp.utilis.UserInfo;

public class server 
{
	public ArrayList<ServerWorker>workers=new ArrayList<>();
	ServerSocket serverSocket;
	public server() throws IOException
	{
		int PORT=Integer.parseInt(ConfigReader.getValue("PORTNO"));
		serverSocket=new ServerSocket(PORT);
		System.out.println("Server starts and Waiting for the clients to connect");
		handleClientRequest();	
	}
	//Multiple Client Handshaking
	public void handleClientRequest() throws IOException 
	{
		while(true)
		{
			Socket clientSocket=serverSocket.accept();
			ServerWorker serverworker=new ServerWorker(clientSocket,this);
			workers.add(serverworker);
			serverworker.start();
		}
	}

	
	public static void main(String[]args) throws IOException
	{
		server serve=new server();
	}
}















/*{
	ServerSocket serverSocket;
	public server() throws IOException
	{
		int PORT=Integer.parseInt(ConfigReader.getValue("PORTNO"));
		serverSocket=new ServerSocket(PORT);
		System.out.println("Serve Started and Waiting for Client.......");
		Socket socket=serverSocket.accept();//THIS PROCESS IS CALLED HANDSHAKING OF CLIENT AND SERVER
		System.out.println("Client joins the Server....");
		InputStream in=socket.getInputStream();//read all bytes from network
		byte arr[]=in.readAllBytes();
		String str=new String(arr);
		System.out.println("Message Rec from the Client"+str );
		in.close();
		serverSocket.close();
	}
	public static void main(String[]args) throws IOException
	{
		server serve =new server();
	} 
   	

}*/
