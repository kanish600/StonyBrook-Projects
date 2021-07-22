import java.util.Scanner;

public class UnoMain {

	public static void main(String[] args) {
		
		
		Scanner input = new Scanner(System.in);
		Player player = new Player();
		Player comp = new Player();
		Deck drawPile = new Deck();
		
		
		boolean playerFirst=false;
		boolean computerFirst=false;
		
		
		drawPile.addCards();
		drawPile.shuffleCards();
		
		player.addCardToHand(drawPile.drawCard());
		comp.addCardToHand(drawPile.drawCard());
		
		while(player.getPlayerHand().get(0).getCardNum()<0){
			Card a =(Card) player.getPlayerHand().get(0);
			player.placeCard(a);
			drawPile.addCardToDraw(a);
			player.addCardToHand(drawPile.drawCard());
		}//player starting game
		
		while(comp.getPlayerHand().get(0).getCardNum()<0){
			Card b =(Card) comp.getPlayerHand().get(0);
			comp.placeCard(b);
			drawPile.addCardToDraw(b);
			comp.addCardToHand(drawPile.drawCard());
		}//comp starting game
		
		while(player.getPlayerHand().get(0).getCardNum()==comp.getPlayerHand().get(0).getCardNum()){
			Card b =(Card) comp.getPlayerHand().get(0);
			comp.placeCard(b);
			drawPile.addCardToDraw(b);
			comp.addCardToHand(drawPile.drawCard());
		}//checks if equal
		
		System.out.println("You drew a "+player.printPlayerHand());
		System.out.println("Computer drew a "+comp.printPlayerHand());
		
		if(player.getPlayerHand().get(0).getCardNum()<0){
			Card x=(Card) player.getPlayerHand().get(0);
			player.placeCard(x);
			drawPile.addCardToDraw(x);
			player.addCardToHand(drawPile.drawCard());
		}//make sure number card for user
		
		if(comp.getPlayerHand().get(0).getCardNum()<0){
			Card x=(Card) comp.getPlayerHand().get(0);
			comp.placeCard(x);
			drawPile.addCardToDraw(x);
			comp.addCardToHand(drawPile.drawCard());
		}//make sure number card for user
		
		
		
		if(player.getPlayerHand().get(0).getCardNum()>comp.getPlayerHand().get(0).getCardNum()){
			System.out.println("You drew the higher card! You start first!");
			
			playerFirst=true;
		}
		else{
			System.out.println("The computer drew the higher card! The computer starts first!");
			
			computerFirst=true;
		}
		
		Card a =(Card) player.getPlayerHand().get(0);
		player.placeCard(a);
		drawPile.addCardToDraw(a);
		
		Card b =(Card) comp.getPlayerHand().get(0);
		comp.placeCard(b);
		drawPile.addCardToDraw(b);
		
		drawPile.shuffleCards();
		
		for(int i=0;i<5;i++){
			player.addCardToHand(drawPile.drawCard());
			comp.addCardToHand(drawPile.drawCard());
		}//adds 5 cards to hands
		
		System.out.println("You have: "+player.printPlayerHand()+" in your hand");
		
		
		
		while(true){
			
			Card top = drawPile.drawCard();
			drawPile.addCardToDiscard(top);
			if(top.getCardNum()>0){
				break;
			}
		}
		
		System.out.println("The top card of the discard pile is: "+drawPile.topOfDiscard());
		
		boolean playerTurn=playerFirst;
		
	while(player.getPlayerHand().size()!=0 || comp.getPlayerHand().size()!=0){
		
		/*if(drawPile.getDrawPile().size()<1){
			drawPile.addDiscardToDraw();
		}
		*/
		System.out.println("The top card of the discard pile is: "+drawPile.topOfDiscard());
		System.out.println("You have: "+player.printPlayerHand()+" in your hand");
		
		if(playerTurn==true){
			System.out.println("Enter what index of the card you would like to place, or enter -1 if you would like to draw another card: ");
			int index=input.nextInt();
			input.nextLine();
			
			if(index==-1){
				player.addCardToHand(drawPile.drawCard());
				
				//added start
				System.out.println("You have: "+player.printPlayerHand()+" in your hand");
				System.out.println("Enter what index of the card you would like to place, or enter -1 if you would like to end your turn: ");
				int secondindex=input.nextInt();
				
				if(secondindex==-1){
					playerTurn=false;
				}
				
				else if(drawPile.topOfDiscard().getCardType().equals("Wild")||(
						player.getPlayerHand().get(secondindex).getCardType().equals("Choose Who Draw 2")&&
						player.getPlayerHand().get(secondindex).getCardColor()==drawPile.topOfDiscard().getCardColor())){
					Card x=(Card) player.getPlayerHand().get(secondindex);
					player.placeCard(x);
					drawPile.addCardToDiscard(x);
					
					comp.addCardToHand(drawPile.drawCard());
					comp.addCardToHand(drawPile.drawCard());
					playerTurn=false;
				}
				
				else if(drawPile.topOfDiscard().getCardType().equals("Wild")||(
						player.getPlayerHand().get(secondindex).getCardType().equals("Draw 1")&&
						player.getPlayerHand().get(secondindex).getCardColor()==drawPile.topOfDiscard().getCardColor())){
					Card x=(Card) player.getPlayerHand().get(secondindex);
					player.placeCard(x);
					drawPile.addCardToDiscard(x);
					
					comp.addCardToHand(drawPile.drawCard());
					playerTurn=false;
				}
				
				else if((player.getPlayerHand().get(secondindex).getCardType().equals("Wild"))){
					Card x=(Card) player.getPlayerHand().get(secondindex);
					player.placeCard(x);
					drawPile.addCardToDiscard(x);
					
					System.out.println("What color would you like to set?");
					String wildColor=input.next();
					drawPile.topOfDiscard().setCardColor(wildColor);
					
					playerTurn=false;
				}
				
				
				else if(drawPile.topOfDiscard().getCardType().equals("Wild")||
						player.getPlayerHand().get(secondindex).getCardNum()==drawPile.topOfDiscard().getCardNum() || 
						player.getPlayerHand().get(secondindex).getCardColor()==drawPile.topOfDiscard().getCardColor() || 
						player.getPlayerHand().get(secondindex).getCardName()==drawPile.topOfDiscard().getCardName() ||
						player.getPlayerHand().get(secondindex).getCardNum()<0){
					
					Card x=(Card) player.getPlayerHand().get(secondindex);
					player.placeCard(x);
					drawPile.addCardToDiscard(x);
					
					playerTurn=false;
				}
				else{
					System.out.println("Not valid, choose card or enter -1 to end turn");
					
					boolean isValid2 = false;
					int selection2 = 0;
					do{
						try{
							selection2 = input.nextInt();
							while(selection2 < 1 || selection2 > player.getPlayerHand().size()){
								System.out.println("Invalid input. Enter again!");
								selection2=input.nextInt();
							}
							isValid2 = true;
						}catch(Exception e){
							System.out.println("Invalid input. Enter again!");
							input.nextLine();
						}
					}while(isValid2==false);
					
					playerTurn=true;
				}
				//added end
				
			}
			
			else if(drawPile.topOfDiscard().getCardType().equals("Wild")||(
					player.getPlayerHand().get(index).getCardType().equals("Choose Who Draw 2")&&
					player.getPlayerHand().get(index).getCardColor()==drawPile.topOfDiscard().getCardColor())){
				Card x=(Card) player.getPlayerHand().get(index);
				player.placeCard(x);
				drawPile.addCardToDiscard(x);
				
				comp.addCardToHand(drawPile.drawCard());
				comp.addCardToHand(drawPile.drawCard());
				playerTurn=false;
			}
			
			else if(drawPile.topOfDiscard().getCardType().equals("Wild")||(
					player.getPlayerHand().get(index).getCardType().equals("Draw 1")&&
					player.getPlayerHand().get(index).getCardColor()==drawPile.topOfDiscard().getCardColor())){
				Card x=(Card) player.getPlayerHand().get(index);
				player.placeCard(x);
				drawPile.addCardToDiscard(x);
				
				comp.addCardToHand(drawPile.drawCard());
				playerTurn=false;
			}
			
			else if((player.getPlayerHand().get(index).getCardType().equals("Wild"))){
				Card x=(Card) player.getPlayerHand().get(index);
				player.placeCard(x);
				drawPile.addCardToDiscard(x);
				
				System.out.println("What color would you like to set?");
				String wildColor=input.next();
				System.out.println(wildColor);
				boolean skipLoop = wildColor.equals("Blue")||wildColor.equals("Yellow")||wildColor.equals("Green")||wildColor.equals("Red");
				while(!skipLoop){
					System.out.println("Enter a valid color! Example: 'Blue' or 'Red'");
					wildColor=input.next();
					skipLoop = wildColor.equals("Blue")||wildColor.equals("Yellow")||wildColor.equals("Green")||wildColor.equals("Red");
				}
				
				drawPile.topOfDiscard().setCardColor(wildColor);
				
				playerTurn=false;
			}
			
			
			else if(drawPile.topOfDiscard().getCardType().equals("Wild")||
					player.getPlayerHand().get(index).getCardNum()==drawPile.topOfDiscard().getCardNum() || 
					player.getPlayerHand().get(index).getCardColor()==drawPile.topOfDiscard().getCardColor() || 
					player.getPlayerHand().get(index).getCardName()==drawPile.topOfDiscard().getCardName() ||
					player.getPlayerHand().get(index).getCardNum()<0){
				
				Card x=(Card) player.getPlayerHand().get(index);
				player.placeCard(x);
				drawPile.addCardToDiscard(x);
				
				playerTurn=false;
			}
			else{
				System.out.println("Not valid, choose card or enter -1 to draw another card");
				playerTurn=true;
			}
			
			if(player.getPlayerHand().size()<3){
				System.out.println("Say 'UNO'");
				String uno=input.next();
				if(!uno.equals("UNO")) {
					System.out.println("You now draw two cards...");
					player.addCardToHand(drawPile.drawCard());
					player.addCardToHand(drawPile.drawCard());
				}
			}
			
		}//playerTurn=true
		else{
			
			for(int i=0; i<comp.getPlayerHand().size(); i++){
				
				if(drawPile.topOfDiscard().getCardType().equals("Wild")||(
						comp.getPlayerHand().get(i).getCardType().equals("Choose Who Draw 2")&&
						comp.getPlayerHand().get(i).getCardColor()==drawPile.topOfDiscard().getCardColor())){
					
					Card x=(Card) comp.getPlayerHand().get(i);
					comp.placeCard(x);
					drawPile.addCardToDiscard(x);
					
					player.addCardToHand(drawPile.drawCard());
					player.addCardToHand(drawPile.drawCard());
					playerTurn=true;
				}
				
				else if(drawPile.topOfDiscard().getCardType().equals("Wild")||(
						comp.getPlayerHand().get(i).getCardType().equals("Draw 1")&&
						comp.getPlayerHand().get(i).getCardColor()==drawPile.topOfDiscard().getCardColor())){
					
					Card x=(Card) comp.getPlayerHand().get(i);
					comp.placeCard(x);
					drawPile.addCardToDiscard(x);
					
					player.addCardToHand(drawPile.drawCard());
					playerTurn=true;
				}
				
				else if((comp.getPlayerHand().get(i).getCardType().equals("Wild"))){
					Card x=(Card) comp.getPlayerHand().get(i);
					x.setCardColor("Blue");
					comp.placeCard(x);
					drawPile.addCardToDiscard(x);
					
					drawPile.topOfDiscard().setCardColor("Blue");
					
					playerTurn=true;
				}
				
			else if(drawPile.topOfDiscard().getCardType().equals("Wild")||
					comp.getPlayerHand().get(i).getCardNum()==drawPile.topOfDiscard().getCardNum() || 
					comp.getPlayerHand().get(i).getCardColor()==drawPile.topOfDiscard().getCardColor() || 
					comp.getPlayerHand().get(i).getCardName()==drawPile.topOfDiscard().getCardName() ||
					comp.getPlayerHand().get(i).getCardNum()<0){
					
					Card x=(Card) comp.getPlayerHand().get(i);
					comp.placeCard(x);
					
					drawPile.addCardToDiscard(x);
					
					playerTurn=true;
					break;//remove
				}
				
				if(comp.getPlayerHand().size()<3){
					System.out.println("UNO!");
				}
				else{
					
				}
				
			}//for
			
			comp.addCardToHand(drawPile.drawCard());
			
			
			
			
			
			playerTurn=true;
			
		}//playerTurn==false
		
		if(comp.getPlayerHand().size()<1){
			System.out.println("Computer Won!");
		}
		if(player.getPlayerHand().size()<1){
			System.out.println("You Won!");
		}
	}//while
		
	System.out.println("Game Over!!");
	
}//main
}//class
