import java.util.Collections;
import java.util.ArrayList;

public class Deck {

	private ArrayList<Card> drawPile = new ArrayList<Card>();
	private ArrayList<Card> discardPile = new ArrayList<Card>();
	
	public Deck(){
		this.drawPile=drawPile;
		this.discardPile=discardPile;
	}
	
	public void addCards(){
		for(int i=1; i<7; i++){
			String name = "";
			if (i==1){
				name="Big Bird";
			}
			else if(i==2){
				name="Zoe";
			}
			else if(i==3){
				name="Cookie Monster";
			}
			else if(i==4){
				name="Elmo";
			}
			else if(i==5){
				name="Baby Bear";
			}
			else if(i==6){
				name="Rosita";
			}
			else if(i==7){
				name="Grover";
			}
			drawPile.add(new Card("Number Card", i, "Red", name));
			drawPile.add(new Card("Number Card", i, "Yellow", name));
			drawPile.add(new Card("Number Card", i, "Blue", name));
			drawPile.add(new Card("Number Card", i, "Green", name));
		}//for
		
		drawPile.add(new Card("Choose Who Draw 2", -1, "Yellow", "Oscar the Grouch"));
		drawPile.add(new Card("Choose Who Draw 2", -1, "Green", "Oscar the Grouch"));
		drawPile.add(new Card("Draw 1", -1, "Red", "Ernie and Bert"));
		drawPile.add(new Card("Draw 1", -1, "Blue", "Ernie and Bert"));
		for(int k=1; k<4;k++){
		drawPile.add(new Card("Wild", -1, "", "Monster"));
		}
		
	}//addCards
	
	public void shuffleCards(){
		Collections.shuffle(drawPile);
	}
	
	public Card drawCard(){
		return drawPile.remove(0);
	}
	
	public void addCardToDraw(Card card){
		drawPile.add(card);
	}
	
	public void addCardToDiscard(Card card){
		discardPile.add(card);
	}
	
	public void addDiscardToDraw(){
		for(int j=0; j<(discardPile.size())-2; j++){
		drawPile.add(discardPile.remove(j));	
		}	
	}
	
	public Card topOfDiscard(){
		return (discardPile.get(discardPile.size()-1));
	}
	
	public ArrayList getDrawPile(){
		return drawPile;
	}
	
}//class
