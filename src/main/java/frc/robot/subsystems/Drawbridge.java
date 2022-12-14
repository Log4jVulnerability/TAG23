package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.math.controller.PIDController;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Constants;
import com.revrobotics.CANSparkMaxLowLevel;

public class Drawbridge extends SubsystemBase {
    final CANSparkMax motor;
    final RelativeEncoder encoder;
    PIDController controller;
    final WPI_TalonSRX flywheelLeft;
    final WPI_TalonSRX flywheelRight;

    public Drawbridge() {
        double kP = 0.1;
        double kI = 1e-4;
        int kD = 1;

        motor = new CANSparkMax(Constants.drawbridgeMotor, CANSparkMaxLowLevel.MotorType.kBrushless);
        motor.restoreFactoryDefaults();
        encoder = motor.getEncoder();
        controller = new PIDController(kP, kI, kD);

        flywheelLeft = new WPI_TalonSRX(Constants.flywheelLeft);
        flywheelRight = new WPI_TalonSRX(Constants.flywheelRight);
    }

    // ANGLE CONTROL

    public void gotoAngle(int deg) {
        double normalizedAngle = (double) deg/360;
        int target = (int) (4096 * normalizedAngle);
        motor.set(controller.calculate(encoder.getPosition(), target));
    }

    public void runAngle(double Amt) {motor.set(Amt * Constants.drawbridgeSpeed);}
    public void stopAngle() {motor.set(0);}

    // FLYWHEEL CONTROL

    public void runFlywheels(boolean in) {
        if (in) {
            flywheelLeft.set(Constants.flywheelSpeed);
            flywheelRight.set(-Constants.flywheelSpeed);
        } else {
            flywheelLeft.set(-Constants.flywheelSpeed);
            flywheelRight.set(Constants.flywheelSpeed);
        }
    }

    public void stopFlywheels() {
        flywheelLeft.stopMotor();
        flywheelRight.stopMotor();
    }
}
