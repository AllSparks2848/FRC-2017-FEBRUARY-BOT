package org.usfirst.frc.team2852.autonCommands;

import org.usfirst.frc.team2852.intakeCommands.IntakePID;
import org.usfirst.frc.team2852.intakeCommands.SpitGearBreakBeam;
import org.usfirst.frc.team2852.intakeCommands.ZeroIntake;
import org.usfirst.frc.team2852.robot.Robot;
import org.usfirst.frc.team2852.robot.driveCommands.BackAway;
import org.usfirst.frc.team2852.robot.driveCommands.DriveStraight;
import org.usfirst.frc.team2852.robot.driveCommands.NoOmnis;
import org.usfirst.frc.team2852.robot.driveCommands.ShiftLow;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class MiddleFast extends CommandGroup {

    public MiddleFast() {
    	addSequential(new ShiftLow());
    	addSequential(new NoOmnis());
    	addSequential(new ZeroIntake());
    	addParallel(new IntakePID(Robot.intake.spitPos));
       
       
         addSequential(new DriveStraight(72)); 
         
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
