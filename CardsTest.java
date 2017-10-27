import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CardsTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test(){
        Cards c1 = new Cards();
        assertFalse(c1.setCard("Hearts", 11));

        // these if statements should run, indecating that there was an
        // error
        if(c1.setCard("Goats", 3)){
            System.out.println("Goats is not a suit");
        }
        if(c1.setCard("Clubs", 44)){
            System.out.println("numerical ranking is between 2 and 14");
            System.out.println("44 is not a valid card rank");
        }
        if(c1.setCard("SailBoats", 1000)){
            System.out.println("Both the suit and rank are invalid");
        }

        // This shows that the card will only be set to valid input
        // even when attempting to set the card invalidly
        assertFalse(c1.play());

        // This test that Cards stores the right messege
        // to display when being played
        Cards c2 = new Cards("Diamonds", 3);
        Cards c3 = new Cards("Spades", 12);

        assertEquals(c2.getCardTitle(), "3 of Diamonds");
        assertEquals(c3.getCardTitle(), "Q of Spades");
    }

}
