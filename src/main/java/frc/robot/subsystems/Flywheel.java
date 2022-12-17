package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Constants;

public class Flywheel extends SubsystemBase {
    final WPI_TalonSRX flywheelLeft;
    final WPI_TalonSRX flywheelRight;

    public Flywheel() {
        flywheelLeft = new WPI_TalonSRX(Constants.flywheelLeft);
        flywheelRight = new WPI_TalonSRX(Constants.flywheelRight);
    }

    public void runFlywheels(boolean in) {
        if (in) {
            flywheelLeft.set(-Constants.flywheelSpeed);
            flywheelRight.set(Constants.flywheelSpeed);
        } else {
            flywheelLeft.set(Constants.flywheelSpeed);
            flywheelRight.set(-Constants.flywheelSpeed);
        }
    }

    public void stopFlywheels() {
        flywheelLeft.set(0);
        flywheelRight.set(0);
    }

}
