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
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SPI;

public class DriveSub extends SubsystemBase {
  /** Creates a new DriveSub. */
  private WPI_VictorSPX leftDrive1;
  private WPI_VictorSPX rightDrive1;

  private WPI_VictorSPX leftDrive2;
  private WPI_VictorSPX rightDrive2;

  private ADXRS450_Gyro gyro;

  public DriveSub() {
    leftDrive1 = new WPI_VictorSPX(Constants.LEFT_DRIVE_1); 
    leftDrive2 = new WPI_VictorSPX(Constants.LEFT_DRIVE_2);
    leftDrive1.setInverted(true);
    leftDrive2.setInverted(true);

    rightDrive1 = new WPI_VictorSPX(Constants.RIGHT_DRIVE_1);
    rightDrive2 = new WPI_VictorSPX(Constants.RIGHT_DRIVE_2);
    //rightDrive1.setInverted(true);
    //rightDrive2.setInverted(true);

    leftDrive1.setNeutralMode(NeutralMode.Coast);
    leftDrive2.setNeutralMode(NeutralMode.Coast);
    rightDrive1.setNeutralMode(NeutralMode.Coast);
    rightDrive2.setNeutralMode(NeutralMode.Coast);

    gyro = new ADXRS450_Gyro(SPI.Port.kOnboardCS0);
    resetGyro();
  }

  public void resetGyro() {
    gyro.calibrate();
  }

  // -180.0 to 180.0.
  public double getPitch() {
    return 0.0;
  }

  public double getRoll() {
    return 0.0;
  }

  public double getYaw() {
    return gyro.getAngle();
  }

  public void setRightMotor(double speed){
    rightDrive1.set(VictorSPXControlMode.PercentOutput, speed * Constants.DRIVE_SPEED);
    rightDrive2.set(VictorSPXControlMode.PercentOutput, speed * Constants.DRIVE_SPEED);
  }
  public void setleftMotor(double speed){
    leftDrive1.set(VictorSPXControlMode.PercentOutput, speed * Constants.DRIVE_SPEED);
    leftDrive2.set(VictorSPXControlMode.PercentOutput, speed * Constants.DRIVE_SPEED);
  }
  public void setArcadeDrive(double forwardPower, double turnPower){
    //System.out.println("Forward: " + forwardPower);
    //System.out.println("TurnPower: " + turnPower);
    setRightMotor(forwardPower + turnPower);
    setleftMotor(forwardPower - turnPower);
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
    setRightMotor(Constants.DRIVE_SPEED*0.9);
    setleftMotor(Constants.DRIVE_SPEED*0.45);
  }
  public void stop(){
    setRightMotor(Constants.DRIVE_SPEED*0);
    setleftMotor(Constants.DRIVE_SPEED*0);
  }
  public void moveBackward(){
    setRightMotor(-Constants.DRIVE_SPEED);
    setleftMotor(-Constants.DRIVE_SPEED*0.7);
  }
  public void slowMoveForward(){
    setRightMotor(Constants.DRIVE_SPEED*0.7);
    setleftMotor(Constants.DRIVE_SPEED*0.7);
  }
  public void slowMoveBackward(){
    setRightMotor(-Constants.DRIVE_SPEED*0.7);
    setleftMotor(-Constants.DRIVE_SPEED*0.7);
  }
  public void slowMoveForwardGiveSpeed(double speed){
    setRightMotor(speed);
    setleftMotor(speed*0.75);
  }
  public void slowMoveBackwardGiveSpeed(double speed){
    setRightMotor(-speed);
    setleftMotor(-speed*0.75);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Yaw", getYaw());
    SmartDashboard.putNumber("Pitch", getPitch());
    SmartDashboard.putNumber("Roll", getRoll());
  }
}
