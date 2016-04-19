package com.bikash.google;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;




public class GoogleHomePage {
WebDriver driver;
	
	@Test
  public void googleHome() {
		driver.get("http://www.google.com");
		driver.findElement(By.id("lst-ib")).sendKeys("Testing");
		driver.findElement(By.name("btnk")).click();
		
	}
  @BeforeTest
  public void beforeTest() {
	  driver  = new FirefoxDriver();
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
	  driver.quit();
  }

}
