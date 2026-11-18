public class Dealer extends Player {
    public void displayFirstCard() {
        System.out.println(getName() + "'s hand:"); 
        System.out.println(getHand()[0].toString()); 
        System.out.println("The second card is face down."); 
}
    public Dealer() {
        super("Dealer");
    }
    public void displayHand() {
        System.out.println(getName() + "'s hand:");
        for (int i = 0; i < handSize; i++) {
            if (i == 1) {
                System.out.println("The second card is face down.");
            } else {
                System.out.println(getHand()[i].toString());
            }
        }
    }
    public Card[] getHand() {
        return super.hand; 
    }
    public boolean shouldIHit() {
        return getHandValue() < 17;
    }
}
