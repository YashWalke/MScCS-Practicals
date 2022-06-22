// Light1.java
// LightSensor

import ch.aplu.jgamegrid.*;
import ch.aplu.raspisim.*;

public class Light2
{
  public Light2()
  {
    Robot robot = new Robot();
    Gear gear = new Gear();
    gear.leftArc(0.2);
    LightSensor ls = new LightSensor(LightSensor.LS_FRONT_LEFT);
    while (!robot.isEscapeHit())
    {
      double v = ls.getValue();
      System.out.println("v: " + v);
      Tools.delay(1000);
    }  
    robot.exit();
  }

  public static void main(String[] args)
  {
    new Light2();
  }
  
   static
  {
    RobotContext.useTorch(1, 150, 250, 100);
    RobotContext.showStatusBar(20);
  }
}