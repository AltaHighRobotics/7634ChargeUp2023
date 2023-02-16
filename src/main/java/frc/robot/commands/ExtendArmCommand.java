// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.CompressorSub;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants;
import frc.robot.subsystems.CompressorSub;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
public class ExtendArmCommand extends CommandBase {
  Compressor phCompressor = new Compressor(1, PneumaticsModuleType.REVPH);
  /** Creates a new ExtendArmCommand. */
  private CompressorSub m_compressorSub;
  public ExtendArmCommand(CompressorSub CompressorSub) {
    m_compressorSub = CompressorSub;

    addRequirements(m_compressorSub);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_compressorSub.extendArm();
    phCompressor.enableDigital();
     //boolean enable = phCompressor.enabled();                                   
     //boolean pressureSwitch = phCompressor.getPressureSwitchValue();
     //double curent = phCompressor.getCurrent();
  
    //System.out.println("Arm Command works.");
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_compressorSub.squishArm();

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
  