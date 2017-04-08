package org.usfirst.frc.team2852.robot.util;

public class MotionProfilePoint {
	public double time;
	public double position;
	public double velocity;
	public double acceleration;
	
	public void initialize(double startPosition) {
		time = 0;
		position = startPosition;
		velocity = 0;
		acceleration = 0;
	}
}
