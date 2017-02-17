package org.usfirst.frc.team2852.robot.subsystems;

import org.usfirst.frc.team2852.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {

    Spark climb1 = new Spark(RobotMap.p_climb1);
    Spark climb2 = new Spark(RobotMap.p_climb2);
    

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void climb() {
    	climb1.set(.75);
    	climb2.set(-.75);
    }
    
    public void stopClimbing() {
    	climb1.set(0);
    	climb2.set(0);
    }
}

