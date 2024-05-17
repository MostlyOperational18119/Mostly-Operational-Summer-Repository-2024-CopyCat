package org.firstinspires.ftc.teamcode

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import com.qualcomm.robotcore.hardware.DcMotor
@TeleOp(name = "motorTester", group="Basic Chassis")
class motorTester: LinearOpMode() {
    override fun runOpMode() {
        val motorFL = hardwareMap.get(DcMotor::class.java, "motorFL")
        val motorFR = hardwareMap.get(DcMotor::class.java, "motorFR")
        val motorBL = hardwareMap.get(DcMotor::class.java, "motorBL")
        val motorBR = hardwareMap.get(DcMotor::class.java, "motorBR")
        val aimMotor = hardwareMap.get(DcMotor::class.java, "aimMotor")
        val speedDiv = 2.0

        telemetry.addData("Status", "Initialized")
        telemetry.update()
        waitForStart()
        telemetry.addData("Status", "Running")
        while (opModeIsActive()) {
            if(gamepad1.a){
                telemetry.addLine("Running motorFL");
                motorFL.power=1.0;
            }else if(gamepad1.b){
                telemetry.addLine("Running motorBL");
                motorBL.power=1.0;
            }else if(gamepad1.x){
                telemetry.addLine("Running motorBR");
                motorBR.power=1.0;
            }else if(gamepad1.y){
                telemetry.addLine("Running motorFR");
                motorFR.power=1.0;
            }else if(gamepad1.dpad_down){
                telemetry.addLine("Running AIM Motor Original Position: ${aimMotor.currentPosition}");
                aimMotor.power=0.1;
                sleep(80);
                aimMotor.power=0.0;
                telemetry.addLine("Running AIM Motor New Position: ${aimMotor.currentPosition}");
            }else{
                motorBL.power=0.0;
                motorBR.power=0.0;
                motorFL.power = 0.0;
                motorFR.power = 0.0;
                aimMotor.power = 0.0;
            }
            telemetry.update()
            sleep(10)
        }
    }
}
