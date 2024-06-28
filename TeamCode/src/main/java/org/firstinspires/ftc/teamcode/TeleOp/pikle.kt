package org.firstinspires.ftc.teamcode.TeleOp

import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorSimple
import org.firstinspires.ftc.teamcode.DriveMethods

@TeleOp(name = "pikle \uD83E\uDD70", group="pikle")
class pikle: DriveMethods() {
    @Override
    override fun runOpMode() {
//        val motor1 = hardwareMap.get(DcMotor::class.java, "m1")
//        val motor2 = hardwareMap.get(DcMotor::class.java, "m2")
//        val motor3 = hardwareMap.get(DcMotor::class.java, "m3")
        val flywheel_right = hardwareMap.get(DcMotor::class.java, "flywheel-right");
        flywheel_right.direction = DcMotorSimple.Direction.REVERSE
        val flywheel_left = hardwareMap.get(DcMotor::class.java, "flywheel-left");
        flywheel_left.direction = DcMotorSimple.Direction.REVERSE
        val flywheel_bottom = hardwareMap.get(DcMotor::class.java, "flywheel-bottom");
        flywheel_bottom.direction = DcMotorSimple.Direction.REVERSE

        val motorFR = hardwareMap.get(DcMotor::class.java, "motorFR");
        val motorFL = hardwareMap.get(DcMotor::class.java, "motorFL");
        val motorBR = hardwareMap.get(DcMotor::class.java, "motorBR");
        val motorBL = hardwareMap.get(DcMotor::class.java, "motorBL");
        motorBL.direction = DcMotorSimple.Direction.REVERSE;
        val rotationMotor = hardwareMap.get(DcMotor::class.java, "rotationMotor");
        rotationMotor.direction = DcMotorSimple.Direction.REVERSE;

        rotationMotor.mode = DcMotor.RunMode.STOP_AND_RESET_ENCODER;
        rotationMotor.targetPosition = 0;
        rotationMotor.mode = DcMotor.RunMode.RUN_TO_POSITION;
        rotationMotor.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE;

        waitForStart()
        var speedDiv = 2.0
        var target_position = 0;
        while (opModeIsActive()) {
            //leftX is intended for strafing
            val leftX = gamepad1.left_stick_x
            //leftY is intended for forward and backward
            val leftY = -gamepad1.left_stick_y
            //rigthX is indended for rotation
            val rightX = gamepad1.right_stick_x

            motorFL.power = (leftY + leftX + rightX) / speedDiv
            motorBL.power = (leftY - leftX + rightX) / speedDiv
            motorFR.power = (leftY - leftX - rightX) / speedDiv
            motorBR.power = (leftY + leftX - rightX) / speedDiv


            if (gamepad1.a) {
                if (flywheel_right.power<=0.9) {
                    flywheel_right.power += 0.02
                    flywheel_left.power += 0.02
                    flywheel_bottom.power += 0.02
                }else{
                    flywheel_right.power = 1.0
                    flywheel_left.power = 1.0
                    flywheel_bottom.power = 1.0
                }
            }else if(gamepad1.x){
                flywheel_right.power-= 0.2
                flywheel_left.power-= 0.2
                flywheel_bottom.power-= 0.2
                if (flywheel_right.power<0.1){
                    flywheel_right.power = 0.0;
                    flywheel_left.power = 0.0;
                    flywheel_bottom.power = 0.0;
                }
            }
            if (gamepad1.dpad_up){
                rotationMotor.targetPosition = 80
                rotationMotor.power = 0.2
                target_position = 0;
//                rotationMotor.
            }else if (gamepad1.dpad_down){
                rotationMotor.targetPosition = -700
                rotationMotor.power = 0.2
                target_position = 0;
            }else{
                if(target_position==0) {
                    rotationMotor.targetPosition = rotationMotor.currentPosition;
                    target_position = rotationMotor.currentPosition;
                }

                if (rotationMotor.currentPosition<-550){
                    telemetry.addLine("Setting motor power to 1.0");
                    rotationMotor.power = 1.0
                }else{
                    telemetry.addLine("Setting motor power to 0.2");
                    rotationMotor.power = 0.2
                }
            }
            telemetry.addLine("Rotation Motor Position: ${rotationMotor.currentPosition}");
            telemetry.update()
            sleep(50)
        }
    }
}