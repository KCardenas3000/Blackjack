public class Player { 
    private String name;
    private int handValue;
    private int wins;
    protected Card[] hand;
    protected int handSize;

    public Player(String name) {
        this.name = name;
        this.handValue = 0;
        this.wins = 0;
        this.hand = new Card[11];
        this.handSize = 0; 
        }
    public String getName() {
        return name;
        }
    public int getHandValue() {
        return handValue;
        }
    public int getWins() {
        return wins;
        }
    public void addCard(Card card) {
        if (handSize < hand.length) {
            hand[handSize++] = card;
            handValue += card.getValue();
        }
    }
    public void clearHand() { 
        handSize = 0;
        handValue = 0;
        for (int i = 0; i < hand.length; i++) {
            hand[i] = null;
        }
    }
    public void addWin() {
        wins++;
    }
    public void displayHand() {
        System.out.println(name + "'s hand:");
        for (int i = 0; i < handSize; i++) {
            System.out.println(hand[i].toString());
        }
    }
}
