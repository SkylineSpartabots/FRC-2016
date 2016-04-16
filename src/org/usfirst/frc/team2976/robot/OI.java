package org.usfirst.frc.team2976.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team2976.robot.commands.MoveArm;
import org.usfirst.frc.team2976.robot.utilities.XBoxController;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	XBoxController m_driveStick;
	XBoxController m_secondaryStick;
	
	public OI(){
		m_driveStick = new XBoxController(0);
		m_secondaryStick = new XBoxController(1);
		

		Button a = new JoystickButton (getDriveStick(), 1);
		Button b = new JoystickButton (getDriveStick(), 2);
		
		a.whileHeld(new MoveArm(true));
		b.whileHeld(new MoveArm(false));
	}
	
	public XBoxController getDriveStick(){
		return m_driveStick;
	}
	
	
	
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}

