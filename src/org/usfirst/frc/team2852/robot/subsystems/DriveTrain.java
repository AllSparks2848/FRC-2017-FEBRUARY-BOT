package org.usfirst.frc.team2852.robot.subsystems;

import org.usfirst.frc.team2852.robot.RobotMap;
import org.usfirst.frc.team2852.robot.driveCommands.ArcadeDrive;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class DriveTrain extends PIDSubsystem {
	public Spark leftDrive1 = new Spark(RobotMap.p_leftDrive1);
	public Spark leftDrive2 = new Spark(RobotMap.p_leftDrive2);
	public Spark leftDrive3 = new Spark(RobotMap.p_leftDrive3);
	public Spark rightDrive1 = new Spark(RobotMap.p_rightDrive1);
	public Spark rightDrive2 = new Spark(RobotMap.p_rightDrive2);
	public Spark rightDrive3 = new Spark(RobotMap.p_rightDrive3);
	
	RobotDrive drive1 = new RobotDrive(leftDrive1, leftDrive2, rightDrive1, rightDrive2);
	RobotDrive drive2 = new RobotDrive(leftDrive3, rightDrive3);
	
	DoubleSolenoid frontButterfly = new DoubleSolenoid(RobotMap.p_frontButterfly1, RobotMap.p_frontButterfly2);
	DoubleSolenoid backButterfly = new DoubleSolenoid(RobotMap.p_backButterfly1, RobotMap.p_backButterfly2);
	DoubleSolenoid driveShifter = new DoubleSolenoid(RobotMap.p_driveshifter1, RobotMap.p_driveshifter2);
	
	private static double pDrive = .07;
	private static double iDrive = 0;
	private static double dDrive = .007;
	
//	public static Encoder rightEncoder = new Encoder(RobotMap.p_rightEncoderA, RobotMap.p_rightEncoderB, false, Encoder.EncodingType.k4X);
//	public static Encoder leftEncoder = new Encoder(RobotMap.p_leftEncoderA, RobotMap.p_leftEncoderB, false, Encoder.EncodingType.k4X);
	
    // Initialize your subsystem here
    public DriveTrain() {
    	super("DriveTrain", pDrive, iDrive, dDrive);
//    	leftEncoder.setDistancePerPulse(-0.01057);
//    	rightEncoder.setDistancePerPulse(.01125);
    }

    public void initDefaultCommand() {
         setDefaultCommand(new ArcadeDrive());
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
//        return (leftEncoder.getDistance()+rightEncoder.getDistance())/2;
    	return 0;
    }

    protected void usePIDOutput(double output) {
    	drive1.tankDrive(output, output);
    	drive2.tankDrive(output, output);
    }
    
    public void tankDrive(double left, double right){
    	drive1.tankDrive(left, right);
    	drive2.tankDrive(left, right);
    }
    
    public void arcadeDrive(double left, double right){
    	drive1.arcadeDrive(-left, -right);
    	drive2.arcadeDrive(-left, -right);
    }
    
    public void setPowerZero(){
    	drive1.setLeftRightMotorOutputs(0, 0);;
    	drive2.setLeftRightMotorOutputs(0, 0);
    }
    
    public void frontOmnisDown() {
    	frontButterfly.set(DoubleSolenoid.Value.kForward);
    }
    
    public void backOmnisDown() {
    	backButterfly.set(DoubleSolenoid.Value.kForward);
    }
    
    public void frontAllDown() {
    	frontButterfly.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void backAllDown() {
    	backButterfly.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void shiftHigh() {
    	driveShifter.set(DoubleSolenoid.Value.kForward);
    }
    
    public void shiftLow() {
    	driveShifter.set(DoubleSolenoid.Value.kReverse);
    }
}

