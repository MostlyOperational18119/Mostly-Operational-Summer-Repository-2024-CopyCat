package org.firstinspires.ftc.teamcode.TeleOp

import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import com.qualcomm.robotcore.hardware.DcMotor
import org.firstinspires.ftc.teamcode.DriveMethods

@TeleOp(name = "pikle \uD83E\uDD70", group="pikle")
class pikle: DriveMethods() {
    @Override
    override fun runOpMode() {
//        val motor1 = hardwareMap.get(DcMotor::class.java, "m1")
//        val motor2 = hardwareMap.get(DcMotor::class.java, "m2")
//        val motor3 = hardwareMap.get(DcMotor::class.java, "m3")
        val flywheel_right = hardwareMap.get(DcMotor::class.java, "flywheel-right");
        val flywheel_left = hardwareMap.get(DcMotor::class.java, "flywheel-left");
        val flywheel_bottom = hardwareMap.get(DcMotor::class.java, "flywheel-bottom");
        val motorFR = hardwareMap.get(DcMotor::class.java, "motorFR");
        val motorFL = hardwareMap.get(DcMotor::class.java, "motorFL");
        val motorBR = hardwareMap.get(DcMotor::class.java, "motorBR");
        val motorBL = hardwareMap.get(DcMotor::class.java, "motorBL");
        val rotationMotor = hardwareMap.get(DcMotor::class.java, "rotationMotor");
        rotationMotor.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE;
        rotationMotor.mode = DcMotor.RunMode.STOP_AND_RESET_ENCODER;
        rotationMotor.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER;

        waitForStart()
        var flywheel_active = false;
        while (opModeIsActive()) {

            if (gamepad1.a && gamepad1.x && !flywheel_active) {
                flywheel_right.power = 1.0
                flywheel_left.power = 1.0
                flywheel_bottom.power = 1.0
                flywheel_active = true;
            }else if(gamepad1.a && gamepad1.x && flywheel_active){
                flywheel_right.power = 0.0
                flywheel_left.power = 0.0
                flywheel_bottom.power = 0.0
                flywheel_active = false;
            }
            if (gamepad1.dpad_up){
                rotationMotor.power = 0.2

            }else if (gamepad1.dpad_down){
                rotationMotor.power = -0.2
            }else{
                rotationMotor.power = 0.0;
            }
            telemetry.addLine("Rotation Motor Position: ${rotationMotor.currentPosition}");
            telemetry.update()
            sleep(50)
        }
    }
}