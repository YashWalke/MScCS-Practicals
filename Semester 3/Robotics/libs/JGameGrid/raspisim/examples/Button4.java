// Button4.java

import ch.aplu.raspisim.*;

public class Button4 implements ButtonListener
{
  private Robot robot = new Robot();
  private Gear gear = new Gear();

  public Button4()
  {
    robot.addButtonListener(this);
  }

  public void buttonHit(int buttonID)
  {
    switch (buttonID)
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
        robot.exit();
        break;
    }
  }

  public static void main(String[] args)
  {
    new Button4();
  }
}
