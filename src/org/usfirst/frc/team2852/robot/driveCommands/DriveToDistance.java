package org.usfirst.frc.team2852.robot.driveCommands;

import org.usfirst.frc.team2852.robot.Robot;
import org.usfirst.frc.team2852.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

public class DriveToDistance extends Command {
	private double setpoint;
	
	public DriveToDistance() {
		requires(Robot.drivetrain);
	}
    public DriveToDistance(double setpoint) {
        this.setpoint = setpoint;
    }

    protected void initialize() {
    	Robot.drivetrain.leftEncoder.reset();
    	Robot.drivetrain.rightEncoder.reset();
    	Robot.drivetrain.leftEncoder.setDistancePerPulse(.0493);
    	Robot.drivetrain.rightEncoder.setDistancePerPulse(.0488);
    	Robot.drivetrain.setOutputRange(-.9, .9);
    	Robot.drivetrain.setSetpoint(setpoint);
    	Robot.drivetrain.getPIDController().enable();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
    	System.out.println("Left Dist: " + Robot.drivetrain.leftEncoder.getDistance());
    	System.out.println("Right Dist: " + Robot.drivetrain.rightEncoder.getDistance());
    	System.out.println("Position: " + Robot.drivetrain.getPosition());
    	System.out.println("Error: " + Robot.drivetrain.getPIDController().getError());
    	System.out.println("PID Out: " + Robot.drivetrain.getPIDController().get());
        return Math.abs(Robot.drivetrain.getPosition() - setpoint) < 2;
    }

    protected void end() {
    	Robot.drivetrain.disable();
    	Robot.drivetrain.leftEncoder.reset();
    	Robot.drivetrain.rightEncoder.reset();
    }

    protected void interrupted() {
    	end();
    }
}
