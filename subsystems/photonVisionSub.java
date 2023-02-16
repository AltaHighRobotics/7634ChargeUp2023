// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.lang.reflect.Array;
import java.util.List;

import org.photonvision.PhotonCamera;
import org.photonvision.PhotonVersion;
import org.photonvision.targeting.PhotonPipelineResult;
import org.photonvision.targeting.PhotonTrackedTarget;

import frc.robot.subsystems.DriveSub;
import edu.wpi.first.math.geometry.Transform2d;
import edu.wpi.first.math.geometry.Transform3d;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class photonVisionSub extends SubsystemBase {
  private PhotonCamera camera;
  private boolean hasTarget;
  private PhotonPipelineResult result;
  //private PhotonTrackedTarget target = result.getBestTarget();
  private int targetID;
  private double ambiguity;
  private Transform3d bestCameraToTarget;
  private Transform3d alternateCameraToTarget;

  private List<PhotonTrackedTarget> targetInfo;

  private double yaw;
  private double pitch;
  private double area;
  private double skew;

  /** Creates a new photonVisionSub. */
  public photonVisionSub() {
    camera = new PhotonCamera("photonvision");
  }
/* 
  // updates the target data
  public void update() {
     // Get result.
    result = camera.getLatestResult();
    hasTarget = result.hasTargets();

    // Get targets.
    targetInfo = result.getTargets();
    target = result.getBestTarget();

    // Get data from target.
    yaw = target.getYaw();
    pitch = target.getPitch();
    area = target.getArea();
    skew = target.getSkew();

    // Get camera to target.
    bestCameraToTarget = target.getBestCameraToTarget();
    alternateCameraToTarget = target.getAlternateCameraToTarget();

    // Get id.
    targetID = target.getFiducialId();   
  }

  public Transform3d getCameraToTarget() {
    return bestCameraToTarget;
  }

  public boolean getHasTarget() {
    return hasTarget;
  }

  public double getYaw() {
    return yaw;
  }

  public double getPitch() {
    return pitch;
  }

  public double getArea() {
    return area;
  }

  public double getSkew() {
    return skew;
  }
  
  public double getX(){
    return bestCameraToTarget.getX();
  }

  public double getY(){
    return bestCameraToTarget.getY();
  }

    public double getZ(){
    return bestCameraToTarget.getZ();
  }
  
  public int getId(){
   return targetID;
  }


   //this tell should the robot go forward
  public boolean forwardOrNot(double x){
    if(x==0){
      return true;
    }else{
      return false;
    }
  } 
*/
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
