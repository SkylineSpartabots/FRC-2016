package org.usfirst.frc.team2976.robot.commands;

import org.usfirst.frc.team2976.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RollOut extends Command {
	final long runTime = 500;
	long startingTime = 0;
	
    public RollOut() {
    	requires(Robot.rollerArm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	startingTime = System.currentTimeMillis();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.rollerArm.rollerOut();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (System.currentTimeMillis()-startingTime>runTime);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.rollerArm.rollerStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
