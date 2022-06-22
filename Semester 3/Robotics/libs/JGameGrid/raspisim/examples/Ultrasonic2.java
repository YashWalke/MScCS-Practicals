// Ultrasonic2.java
// Event driven ultrasonic sensor

import ch.aplu.raspisim.*;
import java.awt.Color;
import java.awt.Point;

public class Ultrasonic2 implements UltrasonicListener
{
  private Robot robot = new Robot();
  private Gear gear = new Gear();

  public Ultrasonic2()
  {
    UltrasonicSensor us = new UltrasonicSensor();
    us.addUltrasonicListener(this, 50);
    us.setBeamAreaColor(Color.green);
    us.setProximityCircleColor(Color.lightGray);
  
    gear.setSpeed(25);
    gear.forward();
  }

  public void far(int value)
  {
    System.out.println("far event");
  }

  public void near(int value)
  {
    System.out.println("near event");
    gear.backward(2000);
    gear.left(1000);
    gear.forward();
  }

  public static void main(String[] args)
  {
    new Ultrasonic2();
  }

  // ------------------ Environment --------------------------
  static
  {
    Point[] mesh_hbar =
    {
      new Point(200, 10), new Point(-200, 10),
      new Point(-200, -10), new Point(200, -10)
    };
    Point[] mesh_vbar =
    {
      new Point(10, 200), new Point(-10, 200),
      new Point(-10, -200), new Point(10, -200)
    };
    RobotContext.useTarget("sprites/bar0.gif", mesh_hbar, 250, 100);
    RobotContext.useTarget("sprites/bar0.gif", mesh_hbar, 250, 400);
    RobotContext.useTarget("sprites/bar1.gif", mesh_vbar, 100, 250);
    RobotContext.useTarget("sprites/bar1.gif", mesh_vbar, 400, 250);
  }

}
