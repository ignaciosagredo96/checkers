package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import checkers_aut.Common;
import checkers_aut.Suite;

public class CheckersPage {
	
	public static String SPACE = "space";
	
	@FindBy(how = How.ID, using = "message")
	private WebElement pMessage;
	
	public WebElement getPMessage() {
		return pMessage;
	}
	
	public void getOponentMovements() {
		
		int quantPiecesOponent = Common.countWebElements("//img[@src='me1.gif']");
		
		for (int i = 1; i <= quantPiecesOponent; i++) {
			
			WebElement piece = Common.getWebElementByPosition(
					"//img[@src='me1.gif']", i);
			String namePiece = piece.getAttribute("name");
			String positionPiece = namePiece.replace("space", "");
			int column = Integer.parseInt(positionPiece.substring(1,2));
			if(column < 5)
			{
				System.out.println("Oponent movement");
			}
		}
		
	}

	public String getPositivonToMove(String positionPiece, String typePiece) {
		String positionToMove = "NAN";
		
		int column = Integer.parseInt(positionPiece.substring(1,2));
		int position = Integer.parseInt(positionPiece.substring(0,1));

		int columnToMove = column+1;
		int init = 0;
		int limit = 0;
		switch (position) {
		case 7:
			init = 6;
			limit = 6;
			break;
		case 6:
			init = 7;
			limit = 5;
			break;
		case 5:
			init = 6;
			limit = 4;
			break;
		case 4:
			init = 5;
			limit = 3;
			break;
		case 3:
			init = 4;
			limit = 2;
			break;
		case 2:
			init = 3;
			limit = 1;
			break;
		case 1:
			init = 2;
			limit = 0;
			break;
		case 0:
			init = 1;
			limit = 1;
			break;

		default:
			break;
		}
		
		for (int i = init; i >= limit; i--) {
			String namePlaceToMove = SPACE+i+columnToMove;
			WebElement placeToMove = Suite.driver.findElement(By.name(namePlaceToMove));
			String content = placeToMove.getAttribute("src");
			if(typePiece.equals("you"))
			{
			if(content.contains("me1.gif"))
			{
				namePlaceToMove = getPositivonToMove(namePlaceToMove.replace(SPACE, ""),"me");
				if(!namePlaceToMove.equals("NAN"))
				{
					int newPosition = Integer.parseInt(namePlaceToMove.replace(SPACE, "").substring(0,1));
					if(newPosition != position)
					{
					positionToMove = namePlaceToMove;
					break;
					}
					else
					{
						positionToMove = "NAN";
					}
				}
			}
			}
			if(content.contains("gray"))
			{
				positionToMove = namePlaceToMove;
				break;
			}
		}
		
		return positionToMove;
	}

	

}
