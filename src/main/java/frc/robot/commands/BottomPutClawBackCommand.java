// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.smoothArmSub;
import frc.robot.subsystems.WinchSub;
import frc.robot.subsystems.CompressorSub;

public class BottomPutClawBackCommand extends CommandBase {
  /** Creates a new BottomPutClawBackCommand. */
  private WinchSub m_winchSub;
  private smoothArmSub m_SmoothArmSub;
  private CompressorSub m_CompressorSub;

  private int stage;
  private long startTime;

  public BottomPutClawBackCommand(WinchSub winchSub , smoothArmSub smoothArmSub , CompressorSub compressorSub) {
    m_winchSub = winchSub;
    m_SmoothArmSub = smoothArmSub;
    m_CompressorSub = compressorSub;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_winchSub,m_SmoothArmSub,m_CompressorSub);
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
      m_winchSub.SetWinchArm(-1);

      if(startTime == 0){
        startTime = System.currentTimeMillis();
      }

      if(System.currentTimeMillis()-startTime >=1000){
        startTime = 0;
        stage = 1;

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
    m_winchSub.stopArm();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
