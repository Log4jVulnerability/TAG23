package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import frc.robot.Constants;
import com.revrobotics.CANSparkMaxLowLevel;

public class BridgeAngle extends SubsystemBase {
    final CANSparkMax drawbridgeMotor;

    public BridgeAngle() {
        drawbridgeMotor = new CANSparkMax(Constants.drawbridgeMotor, CANSparkMaxLowLevel.MotorType.kBrushless);
    }

    public void zero() {

    }

}
