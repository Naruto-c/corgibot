package frc.robot.commands;

import frc.robot.MecanumDriveCTRE;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;

public class DriveCommand extends CommandBase{
    private final MecanumDriveCTRE mDrive;
    private final DoubleSupplier mSpeedY;
    private final DoubleSupplier mSpeedX;
    private final DoubleSupplier mSpeedRot;

    public DriveCommand(DoubleSupplier speedY, DoubleSupplier speedX, DoubleSupplier speedRot, MecanumDriveCTRE drive){
        mSpeedY = speedY;
        mSpeedX = speedX;
        mSpeedRot = speedRot;
        mDrive = drive;
    }

    @Override
  public void initialize() {}

  @Override
  public void execute() {
    mDrive.driveCartesian(mSpeedY.getAsDouble(), mSpeedX.getAsDouble(), mSpeedRot.getAsDouble());
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
