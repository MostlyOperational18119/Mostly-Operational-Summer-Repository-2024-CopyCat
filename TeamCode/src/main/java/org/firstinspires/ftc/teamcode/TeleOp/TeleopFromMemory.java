package org.firstinspires.ftc.teamcode.TeleOp;


import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.DriveMethods;

@TeleOp(name = "Basic Teleop", group = "Basic Chassis")
public class TeleopFromMemory extends DriveMethods {
    @Override
    public void runOpMode() {
        DcMotor motorFL = hardwareMap.get(DcMotor.class, "motorFL");
        DcMotor motorBL = hardwareMap.get(DcMotor.class, "motorBL");
        DcMotor motorFR = hardwareMap.get(DcMotor.class, "motorFR");
        DcMotor motorBR = hardwareMap.get(DcMotor.class, "motorBR");
        double speedDiv = 2.0;

        telemetry.addLine("Status");
        telemetry.addLine("Initialized");
        telemetry.update();

        waitForStart();
        while (opModeIsActive()) {
            double leftX = gamepad1.left_stick_x;
            double leftY = gamepad1.left_stick_y;
            double rightX = gamepad1.right_stick_x;

            motorFL.setPower(-(leftY - leftX + rightX) / speedDiv);
            motorBL.setPower(-(leftY + leftX + rightX) / speedDiv);
            motorBR.setPower((leftY - leftX - rightX) / speedDiv);
            motorFR.setPower((leftY + leftX - rightX) / speedDiv);
        }
    }
}
