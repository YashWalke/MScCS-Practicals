// Infrared.java
// One IR sensor, event driven

import ch.aplu.raspisim.*;

public class Infrared2 implements InfraredListener
{
  private Gear gear;

  public Infrared2()
  {
    new Robot();
    gear = new Gear();
    InfraredSensor ir = new InfraredSensor(InfraredSensor.IR_CENTER);
    ir.addInfraredListener(this);
    gear.setSpeed(30);
    gear.forward();
  }

  public void bright(int id)
  {
    gear.backward(1200);
    gear.left(750);
    gear.forward();
  }

  public void dark(int id)
  {
  }

  public static void main(String[] args)
  {
    new Infrared2();
  }

  // ------------------ Environment --------------------------
  static
  {
    RobotContext.useObstacle("sprites/bar0.gif", 250, 100);
    RobotContext.useObstacle("sprites/bar1.gif", 400, 250);
    RobotContext.useObstacle("sprites/bar2.gif", 250, 400);
    RobotContext.useObstacle("sprites/bar3.gif", 100, 250);
  }
}
