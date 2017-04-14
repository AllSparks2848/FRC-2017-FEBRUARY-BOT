package org.usfirst.frc.team2852.autonCommands;

import org.usfirst.frc.team2852.intakeCommands.IntakeGear;
import org.usfirst.frc.team2852.intakeCommands.IntakePID;
import org.usfirst.frc.team2852.intakeCommands.SpitGearBreakBeam;
import org.usfirst.frc.team2852.intakeCommands.ZeroIntake;
import org.usfirst.frc.team2852.robot.Robot;
import org.usfirst.frc.team2852.robot.driveCommands.DriveStraight;
import org.usfirst.frc.team2852.robot.driveCommands.DriveToDistance;
import org.usfirst.frc.team2852.robot.driveCommands.GearTurn;
import org.usfirst.frc.team2852.robot.driveCommands.GyroTurn;
import org.usfirst.frc.team2852.robot.driveCommands.NoOmnis;
import org.usfirst.frc.team2852.robot.driveCommands.ShiftLow;
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
    	addParallel(new IntakePID(Robot.intake.spitPos));
       
       
        addSequential(new DriveStraight(74)); 
        addSequential(new Wait(.2));
        addParallel(new SpitGearBreakBeam());
        
        addSequential(new DriveStraight(-60)); 
        addSequential(new testZeroGyro());
        addParallel(new IntakePID(Robot.intake.intakePos));
        addSequential(new GyroTurn(90));
        addSequential(new testZeroGyro());
        addSequential(new DriveStraight(20));
        addSequential(new GearTurn());
        
        addParallel(new IntakeGear());
//        addParallel(new ShootAuton(660));
        addSequential(new DriveStraight(55)); 
        addSequential(new GyroTurn(0));
        addSequential(new RightTwoGearSecondHalf());
    }
}
