package org.usfirst.frc.team2852.robot.driveCommands;

import org.usfirst.frc.team2852.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class GyroTurn extends Command {

	private double setpoint;
    public GyroTurn(double setpoint) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    	this.setpoint = setpoint;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.gyro.zeroYaw();
    	Robot.drivetrain.gyroController.setOutputRange(-.5, .5);
    	Robot.drivetrain.gyroController.setSetpoint(setpoint);
    	Robot.drivetrain.gyroController.enable();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	Robot.drivetrain.leftDrive1.pidWrite(Robot.drivetrain.gyroController.get()); 
    	Robot.drivetrain.leftDrive2.pidWrite(Robot.drivetrain.gyroController.get());
    	Robot.drivetrain.leftDrive3.pidWrite(Robot.drivetrain.gyroController.get());
    	
    	Robot.drivetrain.rightDrive1.pidWrite(Robot.drivetrain.gyroController.get());
    	Robot.drivetrain.rightDrive2.pidWrite(Robot.drivetrain.gyroController.get());
    	Robot.drivetrain.rightDrive3.pidWrite(Robot.drivetrain.gyroController.get());
		System.out.println("Running Gyro Turn");
		
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(setpoint-Robot.drivetrain.gyro.getYaw()) < 1;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.gyroController.disable();
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
