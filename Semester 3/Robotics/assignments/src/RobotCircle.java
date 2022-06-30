/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotics;

import ch.aplu.robotsim.TurtleRobot;
/**
 *
 * @author admin
 */
public class RobotCircle {

    public RobotCircle() {
        TurtleRobot turtleRobot = new TurtleRobot();
        while(true)
        {
            turtleRobot.forward(2);
            turtleRobot.right(2);
        }
    }
    
    public static void main(String[] args){
        new RobotCircle();
    }
    
}
