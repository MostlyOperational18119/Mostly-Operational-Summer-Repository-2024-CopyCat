package org.firstinspires.ftc.teamcode.TeleOp

import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import com.qualcomm.robotcore.hardware.DcMotor
import org.firstinspires.ftc.teamcode.DriveMethods

@TeleOp(name = "test")
class test: DriveMethods() {
    override fun runOpMode() {
        val motorFL = hardwareMap.get(DcMotor::class.java, "motorFL")
        val motorFR = hardwareMap.get(DcMotor::class.java, "motorFR")
        val motorBL = hardwareMap.get(DcMotor::class.java, "motorBL")
        val motorBR = hardwareMap.get(DcMotor::class.java, "motorBR")

        while (opModeIsActive()) {
            val leftX = gamepad1.left_stick_x
            val leftY = gamepad1.left_stick_y
            val rightX = gamepad1.right_stick_x

            motorFL.power = (leftY + leftX + rightX).toDouble()
            motorBL.power = (leftY - leftX + rightX).toDouble()
            motorFR.power = (leftY - leftX - rightX).toDouble()
            motorBR.power = (leftY + leftX - rightX).toDouble()
        }
    }
}