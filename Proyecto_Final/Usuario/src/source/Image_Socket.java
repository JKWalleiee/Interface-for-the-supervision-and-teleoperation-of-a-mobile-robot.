package source;



import java.io.*;
import java.net.*;

import javax.swing.JOptionPane;

public class Image_Socket
{
	Socket providerSocket;
	//Socket connection=null;

	ObjectOutputStream out;
	ObjectInputStream in;

	static byte[] message = null;
	static int height=0;
	static int width=0;
	//String message2;
	String HostName;
	int PortName;
	int dimension;
    int contador=0;
    int flagFirstTime = 1;
    Image_Socket(String serverName, int portName)
	{
    	HostName = serverName;
		PortName = portName;
	}

	void run()
	{

		try{
			//1. creating a server socket
			providerSocket = new Socket(HostName, PortName);

			//2. Wait for connection
			//connection = providerSocket.accept();
			//System.out.println("Connection received from " + connection.getInetAddress().getHostName());

			//3. get Input and Output streams
			out = new ObjectOutputStream(providerSocket.getOutputStream());
			out.flush();
			in = new ObjectInputStream(providerSocket.getInputStream());

			//4. The two parts communicate via the input and output streams
			do{
                    contador=contador+1;
				try{
					if (flagFirstTime == 1)
					{
						//message = (String)in.readObject();
						System.out.println("server>");
						//sendMessage("Hi my server");
						flagFirstTime = 0;
					}

					sendMessage("peticion");
					dimension = (int)in.readObject();
					message = new byte[dimension];
					sendMessage("listo");
					height = (int)in.readObject();
					sendMessage("listo");
					width = (int)in.readObject();
					sendMessage("listo");
					message = (byte[])in.readObject();
					//message = GetBytes(message2);
					System.out.println("client>" + dimension);

				}
				catch(Exception e){
				    //System.err.println("You are trying 1");
					//e.printStackTrace();
				}
			}while(contador<=0);
		}
		catch (ConnectException e) {
			JOptionPane.showMessageDialog(null, "there isn't connection to the robot's map");
		    //e.printStackTrace();
		}
		catch(IOException ioException){
			//ioException.printStackTrace();
			//System.err.println("You are trying 1");
			//JOptionPane.showMessageDialog(null, "there isn't connection to the robot's map");
		}
		finally{
			//4: Closing connection
			try{
				in.close();
				out.close();
				providerSocket.close();
			}
			catch(IOException ioException){
				ioException.printStackTrace();
			}
		}
	}


	void sendMessage(String msg)
	{
		try{
			out.writeObject(msg);
			out.flush();
			out.reset();

		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
	}


	public static void empezar()
	{
		int PortName =9999;
		String Hostname = "192.168.2.100";
		//String Hostname = "localhost";
		Image_Socket server = new Image_Socket(Hostname,PortName);

			server.run();

	}

}
