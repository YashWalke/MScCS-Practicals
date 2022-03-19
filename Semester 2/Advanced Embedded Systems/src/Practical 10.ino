#define BLYNK_PRINT Serial
#include<ESP8266WiFi.h>
#include<BlynkSingleEsp8266_SSL.h>
// You should get Auth tokens from the Blynk app.
// Go to Project Settings > Auth Tokens > Copy All.
char auth[] = "YourAuthToken";
// Your wifi credentials
// Set password to "" for open networks.
char ssid[] = "YourNetworkName";
char pass[] = "YourPassword";
void setup() {
  // put your setup code here, to run once:
  // Debug console
  Serial.begin(9600);
  Blynk.begin(auth, ssid, pass);
}

void loop() {
  // put your main code here, to run repeatedly:
  Blynk.run();
}
