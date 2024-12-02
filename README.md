# Card

- A computer game that uses a set of cards.
- Each card has a number and a colour. The cards are saved in a text file CardValues.txt
- The program has a class named Card. Its atrributes and methods:

  ---
  - Number : INTEGER - The number of the card
  - Colour : STRING -  The colour of the card
  - Constructor() - Takes two values as parameters and sets them to private attributes
  - GetNumber() - Returns the number of the card
  - GetColour() - Returns the colour of the card
 
---
The text file CardValues.txt stores data for 30 cards, in the order : number, colour.
- Example : 
  - 1 is the number
  - red is the colour
- 1D array of type Cards is used to store all the cards read from the file

   ---
# Function - ChooseCard()
- Each player selects 4 cards from the 30 available
- Takes an integer to represent an array index from 1 to 30
- validates the value
- checks if the card is available
- loops until an available card is selected
- returns the index of the card if it is available
