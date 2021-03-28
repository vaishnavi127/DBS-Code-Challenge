package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import commonUtils.commonFunctions;

public class Default_Page_Objects extends commonFunctions {
	
	@FindBy(xpath="/html/body/div[1]/div/div[1]/div[2]/header/div/div[2]/ul/li[2]/a")
	public static WebElement cards;
	
	}
