package org.usfirst.frc.team2852.autonCommands;

import org.usfirst.frc.team2852.intakeCommands.IntakeGear;
import org.usfirst.frc.team2852.intakeCommands.IntakePID;
import org.usfirst.frc.team2852.intakeCommands.SpitGearBreakBeam;
import org.usfirst.frc.team2852.intakeCommands.ZeroIntake;
import org.usfirst.frc.team2852.robot.Robot;
import org.usfirst.frc.team2852.robot.driveCommands.DriveStraight;
import org.usfirst.frc.team2852.robot.driveCommands.DriveToDistHigh;
import org.usfirst.frc.team2852.robot.driveCommands.DriveToDistance;
import org.usfirst.frc.team2852.robot.driveCommands.GearTurn;
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
public class LeftTwoGear extends CommandGroup {

    public LeftTwoGear() {
    	addSequential(new ShiftLow());
    	addSequential(new NoOmnis());
    	addSequential(new ZeroIntake());
    	addParallel(new IntakePID(Robot.intake.spitPos));
       
       
        addSequential(new DriveStraight(71)); 
//        addSequential(new Wait(.2));
        addParallel(new SpitGearBreakBeam());
        
        addSequential(new DriveStraight(-51)); 
        addSequential(new testZeroGyro());
        addParallel(new IntakePID(Robot.intake.intakePos));
        addSequential(new GyroTurn(-90));
        addSequential(new testZeroGyro());
        addSequential(new DriveStraight(20));
        addSequential(new GearTurn());
        addParallel(new IntakePID(Robot.intake.intakePos));
//        odith
        
        addParallel(new IntakeGear());
//        addParallel(new ShootAuton(660));
        addSequential(new DriveToDistance(60)); 
        addSequential(new GyroTurn(0));
        addSequential(new LeftTwoGearSecondHalf());
    }
}
