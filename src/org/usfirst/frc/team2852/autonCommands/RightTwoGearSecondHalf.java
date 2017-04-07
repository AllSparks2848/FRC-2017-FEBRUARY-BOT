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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class RightTwoGearSecondHalf extends CommandGroup {

    public RightTwoGearSecondHalf() {
    	if(Robot.isGear) {
        	
	        addSequential(new DriveToDistHigh(-55));
	        addParallel(new IntakePID(Robot.intake.visionPos));
	        addSequential(new Wait(.1));
	        addSequential(new testZeroGyro());
	        addSequential(new GyroTurnHigh(-90));
	        addSequential(new Wait(.1));
	        addSequential(new DriveToDistHigh(20));
	        addSequential(new VisionTurn());
	        addSequential(new DriveToDistHigh(20));
	        addSequential(new VisionTurn());
	        addParallel(new IntakePID(Robot.intake.spitPos));
	        addSequential(new DriveToDistHigh(30));
	        addParallel(new SpitGearBreakBeam());
	        addParallel(new BackAway());
        }
//    	else stop intake 
    }
}
