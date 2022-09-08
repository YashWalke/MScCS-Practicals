import ch.aplu.robotsim.*;

public class BasicRobotSquare {
    public BasicRobotSquare() {
        TurtleRobot turtleRobot = new TurtleRobot();
        while (true) {
            turtleRobot.forward(100);
            turtleRobot.left(90);
        }
    }

    public static void main(String[] args) {
        new BasicRobotSquare();
    }
}
