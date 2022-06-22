// Light1.java
// LightSensor, polling

import ch.aplu.raspisim.*;

public class Light1
{
  public Light1()
  {
    Robot robot = new Robot();
    LightSensor ls = new LightSensor(LightSensor.LS_FRONT_LEFT);
    while (!robot.isEscapeHit())
    {
      int v = ls.getValue();
      System.out.println("v: " + v);
      Tools.delay(500);
    }  
    robot.exit();
  }

  public static void main(String[] args)
  {
    new Light1();
  }
  
  // ------------------ Environment --------------------------
  static
  {
    RobotContext.useTorch(1, 150, 250, 100);
  }
}