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
public class RobotGears {

    public RobotGears() {
        NxtRobot nxtRobot = new NxtRobot();
        Gear gearBox = new Gear();
        nxtRobot.addPart(gearBox);
        
        gearBox.setSpeed(1000);
        int count = 1;
        while(true){
            if(count % 2 == 0){
                gearBox.backward(200);
            }
            else{
                gearBox.forward(200);
            }
            count++;
        }
    }
    
    public static void main(String[] args)
    {
        new RobotGears();
    }
}
