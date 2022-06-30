/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package robotics;
import ch.aplu.robotsim.NxtRobot;
import ch.aplu.robotsim.Gear;
/**
 *
 * @author admin
 */
public class RobotGearSquare {

    public RobotGearSquare() {
        NxtRobot nxtRobot = new NxtRobot();
        Gear gearBox = new Gear();
        nxtRobot.addPart(gearBox);
        
        gearBox.setSpeed(100);
        
        while(true){
            gearBox.forward(1000);
            gearBox.left(280);
        }
    }
    
    public static void main(String[] args){
        new RobotGearSquare();
    }
    
}
