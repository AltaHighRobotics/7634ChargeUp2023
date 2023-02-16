// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import org.opencv.features2d.FlannBasedMatcher;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import frc.robot.Robot;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;

// Hello Vic!!!!!!!

public class WinchSub extends SubsystemBase {
  //private WPI_TalonSRX winchMotory;
  private VictorSPX winchMotory;
  
  
  /** Creates a new WinchSub. */
  public WinchSub() {
  //winchMotory = new WPI_TalonSRX(Constants.WINCH_MOTOR);
  winchMotory = new VictorSPX(Constants.WINCH_MOTOR);
  
  

  winchMotory.configFactoryDefault();
  winchMotory.setNeutralMode(NeutralMode.Brake);
  
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void liftArm(double y_Axis){
    winchMotory.set(ControlMode.PercentOutput,y_Axis* Constants.WINCH_SPEED);
  }
  public void lowerWinch(){
    winchMotory.set(ControlMode.PercentOutput,-Constants.WINCH_SPEED);
  }
//this function make lower the arm
  public void stopArm(){
    winchMotory.set(ControlMode.PercentOutput, Constants.STOP);
  }
  
}
