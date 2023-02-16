// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.*;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.Constants;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private XboxController xboxController = new XboxController(Constants.XBOX_CONTROLLER);
  private XboxController shooterController = new XboxController(Constants.SHOOTER_CONTROLLER);
  
  //Subsystems%
  private DriveSub m_driveSub = new DriveSub();
  private WinchSub m_winchSub = new WinchSub();
  private ShooterSub m_shooterSub = new ShooterSub();
  private PullerSub m_pullerSub = new PullerSub();
  private FeederSub m_feederSub = new FeederSub();
  private CompressorSub m_compressorSub = new CompressorSub();
  private turnThingySub m_turnThingySub = new turnThingySub();
  private smoothArmSub m_SmoothArmSub = new smoothArmSub();
  private photonVisionSub m_PhotonVisionSub = new photonVisionSub();
  //commands
  private DriveCommand m_driveCommand = new DriveCommand(m_driveSub, xboxController);
  private LiftWinchCommand m_liftWinchCommand = new LiftWinchCommand(m_winchSub,shooterController);
  //private PhotonVisionCommand m_PhotonVisionCommand = new PhotonVisionCommand(m_PhotonVisionSub, m_driveSub);
  //private LowerWinchCommand m_lowerWinchCommand = new LowerWinchCommand(m_winchSub);
  //private ShootCommand m_shootCommand = new ShootCommand(m_shooterSub);
  //private PullerCommand m_pullerCommand = new PullerCommand(m_pullerSub);
  ///private ReleasePullBallCommand m_ReleasePullBallCommand = new ReleasePullBallCommand(m_pullerSub);
  //private FeederCommand m_feederCommand = new FeederCommand(m_feederSub);
  //private ReverseFeederCommand m_reverseFeederCommand = new ReverseFeederCommand(m_feederSub);
  private ExtendArmCommand m_extendArmCommand = new ExtendArmCommand(m_compressorSub);
  //private turnThingyLeftCommand m_TurnThingyLeftCommand = new turnThingyLeftCommand(m_turnThingySub,shooterController);
  private armOutCommand m_ArmOutCommand = new armOutCommand(m_SmoothArmSub);
  private ArmInCommand m_ArmInCommand = new  ArmInCommand(m_SmoothArmSub);
  private turnThingyRightCommand m_TurnThingyRightCommand = new turnThingyRightCommand(m_turnThingySub,shooterController);

  //private SquishsArmCommand m_SquishsArmCommand = new SquishsArmCommand(m_winchSub);
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    CommandScheduler.getInstance().setDefaultCommand(m_driveSub, m_driveCommand);
    //CommandScheduler.getInstance().setDefaultCommand(m_turnThingySub,m_TurnThingyLeftCommand);
    CommandScheduler.getInstance().setDefaultCommand(m_winchSub, m_liftWinchCommand);
    CommandScheduler.getInstance().setDefaultCommand(m_turnThingySub,m_TurnThingyRightCommand);
    CommandScheduler.getInstance().schedule(m_extendArmCommand);
    
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    //final JoystickButton feedButton = new JoystickButton(xboxController, Constants.XBOX_B_BUTTON);
    final JoystickButton armExtendButton = new JoystickButton(shooterController, Constants.XBOX_A_BUTTON);
    //final JoystickButton stopPhotonVision = new JoystickButton(shooterController,Constants.FLIGHT_BUTTON_12);
    final POVButton smooarmButtton = new POVButton(shooterController, 0);
    final POVButton inArmButton = new POVButton(shooterController, 180);
    //final JoystickButton squishArmButton = new JoystickButton(shooterController, Constants.XBOX_B_BUTTON);
    //final JoystickButton shootButton = new JoystickButton(xboxController, Constants.SHOULDER_R);
    //final JoystickButton pullButton = new JoystickButton(xboxController, Constants.XBOX_X_BUTTON);
    //final JoystickButton releaseBallButton = new JoystickButton(xboxController, Constants.MENU_BUTTON_R);

    //shooter
    //final JoystickButton feedButton1 = new JoystickButton(shooterController, Constants.XBOX_A_BUTTON);
    //final JoystickButton shootButton1 = new JoystickButton(shooterController, Constants.XBOX_B_BUTTON);
    //final JoystickButton pullerButton1 = new JoystickButton(shooterController, Constants.XBOX_Y_BUTTON);
    //final JoystickButton releaseBallButton1 = new JoystickButton(shooterController, Constants.MENU_BUTTON_R);
    //final JoystickButton liftArmButton = new JoystickButton(shooterController, Constants.FLIGHT_BUTTON_12);
    //final JoystickButton lowerArmButton = new JoystickButton(shooterController, Constants.FLIGHT_BUTTON_11);
    //final JoystickButton armOutButton = new JoystickButton(shooterController, Constants.XBOX_A_BUTTON);
    //final JoystickButton armInButton = new JoystickButton(shooterController,Constants.XBOX_B_BUTTON);
   
    
    //Button action
    
    //feedButton.toggleWhenPressed(m_feederCommand);

    armExtendButton.whileTrue(m_extendArmCommand);
    //stopPhotonVision.whileFalse(m_PhotonVisionCommand);
    smooarmButtton.whileTrue(m_ArmOutCommand);
    inArmButton.whileTrue(m_ArmInCommand);

    //squishArmButton.whileTrue(m_extendArmCommand);
    //shootButton.toggleWhenPressed(m_shootCommand);
    //pullButton.toggleWhenPressed(m_pullerCommand);
    //releaseBallButton.toggleWhenPressed(m_ReleasePullBallCommand);
    //releaseBallButton.toggleWhenPressed(m_reverseFeederCommand);

    //Shooter
    //liftArmButton.whileHeld(m_liftWinchCommand);
    //lowerArmButton.whileHeld(m_lowerWinchCommand);
   // armOutButton.whileHeld(m_ArmOutCommand);
   // armInButton.whileHeld(m_ArmInCommand);
    //shootButton1.toggleWhenPressed(m_shootCommand);
    //feedButton1.whileHeld(m_feederCommand);
    //pullerButton1.toggleWhenPressed(m_pullerCommand);
    //releaseBallButton1.toggleWhenPressed(m_ReleasePullBallCommand);
    //releaseBallButton1.toggleWhenPressed(m_reverseFeederCommand);
    //turnLeftThingyButton.toggleWhenPressed(m_TurnThingyLeftCommand);
    //turnRightThingyButton.toggleWhenPressed(m_TurnThingyRightCommand);
    //squishArmButton.whileHeld(m_SquishsArmCommand);

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
