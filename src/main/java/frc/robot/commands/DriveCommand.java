// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;
import frc.robot.Constants;

public class DriveCommand extends CommandBase {
  /** Creates a new DriveCommand. */
  private DriveSub m_driveSub;
  private XboxController m_xboxController;
  
  private double leftStickY;
  private double leftStickZ;

  public DriveCommand(DriveSub subsystem, XboxController xboxController ) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_driveSub = subsystem;
    m_xboxController = xboxController;
    addRequirements(m_driveSub);    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    leftStickY = m_xboxController.getRawAxis(Constants.LEFT_Y_AXIS);
    leftStickZ = m_xboxController.getRawAxis(2);

    m_driveSub.setArcadeDrive(-leftStickY/**Constants.DRIVE_SPEED*/,leftStickZ/*Constants.TURN_POWER*/);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
