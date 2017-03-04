package org.usfirst.frc.team2852.robot.util;

public class VisionTable {
	
	double[] visionArr = {0,1,2,3,4,5,6,7,8,9,10,11,12};
	

	public int getIndex(double robotX) {
		int index = 0;
		double rawIndex;
		rawIndex = 20*robotX +6;
		index = (int) Math.round(rawIndex);
		return index;
	}
	
	public double getAngleToTurn(int index) {
		return visionArr[index];
	}
}
