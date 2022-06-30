/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package robotics;

//Import packages
import ch.aplu.robotsim.*;

/**
 *
 * @author admin
 */
public class RobotSquare {

    public RobotSquare() {
        TurtleRobot turtleRobot = new TurtleRobot();
        while(true)
        {
            turtleRobot.forward(100);
            turtleRobot.right(90);
        //turtleRobot.exit();
        }
    }
    
    public static void main(String[] args){
        new RobotSquare();
    }
            
}
