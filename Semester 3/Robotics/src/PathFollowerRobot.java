import ch.aplu.robotsim.*;

public class PathFollowerRobot {
    static {
        RobotContext.setStartPosition(88, 455);
        RobotContext.useBackground("sprites/path.gif");
    }
    public PathFollowerRobot() {
        LegoRobot legoRobot = new LegoRobot();
        Gear gearBox = new Gear();
        LightSensor lightSensorL = new LightSensor(SensorPort.S2);
        LightSensor lightSensorR = new LightSensor(SensorPort.S1);
        
        legoRobot.addPart(gearBox);
        legoRobot.addPart(lightSensorL);
        legoRobot.addPart(lightSensorR);
        
        while(true){
            if(lightSensorL.getValue() > lightSensorR.getValue()){
                gearBox.leftArc(0.01);
            }
            else if(lightSensorL.getValue() < lightSensorR.getValue()) {
                gearBox.rightArc(0.01);
            }
            else {
                gearBox.forward();
            }
        }
    }

    public static void main(String[] args) {
        new PathFollowerRobot();
    }
}
