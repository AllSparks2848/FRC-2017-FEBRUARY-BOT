package org.usfirst.frc.team2852.autonCommands;

import org.usfirst.frc.team2852.intakeCommands.IntakePID;
import org.usfirst.frc.team2852.intakeCommands.SpitGearBreakBeam;
import org.usfirst.frc.team2852.intakeCommands.ZeroIntake;
import org.usfirst.frc.team2852.robot.Robot;
import org.usfirst.frc.team2852.robot.driveCommands.BackAway;
import org.usfirst.frc.team2852.robot.driveCommands.DriveToDistance;
import org.usfirst.frc.team2852.robot.driveCommands.NoOmnis;
import org.usfirst.frc.team2852.robot.driveCommands.ShiftLow;
import org.usfirst.frc.team2852.robot.driveCommands.VisionDrive;
import org.usfirst.frc.team2852.robot.driveCommands.VisionTurn;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class MiddleAuton extends CommandGroup {

    public MiddleAuton() {
    //non vision	
    	/*
    	addSequential(new ShiftLow());
    	addSequential(new NoOmnis());
    	addSequential(new ZeroIntake());
        addSequential(new DriveToDistance(68));
        addSequential(new IntakePID(Robot.intake.spitPos));
        addSequential(new SpitGearBreakBeam());
        addSequential(new Wait(.25));
   		addSequential(new DriveToDistance(-20));
   		*/
    	addSequential(new ShiftLow());
    	addSequential(new NoOmnis());
    	addSequential(new ZeroIntake());
    	addParallel(new IntakePID(Robot.intake.visionPos));
        addSequential(new DriveToDistance(45));
        addSequential(new VisionTurn());
       
       
        //addSequential(new IntakePID(Robot.intake.spitPos));
        System.out.println(Robot.distance);
        addSequential(new IntakePID(Robot.intake.spitPos));
         addSequential(new DriveToDistance(28));
         
        addParallel(new SpitGearBreakBeam());
        addSequential(new Wait(.25));
   		addSequential(new BackAway());
   		
   		
    }
    
}
