package org.usfirst.frc.team2852.intakeCommands;

import org.usfirst.frc.team2852.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakePIDNonStop extends Command {
	private double setpoint;
	
    public IntakePIDNonStop(double setpoint) {
    	this.setpoint = setpoint;
        requires(Robot.intake);
        Robot.intake.setOutputRange(-.45, .45);
    }

    protected void initialize() {
    	Robot.intake.setSetpoint(setpoint);
    	Robot.intake.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.intake.disable();
    }

    protected void interrupted() {
    	end();
    }
}