package org.usfirst.frc.team3008.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import org.opencv.core.Mat;
import org.opencv.core.RotatedRect;



public class Camera {
	
	
	UsbCamera Cam1;
	
	public void camInit(){
		this.Cam1 = CameraServer.getInstance().startAutomaticCapture("vision", 0);
		this.Cam1.setFPS(14); // Frames per a second
		this.Cam1.setResolution(1280, 720); //width and height of frame that camera sees as a whole image
		this.Cam1.setExposureManual(50); // amount of light the camera captures when photo is taken.
	}
	public static void boxPoints(RotatedRect box, Mat points)
    { 
        boxPoints_0(box.center.x, box.center.y, box.size.width, box.size.height, box.angle, points.nativeObj);
        return;
    }
	private static native void boxPoints_0(double box_center_x, double box_center_y, double box_size_width, double box_size_height, double box_angle, long points_nativeObj);
	// calling in original identification  (Box points is From org.opencv.imgproc.imgproc) need to test... 
	// check org.opencv.calib3d   calib3d.class for more stuff for image processing that might work
}
	
