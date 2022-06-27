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
public class RobotMotor {

    public RobotMotor() {
        NxtRobot nxtRobot = new NxtRobot();
        Motor motorLeft = new Motor(MotorPort.A);
        Motor motorRight = new Motor(MotorPort.B);
        
        nxtRobot.addPart(motorLeft);
        nxtRobot.addPart(motorRight);
        
        motorLeft.forward();
        motorRight.forward();
        
        //Right
        Tools.delay(1000);
        motorRight.stop();
        
        Tools.delay(1110);
        motorRight.forward();
        
        //Left
        Tools.delay(1000);
        motorLeft.stop();
        
        Tools.delay(1000);
        motorLeft.forward();
        
        Tools.delay(1000);
    }
    
    public static void main(String[] args){
        new RobotMotor();
    }
}
