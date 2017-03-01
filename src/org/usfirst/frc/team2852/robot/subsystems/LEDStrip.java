package org.usfirst.frc.team2852.robot.subsystems;

import org.usfirst.frc.team2852.ledCommands.SendLEDState;
import org.usfirst.frc.team2852.robot.Robot;
import org.usfirst.frc.team2852.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LEDStrip extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	DigitalOutput out1 = new DigitalOutput(RobotMap.p_out1);
	DigitalOutput out2 = new DigitalOutput(RobotMap.p_out2);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new SendLEDState());
    }
    
    public void sendLEDState() {
		boolean output1 = false;
		if(Robot.intake.isBeamBroken())
			output1 = true;
		
		out1.set(output1);
		out2.set(false); //extra 2 options built in
	}
    
}

