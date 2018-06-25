import java.io.*;
import java.net.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;



import javax.imageio.ImageIO;

import java.awt.image.DataBufferByte;
public class Image_Server_Interfaces
{
	ServerSocket requestSocket;
    Socket connection=null;

	ObjectOutputStream out;
 	ObjectInputStream in;

 	String message;
	//String HostName;
    int contador=0;
	int PortName;
	byte[] hola = null;
	static byte sumar=2;
	static byte sumador=1;
	static int width=0;
	static int height=0;


	Image_Server_Interfaces(int portName)
	{
		//HostName = serverName;
		PortName = portName;
	}

	void run()
	{
		try{
			//1. creating a socket to connect to the server
			requestSocket = new ServerSocket(PortName, 10);

            connection = requestSocket.accept();
			System.out.println("Connection received from " + connection.getInetAddress().getHostName());
			//2. get Input and Output streams
			out = new ObjectOutputStream(connection.getOutputStream());
			out.flush();
			in = new ObjectInputStream(connection.getInputStream());

			//2.1 get input console stream
			//InputStreamReader inConsole = new InputStreamReader(System.in);
			//BufferedReader inConsoleLines = new BufferedReader(inConsole);


			//3: Communicating with the server
			do{
				try{

                    hola = cargar();
                    int valor = hola.length;
					//message = inConsoleLines.readLine();
					//message = "bye";
                            String salida = (String)in.readObject();
                            System.out.println(salida);
                            sendMessage2(valor);
                            salida = (String)in.readObject();
                            System.out.println(salida);
                            sendMessage2(height);
                            salida = (String)in.readObject();
                            System.out.println(salida);
                            sendMessage2(width);
                            salida = (String)in.readObject();
                            System.out.println(salida);
                            sendMessage(hola);
                            salida = (String)in.readObject();
                            System.out.println(salida);

					contador=contador+1;

				}

				catch(ClassNotFoundException classnot){
					System.err.println("Data received in unknown format");
				}
			}while(contador<=0);
		}
		catch(IOException ioException){
			//ioException.printStackTrace();
			System.err.println("You are trying 1");
		}
		finally{
			//4: Closing connection
			try{
				in.close();
				out.close();
				requestSocket.close();
			}
			catch(IOException ioException){
				ioException.printStackTrace();
			}
		}
	}

	byte[] cargar()
	{
	     byte[] pixels = null;
        try
        {


	    File file = new File("/home/p3dx/workspace/sicklogger/Debug/JhonKevin_SalasSector.PNG");
            System.out.println(file.exists() + "!!");
            FileInputStream fis = new FileInputStream(file);
             BufferedImage originalImage = ImageIO.read(fis);
             width          = originalImage.getWidth();
             height         = originalImage.getHeight();
          pixels = ((DataBufferByte)originalImage.getRaster().getDataBuffer()).getData();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    return pixels;
	}


    void sendMessage2(int msg)
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

	void sendMessage(byte[] msg)
	{
		try{
			out.writeObject(msg);
			//out.flush();
			out.reset();


		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
	}

	public static void main(String args[])
	{
		if (args.length < 1)
		{
			System.out.println("Uso: java Requester HOST PORT");
			return;
		}

		Image_Server_Interfaces client = new Image_Server_Interfaces(Integer.parseInt(args[0]));
		while(true)
        {
           client.run();
        }

	}
}
