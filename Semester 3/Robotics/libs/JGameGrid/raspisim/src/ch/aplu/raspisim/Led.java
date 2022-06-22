// Led.java

/*
 This software is part of the RaspiJLib library.
 It is Open Source Free Software, so you may
 - run the code for any purpose
 - study how the code works and adapt it to your needs
 - integrate all or parts of the code in your own programs
 - redistribute copies of the code
 - improve the code and release your improvements to the public
 However the use of the code is entirely your responsibility.
 */
package ch.aplu.raspisim;

import ch.aplu.jgamegrid.*;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Transparency;
import java.awt.image.BufferedImage;

/**
 Class that represents a LED pair.
 */
public class Led
{
  /** Constant for id of front LED pair */
  public static int LED_FRONT = 0;
  /** Constant for id of left LED pair */
  public static int LED_LEFT = 1;
  /** Constant for id of rear LED pair */
  public static int LED_REAR = 2;
  /** Constant for id of right LED pair */
  public static int LED_RIGHT = 3;

  private static final Location[] sensorPos =
  {
    new Location(23, 4),
    new Location(23, -4),
    new Location(5, -8),
    new Location(16, -8),
    new Location(-4, 4),
    new Location(-4, -4),
    new Location(16, 8),
    new Location(5, 8),
  };

  private static SingleLed[] sLeds = new SingleLed[8];

  static
  {
    for (int id = 0; id < 4; id++)
    {
      sLeds[2 * id] = null;
      sLeds[2 * id + 1] = null;
    }
  }

  // List of exiting leds
  private int id;

  /**
   * Creates a Led instance with given ID.
   * IDs of the double LEDs: 0: front, 1: left side , 2: rear, 3: right side.
   * The following global constants are defined:
   * LED_FRONT = 0, LED_LEFT = 1, LED_REAR = 2, RED_RIGHT = 3.
   * @param id the LED identifier
   */
  public Led(int id)
  {
    this.id = id;
  }

  protected void cleanup()
  {
  }

  /**
   * Sets the RGB color value of the two LEDs with current ID.
   * @param red the red color component 0..255
   * @param green the greed color component 0..255
   * @param blue the blue color component 0..255
   */
  synchronized public void setColor(int red, int green, int blue)
  {
    setColor(new Color(red, green, blue));
  }

  /**
   * Sets the RGB color value of the two LEDs with current ID.
   * @param color the RGB color
   */
  synchronized public void setColor(Color color)
  {
    RobotInstance.checkRobot();
    Robot robot = RobotInstance.getRobot();
    if (sLeds[2 * id] != null)
    {
      robot.removePart(sLeds[2 * id]);
      robot.removePart(sLeds[2 * id + 1]);
    }
    if (color.equals(Color.black))
    {
      sLeds[2 * id] = null;
      sLeds[2 * id + 1] = null;
    }
    else
    {
      BufferedImage bi = createLedImage(color);
      sLeds[2 * id] = new SingleLed(bi, sensorPos[2 * id]);
      sLeds[2 * id + 1] = new SingleLed(bi, sensorPos[2 * id + 1]);
    }
  }

  /**
   * Sets the RGB color value of all LEDs.
   * @param red the red color component 0..255
   * @param green the greed color component 0..255
   * @param blue the blue color component 0..255
   */
  synchronized public static void setColorAll(int red, int green, int blue)
  {
    setColorAll(new Color(red, green, blue));
  }

  /**
   * Sets the RGB color value of all LEDs.
   * @param color the RGB color
   */
  synchronized public static void setColorAll(Color color)
  {
    RobotInstance.checkRobot();
    Robot robot = RobotInstance.getRobot();
    BufferedImage bi = createLedImage(color);
    for (int id = 0; id < 4; id++)
    {
      if (sLeds[2 * id] != null)
      {
        robot.removePart(sLeds[2 * id]);
        robot.removePart(sLeds[2 * id + 1]);
      }
      if (color.equals(Color.black))
      {
        sLeds[2 * id] = null;
        sLeds[2 * id + 1] = null;
      }
      else
      {
        sLeds[2 * id] = new SingleLed(bi, sensorPos[2 * id]);
        sLeds[2 * id + 1] = new SingleLed(bi, sensorPos[2 * id + 1]);
      }  
    }
  }

  /**
   * Turns off all 4 LED pairs.
   */
  synchronized public static void clearAll()
  {
    setColorAll(Color.black);
  }

  private static BufferedImage createLedImage(Color c)
  {
    int size = 3;
    BufferedImage bi = new BufferedImage(size, size, Transparency.BITMASK);
    Graphics2D g2D = bi.createGraphics();

    // Set background color
    g2D.setColor(c);
    g2D.fillRect(0, 0, size, size);
    

    return bi;
  }

}
