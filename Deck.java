import java.util.ArrayList;
import java.util.Random;

public class Deck {
	private ArrayList<Cards> deck;
    private Random rand;

    Deck(){
        rand = new Random(System.nanoTime());
        deck = new ArrayList<>();
        String []suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

        for(int i = 0; i < 4; i++) {
            for(int j = 2; j <=14; j++) {
                deck.add(new Cards(suits[i], j));
            }
        }

    }

    public void shuffle() {

		for(int i = 0; i < deckSize()*40; i++) {
			int card1 = rand.nextInt(deckSize());
			int card2 = rand.nextInt(deckSize());
			Cards hold = deck.get(card1);
			deck.set(card1, deck.get(card2));
			deck.set(card2, hold);
        }
    }

    
    // this function checks if more then half the deck
    // is shuffled
    public boolean compareTo(Deck d) {
        int cards_in_a_row_that_match = 0;
        for(int i = 0; i < deck.size(); i++) {
            if(deck.get(i).compare(d.getCard(i))) {
                cards_in_a_row_that_match++;
            }
        }
        return cards_in_a_row_that_match >= 26;
    }

    public Cards getCard(int i) {
        return deck.get(i);
    }

    public int deckSize() {
        return deck.size();
    }

    public boolean addCard(Cards c) {
        if(deck.size() < 52 && !deckHasCard(c)) {
            deck.add(c);
            return false;
        }
        return true;
    }

    public boolean deal(Hand h) throws NotEnoughCardsException {
        boolean ret_val = false;
        if(h.getHandSize() > deck.size()) {
            throw new NotEnoughCardsException();
        }
        else {
            int size = deck.size()-1;
            for(int i = size; i > size - h.getHandSize(); i--) {
                h.addCard(deck.get(i));
                deck.remove(i);
            }
        }
        return ret_val;
    }

    private boolean deckHasCard(Cards c) {
        boolean retval = false;
        for(Cards card : deck) {
            if(card.compare(c)) {
                retval = true;
                break;
            }
        }
        return retval;
    }
}