import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class TableTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test(){
        ArrayList<Hand> player = new ArrayList<>();
        Table t = new Table();

        // should pass
        assertFalse(t.startGame(4, 13, player));
        t.endGame(player);

        // should pass
        assertFalse(t.startGame(52, 1, player));
        t.endGame(player);

        //should return true, indicating the test didn't pass
        if(t.startGame(52, 30, player)){
            System.out.println("There are not enough cards in a deck to deal 30 cards to 52 players");
            t.endGame(player);
        }

    }
}
