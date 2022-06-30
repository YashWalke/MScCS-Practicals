/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package robotics;

//Import packages
import ch.aplu.robotsim.*;
import java.util.Scanner;
/**
 *
 * @author admin
 */

public class RobotMotorSquare {
	NxtRobot nxtRobot;
	Motor motorLeft, motorRight;
	
	public RobotMotorSquare() {
		nxtRobot = new NxtRobot();
		motorLeft = new Motor(MotorPort.A);
		motorRight = new Motor(MotorPort.B);
		
		nxtRobot.addPart(motorLeft);
		nxtRobot.addPart(motorRight);
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter l for left and r for right:");
		char direction = scanner.nextChar();
		
		switch(direction){
			case 'l':
				moveRobot("left");
			break;
			
			case 'r':
				moveRobot("right");
			break;
			
			default:
				System.out.println("Please specify the correct direction");
				System.exit(1);
			break;
		}
	}
	
	public void moveRobot(String direction) {
		for(int i = 0; i < 4; i++) {
			if(direction == "left") {
				motorLeft.forward();
				Tools.delay(1090);
				motorRight.forward();
			}
			else {
				motorRight.forward();
				Tools.delay(1090);
				motorLeft.forward();
			}
			
			Tools.delay(1090);
			motorLeft.stop();
			motorRight.stop();
		}
	}
	
	public static void main(String[] args) {
		new RobotMotorSquare();
	}
}