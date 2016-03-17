
package org.usfirst.frc.team2976.robot.commands;

import org.usfirst.frc.team2976.robot.OI;
import org.usfirst.frc.team2976.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

//import org.usfirst.frc.team2976.robot.Robot;

/**
 * @author Jasmine Cheng
 * @author NeilHazra
 */
public class DriveBOT extends Command {
	public static DriveTrain drivetrain = new DriveTrain();
	
	public static LeftDriveEncoder driveEncoder = new LeftDriveEncoder();
	
	boolean isbraked = false;

	public DriveBOT() {
		// Use requires() here to declare subsystem dependencies
		requires(drivetrain);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}
	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double joystick_value = OI.driveStick.getLY();
		if (Math.abs(joystick_value) < 0.2) {
			joystick_value = 0;
		}
		if (OI.driveStick.getRawButton(OI.Button.A.getBtnNumber()) && !isbraked) {
			DriveTrain.leftBackMotor.enableBrakeMode(true);
			DriveTrain.rightBackMotor.enableBrakeMode(true);
			DriveTrain.leftFrontMotor.enableBrakeMode(true);
			DriveTrain.rightFrontMotor.enableBrakeMode(true);
		}
		if (!OI.driveStick.getRawButton(OI.Button.A.getBtnNumber())) {
			if (isbraked) {
				DriveTrain.leftBackMotor.enableBrakeMode(false);
				DriveTrain.rightBackMotor.enableBrakeMode(false);
				DriveTrain.leftFrontMotor.enableBrakeMode(false);
				DriveTrain.rightFrontMotor.enableBrakeMode(false);
			} else {
				DriveTrain.m_drive.arcadeDrive(-joystick_value, -OI.driveStick.getRX(), true);
			}
		}
		SmartDashboard.putNumber("DriveEncoder", driveEncoder.motor1position);
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
