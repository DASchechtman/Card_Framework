import java.util.ArrayList;

public class Table {
	private Deck deck;
    private Integer num_of_players;
    private Integer deal_size;

    Table(){
        deck = new Deck();
    }

    public boolean startGame(int number_of_players, int hand_size, ArrayList<Hand> players) {

        if(num_of_players == null){
            num_of_players = number_of_players;
        }
        if(deal_size == null){
            deal_size = hand_size;
        }

        boolean ret_val = false;
        try {
            deck.shuffle();
            for(int i = 0; i < num_of_players; i++) {
                Hand hand = new Hand(deal_size);
                deck.deal(hand);
                players.add(hand);
            }
        }
        catch(NotEnoughCardsException e) {
            ret_val = true;
        }
        return ret_val;
    }

    public void endGame(ArrayList<Hand> players){
        for(int i = players.size()-1; i >= 0; i--){
            players.get(i).returnCards(deck);
            players.remove(i);
        }
        num_of_players = null;
        deal_size = null;
    }

}
