package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Compare_Page_Objects {
	
	@FindBy(xpath="/html/body/div[1]/div/div[2]/div[2]/div/div[1]/div/div/div[1]/div/div[2]/div/label/div[1]")
	public static WebElement card1;
	
	@FindBy(xpath="//*[@id=\"bodywrapper\"]/div[2]/div/div[1]/div/div/div[2]/div/div[2]/div/label/div[1]/span")
	public static WebElement card2;		
	
	@FindBy(id="cardCompareBtn")
	public static WebElement compareButton;

}
