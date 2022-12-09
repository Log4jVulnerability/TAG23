package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMaxPIDController;
import frc.robot.Constants;
import com.revrobotics.CANSparkMaxLowLevel;

public class BridgeAngle extends SubsystemBase {

    final CANSparkMax drawbridgeMotor;
    final SparkMaxPIDController controller;

    public BridgeAngle() {
        drawbridgeMotor = new CANSparkMax(Constants.drawbridgeMotor, CANSparkMaxLowLevel.MotorType.kBrushless);
        drawbridgeMotor.restoreFactoryDefaults();
        controller = drawbridgeMotor.getPIDController();

        double kP = 0.1;
        double kI = 1e-4;
        int kD = 1;
        int kIz = 0;
        int kFF = 0;
        double kMaxOutput = .1;
        double kMinOutput = -.1;

        controller.setP(kP);
        controller.setI(kI);
        controller.setD(kD);
        controller.setIZone(kIz);
        controller.setFF(kFF);
        controller.setOutputRange(kMinOutput, kMaxOutput);
    }

    public void zero() {

    }

}
