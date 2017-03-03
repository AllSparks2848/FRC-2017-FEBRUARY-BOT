package org.usfirst.frc.team2852.autonCommands;







import org.usfirst.frc.team2852.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
*
*/
public class VisionTurn extends Command {
	Timer timer;
	double gain = 2.0;
	double tol = .01;
	

	
   public VisionTurn() {
       // Use requires() here to declare subsystem dependencies
       // eg. requires(chassis);
   	requires(Robot.drivetrain);
   	 timer = new Timer();
   	
   }

   // Called just before this Command runs the first time
   protected void initialize() {
	   
	   timer.reset();
	   timer.start();
   
   	
   }

   // Called repeatedly when this Command is scheduled to run
   protected void execute() {
	   
	   SmartDashboard.putNumber("Vision x", Robot.x);
	   SmartDashboard.putNumber("Gain", gain);
	   SmartDashboard.putNumber("Tolerance", tol);
	   
	   System.out.println(Robot.x);
	   
	   if(timer.get()<1){
	   
	   
	   
	   if(Robot.x<-.02){
		  
		   Robot.drivetrain.leftDrive1.set((tol+Robot.x)*gain);
		   Robot.drivetrain.leftDrive2.set((tol+Robot.x)*gain);
		   Robot.drivetrain.leftDrive3.set((tol+Robot.x)*gain);
		   Robot.drivetrain.rightDrive1.set((tol+Robot.x)*gain);
		   Robot.drivetrain.rightDrive2.set((tol+Robot.x)*gain);
		   Robot.drivetrain.rightDrive3.set((tol+Robot.x)*gain);
		   System.out.println(.01-Robot.x);
	   }
	   
	   if(Robot.x>.02){
		   Robot.drivetrain.leftDrive1.set((Robot.x-tol)*gain);
		   Robot.drivetrain.leftDrive2.set((Robot.x-tol)*gain);
		   Robot.drivetrain.leftDrive3.set((Robot.x-tol)*gain);
		   Robot.drivetrain.rightDrive1.set((Robot.x-tol)*gain);
		   Robot.drivetrain.rightDrive2.set((Robot.x-tol)*gain);
		   Robot.drivetrain.rightDrive3.set((Robot.x-tol)*gain);
		   System.out.println(Robot.x-tol);
	   }
	   
	   }
   }
	  
	   
   	
   	
		
   

   // Make this return true when this Command no longer needs to run execute()
   protected boolean isFinished() {
	if (timer.get()>1){
		return true;
	}
	else return false;
   }
	

   // Called once after isFinished returns true
   protected void end() {
   	
   	Robot.drivetrain.leftDrive1.set(0);  
   	Robot.drivetrain.leftDrive2.set(0);
   	Robot.drivetrain.leftDrive3.set(0);
   	
   	Robot.drivetrain.rightDrive1.set(0);
   	Robot.drivetrain.rightDrive2.set(0);
   	Robot.drivetrain.rightDrive3.set(0);
   }

   // Called when another command which requires one or more of the same
   // subsystems is scheduled to run
   protected void interrupted() {
   	end();
   }
}
