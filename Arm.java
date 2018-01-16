package org.usfirst.frc.team3008.robot;
import org.usfirst.frc.team3008.robot.Variables;

import edu.wpi.first.wpilibj.DigitalInput;
public class Arm implements Variables{
	public static DigitalInput Lim1 = new DigitalInput(lift);
	
	
public boolean Lim1Pressed(){
	return Lim1.get(); 
}

public void Lim1NotPressed(){
	long initTime = System.currentTimeMillis();
	while(Lim1Pressed() && initTime + 4000 > System.currentTimeMillis()){
		
	}
}
 
}
