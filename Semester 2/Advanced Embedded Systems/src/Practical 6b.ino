int buzzer = 11;

void setup() {
  // put your setup code here, to run once:
  
}

void loop() {
  // put your main code here, to run repeatedly:
  int i = 0;
  do
  {
    i++;
    tone(buzzer, 450);
    delay(200);
    noTone(buzzer);
    delay(200);
  }
  while(i < 3);
  delay(3000);
}
