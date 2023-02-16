// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import frc.robot.subsystems.ShooterSub;
import edu.wpi.first.wpilibj2.command.CommandBase;


public class ShootCommand extends CommandBase {
  
  private ShooterSub m_shootSub;
  /** Creates a new ShootCommand. */
  public ShootCommand(ShooterSub shootSub) {
    m_shootSub = shootSub;
    addRequirements(m_shootSub);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_shootSub.startShooter();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_shootSub.stopShooter();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
