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
public class RobotSensorTrackFollower {
    static {
        RobotContext.setStartPosition(80, 438);
        RobotContext.useBackground("sprites/track.png");
    }
    
    public RobotSensorTrackFollower() {
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
        new RobotSensorTrackFollower();
    }
}
