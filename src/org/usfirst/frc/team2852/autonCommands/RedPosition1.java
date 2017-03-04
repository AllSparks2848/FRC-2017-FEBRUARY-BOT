package org.usfirst.frc.team2852.autonCommands;


import org.usfirst.frc.team2852.intakeCommands.IntakePIDNonStop;
import org.usfirst.frc.team2852.intakeCommands.SpitGearBreakBeam;
import org.usfirst.frc.team2852.intakeCommands.ZeroIntake;
import org.usfirst.frc.team2852.robot.Robot;
import org.usfirst.frc.team2852.robot.driveCommands.DriveToDistance;
import org.usfirst.frc.team2852.robot.driveCommands.GyroTurn;
import org.usfirst.frc.team2852.robot.driveCommands.NoOmnis;
import org.usfirst.frc.team2852.robot.driveCommands.ShiftLow;
import org.usfirst.frc.team2852.robot.driveCommands.testZeroGyro;

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
    
    	addSequential(new DriveToDistance(70.3)); 
    	addSequential(new Wait(.75));
    	addParallel(new IntakePIDNonStop(Robot.intake.visionPos));
    	//addParallel(new IntakePIDNonStop(Robot.intake.spitPos));
    	addSequential (new GyroTurn(60));
    	addSequential(new Wait(.75));
    	addSequential(new DriveToDistance(30));
    	
    	addSequential(new Wait(.75));
    
    	/*addSequential(new VisionTurn());
    	addParallel(new IntakePIDNonStop(Robot.intake.spitPos));
    	addSequential(new DriveToDistance(30));
    	
    	
//    	addSequential(new IntakePIDNonStop(Robot.intake.spitPos));
//    	addSequential(new DriveToDistance(45));
    	addSequential(new SpitGearBreakBeam());
    	addSequential(new DriveToDistance(-20));
    	*/
    }
}
