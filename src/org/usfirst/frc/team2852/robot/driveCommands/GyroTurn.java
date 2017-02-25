package org.usfirst.frc.team2852.robot.driveCommands;

import org.usfirst.frc.team2852.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

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
    	Robot.drivetrain.gyro.reset(); 
    	Robot.drivetrain.gyroController.setSetpoint(setpoint);
    	Robot.drivetrain.gyroController.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.arcadeDrive(0, Robot.drivetrain.gyroController.get());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(setpoint-Robot.drivetrain.gyro.getAngle()) < 2;
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
