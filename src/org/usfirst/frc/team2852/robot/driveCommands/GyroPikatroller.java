package org.usfirst.frc.team2852.robot.driveCommands;

import org.usfirst.frc.team2852.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GyroPikatroller extends Command {

	double pGyro = .08;
	
	private double setpoint;
	double error;
	double output;
	
	double initialAngle;
	double newSetpoint;
	
    public GyroPikatroller(double setpoint) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    	this.setpoint = setpoint;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	initialAngle = Robot.drivetrain.gyro.getAngle();
    	newSetpoint = initialAngle - setpoint;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	error = newSetpoint - Robot.drivetrain.gyro.getAngle();
    	output = error*pGyro;
    	Robot.drivetrain.leftDrive1.pidWrite(-output); 
    	Robot.drivetrain.leftDrive2.pidWrite(-output);
    	Robot.drivetrain.leftDrive3.pidWrite(-output);
    	
    	Robot.drivetrain.rightDrive1.pidWrite(-output);
    	Robot.drivetrain.rightDrive2.pidWrite(-output);
    	Robot.drivetrain.rightDrive3.pidWrite(-output);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(error) < 2;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.leftDrive1.set(0);  
    	Robot.drivetrain.leftDrive2.set(0);
    	Robot.drivetrain.leftDrive3.set(0);
    	
    	Robot.drivetrain.rightDrive1.set(0);
    	Robot.drivetrain.rightDrive2.set(0);
    	Robot.drivetrain.rightDrive3.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
