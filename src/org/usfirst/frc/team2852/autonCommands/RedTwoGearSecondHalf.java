package org.usfirst.frc.team2852.autonCommands;

import org.usfirst.frc.team2852.intakeCommands.IntakePID;
import org.usfirst.frc.team2852.intakeCommands.SpitGearBreakBeam;
import org.usfirst.frc.team2852.robot.Robot;
import org.usfirst.frc.team2852.robot.driveCommands.BackAway;
import org.usfirst.frc.team2852.robot.driveCommands.DriveToDistHigh;
import org.usfirst.frc.team2852.robot.driveCommands.GyroTurnHigh;
import org.usfirst.frc.team2852.robot.driveCommands.VisionTurn;
import org.usfirst.frc.team2852.robot.driveCommands.testZeroGyro;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RedTwoGearSecondHalf extends CommandGroup {

    public RedTwoGearSecondHalf() {
    	if(Robot.intake.isBeamBroken()) {
        	
	        addSequential(new DriveToDistHigh(-50));
	        addParallel(new IntakePID(Robot.intake.visionPos));
	        addSequential(new Wait(.15));
	        addSequential(new testZeroGyro());
	        addSequential(new Wait(.15));
	        addSequential(new GyroTurnHigh(-90));
	        addSequential(new DriveToDistHigh(20));
	        addSequential(new VisionTurn());
	        addSequential(new DriveToDistHigh(20));
	        addSequential(new VisionTurn());
	        addParallel(new IntakePID(Robot.intake.spitPos));
	        addSequential(new DriveToDistHigh(30));
	        addParallel(new SpitGearBreakBeam());
	        addParallel(new BackAway());
        }
    }
}
