package tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import pages.CheckersPage;
import checkers_aut.Common;
import checkers_aut.DriverManagement;
import checkers_aut.Suite;


public class T1_PlayCheckers {

	 /**
     * <b>Nombre:</b> setUpDriverAndSuiteTest</br></br>
     * <b>Description:</b> Install the automated test execution environment
     *
     * @return void
     * @author Ignacio Sagredo
     * @throws Throwable 
     **/
	@BeforeClass
    public static void setUpDriverAndSuiteTest() throws Throwable {
		Suite.loadProperties();
		Suite.driver = DriverManagement.getDriver();
		Suite.goToLocation();
    }
	
	@Test
	public void PlayCheckers() throws Exception {
		try {
			
			CheckersPage checkersPage = PageFactory.initElements(Suite.driver, CheckersPage.class);
			String message = ""; checkersPage.getPMessage().getText();
			int quantPieces = 0;
			do {
				message = checkersPage.getPMessage().getText();
				quantPieces = Common.countWebElements("//img[@src='you1.gif']");
				
				for (int i = 1; i <= quantPieces; i++) {
					WebElement piece = Common.getWebElementByPosition(
							"//img[@src='you1.gif']", i);
					String namePiece = piece.getAttribute("name");
					String positionPiece = namePiece.replace("space", "");
					String positionToMove = checkersPage.getPositivonToMove(positionPiece,"you");
					if(!positionToMove.contains("NAN"))
					{
						Suite.driver.findElement(By.name(namePiece)).click();
						Suite.driver.findElement(By.name(positionToMove)).click();
						Thread.sleep(1000);
						
						checkersPage.getOponentMovements();
						
						
						break;
					}
					
				}
				
				
				
			} while (!message.equals("You lose. Game over."));
		} catch (Exception e) {
			Suite.RESULT = e.getMessage();
			System.out.println(e.getMessage());
		}

	}
	
	 /**
     * <b>Name:</b> endTest</br></br>
     * <b>Description:</b> End the test and close the automated test execution environment
     *
     * @return void
     * @author Ignacio Sagredo
     **/
	@AfterClass
	public static void endTest() {
		
		System.out.println("End automated test, result: " + Suite.RESULT);
		
	}

}
