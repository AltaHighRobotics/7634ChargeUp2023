// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.turnThingySub;
import frc.robot.subsystems.CompressorSub;
import frc.robot.subsystems.smoothArmSub;
import frc.robot.subsystems.WinchSub;

public class PutTargetOnTopCommand extends CommandBase {
  /** Creates a new PutTargetOnTopCommand. */
  private turnThingySub m_TurnThingySub;
  private CompressorSub m_CompressorSub;
  private smoothArmSub m_SmoothArmSub;
  private WinchSub m_WinchSub;

  //the Time
  private long startTime;
  private int stage;

  public PutTargetOnTopCommand(turnThingySub turnThingySub, CompressorSub compressorSub, smoothArmSub smoothArmSub, WinchSub winchSub) {
    m_TurnThingySub = turnThingySub;
    m_CompressorSub = compressorSub;
    m_SmoothArmSub = smoothArmSub;
    m_WinchSub = winchSub;
  
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_TurnThingySub,m_CompressorSub,m_SmoothArmSub,m_WinchSub);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    stage = 0;
    startTime = 0;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    switch(stage){
      case 0:
      m_WinchSub.SetWinchArm(-1);

      if(startTime == 0){
        startTime = System.currentTimeMillis();
     }
     else if(System.currentTimeMillis()-startTime >=1500){
       m_WinchSub.stopArm();
       stage = 1;
       startTime = 0;
      }
      
     break;

     case 1:
      
      m_TurnThingySub.turnLeftRight(-1);
      

      if(startTime == 0){
       startTime = System.currentTimeMillis();
     }
     else if(System.currentTimeMillis()-startTime >= 2000){
       m_TurnThingySub.turnStop();
      

        stage = 2;
       startTime = 0;
     }
     
     break;
     case 2:

      m_SmoothArmSub.CanWePutArmOut();

      if(startTime == 0){
       startTime = System.currentTimeMillis();
     }
     else if(System.currentTimeMillis()-startTime >= 2000){
       m_SmoothArmSub.ArmStop();
      

        stage = 3;
       startTime = 0;
     }
      break;
      case 3:
      m_CompressorSub.openClaw();
      if(startTime == 0 ){
        stage = 4;
        startTime = 0;
        
      }


      break;
      default:
      break;

  }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    stage = 0;
    startTime = 0;

    //stop
    m_SmoothArmSub.ArmStop();
    m_WinchSub.stopArm();
    m_CompressorSub.closeClaw();
    m_TurnThingySub.turnStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
