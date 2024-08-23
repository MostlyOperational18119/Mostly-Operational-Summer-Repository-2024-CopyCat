package org.firstinspires.ftc.teamcode.TeleOp

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.Servo

@TeleOp(name = "picleMotorTester", group = "pikle")
class picle_motor_tester : LinearOpMode() {
    override fun runOpMode() {
        val flywheel_right = hardwareMap.get(DcMotor::class.java, "flywheel-right");
        val flywheel_left = hardwareMap.get(DcMotor::class.java, "flywheel-left");
        val flywheel_bottom = hardwareMap.get(DcMotor::class.java, "flywheel-bottom");
        val motorFR = hardwareMap.get(DcMotor::class.java, "motorFR");
        val motorFL = hardwareMap.get(DcMotor::class.java, "motorFL");
        val motorBR = hardwareMap.get(DcMotor::class.java, "motorBR");
        val motorBL = hardwareMap.get(DcMotor::class.java, "motorBL");
        val rotationMotor = hardwareMap.get(DcMotor::class.java, "rotationMotor");
        val gateServo = hardwareMap.get(Servo::class.java, "gateServo")
        val speedDiv = 2.0
        val gateOpen = 1.0
        val gateClosed = 0.0

        telemetry.addData("Status", "Initialized")
        telemetry.update()
        waitForStart()
        telemetry.addData("Status", "Running")
        while (opModeIsActive()) {
            if (gamepad1.a) {
                telemetry.addLine("Running motorFL");
                motorFL.power = 1.0;
            } else if (gamepad1.b) {
                telemetry.addLine("Running motorBL");
                motorBL.power = 1.0;
            } else if (gamepad1.x) {
                telemetry.addLine("Running motorBR");
                motorBR.power = 1.0;
            } else if (gamepad1.y) {
                telemetry.addLine("Running motorFR");
                motorFR.power = 1.0;
            } else {
                motorBL.power = 0.0;
                motorBR.power = 0.0;
                motorFL.power = 0.0;
                motorFR.power = 0.0;
            }
            if (gamepad2.a) {
                telemetry.addLine("Running flywheel_left");
                flywheel_left.power = 1.0;
//            }
//            else if(gamepad2.b){
                telemetry.addLine("Running flywheel_left");
                flywheel_right.power = 1.0;
//            }
//            else if(gamepad2.x){
                telemetry.addLine("Running flywheel_bottom");
                flywheel_bottom.power = 1.0;
            } else {
                flywheel_left.power = 0.0;
                flywheel_bottom.power = 0.0;
                flywheel_right.power = 0.0;
            }

            if (gamepad2.dpad_up) {
                gateServo.position = gateOpen;
                telemetry.addLine("Gate Open");
            }
            if (gamepad2.dpad_down) {
                gateServo.position = gateClosed;
                telemetry.addLine("Gate Closed");
            }
            telemetry.update()
            sleep(10)
        }
    }
}
