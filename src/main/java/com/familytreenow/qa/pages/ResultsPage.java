package com.familytreenow.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.familytreenow.qa.testbase.TestBase;

public class ResultsPage extends TestBase {
	
	@FindBy(xpath = "//span[@class='spouse relationship-label']//following::span[@class='relationship-data']")
	WebElement firstSpouse;
	
	@FindBy(xpath = "//span[@class='mother relationship-label']//following::span[@class='relationship-data']")
	WebElement mother;
	
	public ResultsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String searchResults() {
		String spouse = firstSpouse.getText();
		return spouse;
	}

	public String momResults() {
		String mom = mother.getText();
		return mom;
	}
	
}
