/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package robotics;
import ch.aplu.robotsim.*;
/**
 *
 * @author admin
 */
public class RobotSensorLineFollower {
    static {
        RobotContext.setStartPosition(50, 470);
        RobotContext.useBackground("sprites/road.gif");
    }
    public RobotSensorLineFollower() {
        LegoRobot legoRobot = new LegoRobot();
        Gear gearBox = new Gear();
        LightSensor lightSensor = new LightSensor(SensorPort.S3);
        
        legoRobot.addPart(gearBox);
        legoRobot.addPart(lightSensor);
        
        gearBox.forward();
        gearBox.setSpeed(100);
        
        while (true) {            
            int lightSensorValue = lightSensor.getValue();
            if(lightSensorValue < 100)
                gearBox.forward();
            else if(lightSensorValue > 350 && lightSensorValue < 750)
                gearBox.leftArc(0.05);
            else if(lightSensorValue > 800)
                gearBox.rightArc(0.05);
        }
    }
    
    public static void main(String[] args) {
        new RobotSensorLineFollower();
    }
}
