import ch.aplu.robotsim.*;

public class MotorRobot {
    public MotorRobot() {
        NxtRobot nxtRobot = new NxtRobot();
        Motor motorL = new Motor(MotorPort.A);
        Motor motorR = new Motor(MotorPort.B);

        nxtRobot.addPart(motorL);
        nxtRobot.addPart(motorR);

        // Move forward
        motorL.forward();
        motorR.forward();

        // Move Left
        Tools.delay(1000);
        motorL.stop();

        Tools.delay(1110);
        motorL.forward();

        // Move Right
        Tools.delay(1000);
        motorR.stop();

        Tools.delay(1110);
        motorR.forward();
    }

    public static void main(String[] args) {
        new MotorRobot();
    }
}
