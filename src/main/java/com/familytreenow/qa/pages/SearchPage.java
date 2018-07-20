package com.familytreenow.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.familytreenow.qa.testbase.TestBase;
	
	public class SearchPage extends TestBase {
		
		@FindBy(xpath = "//input[@id='hr_pg']")
		WebElement firstName;
		
		@FindBy(xpath = "//input[@id='hr_ps']")
		WebElement lastName;
		
		@FindBy(xpath = "//input[@id='hr_fg']")
		WebElement fatherName;
		
		@FindBy(xpath = "//button[@type='submit']")
		WebElement searchButton;
		
		public SearchPage() {
			PageFactory.initElements(driver, this);
		}
		
		public void searchSpouse(String fname, String lname) {
			firstName.sendKeys(fname);
			lastName.sendKeys(lname);
			searchButton.click();
		}
		
		public void searchMother(String fname, String lname, String dad) {
			firstName.sendKeys(fname);
			lastName.sendKeys(lname);
			fatherName.sendKeys(dad);
			searchButton.click();
		}
	
}
