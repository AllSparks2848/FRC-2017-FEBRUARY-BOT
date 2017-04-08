package org.usfirst.frc.team2852.autonCommands;

import org.usfirst.frc.team2852.intakeCommands.IntakePID;
import org.usfirst.frc.team2852.intakeCommands.SpitGearBreakBeam;
import org.usfirst.frc.team2852.intakecommands.ZeroIntake;
import org.usfirst.frc.team2852.robot.Robot;
import org.usfirst.frc.team2852.robot.driveCommands.DriveToDistHigh;
import org.usfirst.frc.team2852.robot.driveCommands.DriveToDistance;
import org.usfirst.frc.team2852.robot.driveCommands.GyroTurnHigh;
import org.usfirst.frc.team2852.robot.driveCommands.NoOmnis;
import org.usfirst.frc.team2852.robot.driveCommands.ShiftHigh;
import org.usfirst.frc.team2852.robot.driveCommands.ShiftLow;
import org.usfirst.frc.team2852.robot.driveCommands.VisionTurn;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class BlueMidShot extends CommandGroup {

    public BlueMidShot() {
    	addSequential(new ShiftLow());
    	addSequential(new NoOmnis());
    	addSequential(new ZeroIntake());
    	addParallel(new IntakePID(Robot.intake.visionPos));
        addSequential(new DriveToDistance(45));
        addSequential(new VisionTurn());
       
       
        //addSequential(new IntakePID(Robot.intake.spitPos));
        System.out.println(Robot.distance);
        addSequential(new IntakePID(Robot.intake.spitPos));
         addSequential(new DriveToDistance(28));
         
        addParallel(new SpitGearBreakBeam());
        addSequential(new ShiftHigh());
        addSequential(new Wait(.2));
        addSequential(new DriveToDistHigh(-38)); //was -44.1
        addSequential(new GyroTurnHigh(-102.3));
        addParallel(new IntakePID(Robot.intake.tuckPos));
    	addParallel(new ShootAutonLong());
        addSequential(new DriveToDistHigh(100)); //was 114
    }
}
