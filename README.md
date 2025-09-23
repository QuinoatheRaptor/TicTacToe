# Tic Tac Toe Code
This is a simple Java program that lets the user simulate a game of tic tac toe against another user or three different difficulties of bots.

## Features
This code runs entirely in the terminal (no GUI yet unfortunately). It first asks the user to select an opponent who can either be another user or one of three difficulties of bots. The Every time a player makes a move the code checks that the move is within the bounds of the board and isn't in a spot that's already taken.

## Usage
When you run the code you will be prompted to select your opponent by typing in their number in the list and pressing enter. Afterwards you make your move by entering the row and the column you want to play in and then pressing enter (currently the user always goes first). The terminal prints a small graphic of the board with rows and columns labeled for convenience. If you're playing against a bot the bot will automatically make its move after you hit enter and an updated graphic will be printed to reflect this.

## The 3 Levels of Bot:
### The easy difficulty bot
The easy difficulty bot is the simplest. Every turn it takes a random spot.
### The medium difficulty bot
The medium difficulty bot has a bit more of a brain than the easy bot. On its turn it will look for ways it can win, ways to stop you from winning, and ways it can begin setting up its own win. Its pretty smart, but it can be beat using some simple gimmicks.
### The impossible difficulty bot
The impossible difficulty bot has a similar brain to the medium difficulty bot, but with a few added components that mostly come into play at the beginning of the game. The impossible bot always takes the middle at the start of the game unless you take the middle, in which case it takes a corner. This is a simple addition that breaks the gimmicks that beat the medium bot. The impossible bot isn't necessarily better at winning, but it never loses.

## Additional Notes
This code uses a class called KeyboardReader that my Intro to Comp Sci I professor helped our whole class develop for user input. It works a bit better than Java's scanner class by eliminating buffer errors and prompting the user for a new input if their input doesn't match the required data type. The class is static but I create an instance of it called 'r' so I don't have to write out KeyboardReader every time.dddd
