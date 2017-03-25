package org.usfirst.frc.team2852.robot;






import org.spectrum3847.RIOdroid.RIOdroid;
import org.usfirst.frc.team2852.autonCommands.BP1Shoot;
import org.usfirst.frc.team2852.autonCommands.BluePosition1;
import org.usfirst.frc.team2852.autonCommands.BluePosition3;
import org.usfirst.frc.team2852.autonCommands.CrossBaseline;
import org.usfirst.frc.team2852.autonCommands.DoNothing;
import org.usfirst.frc.team2852.autonCommands.MiddleAuton;
import org.usfirst.frc.team2852.autonCommands.RP3Shoot;
import org.usfirst.frc.team2852.autonCommands.RedPosition1;
import org.usfirst.frc.team2852.autonCommands.RedPosition3;
import org.usfirst.frc.team2852.autonCommands.ShootAuton;
import org.usfirst.frc.team2852.robot.subsystems.AutonSelector;
import org.usfirst.frc.team2852.robot.subsystems.Climber;
import org.usfirst.frc.team2852.robot.subsystems.Conveyor;
import org.usfirst.frc.team2852.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2852.robot.subsystems.Intake;
import org.usfirst.frc.team2852.robot.subsystems.Shooter;
import org.usfirst.frc.team2852.robot.util.VisionTable;
import org.usfirst.frc.team2852.robot.vision.TestUpdateReceiver;
import org.usfirst.frc.team2852.robot.vision.VisionServer;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
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
	public static double x=0.0;
	public static double distance=0.0;
	public static double xValOdtih = 0;
	public static Command autonomousCommand;
	
	public static DriveTrain drivetrain = new DriveTrain();
	public static Intake intake = new Intake();
	public static Shooter shooter = new Shooter();
	public static Conveyor conveyor = new Conveyor();
	public static Climber climber = new Climber();
	public static VisionTable visiontable = new VisionTable();
	
	public static Logger logger;
	public static VisionServer visionServer;

	public static TestUpdateReceiver testUpdateReceiver;
    public static FileIO fileIO = new FileIO();
    private int LOGGER_LEVEL = 5;
    boolean useConsole = true, useFile = false;
    
    public int autoNum;
    
    public PowerDistributionPanel pdp = new PowerDistributionPanel();
	public boolean isLowVoltage = false;
    
	//public static Preferences prefs;
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
		 logger = new Logger(useConsole, useFile, LOGGER_LEVEL);
		        visionServer = VisionServer.getInstance();
		        testUpdateReceiver = new TestUpdateReceiver();
		        visionServer.addVisionUpdateReceiver(testUpdateReceiver);
		     
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
		autoNum = getAutoNum();
		setAutoCommand();
			if(!autonomousCommand.equals(null))
				autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		
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
		
		
		SmartDashboard.putBoolean("Photogate", intake.isPhotoGateBroken());
		SmartDashboard.putBoolean("Beam Broken", intake.isBeamBroken());
		SmartDashboard.putNumber("Current Enc val", Intake.intakeEnc.get());
//		
		SmartDashboard.putNumber("Gyro Angle", Robot.drivetrain.gyro.getYaw());
		SmartDashboard.putNumber("Low Pressure Value", drivetrain.getLowPressure());
		SmartDashboard.putNumber("High Pressure Value", drivetrain.getHighPressure());
		
		SmartDashboard.putNumber("Encoder Left", Robot.drivetrain.leftEncoder.getDistance());
		SmartDashboard.putNumber("Encoder Right", Robot.drivetrain.rightEncoder.getDistance());
		SmartDashboard.putNumber("Back RPM", Shooter.shooterBackEnc.getRate());
		SmartDashboard.putNumber("Front RPM", Shooter.shooterFrontEnc.getRate());
		
		if(pdp.getVoltage()<7.5)
			isLowVoltage = true;
		else
			isLowVoltage = false;
		SmartDashboard.putBoolean("Voltage", isLowVoltage);
		
		
		
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
	
	DigitalInput autoSelect1 = new DigitalInput(RobotMap.p_autoSelect1);
    DigitalInput autoSelect2 = new DigitalInput(RobotMap.p_autoSelect2);
    DigitalInput autoSelect3 = new DigitalInput(RobotMap.p_autoSelect3);
    DigitalInput autoSelect4 = new DigitalInput(RobotMap.p_autoSelect4);
    
    public int getAutoNum() {
    	if(autoSelect1.get()){ //true
    		if(autoSelect2.get()) { //true-true
    			if(autoSelect3.get()) { //true-true-true
    				return 7;
    			}
    			else { //true-true-false
    				return 6;
    			}
    		}
    		else { //true-false
    			if(autoSelect3.get()) { //true-false-true
    				return 3;
    			}
    			else { //true-false-false
    				return 2;
    			}
    		}
    	}
    	else { //false
    		if(autoSelect2.get()) { //false-true
    			if(autoSelect3.get()) { //false-true-true
    				return 5;
    			}
    			else { //false-true-false
    				return 4;
    			}
    		}
    		else { //false-false
    			if(autoSelect3.get()) { //false-false-true
    				if(autoSelect4.get()) { //false-false-true-true
    					return 9;
    				}
    				else { //false-false-true-false
    					return 1;
    				}
    			}
    			else { //false-false-false
    				if(autoSelect4.get()) {
    					return 8;
    				}
    				else {
    					return 0;
    				}
    			}
    		}
    	}
    }
    
    public void setAutoCommand() {
    	Command autonCommand = new MiddleAuton();
        switch(autoNum) {
        case 0: autonCommand = new RedPosition1();
        	break;
        case 1: autonCommand = new MiddleAuton();
    	break;
        case 2: autonCommand = new RedPosition3();
    	break;
        case 3: autonCommand = new BluePosition1();
    	break;
        case 4: autonCommand = new MiddleAuton();
    	break;
        case 5: autonCommand = new BluePosition3();
    	break;
        case 6: autonCommand = new CrossBaseline();
    	break;
        case 7: autonCommand = new ShootAuton();
    	break;
        case 8: autonCommand = new RP3Shoot();
    	break;
        case 9: autonCommand = new BP1Shoot();
    	break;
        }
        autonomousCommand = autonCommand;
    }
}
