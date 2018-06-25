package source;

//package org.javaopencvbook;
import static source.Principal.CenterLabel;
import static source.Principal.frame;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;

import javax.swing.ImageIcon;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class GetMap
{
	//static Mat newImage;
	static{ System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }
	public static Mat OriginalMap()
	{	
		if(!Principal.Load_Map)
		{
		Image_Socket.empezar();
		Principal.Load_Map=true;
		}
		byte[] bytes = Image_Socket.message;
		Mat newImage = new Mat(Image_Socket.height, Image_Socket.width, CvType.CV_8UC3);
		newImage.put(0, 0, bytes);
		if(newImage.dataAddr()==0){
		System.out.println("Couldn't open file ");
		} else{
		Size dsize= new Size(340,358);	
		Imgproc.resize(newImage, newImage, dsize);
		Image loadedImage = toBufferedImage(newImage);
		CenterLabel.setIcon(new ImageIcon(loadedImage));
		frame.pack();
		
		}
		return newImage;
	}
	public static Image toBufferedImage(Mat matrix){
		int type = BufferedImage.TYPE_BYTE_GRAY;
		if ( matrix.channels() > 1 ) {
		type = BufferedImage.TYPE_3BYTE_BGR;
		}
		int bufferSize = matrix.channels()*matrix.cols()*matrix.rows();
		byte [] buffer = new byte[bufferSize];
		matrix.get(0,0,buffer); // get all the pixels
		BufferedImage image = new BufferedImage(matrix.cols(),matrix.rows(), type);
		final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
		System.arraycopy(buffer, 0, targetPixels, 0, buffer.length);
		return image;
		}
}