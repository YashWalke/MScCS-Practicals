#include<Servo.h>
//Create Servo object to control a Servo
Servo myservo;
// 12 servo objects can be created on most boards.
int pos;
void setup() {
  // put your setup code here, to run once:
  myservo.attach(9);  //Variable to store the servo position.
}

void loop() {
  // put your main code here, to run repeatedly:
  for(pos = 0; pos <= 180; pos += 1)
  {
    // Goes from 0 to 180 degrees with a step of 1
    myservo.write(pos); //Tell servo to go to position 'pos'.
    delay(15);  //Wait 15ms for the servo to reach the position 'pos'.
  }

  for(pos = 180; pos >= 0; pos -= 1)
  {
    // Goes from 180 to 0 degrees with a step of -1
    myservo.write(pos); //Tell servo to go to position 'pos'.
    delay(15);  //Wait 15ms for the servo to reach the position 'pos'.
  }
}
