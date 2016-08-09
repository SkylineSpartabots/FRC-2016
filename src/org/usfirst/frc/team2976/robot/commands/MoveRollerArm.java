package org.usfirst.frc.team2976.robot.commands;

import org.usfirst.frc.team2976.robot.OI;
import org.usfirst.frc.team2976.robot.Robot;
import org.usfirst.frc.team2976.robot.subsystems.PIDMain;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author NeilHazra
 */
public class MoveRollerArm extends Command {
	public MoveRollerArm() {
		requires(Robot.rollerArm);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		double x = OI.otherStick.getRawAxis(OI.Axis.LY.getAxisNumber()) / 3;
		Robot.rollerArm.setArm(x);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	protected boolean isFinished() {
		return true;
	}

	protected void end() {

	}

	protected void interrupted() {

	}
}
