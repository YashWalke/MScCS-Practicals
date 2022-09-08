import ch.aplu.robotsim.*;

public class TrackFollowerRobot {
    static {
        RobotContext.setStartPosition(80, 438);
        RobotContext.useBackground("sprites/track.png");
    }

    public TrackFollowerRobot() {
        LegoRobot legoRobot = new LegoRobot();
        Gear gearBox = new Gear();
        LightSensor lightSensor = new LightSensor(SensorPort.S3);
        
        legoRobot.addPart(gearBox);
        legoRobot.addPart(lightSensor);
        
        gearBox.forward();
        gearBox.setSpeed(100);
        
        while (true) {            
            if(lightSensor.getValue() > 10){
                gearBox.forward();
            }
            else{
                gearBox.rightArc(0.03);
            }
        }
    }

    public static void main(String[] args) {
        new TrackFollowerRobot();
    }
}
