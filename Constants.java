// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

   //motor ID
   public static final int LEFT_DRIVE_1 = 3;
   public static final int RIGHT_DRIVE_1 = 1;
   public static final int LEFT_DRIVE_2 = 2  ;
   public static final int ARM_SMOOTH_MOTOR = 7;
   public static final int TURN_MOTOR = 5;
   public static final int WINCH_MOTOR = 6;
   public static final int SHOOTER_MOTOR = 9;
   public static final int RIGHT_DRIVE_2 = 4;
   
   public static final int FEEDER_MOTOR = 1;
   //puller
   public static final int PULL_MOTOR = 55;

   //SPEED VALUES
   public static final double DRIVE_SPEED = 0.8;
   public static final double TURN_POWER = 0.3;
   public static final double WINCH_SPEED = 0.6;
   //Turn speed 
   public static final double TURN_SPEED = 0.5;
   //Puller speed

   public static final double PULL_SPEED = 0.5;
   //arm out and arm in speed
   public static final double ARMOUT_SPEED = 0.8;

   //Feeder Speed
   public static final double FEEDER_SPEED = 0.8;
   //Xbox controller
   public static final int LEFT_Y_AXIS = 1;
   public static final int LEFT_X_AXIS = 0;
   
   public static final int XBOX_CONTROLLER = 0;
   public static final int SHOOTER_CONTROLLER = 1;

   //WINCH
   public static final int LIFT_ARM = 9;
   public static final double STOP = 0;
   //shooter speed
   public static final double SHOOTER_SPEED = 0.8;
   
   
   
   
   //Button IDs
   public static final int RIGHT_STICK_Y = 3; //5 for flight, 3 for cntroller
   public static final int RIGHT_STICK_X = 4;
   public static final int LEFT_STICK_Y = 1;
   public static final int LEFT_STICK_X = 0;
   public static final int STICK_Z = 2;

   public static final int LEFT_TRIGGER = 2;
   public static final int RIGHT_TRIGGER = 3;

   public static final int XBOX_A_BUTTON = 1; 
   public static final int XBOX_B_BUTTON = 2;
   public static final int XBOX_X_BUTTON = 3;
   public static final int XBOX_Y_BUTTON = 4;

   //public static final int FLIGHT_BUTTON_5 = 5;
   //public static final int FLIGHT_BUTTON_6 = 6;
   public static final int SHOULDER_L = 5;
   public static final int SHOULDER_R = 6;
   public static final int MENU_BUTTON_L_7 = 7;
   public static final int MENU_BUTTON_R = 8;
   public static final int FLIGHT_BUTTON_9 = 9;
   public static final int FLIGHT_BUTTON_10 = 10;
   public static final int FLIGHT_BUTTON_11 = 11;
   public static final int FLIGHT_BUTTON_12 = 12;



   //LimeLight sub
   public static final int LIMELIGHT_PIPELINE = 0;

}

