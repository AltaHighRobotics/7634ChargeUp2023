// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.time.Instant;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.WinchSub;

public class LowerWinchCommand extends CommandBase {

private WinchSub m_winchSub;

  /** Creates a new LiftWinchCommand. */
  public LowerWinchCommand(WinchSub winchSub) {

    m_winchSub = winchSub;
    addRequirements(m_winchSub);
      // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("work");
   }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_winchSub.lowerWinch();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_winchSub.stopArm();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
