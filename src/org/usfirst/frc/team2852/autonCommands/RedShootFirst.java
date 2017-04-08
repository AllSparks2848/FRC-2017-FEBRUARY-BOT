package org.usfirst.frc.team2852.autonCommands;

import org.usfirst.frc.team2852.intakeCommands.IntakePID;
import org.usfirst.frc.team2852.intakeCommands.SpitGearBreakBeam;
import org.usfirst.frc.team2852.intakecommands.ZeroIntake;
import org.usfirst.frc.team2852.robot.Robot;
import org.usfirst.frc.team2852.robot.driveCommands.BackAway;
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
public class RedShootFirst extends CommandGroup {

    public RedShootFirst() {
    	addSequential(new ShiftLow());
    	addSequential(new NoOmnis());
    	addParallel(new ZeroIntake());
    	addSequential(new testZeroGyro());
    	
    	addSequential(new ShootAuton());
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
    	addSequential(new IntakePID(Robot.intake.spitPos));
    	addSequential(new DriveToDistance(32)); //was 30
    	addParallel(new SpitGearBreakBeam());
    	addSequential(new BackAway());
    	
//    	addSequential(new testZeroGyro());
//    	addSequential(new GyroTurnHigh(60));
//    	addSequential(new DriveToDistHigh(100));
    	
    	
    	
    	
    	
    	
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
