package org.usfirst.frc.team2852.robot.driveCommands;

import org.usfirst.frc.team2852.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class GyroTurn extends Command {

	private double setpoint;
	double initialYaw;
	double newSetpoint;
	boolean goodSetpoint = false;
    public GyroTurn(double setpoint) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    	this.setpoint = setpoint;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	initialYaw = Robot.drivetrain.gyro.getYaw();
    	Robot.drivetrain.gyroController.setOutputRange(-.5, .5);
    	newSetpoint = initialYaw - setpoint;
    	SmartDashboard.putNumber("Initial Yaw", initialYaw);
    	if(!(newSetpoint>180||newSetpoint<-180)) {
    		Robot.drivetrain.gyroController.setSetpoint(newSetpoint);
    		Robot.drivetrain.gyroController.enable();
    		goodSetpoint = true;
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(newSetpoint>180||newSetpoint<-180){
    		Robot.drivetrain.gyro.zeroYaw();
    		initialYaw = Robot.drivetrain.gyro.getYaw();
    		newSetpoint = initialYaw - setpoint;
    		SmartDashboard.putNumber("Initial Yaw", initialYaw);
    		if(!(newSetpoint>180||newSetpoint<-180)) {
    		Robot.drivetrain.gyroController.setSetpoint(newSetpoint);
    		Robot.drivetrain.gyroController.enable();
    		goodSetpoint = true;
    		}
    	}
    	if(goodSetpoint) {
    	Robot.drivetrain.leftDrive1.pidWrite(-Robot.drivetrain.gyroController.get()); 
    	Robot.drivetrain.leftDrive2.pidWrite(-Robot.drivetrain.gyroController.get());
    	Robot.drivetrain.leftDrive3.pidWrite(-Robot.drivetrain.gyroController.get());
    	
    	Robot.drivetrain.rightDrive1.pidWrite(-Robot.drivetrain.gyroController.get());
    	Robot.drivetrain.rightDrive2.pidWrite(-Robot.drivetrain.gyroController.get());
    	Robot.drivetrain.rightDrive3.pidWrite(-Robot.drivetrain.gyroController.get());
    	}
		System.out.println("Running Gyro Turn");
		
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(newSetpoint-Robot.drivetrain.gyro.getYaw()) < 2;
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
