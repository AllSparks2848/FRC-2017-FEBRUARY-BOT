package org.usfirst.frc.team2852.robot.shooterCommands;

import org.usfirst.frc.team2852.robot.Robot;
import org.usfirst.frc.team2852.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PIDShoot extends Command {
private int setpoint;
    public PIDShoot(int setpoint) {
    	this.setpoint = setpoint;
    	requires(Robot.shooter);
    	Robot.shooter.setOutputRange(0, 1);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.shooter.setSetpoint(setpoint);
    	Robot.shooter.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	System.out.println("Front Encoder Rate: "+ Shooter.shooterFrontEnc.getRate());
    	System.out.println("Front Motor Speed: "+ Shooter.shooterFront.getSpeed());
    	System.out.println("Back Encoder Rate: "+ Shooter.shooterBackEnc.getRate());
    	System.out.println("Back Motor Speed: "+ Shooter.shooterBack.getSpeed());
    	System.out.println("/n/n/n");
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.shooter.disable();
    	Robot.shooter.stopShoot();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
