package org.firstinspires.ftc.teamcode.TeleOp

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.Servo

@TeleOp(name = "SpinnyRobot", group = "Basic Chassis")
class spinnyBot : LinearOpMode() {
    override fun runOpMode() {
        val topMotor = hardwareMap.get(DcMotor::class.java, "topMotor")
        val spinnyMotor = hardwareMap.get(DcMotor::class.java, "spinnyMotor")
        val topServo = hardwareMap.get(Servo::class.java, "topServo")

        telemetry.addData("Status", "Initialized")
        telemetry.update()
        waitForStart()
        telemetry.addData("Status", "Running")
        while (opModeIsActive()) {
            val leftX = gamepad1.left_stick_x;

            if (gamepad1.right_trigger > 0.1 || gamepad1.left_trigger > 0.1) {
                spinnyMotor.power =
                    gamepad1.right_trigger.toDouble() - gamepad1.left_trigger.toDouble();
            } else {
                spinnyMotor.power = 0.0
            }

            topMotor.power = gamepad1.right_stick_y.toDouble()

            topServo.position = ((leftX + 1.0) / 2)
            telemetry.addLine("Top Motor Position: ${topMotor.currentPosition}");
            telemetry.addLine("Spinny Motor Position: ${spinnyMotor.currentPosition}");
            telemetry.addLine("Left Trigger: ${leftX}");
            telemetry.update()
        }
    }
}
