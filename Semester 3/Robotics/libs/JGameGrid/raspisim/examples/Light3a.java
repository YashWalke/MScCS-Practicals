// Light3a.java
// LightSensor

import ch.aplu.jgamegrid.*;
import ch.aplu.raspisim.*;

public class Light3a
{
  public Light3a()
  {
    Robot robot = new Robot();
    Gear gear = new Gear();
    LightSensor lsL = new LightSensor(LightSensor.LS_FRONT_LEFT);
    LightSensor lsR = new LightSensor(LightSensor.LS_FRONT_RIGHT);
    gear.setSpeed(25);
    gear.forward();
    double s = 0.02;
    while (!robot.isEscapeHit())
    {
      double vL = lsL.getValue();
      double vR = lsR.getValue();
      double d = (vL - vR) / (vL + vR);
      if (d > -s && d < s)
        gear.forward();
      else if (d >= s)
        gear.rightArc(0.05);
      else
        gear.leftArc(0.05);
      Tools.delay(100);
    }
    robot.exit();
  }

  public static void main(String[] args)
  {
    new Light3a();
  }

  // ------------------ Environment --------------------------
  static
  {
    RobotContext.useTorch(1, 150, 250, 100);
    RobotContext.useTorch(1, 250, 250, 100);
    RobotContext.useTorch(1, 350, 250, 100);
  }
}
