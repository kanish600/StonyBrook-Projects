import java.util.ArrayList;


public class Player {

	private ArrayList<Card> playerHand = new ArrayList<Card>();

	public Player() {
	}
	
	public void addCardToHand(Card card){
		playerHand.add(card);
	}
	
	public void placeCard(Card card){
		playerHand.remove(card);
	}
	
	public String printPlayerHand(){
		String playerCard="";
		for(int i=0; i<playerHand.size(); i++){
			playerCard += "("+i+") "+playerHand.get(i)+"\n";
		}
		return playerCard;
	}
	
	public ArrayList<Card> getPlayerHand(){
		return playerHand;
	}
}//class
