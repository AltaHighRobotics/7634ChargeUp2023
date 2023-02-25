// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot.commands;

import com.ctre.phoenixpro.signals.ForwardLimitSourceValue;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.DriveSub;
import frc.robot.subsystems.VisionSubsystem;



// This command is used to turn the robot to face an AprilTag, using the VisionSubsystem to detect the AprilTag
public class PhotonVisionCommand extends CommandBase {
  private boolean fowardBackwardSwitch;
  private int idealId = 4;
  DriveSub  m_DriveSub ; // drive system
  VisionSubsystem m_VisionSubsystem; // vision system
  double kp = 0.015; // scaling ratio for robot movement
  double error; // amount of error our robot detects that it tries to correct for, relative to the position of the AprilTag

  public PhotonVisionCommand(DriveSub driveSub, VisionSubsystem visionSubsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_DriveSub = driveSub ; // define drive and vision system
    m_VisionSubsystem = visionSubsystem;
    addRequirements(m_DriveSub, m_VisionSubsystem);
  }

  public boolean yawIsReady(double yaw){
    if(yaw<=5&&yaw>=-5){
      return true;
    }else{
      return false;
    }
  }
  public boolean yawIsUnready(double yaw){
    if(yaw>=5&&yaw<=-5){
      return false;
    }else{
      return true;
    }
  }

  public boolean goFowardBackward(boolean hasTarget){
    if(hasTarget == false){
      return false;
    }else{
      return true;
    }

  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (m_VisionSubsystem.getHasTarget()&& m_VisionSubsystem.getId() == idealId && yawIsUnready(m_VisionSubsystem.getYaw())) { // if we find a target,
      error = m_VisionSubsystem.getBestTarget().getYaw(); // calculate error based off Yaw value of our current best target
      double value = -Math.min(error*kp, 1); // calculate motor percentage value

      // write values to motors, negative and positive value in order for turning to occur
      m_DriveSub.setRightMotor(value);
      m_DriveSub.setleftMotor(-value);
      System.out.println(m_VisionSubsystem.getYaw());
      System.out.println(m_VisionSubsystem.getArea());
      System.out.println(m_VisionSubsystem.getPitch());
      System.out.println(m_VisionSubsystem.getSkew());
      System.out.println(m_VisionSubsystem.getId());

    }else if(m_VisionSubsystem.getHasTarget() && m_VisionSubsystem.getArea() <= 7 && yawIsReady(m_VisionSubsystem.getYaw()) && m_VisionSubsystem.getId() == idealId){
     m_DriveSub.moveForward();
    } 
    else {
      m_DriveSub.stop(); // otherwise, don't do anything
    }
  }
  
  


  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
      System.out.println("ENDED");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
