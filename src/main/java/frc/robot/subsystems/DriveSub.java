// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class DriveSub extends SubsystemBase {
  /** Creates a new DriveSub. */
  private WPI_VictorSPX leftDrive1;
  private WPI_VictorSPX rightDrive1;

  private WPI_VictorSPX leftDrive2;
  private WPI_VictorSPX rightDrive2;

  public DriveSub() {
    leftDrive1 = new WPI_VictorSPX(Constants.LEFT_DRIVE_1); 
    leftDrive2 = new WPI_VictorSPX(Constants.LEFT_DRIVE_2);
    // leftDrive1.setInverted(true);
    // leftDrive2.setInverted(true);

    rightDrive1 = new WPI_VictorSPX(Constants.RIGHT_DRIVE_1);
    rightDrive2 = new WPI_VictorSPX(Constants.RIGHT_DRIVE_2);
    // rightDrive1.setInverted(true);
    // rightDrive2.setInverted(true);

    leftDrive1.setNeutralMode(NeutralMode.Coast);
    leftDrive2.setNeutralMode(NeutralMode.Coast);
    rightDrive1.setNeutralMode(NeutralMode.Coast);
    rightDrive2.setNeutralMode(NeutralMode.Coast);

  }

  public void setRightMotor(double speed){
    rightDrive1.set(VictorSPXControlMode.PercentOutput, speed * Constants.DRIVE_SPEED);
    rightDrive2.set(VictorSPXControlMode.PercentOutput, speed * Constants.DRIVE_SPEED);
  }
  public void setleftMotor(double speed){
    leftDrive1.set(VictorSPXControlMode.PercentOutput, -speed * Constants.DRIVE_SPEED);
    leftDrive2.set(VictorSPXControlMode.PercentOutput, -speed * Constants.DRIVE_SPEED);
  }
  public void setArcadeDrive(double forwardPower, double turnPower){
    setRightMotor(forwardPower - turnPower);
    setleftMotor(forwardPower + turnPower);
  }
  public void turnRight(){
    setRightMotor(Constants.DRIVE_SPEED);
    setleftMotor(-Constants.DRIVE_SPEED);
  }
  public void turnLeft(){
    setRightMotor(-Constants.DRIVE_SPEED);
    setleftMotor(Constants.DRIVE_SPEED);
  }
  public void moveForward(){
    setRightMotor(-Constants.DRIVE_SPEED*0.3);
    setleftMotor(-Constants.DRIVE_SPEED*0.3);
  }
  public void stop(){
    setRightMotor(Constants.DRIVE_SPEED*0);
    setleftMotor(Constants.DRIVE_SPEED*0);
  }
  public void moveBackward(){
    setRightMotor(Constants.DRIVE_SPEED*0.3);
    setleftMotor(Constants.DRIVE_SPEED*0.3);
  }
  public void slowMoveForward(){
    setRightMotor(Constants.DRIVE_SPEED*0.2);
    setleftMotor(Constants.DRIVE_SPEED*0.2);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
