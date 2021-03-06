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
public class RedShootFirst extends CommandGroup {

    public RedShootFirst() {
    	addSequential(new ShiftLow());
    	addSequential(new NoOmnis());
    	addParallel(new ZeroIntake());
    	addSequential(new testZeroGyro());
    	
    	addSequential(new ShootAuton(510));
    	addSequential(new DriveToDistance(-25)); 
    	addSequential(new Wait(.1));
    	
    	
    	addSequential(new ShiftHigh());
    	addParallel(new IntakePID(Robot.intake.visionPos));
    	addSequential(new GyroTurnHigh(-105)); 
    	addSequential(new Wait(.05));
    	addSequential(new DriveToDistHigh(68)); //was 76, 
    	addSequential(new testZeroGyro());
    	addSequential(new GyroTurnHigh(-60));
    	addSequential(new ShiftLow());
    	addSequential(new DriveToDistance(20));
    	addSequential(new VisionTurn());
    	addParallel(new IntakePIDNonStop(Robot.intake.spitPos));
    	addSequential(new DriveToDistance(36)); //was 30
    	addParallel(new SpitGearBreakBeam());
    	addSequential(new BackAway());
    	
    	addSequential(new testZeroGyro());
    	addSequential(new GyroTurn(60));
    	addSequential(new ShiftHigh());
    	addSequential(new AllOmnis());
    	addSequential(new DriveToDistHigh(125));    
    }
}
