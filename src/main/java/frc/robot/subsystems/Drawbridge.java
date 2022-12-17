package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import frc.robot.Constants;
import com.revrobotics.CANSparkMaxLowLevel;

public class Drawbridge extends SubsystemBase {
    final CANSparkMax motor;

    public Drawbridge() {
        motor = new CANSparkMax(Constants.drawbridgeMotor, CANSparkMaxLowLevel.MotorType.kBrushless);
        motor.restoreFactoryDefaults();
    }

    public void run(double Amt) {motor.set(Amt * Constants.drawbridgeSpeed);}
}
