package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.hardware.DcMotor;

public class TeleopFromMemory extends DriveMethods {
    @Override
    public void runOpMode() {
        DcMotor motorFL = hardwareMap.get(DcMotor.class, "motorFL");
        DcMotor motorBL = hardwareMap.get(DcMotor.class, "motorBL");
        DcMotor motorFR = hardwareMap.get(DcMotor.class, "motorFR");
        DcMotor motorBR = hardwareMap.get(DcMotor.class, "motorBR");
        double speedDiv = 2.0;

        while(opModeIsActive()) {
            double leftX = gamepad1.left_stick_x;
            double leftY = gamepad2.left_stick_y;
            double rightX = gamepad1.right_stick_x;

            
        }
    }
}
