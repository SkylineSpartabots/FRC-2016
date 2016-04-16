
package org.usfirst.frc.team2976.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2976.robot.OI;
import org.usfirst.frc.team2976.robot.Robot;

/**
 *
 */
public class MoveArm extends Command {
	boolean m_up;
    public MoveArm(boolean up) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.arm);
        m_up = up;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (m_up){
    		Robot.arm.armUp();
    	} else {
    		Robot.arm.armDown();
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.arm.armStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
