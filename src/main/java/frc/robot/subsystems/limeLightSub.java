// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import limelightvision.limelight.frc.ControlMode;
import limelightvision.limelight.frc.ControlMode.LedMode;
import limelightvision.limelight.frc.ControlMode.CamMode;
import limelightvision.limelight.frc.LimeLight;
import frc.robot.Constants;

public class limeLightSub extends SubsystemBase {
  /** Creates a new limeLightSub. */
  private LimeLight limeLight;

  public limeLightSub() {
    limeLight = new LimeLight();
    limeLight.setPipeline(Constants.USB_CAMERA_NAME);
    limeLight.setCamMode(CamMode.kvision);
  }

  public void ledOn() {
    limeLight.setLEDMode(LedMode.kforceOn);
  }

  public void ledOff() {
    limeLight.setLEDMode(LedMode.kforceOff);
  }

  public boolean forwardOrNot(double x){
    if(x==0){
      return true;
    }else{
      return false;
    }
  } 
  
  // 0 is the center
  // -27 to 27
  public double getX() {
    return limeLight.getdegRotationToTarget();
  }

  // -20.5 to 20,5
  public double getY() {
    return limeLight.getdegVerticalToTarget();
  }

  // percent size of object
  public double getArea() {
    return limeLight.getTargetArea();
  }

  public boolean objectSeen() {
    return getArea() > 0;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
