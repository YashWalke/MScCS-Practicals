int f = 13;
int g = 12;
int e = 11;
int d = 10;
int c = 9;
int b = 8;
int a = 7;
int delay_ms = 1000;
int count = 0x00;
void setup() {
// put your setup code here, to run once:
pinMode(13, OUTPUT);
pinMode(12, OUTPUT);
pinMode(11, OUTPUT);
pinMode(10, OUTPUT);
pinMode(9, OUTPUT);
pinMode(8, OUTPUT);
pinMode(7, OUTPUT);
}

void loop() {
	// put your main code here, to run repeatedly:
	/*
				a
			---
	f |g | b
			 ---
		 e |	| c
			---
			d
	*/
	digitalWrite(a, 1);
	digitalWrite(b, 1);
	digitalWrite(c, 1);
	digitalWrite(d, 1);
	digitalWrite(e, 1);
	digitalWrite(f, 1);
	digitalWrite(g, 0);
	
	delay(delay_ms); //0
	
	digitalWrite(a, 0);
	digitalWrite(b, 1);
	digitalWrite(c, 1);
	digitalWrite(d, 0);
	digitalWrite(e, 0);
	digitalWrite(f, 0);
	digitalWrite(g, 0);
	
	delay(delay_ms); //1
	
	digitalWrite(a, 1);
	digitalWrite(b, 1);
	digitalWrite(c, 0);
	digitalWrite(d, 1);
	digitalWrite(e, 1);
	digitalWrite(f, 0);
	digitalWrite(g, 1);
	
	delay(delay_ms); //2
	
	digitalWrite(a, 1);
	digitalWrite(b, 1);
	digitalWrite(c, 1);
	digitalWrite(d, 1);
	digitalWrite(e, 0);
	digitalWrite(f, 0);
	digitalWrite(g, 1);
	
	delay(delay_ms); //3
	
	digitalWrite(a, 0);
	digitalWrite(b, 1);
	digitalWrite(c, 1);
	digitalWrite(d, 0);
	digitalWrite(e, 0);
	digitalWrite(f, 1);
	digitalWrite(g, 1);
	
	delay(delay_ms); //4
	
	digitalWrite(a, 1);
	digitalWrite(b, 0);
	digitalWrite(c, 1);
	digitalWrite(d, 1);
	digitalWrite(e, 0);
	digitalWrite(f, 1);
	digitalWrite(g, 1);
	
	delay(delay_ms); //5
	
	digitalWrite(a, 0);
	digitalWrite(b, 0);
	digitalWrite(c, 1);
	digitalWrite(d, 1);
	digitalWrite(e, 1);
	digitalWrite(f, 1);
	digitalWrite(g, 1);
	
	delay(delay_ms); //6
	
	digitalWrite(a, 1);
	digitalWrite(b, 1);
	digitalWrite(c, 1);
	digitalWrite(d, 0);
	digitalWrite(e, 0);
	digitalWrite(f, 0);
	digitalWrite(g, 0);
	
	delay(delay_ms); //7
	
	digitalWrite(a, 1);
	digitalWrite(b, 1);
	digitalWrite(c, 1);
	digitalWrite(d, 1);
	digitalWrite(e, 1);
	digitalWrite(f, 1);
	digitalWrite(g, 1);
	
	delay(delay_ms); //8
	
	digitalWrite(a, 1);
	digitalWrite(b, 1);
	digitalWrite(c, 1);
	digitalWrite(d, 0);
	digitalWrite(e, 0);
	digitalWrite(f, 1);
	digitalWrite(g, 1);
	
	delay(delay_ms); //9
}
