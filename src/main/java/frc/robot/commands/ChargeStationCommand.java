// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSub;

public class ChargeStationCommand extends CommandBase {
  /** Creates a new ChargeStationCommand. */
  private double theAngle;
  private DriveSub m_DriveSub;
  public ChargeStationCommand(DriveSub driveSub) {
    m_DriveSub = driveSub;
   
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_DriveSub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    theAngle = m_DriveSub.getPitch();
    if(theAngle < 0){
      m_DriveSub.moveForward();
    }
    else if(theAngle > 0){
      m_DriveSub.moveBackward();
    }
    else{
      m_DriveSub.stop();
    }
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
/*what is your favortie color, mine is red, the best color in the world is blue tho. i do not have a mental problem i am just stupid. */
