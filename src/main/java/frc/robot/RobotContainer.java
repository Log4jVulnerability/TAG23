// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.Drawbridge;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.BridgeAngle;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.BridgeFlywheels;
import frc.robot.commands.BridgeZero;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
    // The robot's subsystems and commands are defined here...
    public final static XboxController xbox0 = new XboxController(0);
    public final static XboxController xbox1 = new XboxController(1);
    public final static Drivebase m_drivebase = new Drivebase();
    public final static Drawbridge m_drawbridge = new Drawbridge();

    /** The container for the robot. Contains subsystems, OI devices, and commands. */
    public RobotContainer() {
        // Configure the button bindings
        configureButtonBindings();
        ArcadeDrive m_arcadeDrive = new ArcadeDrive(m_drivebase);
        m_drivebase.setDefaultCommand(m_arcadeDrive);
        BridgeAngle m_bridgeAngle = new BridgeAngle(m_drawbridge);
        m_drawbridge.setDefaultCommand(m_bridgeAngle);
    }
    /* ONE CONTROLLER
    public static XboxController getXbox0() {return xbox0;}
    public static double getDriveRightTrigger() {return getXbox0().getRightTriggerAxis();}
    public static double getDriveLeftTrigger() {return getXbox0().getLeftTriggerAxis();}
    public static double getDriveSteer() {return getXbox0().getLeftX();}
    public static double getBridgeAngle() {return getXbox1().getLeftY();}
    */

    public static XboxController getXbox0() {return xbox0;}
    public static XboxController getXbox1() {return xbox1;}
    public static double getDriveRightTrigger() {return getXbox0().getRightTriggerAxis();}
    public static double getDriveLeftTrigger() {return getXbox0().getLeftTriggerAxis();}
    public static double getDriveSteer() {return getXbox0().getLeftX();}
    public static double getBridgeAngle() {return getXbox1().getLeftY();}

    /**
     * Use this method to define your button->command mappings. Buttons can be created by
     * instantiating a {@link GenericHID} or one of its subclasses ({@link
     * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
     * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings() {
        /* ONE CONTROLLER
        new JoystickButton(xbox0, XboxController.Button.kLeftBumper.value).whenHeld(new BridgeFlywheels(m_drawbridge, true));
        new JoystickButton(xbox0, XboxController.Button.kRightBumper.value).whenHeld(new BridgeFlywheels(m_drawbridge, false));
        new JoystickButton(xbox0, XboxController.Button.kRightStick.value).whenHeld(new BridgeZero(m_drawbridge));
        */

        new JoystickButton(xbox1, XboxController.Button.kLeftBumper.value).whenHeld(new BridgeFlywheels(m_drawbridge, true));
        new JoystickButton(xbox1, XboxController.Button.kRightBumper.value).whenHeld(new BridgeFlywheels(m_drawbridge, false));
        new JoystickButton(xbox1, XboxController.Button.kLeftStick.value).whenHeld(new BridgeZero(m_drawbridge));
    }

}