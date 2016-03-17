package org.usfirst.frc.team2976.robot.commands;

import org.usfirst.frc.team2976.robot.OI;
import org.usfirst.frc.team2976.robot.subsystems.ArmMotors;
import org.usfirst.frc.team2976.robot.subsystems.LeftEncoderPIDSource;
import org.usfirst.frc.team2976.robot.subsystems.RightEncoderPIDSource;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class VelocityArm extends Command {
	public static ArmMotors armMotors = new ArmMotors();

	public VelocityArm() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(armMotors);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
    	if(Math.abs(OI.Axis.LY.getAxisNumber()) <= 0.2)
    	{
    		ArmMotors.leftArm.enableBrakeMode(true);
    		ArmMotors.rightArm.enableBrakeMode(true);
    	}	else	{ 
    		ArmMotors.leftArm.enableBrakeMode(false);
    		ArmMotors.rightArm.enableBrakeMode(false);	
    	}
		ArmMotors.leftArm.set(OI.otherStick.getRawAxis(-OI.Axis.LY.getAxisNumber()));
		ArmMotors.rightArm.set(OI.otherStick.getRawAxis(OI.Axis.LY.getAxisNumber()));

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
