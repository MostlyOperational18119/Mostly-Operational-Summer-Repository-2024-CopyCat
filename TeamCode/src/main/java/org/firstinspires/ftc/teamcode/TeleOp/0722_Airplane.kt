package org.firstinspires.ftc.teamcode.TeleOp

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorSimple
import com.qualcomm.robotcore.hardware.Servo

@TeleOp(name = "AirplameTeleop", group="AAAAAAAAAAA")
class `0722_Airplane`: LinearOpMode() {
    override fun runOpMode() {
        val motorFL = hardwareMap.get(DcMotor::class.java, "motorFL")
        val motorFR = hardwareMap.get(DcMotor::class.java, "motorFR")
        val motorBL = hardwareMap.get(DcMotor::class.java, "motorBL")
        val motorBR = hardwareMap.get(DcMotor::class.java, "motorBR")
        val airplaneServo = hardwareMap.get(Servo::class.java, "airplaneServo")
        val launchMotor = hardwareMap.get(DcMotor::class.java, "aimMotor")

        motorFL.direction=DcMotorSimple.Direction.REVERSE;
        motorBL.direction=DcMotorSimple.Direction.REVERSE;
        motorBR.direction=DcMotorSimple.Direction.REVERSE;
        launchMotor.mode=DcMotor.RunMode.STOP_AND_RESET_ENCODER;
        launchMotor.mode=DcMotor.RunMode.RUN_USING_ENCODER;

        val lowerServoPosition = 0.65;
        val highestServoPosition = 0.95;
        val speedDiv = 2.0

        telemetry.addData("Status", "Initialized")
        telemetry.update()

        waitForStart()
        while (opModeIsActive()) {
            val leftX = gamepad1.left_stick_x
            val leftY = -gamepad1.left_stick_y
            val rightX = gamepad1.right_stick_x

            motorFL.power = (leftY + leftX + rightX) / speedDiv
            motorBL.power = (leftY - leftX + rightX) / speedDiv
            motorFR.power = (leftY - leftX - rightX) / speedDiv
            motorBR.power = (leftY + leftX - rightX) / speedDiv

            telemetry.addData("Status", "Running")


            if(gamepad1.a){
                airplaneServo.position=lowerServoPosition;
                sleep(1000)
            }else if (gamepad1.b) {
                airplaneServo.position=highestServoPosition;
                sleep(1000)
            }
            if(gamepad1.dpad_up && launchMotor.currentPosition<=250) {
                launchMotor.power=.07;
            }
            else if (gamepad1.dpad_down && launchMotor.currentPosition>=0) {
                launchMotor.power=-0.07;
            }
            else {
                launchMotor.power=0.0;
            }
            telemetry.addData("Rotate Pos", launchMotor.currentPosition);
            telemetry.update();
        }
    }
}
