package org.usfirst.frc.team2852.robot.driveCommands;

import org.usfirst.frc.team2852.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class GearTurn extends Command {
	double turn = 0;
    public GearTurn() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	turn = Robot.gearX - 173; //centered is 160
    	turn*= .0215; //.05
    	if(Math.abs(turn)>.635 && turn <0)
    		turn = -.635; //.61
    	if(Math.abs(turn)>.635 && turn >0)
    		turn = .63;
    	if(Math.abs(turn)<.635 && turn >0)
    		turn = .635; //.55
    	if(Math.abs(turn)<.635 && turn <0)
    		turn = -.635;
    	Robot.drivetrain.tankDrive(turn, -turn);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Math.abs(173 - Robot.gearX) <= 5);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.leftDrive1.set(0);  
    	Robot.drivetrain.leftDrive2.set(0);
    	Robot.drivetrain.leftDrive3.set(0);
    	
    	Robot.drivetrain.rightDrive1.set(0);
    	Robot.drivetrain.rightDrive2.set(0);
    	Robot.drivetrain.rightDrive3.set(0);
    	Robot.twoGearAngle = Robot.drivetrain.gyro.getYaw();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
