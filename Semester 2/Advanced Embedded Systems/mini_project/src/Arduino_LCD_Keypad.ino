#include <Keypad.h>
#include <LiquidCrystal_I2C.h>

const int ROW_COUNT    = 4; // four rows
const int COLUMN_COUNT = 4; // four columns

char keyMap[ROW_COUNT][COLUMN_COUNT] = {
  {'1','2','3', 'A'},
  {'4','5','6', 'B'},
  {'7','8','9', 'C'},
  {'*','0','#', 'D'}
};

byte pinRows[ROW_COUNT] = {9, 8, 7, 6};      // connect to the row pinouts of the keypad
byte pinColumns[COLUMN_COUNT] = {5, 4, 3, 2}; // connect to the column pinouts of the keypad

Keypad keypad = Keypad(makeKeymap(keyMap), pinRows, pinColumns, ROW_COUNT, COLUMN_COUNT);
LiquidCrystal_I2C lcdDisplay(0x27, 16, 2); // I2C address 0x27, 16 column and 2 rows

int cursorColumn = 0;

void setup(){
	// initialize the LCD.
	lcdDisplay.init();
	lcdDisplay.backlight();
}

void loop(){
  char key = keypad.getKey();

  if (key) {
    lcdDisplay.setCursor(cursorColumn, 0); // move cursor to (cursorColumn, 0)
    lcdDisplay.print(key);                 // print key at   (cursorColumn, 0)

    cursorColumn++;                 // move cursor to next position
    if(cursorColumn == 16) {        // if all columns are used, clear the lcd
      lcdDisplay.clear();
      cursorColumn = 0;
    }
  }
}