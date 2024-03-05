package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.*;


public class IntakeSubsystem extends SubsystemBase {
    
    private VictorSPX rightMotor;
    private VictorSPX leftMotor;
    public AnalogInput sharp = new AnalogInput(0);

    
    public IntakeSubsystem(){
        rightMotor = new VictorSPX(3);
        leftMotor = new VictorSPX(4 );
        
        rightMotor.setInverted(true);
        leftMotor.setInverted(true);

        rightMotor.setSelectedSensorPosition(0);
        leftMotor.setSelectedSensorPosition(0);

    }

    public void setIntake(Boolean open){
        if (open == true){
            rightMotor.set(ControlMode.PercentOutput, Constants.Intake.INTAKE_SPEED);
            leftMotor.set(ControlMode.PercentOutput,  Constants.Intake.INTAKE_SPEED);
        }
        else{
            rightMotor.set(ControlMode.PercentOutput, 0.0);
            leftMotor.set(ControlMode.PercentOutput, 0.0); 
        }
    }
    public void setIntakeReversed(){
     
        rightMotor.set(ControlMode.PercentOutput, Constants.Intake.INTAKE_REVERSE_SPEED);
        leftMotor.set(ControlMode.PercentOutput, Constants.Intake.INTAKE_REVERSE_SPEED);

    }
    public void intakeToShooter(){

        rightMotor.set(ControlMode.PercentOutput, Constants.Intake.INTAKE_TO_SHOOTER_SPEED);
        leftMotor.set(ControlMode.PercentOutput, Constants.Intake.INTAKE_TO_SHOOTER_SPEED);
    }
    public void autoIntake(){
      
        rightMotor.set(ControlMode.PercentOutput, Constants.Intake.INTAKE_AUTO_SPEED);
        leftMotor.set(ControlMode.PercentOutput, Constants.Intake.INTAKE_AUTO_SPEED);
    }

    @Override
    public void periodic(){
        double val = sharp.getValue();
        if (val > Constants.Intake.INTAKE_SHARP_VALUE_LIMIT){
            SmartDashboard.putBoolean("Intake Durum", true);
        }
        else {
            SmartDashboard.putBoolean("Intake Durum", false);
        }
    }
}