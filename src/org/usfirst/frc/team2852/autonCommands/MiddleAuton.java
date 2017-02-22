package org.usfirst.frc.team2852.autonCommands;

import org.usfirst.frc.team2852.robot.driveCommands.DriveToDistance;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class MiddleAuton extends CommandGroup {

    public MiddleAuton() {
       addSequential(new DriveToDistance(48));
       //vision?
    }
}
