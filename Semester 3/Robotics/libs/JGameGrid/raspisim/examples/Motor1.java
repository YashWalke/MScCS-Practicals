// Motor1.java
// Motors both forward - backward

import ch.aplu.raspisim.*;

public class Motor1
{
  public Motor1()
  {
    Robot robot = new Robot();
    Motor motL = new Motor(Motor.LEFT);
    Motor motR = new Motor(Motor.RIGHT);
    
    motL.forward();
    motR.forward();
    Tools.delay(2000);

    motL.backward();
    motR.backward();
    Tools.delay(2000);

    motL.stop();
    Tools.delay(2000);

    motR.stop();
    Tools.delay(2000);

    robot.exit();
  }

  public static void main(String[] args)
  {
    new Motor1();
  }
}