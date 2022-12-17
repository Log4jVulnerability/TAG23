// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivebase;


/** An example command that uses an example subsystem. */
public class AutoDrive extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final Drivebase m_drivebase;
    private final double speed;
    private final double turn;


    /**
     * Creates a new ExampleCommand.
     *
     * @param subsystem The subsystem used by this command.
     */

    public AutoDrive(Drivebase subsystem, double Speed, double Turn) {
        m_drivebase = subsystem;
        speed = Speed;
        turn = Turn;
        addRequirements(subsystem);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        m_drivebase.drive(speed, turn);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {m_drivebase.stopMotors();}

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {return false;}
}