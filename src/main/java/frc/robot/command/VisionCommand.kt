package frc.robot.command

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import edu.wpi.first.wpilibj2.command.CommandBase
import frc.robot.subsystem.VisionSystem

object VisionCommand: CommandBase() {
    init {
        addRequirements(VisionSystem)
    }

    override fun execute() {
        SmartDashboard.putNumber("VisionCommand: suggestedPower", VisionSystem.suggestedPower)
    }
}