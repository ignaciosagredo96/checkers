package checkers_aut;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Common {

	/**
     * <b>Nombre:</b> countWebElements</br></br>
     * <b>Description:</b> Cuenta la cantidad de webElements dado un xpath
     *
     * @return int
     * @author Ignacio Sagredo
     **/
	public static int countWebElements(String xpathElement){
		return Suite.driver.findElements(By.xpath(xpathElement)).size();
	}
	
	/**
     * <b>Nombre:</b> getWebElementByPosition</br></br>
     * <b>Description:</b> Devuelve un WebElement de acuerdo a un posición y Xpath dado
     *
     * @return int
     * @author Ignacio Sagredo
     **/
	public static WebElement getWebElementByPosition(String xpathElement, int position){
		return Suite.driver.findElement(By.xpath("("+xpathElement+")["+position+"]"));
	}
	
	/**
     * <b>Nombre:</b> focusOnElement</br></br>
     * <b>Description:</b> realiza foco en elemento
     *
     * @author Ignacio Sagredo
     **/
	public static void focusOnElement(WebElement element){
		((JavascriptExecutor)Suite.driver).executeScript("arguments[0].focus();", element);
	}
	

	
}
