package org.usfirst.frc.team3008.robot;

import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;

public class Pneumatic_System extends SampleRobot{
	public Solenoid s1, s2;
	private Compressor airCompressor;
	
	public Pneumatic_System(){
		airCompressor = new Compressor(1); 
		airCompressor.start();
		
		s1 = new Solenoid(1);
		s2 = new Solenoid(2);
	}
}
