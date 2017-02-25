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
    public GyroTurn(double setpoint) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    	this.setpoint = setpoint;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.gyroController.setInputRange(-180, 180);
    	initialYaw = Robot.drivetrain.gyro.getYaw();
    	newSetpoint = initialYaw - setpoint;
    	Robot.drivetrain.gyroController.setSetpoint(newSetpoint);
    	Robot.drivetrain.gyroController.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.arcadeDrive(0, -Robot.drivetrain.gyroController.get());
		SmartDashboard.putNumber("Initial Yaw", initialYaw);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(newSetpoint-Robot.drivetrain.gyro.getYaw()) < 2;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.gyroController.disable();
    	Robot.drivetrain.drive1.arcadeDrive(0, 0);
    	Robot.drivetrain.drive2.arcadeDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
