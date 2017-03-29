package org.usfirst.frc.team2852.autonCommands;

import org.usfirst.frc.team2852.intakeCommands.IntakeGear;
import org.usfirst.frc.team2852.intakeCommands.IntakePID;
import org.usfirst.frc.team2852.intakeCommands.SpitGearBreakBeam;
import org.usfirst.frc.team2852.intakeCommands.ZeroIntake;
import org.usfirst.frc.team2852.robot.Robot;
import org.usfirst.frc.team2852.robot.driveCommands.DriveToDistHigh;
import org.usfirst.frc.team2852.robot.driveCommands.DriveToDistance;
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
public class BlueTwoGear extends CommandGroup {

    public BlueTwoGear() {
    	addSequential(new ShiftLow());
    	addSequential(new NoOmnis());
    	addSequential(new ZeroIntake());
    	addSequential(new testZeroGyro());
    	
    	addParallel(new IntakePID(Robot.intake.visionPos));
        addSequential(new DriveToDistance(45));
        addSequential(new VisionTurn());
       
       
        //addSequential(new IntakePID(Robot.intake.spitPos));
        System.out.println(Robot.distance);
        addSequential(new IntakePID(Robot.intake.spitPos));
        addSequential(new DriveToDistance(28));
        addSequential(new ShiftHigh());
        addParallel(new SpitGearBreakBeam());
        addSequential(new DriveToDistHigh(-55)); //was 70
        addSequential(new testZeroGyro());
        addParallel(new IntakePID(Robot.intake.intakePos));
        addSequential(new GyroTurnHigh(-80));
        addSequential(new Wait(.15));
        
        addParallel(new IntakeGear());
        addSequential(new DriveToDistHigh(75));
        addSequential(new BlueTwoGearSecondHalf());
    }
}
