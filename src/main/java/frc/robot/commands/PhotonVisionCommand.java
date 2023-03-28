// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.CompressorSub;
import frc.robot.subsystems.DriveSub;
import frc.robot.subsystems.VisionSubsystem;
import frc.robot.subsystems.WinchSub;
import frc.robot.subsystems.turnThingySub;



// This command is used to turn the robot to face an AprilTag, using the VisionSubsystem to detect the AprilTag
public class PhotonVisionCommand extends CommandBase {
  private int getTag= 0;
  private WinchSub m_WinchSub;
  private CompressorSub m_CompressorSub;
  private int idealId = 6;

  private double curAuto;
  private int currentAutonomous = 0;

  DriveSub  m_DriveSub ; // drive system
  VisionSubsystem m_VisionSubsystem; // vision system
  double kp = 0.0175; // scaling ratio for robot movement
  double error; // amount of error our robot detects that it tries to correct for, relative to the position of the AprilTag

  public PhotonVisionCommand(DriveSub driveSub, VisionSubsystem visionSubsystem, WinchSub winchSub, CompressorSub compressorSub,turnThingySub turnThingySub) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_WinchSub = winchSub;
    m_CompressorSub = compressorSub;
    m_DriveSub = driveSub ; // define drive and vision system
    m_VisionSubsystem = visionSubsystem;
    addRequirements(m_DriveSub, m_VisionSubsystem,m_WinchSub, m_CompressorSub,turnThingySub);
  }
/* 
  public boolean yawIsReady(VisionSubsystem m_VisionSubsystem1){
    if(m_VisionSubsystem1.getYaw()<=5&&m_VisionSubsystem1.getYaw()>=-5){
      return false;
    }else{
      return true;
    }
  }
  public boolean yawIsUnready(VisionSubsystem m_VisionSubsystem1){
    if(m_VisionSubsystem1.getYaw()>=5&&m_VisionSubsystem1.getYaw()<=-5){
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

  public void autonomous0() {
    if (m_VisionSubsystem.getHasTarget() && m_VisionSubsystem.getId() == idealId && m_VisionSubsystem.getYaw()>5 || m_VisionSubsystem.getHasTarget() && m_VisionSubsystem.getId() == 0 && m_VisionSubsystem.getYaw() <= 5) { // if we find )) { // if we find a target,
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

   
    }
    else if(m_VisionSubsystem.getHasTarget() && m_VisionSubsystem.getArea() > 0.13 && m_VisionSubsystem.getYaw() >-6 && m_VisionSubsystem.getId() == 0 ||m_VisionSubsystem.getHasTarget() && m_VisionSubsystem.getArea() > 0.13 && m_VisionSubsystem.getYaw() <6 && m_VisionSubsystem.getId() == idealId){
      m_DriveSub.moveBackward();
    }
     else {
      m_DriveSub.stop(); // otherwise, don't do anything
    }
  }
  public void autonomous1() {
    if (m_VisionSubsystem.getHasTarget() && m_VisionSubsystem.getId() == idealId && m_VisionSubsystem.getYaw()>5 || m_VisionSubsystem.getHasTarget() && m_VisionSubsystem.getId() ==1 && m_VisionSubsystem.getYaw() <= 5) { // if we find )) { // if we find a target,
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

   
    }
    else if(m_VisionSubsystem.getHasTarget() && m_VisionSubsystem.getArea() > 0.13 && m_VisionSubsystem.getYaw() >-6 && m_VisionSubsystem.getId() == 1 ||m_VisionSubsystem.getHasTarget() && m_VisionSubsystem.getArea() > 0.13 && m_VisionSubsystem.getYaw() <6 && m_VisionSubsystem.getId() == idealId){
      m_DriveSub.moveBackward();
    }
     else {
      m_DriveSub.stop(); // otherwise, don't do anything
    }
  }
  public void autonomous2() {
    if (m_VisionSubsystem.getHasTarget() && m_VisionSubsystem.getId() == idealId && m_VisionSubsystem.getYaw()>5 || m_VisionSubsystem.getHasTarget() && m_VisionSubsystem.getId() ==2 && m_VisionSubsystem.getYaw() <= 5) { // if we find )) { // if we find a target,
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

   
    }
    else if(m_VisionSubsystem.getHasTarget() && m_VisionSubsystem.getArea() > 0.13 && m_VisionSubsystem.getYaw() >-6 && m_VisionSubsystem.getId() == 2 ||m_VisionSubsystem.getHasTarget() && m_VisionSubsystem.getArea() > 0.13 && m_VisionSubsystem.getYaw() <6 && m_VisionSubsystem.getId() == idealId){
      m_DriveSub.moveBackward();
    }
     else {
      m_DriveSub.stop(); // otherwise, don't do anything
    }
  }public void autonomous3() {
    if (m_VisionSubsystem.getHasTarget() && m_VisionSubsystem.getId() == idealId && m_VisionSubsystem.getYaw()>5 || m_VisionSubsystem.getHasTarget() && m_VisionSubsystem.getId() ==3 && m_VisionSubsystem.getYaw() <= 5) { // if we find )) { // if we find a target,
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

   
    }
    else if(m_VisionSubsystem.getHasTarget() && m_VisionSubsystem.getArea() > 0.13 && m_VisionSubsystem.getYaw() >-6 && m_VisionSubsystem.getId() == 3 ||m_VisionSubsystem.getHasTarget() && m_VisionSubsystem.getArea() > 0.13 && m_VisionSubsystem.getYaw() <6 && m_VisionSubsystem.getId() == idealId){
      m_DriveSub.moveBackward();
    }
     else {
      m_DriveSub.stop(); // otherwise, don't do anything
    }
  }
  public void autonomous4() {
    if (m_VisionSubsystem.getHasTarget() && m_VisionSubsystem.getId() == idealId && m_VisionSubsystem.getYaw()>5 || m_VisionSubsystem.getHasTarget() && m_VisionSubsystem.getId() ==4 && m_VisionSubsystem.getYaw() <= 5) { // if we find )) { // if we find a target,
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

   
    }
    else if(m_VisionSubsystem.getHasTarget() && m_VisionSubsystem.getArea() > 0.13 && m_VisionSubsystem.getYaw() >-6 && m_VisionSubsystem.getId() == 4 ||m_VisionSubsystem.getHasTarget() && m_VisionSubsystem.getArea() > 0.13 && m_VisionSubsystem.getYaw() <6 && m_VisionSubsystem.getId() == idealId){
      m_DriveSub.moveBackward();
    }
     else {
      m_DriveSub.stop(); // otherwise, don't do anything
    }
  }
  public void autonomous5() {
    if (m_VisionSubsystem.getHasTarget() && m_VisionSubsystem.getId() == idealId && m_VisionSubsystem.getYaw()>5 || m_VisionSubsystem.getHasTarget() && m_VisionSubsystem.getId() ==5 && m_VisionSubsystem.getYaw() <= 5) { // if we find )) { // if we find a target,
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

   
    }
    
    else if(m_VisionSubsystem.getHasTarget() && m_VisionSubsystem.getArea() > 0.13 && m_VisionSubsystem.getYaw() >-6 && m_VisionSubsystem.getId() == 5 ||m_VisionSubsystem.getHasTarget() && m_VisionSubsystem.getArea() > 0.13 && m_VisionSubsystem.getYaw() <6 && m_VisionSubsystem.getId() == idealId){
      m_DriveSub.moveBackward();
    }
     else {
      m_DriveSub.stop(); // otherwise, don't do anything
    }
  }
  public void autonomous6() {
    if (m_VisionSubsystem.getHasTarget() && m_VisionSubsystem.getId() == idealId && m_VisionSubsystem.getYaw()>5 || m_VisionSubsystem.getHasTarget() && m_VisionSubsystem.getId() ==6 && m_VisionSubsystem.getYaw() <= 5) { // if we find )) { // if we find a target,
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

   
    }
    else if(m_VisionSubsystem.getHasTarget() && m_VisionSubsystem.getArea() > 0.13 && m_VisionSubsystem.getYaw() >-6 && m_VisionSubsystem.getId() == 6 ||m_VisionSubsystem.getHasTarget() && m_VisionSubsystem.getArea() > 0.13 && m_VisionSubsystem.getYaw() <6 && m_VisionSubsystem.getId() == idealId){
      m_DriveSub.moveBackward();
    }
     else {
      m_DriveSub.stop(); // otherwise, don't do anything
    }
  }
  public void autonomous7() {
    if (m_VisionSubsystem.getHasTarget() && m_VisionSubsystem.getId() == idealId && m_VisionSubsystem.getYaw()>5 || m_VisionSubsystem.getHasTarget() && m_VisionSubsystem.getId() ==7 && m_VisionSubsystem.getYaw() <= 5) { // if we find )) { // if we find a target,
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

   
    }
    else if(m_VisionSubsystem.getHasTarget() && m_VisionSubsystem.getArea() > 0.13 && m_VisionSubsystem.getYaw() >-6 && m_VisionSubsystem.getId() == 7 ||m_VisionSubsystem.getHasTarget() && m_VisionSubsystem.getArea() > 0.13 && m_VisionSubsystem.getYaw() <6 && m_VisionSubsystem.getId() == idealId){
      m_DriveSub.moveBackward();
    }
     else {
      m_DriveSub.stop(); // otherwise, don't do anything
    }
  }
  public void autonomous8() {
    if (m_VisionSubsystem.getHasTarget() && m_VisionSubsystem.getId() == idealId && m_VisionSubsystem.getYaw()>5 || m_VisionSubsystem.getHasTarget() && m_VisionSubsystem.getId() ==8 && m_VisionSubsystem.getYaw() <= 5) { // if we find )) { // if we find a target,
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

   
    }
    else if(m_VisionSubsystem.getHasTarget() && m_VisionSubsystem.getArea() > 0.13 && m_VisionSubsystem.getYaw() >-6 && m_VisionSubsystem.getId() == 8 ||m_VisionSubsystem.getHasTarget() && m_VisionSubsystem.getArea() > 0.13 && m_VisionSubsystem.getYaw() <6 && m_VisionSubsystem.getId() == idealId){
      m_DriveSub.moveBackward();
    }
     else {
      m_DriveSub.stop(); // otherwise, don't do anything
    }
  }
  public void autonomous9() {
    if (m_VisionSubsystem.getHasTarget() && m_VisionSubsystem.getId() == idealId && m_VisionSubsystem.getYaw()>5 || m_VisionSubsystem.getHasTarget() && m_VisionSubsystem.getId() ==9 && m_VisionSubsystem.getYaw() <= 5) { // if we find )) { // if we find a target,
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

   
    }
    else if(m_VisionSubsystem.getHasTarget() && m_VisionSubsystem.getArea() > 0.13 && m_VisionSubsystem.getYaw() >-6 && m_VisionSubsystem.getId() == 9 ||m_VisionSubsystem.getHasTarget() && m_VisionSubsystem.getArea() > 0.13 && m_VisionSubsystem.getYaw() <6 && m_VisionSubsystem.getId() == idealId){
      m_DriveSub.moveBackward();
    }
     else {
      m_DriveSub.stop(); // otherwise, don't do anything
    }
  }
  public void autonomous10() {
    if (m_VisionSubsystem.getHasTarget() && m_VisionSubsystem.getId() == idealId && m_VisionSubsystem.getYaw()>5 || m_VisionSubsystem.getHasTarget() && m_VisionSubsystem.getId() ==10 && m_VisionSubsystem.getYaw() <= 5) { // if we find )) { // if we find a target,
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

   
    }
    else if(m_VisionSubsystem.getHasTarget() && m_VisionSubsystem.getArea() > 0.13 && m_VisionSubsystem.getYaw() >-6 && m_VisionSubsystem.getId() == 10 ||m_VisionSubsystem.getHasTarget() && m_VisionSubsystem.getArea() > 0.13 && m_VisionSubsystem.getYaw() <6 && m_VisionSubsystem.getId() == idealId){
      m_DriveSub.moveBackward();
    }
     else {
      m_DriveSub.stop(); // otherwise, don't do anything
    }
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    curAuto = SmartDashboard.getNumber("Auto Value", currentAutonomous);
    currentAutonomous = (int)curAuto;
  }
  */

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    /* 
    switch(currentAutonomous) {
      
      case 0:
      autonomous0();
      break;
      case 1:
      autonomous1();
      break;
      case 2:
      autonomous2();
      break;
      case 3:
      autonomous3();
      break;
      case 4:
      autonomous4();
      break;
      case 5:
      autonomous5();
      break;
      case 6:
      autonomous6();
      break;
      case 7:
      autonomous7();
      break;
      case 8:
      autonomous8();
      break;
      case 9:
      autonomous9();
      break;
      case 10:
      autonomous10();
      break;
      */
      
  
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
