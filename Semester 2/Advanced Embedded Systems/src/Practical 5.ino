#include<Keypad.h>
#include<Key.h>
const byte rows = 4;
const byte cols = 4;
char keys[rows][cols] = {
  {'1', '2', '3', 'A'},
  {'4', '5', '6', 'B'},
  {'7', '8', '9', 'C'},
  {'*', '0', '#', 'D'}
};

byte colPins[rows] = {5, 4, 3, 2}; //Connect to the row pinouts of keypad.
byte rowPins[cols] = {9, 8, 7, 6}; //Connect to the row pinouts of keypad.
Keypad keypad = Keypad(makeKeymap(keys), rowPins, colPins, rows, cols);

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
}

void loop() {
  // put your main code here, to run repeatedly:
  char key = keypad.getKey();
  if(key)
  {
    Serial.println(key);
  }
}
