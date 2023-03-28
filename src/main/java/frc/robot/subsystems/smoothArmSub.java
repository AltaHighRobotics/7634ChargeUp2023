// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;
public class smoothArmSub extends SubsystemBase {
  private VictorSPX m_smoothArmMotor;
  private DigitalInput ArmIsNotOut = new DigitalInput(9);
  private DigitalInput ArmIsNotIn = new DigitalInput(8);
  /** Creates a new smoothArmSub. */
  public smoothArmSub() {
    m_smoothArmMotor = new VictorSPX(Constants.ARM_SMOOTH_MOTOR);

    m_smoothArmMotor.configFactoryDefault();
    m_smoothArmMotor.setNeutralMode(NeutralMode.Brake);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putBoolean("ArmIsNotOut switch", ArmIsNotOut.get());
    SmartDashboard.putBoolean("ArmIsNotIn switch", ArmIsNotIn.get());
  }

  public void ArmOut(){
    m_smoothArmMotor.set(VictorSPXControlMode.PercentOutput,-Constants.ARMOUT_SPEED);
  }
  public void ArmIn(){
    m_smoothArmMotor.set(VictorSPXControlMode.PercentOutput,Constants.ARMOUT_SPEED);
  }

  public void ArmStop(){
    m_smoothArmMotor.set(VictorSPXControlMode.PercentOutput,Constants.STOP);
  }
  public void CanWePutArmIn(){
    if(ArmIsNotIn.get()){
      ArmIn();
      SmartDashboard.putBoolean("Arm is extending", false);

    }else {
      SmartDashboard.putBoolean("Armisextending", true);
      ArmStop();

    }
    

  }
  public void CanWePutArmOut(){
    if(ArmIsNotOut.get()){
      
      System.out.println("we stop when arm in");
      SmartDashboard.putBoolean("Arm is extending", true);
      ArmOut();
      
    }else {
      ArmStop();
    }
    
  }
}
