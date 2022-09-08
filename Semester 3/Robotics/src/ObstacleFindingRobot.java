import ch.aplu.robotsim.*;

public class ObstacleFindingRobot {
    static {
        RobotContext.setStartPosition(15, 240);
        RobotContext.useObstacle(RobotContext.channel);
        RobotContext.setStartDirection(30);
    }

    public ObstacleFindingRobot() {
        LegoRobot legoRobot = new LegoRobot();
        Gear gear = new Gear();
        TouchSensor touchSensorL = new TouchSensor(SensorPort.S2);
        TouchSensor touchSensorR = new TouchSensor(SensorPort.S1);
        
        legoRobot.addPart(gear);
        legoRobot.addPart(touchSensorL);
        legoRobot.addPart(touchSensorR);
        
        gear.forward();
        while(true) {
            if(touchSensorL.isPressed() && touchSensorR.isPressed()) {
                gear.backward(40);
                gear.right(400);
                gear.forward();
            }
            else {
                if (touchSensorL.isPressed()) {
                    gear.backward(40);
                    gear.right(400);
                    gear.forward();
                }
                else if(touchSensorR.isPressed()) {
                    gear.backward(40);
                    gear.left(400);
                    gear.forward();
                }
                else {
                    gear.forward();
                }
            }
        }
    }

    public static void main(String[] args) {
        new ObstacleFindingRobot();
    }
}
