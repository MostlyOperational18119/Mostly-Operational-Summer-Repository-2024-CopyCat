package org.firstinspires.ftc.teamcode.TeleOp

import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import com.qualcomm.robotcore.hardware.DigitalChannel
import com.qualcomm.robotcore.hardware.TouchSensor
import org.firstinspires.ftc.teamcode.DriveMethods

    @O  verride
    @TeleOp(name = "magTest")
    class magTest : DriveMethods() {
    override fun runOpMode() {
        val mag = hardwareMap.get(DigitalChannel::class.java, "SkibidiToilet")
        mag.setMode(DigitalChannel.Mode.INPUT)
        waitForStart()

        while (opModeIsActive()) {
            telemetry.addData("is pressed", !mag.state)
            telemetry.update()
        }
    }
}