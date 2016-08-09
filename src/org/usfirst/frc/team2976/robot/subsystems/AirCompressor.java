package org.usfirst.frc.team2976.robot.subsystems;

import org.usfirst.frc.team2976.robot.commands.startCompressor;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class AirCompressor extends Subsystem {
    public Compressor c_compress = new Compressor();
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new startCompressor());
    }
}

