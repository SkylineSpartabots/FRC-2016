package org.usfirst.frc.team2976.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team2976.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
/**
 *@author NeilHazra
 */
public class ArmLimitSwitches extends Subsystem {
    public static DigitalInput high_switch = new DigitalInput(RobotMap.ArmSwitch);
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

