package org.firstinspires.ftc.teamcode.TeleOp

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import org.firstinspires.ftc.robotcore.external.hardware.camera.CameraName
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence
import org.firstinspires.ftc.vision.VisionPortal
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor

@TeleOp(name = "OdometryInTeleOp")
class OdometryInTeleOp : LinearOpMode() {
    override fun runOpMode() {
        val drive = SampleMecanumDrive(hardwareMap)
        val processor = AprilTagProcessor.easyCreateWithDefaults()!!
        val visionPortal = VisionPortal.Builder()
            .setCamera(hardwareMap.get(CameraName::class.java, "Webcam 1"))
            .addProcessor(processor)
            .build()


        waitForStart()

        while (opModeIsActive()) {
            if (!drive.isBusy) {
                val leftY = -gamepad1.left_stick_y.toDouble()
                val leftX = -gamepad1.left_stick_x.toDouble()
                val rightX = gamepad1.right_stick_x.toDouble()

                drive.setMotorPowers(
                    leftY - leftX + rightX,
                    leftY + leftX + rightX,
                    leftY - leftX - rightX,
                    leftY + leftX - rightX
                )

                if (gamepad1.a) {
                    var detection: AprilTagDetection? = null

                    processor.detections.forEach {
                        if (it.id == 1) detection = it
                    }

                    if (detection != null) {
                        val trajectorySequence =
                            calculateTrajectorySequenceApriltags(detection!!, drive)

                        drive.followTrajectorySequenceAsync(trajectorySequence)
                    } else {
                        telemetry.addLine("Unable to find an Apriltag with an ID of 1")
                        telemetry.update()
                    }
                }
            } else {
                drive.update()
                drive.updatePoseEstimate()

                telemetry.addData(
                    "Odometry info",
                    String.format(
                        "Pose: %s, Velocity: %s",
                        drive.poseEstimate.toString(),
                        drive.getWheelVelocities().toString()
                    )
                )
                telemetry.update()
            }
        }
    }

    private fun calculateTrajectorySequenceApriltags(
        detection: AprilTagDetection,
        drive: SampleMecanumDrive
    ): TrajectorySequence {
        val ftcPose = detection.ftcPose

        drive.update()
        drive.updatePoseEstimate()

        return drive.trajectorySequenceBuilder(drive.poseEstimate)
            .forward(ftcPose.x)
            .strafeRight(ftcPose.z)
            .build()
    }
}