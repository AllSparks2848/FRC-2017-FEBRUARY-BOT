package org.usfirst.frc.team2852.robot;



import org.spectrum3847.RIOdroid.RIOdroid;
import org.usfirst.frc.team2852.robot.subsystems.AutonSelector;
import org.usfirst.frc.team2852.robot.subsystems.Climber;
import org.usfirst.frc.team2852.robot.subsystems.Conveyor;
import org.usfirst.frc.team2852.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2852.robot.subsystems.Intake;
import org.usfirst.frc.team2852.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.RobotState;
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
	public static AutonSelector autonselector = new AutonSelector();
	

	
	//public static Preferences prefs;
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
		SmartDashboard.putData(Scheduler.getInstance());
		Robot.drivetrain.leftEncoder.setDistancePerPulse(.0493);
    	Robot.drivetrain.rightEncoder.setDistancePerPulse(.0488);
    	//camera code added 2/21 7pm
    	
    	//CameraServer server = CameraServer.getInstance();  //cbc
    	//server.startAutomaticCapture();
    	
    	Robot.drivetrain.gyro.zeroYaw();
    	
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
			autonomousCommand = autonselector.getAutoCommand();
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
	
	}

	@Override
	public void teleopInit() {
		if(autonomousCommand.isRunning())
			autonomousCommand.cancel();
		
		drivetrain.gyroController.disable();
		
		//Scheduler.getInstance().add(new ZeroIntake());
		Robot.drivetrain.leftEncoder.setDistancePerPulse(.0493); 
    	Robot.drivetrain.rightEncoder.setDistancePerPulse(.0488);
    	Robot.drivetrain.leftEncoder.reset(); 
    	Robot.drivetrain.rightEncoder.reset();
    	Robot.drivetrain.gyro.zeroYaw();
	}

	@Override
	public void teleopPeriodic() {
		if(Math.abs(oi.getLeftJoystick())>.05 || Math.abs(oi.getRightJoystick())>.05)
			drivetrain.arcadeDrive(oi.getLeftJoystick(), oi.getRightJoystick());
		
		SmartDashboard.putData("PID Controller", drivetrain.getPIDController());
		SmartDashboard.putData("Gyro PID Controller", drivetrain.gyroController);
		SmartDashboard.putBoolean("Photogate", intake.isPhotoGateBroken());
		SmartDashboard.putBoolean("Beam Broken", intake.isBeamBroken());
		SmartDashboard.putNumber("Current Enc val", Intake.intakeEnc.get());
		SmartDashboard.putNumber("Left Encoder Val", drivetrain.leftEncoder.getDistance());
		SmartDashboard.putNumber("Right Encoder Val", drivetrain.rightEncoder.getDistance());
		SmartDashboard.putNumber("Back Shooter RPM", Shooter.shooterBackEnc.getRate());
		SmartDashboard.putNumber("Front Shooter RPM", Shooter.shooterFrontEnc.getRate());
		SmartDashboard.putNumber("Gyro Angle", Robot.drivetrain.gyro.getYaw());
		
		SmartDashboard.putNumber("GyroPID Output", drivetrain.gyroController.get());
//		SmartDashboard.putNumber("Angle Setpoint", drivetrain.gyroController.getSetpoint());
		
		SmartDashboard.putNumber("Low Pressure Value", drivetrain.getLowPressure());
		SmartDashboard.putNumber("High Pressure Value", drivetrain.getHighPressure());
		
		
		
//		if(Robot.intake.isBeamBroken())
//			output1 = true;
//		
//		out1.set(output1);
//		out2.set(false); //extra 2 options built in
		
		Scheduler.getInstance().run();
	}
	
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
