// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.limeLightSub;
import limelightvision.limelight.frc.LimeLight;
import frc.robot.subsystems.DriveSub;
public class limeLightCommand extends CommandBase {
  /** Creates a new limeLightCommand. */
  private limeLightSub m_limeLightSub = new limeLightSub();
  private DriveSub m_driveSub = new DriveSub();
  private int switches = 0;

  public limeLightCommand(limeLightSub limeLightSub,DriveSub DriveSub) {
    m_limeLightSub = limeLightSub ;
    m_driveSub = DriveSub;

    addRequirements(m_driveSub);
    addRequirements(m_limeLightSub);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  public void moveLeftRight(double x){
    if(x<0){
      m_driveSub.turnRight();
    }if(x>0){
      m_driveSub.turnLeft();
    }
  }
  public void towardToZero(){
    double x = m_limeLightSub.getX();

    if(x != 0 && m_limeLightSub.objectSeen()){
      moveLeftRight(x);
    } else {
      m_driveSub.stop();
    }
  }
  public void moveTowardToTarg(){
    double ta = m_limeLightSub.getArea();
    if(ta<1.0){
      m_driveSub.moveForward();
    }else{
      m_driveSub.stop();
    }
  }
  public void moveBackward(){
    double ta = m_limeLightSub.getArea();
    if(ta>=0.0){
      m_driveSub.moveBackward();
    }else{
      m_driveSub.stop();
    }
  }
  public void movelittle(){

  }

  public void swithes(){

  }
  public void backOrNot(){

  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    towardToZero();
    
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_driveSub.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
