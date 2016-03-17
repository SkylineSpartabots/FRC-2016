package org.usfirst.frc.team2976.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2976.robot.OI;
import org.usfirst.frc.team2976.robot.Robot;
import org.usfirst.frc.team2976.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2976.robot.subsystems.GyroPIDSource;
import org.usfirst.frc.team2976.robot.subsystems.HookMotor;
import org.usfirst.frc.team2976.robot.subsystems.PIDMain;

/**
 * @author JasmineCheng
 */
public class AutoDriveStraight extends Command {
	DriveTrain driveTrain = new DriveTrain();
	public GyroPIDSource gyropidsource = new GyroPIDSource(); // Implements
																// PIDSource
	/** Proportional gain */
	double kp = 0.005;
	/** Integral Gain */
	double ki = 0.00;
	//double ki = 0.0001;
	/** Derivative Gain */
	double kd = 0.00;
	//double kd = 0.00003

	int robot_angle_setpoint = 0;

	final int sampleTime = 100;

	public PIDMain RobotAnglePID = new PIDMain(gyropidsource, robot_angle_setpoint, sampleTime, kp, ki, kd);
	// PID controller for Motor 1

	double speed;
	double targetTime;
	int maxCurrent = 25;
	long startingTime = 0;
	
	public AutoDriveStraight(double mSpeed, double mTime) {
		requires(Robot.drivetrain);
		speed = mSpeed;
		targetTime = mTime*1000;

	}

	// Called just before this Command runs the first time
	protected void initialize() {
		gyropidsource.reset();
		startingTime = System.currentTimeMillis();
		RobotAnglePID.isEnabled(true); //
	} 

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {		
			double delta = RobotAnglePID.getOutput();
			
		
			Robot.drivetrain.setLeft(speed -  delta);
			Robot.drivetrain.setRight(speed + delta);
			
			SmartDashboard.putNumber("Left", delta);
			SmartDashboard.putNumber("Right", -delta);
		/*if(DriveTrain.leftBackMotor.getOutputCurrent() > maxCurrent)	{
			DriveTrain.leftBackMotor.set(0);
			DriveTrain.leftFrontMotor.set(0);
			DriveTrain.rightBackMotor.set(0);
			DriveTrain.rightFrontMotor.set(0);
		}	else	{
			DriveTrain.leftBackMotor.set(speed);
			DriveTrain.leftFrontMotor.set(speed);
			DriveTrain.rightBackMotor.set(speed);
			DriveTrain.rightFrontMotor.set(speed);
		}
		SmartDashboard.putNumber("DriveCurrent", DriveTrain.leftBackMotor.getOutputCurrent());
		*/
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return (System.currentTimeMillis()-startingTime>targetTime);
	}

	// Called once after isFinished returns true
	protected void end() {
		DriveTrain.leftBackMotor.set(0);
		DriveTrain.leftFrontMotor.set(0);
		DriveTrain.rightBackMotor.set(0);
		DriveTrain.rightFrontMotor.set(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}