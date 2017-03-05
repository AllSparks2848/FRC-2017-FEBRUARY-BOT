package org.usfirst.frc.team2852.autonCommands;

import org.usfirst.frc.team2852.robot.Robot;
import org.usfirst.frc.team2852.robot.driveCommands.GyroTurn;
import org.usfirst.frc.team2852.robot.driveCommands.testZeroGyro;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class VisionTurn extends CommandGroup {

    public VisionTurn() {
    	addSequential(new testZeroGyro());
    	addSequential(new SetAngle());
    	final double angle = Robot.angle;
        addSequential(new GyroTurn(angle));
    }
}