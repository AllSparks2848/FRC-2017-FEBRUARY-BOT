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
public class RedPosition3 extends CommandGroup {

    public RedPosition3() {
    	//fast version
    	
//    	addSequential(new ShiftHigh());
//    	addSequential(new NoOmnis());
//    	addParallel(new ZeroAndVisionPos());
//    	addSequential(new testZeroGyro());
//    
//    	addSequential(new DriveToDistHigh(74.3)); //was 74.3
//    	//addParallel(new IntakePIDNonStop(Robot.intake.spitPos));
//    	addSequential (new GyroTurnHigh(-55));
//    	addSequential(new ShiftLow());
//    	addSequential(new DriveToDistance(38)); //was 39
//    	addSequential(new VisionTurn());
//    	addParallel(new IntakePID(Robot.intake.spitPos));
//    	addSequential(new DriveToDistance(36)); //was 29
//    	addParallel(new SpitGearBreakBeam());
//    	addSequential(new BackAway());
    	
    	addSequential(new ShiftLow());
    	addSequential(new NoOmnis());
    	addSequential(new ZeroIntake());
    	addSequential(new testZeroGyro());
    
    	addSequential(new DriveToDistance(74.3)); //was 70.3
    	addParallel(new IntakePIDNonStop(Robot.intake.visionPos));
    	//addParallel(new IntakePIDNonStop(Robot.intake.spitPos));
    	addSequential (new GyroTurn(-60));
    	addSequential(new DriveToDistance(39));
    	addSequential(new VisionTurn());
    	addSequential(new IntakePID(Robot.intake.spitPos));
    	addSequential(new DriveToDistance(29));
    	addParallel(new SpitGearBreakBeam());
    	addSequential(new BackAway());
    	
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
