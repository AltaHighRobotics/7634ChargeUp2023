// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.lang.Math;
import java.rmi.StubNotFoundException;

import com.fasterxml.jackson.databind.deser.std.ThrowableDeserializer;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSub;
import frc.robot.subsystems.WinchSub;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.VisionSubsystem;
import frc.robot.Constants;
import frc.robot.subsystems.CompressorSub;
import frc.robot.subsystems.smoothArmSub;
import frc.robot.Constants;

public class SecondAutoCommand extends CommandBase {
  /** Creates a new SecondAutoCommand. */
  //private VisionSubsystem m_VisionSubsystem;
  private DriveSub m_driveSub;
  private WinchSub m_winchSub;
  private CompressorSub m_CompressorSub;
  private smoothArmSub m_SmoothArmSub;

  private double inputDriveSpeed;
  private int stage;

  private double Subtraction;
  private double theAngle;

  private long startTime;
  private double speed;

  public SecondAutoCommand(DriveSub driveSub, WinchSub winchSub,CompressorSub compressorSub, smoothArmSub smoothArmSub) {
    //m_VisionSubsystem = visionSubsystem;
    m_driveSub = driveSub;
    m_winchSub = winchSub;
    m_CompressorSub = compressorSub;
    m_SmoothArmSub = smoothArmSub;

    addRequirements(m_driveSub, m_winchSub, m_CompressorSub, m_SmoothArmSub);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    stage = 0;
    startTime = 0;
    Subtraction = 0.00007;
    speed = Constants.DRIVE_SPEED*0.8*0.072677;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    theAngle = m_driveSub.getPitch();

    switch (stage) {
      case 0: // Move forward 2 seconds. also lift winch
        m_driveSub.moveForward();
        m_CompressorSub.closeClaw();
       // m_winchSub.SetWinchArm(-0.7);

        if (startTime == 0) {
          startTime = System.currentTimeMillis();
        }

        if (System.currentTimeMillis() - startTime >= 1200) {
          startTime = 0; // reset start time.
          stage = 1;
          m_driveSub.stop();
          m_winchSub.stopArm();
        }

        break;
       
      case 1:// Move arm out 3 seconds
        stage = 2;
        startTime = 0;

        break;

      case 2:// Open Claw
        m_CompressorSub.closeClaw();

        if(startTime == 0){
          startTime=System.currentTimeMillis();
        }

        if(System.currentTimeMillis() - startTime >= 1000){
          startTime = 0;
          stage = 3;
          m_driveSub.stop();
        }
        break;
        
        
        case 3://Drive backward for 3.5 second
        m_driveSub.moveBackward();

        if(startTime == 0){
          startTime=System.currentTimeMillis();
        }

        if(System.currentTimeMillis() - startTime >= 4000){
          startTime = 0;
          stage = 4;
          m_driveSub.stop();
        }
        break;

      //balance on charge station
      case 4:
      /*

      if(Math.abs(theAngle) <= Constants.AUTO_BALANCE_THRSHOLD){
        m_driveSub.stop();
        stage = 5;
      }else{
        m_driveSub.moveBackward();
      }
      */
      
      theAngle = m_driveSub.getYaw();
      
      inputDriveSpeed = theAngle*speed;

      SmartDashboard.putNumber("Stage", stage);
    SmartDashboard.putNumber("the balance angle", theAngle);
        startTime =0;

     if(theAngle > Constants.AUTO_BALANCE_THRSHOLD){
       m_driveSub.slowMoveForwardGiveSpeed(inputDriveSpeed * 1.2- Subtraction );
      //Subtraction +=0.00007;
     }
     else if(Math.abs(theAngle) >Constants.AUTO_BALANCE_THRSHOLD){
      m_driveSub.slowMoveBackwardGiveSpeed(Math.abs(inputDriveSpeed - Subtraction));
       
     }
     else{ 
       m_driveSub.stop();
     }
     break;
      default:
        break;
    }

    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_driveSub.stop();
    m_winchSub.stopArm();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
