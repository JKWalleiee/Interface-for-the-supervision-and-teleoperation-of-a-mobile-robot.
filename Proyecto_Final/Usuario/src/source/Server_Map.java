package source;



import java.io.*;
import java.net.*;
//// ESTE ES EL DE RECIBIR COSAS DEL ROBOT VERSION FINAL
public class Server_Map
{
	static ServerSocket providerSocket;
	Socket connection=null;

	//ObjectOutputStream out;
	static BufferedReader in;
	static float pose_x_odometry=0;
	static float pose_y_odometry=0;
	String message;
	int PortName;
    int contador=0;
    Server_Map(int portName)
	{
		PortName = portName;
	}

	void run()
	{   float dos=0;
		float tres=0;
		try{
			//1. creating a server socket
			providerSocket = new ServerSocket(PortName, 10);

			//2. Wait for connection
			connection = providerSocket.accept();
			System.out.println("Connection received from " + connection.getInetAddress().getHostName());

			//3. get Input and Output streams
			//out = new ObjectOutputStream(connection.getOutputStream());
			//out.flush();
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            PrintWriter out = new PrintWriter(connection.getOutputStream(),true);
            out.println("pedido\n");
			//4. The two parts communicate via the input and output streams
			do{
                    contador=contador+1;

					message = (String)in.readLine();
					if(message != null)
                        {
						pose_x_odometry = Float.parseFloat(message);
					
                        }

                        message = (String)in.readLine();
					if(message != null)
                        {
						pose_y_odometry = Float.parseFloat(message);;
					
                        }
                    out.println("listo\n");
                   
                    pose_x_odometry=(float) (pose_x_odometry*46.0);
                    //System.out.println("x es>" + pose_x_odometry);
                    pose_y_odometry=(float) (pose_y_odometry*46.0);
                    //System.out.println("y es>" + pose_y_odometry);
                    Principal.New_Position=true;

			}while(message!=null);
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
		finally{
			//4: Closing connection
			try{
				in.close();
				//out.close();
				providerSocket.close();
			}
			catch(IOException ioException){
				ioException.printStackTrace();
			}
		}
	}

	public static void empezar()
	{
		int PortName =9090;
		Server_Map server = new Server_Map(PortName);
		while(true){
			server.run();
		}
	}

}
