import ch.aplu.robotsim.*;

public class GearRobot{
    public GearRobot() {
        NxtRobot nxtRobot = new NxtRobot();
        Gear gear = new Gear();
        nxtRobot.addPart(gear);

        gear.setSpeed(150);
        gear.forward(100);
        gear.left(10);
        gear.right(20);
    }

    public static void main(String[] args) {
        new GearRobot();
    }
}
