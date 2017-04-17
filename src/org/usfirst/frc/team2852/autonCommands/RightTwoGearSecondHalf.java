package org.usfirst.frc.team2852.autonCommands;

import org.usfirst.frc.team2852.intakeCommands.IntakePID;
import org.usfirst.frc.team2852.intakeCommands.SpitGearBreakBeam;
import org.usfirst.frc.team2852.robot.Robot;
import org.usfirst.frc.team2852.robot.driveCommands.BackAway;
import org.usfirst.frc.team2852.robot.driveCommands.DriveStraight;
import org.usfirst.frc.team2852.robot.driveCommands.DriveToDistance;
import org.usfirst.frc.team2852.robot.driveCommands.GyroTurn;
import org.usfirst.frc.team2852.robot.driveCommands.VisionTurn;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightTwoGearSecondHalf extends CommandGroup {

    public RightTwoGearSecondHalf() {
//    	if(Robot.isGear) {
        	
	        addSequential(new DriveStraight(-80));
	        addParallel(new IntakePID(Robot.intake.visionPos));
	        addSequential(new GyroTurn(-90));
	        addSequential(new DriveToDistance(35));
	        addSequential(new VisionTurn());
	        addParallel(new IntakePID(Robot.intake.spitPos));
	        addSequential(new DriveToDistance(32));
	        addParallel(new SpitGearBreakBeam());
	        addParallel(new BackAway());
//        }
//    	else stop intake 
    }
}
