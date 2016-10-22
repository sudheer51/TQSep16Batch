package org.retailmenot.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DealsPage {
	WebDriver driver;
	public DealsPage(WebDriver driver) {
		this.driver = driver;
	}

	public void jumptoSection(String sectionName)
	{													    //'"+sectionName+"'
		driver.findElement(By.xpath("(//a[contains(text(),'"+sectionName+"')])[2]")).click();

	}

	public int getSectionDealsCount(String sectionName)
	{
		List<WebElement> elements=null;
		try{
			 elements = driver.findElements(By.xpath(".//*[@id='"+sectionName+"']/div/div"));
		}
		catch(UnhandledAlertException e)
		{
			if(elements==null)
			{
				 elements = driver.findElements(By.xpath(".//*[@id='"+sectionName+"']/div/div"));
			}
		}
		return elements.size();

	}
}
