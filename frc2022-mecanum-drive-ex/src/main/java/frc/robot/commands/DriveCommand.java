package frc.robot.commands;

import frc.robot.MecanumDriveCTRE;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;

public class DriveCommand extends CommandBase{
    private final MecanumDriveCTRE mDrive;
    private final DoubleSupplier mSpeedY;
    private final DoubleSupplier mSpeedX;
    private final DoubleSupplier mSpeedRotL;
    private final DoubleSupplier mSpeedRotR;

    public DriveCommand(DoubleSupplier speedY, DoubleSupplier speedX, DoubleSupplier speedRotL, DoubleSupplier speedRotR, MecanumDriveCTRE drive){
        mSpeedY = speedY;
        mSpeedX = speedX;
        mSpeedRotL = speedRotL;
        mSpeedRotR = speedRotR;
        mDrive = drive;
    }

    @Override
  public void initialize() {}

  @Override
  public void execute() {
    mDrive.driveCartesian(mSpeedY.getAsDouble(), mSpeedX.getAsDouble(), mSpeedRotL.getAsDouble(), mSpeedRotR.getAsDouble());
  }

  @Override
  public void end(boolean interrupted) {
    mDrive.stopMotor();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
