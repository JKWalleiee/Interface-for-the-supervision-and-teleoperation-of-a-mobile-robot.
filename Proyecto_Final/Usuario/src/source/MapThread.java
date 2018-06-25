package source;

import static source.Principal.CenterLabel;
import static source.Principal.frame;

import	java.util.Vector;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class MapThread implements Runnable{
	
	Thread MapThread;
	static{ System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }
	//static ImageViewer imageViewer = new ImageViewer();
	public void run(){
		
		Mat hola2 = GetMap.OriginalMap();
		//Mat hola2 = hola1;
		int pose_x=0;
		int pose_y=0;
		int pose_x2=0;
		int pose_y2=0;
		
		while(true){
			
			if(!Principal.stop_button)
			{
				if(Principal.New_Position)
				{
					hola2 = GetMap.OriginalMap();
					Principal.New_Position=false;
					pose_x2=(int) Server_Map.pose_x_odometry;
					pose_y2=((int) Server_Map.pose_y_odometry)*(-1);
					
					pose_x=24+pose_x2;
					pose_y=13+pose_y2;
					
					Imgproc.circle(hola2,new Point(pose_x,pose_y),9, new Scalar(0,0,255), 4);
					System.out.println(pose_x);
					System.out.println(pose_y);
					Image loadedImage = GetMap.toBufferedImage(hola2);
					CenterLabel.setIcon(new ImageIcon(loadedImage));
					frame.pack();
				}
			}
		}
	}
	
	 public static void empezar(){
		 MapThread Graph2 = new MapThread();
   }
	 
	 public MapThread (){
         
		 MapThread = new Thread(this);
		 MapThread.start();
         
}
	
	


}
