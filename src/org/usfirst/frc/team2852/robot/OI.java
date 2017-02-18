package org.usfirst.frc.team2852.robot;

import org.usfirst.frc.team2852.climbercommands.Climb;
import org.usfirst.frc.team2852.intakecommands.IntakeDown;
import org.usfirst.frc.team2852.intakecommands.IntakeGear;
import org.usfirst.frc.team2852.intakecommands.IntakePID;
import org.usfirst.frc.team2852.intakecommands.IntakeToPosition;
import org.usfirst.frc.team2852.intakecommands.IntakeUp;
import org.usfirst.frc.team2852.intakecommands.SetBottomPos;
import org.usfirst.frc.team2852.intakecommands.SpitGear;
import org.usfirst.frc.team2852.robot.drivecommands.AllOmnis;
import org.usfirst.frc.team2852.robot.drivecommands.BackOmnis;
import org.usfirst.frc.team2852.robot.drivecommands.FrontOmnis;
import org.usfirst.frc.team2852.robot.drivecommands.NoOmnis;
import org.usfirst.frc.team2852.robot.drivecommands.ShiftHigh;
import org.usfirst.frc.team2852.robot.drivecommands.ShiftLow;
import org.usfirst.frc.team2852.robot.shootercommands.Convey;
import org.usfirst.frc.team2852.robot.shootercommands.ManualShoot;
import org.usfirst.frc.team2852.robot.shootercommands.PIDShoot;
import org.usfirst.frc.team2852.robot.shootercommands.ShootAndConvey;
import org.usfirst.frc.team2852.robot.util.XboxTrigger;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class OI {
	Joystick xbox1 = new Joystick(RobotMap.p_xbox1);
	Joystick xbox2 = new Joystick(RobotMap.p_xbox2);
	Joystick buttonBox = new Joystick(RobotMap.p_buttonBox);
	Joystick buttonBox2 = new Joystick(RobotMap.p_buttonBox2);
	
//	Controller 1
	Button a1 = new JoystickButton(xbox1, 1);
	Button b1 = new JoystickButton(xbox1, 2);
	Button x1 = new JoystickButton(xbox1, 3);
	Button y1 = new JoystickButton(xbox1, 4);
	
	XboxTrigger lTrig1 = new XboxTrigger(xbox1, 2);
	XboxTrigger rTrig1 = new XboxTrigger(xbox1, 3);
	Button lBump1 = new JoystickButton(xbox1, 5);
	Button rBump1 = new JoystickButton(xbox1, 6);
	
//	Controller 2
	Button a2 = new JoystickButton(xbox2, 1);
	Button b2 = new JoystickButton(xbox2, 2);
	Button x2 = new JoystickButton(xbox2, 3);
	Button y2 = new JoystickButton(xbox2, 4);
	
	Button start = new JoystickButton(xbox2, 8);
	
	Button lBump2 = new JoystickButton(xbox2, 5);
	Button rBump2 = new JoystickButton(xbox2, 6);
	XboxTrigger lTrig2 = new XboxTrigger(xbox2, 2);
	XboxTrigger rTrig2 = new XboxTrigger(xbox2, 3);
	
	Button clickRight2 = new JoystickButton(xbox2, 10);
	
//	Button bOx
	Button bb1 = new JoystickButton(buttonBox, 6);
	Button bb2 = new JoystickButton(buttonBox, 4);
	Button bb3 = new JoystickButton(buttonBox, 2);
	Button bb4 = new JoystickButton(buttonBox, 5);
	Button bb5 = new JoystickButton(buttonBox, 3);
	Button bb6 = new JoystickButton(buttonBox, 1);
	Button bb7 = new JoystickButton(buttonBox, 7);
	Button bb8 = new JoystickButton(buttonBox, 9);
	Button bb9 = new JoystickButton(buttonBox, 8);
	
//	button Box 2
	Button bb21 = new JoystickButton(buttonBox2, 3);
	Button bb22 = new JoystickButton(buttonBox2, 12);
	Button bb23 = new JoystickButton(buttonBox2, 15);
	Button bb24 = new JoystickButton(buttonBox2, 6);
	Button bb25 = new JoystickButton(buttonBox2, 9);
	Button bb26 = new JoystickButton(buttonBox2, 2);
	Button bb27 = new JoystickButton(buttonBox2, 13);
	Button bb28 = new JoystickButton(buttonBox2, 16);
	Button bb29 = new JoystickButton(buttonBox2, 5);
	Button bb210 = new JoystickButton(buttonBox2, 10);
	Button bb211 = new JoystickButton(buttonBox2, 4); 
	Button bb212 = new JoystickButton(buttonBox2, 11);
	Button bb213 = new JoystickButton(buttonBox2, 14);
	Button bb214 = new JoystickButton(buttonBox2, 7);
	Button bb215 = new JoystickButton(buttonBox2, 8);
	
	public OI() {
		bb21.whenPressed(new IntakeGear());
		bb22.whileHeld(new SpitGear());
		
		bb24.whenPressed(new IntakePID(Robot.intake.bottomPos)); 
		bb25.whenPressed(new IntakePID(Robot.intake.spitPos));
		bb29.whenPressed(new IntakePID(Robot.intake.intakePos));
		bb210.whenPressed(new IntakePID(Robot.intake.tuckPos));
		bb28.whileHeld(new Convey(.6));
		bb211.whileHeld(new Climb());
		bb214.whileHeld(new IntakeUp());
		bb215.whileHeld(new IntakeDown());
		
		a1.whileHeld(new Climb());
		x1.whileHeld(new Convey(.6));
		y1.whileHeld(new ManualShoot(-.675, .7));
		
		rTrig1.whenPressed(new NoOmnis());
		rBump1.whenPressed(new AllOmnis());
		lBump1.whenPressed(new ShiftHigh());
		lTrig1.whenPressed(new ShiftLow());
		
		bb8.whileHeld(new SpitGear());
		bb6.whileHeld(new IntakeDown());
		bb3.whileHeld(new IntakeUp());
		bb9.whenPressed(new IntakeGear());
		bb1.whenPressed(new IntakePID(Robot.intake.bottomPos)); 
		bb2.whenPressed(new IntakePID(Robot.intake.intakePos));
		bb4.whenPressed(new IntakePID(Robot.intake.spitPos));
		bb5.whenPressed(new IntakePID(Robot.intake.tuckPos));
		bb7.whileHeld(new ShootAndConvey()); //may be problematic
		
	}
	
	public double getLeftJoystick() {
		return xbox1.getRawAxis(1);
	}
	
	public double getRightJoystick() {
		return xbox1.getRawAxis(4);
	}
}
