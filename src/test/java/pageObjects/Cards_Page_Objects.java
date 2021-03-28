package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Cards_Page_Objects {
	
	@FindBy(xpath="/html/body/div[1]/div/div[2]/div[1]/div[1]/div/ul/li[2]/a")
	public static WebElement creditCards;
	
}
