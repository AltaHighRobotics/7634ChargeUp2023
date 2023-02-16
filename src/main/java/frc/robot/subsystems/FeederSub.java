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

public class FeederSub extends SubsystemBase {

  private WPI_VictorSPX m_feedMotor;
  /** Creates a new PullerSub. */
  public FeederSub() {
    m_feedMotor = new WPI_VictorSPX(Constants.FEEDER_MOTOR); 
  
    m_feedMotor.configFactoryDefault();
    m_feedMotor.setNeutralMode(NeutralMode.Brake);  
  }
  public void startFeed(){
    m_feedMotor.set(VictorSPXControlMode.PercentOutput, Constants.FEEDER_SPEED);
    SmartDashboard.putBoolean("feeder", true);
  }
  public void stopFeed(){
    m_feedMotor.neutralOutput();
    SmartDashboard.putBoolean("feeder", false);
    SmartDashboard.putBoolean("reverseFeeder", false);
  }
  public void reverseFeeder(){
    m_feedMotor.set(VictorSPXControlMode.PercentOutput,Constants.FEEDER_SPEED*-1);
    SmartDashboard.putBoolean("reversefeeder", true);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}