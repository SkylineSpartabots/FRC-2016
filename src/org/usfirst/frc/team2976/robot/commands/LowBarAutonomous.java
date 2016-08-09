package org.usfirst.frc.team2976.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LowBarAutonomous extends CommandGroup {
    
    public  LowBarAutonomous() {
    	addSequential(new ArmDown());
        addSequential(new AutoDriveStraight(0.9, 3));   
        addSequential(new RollOut());
        addSequential(new ArmUp());
    }
}
