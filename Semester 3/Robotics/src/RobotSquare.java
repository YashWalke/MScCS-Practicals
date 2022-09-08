import ch.aplu.robotsim.*;

public class RobotSquare {
    NxtRobot nxtRobot;
    Motor motorLeft, motorRight;
    public RobotSquare() {
        nxtRobot = new NxtRobot();
		motorLeft = new Motor(MotorPort.A);
		motorRight = new Motor(MotorPort.B);
		
		nxtRobot.addPart(motorLeft);
		nxtRobot.addPart(motorRight);

        while (true) {
            for (int i = 0; i < 4; i++) {
                motorLeft.forward();
				Tools.delay(1090);
				motorRight.forward();

                Tools.delay(1090);
			    motorLeft.stop();
			    motorRight.stop();
            }
        }
    }

    public static void main(String[] args) {
        new RobotSquare();
    }
}
