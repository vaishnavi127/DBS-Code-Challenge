package commonUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

public class commonFunctions {

	public static WebDriver driver;
	public static Properties properties = null;
	public Properties loadPropertyFile() throws IOException
	{
		FileInputStream fs = new FileInputStream("config.properties");
		properties = new Properties();
		properties.load(fs);
		return properties;		
	}
	
	@BeforeSuite
	public void launchBrowser() throws IOException
	{
		loadPropertyFile();
		String url = properties.getProperty("url");		
		String driverLocation = properties.getProperty("DriverLocation");		
		System.setProperty("webdriver.chrome.driver",driverLocation);
		driver = new ChromeDriver();		
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		
	}
	
	public void assertCard1Name() throws IOException
	{
		loadPropertyFile();
		String expectedCard1Name = properties.getProperty("expectedCard1Name");
		String actualCard1Name = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[4]/div/div[1]/div[2]/div")).getText();
		Assert.assertEquals(actualCard1Name, expectedCard1Name);
		System.out.println("Card1 Name is asserted");
	}

	public void assertCard2Name() throws IOException
	{
		loadPropertyFile();
		String expectedCard1Name = properties.getProperty("expectedCard2Name");
		String actualCard1Name = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[4]/div/div[2]/div[2]/div")).getText();
		Assert.assertEquals(actualCard1Name, expectedCard1Name);
		System.out.println("Card2 Name is asserted");
	}
	
	public void assertCard1Benefits() throws IOException
	{
		loadPropertyFile();
		String expectedCard1Benefits = properties.getProperty("expectedCard1Benefits");
		String actualCard1Benefits = driver.findElement(By.xpath("//*[@id=\"card0\"]/div[8]/div[2]/span/ul/li[1]")).getText();
		Assert.assertEquals(expectedCard1Benefits, actualCard1Benefits);
		System.out.println("Card1 Benefits asserted");
	}
	
	public void assertCard2Benefits() throws IOException
	{
		loadPropertyFile();
		String expectedCard2Benefits = properties.getProperty("expectedCard2Benefits");
		String actualCard2Benefits = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[4]/div/div[2]/div[8]/div[2]/span/ul/li[1]")).getText();
		Assert.assertEquals(expectedCard2Benefits, actualCard2Benefits);
		System.out.println("Card2 Benefits asserted");
	}
	
	public void assertPageTitle() throws IOException
	{
		loadPropertyFile();
		String expectedTitle = properties.getProperty("expectedTitle");
		String actualTitle = driver.getCurrentUrl();
		Assert.assertEquals(expectedTitle, actualTitle);
		System.out.println("Page Title asserted");
	}
	
	public void tearDown()
	{
		driver.quit();
	}

}
