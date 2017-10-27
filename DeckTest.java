import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DeckTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void test(){
	        // creates 2 decks. One will be shuffled
	        // one won't be shuffled, so that Deck's
	        // shuffle can be tested properly
	        Deck deck1 = new Deck();
	        Deck deck2 = new Deck();

	        deck1.shuffle();

	        for(int i = 0; i < 1000; i++){
	            assertFalse(deck1.compareTo(deck2));
	            deck1.shuffle();
	        }

	        // tests the deck's ability to deal out cards
	        // Hand will act as the player

	        ArrayList<Hand> players = new ArrayList<>();
	        try{
	            for(int i = 0; i < 6; i++){
	                players.add(new Hand(5));
	                assertFalse(deck1.deal(players.get(i)));
	            }
	            System.out.println("returning cards to deck");

	            for(int i = players.size()-1; i >= 0; i--){
	                players.get(i).returnCards(deck1);
	                players.remove(i);
	            }
	        }
	        catch (NotEnoughCardsException e){}

	        // This should fail
	        try{
	            for(int i = 0; i < 6; i++){
	                players.add(new Hand(10));
	                deck1.deal(players.get(i));
	            }
	        }
	        catch (NotEnoughCardsException e){
	            System.out.println("Not enough cards in the deck to give each player a hand");
	            System.out.println("Tried to deal 60 cards, there are only 52 per deck");
	            for(int i = 0; i < players.size(); i++){
	                players.get(i).returnCards(deck1);
	                players.remove(i);
	            }
	        }

	    }

}
