package org.usfirst.frc.team2976.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * @author JasmineCheng
 * Drives under low bar, turns and shoots
 */
public class ArmUpAutonomous extends CommandGroup {
    public ArmUpAutonomous() {
     addSequential(new AutoDriveStraight(0.9, 3));   
     addSequential(new ArmDown());
     addSequential(new RollOut());
     addSequential(new ArmUp());
    }
}