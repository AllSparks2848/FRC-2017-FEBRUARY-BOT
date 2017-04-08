package org.usfirst.frc.team2852.autonCommands;

import org.usfirst.frc.team2852.intakeCommands.IntakePID;
import org.usfirst.frc.team2852.intakeCommands.SpitGearBreakBeam;
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
public class RedHopperShot extends CommandGroup {

    public RedHopperShot() {
//fast version
    	
    	addSequential(new ShiftHigh());
    	addSequential(new NoOmnis());
    	addParallel(new ZeroAndVisionPos());
    	addSequential(new testZeroGyro());
    
    	addSequential(new DriveToDistHigh(74.3)); //was 74.3
    	//addParallel(new IntakePIDNonStop(Robot.intake.spitPos));
    	addSequential (new GyroTurnHigh(-55));
    	addSequential(new ShiftLow());
    	addSequential(new DriveToDistance(38)); //was 39
    	addSequential(new VisionTurn());
    	addParallel(new IntakePID(Robot.intake.spitPos));
    	addSequential(new DriveToDistance(36)); //was 29
    	addParallel(new SpitGearBreakBeam());
    	
    	//slow version
//    	addSequential(new ShiftLow());
//    	addSequential(new NoOmnis());
//    	addSequential(new ZeroIntake());
//    	addSequential(new testZeroGyro());
//    
//    	addSequential(new DriveToDistance(74.3)); //was 74.3
//    	addParallel(new IntakePIDNonStop(Robot.intake.visionPos));
//    	//addParallel(new IntakePIDNonStop(Robot.intake.spitPos));
//    	addSequential (new GyroTurn(-60));
//    	addSequential(new DriveToDistance(38));
//    	addSequential(new VisionTurn());
//    	addSequential(new IntakePID(Robot.intake.spitPos));
//    	addSequential(new DriveToDistance(29));
//    	addParallel(new SpitGearBreakBeam());
    	
    	addSequential(new ShiftHigh());
    	addSequential(new DriveToDistHigh(-64));
    	addSequential (new GyroTurnHigh(150));
    	addSequential(new Wait(.25));
    	addSequential(new DriveToDistHigh(50)); //was 60.3
    	addSequential(new Wait(.5));
    	addSequential(new DriveToDistHigh(-7.5));
    	addParallel(new ShootAutonLong());
    	addSequential(new DriveToDistHigh(60));
        
    }
}
