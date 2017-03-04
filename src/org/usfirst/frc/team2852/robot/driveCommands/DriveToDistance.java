package org.usfirst.frc.team2852.robot.driveCommands;

import org.usfirst.frc.team2852.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class DriveToDistance extends Command {
	private double setpoint;
	Timer timer = new Timer();
	
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
    	
    	Robot.drivetrain.setOutputRange(-.5, .5); //good at .9
    	Robot.drivetrain.setSetpoint(setpoint);
    	
    	Robot.drivetrain.enable();
    	timer.start();
    }

    protected void execute() {
    	
    }

    protected boolean isFinished() {
    	System.out.println("Error: " + Robot.drivetrain.getPIDController().getError());
    	System.out.println("PID Out: " + Robot.drivetrain.getPIDController().get());
    	
    	if(timer.get() > 3)
    		return true;
    	return false;
        //return (Math.abs(Robot.drivetrain.getPosition()-setpoint) < .5);
    }

    protected void end() {
    	Robot.drivetrain.disable();
//    	Robot.drivetrain.leftDrive1.set(0);
//    	Robot.drivetrain.leftDrive2.set(0);
//    	Robot.drivetrain.leftDrive3.set(0);
//    	Robot.drivetrain.rightDrive1.set(0);
//    	Robot.drivetrain.rightDrive2.set(0);
//    	Robot.drivetrain.rightDrive3.set(0);
    }

    protected void interrupted() {
    	end();
    }
}
