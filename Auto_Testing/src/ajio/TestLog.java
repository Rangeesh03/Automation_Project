package ajio;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class TestLog extends DataDriven {
	static WebDriver driver;
	static Keywords POM = new Keywords();
	static boolean TestResult;
	static int i = 0;

	/**
	 * Open The Browser Once For All The @Test Methods
	 */
	@BeforeClass
	public void OpenBrowser() throws IOException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	/**
	 * Close All The Browser When All the @Test Methods Are Executed
	 */
	@AfterClass
	public void CloseBrowser() {
		driver.quit();
	}

	/**
	 * Take ScreenShot For Only Failed @Test Method
	 */
	@AfterMethod
	public void screenshot() throws IOException {

		i++;
		if (i <= 75) {
			if (TestResult) {
				Reporter.log("TestCase_0" + i + " Passed", true);
			} else {
				Reporter.log("TestCase_0" + i + " Faild", true);
				PageFactory.initElements(driver, POM);
				POM.ScreenShot(driver, "TestCase_" + i);
			}
			TestResult = false;
		}
	}

	/**
	 * Verify that the search box accepts different types of user inputs
	 */
	/*
	 * Check that search box accepts alphabets or not
	 */
	@Test(priority = 1, groups = "Smoke Testing")
	public void TestCase_001() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		POM.Search(Alphapets());
		Assert.assertTrue(driver.getCurrentUrl().contains(Alphapets()));
		TestResult = true;
	}

	/*
	 * Check that search box accepts numbers
	 */
	@Test(priority = 2)
	public void TestCase_002() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		POM.Search(Numbers());
		Assert.assertTrue(driver.getCurrentUrl().contains(Numbers()));
		TestResult = true;
	}

	/*
	 * Check that search box accepts symbols
	 */
	@Test(priority = 3, groups = "Negative TestCase")
	public void TestCase_003() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		POM.Search(SpecialCharacters());
		Assert.assertTrue(driver.getCurrentUrl().contains(SpecialCharacters()));
		TestResult = true;
	}

	/*
	 * Check that search box accepts alphanumeric
	 */
	@Test(priority = 4, groups = "Smoke Testing")
	public void TestCase_004() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		POM.Search(Alphanumeric());
		Assert.assertTrue(driver.getCurrentUrl().contains(Alphanumeric()));
		TestResult = true;
	}

	/*
	 * Check that search box accepts multiple string.
	 */
	@Test(priority = 5)
	public void TestCase_005() throws IOException {
		PageFactory.initElements(driver, POM);
		POM.Search(MultipleString());
		Assert.assertTrue(driver.getCurrentUrl().contains("shirts-for-men"));
		TestResult = true;
	}

	/*
	 * Check that search box accepts blank
	 */
	@Test(priority = 6, groups = "Negative TestCase")
	public void TestCase_006() throws IOException {
		PageFactory.initElements(driver, POM);
		POM.Search(Blank());
		Assert.assertFalse(driver.getCurrentUrl().contains(" "));
		TestResult = true;
	}

	/*
	 * Check that search box accepts lower case
	 */
	@Test(priority = 7)
	public void TestCase_007() throws IOException {
		PageFactory.initElements(driver, POM);
		POM.Search(LowerCase());
		Assert.assertTrue(driver.getCurrentUrl().contains(LowerCase()));
		TestResult = true;
	}

	/*
	 * Check that search box accepts the combination of upper case and lower case
	 */
	@Test(priority = 8)
	public void TestCase_008() throws IOException {
		PageFactory.initElements(driver, POM);
		POM.Search(Upper_LowerCase());
		Assert.assertTrue(driver.getCurrentUrl().contains(Upper_LowerCase()));
		TestResult = true;
	}

	/**
	 * Verify that the search box suggestion list functionality
	 */
	/*
	 * Check whether entering a product name partially in the search box will
	 * display a suggestion list or not.
	 */
	@Test(priority = 9, groups = "Sanity Testing")
	public void TestCase_009() throws IOException, EncryptedDocumentException, InterruptedException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.Suggestion(PartialName());
		Assert.assertTrue(Result);
		TestResult = true;
	}

	/*
	 * Check whether entering a Brand Name in the search box will display a
	 * suggestion list or not.
	 */
	@Test(priority = 10)
	public void TestCase_010() throws IOException, EncryptedDocumentException, InterruptedException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.Suggestion(BrandName());
		Assert.assertTrue(Result);
		TestResult = true;
	}

	/*
	 * Check whether entering a Product name in the search box will display a
	 * suggestion list or not.
	 */
	@Test(priority = 11, groups = "Smoke Testing")
	public void TestCase_011() throws IOException, EncryptedDocumentException, InterruptedException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.Suggestion(ProductName());
		Assert.assertTrue(Result);
		TestResult = true;
	}

	/*
	 * Check whether entering a Product Description in the search box will display a
	 * suggestion list or not.
	 */
	@Test(priority = 12, groups = "ReTesting") // Faild
	public void TestCase_012() throws IOException, EncryptedDocumentException, InterruptedException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.Suggestion(ProductDescription());
		Assert.assertTrue(Result);
		Reporter.log("TestCase_012 Passed", true);
		TestResult = true;
	}

	/*
	 * Check whether navigating through the suggestion items should be displayed in
	 * the search box or not.
	 */
	@Test(priority = 13, groups = "Sanity Testing")
	public void TestCase_013() throws IOException, EncryptedDocumentException, AWTException, InterruptedException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.SuggestionFirst(ProductName());
		Assert.assertTrue(Result);
		TestResult = true;
	}

	/**
	 * Verify that the Features of Search Result Page
	 */
	/*
	 * Check whether the title of the Search Result page is related to the search
	 * content or not
	 */
	@Test(priority = 14, invocationCount = 2)
	public void TestCase_014() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		POM.Search(ProductName());
		Assert.assertTrue(driver.getTitle().contains(ProductName()));
		TestResult = true;
	}

	/*
	 * Check whether the total item count is displayed or not
	 */
	@Test(priority = 15)
	public void TestCase_015() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.TotalCount(ProductName());
		Assert.assertTrue(Result);
		TestResult = true;
	}

	/*
	 * Check whether the GRID view option is displayed or not.
	 */
	@Test(priority = 16)
	public void TestCase_016() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.GridView(ProductName());
		Assert.assertTrue(Result);
		TestResult = true;
	}

	/*
	 * Check whether the SORT BY option is displayed or not.
	 */
	@Test(priority = 17)
	public void TestCase_017() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.SortByOption(ProductName());
		Assert.assertTrue(Result);
		TestResult = true;
	}

	/*
	 * Check whether the Refine by Gender option is displayed or not.
	 */
	@Test(priority = 18, groups = "Smoke Testing")
	public void TestCase_018() throws IOException {
		driver.get(Url());
		boolean Result = POM.Gender(ProductName());
		PageFactory.initElements(driver, POM);
		Assert.assertTrue(Result);
		TestResult = true;
	}

	/*
	 * Check whether the Refine by Category option is displayed or not.
	 */
	@Test(priority = 19)
	public void TestCase_019() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.Category(ProductName());
		Assert.assertTrue(Result);
		TestResult = true;
	}

	/*
	 * Check whether the Refine by Price option is displayed or not.
	 */
	@Test(priority = 20)
	public void TestCase_020() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.Price(ProductName());
		Assert.assertTrue(Result);
		TestResult = true;
	}

	/*
	 * Check whether the Refine by Brand option is displayed or not.
	 */
	@Test(priority = 21, groups = "Sanity Testing")
	public void TestCase_021() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.Brand(ProductName());
		Assert.assertTrue(Result);
		TestResult = true;
	}

	/*
	 * Check whether the Refine by Occasion option is displayed or not.
	 */
	@Test(priority = 22)
	public void TestCase_022() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.Occasion(ProductName());
		Assert.assertTrue(Result);
		TestResult = true;
	}

	/*
	 * Check whether the Refine by Discount option is displayed or not.
	 */
	@Test(priority = 23)
	public void TestCase_023() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.Discount(ProductName());
		Assert.assertTrue(Result);
		TestResult = true;
	}

	/*
	 * Check whether the Refine by Colors option is displayed or not.
	 */
	@Test(priority = 24, groups = "Smoke Testing")
	public void TestCase_024() throws IOException {
		PageFactory.initElements(driver, POM);
		boolean Result = POM.Color(ProductName());
		Assert.assertTrue(Result);
		TestResult = true;
	}

	/*
	 * Check whether the Refine by Size & Fit option is displayed or not.
	 */
	@Test(priority = 25)
	public void TestCase_025() throws IOException {
		PageFactory.initElements(driver, POM);
		boolean Result = POM.SizeFit(ProductName());
		Assert.assertTrue(Result);
		TestResult = true;
	}

	/*
	 * Check whether the Refine by More Filters option is displayed or not.
	 */
	@Test(priority = 26)
	public void TestCase_026() throws IOException {
		PageFactory.initElements(driver, POM);
		boolean Result = POM.MoreFilter(ProductName());
		Assert.assertTrue(Result);
		TestResult = true;
	}

	/**
	 * verify the functionality of the 'Sort By' feature on the search result page
	 */
	/*
	 * check whether selecting price(lowest first) option on sort by feature will
	 * display related products or not
	 */
	@Test(priority = 27, groups = "Sanity Testing")
	public void TestCase_027() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.SortBy(ProductName(), 0);
		Assert.assertTrue(Result);
		TestResult = true;
	}

	/*
	 * check whether selecting Relavance option on sort by feature will display
	 * related products or not
	 */
	@Test(priority = 28)
	public void TestCase_028() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.SortBy(ProductName(), 1);
		Assert.assertTrue(Result);
		TestResult = true;
	}

	/*
	 * check whether selecting Discount option on sort by feature will display
	 * related products or not
	 */
	@Test(priority = 29, groups = "Smoke Testing")
	public void TestCase_029() throws IOException {
		PageFactory.initElements(driver, POM);
		boolean Result = POM.SortBy(ProductName(), 2);
		Assert.assertTrue(Result);
		TestResult = true;
	}

	/*
	 * check whether selecting Price(highest first) option on sort by feature will
	 * display related products or not
	 */
	@Test(priority = 30, groups = "Sanity Testing")
	public void TestCase_030() throws IOException {
		PageFactory.initElements(driver, POM);
		boolean Result = POM.SortBy(ProductName(), 3);
		Assert.assertTrue(Result);
		TestResult = true;
	}

	/*
	 * check whether selecting What's new option on sort by feature will display
	 * related products or not
	 */
	@Test(priority = 31)
	public void TestCase_031() throws IOException {
		PageFactory.initElements(driver, POM);
		boolean Result = POM.SortBy(ProductName(), 4);
		Assert.assertTrue(Result);
		TestResult = true;
	}

	/**
	 * 
	 * 
	 * Verify the functionality of the Gender option on the Refine by Feature
	 */
	/*
	 * Check whether selecting Boys option on Gender feature will display related
	 * products or not
	 */
	@Test(priority = 32)
	public void TestCase_032() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.Boy(ProductName());
		Assert.assertTrue(Result);
		TestResult = true;
	}

	/*
	 * Check whether selecting Girls option on Gender feature will display related
	 * products or not
	 */
	@Test(priority = 33)
	public void TestCase_033() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.Girl(ProductName());
		Assert.assertTrue(Result);
		TestResult = true;
	}

	/*
	 * Check whether selecting Infants option on Gender feature will display related
	 * products or not
	 */
	@Test(priority = 34)
	public void TestCase_034() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.Infant(ProductName());
		Assert.assertTrue(Result);
		TestResult = true;
	}

	/*
	 * Check whether selecting Men option on Gender feature will display related
	 * products or not
	 */
	@Test(priority = 35, groups = "Smoke Testing")
	public void TestCase_035() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.Mens(ProductName());
		Assert.assertTrue(Result);
		TestResult = true;
	}

	/*
	 * Check whether selecting Women option on Gender feature will display related
	 * products or not
	 */
	@Test(priority = 36)
	public void TestCase_036() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.Womens(ProductName());
		Assert.assertTrue(Result);
		TestResult = true;
	}

	/*
	 * Check whether selecting Select All option on Gender feature will display
	 * related products or not
	 */
	@Test(priority = 37)
	public void TestCase_037() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.Gen_SelectAll(ProductName(), driver);
		Assert.assertTrue(Result);
		TestResult = true;
	}

	/*
	 * Check whether selecting Clear All option on Gender feature will display
	 * related products or not
	 */
	@Test(priority = 38)
	public void TestCase_038() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.Gen_ClearAll(ProductName(), driver);
		Assert.assertFalse(Result);
		TestResult = true;
	}

	/**
	 * Verify the functionality of the Category option on the Refine by Feature
	 */
	/*
	 * Check whether selecting Shirts option on Category feature will display
	 * related products or not
	 */
	@Test(priority = 39)
	public void TestCase_039() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.Shirt(ProductName());
		Assert.assertTrue(Result);
		TestResult = true;
	}

	/*
	 * Check whether selecting TShirts option on Category feature will display
	 * related products or not
	 */
	@Test(priority = 40, groups = "Sanity Testing")
	public void TestCase_040() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.Tshirt(ProductName());
		Assert.assertTrue(Result);
		TestResult = true;
	}

	/*
	 * Check whether selecting Tees,Tops option on Category feature will display
	 * related products or not
	 */
	@Test(priority = 41)
	public void TestCase_041() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.Tee(ProductName());
		Assert.assertTrue(Result);
		TestResult = true;
	}

	/*
	 * Check whether selecting Tops,Tunics option on Category feature will display
	 * related products or not
	 */
	@Test(priority = 42)
	public void TestCase_042() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.Top(ProductName());
		Assert.assertTrue(Result);
		TestResult = true;
	}

	/*
	 * Check whether selecting MaternityWear option on Category feature will display
	 * related products or not
	 */
	@Test(priority = 43, groups = "Smoke Testing")
	public void TestCase_043() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.MaternityWear(ProductName());
		Assert.assertTrue(Result);
		TestResult = true;
	}

	/*
	 * Check whether selecting Select All option on Category feature will display
	 * related products or not
	 */
	@Test(priority = 44)
	public void TestCase_044() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.Cat_SelectAll(ProductName(), driver);
		Assert.assertTrue(Result);
		TestResult = true;
	}

	/*
	 * Check whether selecting Clear All option on Category feature will display
	 * related products or not
	 */
	@Test(priority = 45)
	public void TestCase_045() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.Cat_ClearAll(ProductName(), driver);
		Assert.assertFalse(Result);
		TestResult = true;
	}

	/**
	 * Verify the functionality of the Price option on the Refine by Feature
	 */
	/*
	 * Check whether selecting a single Price option on Price feature will display
	 * related products or not
	 */
	@Test(priority = 46, groups = "Sanity Testing")
	public void TestCase_046() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.PriceOpt_1(ProductName());
		Assert.assertTrue(Result);
		TestResult = true;
	}

	/*
	 * Check whether selecting Multiple Price option on Price feature will display
	 * related products or not
	 */
	@Test(priority = 47)
	public void TestCase_047() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.PriceOpt_2(ProductName());
		Assert.assertTrue(Result);
		TestResult = true;
	}

	/*
	 * Check whether selecting Select All option on price feature will display
	 * related products or not
	 */
	@Test(priority = 48)
	public void TestCase_048() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.Price_SelectAll(ProductName(), driver);
		Assert.assertTrue(Result);
		TestResult = true;
	}

	/*
	 * Check whether selecting Clear All option on Price feature will display
	 * related products or not
	 */
	@Test(priority = 49)
	public void TestCase_049() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.Price_ClearAll(ProductName(), driver);
		Assert.assertFalse(Result);
		TestResult = true;
	}

	/**
	 * Verify the functionality of the Brand option on the Refine by Feature
	 */
	/*
	 * Check whether selecting a Brand Name option on Brand feature will display
	 * related products or not
	 */
	@Test(priority = 50)
	public void TestCase_050() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.BrandOpt_1(ProductName());
		Assert.assertTrue(Result);
		TestResult = true;
	}

	/*
	 * Check whether selecting Multiple Brand Name option on Brand feature will
	 * display related products or not
	 */
	@Test(priority = 51)
	public void TestCase_051() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.BrandOpt_2(ProductName());
		Assert.assertTrue(Result);
		TestResult = true;
	}

	/*
	 * Check whether selecting a Select All option on Brand feature will display
	 * related products or not
	 */
	@Test(priority = 52)
	public void TestCase_052() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.Brand_SelectAll(ProductName(), driver);
		Assert.assertTrue(Result);
		TestResult = true;
	}

	/*
	 * Check whether selecting a Clear All option on Brand feature will display
	 * related products or not
	 */
	@Test(priority = 53, groups = "Smoke Testing")
	public void TestCase_053() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.Brand_ClearAll(ProductName(), driver);
		Assert.assertFalse(Result);
		TestResult = true;
	}

	/**
	 * Verify the functionality of the Occasion option on the Refine by Feature
	 */
	/*
	 * Check whether selecting a Single option on Occasion feature will display
	 * related products or not
	 */
	@Test(priority = 54)
	public void TestCase_054() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.OccasionOpt_1(ProductName());
		Assert.assertTrue(Result);
		TestResult = true;
	}

	/*
	 * Check whether selecting Multiple option on Occasion feature will display
	 * related products or not
	 */
	@Test(priority = 55)
	public void TestCase_055() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.OccasionOpt_2(ProductName());
		Assert.assertTrue(Result);
		TestResult = true;
	}

	/*
	 * Check whether selecting a Select All Option on Occasion feature will display
	 * related products or not
	 */
	@Test(priority = 56, groups = "Sanity Testing")
	public void TestCase_056() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.Occasion_SelectAll(ProductName(), driver);
		Assert.assertTrue(Result);
		TestResult = true;
	}

	/*
	 * Check whether selecting a Clear All Option on Occasion feature will display
	 * related products or not
	 */
	@Test(priority = 57)
	public void TestCase_057() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.Occasion_ClearAll(ProductName(), driver);
		Assert.assertFalse(Result);
		TestResult = true;
	}

	/**
	 * Verify the functionality of the Discount option on the Refine by Feature
	 */
	/*
	 * Check whether selecting a Single Option on Discount feature will display
	 * related products or not
	 */

	@Test(priority = 58, groups = "Smoke Testing")
	public void TestCase_058() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.DiscountOpt_1(ProductName());
		Assert.assertTrue(Result);
		TestResult = true;
	}

	/*
	 * Check whether selecting Multiple Option on Discount feature will display
	 * related products or not
	 */
	@Test(priority = 59)
	public void TestCase_059() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.DiscountOpt_2(ProductName());
		Assert.assertTrue(Result);
		TestResult = true;
	}

	/*
	 * Check whether selecting a Select All on Discount feature will display related
	 * products or not
	 */
	@Test(priority = 60)
	public void TestCase_060() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.Discount_SelectAll(ProductName(), driver);
		Assert.assertTrue(Result);
		TestResult = true;
	}

	/*
	 * Check whether selecting a Clear All Option on Discount feature will display
	 * related products or not
	 */
	@Test(priority = 61)
	public void TestCase_061() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.Discount_ClearAll(ProductName(), driver);
		Assert.assertFalse(Result);
		TestResult = true;
	}

	/**
	 * Verify the functionality of the Color option on the Refine by Feature
	 */
	/*
	 * Check whether selecting a Color Option on Color feature will display related
	 * products or not
	 */

	@Test(priority = 62)
	public void TestCase_062() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.ColorsOpt_1(ProductName());
		Assert.assertTrue(Result);
		TestResult = true;
	}

	/*
	 * Check whether selecting Multiple Color Option on Color feature will display
	 * related products or not
	 */
	@Test(priority = 63)
	public void TestCase_063() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.ColorsOpt_2(ProductName());
		Assert.assertTrue(Result);
		TestResult = true;
	}

	/*
	 * Check whether selecting a Select All Option on Color feature will display
	 * related products or not
	 */
	@Test(priority = 64, groups = "Smoke Testing")
	public void TestCase_064() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.Colors_SelectAll(ProductName(), driver);
		Assert.assertTrue(Result);
		TestResult = true;
	}

	/*
	 * Check whether selecting a Clear All Option on Color feature will display
	 * related products or not
	 */
	@Test(priority = 65)
	public void TestCase_065() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.Colors_ClearAll(ProductName(), driver);
		Assert.assertFalse(Result);
		TestResult = true;
	}

	/**
	 * Verify the functionality of the SizeFit option on the Refine by Feature
	 */
	/*
	 * Check whether selecting by a Single Option on Size & Fit feature will display
	 * related products or not
	 */

	@Test(priority = 66)
	public void TestCase_066() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.SizeFitOpt1(ProductName());
		Assert.assertTrue(Result);
		TestResult = true;
	}

	/*
	 * Check whether selecting by Multiple Option on Size & Fit feature will display
	 * related products or not
	 */
	@Test(priority = 67)
	public void TestCase_067() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.SizeFitOpt2(ProductName());
		Assert.assertTrue(Result);
		TestResult = true;
	}

	/*
	 * Check whether selecting by a Select All Option on Size & Fit feature will
	 * display related products or not
	 */
	@Test(priority = 68, groups = "Smoke Testing")
	public void TestCase_068() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.SizeFit_SelectAll(ProductName(), driver);
		Assert.assertTrue(Result);
		TestResult = true;
	}

	/*
	 * Check whether selecting by a Clear All Option on Size & Fit feature will
	 * display related products or not
	 */
	@Test(priority = 69)
	public void TestCase_069() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.SizeFit_ClearAll(ProductName(), driver);
		Assert.assertFalse(Result);
		TestResult = true;
	}

	/**
	 * Verify that the Product Details on the Search Result Page
	 */

	/*
	 * Check whether the product Brand name is displayed or not on the search result
	 * page
	 */
	@Test(priority = 70)
	public void TestCase_070() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.ProductBrand(ProductName());
		Assert.assertTrue(Result);
		TestResult = true;
	}

	/*
	 * Check whether the product Name is displayed or not on the search result page
	 */
	@Test(priority = 71)
	public void TestCase_071() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.ProductName(ProductName());
		Assert.assertTrue(Result);
		TestResult = true;
	}

	/*
	 * Check whether the Actual price Of the Product is displayed or not on the
	 * search result page
	 */
	@Test(priority = 72)
	public void TestCase_072() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.ProductPrice(ProductName());
		Assert.assertTrue(Result);
		TestResult = true;
	}

	/*
	 * Check whether the (BBS Price)Discount price Of the Product is displayed or
	 * not on the search result page
	 */
	@Test(priority = 73)
	public void TestCase_073() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.ProductOffPrice(ProductName());
		Assert.assertTrue(Result);
		TestResult = true;
	}

	/*
	 * check whether mouse hovering over a product quick view option will display or
	 * not
	 */
	@Test(priority = 74)
	public void TestCase_074() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.ProductQuickview(driver, ProductName());
		Assert.assertTrue(Result);
		TestResult = true;
	}

	/*
	 * Check whether clicking on a product will redirect to product details page or
	 * not
	 */
	@Test(priority = 75)
	public void TestCase_075() throws IOException {
		driver.get(Url());
		PageFactory.initElements(driver, POM);
		boolean Result = POM.ProductDetailsPage(driver, ProductName());
		Assert.assertTrue(Result);
		TestResult = true;
	}
}
