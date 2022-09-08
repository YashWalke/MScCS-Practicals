/**
 * BasicRobot
 */

import ch.aplu.robotsim.*;
public class BasicRobot {
    public BasicRobot() {
        TurtleRobot turtleRobot = new TurtleRobot();
        turtleRobot.forward(100);
        turtleRobot.left(120);
        turtleRobot.backward(100);
        turtleRobot.right(120);
    }

    public static void main(String[] args) {
        new BasicRobot();
    }
}