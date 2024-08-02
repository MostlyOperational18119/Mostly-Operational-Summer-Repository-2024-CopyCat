package org.firstinspires.ftc.teamcode.TeleOp

import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorSimple.Direction as MotorDirection
import org.firstinspires.ftc.teamcode.DriveMethods
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection

class AprilTagTest: DriveMethods() {
    override fun runOpMode() {
        // Setup vision
        val aprilTagProcessor = createAprilTagProcessor()
        val portal = createVisionPortal(aprilTagProcessor)
        val targetTagID = 2

        // Init motors
        val motorFL = hardwareMap.get(DcMotor::class.java, "motorFL")
        val motorFR = hardwareMap.get(DcMotor::class.java, "motorFR")
        val motorBL = hardwareMap.get(DcMotor::class.java, "motorBL")
        val motorBR = hardwareMap.get(DcMotor::class.java, "motorBR")

        // Reverse motors as needed
        motorFR.direction = MotorDirection.REVERSE

        // Create detection variable for storage
        var detection: AprilTagDetection

        // Tell the user that we initialized successfully
        telemetry.addLine("Initialized")
        telemetry.update()
        waitForStart()

        while (opModeIsActive()) {
            val detections = aprilTagProcessor.detections
            detections.forEach {
                if (it.id == targetTagID) detection = it
            }


        }
    }
}