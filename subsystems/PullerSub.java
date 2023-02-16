// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
public class PullerSub extends SubsystemBase {

  private WPI_VictorSPX m_pullMotor;
  /** Creates a new PullerSub. */
  public PullerSub() {
    m_pullMotor = new WPI_VictorSPX(Constants.PULL_MOTOR); 
  
    m_pullMotor.configFactoryDefault();
    m_pullMotor.setInverted(true);
    m_pullMotor.setNeutralMode(NeutralMode.Brake);  
  }
  public void pullBall(){
    m_pullMotor.set(VictorSPXControlMode.PercentOutput, Constants.PULL_SPEED);
    System.out.println("SubWOrks");
    SmartDashboard.putBoolean("Puller", true);
  }
  public void stopPullBall(){
    m_pullMotor.neutralOutput();
    SmartDashboard.putBoolean("Puller", false);
    SmartDashboard.putBoolean("ReversePull",false);
  }
  public void releasePullBall(){
    m_pullMotor.set(VictorSPXControlMode.PercentOutput, Constants.PULL_SPEED*-1);
    SmartDashboard.putBoolean("ReversePull", true);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
