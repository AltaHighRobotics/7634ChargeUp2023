// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import javax.swing.plaf.basic.BasicTreeUI.SelectionModelPropertyChangeHandler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.smoothArmSub;
import edu.wpi.first.wpilibj.XboxController;
public class ArmInCommand extends CommandBase {
  private smoothArmSub m_smoothArmSub;

  /** Creates a new ArmInCommand. */
  public ArmInCommand(smoothArmSub smoothArmSub) {
    m_smoothArmSub = smoothArmSub;

    addRequirements(m_smoothArmSub);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    m_smoothArmSub.ArmIn();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_smoothArmSub.ArmStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
