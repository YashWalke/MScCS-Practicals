// Button1.java

import ch.aplu.raspisim.*;

public class Button3
{
  public Button3()
  {
    Robot robot = new Robot();
    Gear gear = new Gear();
    boolean isRunning = true;
    while (isRunning)
    {
      if (robot.isButtonHit())
      {
        switch (robot.getHitButtonID())
        {
          case BrickButton.ID_DOWN:
            gear.backward();
            robot.drawString("down", 0, 0);
            break;
          case BrickButton.ID_UP:
            gear.forward();
            robot.drawString("up", 0, 0);
            break;
          case BrickButton.ID_LEFT:
            gear.left();
            robot.drawString("left", 0, 0);
            break;
          case BrickButton.ID_RIGHT:
            gear.right();
            robot.drawString("right", 0, 0);
            break;
          case BrickButton.ID_ENTER:
            gear.stop();
            robot.drawString("enter", 0, 0);
            break;
          case BrickButton.ID_ESCAPE:
            robot.drawString("escape", 0, 0);
            isRunning = false;
            break;
        }
      }
    }
    robot.exit();
  }

  public static void main(String[] args)
  {
    new Button3();
  }
}
