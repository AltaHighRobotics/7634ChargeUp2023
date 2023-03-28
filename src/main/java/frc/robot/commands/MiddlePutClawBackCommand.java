// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.WinchSub;
import frc.robot.subsystems.smoothArmSub;
import frc.robot.subsystems.turnThingySub;
import frc.robot.subsystems.CompressorSub;

public class MiddlePutClawBackCommand extends CommandBase {
  /** Creates a new MiddlePutClawBackCommand. */
  private WinchSub m_WinchSub;
  private smoothArmSub m_SmoothArmSub;
  private turnThingySub m_TurnThingySub;
  private CompressorSub m_CompressorSub; 
  private long startTime;
  private int stage;

  public MiddlePutClawBackCommand(WinchSub winchSub, smoothArmSub smoothArmSub , turnThingySub turnThingySub , CompressorSub compressorSub) {
    m_WinchSub = winchSub;
    m_SmoothArmSub = smoothArmSub;
    m_TurnThingySub = turnThingySub;
    m_CompressorSub = compressorSub;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_WinchSub,m_CompressorSub,m_TurnThingySub,m_SmoothArmSub);
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
      m_CompressorSub.closeClaw();
      stage = 0;
      startTime = 0;
      
      break;
      case 1:
      m_SmoothArmSub.CanWePutArmIn();
      if(startTime == 0){
        startTime = System.currentTimeMillis();
      }
      if(System.currentTimeMillis()-startTime >= 1500){
        m_SmoothArmSub.ArmStop();
        stage =1;
        startTime = 0;
      }

      
      break;
      case 2:
      m_WinchSub.SetWinchArm(-1);

      if(startTime == 0){
        startTime = System.currentTimeMillis();
      }
      if(System.currentTimeMillis()-startTime >= 1500){

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
