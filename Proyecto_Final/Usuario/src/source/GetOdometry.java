package source;

import	java.util.Vector;

import javax.swing.JOptionPane;

public class GetOdometry implements Runnable{
	
	Thread GetOdometry;
	
	public void run(){
		
		while(true)
		{
			if(!Principal.stop_button)
			{
				JOptionPane.showMessageDialog(null, "LOADING POSITION");
				Server_Map.empezar();
			}
		}
	}
	
	 public static void empezar(){
		 GetOdometry Graph2 = new GetOdometry();
   }
	 
	 public GetOdometry (){
         
		 GetOdometry = new Thread(this);
		 GetOdometry.start();
         
}
	
	


}
