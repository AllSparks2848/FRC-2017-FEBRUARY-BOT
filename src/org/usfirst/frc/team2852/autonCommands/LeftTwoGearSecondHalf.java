package org.usfirst.frc.team2852.autonCommands;

import org.usfirst.frc.team2852.intakeCommands.IntakePID;
import org.usfirst.frc.team2852.intakeCommands.SpitGearBreakBeam;
import org.usfirst.frc.team2852.robot.Robot;
import org.usfirst.frc.team2852.robot.driveCommands.BackAway;
import org.usfirst.frc.team2852.robot.driveCommands.DriveToDistHigh;
import org.usfirst.frc.team2852.robot.driveCommands.DriveToDistance;
import org.usfirst.frc.team2852.robot.driveCommands.GyroTurn;
import org.usfirst.frc.team2852.robot.driveCommands.GyroTurnHigh;
import org.usfirst.frc.team2852.robot.driveCommands.ShiftHigh;
import org.usfirst.frc.team2852.robot.driveCommands.ShiftLow;
import org.usfirst.frc.team2852.robot.driveCommands.VisionTurn;
import org.usfirst.frc.team2852.robot.driveCommands.testZeroGyro;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftTwoGearSecondHalf extends CommandGroup {

    public LeftTwoGearSecondHalf() {
    	//if(Robot.isGear) {
    	addSequential(new ShiftHigh());
		
        addSequential(new DriveToDistHigh(-86));
        addSequential(new ShiftLow());
        addParallel(new IntakePID(Robot.intake.visionPos));
        addSequential(new GyroTurn(90));
        addSequential(new DriveToDistance(35));
        
        addSequential(new VisionTurn());
        addParallel(new IntakePID(Robot.intake.spitPos));
        addSequential(new DriveToDistance(40));
        addParallel(new SpitGearBreakBeam());
        addParallel(new BackAway());
    	//}
    }
}
