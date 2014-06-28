package sample;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
public class Browser1 {

	WebDriver driver;
	@BeforeMethod   /* The annotated method will be run before all tests in this suite have run */

	//browser is the name of parameter that we have used in xml
	//@Parameters(“browsers”)  /* this annotation is used to insert parameter in test*/
	@Parameters("browser")
	public void openBroswer(String browser){

	/*Comparing the value of parameter name if this is FF then It would launch Firefox and script that would run is as follows */
	if(browser.equalsIgnoreCase("FF"))
	{
	System.out.println("Firefox driver would be used");
	driver = new FirefoxDriver();
	}
	else if(browser.equalsIgnoreCase("IE"))
	{
	System.out.println("Ie webdriver would be used");
	System.setProperty("webdriver.ie.driver", "C:\\IEDriverServer.exe"); 
	driver = new InternetExplorerDriver();
	}
	else if(browser.equalsIgnoreCase("CH"))
	{
	System.out.println("chrome webdriver would be used");
	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
	driver=new ChromeDriver();
	}
	}

	@AfterMethod /* this annotation would run once test script execution would complete*/

	public void closeBrowser()
	{try{
	driver.wait(15);
	}
	catch(Exception e){}
	driver.close();
	driver.quit();
	}
}
