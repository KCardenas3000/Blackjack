public class Deck {
    private Card[] deck;
   private int currentCard;
   public Deck() {
       deck = new Card[52];
       String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
       String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
       int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};
       currentCard = 0;
       for (int i = 0; i < suits.length; i++) {
        for (int j = 0; j < ranks.length; j++) {
            deck[i * ranks.length + j] = new Card(suits[i], ranks[j], values[j]);
        }
       }
    }
    public void shuffle() {
        for (int i = 0; i < deck.length; i++) {
            int randomIndex = (int) (Math.random() * deck.length);
            Card temp = deck[i];
            deck[i] = deck[randomIndex];
            deck[randomIndex] = temp;
        }
        currentCard = 0;
    }
    public Card dealCards() {
        if (currentCard < deck.length) {
            return deck[currentCard++];
        } else {
            return null;
        }
    }
}