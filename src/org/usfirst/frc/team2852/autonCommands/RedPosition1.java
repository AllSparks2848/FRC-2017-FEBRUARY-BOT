package org.usfirst.frc.team2852.autonCommands;


import org.usfirst.frc.team2852.autonCommands.VisionTurn;
import org.usfirst.frc.team2852.intakeCommands.IntakePID;
import org.usfirst.frc.team2852.intakeCommands.IntakePIDNonStop;
import org.usfirst.frc.team2852.intakeCommands.SpitGear;
import org.usfirst.frc.team2852.intakeCommands.SpitGearBreakBeam;
import org.usfirst.frc.team2852.intakeCommands.ZeroIntake;
import org.usfirst.frc.team2852.robot.Robot;
import org.usfirst.frc.team2852.robot.driveCommands.DriveToDistance;
import org.usfirst.frc.team2852.robot.driveCommands.GyroTurn;
import org.usfirst.frc.team2852.robot.driveCommands.NoOmnis;
import org.usfirst.frc.team2852.robot.driveCommands.ShiftLow;
import org.usfirst.frc.team2852.robot.driveCommands.testZeroGyro;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RedPosition1 extends CommandGroup {

    public RedPosition1() {
    	addSequential(new ShiftLow());
    	addSequential(new NoOmnis());
    	addSequential(new ZeroIntake());
    	addSequential(new testZeroGyro());
//    	addParallel(new IntakePIDNonStop(Robot.intake.visionPos));
    	addSequential(new DriveToDistance(70.3));
    	addSequential(new Wait(.5));
    	addParallel(new IntakePIDNonStop(Robot.intake.spitPos));
    	addSequential (new GyroTurn(60));
    	
    	addSequential(new Wait(.5));
    	addSequential(new DriveToDistance(60));//ian lowered at 813
    	
//    	addSequential(new VisionTurn());
//    	addSequential(new IntakePIDNonStop(Robot.intake.spitPos));
//    	addSequential(new DriveToDistance(45));
    	addSequential(new SpitGearBreakBeam());
    	addSequential(new DriveToDistance(-20));
    	
    	
    	//non vision above
    	
//    	addSequential(new ShiftLow());
//    	addSequential(new NoOmnis());
//    	addSequential(new ZeroIntake());
//    	addSequential(new testZeroGyro());
////    	addParallel(new IntakePIDNonStop(Robot.intake.visionPos));
//    	addSequential(new DriveToDistance(70.3));
//    	addSequential(new Wait(.5));
//    	addParallel(new IntakePID(Robot.intake.visionPos));
//    	addSequential (new GyroTurn(60));
//    	
//    	addSequential(new Wait(.5));
//    	addSequential(new DriveToDistance(15));//ian lowered at 813
//    	
//    	addSequential(new VisionTurn());
//    	addSequential(new IntakePID(Robot.intake.spitPos));
////    	addSequential(new IntakePIDNonStop(Robot.intake.spitPos));
//    	addSequential(new DriveToDistance(45));
//    	addSequential(new SpitGearBreakBeam());
//    	addSequential(new DriveToDistance(-20));
    	
    	//vision above
    	
    	
    	
    	
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
