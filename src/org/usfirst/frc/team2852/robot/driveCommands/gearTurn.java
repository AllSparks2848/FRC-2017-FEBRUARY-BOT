package org.usfirst.frc.team2852.robot.driveCommands;

import org.usfirst.frc.team2852.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class gearTurn extends Command {
	double turn = 0;
    public gearTurn() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	turn = Robot.gearX - 160; //centered is 160
    	turn*=.0175;
    	if(Math.abs(turn)>.7 && turn <0)
    		turn = -.7;
    	if(Math.abs(turn)>.7 && turn >0)
    		turn = .7;
    	if(Math.abs(turn)<.2 && turn >0)
    		turn = .2;
    	if(Math.abs(turn)<.2 && turn <0)
    		turn = -.2;
    	Robot.drivetrain.tankDrive(turn, -turn);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Math.abs(Robot.gearX) <2);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.setPowerZero();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
