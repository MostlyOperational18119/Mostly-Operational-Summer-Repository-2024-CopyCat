package org.firstinspires.ftc.teamcode

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName
import org.firstinspires.ftc.vision.VisionPortal
import org.firstinspires.ftc.vision.VisionProcessor
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor
import org.firstinspires.ftc.vision.tfod.TfodProcessor

abstract class DriveMethods: LinearOpMode() {
    fun createVisionPortal(processor: VisionProcessor): VisionPortal {
        val portal = VisionPortal.Builder()
            .addProcessors(processor)
            .setCamera(hardwareMap.get(WebcamName::class.java, "Webcam 1"))
            .build()

        return portal
    }

    fun createAprilTagProcessor(): AprilTagProcessor {
        return AprilTagProcessor.Builder().build()
    }

    fun createTfodProcessor(): TfodProcessor {
        val processor = TfodProcessor.Builder()
            .setModelAssetName("centerstage")
            .build()

        return processor
    }
}
