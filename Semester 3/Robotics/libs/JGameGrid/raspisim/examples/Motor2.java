// Motor2.java
// Motors, both forward - one stop

import ch.aplu.raspisim.*;

public class Motor2
{
  public Motor2()
  {
    Robot robot = new Robot();
    Motor motB = new Motor(Motor.RIGHT);
    Motor motA = new Motor(Motor.LEFT);
    
    motA.forward();
    motB.forward();
    Tools.delay(2000);

    motA.stop();
    Tools.delay(2000);
    
    motB.stop();
    Tools.delay(2000);

    motA.backward();
    motB.backward();
    Tools.delay(2000);

    robot.exit();
  }

  public static void main(String[] args)
  {
    new Motor2();
  }
}