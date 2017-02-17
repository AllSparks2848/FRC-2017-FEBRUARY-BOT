package org.usfirst.frc.team2852.robot;

import org.usfirst.frc.team2852.robot.subsystems.Climber;
import org.usfirst.frc.team2852.robot.subsystems.Conveyor;
import org.usfirst.frc.team2852.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2852.robot.subsystems.Intake;
import org.usfirst.frc.team2852.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	public static OI oi;
	public static RobotMap robot = new RobotMap();

	Command autonomousCommand;

	public static DriveTrain drivetrain = new DriveTrain();
	public static Intake intake = new Intake();
	public static Shooter shooter = new Shooter();
	public static Conveyor conveyor = new Conveyor();
	public static Climber climber = new Climber();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		//autonomousCommand = new AutonGearLeft();
		oi = new OI();
		SmartDashboard.putData(Scheduler.getInstance());
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		// schedule the autonomous command (example)
			
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
	
	}

	@Override
	public void teleopInit() {
			
	}

	@Override
	public void teleopPeriodic() {
		System.out.println("\n");
		SmartDashboard.putNumber("Current Enc val", Intake.intakeEnc.get());
//		SmartDashboard.putNumber("LD1", Robot.drivetrain.leftDrive1.get());
//		SmartDashboard.putNumber("LD2", Robot.drivetrain.leftDrive2.get());
//		SmartDashboard.putNumber("LD3", Robot.drivetrain.leftDrive3.get());
//		SmartDashboard.putNumber("RD1", Robot.drivetrain.rightDrive1.get());
//		SmartDashboard.putNumber("RD2", Robot.drivetrain.rightDrive2.get());
//		SmartDashboard.putNumber("RD3", Robot.drivetrain.rightDrive3.get());
		
		Scheduler.getInstance().run();
	}
	
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
