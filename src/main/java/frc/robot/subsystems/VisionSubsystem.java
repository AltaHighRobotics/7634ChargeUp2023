// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Constants;

import java.util.List;

import javax.xml.crypto.dsig.Transform;

import org.photonvision.PhotonCamera;
import org.photonvision.targeting.PhotonPipelineResult;
import org.photonvision.targeting.PhotonTrackedTarget;
import frc.robot.Constants;
import edu.wpi.first.math.geometry.Transform3d;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class VisionSubsystem extends SubsystemBase {
    PhotonCamera camera; // Correctly ID the camera (nobody for some reason has been able to do this)
    boolean hasTarget; // boolean becomes true if we have the target
    PhotonPipelineResult result; // gives us whatever photon vision finds (hopefully)
    //Cheng old code value
    private int targetID;
    private double ambiguity;
    private Transform3d bestCameraToTarget;
    private Transform3d alternateCameraToTarget;
    private List<PhotonTrackedTarget> targetInfo;
    private PhotonTrackedTarget target;
    
    private double yaw;
    private double pitch;
    private int numberOfTarget;
    private double area;
    private double skew;

    public VisionSubsystem() {
      camera = new PhotonCamera("LimeLight");
    }


    @Override
    public void periodic() {
        PhotonPipelineResult result = camera.getLatestResult(); // Ask photonvision what it sees
        hasTarget = result.hasTargets(); // If the april tag is ID'd, this boolean becomes true
        if (hasTarget) {
            this.result = result;
            // Get result.
        //    result = camera.getLatestResult();
        //  hasTarget = result.hasTargets();
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
            
    }
    public PhotonTrackedTarget getTargetWithID(int id) { // Give us the april tag ID (if it exists
        List<PhotonTrackedTarget> targets = result.getTargets(); // List of everything we're tracking so we can debug multiple at once
        for (PhotonTrackedTarget i : targets) {
            if (i.getFiducialId() == id) { // See if these IDs of track targets actually exist
                return i; // If the IDs do exist, this if statement becomes true
            }
        }
        return null; // ID doesn't exist or your camera is being stupid
    }


/* 
    //updates the target data
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
*/
     public int getId(){
        return target.getFiducialId();
     }
     public Transform3d getCameraToTarget() {
        return bestCameraToTarget;
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

    
    
    public PhotonTrackedTarget getBestTarget() {
        if (hasTarget) {
        return result.getBestTarget(); // Gets us the closet target (side note; why is photon vision so weird in it's naming conventions?)
        }
        else {
            return null; // if there are no targets then nothing happens
        }
    }
    public boolean getHasTarget() {
        return hasTarget; ///boolean becomes true if we have the target
    }
}

