package org.firstinspires.ftc.teamcode.TeleOp;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "microBot", group = "Basic Chassis")
public class microBot extends LinearOpMode {
    @Override
    public void runOpMode() {
        DcMotor motorR = hardwareMap.get(DcMotor.class, "motorR");
        DcMotor motorL = hardwareMap.get(DcMotor.class, "motorL");

        motorR.setDirection(DcMotorSimple.Direction.REVERSE);
        motorL.setDirection(DcMotorSimple.Direction.REVERSE);

        double speedDiv = 2.0;


        waitForStart();
        while (opModeIsActive()) {
            double leftY = gamepad1.left_stick_y;
            double leftX = gamepad1.left_stick_x;

            motorR.setPower((leftY + leftX) / speedDiv);
            motorL.setPower((leftY - leftX) / speedDiv);
        }
    }
}
