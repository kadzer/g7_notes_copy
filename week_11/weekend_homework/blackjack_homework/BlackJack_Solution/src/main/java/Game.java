import java.util.ArrayList;

public class Game {

    private Deck deck;
    private Dealer dealer;
    private ArrayList<Player> players;

    public Game(Deck deck, ArrayList<Player> players, Dealer dealer) {
        this.deck = deck;
        this.dealer = dealer;
        this.players = players;
    }


    public void startGame() {
        for (Player player : players){
            for (int i = 0; i<2; i++){
                dealer.dealCard(player, this.deck);
            }
        }

    }


    public void twist(Player player){
        if(!checkBust(player)) {
            dealer.dealCard(player, this.deck);
        }
    }

    private boolean checkBust(Player player){
        if (player.getHandValue() > 21){
            player.setBust(true);
        }
        return player.isBust();
    }



    public Player checkWinner(){
       Player winner = this.players.get(0);
        for (Player player : this.players){
            if (player.getHandValue() > winner.getHandValue() && !player.isBust()){
                winner = player;
            }
        }
        return winner;
    }
}
