package org.firstinspires.ftc.teamcode.TeleOp

import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import com.qualcomm.robotcore.hardware.Servo
import com.qualcomm.robotcore.hardware.TouchSensor
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName
import org.firstinspires.ftc.teamcode.DriveMethods
import org.firstinspires.ftc.vision.VisionPortal

@TeleOp(name = "saarangtest")
class saarangtest : DriveMethods() {
    @Override
    override fun runOpMode() {
        val motor = hardwareMap.get(Servo::class.java, "saarang")
        val touch = hardwareMap.get(TouchSensor::class.java, "touch")
        val builder = VisionPortal.Builder()

        val cam = hardwareMap.get(WebcamName::class.java, "Webcam 1")
        builder.setCamera(cam)
        val portal = builder.build()

        val linear = hardwareMap.get(Servo::class.java, "linear")


        waitForStart()

        while (opModeIsActive()) {
            //if (touch.isPressed) {
            linear.position = 1.0
            sleep(1000)
            linear.position = 0.0
            sleep(1000)
            // }
        }
    }
}