package testCases;

import java.io.IOException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import commonUtils.commonFunctions;
import pageObjects.Cards_Page_Objects;
import pageObjects.Compare_Page_Objects;
import pageObjects.Default_Page_Objects;

public class Credit_Card_Comparison extends commonFunctions {
	commonFunctions cf =new commonFunctions();			
	
	public void creditCard() 
	{		

		PageFactory.initElements(driver, Default_Page_Objects.class);		
		Default_Page_Objects.cards.click();
		
		PageFactory.initElements(driver, Cards_Page_Objects.class);
		Cards_Page_Objects.creditCards.click();
		
		PageFactory.initElements(driver, Compare_Page_Objects.class);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()",Compare_Page_Objects.card1);
		js.executeScript("arguments[0].click()",Compare_Page_Objects.card2);
		
		Compare_Page_Objects.compareButton.click();
		
	}
	
	public void compare() throws IOException
	{	
		
		cf.assertCard1Name();
		cf.assertCard2Name();
		cf.assertCard1Benefits();
		cf.assertCard2Benefits();
		cf.assertPageTitle();
	}
	
	@Test
	public void creditCardComparison() throws IOException
	{
		creditCard();
		compare();
	}		
	
}


            