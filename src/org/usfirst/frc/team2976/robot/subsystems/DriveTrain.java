
package org.usfirst.frc.team2976.robot.subsystems;

import org.usfirst.frc.team2976.robot.RobotMap;
import org.usfirst.frc.team2976.robot.utilities.XBoxController;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
	
	CANTalon m_rightFrontMotor;  
	CANTalon m_leftFrontMotor; 
	CANTalon m_rightBackMotor;
	CANTalon m_leftBackMotor;
 
	AnalogGyro m_gyro;
	
	RobotDrive m_drive;

	public DriveTrain(){
		m_rightFrontMotor = new CANTalon(RobotMap.RightFrontDriveMotor);
		m_leftFrontMotor = new CANTalon(RobotMap.LeftFrontDriveMotor);
		m_rightBackMotor = new CANTalon(RobotMap.RightBackDriveMotor);
		m_leftBackMotor = new CANTalon(RobotMap.LeftBackDriveMotor);
		
		m_gyro = new AnalogGyro(RobotMap.GyroInput);
		
		m_drive = new RobotDrive(m_leftFrontMotor, m_leftBackMotor,
				m_rightFrontMotor, m_rightBackMotor);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void resetDirection(){
    	m_gyro.reset();
    }
    
    public double getDirection(){
    	return m_gyro.getAngle();
    }
    
    public void arcadeDrive (XBoxController joy){
    	
    }
}

