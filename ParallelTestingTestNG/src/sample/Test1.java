package sample;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;




public class Test1 extends Browser1 {
	@Test
	public void test(){
		/* in this test we are searching selenium in Google and clicking on first link in Google Result*/
		
		driver.manage().window().maximize();
		driver.get("https://in.linkedin.com/");
		
	
		driver.findElement(By.xpath(".//*[@id='session_key-login']")).sendKeys("selenium");
		driver.findElement(By.xpath(".//*[@id='session_password-login']")).sendKeys("selenium");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='signin']")).click();
		
		String expErr="Please enter a valid email address.";
		String actErr=driver.findElement(By.xpath(".//*[@id='session_key-login-error']")).getText();
		
		Assert.assertEquals(actErr, expErr);
		}

		
}
