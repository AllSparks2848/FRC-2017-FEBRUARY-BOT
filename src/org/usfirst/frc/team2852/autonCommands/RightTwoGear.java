package org.usfirst.frc.team2852.autonCommands;

import org.usfirst.frc.team2852.intakeCommands.IntakeGear;
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
public class RightTwoGear extends CommandGroup {

    public RightTwoGear() {
    	addSequential(new ShiftLow());
    	addSequential(new NoOmnis());
    	addSequential(new ZeroIntake());
    	addSequential(new testZeroGyro());
    	
    	addParallel(new IntakePID(Robot.intake.visionPos));
        addSequential(new DriveToDistance(45));
        addSequential(new VisionTurn());
       
       
        //addSequential(new IntakePID(Robot.intake.spitPos));
        addSequential(new IntakePID(Robot.intake.spitPos));
        addSequential(new DriveToDistance(30));
        
        addParallel(new SpitGearBreakBeam());
        addSequential(new DriveToDistHigh(-55)); //was 70
        addSequential(new testZeroGyro());
        addParallel(new IntakePID(Robot.intake.intakePos));
        addSequential(new GyroTurn(90));
        addSequential(new ShiftHigh());
//        addSequential(new Wait(.15));
        
        addParallel(new IntakeGear());
        addSequential(new DriveToDistHigh(75));
        addSequential(new RightTwoGearSecondHalf());
    }
}
