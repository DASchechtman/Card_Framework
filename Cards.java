

public class Cards {
	 private String suit;
	    private Integer rank;
	    private String []non_numeric_ranks  = {"J", "Q", "K", "A"};
	    private String card_title;

	    Cards(){}

	    Cards(String suit, Integer rank){
	        if(isASuit(suit) && isARank(rank)) {
	            this.suit = suit;
	            this.rank = rank;
	            card_title = getDisplayRank()+suit;
	        }
	    }

	    public boolean setCard(String suit, Integer rank) {
	        boolean ret_val = false;
	        if(!isASuit(suit) || !isARank(rank)) {
	            ret_val = true;
	        }
	        else {
	            this.suit = suit;
	            this.rank = rank;
	            card_title = getDisplayRank()+suit;
	        }
	        return ret_val;
	    }

	    public boolean play() {
	        boolean ret_val = false;
	        if(suit == null || rank == null) {
	            ret_val = true;
	        }
	        else {
	            System.out.println(card_title);
	        }
	        return ret_val;
	    }

	    public String getCardTitle(){
	        return card_title;
	    }

	    public Integer getRank() {
	        return rank;
	    }

	    public String getSuit() {
	        return suit;
	    }

	    public boolean compare(Cards c) {
	        return rank.equals(c.getRank()) && suit.equals(c.getSuit());
	    }

	    private boolean isASuit(String suit) {
	        return suit == "Hearts" || suit == "Clubs" || suit == "Spades" || suit == "Diamonds";
	    }

	    private boolean isARank(int rank) {
	        return rank >= 2 && rank <= 14;
	    }

	    private String getDisplayRank() {
	        String display_rank = "";
	        if (rank > 10) {
	            display_rank += non_numeric_ranks[rank-11] + " of ";
	        }else {
	            display_rank += Integer.toString(rank) + " of ";
	        }
	        return display_rank;
	    }
}
