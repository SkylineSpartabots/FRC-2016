package org.usfirst.frc.team2976.robot.commands;

import org.usfirst.frc.team2976.robot.OI;
import org.usfirst.frc.team2976.robot.subsystems.ArmMotors;
import org.usfirst.frc.team2976.robot.subsystems.LeftEncoderPIDSource;
import org.usfirst.frc.team2976.robot.subsystems.PIDMain;
import org.usfirst.frc.team2976.robot.subsystems.RightEncoderPIDSource;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author NeilHazra
 */
public class ArmDynamicSetpointPID extends Command {
	final int ARM_SPEED_REDUCER = 4;
	int ArmMinEncoderValue = -100;
	int ArmMaxEncoderValue = 600;
	double x = 0;
	final int sampleTime = 100;

	/** Proportional gain */
	final double kp = 0.007;
	/** Integral Gain */
	final double ki = 0.000;
	/** Derivative Gain */
	final double kd = 0.0;

	double min = -0.33;/// ARM_SPEED_REDUCER; //Divide by how much slower you
						/// want the max speed
	double max = 0.33;/// ARM_SPEED_REDUCER;

	final int centerValue = 0; // Place Holding Variable
	public static ArmMotors armMotors = new ArmMotors();
	public static LeftEncoderPIDSource leftEncoderPIDSource = new LeftEncoderPIDSource();
	public static RightEncoderPIDSource rightEncoderPIDSource = new RightEncoderPIDSource();
	// public static ArmLimitSwitches armSwitch = new ArmLimitSwitches();
	public PIDMain leftArmDynamicPID = new PIDMain(leftEncoderPIDSource, centerValue, sampleTime, kp, ki, kd);
	public PIDMain rightArmDynamicPID = new PIDMain(rightEncoderPIDSource, centerValue, sampleTime, kp, ki, kd);

	public ArmDynamicSetpointPID() {
		requires(armMotors);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		leftEncoderPIDSource.reset();
		rightEncoderPIDSource.reset();

		leftArmDynamicPID.isEnabled(true);
		rightArmDynamicPID.isEnabled(true);

		leftArmDynamicPID.setOutputLimits(min, max);
		rightArmDynamicPID.setOutputLimits(min, max);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		x = -OI.otherStick.getRawAxis(OI.Axis.LY.getAxisNumber()) / 3;

			ArmMotors.leftArm.set(x);
			ArmMotors.rightArm.set(-x);
		
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {

	}

	protected void interrupted() {
		leftArmDynamicPID.isEnabled(false);
		rightArmDynamicPID.isEnabled(false);
		this.end();
	}
}
