import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Blackjack {
    public static void main(String[] args) throws IOException {
        Scanner scnr = new Scanner(System.in);
        PrintWriter outputFile = new PrintWriter("blackjackscore.txt");
        Deck deck = new Deck();
        String playerName = promptName(scnr);
        Player player = new Player(playerName);
        Dealer dealer = new Dealer();
        int losses = 0;
        int ties = 0;
        int round = 1;
        boolean keepPlaying = true;

        while (keepPlaying) {
            System.out.println("\n--- Round " + round + " ---");

            deck.shuffle();
            player.addCard(deck.dealCards());
            player.addCard(deck.dealCards());
            dealer.addCard(deck.dealCards());
            dealer.addCard(deck.dealCards());

            player.displayHand();
            System.out.println();
            dealer.displayFirstCard();
            System.out.println();

            playerTurn(player, deck, scnr);
            System.out.println();

            if (player.getHandValue() <= 21) {
                dealerTurn(dealer, deck);
                System.out.println();
            }

            String result = checkWinner(player, dealer);
            System.out.println("Result: " + result);
            saveToFile(outputFile, playerName, result, round);

            if (result.contains("win")) {
                player.addWin();
            } else if (result.contains("tie")) {
                ties++;
            } else {
                losses++;
            }

            player.clearHand();
            dealer.clearHand();
            round++;

            System.out.println();
            System.out.print("Play again? (y/n): ");
            String again = scnr.nextLine();
            if (again.equalsIgnoreCase("n")) {
                keepPlaying = false;
            }
        }

        System.out.println();
        printStats(player, losses, ties);
        outputFile.close();
        scnr.close();
    }

    public static String promptName(Scanner scnr) {
        System.out.print("Welcome to Blackjack! Please enter your name: ");
        String name = scnr.nextLine();
        return name;
    }

    public static void playerTurn(Player player, Deck deck, Scanner scnr) {
        System.out.println(player.getName() + "'s turn:");
        player.displayHand();
        System.out.println("Your hand value is: " + player.getHandValue());
        System.out.print("Would you like to hit or stand? (h/s): ");
        String choice = scnr.nextLine();
        if (choice.equalsIgnoreCase("h")) {
            Card newCard = deck.dealCards();
            player.addCard(newCard);
            System.out.println("You drew: " + newCard.toString());
            if (player.getHandValue() > 21) {
                System.out.println("Bust! Your hand value is: " + player.getHandValue());
            } else {
                playerTurn(player, deck, scnr);
            }
        } else if (choice.equalsIgnoreCase("s")) {
            System.out.println("You chose to stand with a hand value of: " + player.getHandValue());
        } else {
            System.out.println("This is a Invalid choice :(). Please enter 'h' to hit or 's' to stand.");
            playerTurn(player, deck, scnr);
        }
    }

    public static void dealerTurn(Dealer dealer, Deck deck) {
        System.out.println(dealer.getName() + "'s turn:");
        dealer.displayHand();
        System.out.println("Dealer's hand value is: " + dealer.getHandValue());
        while (dealer.shouldIHit()) {
            Card newCard = deck.dealCards();
            dealer.addCard(newCard);
            System.out.println(dealer.getName() + " drew: " + newCard.toString());
            System.out.println(dealer.getName() + "'s hand value is now: " + dealer.getHandValue());
            if (dealer.getHandValue() > 21) {
                System.out.println(dealer.getName() + " busts!");
                return;
            }
        }
        System.out.println("Dealer stands with a hand value of: " + dealer.getHandValue());
    }

    public static String checkWinner(Player player, Dealer dealer) {
        if (player.getHandValue() > 21) {
            return "Bust! You lose.";
        } else if (dealer.getHandValue() > 21) {
            return "Dealer busts! You win.";
        } else if (player.getHandValue() > dealer.getHandValue()) {
            return "You win!";
        } else if (player.getHandValue() < dealer.getHandValue()) {
            return "You lose.";
        } else {
            return "It's a tie!";
        }
    }

    public static void saveToFile(PrintWriter outputFile, String playerName, String result, int round) {
        outputFile.println("Round " + round + ": " + playerName + " - " + result);
    }

    public static void printStats(Player player, int losses, int ties) {
        System.out.println("--- Final Stats ---");
        System.out.println(player.getName() + "'s stats:");
        System.out.println("Wins: " + player.getWins());
        System.out.println("Losses: " + losses);
        System.out.println("Ties: " + ties);
    }
}
