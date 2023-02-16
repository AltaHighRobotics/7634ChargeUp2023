// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import frc.robot.Constants;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ShooterSub extends SubsystemBase {
  
  private WPI_TalonFX m_shootMotor;

  /** Creates a new ShooterSubsystem. */
  public ShooterSub() {
    m_shootMotor = new WPI_TalonFX(Constants.SHOOTER_MOTOR);


    m_shootMotor.configFactoryDefault();
    m_shootMotor.setNeutralMode(NeutralMode.Brake);

  }
  public void startShooter(){
    m_shootMotor.set(TalonFXControlMode.PercentOutput, Constants.SHOOTER_SPEED);
    SmartDashboard.putBoolean("Shooter", true);
  }
  public void stopShooter(){
    m_shootMotor.neutralOutput();
    SmartDashboard.putBoolean("Shooter", false);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
