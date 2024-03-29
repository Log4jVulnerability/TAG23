// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static int frontLeftID = 12;
    public static int rearLeftID = 14;
    public static int frontRightID = 13;
    public static int rearRightID = 15;

    public static int drawbridgeMotor = 16;
    public static double drawbridgeSpeed = 0.75;
    public static int flywheelLeft = 17;
    public static int flywheelRight = 18;
    public static double flywheelSpeed = 0.9;

    public static double SPEED_SCALING = 0.8;
    public static double TURN_SCALING = 0.6;
}
