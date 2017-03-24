package org.usfirst.frc.team2852.autonCommands;


import org.usfirst.frc.team2852.intakeCommands.IntakePID;
import org.usfirst.frc.team2852.intakeCommands.IntakePIDNonStop;
import org.usfirst.frc.team2852.intakeCommands.SpitGearBreakBeam;
import org.usfirst.frc.team2852.intakeCommands.ZeroIntake;
import org.usfirst.frc.team2852.robot.Robot;
import org.usfirst.frc.team2852.robot.driveCommands.AllOmnis;
import org.usfirst.frc.team2852.robot.driveCommands.BackAway;
import org.usfirst.frc.team2852.robot.driveCommands.DriveToDistHigh;
import org.usfirst.frc.team2852.robot.driveCommands.DriveToDistance;
import org.usfirst.frc.team2852.robot.driveCommands.GyroTurn;
import org.usfirst.frc.team2852.robot.driveCommands.GyroTurnHigh;
import org.usfirst.frc.team2852.robot.driveCommands.NoOmnis;
import org.usfirst.frc.team2852.robot.driveCommands.ShiftHigh;
import org.usfirst.frc.team2852.robot.driveCommands.ShiftLow;
import org.usfirst.frc.team2852.robot.driveCommands.VisionTurn;
import org.usfirst.frc.team2852.robot.driveCommands.testZeroGyro;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RedPosition1 extends CommandGroup {

    public RedPosition1() {
    	
    	// NON VISION
    	/*addSequential(new ShiftLow());
    	addSequential(new NoOmnis());
    	addSequential(new ZeroIntake());
    	addSequential(new testZeroGyro());
    
    	addSequential(new DriveToDistance(70.3)); 
    	addSequential(new Wait(.75));
    	addParallel(new IntakePIDNonStop(Robot.intake.spitPos));
    	addSequential (new GyroTurn(60));
    	addSequential(new Wait(.75));
    	addSequential(new DriveToDistance(62));
    	
    	addSequential(new Wait(.75)); */
    	//NON VISION
    
    	addSequential(new ShiftHigh());
    	addSequential(new NoOmnis());
    	addParallel(new ZeroAndVisionPos());
    	addSequential(new testZeroGyro());
    
    	addSequential(new DriveToDistHigh(70.3)); 
    	
    	//addParallel(new IntakePIDNonStop(Robot.intake.spitPos));
    	addSequential (new GyroTurnHigh(60));
    	addSequential(new Wait(.1));
    	addSequential(new ShiftLow());
    	addSequential(new DriveToDistance(38)); //was 30
    	addSequential(new VisionTurn());
//    	addSequential(new Wait(.1));
    	addSequential(new IntakePID(Robot.intake.spitPos));
    	addSequential(new DriveToDistance(30)); //was 34
    	addParallel(new SpitGearBreakBeam());
    	addSequential(new BackAway());
//    	addSequential(new ShiftHigh());
//    	addSequential(new AllOmnis());
    	
    }
}
