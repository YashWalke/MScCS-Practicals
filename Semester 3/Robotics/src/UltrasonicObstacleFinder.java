import ch.aplu.robotsim.*;
import java.awt.Color;
import java.awt.Point;

public class UltrasonicObstacleFinder {
    static {
        final Point[] mesh_bars = {
            new Point(10, 200), new Point(-10, 200),
            new Point(-10, -200), new Point(10, -200)
        };
        RobotContext.useTarget("sprites/bar1.gif", mesh_bars, 200, 250);
        RobotContext.useTarget("sprites/bar1.gif", mesh_bars, 300, 250);
        RobotContext.setStartPosition(250, 460);
    }

    public UltrasonicObstacleFinder() {
        LegoRobot legoRobot = new LegoRobot();
        Gear gear = new Gear();
        UltrasonicSensor ultrasonicSensor = new UltrasonicSensor(SensorPort.S1);
        ultrasonicSensor.setProximityCircleColor(Color.MAGENTA);
        legoRobot.addPart(gear);
        legoRobot.addPart(ultrasonicSensor);

        double arclength = 10.9;
        boolean isLeftArc = true;
        int oldDistance = 0;
        
        gear.setSpeed(50);
        gear.rightArc(arclength);
        
        while (true) {
            Tools.delay(100);
            int newDistance = ultrasonicSensor.getDistance();
            
            if (newDistance == -1) {
                continue;
            }
            if (oldDistance < newDistance) {
                if (isLeftArc) {
                    gear.leftArc(arclength);
                    isLeftArc = false;
                } else {
                    gear.rightArc(arclength);
                    isLeftArc = true;
                }
            }

            oldDistance = newDistance;
        }
    }

    public static void main(String[] args) {
        new UltrasonicObstacleFinder();
    }
}
