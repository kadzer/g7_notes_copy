public class Player {

    private String name;
    private Hand hand;
    private boolean isBust;

    public Player(String name, Hand hand) {
        this.name = name;
        this.isBust = false;
        this.hand =hand;
    }

    public String getName() {
        return name;
    }

    public Hand getHand() {
        return hand;
    }

    public boolean isBust() {
        return isBust;
    }

    public void setBust(boolean bust) {
        this.isBust = bust;
    }

    public int getHandValue() {
        return this.hand.getHandValue();
    }


    public void addCardToHand(Card card) {
        this.hand.addCard(card);
    }

}
