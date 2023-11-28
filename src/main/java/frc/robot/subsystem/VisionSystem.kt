package frc.robot.subsystem

import edu.wpi.first.networktables.NetworkTableInstance
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import edu.wpi.first.wpilibj2.command.SubsystemBase

object VisionSystem: SubsystemBase() {
    private val table = NetworkTableInstance.getDefault().getTable("limelight")

    val tx get(): Double = table.getEntry("tx").getDouble(0.0)
    val ty get(): Double = table.getEntry("ty").getDouble(0.0)
    val ta get(): Double = table.getEntry("ta").getDouble(0.0)
    val tv get(): Boolean = table.getEntry("tv").getDouble(0.0) == 1.0

    private data class PowerRange(val power: Double, val minD: Double, val maxD: Double)
    private val ranges: Array<PowerRange> = arrayOf(

    )

    val suggestedPower: Double get() {
        for (range in ranges) {
            if (ty in range.minD..range.maxD)
                return range.power
        }

        return 0.0
    }

    override fun periodic() {
        SmartDashboard.putNumber("VisionSystem: width", tx)
        SmartDashboard.putNumber("VisionSystem: height", ty)
        SmartDashboard.putNumber("VisionSystem: area", ta)
        SmartDashboard.putBoolean("VisionSystem: isValid", tv)
    }
}