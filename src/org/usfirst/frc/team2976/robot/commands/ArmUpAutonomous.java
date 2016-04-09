package org.usfirst.frc.team2976.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * @author JasmineCheng
 * Drives under low bar, turns and shoots
 */
public class LowBarAutonomous extends CommandGroup {
    public LowBarAutonomous() {
     addSequential(new AutoDriveStraight(0.9, 3));   
    }
}