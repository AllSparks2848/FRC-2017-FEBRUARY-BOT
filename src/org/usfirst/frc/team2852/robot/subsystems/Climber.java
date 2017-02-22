package org.usfirst.frc.team2852.robot.subsystems;

import org.usfirst.frc.team2852.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {

    Spark climbR = new Spark(RobotMap.p_climbR);
    Spark climbL = new Spark(RobotMap.p_climbL);
    

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void climb() {
    	climbR.set(1);
    	climbL.set(-1);
    }
    
    public void stopClimbing() {
    	climbR.set(0);
    	climbL.set(0);
    }
}

