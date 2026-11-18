# Blackjack (Java)

A console based Blackjack game written in Java I created, originally built as a final project for CS 1060 (CS 1) at Pikes Peak State College.

## Overview

This project implements a terminal based version of Blackjack using object-oriented programming in Java. You play against an automated dealer across multiple rounds, with game results logged to a local text file and final win/loss/tie statistics displayed at the end of the session.

## Cool Features

- **Standard Blackjack Loop**: Play multiple rounds against the dealer with interactive **Hit (`h`)** and **Stand (`s`)** prompts.
- **Automated Dealer Logic**: The dealer conceals their second card during the player's turn and automatically hits until reaching a hand value of `17` or higher.
- **Number System Conversions**: Each card displays its point value in **decimal**, **binary**, and **hexadecimal** using custom base-conversion methods. Fun trivia I suppose.
- **Score Logging & Session Stats**: Records the outcome of every round to `blackjackscore.txt` and prints total wins, losses, and ties when you quit.

## Prerequisites

- **Java Development Kit (JDK)**: Version 8 or higher (`javac` and `java` available in your terminal). As long as you have this (you should) you can play.

## Getting Started

1. **Clone the repository**
   ```bash
   git clone https://github.com
   cd Blackjack/Source
   ```

2. **Compile the Java files**
   ```bash
   javac *.java
   ```

3. **Run the game**
   ```bash
   java Blackjack
   ```

## Project Structure

```text
Blackjack/
├── Source/
│   ├── Blackjack.java      # Entry point, game loop, turn handling, and file logging
│   ├── Card.java           # Card model with suit, rank, value, and binary/hex converters
│   ├── Deck.java           # 52-card deck initialization, shuffling, and dealing
│   ├── Player.java         # Player state, hand management, and win tracking
│   └── Dealer.java         # Subclass of Player with dealer-specific hit logic and display rules
└── README.md               # Project documentation
```

## How It Works

- **`Blackjack.java`**: Prompts for the player's name, runs the round loop, manages recursive player turns and iterative dealer turns, determines winners, writes round results to `blackjackscore.txt`, and outputs final stats.
- **`Deck.java`**: Builds a standard 52-card array (`2`–`10`, `Jack`–`King` = `10`, `Ace` = `11`), shuffles via random swaps, and deals cards sequentially.
- **`Player.java` & `Dealer.java`**: Demonstrates inheritance—`Dealer` extends `Player` to hide the face-down card (`displayFirstCard` / `displayHand`) and hit while hand value is below `17` (`shouldIHit`).
- **`Card.java`**: Stores card attributes and formats each card with custom `convertToBinary()` and `convertToHex()` helper methods.

## Known Limitations & Potential Future Improvements

- **Soft Aces**: Aces currently have a fixed value of `11` rather than dynamically adjusting to `1` when a hand exceeds `21`.
- **Deck Reshuffling**: The deck reshuffles at the start of every round rather than playing through a shoe.
- **Expanded Rules**: I could add betting/chip balances, Double Down, and Splitting pairs. It all depends on if I ever want to come back to this.

