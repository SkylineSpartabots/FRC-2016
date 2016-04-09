//FIXME: change access types to non-static
package org.usfirst.frc.team2976.robot;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import org.usfirst.frc.team2976.robot.commands.*;
import org.usfirst.frc.team2976.robot.subsystems.*;

/**
 * @author NeilHazra 
 * @author JasmineCheng
 * The VM is configured to automatically run this class, and
 *         to call the functions corresponding to each mode, as described in the
 *         IterativeRobot documentation. If you change the name of this class or
 *         the package after creating this project, you must also update the
 *         manifest file in the resource directory.
 */
public class Robot extends IterativeRobot {
	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static final ArmDynamicSetpointPID armPID = new ArmDynamicSetpointPID();
	public static final DriveBOT DriveBot = new DriveBOT();
	public static final RunRoller runRoller = new RunRoller();
	public static final RaiseHook raiseHook = new RaiseHook();
	public static final RaiseRobot raiseRobot = new RaiseRobot();
	public static final RaiseBackArm raiseBackArm = new RaiseBackArm();
	public static final startCompressor startCompressor = new startCompressor();
	//public static final VelocityArm velocityArm = new VelocityArm();
	
	
	//public static final ArmSwitchNotifier armSwitch = new ArmSwitchNotifier();
	//FIXME put this in OI with button commands if anyone has an extra hour

	SendableChooser autoChooser;
	
	public static OI oi;
	
	public static DriveTrain drivetrain;
	public static Roller roller;
	public static ArmMotors armMotors;
	
	// Btn Commands are started in the OI constructor
	
	Command autonomousCommand;
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		oi = new OI();
		armMotors = new ArmMotors();
		drivetrain = new DriveTrain();
	}
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}
	public void autonomousInit() {
		// schedule the autonomous command (example)
		autonomousCommand = new LowBarAutonomous();
        if(autonomousCommand != null) autonomousCommand.start();
	}
	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}
	public void teleopInit() {
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		startCompressor.start(); //Starts the Compressor
		armPID.start(); //moves the arm
		runRoller.start();//Runs the roller
		DriveBot.start(); //Drive Code
		raiseHook.start(); //works
		raiseRobot.start(); //works
		raiseBackArm.start(); //works		
		
		//armSwitch.start(); //Test not done yet
	}
	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	public void disabledInit() {	
	}
	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}
	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
}
