package org.usfirst.frc.team2852.robot.subsystems;

import org.usfirst.frc.team2852.robot.Robot;
import org.usfirst.frc.team2852.robot.RobotMap;
import edu.wpi.first.wpilibj.AnalogInput;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class Intake extends PIDSubsystem {
	public static double p = .03;
	public static double i = 0.01;
	public static double d = 0;
	public int bottomPos = 0;
	public int intakePos = 1;
	public int spitPos = 74;
	public int tuckPos = 102;
	public PowerDistributionPanel pdp = new PowerDistributionPanel();
	public Spark intakeRoller = new Spark(RobotMap.p_intakeRoller);
	public Spark intakePivot = new Spark(RobotMap.p_intakePivot);
	DigitalInput breakbeam = new DigitalInput(RobotMap.p_breakbeam);
	public static Encoder intakeEnc = new Encoder(RobotMap.p_intakeEncA, RobotMap.p_intakeEncB, false,
			EncodingType.k4X);

	public final int INTAKE_OFFSET = 1;
	public final int SPIT_OFFSET = 74;
	public final int TUCK_OFFSET = 102;

	public Timer timer = new Timer();

	public Intake() {
		super("Intake", p, i, d);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	protected double returnPIDInput() {
		// Return your input value for the PID loop
		// e.g. a sensor, like a potentiometer:
		// yourPot.getAverageVoltage() / kYourMaxVoltage;
		return Intake.intakeEnc.get();
	}

	protected void usePIDOutput(double output) {
		intakePivot.set(-output);
	}

	public void intake(double speed) {
		intakeRoller.set(speed);
	}

	public void stopIntake() {
		intakeRoller.set(0);
	}

	public void stopActuate() {
		intakePivot.set(0);
	}

	public void actuate(double speed) {
		intakePivot.set(speed);
	}

	public boolean isBeamBroken() {
		return breakbeam.get();
	}

	public double getPivot() {
		return intakePivot.get();
	}

	public double getBottomPos() {
		return bottomPos;
	}

	public void setBottomPos() {
		bottomPos = intakeEnc.get();
		intakePos = bottomPos + INTAKE_OFFSET;
		spitPos = bottomPos + SPIT_OFFSET;
		tuckPos = bottomPos + TUCK_OFFSET;
	}

	public double getIntakePos() {
		return intakePos;
	}

	public double getSpitPos() {
		return spitPos;
	}

	public double getTuckPos() {
		return tuckPos;
	}
}
