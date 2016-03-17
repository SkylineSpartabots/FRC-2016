package org.usfirst.frc.team2976.robot.commands;

import org.usfirst.frc.team2976.robot.OI;
import org.usfirst.frc.team2976.robot.subsystems.RaiseArmSolenoid;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *@author AjayPai
 */
public class RaiseBackArm extends Command {
	RaiseArmSolenoid raiseArmSolenoid = new RaiseArmSolenoid();
    public RaiseBackArm() {
    	requires(raiseArmSolenoid);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	raiseArmSolenoid.raiseHookMechanism.set(DoubleSolenoid.Value.kOff);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(OI.otherStick.getRawButton(OI.Button.X.getBtnNumber())){
    		raiseArmSolenoid.raiseHookMechanism.set(DoubleSolenoid.Value.kReverse);
    	} else if(OI.otherStick.getRawButton(OI.Button.Y.getBtnNumber()))	{
    		raiseArmSolenoid.raiseHookMechanism.set(DoubleSolenoid.Value.kForward);
    	}	else	{
    		//raiseArmSolenoid.raiseHookMechanism.set(DoubleSolenoid.Value.kOff);
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
    }
}
