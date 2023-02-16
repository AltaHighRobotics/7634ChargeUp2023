// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.geometry.Transform3d;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.photonVisionSub;
import frc.robot.subsystems.DriveSub;

public class PhotonVisionCommand extends CommandBase {
  /* 
  private photonVisionSub m_photonvisionSub;
  private DriveSub m_DriveSub;
  private int switches;
  private double x;
  private double area;
  private int id;
  private final int ids = m_photonvisionSub.getId();
  private boolean hastarget; 
  // Creates a new PhotonVisionCommand. 
  public PhotonVisionCommand(photonVisionSub photonVisionSub, DriveSub driveSub) {
    m_photonvisionSub = photonVisionSub;
    m_DriveSub = driveSub;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_photonvisionSub);
    addRequirements(m_DriveSub);
  }
  //this function turn to the target
  public void moveLeftRight(){
    x = m_photonvisionSub.getYaw();
    if(x > 0){
      m_DriveSub.turnLeft();
    }else if(x < 0){
      m_DriveSub.turnRight();
    }
  }
     public void wrongMoveLeftRight(){
      double x = m_photonvisionSub.getYaw();
      if(x > 10){
        m_DriveSub.turnLeft();
      }else if(x < 10){
        m_DriveSub.turnRight();
      }

  }
  
  // This function tell should we go forward or not 
  public void switchs(){
    if(switches > 10){
      switches = 0;
    }
    switches++;
  }
  

  //this function move forward
  public void moveForward(){
    m_DriveSub.moveForward();
  }
  
  public void moveBackward(){
    m_DriveSub.moveBackward();
  }

  public void moveForwardSLowly(){
    m_DriveSub.slowMoveForward();
  }

// this is the final function
  public void allmove(){
    hastarget = m_photonvisionSub.getHasTarget();
    id = m_photonvisionSub.getId();
    area = m_photonvisionSub.getArea();
    if(switches == 0 && x != 0 && id == ids ){
      moveLeftRight();
      
    }else if(switches == 1 && x == 0 && area < 0.9 && id == ids && hastarget == true ){
      moveForward();
    }else if(switches == 2 && area >= 0.9 && id == ids && hastarget == true){
      moveLeftRight();
    }else if(switches == 3 && area == 0.9 && id == ids && hastarget == true ){
      moveBackward();
    }else if(switches == 4 && id == ids && hastarget == false){
      moveBackward();
    }else if(switches == 5 && id == ids && hastarget == true ){
      moveBackward();
    }else if(switches == 6 && id == ids && hastarget == false){
      moveForwardSLowly();
    }else if(switches == 7 && id == ids && hastarget == true) {
      m_DriveSub.stop();
    }else{
      switchs();
      m_DriveSub.stop();
    }

    
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Execute Order 66
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_photonvisionSub.update(); 
    allmove();

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_DriveSub.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
  */
}

//if bob was a builder he would build. If Sam was a fighter she would fight, But if Joe was a jester he would joke.
// 2 blind mn walk down a street. One of them falls and hurts his knee. He said to the other blind man "help me". The other man asked "where are you", The injured man in then replied "I don't know, I can't see". Why aren't you laughing, did not SEE the joke.
//A mute guy once said.......
// What is your Zodiac Sign? monkeychicken Thats not a--- monkeychicken