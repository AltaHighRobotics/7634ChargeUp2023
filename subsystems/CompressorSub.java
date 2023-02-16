// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
public class CompressorSub extends SubsystemBase {

  private final Solenoid extendCompressor;
  /** Creates a new CompreesorSub. */
  public CompressorSub() {
    extendCompressor = new Solenoid(PneumaticsModuleType.REVPH, Constants.LIFT_ARM);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void extendArm(){
    extendCompressor.set(true);
    System.out.println("True");
    SmartDashboard.putBoolean("Compressor", true);
  }
  public void squishArm(){
    extendCompressor.set(false);
    System.out.println("False");
    SmartDashboard.putBoolean("Compressor", false);
  }
}
