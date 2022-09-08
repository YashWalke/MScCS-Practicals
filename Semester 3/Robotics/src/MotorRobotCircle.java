import ch.aplu.robotsim.*;

public class MotorRobotCircle {
    NxtRobot nxtRobot;
    Motor motorL, motorR;

    public MotorRobotCircle() {
        nxtRobot = new NxtRobot();
        motorL = new Motor(MotorPort.A);
        motorR = new Motor(MotorPort.B);

        nxtRobot.addPart(motorL);
        nxtRobot.addPart(motorR);

        while (true) {
            motorL.forward();
			Tools.delay(200);
			motorR.forward();

            Tools.delay(100);
			motorL.stop();
			motorR.stop();
        }
    }

    public static void main(String[] args) {
        new MotorRobotCircle();
    }
}
