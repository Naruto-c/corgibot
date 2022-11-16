package frc.robot.commands;

import frc.robot.MecanumDriveCTRE;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;

public class DriveCommand extends CommandBase{
    private final MecanumDriveCTRE mDrive;
    private final double mSpeedY;
    private final double mSpeedX;
    private final double mSpeedRot;

    public DriveCommand(double speedY, double speedX, double speedRot, MecanumDriveCTRE drive){
        mSpeedY = speedY;
        mSpeedX = speedX;
        mSpeedRot = speedRot;
        mDrive = drive;
    }

    @Override
  public void initialize() {}

  @Override
  public void execute() {
    mDrive.driveCartesian(mSpeedY, mSpeedX, mSpeedRot);
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
