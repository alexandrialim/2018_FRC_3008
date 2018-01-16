package org.usfirst.frc.team3008.robot;
import org.usfirst.frc.team3008.robot.Robot;
import org.usfirst.frc.team3008.robot.Pneumatic_System;

import edu.wpi.first.wpilibj.Encoder;
//import edu.wpi.first.wpilibj.GenericHID;  // for joystick
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TalonSRX;

import org.usfirst.frc.team3008.robot.Variables;

public class Drive implements Variables {
	Joystick joy1;
	double x;
	double y;
	
	//setting sparks for motors:
	

    static Spark h = new Spark(claw); 				// Spark for Claw Motor
    
    static TalonSRX FRT = new TalonSRX(frontRightDrive); // Talon SRX for Front Right Motor
    static TalonSRX BRT = new TalonSRX(backRightDrive); // Talon SRX for Back Right Motor
    static TalonSRX BLT = new TalonSRX(backLeftDrive); // Talon SRX for Back Left Motor 
    static TalonSRX FLT = new TalonSRX(frontLeftDrive); // Talon SRX for Front Left Motor
    static TalonSRX LT = new TalonSRX(lift); //TAlonSRX for lift

    
    
  
    // Set all motors to start at 0:
    double FR2=0;
    double FL2=0;
    double BR2=0;
    double BL2=0;
    double h2 = 0;
    
    //Run Teleop Code:
    public void run(){
    	joy1 = new Joystick(0);
    	x = joy1.getX();
    	y = joy1.getY();
    	
    	boolean buttonValue;
    	buttonValue = joy1.getTrigger();
    	
    	if(joy1.getRawButton(1) == true){
    		//s1.set(true);
    	}
    	while (true){
    		x = joy1.getRawAxis(0);
    		y = joy1.getRawAxis(1);
    		
			if (joy1.getRawButton(6))FRT.set(1); // FR motor (change later)
			else FRT.set(0);
    		    	//(look in RobotDrive.class)			
    	}
    }
}
