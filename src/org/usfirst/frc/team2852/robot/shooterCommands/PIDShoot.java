package org.usfirst.frc.team2852.robot.shooterCommands;

import org.usfirst.frc.team2852.robot.Robot;
import org.usfirst.frc.team2852.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PIDShoot extends Command {
    public PIDShoot() {
    	requires(Robot.shooter);
    	Robot.shooter.setOutputRange(0.05, .9);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.shooter.setSetpoint(Shooter.targetRPM);
    	Robot.shooter.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("Shooter Enc: " + Shooter.shooterBackEnc.getRate());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
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
