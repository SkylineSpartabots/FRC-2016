package org.usfirst.frc.team2976.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2976.robot.subsystems.ArmLimitSwitches;
/**
 *
 */
public class ArmSwitchNotifier extends Command {
	ArmLimitSwitches armLimitSwitches = new ArmLimitSwitches();
	
    public ArmSwitchNotifier() {
    	requires(armLimitSwitches);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(ArmLimitSwitches.high_switch.get())	{
    		SmartDashboard.putString("Limit Switch Pressed?", "PRESSED! PRESSED!");
    	}	else if (!ArmLimitSwitches.high_switch.get()){
    		SmartDashboard.putString("Limit Switch Pressed?", "NOT PRESSED! NOT PRESSED!");
    	}
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
    	//this.end();
    }
}
