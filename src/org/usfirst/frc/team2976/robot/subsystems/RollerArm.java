package org.usfirst.frc.team2976.robot.subsystems;

import org.usfirst.frc.team2976.robot.RobotMap;
import org.usfirst.frc.team2976.robot.commands.MoveRollerArm;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class RollerArm extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private Talon roller = new Talon(RobotMap.rollerMotorID);
	private CANTalon rightArm = new CANTalon(RobotMap.RightArmMotor); //Talon Object
	private CANTalon leftArm = new CANTalon(RobotMap.LeftArmMotor);	 //Talon Object

	public void setArm(double power)	{
		rightArm.set(-power);
		leftArm.set(power);
	}
	public void enableBrake(boolean isBraked)	{
		rightArm.enableBrakeMode(isBraked);
		leftArm.enableBrakeMode(isBraked);
	}
    public void setRollerPower(double value){
    	roller.set(value);
    }
    public void rollerIn(){
    	roller.set(0.75);
    }
    
    public void rollerOut(){
    	roller.set(-0.75);
    }
    
    public void rollerStop(){
    	roller.set(0);
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new MoveRollerArm());
    }
}

