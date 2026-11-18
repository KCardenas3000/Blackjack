public class Card {
    private String suit;
    private String rank;
    private int value;

    public Card(String suit, String rank, int value) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    public int getValue() {
        return value;
    }

    public static String convertToBinary(int value) {
        String binary = "";
        int temp = value;
        while (temp > 0) {
            binary = (temp % 2) + binary;
            temp = temp / 2;
        }
        return binary;
    }

    public static String convertToHex(int value) {
        String hex = "";
        int temp = value;
        while (temp > 0) {
            int remain = temp % 16;
            if (remain < 10) {
                hex = remain + hex;
            } else {
                hex = (char) ('A' + (remain - 10)) + hex;
            }
            temp = temp / 16;
        }
        return hex;
    }

    public String toString() {
        return rank + " of " + suit + " | Value: " + value +
                " | In Binary the value is: " + convertToBinary(value) +
                " | In Hex the value is: " + convertToHex(value);
    }
}