// Led3.java
// Leds mit Gear

import ch.aplu.raspisim.*;
import java.awt.Color;

public class Led3
{
  public Led3()
  {
    Robot robot = new Robot();
    Gear gear = new Gear();
    Led.setColorAll(Color.white);
    gear.leftArc(0.5);
    for (int i = 0; i < 4; i++)
    {
      Tools.delay(2000);
      Led.setColorAll(Color.black);
      Tools.delay(2000);
      Led.setColorAll(Color.white);
    }
    System.out.println("All done");
    robot.exit();
  }

  public static void main(String[] args)
  {
    new Led3();
  }
}
