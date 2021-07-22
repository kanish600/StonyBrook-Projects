
public class Card {

	private String cardType;
	private int cardNum;
	private String cardColor;
	private String cardName;
	
	public Card(String cardType, int cardNum, String cardColor, String cardName) {
		this.cardType = cardType;
		this.cardNum = cardNum;
		this.cardColor = cardColor;
		this.cardName = cardName;
	}
	
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public int getCardNum() {
		return cardNum;
	}
	public void setCardNum(int cardNum) {
		this.cardNum = cardNum;
	}
	public String getCardColor() {
		return cardColor;
	}
	public void setCardColor(String cardColor) {
		this.cardColor = cardColor;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	@Override
	public String toString() {
		return  cardType + " " + cardNum + " " + cardColor + " "+ cardName ;
	}
	
}
