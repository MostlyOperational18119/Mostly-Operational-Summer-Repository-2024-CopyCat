package org.firstinspires.ftc.teamcode

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.hardware.DcMotor

class DoernbecherTeleOp: LinearOpMode() {
    override fun runOpMode() {
        val motorFL = hardwareMap.get(DcMotor::class.java, "motorFL")
        val motorFR = hardwareMap.get(DcMotor::class.java, "motorFR")
        val motorBL = hardwareMap.get(DcMotor::class.java, "motorBL")
        val motorBR = hardwareMap.get(DcMotor::class.java, "motorBR")
        val speedDiv = 2.0

        telemetry.addData("Status", "Initialized")
        telemetry.update()
        waitForStart()
        while (opModeIsActive()) {
            val leftX = gamepad1.left_stick_x
            val leftY = -gamepad1.left_stick_y
            val rightX = gamepad1.right_stick_x

            motorFL.power = -(leftY - leftX - rightX) / speedDiv
            motorBL.power = -(leftY + leftX - rightX) / speedDiv
            motorFR.power = (leftY + leftX + rightX) / speedDiv
            motorBR.power = (leftY - leftX + rightX) / speedDiv

            telemetry.addData("Status", "Running")
            telemetry.addLine("motorFL: $motorFL motorFR: $motorFR motorBL: $motorBL motorBR: $motorBR ")
            telemetry.update()
        }
    }
}
