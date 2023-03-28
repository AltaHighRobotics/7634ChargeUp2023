// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.WinchSub;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants;
public class LiftWinchCommand extends CommandBase {
  private XboxController m_XboxController;
  private WinchSub m_winchSub;
  private double y_Axis;
  /** Creates a new LiftWinchCommand. */
  public LiftWinchCommand(WinchSub winchSub, XboxController xboxController) {
    m_XboxController = xboxController;
    m_winchSub = winchSub;
    addRequirements(m_winchSub);
      // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    y_Axis = -m_XboxController.getRawAxis(Constants.LEFT_Y_AXIS);
    
    m_winchSub.SetWinchArm(y_Axis);
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
