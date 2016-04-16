
package org.usfirst.frc.team2976.robot.subsystems;

import org.usfirst.frc.team2976.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends Subsystem {
    CANTalon m_rightArmMotor;
    CANTalon m_leftArmMotor;
    
    CANTalon m_roller;
    
    public Arm(){
    	m_rightArmMotor = new CANTalon (RobotMap.RightArmMotor);
    	m_leftArmMotor = new CANTalon (RobotMap.LeftArmMotor);
    	
    	m_roller = new CANTalon (RobotMap.rollerMotorID);
    }
    public void armUp(){
    	m_rightArmMotor.set(1);
    	m_leftArmMotor.set(1);
    }
  
    public void armDown(){
    	m_rightArmMotor.set(-1);
    	m_leftArmMotor.set(-1);
    }
    
    public void armStop(){
    	m_rightArmMotor.set(0);
    	m_leftArmMotor.set(0);
    }
    
    public void rollerIn(){
    	m_roller.set(1);
    }
    
    public void rollerOut(){
    	m_roller.set(-1);
    }
    
    public void rollerStop(){
    	m_roller.set(0);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

