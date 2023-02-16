// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
  

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.NeutralMode;
public class turnThingySub extends SubsystemBase {
  private VictorSPX m_TurnMotor;
  
  /** Creates a new turnThingySub. */
  public turnThingySub() {
    m_TurnMotor = new VictorSPX(Constants.TURN_MOTOR);

    m_TurnMotor.configFactoryDefault();
    m_TurnMotor.setNeutralMode(NeutralMode.Brake);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }
  public void turnLeftWitch(double turnSpeed){
    m_TurnMotor.set(VictorSPXControlMode.PercentOutput,turnSpeed);

  }
  public void turnRightWitch(){
    m_TurnMotor.set(VictorSPXControlMode.PercentOutput,Constants.TURN_SPEED);

  }
  public void turnStop(){
    

  }
}

