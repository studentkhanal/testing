package com.bikash.google;

import org.testng.annotations.Test;

import org.testng.Assert;

import org.testng.annotations.BeforeTest;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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
		driver.findElement(By.name("btnG")).click();
		
		Assert.assertEquals(driver.getTitle(), "Google");
		
		System.out.println("I am here");
		
		//Getting parent handle
		String parentWindowHandler = driver.getWindowHandle();
		String subWindowHandler = null;
		
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> iterator = handles.iterator();
		
		while(iterator.hasNext()){
			subWindowHandler = iterator.next();
		}
		driver.switchTo().window(subWindowHandler);
		driver.switchTo().window(parentWindowHandler);
		
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		driver.findElement(By.id("gb_70")).click();
		System.out.println("I am here too");
		
		driver.findElement(By.id("Email")).sendKeys("student.khanal@gmail.com");
		driver.findElement(By.id("next")).click();
		
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
