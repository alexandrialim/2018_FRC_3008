package org.usfirst.frc.team3008.robot;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.livewindow.LiveWindowSendable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team3008.robot.Drive;


public class Robot extends SampleRobot {
	RobotDrive Bot = new RobotDrive(0, 1, 2, 3); // numbers are channel numbers  
	
	
													// (frontLeft, backLeft, frontRight, backRight)
	Joystick stick = new Joystick(0);// number = usb port # on driver station
	final String CenterAuto = "CenterAuto";
	final String LeftAuto_red = "Left Auto [Red]";
	final String LeftAuto_blue = "Left Auto [Blue]";
	final String RightAuto_red = "Right Auto [Red]";
	final String RightAuto_blue = "Right Auto [Blue]";
	SendableChooser<String> chooser = new SendableChooser<>();
	Camera cam = new Camera(); 
	
	public Robot() {
		
	}

	@Override
	public void robotInit() {
		chooser.addDefault("Default Auto (Center Auto)", CenterAuto);
		chooser.addObject("Left Auto [Red]", LeftAuto_red );
		chooser.addObject("Left Auto [Blue]", LeftAuto_blue);
		chooser.addObject("Right Auto [Red]", RightAuto_red);
		chooser.addObject("Right Auto [Blue]", RightAuto_blue);
		SmartDashboard.putData("Auto modes", chooser);
		
		cam.camInit(); // Camera initialize / start up
	
		{
			Timer.delay(0.05);
		}
	}


	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString line to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the
	 * if-else structure below with additional strings. If using the
	 * SendableChooser make sure to add them to the chooser code above as well.
	 */
	@Override
	public void autonomous() {
		String autoSelected = chooser.getSelected();
		System.out.println("Auto selected: " + autoSelected);
		switch (autoSelected) {
		case LeftAuto_red:
			Bot.setSafetyEnabled(false);
			Bot.drive(-0.5, 1.0); // spin backwards at half speed (speed for forward/backward), 
										//(turn right) [ -1 for curve == turn left] 
			Timer.delay(2.0); // for 2 seconds
			Bot.drive(0.0, 0.0); // stop robot
			
			break;
		case LeftAuto_blue:
			Bot.setSafetyEnabled(false);
			Bot.drive(-0.5, 1.0); // spin at half speed
			Timer.delay(2.0); // for 2 seconds
			Bot.drive(0.0, 0.0); // stop robot
			break;
		case RightAuto_red:
			Bot.setSafetyEnabled(false);
			Bot.drive(-0.5, 1.0); // spin at half speed
			Timer.delay(2.0); // for 2 seconds
			Bot.drive(0.0, 0.0); // stop robot
			break;
		case RightAuto_blue:
			Bot.setSafetyEnabled(false);
			Bot.drive(-0.5, 1.0); // spin at half speed (OutputMagnitude, Curve)
			Timer.delay(2.0); // for 2 seconds
			Bot.drive(0.0, 0.0); // stop robot
			break;
		case CenterAuto:
		default:
			Bot.setSafetyEnabled(false);
			Bot.drive(-0.5, 0.0); // drive forwards half speed
			Timer.delay(2.0); // for 2 seconds
			Bot.drive(0.0, 0.0); // stop robot
			break;
		}
	}

	/**
	 * Runs the motors with Tank steering.
	 */

	public void operatorControl() {
		
		Bot.setSafetyEnabled(true);
		while (isOperatorControl() && isEnabled()) {
			Timer.delay(0.005); // wait for a motor update time
		}
		
	}

	/**
	 * Runs during test mode
	 */
	@Override
	public void test() {
		while(isTest() && isEnabled()){
			LiveWindow.run();
			Timer.delay(0.1);
		}
	}
}
