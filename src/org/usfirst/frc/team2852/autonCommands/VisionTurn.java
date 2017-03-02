package org.usfirst.frc.team2852.autonCommands;







import org.usfirst.frc.team2852.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
*
*/
public class VisionTurn extends Command {
	Timer timer;

	
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
	   System.out.println(Robot.x);
	   if(timer.get()<1){
	   
	   
	   
	   if(Robot.x<-.02){
		  
		   Robot.drivetrain.leftDrive1.set((.01+Robot.x)*2);
		   Robot.drivetrain.leftDrive2.set((.01+Robot.x)*2);
		   Robot.drivetrain.leftDrive3.set((.0+Robot.x)*2);
		   Robot.drivetrain.rightDrive1.set((.01+Robot.x)*2);
		   Robot.drivetrain.rightDrive2.set((.01+Robot.x)*2);
		   Robot.drivetrain.rightDrive3.set((.01+Robot.x)*2);
		   System.out.println(.01-Robot.x);
	   }
	   
	   if(Robot.x>.02){
		   Robot.drivetrain.leftDrive1.set((Robot.x-.01)*2);
		   Robot.drivetrain.leftDrive2.set((Robot.x-.01)*2);
		   Robot.drivetrain.leftDrive3.set((Robot.x-.01)*2);
		   Robot.drivetrain.rightDrive1.set((Robot.x-.01)*2);
		   Robot.drivetrain.rightDrive2.set((Robot.x-.01)*2);
		   Robot.drivetrain.rightDrive3.set((Robot.x-.01)*2);
		   System.out.println(Robot.x-.01);
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
