// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.WinchSub;
import frc.robot.subsystems.CompressorSub;

public class PutTargetAtBottomCommand extends CommandBase {
  private int stage;
  private long startTime;
  private WinchSub m_WinchSub;
  private CompressorSub m_CompressorSub;
  /** Creates a new PutTargetAtBottomCommand. */
  public PutTargetAtBottomCommand(WinchSub winchSub,CompressorSub compressorSub) {
    m_CompressorSub = compressorSub;
    m_WinchSub = winchSub;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_WinchSub,m_CompressorSub);
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
      m_CompressorSub.openClaw();
      m_WinchSub.SetWinchArm(-1);
      if(startTime == 0){
        startTime=System.currentTimeMillis();
      }
      if(System.currentTimeMillis()-startTime >= 1000){
        m_WinchSub.stopArm();
        stage = 1;
        startTime = 0;
      }
      break;
      case 1:
      m_CompressorSub.closeClaw();
      stage = 2;
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
    m_WinchSub.stopArm();

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
