// Led2.java
// Leds

import ch.aplu.raspisim.*;
import java.awt.Color;

public class Led2
{
  public Led2()
  {
    Robot robot = new Robot();
    while (!robot.isEnterHit());
    Led led = new Led(Led.LED_LEFT);
    System.out.println("Led created");
    while (!robot.isEnterHit());
    led.setColor(Color.yellow);
    System.out.println("Led yellow");
    while (!robot.isEnterHit());
    led.setColor(Color.red);
    System.out.println("Led red");
    while (!robot.isEnterHit());
    Led.clearAll();
    System.out.println("All cleared");
    robot.exit();
  }

  public static void main(String[] args)
  {
    new Led2();
  }
}
