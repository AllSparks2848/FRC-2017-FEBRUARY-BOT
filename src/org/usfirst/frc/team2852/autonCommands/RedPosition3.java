package org.usfirst.frc.team2852.autonCommands;

import org.usfirst.frc.team2852.intakeCommands.IntakePID;
import org.usfirst.frc.team2852.intakeCommands.IntakePIDNonStop;
import org.usfirst.frc.team2852.intakeCommands.SpitGearBreakBeam;
import org.usfirst.frc.team2852.intakeCommands.ZeroIntake;
import org.usfirst.frc.team2852.robot.Robot;
import org.usfirst.frc.team2852.robot.driveCommands.DriveToDistance;
import org.usfirst.frc.team2852.robot.driveCommands.GyroTurn;
import org.usfirst.frc.team2852.robot.driveCommands.NoOmnis;
import org.usfirst.frc.team2852.robot.driveCommands.ShiftLow;
import org.usfirst.frc.team2852.robot.driveCommands.VisionTurn;
import org.usfirst.frc.team2852.robot.driveCommands.testZeroGyro;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RedPosition3 extends CommandGroup {

    public RedPosition3() {
    	// non vision
    	/*
    	addSequential(new ShiftLow());
    	addSequential(new NoOmnis());
    	addSequential(new ZeroIntake());
    	addSequential(new testZeroGyro());
//    	addParallel(new IntakePIDNonStop(Robot.intake.visionPos));
    	addSequential(new DriveToDistance(70.3));
    	addSequential(new Wait(.75));
    	addSequential (new GyroTurn(-60));
    	
    	addSequential(new Wait(.75));
    	addSequential(new DriveToDistance(55));//ian lowered at 813
    	addParallel(new IntakePID(Robot.intake.spitPos));
//    	addSequential(new VisionTurn());
//    	addSequential(new IntakePIDNonStop(Robot.intake.spitPos));
//    	addSequential(new DriveToDistance(45));
    	addSequential(new SpitGearBreakBeam());
    	addSequential(new DriveToDistance(-20));
    	*/
    	

    	addSequential(new ShiftLow());
    	addSequential(new NoOmnis());
    	addSequential(new ZeroIntake());
    	addSequential(new testZeroGyro());
    
    	addSequential(new DriveToDistance(70.3)); 
    	addSequential(new Wait(.25));
    	addParallel(new IntakePIDNonStop(Robot.intake.visionPos));
    	//addParallel(new IntakePIDNonStop(Robot.intake.spitPos));
    	addSequential (new GyroTurn(-60));
    	addSequential(new Wait(.25));
    	addSequential(new DriveToDistance(30));
    	addSequential(new VisionTurn());
    	addParallel(new IntakePID(Robot.intake.spitPos));
    	addSequential(new DriveToDistance(34));
    	addSequential(new SpitGearBreakBeam());
    	addSequential(new DriveToDistance(-20));
    	
    	
    	
    	
    	
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
