package org.firstinspires.ftc.teamcode

import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import com.qualcomm.robotcore.hardware.DcMotor

@TeleOp(name = "pikle \uD83E\uDD70", group="pikle")
class pikle: DriveMethods() {
    @Override
    override fun runOpMode() {
        val motor1 = hardwareMap.get(DcMotor::class.java, "m1")
        val motor2 = hardwareMap.get(DcMotor::class.java, "m2")
        val motor3 = hardwareMap.get(DcMotor::class.java, "m3")
        waitForStart()
        while (opModeIsActive()) {
            if (gamepad1.a && gamepad1.x && gamepad1.left_stick_button) {
                motor1.power = 1.0
                motor2.power = 1.0
                motor3.power = 1.0
            }
        }
    }
}