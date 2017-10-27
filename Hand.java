import java.util.ArrayList;

public class Hand {
	private ArrayList<Cards> hand;
    private int hand_size;

    Hand(int size){
        hand_size = size;
        hand = new ArrayList<>();
    }

    public void addCard(Cards c) {
        hand.add(c);
    }

    public boolean returnCards(Deck deck) {
        for(int i = hand.size()-1; i >= 0; i--) {
            if(deck.addCard(hand.get(i))) {
                return true;
            }
            hand.remove(i);
        }
        return false;
    }

    public int getHandSize() {
        return hand_size;
    }
	
}