package org.usfirst.frc.team2976.robot.subsystems;

import org.usfirst.frc.team2976.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {
    private CANTalon backArmMotor = new CANTalon(RobotMap.RaiseHookMotor);
    private DoubleSolenoid hookSolenoid = new DoubleSolenoid(RobotMap.RaiseHookSolenoid1,RobotMap.RaiseHookSolenoid2);
	private CANTalon liftingMotorA = new CANTalon(RobotMap.PickUpRobotA);
	private CANTalon liftingMotorB = new CANTalon(RobotMap.PickUpRobotB);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public void setArmExtendPower(double power)	{
		backArmMotor.set(power);
	}
	public void armSolenoidUp()	{
		hookSolenoid.set(DoubleSolenoid.Value.kForward);
	}
	public void armSolenoidDown()	{
		hookSolenoid.set(DoubleSolenoid.Value.kReverse);
	}
	public void armSolenoidOff()	{
		hookSolenoid.set(DoubleSolenoid.Value.kOff);
	}
	public void setLiftPower(double power)	{
		liftingMotorA.set(power);
		liftingMotorB.set(power);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

