// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.WinchSub;
import frc.robot.subsystems.smoothArmSub;
import frc.robot.subsystems.turnThingySub;
import frc.robot.subsystems.CompressorSub;

public class TopPutClawBackCommand extends CommandBase {
  /** Creates a new TopPutClawBackCommand. */
  private WinchSub m_WinchSub;
  private smoothArmSub m_SmoothArmSub;
  private turnThingySub m_TurnThingySub;
  private CompressorSub m_CompressorSub; 
  private long startTime;
  private int stage;

  public TopPutClawBackCommand(WinchSub winchSub, smoothArmSub smoothArmSub , turnThingySub turnThingySub , CompressorSub compressorSub) {
    m_WinchSub = winchSub;
    m_SmoothArmSub = smoothArmSub;
    m_TurnThingySub = turnThingySub;
    m_CompressorSub = compressorSub;

    addRequirements(m_WinchSub, m_SmoothArmSub , m_TurnThingySub, m_CompressorSub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    stage =0;
    startTime = 0;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    switch(stage){
      case 0:
      m_CompressorSub.openClaw();
      stage = 0;
      startTime = 0;
      
      break;
      case 1:
      m_SmoothArmSub.CanWePutArmIn();
      if(startTime == 0){
        startTime = System.currentTimeMillis();
      }
      if(System.currentTimeMillis()-startTime >= 2000){
        m_SmoothArmSub.ArmStop();
        stage =1;
        startTime = 0;
      }

      
      break;
      case 2:
      m_WinchSub.SetWinchArm(1);

      if(startTime == 0){
        startTime = System.currentTimeMillis();
      }
      if(System.currentTimeMillis()-startTime >= 2000){

        m_WinchSub.stopArm();
        stage =1;
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
    m_CompressorSub.closeClaw();
    m_SmoothArmSub.ArmStop();
    m_WinchSub.stopArm();
    m_TurnThingySub.turnStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
