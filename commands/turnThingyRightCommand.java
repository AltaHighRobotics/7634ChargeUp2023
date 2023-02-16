// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.turnThingySub;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.XboxController;

public class turnThingyRightCommand extends CommandBase {
  private turnThingySub m_turnThingySub;
  private XboxController m_XboxController;
  private double rightStickY;
  /** Creates a new turnThingyRightCommand. */
  public turnThingyRightCommand(turnThingySub turnThingySub,XboxController xboxController) {
    m_turnThingySub = turnThingySub;
    m_XboxController = xboxController;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_turnThingySub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    rightStickY = m_XboxController.getRawAxis(Constants.LEFT_Y_AXIS); 
    m_turnThingySub.turnLeftWitch(rightStickY*Constants.TURN_SPEED);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_turnThingySub.turnStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
