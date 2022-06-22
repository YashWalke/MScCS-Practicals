// Gear2.java
// Gear, speed

import ch.aplu.raspisim.*;

public class Gear2
{
  public Gear2()
  {
    Robot robot = new Robot();
    Gear gear = new Gear();
    int speed = 30;
    gear.setSpeed(speed);
    while (!robot.isEscapeHit())
    {
      gear.forward(2000);
      gear.backward(2000);
      speed += 10;
      gear.setSpeed(speed);
      System.out.println("speed: " + speed);
    }
    robot.exit();
  }

  public static void main(String[] args)
  {
    new Gear2();
  }
}
