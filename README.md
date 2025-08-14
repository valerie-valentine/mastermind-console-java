# Mastermind-Console-Java

Mastermind is a classic code-breaking game where your goal is to crack the correct number combination before running out of guesses. This Java application features Classic and Timed modes, with optional background sound to enhance gameplay.

## Classes & Responsibilities

| Class / Interface | Description | Key Methods / Features |
|------------------|------------|----------------------|
| **Game** | Main game controller; orchestrates gameplay | `startGame()`, `playGame()`, `checkIfGameOver()`, `restartGame()` |
| **Board** (Interface) | Contract for game boards | `hasGuessBeenPlayed()`, `evaluateUserGuess()`, `submitUserGuess()`, `getAttempts()`, `getAnswer()`, `getGameStatus()`, `getBackgroundSoundFile()` |
| **ClassicBoard** | Classic Mastermind logic implementation | Tracks attempts and guesses; determines win/loss; returns answer and board state |
| **TimedBoard** | Timed Mastermind logic | Wraps `ClassicBoard` and `Timer`; tracks time-based loss; starts timer thread |
| **Timer** | Runnable timer for timed mode | Counts down seconds, tracks if time is up, returns formatted time string |
| **Guess** | Stores a player's guess | `getGuess()`, `getCorrectNumber()`, `getCorrectLocation()`, setters for correctness tracking |
| **DifficultyLevel** (Enum) | Game difficulty levels | `EASY`, `MEDIUM`, `HARD`; `getCodeLength()` |
| **SoundPlayer** | Plays background audio | `playSound()`, `stopSound()`; loops audio |
| **GameUI** (Interface) | Contract for UI implementations | Input/output methods for instructions, guesses, feedback, and game over messages |
| **ClassicUI** | Console UI for classic mode | Implements `GameUI`; displays instructions, guess feedback, and results; uses `AsciiArt` |
| **TimedUI** | Console UI for timed mode | Wraps `ClassicUI`; adds timed-mode instructions and time-up messages |

## Code Design & Considerations
While reattempting this take-home challenge, my main goal was to build a fresh Java implementation of my console application. As a beginner in Java, I wanted it to differ significantly from my original Python script by fully embracing object-oriented programming, encapsulation, and core Java features such as Interfaces and Enums.

I also introduced Wrapper classes to reduce code repetition while allowing class-specific implementations. My models were refactored and simplified to follow stricter MVC principles. For example, in my earlier version, the view layer handled some game logic validation that belonged in the model layer. Now, the view is responsible only for basic input checks (like type and length), while all game logic validation resides in the business classes where it belongs.
    
    Model (Data Layer)
        The Model serves as the data layer and incorporates all game-related business logic.

    Controller (Translation Layer)
        The Controller acts as an intermediary between the Model and the View, ensuring these two layers do not directly interact.
        Its responsibility is to process input, retrieve relevant data from the Model, and determine what the View should display.

    View (Presentation Layer)
        The View retrieves user input and displays output to the user.
        It is responsible for all user-facing interactions, such as displaying instructions, feedback, and game progress.
        
## Challenges
The biggest challenge this time was programming in a brand-new language. I wanted to push myself to learn something new, so I chose Java. Coming from a Python background, the learning curve was steep—especially with syntax, access modifiers, and strict type-checking. Many of my Python approaches simply didn’t translate, which meant lots of research, trial and error, and rethinking solutions. In the end, I was able to connect my Python and OOP knowledge to build a working Java console game.

I also set out to add two new extensions: a timer and background sound. Both were challenging for different reasons.

For the timer, my initial goal was to have it display feedback alongside the game’s console output in real time. This would have required a deeper understanding of concurrent console output—something I’m not quite ready for—so I simplified it to display after each guess. I still wanted the timer to run independently and notify the game when time was up, so I learned the basics of threading. This gave me my first hands-on experience with multi-threading in Java.

For the sound, I ran into Git issues when pushing large .wav files, which broke my workflow. I had to remove them to continue development, but I plan to link the files separately. It was a quick but important reminder about what types of files should be excluded from Git.

## Extensions:
- Two Game Modes: Classic & Timed
- Timer
- Sound

## Setup for Sound:
- 

## How to Play:
1. Run the `main.py` script in your Java environment.
2. The game will start, and you will be prompted to choose a game mode: CLASSIC or TIMED.
3. Then to choose a difficulty level: easy, medium, or hard.
4. You will have 10 attempts to guess the correct number combination based on the chosen difficulty level:
   - Easy: 4 digits
   - Medium: 6 digits
   - Hard: 8 digits
5. After selecting the difficulty level, the game will provide you with instructions on how to play and the number of digits required for that level.
6. You will be prompted to make your guesses. Enter a 4, 6, or 8-digit number (depending on the difficulty level) as your guess. For example, if you're playing on the easy level, enter a 4-digit number like "1234."
7. The game will provide feedback after each guess. You will be told how many correct numbers are in your guess and how many of them are in the correct locations. For example, if you guessed "1234" and three of the numbers are correct but only one is in the correct position, you'll be told that you have "3 correct numbers and 1 correct location."
8. Continue making guesses until you either guess the correct combination or run out of attempts (10 attempts in total).
9. If you guess the correct combination, you win the game! If not, the game will reveal the correct combination.
10. The game ends, and you can choose to play again.

### Future updates:
- Currently supports multiple board types and future modes (Some ideas: emoji codes & words)
- Integrate my mastermind web API with the Java client to store user accounts.
- A menu & option to stop sound
- Mutli-player mode
