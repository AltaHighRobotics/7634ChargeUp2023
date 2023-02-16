// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import frc.robot.subsystems.FeederSub;
import edu.wpi.first.wpilibj2.command.CommandBase;


public class ReverseFeederCommand extends CommandBase {
  private FeederSub m_feederSub;
  /** Creates a new ReverseFeederCommand. */
  public ReverseFeederCommand(FeederSub FeederSub) {
    m_feederSub = FeederSub;

    addRequirements(m_feederSub);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_feederSub.reverseFeeder();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_feederSub.stopFeed();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
