package org.usfirst.frc.team2852.robot.subsystems;

import org.usfirst.frc.team2852.robot.Robot;
import org.usfirst.frc.team2852.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Shooter extends PIDSubsystem {
	public static double p = 0.035; //Robot.prefs.getDouble("kPShoot", .025);
	public static double i = 0.01; //Robot.prefs.getDouble("kIShoot", 0.0);
	public static double d = 0.01; //Robot.prefs.getDouble("kDShoot", 0.0);
	
	public static double targetRPM = 500; //Robot.prefs.getDouble("targetRPM", 500);
	
    public static Spark shooterBack = new Spark(RobotMap.p_shooterBack);
    public static Spark shooterFront = new Spark(RobotMap.p_shooterFront);
    
    public static Encoder shooterFrontEnc = new Encoder(RobotMap.p_shooterFrontEncA, RobotMap.p_shooterFrontEncB);
    public static Encoder shooterBackEnc = new Encoder(RobotMap.p_shooterBackEncA, RobotMap.p_shooterBackEncB);
    
    private double gain = 1.1;
    
    public Timer shootTime = new Timer();
    

	public Shooter() {
    	super("Shooter", p, i, d);
    }

    public void initDefaultCommand() {
    }

    protected double returnPIDInput() {
        return -shooterBackEnc.getRate();
    }

    protected void usePIDOutput(double output) {
    	shooterFront.set(-output*gain);
    	shooterBack.set(output);
    }
    public void setGain(double gain) {
		this.gain = gain;
	}
    
    public void shoot(double powerInner, double powerOuter) {
    	shooterFront.set(powerInner);
    	shooterBack.set(powerOuter);
    }
    
    public void stopShoot() {
    	shooterFront.set(0);
    	shooterBack.set(0);
    }

}
