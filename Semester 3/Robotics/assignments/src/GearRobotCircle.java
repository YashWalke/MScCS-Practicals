import ch.aplu.robotsim.*;

public class GearRobotCircle {
    public GearRobotCircle() {
        NxtRobot nxtRobot = new NxtRobot();
        Gear gear = new Gear();
        nxtRobot.addPart(gear);

        gear.setSpeed(1000);
        while (true) {
            gear.rightArc(0.5);
        }
    }

    public static void main(String[] args) {
        new GearRobotCircle();
    }
}
