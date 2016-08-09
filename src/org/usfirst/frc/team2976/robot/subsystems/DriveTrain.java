package org.usfirst.frc.team2976.robot.subsystems;

import org.usfirst.frc.team2976.robot.RobotMap;
import org.usfirst.frc.team2976.robot.commands.DriveBOT;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;

import org.usfirst.frc.team2976.robot.override.TankDrivePlus;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author NeilHazra
 */
public class DriveTrain extends Subsystem {
	private CANTalon rightFrontMotor;
	private CANTalon leftFrontMotor; // Talon Object
	private CANTalon rightBackMotor; // Talon Object
	private CANTalon leftBackMotor; // Talon Object

	// public TankDrivePlus m_drive = new TankDrivePlus(leftBackMotor,
	// leftFrontMotor,rightBackMotor, rightFrontMotor); //Robot Drive Class
	private RobotDrive m_drive = new RobotDrive(leftBackMotor, leftFrontMotor, rightBackMotor, rightFrontMotor);

	public DriveTrain() {
		super();
		rightFrontMotor = new CANTalon(RobotMap.RightFrontDriveMotor);
		leftFrontMotor = new CANTalon(RobotMap.LeftFrontDriveMotor); // Talon
																		// Object
		rightBackMotor = new CANTalon(RobotMap.RightBackDriveMotor); // Talon
																		// Object
		leftBackMotor = new CANTalon(RobotMap.LeftBackDriveMotor); // Talon
																	// Object
		m_drive = new RobotDrive(leftBackMotor, leftFrontMotor, rightBackMotor, rightFrontMotor);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new DriveBOT());
	}

	public void setLeft(double speed) {
		leftBackMotor.set(speed);
		leftFrontMotor.set(speed);
	}

	public void setRight(double speed) {
		rightBackMotor.set(-speed);
		rightFrontMotor.set(-speed);
	}

	public void setZero() {
		rightFrontMotor.set(0);
		leftFrontMotor.set(0);
		rightBackMotor.set(0);
		leftBackMotor.set(0);
	}

	public void Break() {
		leftBackMotor.enableBrakeMode(true);
		leftFrontMotor.enableBrakeMode(true);
		rightBackMotor.enableBrakeMode(true);
		rightFrontMotor.enableBrakeMode(true);
	}

	public void releaseBreak() {
		leftBackMotor.enableBrakeMode(false);
		leftFrontMotor.enableBrakeMode(false);
		rightBackMotor.enableBrakeMode(false);
		rightFrontMotor.enableBrakeMode(false);
	}

	public void arcadeDrive(double power, double turn) {
		m_drive.arcadeDrive(power, turn, true);
	}
}
