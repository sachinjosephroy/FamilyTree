package com.familytreenow.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.familytreenow.qa.pages.SearchPage;
import com.familytreenow.qa.pages.ResultsPage;
import com.familytreenow.qa.testbase.TestBase;
import com.familytreenow.qa.util.TestUtil;

public class FamilySearchTest extends TestBase {
	
	ResultsPage results;
	SearchPage search;
	String sheetname = "contacts";
	
	public FamilySearchTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		results = new ResultsPage();
		search = new SearchPage();
	}
	
	@DataProvider
	public Object[][] familyTestData(){
		Object data[][] = TestUtil.testData(sheetname);
		return data;
	}
	
	@Test(dataProvider="familyTestData")
	public void spouseSearchTest(String firstname, String lastname, String expectedResult, String father, String mother) {
			search.searchSpouse(firstname, lastname);
			String spouseName = results.searchResults();
			Assert.assertEquals(spouseName, expectedResult);
	}
	
	@Test(dataProvider="familyTestData")
	public void motherSearchTest(String firstname, String lastname, String expectedResult, String father, String mother) {
			search.searchMother(firstname, lastname, father);
			String momName = results.momResults();
			Assert.assertEquals(momName, mother);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}