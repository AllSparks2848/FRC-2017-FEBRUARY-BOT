package org.usfirst.frc.team2852.robot.subsystems;

import org.usfirst.frc.team2852.robot.Robot;
import org.usfirst.frc.team2852.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class Shooter extends PIDSubsystem {
	public static double p = .4;
	public static double i = 0.1;
	public static double d = 0;
    public static Spark shooterBack = new Spark(RobotMap.p_shooterBack);
    public static Spark shooterFront = new Spark(RobotMap.p_shooterFront);
    
    public static Encoder shooterFrontEnc = new Encoder(RobotMap.p_shooterFrontEncA, RobotMap.p_shooterFrontEncB);
    public static Encoder shooterBackEnc = new Encoder(RobotMap.p_shooterBackEncA, RobotMap.p_shooterBackEncB);
    
    private double gain = 1;
    
    public Timer shootTime = new Timer();
    

	public Shooter() {
    	super("Shooter", p, i, d);
    }

    public void initDefaultCommand() {
    }

    protected double returnPIDInput() {
        return shooterBackEnc.getRate();
    }

    protected void usePIDOutput(double output) {
    	shooterFront.set(output);
    	shooterBack.set(output*gain);
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
