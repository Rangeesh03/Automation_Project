package ajio;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
public class Keywords {

	/**
	 * Keywords for SearchBox,icon,Suggestion list
	 */
	@FindBy(xpath = "//input[@name='searchVal']")
	private WebElement SearchBox;
	@FindBy(xpath = "//button[@class='rilrtl-button']")
	private WebElement SearchIcon;
	@FindBy(xpath = "//ul[@class='rilrtl-list ']")
	private WebElement SuggestionList;
	@FindBy(xpath = "(//ul[@class='rilrtl-list ']/li/a)[1]")
	private WebElement SuggestionFirst;
	/**
	 * Keywords for Search Result Page
	 */
	@FindBy(xpath = "//select")
	private WebElement SortBy;
	@FindBy(xpath = "//div[@class='header2']")
	private WebElement Title;
	@FindBy(xpath = "//div[@class='fnl-plp-filtervisible']")
	private WebElement Filters;
	@FindBy(xpath = "//div[@class='fnl-plp-afliter'][1]/span")
	private WebElement Filter;

	@FindBy(xpath = "//label[@class='grid-text']")
	private WebElement Grid;
	@FindBy(xpath = "//div[@class='gotop ic-toparw']")
	private WebElement NavigationButton;
	@FindBy(xpath = "//select")
	private WebElement SortByFilter;
	@FindBy(xpath = "//div[@class='length']")
	private WebElement TotalCount;

	/**
	 * Keywords for Product Details
	 */
	@FindBy(xpath = "(//div[@class='preview'])[1]")
	private WebElement MhQuickView;
	@FindBy(xpath = "(//div[@class='preview'])[1]/div[1]/div[2]")
	private WebElement QuickView;
	@FindBy(xpath = "(//div[@class='contentHolder'])[1]/../div[1]/div/img")
	private WebElement ProImage;
	@FindBy(xpath = "(//div[@class='contentHolder'])[1]/div[1]")
	private WebElement ProBrand;
	@FindBy(xpath = "(//div[@class='contentHolder'])[1]/div[2]")
	private WebElement ProName;
	@FindBy(xpath = "(//div[@class='contentHolder'])[1]/div[3]/span")
	private WebElement ProPrice;
	@FindBy(xpath = "(//div[@class='contentHolder'])[1]/div[4]/span[2]")
	private WebElement OffPrice;

	/**
	 * Keywords for RefineBy Options
	 */
	@FindBy(xpath = "//div[@class='facet-arwup facet-typehead ']")
	private WebElement RefineBy;
	@FindBy(xpath = "//div[@class='facet-typebody']/ul/li[1]/div/div/div")
	private WebElement Gender;
	@FindBy(xpath = "//div[@class='facet-typebody']/ul/li[2]/div/div/div")
	private WebElement Category;
	@FindBy(xpath = "//div[@class='facet-typebody']/ul/li[3]/div/div/div")
	private WebElement Price;
	@FindBy(xpath = "//div[@class='facet-typebody']/ul/li[4]/div/div/div")
	private WebElement Brands;
	@FindBy(xpath = "//div[@class='facet-typebody']/ul/li[5]/div/div/div")
	private WebElement Occasion;
	@FindBy(xpath = "//div[@class='facet-typebody']/ul/li[6]/div/div/div")
	private WebElement Discount;
	@FindBy(xpath = "//div[@class='facet-typebody']/ul/li[7]/div/div/div")
	private WebElement Colors;
	@FindBy(xpath = "//div[@class='facet-typebody']/ul/li[8]/div/div/div")
	private WebElement SizeFit;
	@FindBy(xpath = "(//div[@class='facet-typebody']/div/div/div)[1]")
	private WebElement MoreFilters;

	/**
	 * Keywords for Gender Options
	 */
	@FindBy(xpath = "//div[@class='facet-typebody']/ul/li[1]/div/div/div[2]/ul/li[1]")
	private WebElement Men;
	@FindBy(xpath = "//div[@class='facet-typebody']/ul/li[1]/div/div/div[2]/ul/li[2]")
	private WebElement Women;
	@FindBy(xpath = "//div[@class='facet-typebody']/ul/li[1]/div/div/div[2]/ul/li[3]")
	private WebElement Boys;
	@FindBy(xpath = "//div[@class='facet-typebody']/ul/li[1]/div/div/div[2]/ul/li[4]")
	private WebElement Girls;
	@FindBy(xpath = "//div[@class='facet-typebody']/ul/li[1]/div/div/div[2]/ul/li[5]")
	private WebElement Infants;

	/**
	 * Keywords for Category Options
	 */
	@FindBy(xpath = "//div[@class='facet-typebody']/ul/li[2]/div/div/div[2]/ul/li[1]")
	private WebElement Tshirts;
	@FindBy(xpath = "//div[@class='facet-typebody']/ul/li[2]/div/div/div[2]/ul/li[2]")
	private WebElement Shirts;
	@FindBy(xpath = "//div[@class='facet-typebody']/ul/li[2]/div/div/div[2]/ul/li[3]")
	private WebElement Tops;
	@FindBy(xpath = "//div[@class='facet-typebody']/ul/li[2]/div/div/div[2]/ul/li[4]")
	private WebElement Tees;
	@FindBy(xpath = "//div[@class='facet-typebody']/ul/li[2]/div/div/div[2]/ul/li[5]")
	private WebElement MaternityWear;

	/**
	 * Keywords for Price Options
	 */
	@FindBy(xpath = "//div[@class='facet-typebody']/ul/li[3]/div/div/div[2]/ul/li[1]")
	private WebElement PriceOpt1;
	@FindBy(xpath = "//div[@class='facet-typebody']/ul/li[3]/div/div/div[2]/ul/li[2]")
	private WebElement PriceOpt2;

	/**
	 * Keywords for Brand Options
	 */
	@FindBy(xpath = "//div[@class='facet-typebody']/ul/li[4]/div/div/div[2]/ul/li[1]")
	private WebElement BrandOpt1;
	@FindBy(xpath = "//div[@class='facet-typebody']/ul/li[4]/div/div/div[2]/ul/li[2]")
	private WebElement BrandOpt2;

	/**
	 * Keywords for Occasion Options
	 */
	@FindBy(xpath = "//div[@class='facet-typebody']/ul/li[5]/div/div/div[2]/ul/li[1]")
	private WebElement OccasionOpt1;
	@FindBy(xpath = "//div[@class='facet-typebody']/ul/li[5]/div/div/div[2]/ul/li[2]")
	private WebElement OccasionOpt2;

	/**
	 * Keywords for Discount Options
	 */
	@FindBy(xpath = "//div[@class='facet-typebody']/ul/li[6]/div/div/div[2]/ul/li[1]")
	private WebElement DiscountOpt1;
	@FindBy(xpath = "//div[@class='facet-typebody']/ul/li[6]/div/div/div[2]/ul/li[2]")
	private WebElement DiscountOpt2;

	/**
	 * Keywords for Color Options
	 */
	@FindBy(xpath = "//div[@class='facet-typebody']/ul/li[7]/div/div/div[2]/ul/li[1]")
	private WebElement ColorOpt1;
	@FindBy(xpath = "//div[@class='facet-typebody']/ul/li[7]/div/div/div[2]/ul/li[2]")
	private WebElement ColorOpt2;

	/**
	 * Keywords for SizeFit Options
	 */
	@FindBy(xpath = "//div[@class='facet-typebody']/ul/li[8]/div/div/div[2]/ul/li[1]")
	private WebElement SizeFitOpt1;
	@FindBy(xpath = "//div[@class='facet-typebody']/ul/li[8]/div/div/div[2]/ul/li[2]")
	private WebElement SizeFitOpt2;

	/**
	 * Keywords for SelectAll and ClearAll for all RefineBy options
	 */
	@FindBy(xpath = "(//div[@class='facet-slctclr'])[1]/div[1]")
	private WebElement GenderSelectAll;
	@FindBy(xpath = "(//div[@class='facet-slctclr'])[1]/div[2]")
	private WebElement GenderClearAll;
	@FindBy(xpath = "(//div[@class='facet-slctclr'])[2]/div[1]")
	private WebElement CategorySelectAll;
	@FindBy(xpath = "(//div[@class='facet-slctclr'])[2]/div[2]")
	private WebElement CategoryClearAll;
	@FindBy(xpath = "(//div[@class='facet-slctclr'])[3]/div[1]")
	private WebElement PriceSelectAll;
	@FindBy(xpath = "(//div[@class='facet-slctclr'])[3]/div[2]")
	private WebElement PriceClearAll;
	@FindBy(xpath = "(//div[@class='facet-slctclr'])[4]/div[1]")
	private WebElement BrandsSelectAll;
	@FindBy(xpath = "(//div[@class='facet-slctclr'])[4]/div[2]")
	private WebElement BrandsClearAll;
	@FindBy(xpath = "(//div[@class='facet-slctclr'])[5]/div[1]")
	private WebElement OccasionSelectAll;
	@FindBy(xpath = "(//div[@class='facet-slctclr'])[5]/div[2]")
	private WebElement OccasionClearAll;
	@FindBy(xpath = "(//div[@class='facet-slctclr'])[6]/div[1]")
	private WebElement DiscountSelectAll;
	@FindBy(xpath = "(//div[@class='facet-slctclr'])[6]/div[2]")
	private WebElement DiscountClearAll;
	@FindBy(xpath = "(//div[@class='facet-slctclr'])[7]/div[1]")
	private WebElement ColorsSelectAll;
	@FindBy(xpath = "(//div[@class='facet-slctclr'])[7]/div[2]")
	private WebElement ColorsClearAll;
	@FindBy(xpath = "(//div[@class='facet-slctclr'])[8]/div[1]")
	private WebElement SizeFitSelectAll;
	@FindBy(xpath = "(//div[@class='facet-slctclr'])[8]/div[2]")
	private WebElement SizeFitClearAll;
	/**
	 * 
	 */

	static Robot r;

	public void ScreenShot(WebDriver driver, String name) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sorce = ts.getScreenshotAs(OutputType.FILE);
		File Destnation = new File("./ScreenShot/" + name + ".png");
		FileUtils.copyFile(sorce, Destnation);

	}

	public void Search(String data) {
		SearchBox.sendKeys(data);
		SearchIcon.click();
	}

	public void ClearText() {
		SearchBox.clear();
	}

	public boolean Suggestion(String data) throws InterruptedException {
		SearchBox.sendKeys(data);
		Thread.sleep(100);
		boolean Result;
		try {
			Result = (SuggestionList.isDisplayed()) ? true : false;
		} catch (Exception e) {
			Result = false;
		}

		return Result;
	}

	public boolean SuggestionFirst(String data) throws AWTException, InterruptedException {
		SearchBox.sendKeys(data);
		Thread.sleep(100);
		r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		boolean Result = (SuggestionFirst.getText().contains(SearchBox.getText())) ? true : false;
		return Result;
	}

	public boolean TotalCount(String data) {
		Search(data);
		boolean Result = (TotalCount.isDisplayed()) ? true : false;
		return Result;
	}

	public boolean GridView(String data) {
		Search(data);
		boolean Result = (Grid.isDisplayed()) ? true : false;
		return Result;
	}

	public boolean SortByOption(String data) {
		Search(data);
		boolean Result = (SortBy.isDisplayed()) ? true : false;
		return Result;
	}

	public boolean Gender(String data) {
		Search(data);
		boolean Result = (Gender.isDisplayed()) ? true : false;
		return Result;
	}

	public boolean Category(String data) {
		Search(data);
		boolean Result = (Category.isDisplayed()) ? true : false;
		return Result;
	}

	public boolean Price(String data) {
		Search(data);
		Gender.click();
		Category.click();
		boolean Result = (Price.isDisplayed()) ? true : false;
		return Result;
	}

	public boolean Brand(String data) {
		Search(data);
		Gender.click();
		Category.click();
		boolean Result = (Brands.isDisplayed()) ? true : false;
		return Result;
	}

	public boolean Occasion(String data) {
		Search(data);
		Gender.click();
		Category.click();
		boolean Result = (Occasion.isDisplayed()) ? true : false;
		return Result;
	}

	public boolean Discount(String data) {
		Search(data);
		Gender.click();
		Category.click();
		boolean Result = (Discount.isDisplayed()) ? true : false;
		return Result;
	}

	public boolean Color(String data) {
		Search(data);
		Gender.click();
		Category.click();
		boolean Result = (Colors.isDisplayed()) ? true : false;
		return Result;
	}

	public boolean SizeFit(String data) {
		Search(data);
		Gender.click();
		Category.click();
		boolean Result = (SizeFit.isDisplayed()) ? true : false;
		return Result;
	}

	public boolean MoreFilter(String data) {
		Search(data);
		Gender.click();
		Category.click();
		boolean Result = (MoreFilters.isDisplayed()) ? true : false;
		return Result;
	}

	public boolean SortBy(String data, int index) {
		Search(data);
		Select s = new Select(SortBy);
		s.selectByIndex(index);
		String ExResult = TotalCount.getText();
		boolean Result = (ExResult.contains("Items Found")) ? true : false;
		return Result;
	}

	/**
	 * Verify the functionality of the Gender option on the Refine by Feature
	 */

	public boolean Boy(String data) {
		Search(data);
		Boys.click();
		String ExResult = Filters.getText();
		boolean Result = (ExResult.contains("Boys")) ? true : false;
		return Result;
	}

	public boolean Girl(String data) {
		Search(data);
		Girls.click();
		String ExResult = Filters.getText();
		boolean Result = (ExResult.contains("Girls")) ? true : false;
		return Result;
	}

	public boolean Infant(String data) {
		Search(data);
		Infants.click();
		String ExResult = Filters.getText();
		boolean Result = (ExResult.contains("Infants")) ? true : false;
		return Result;
	}

	public boolean Mens(String data) {
		Search(data);
		Men.click();
		String ExResult = Filters.getText();
		boolean Result = (ExResult.contains("Men")) ? true : false;
		return Result;
	}

	public boolean Womens(String data) {
		Search(data);
		Women.click();
		String ExResult = Filters.getText();
		boolean Result = (ExResult.contains("Women")) ? true : false;
		return Result;
	}

	public boolean Gen_SelectAll(String data, WebDriver driver) {
		Search(data);
		Actions a = new Actions(driver);
		a.moveToElement(Gender).perform();
		GenderSelectAll.click();
		String ExResult = Filters.getText();
		boolean Result = (ExResult.contains("Women")) ? true : false;
		return Result;
	}

	public boolean Gen_ClearAll(String data, WebDriver driver) {
		Search(data);
		Actions a = new Actions(driver);
		a.moveToElement(Gender).perform();
		GenderSelectAll.click();
		a.moveToElement(Gender).perform();
		GenderClearAll.click();
		boolean ExResult = Boys.isSelected();
		boolean Result = (ExResult) ? true : false;
		return Result;
	}

	/**
	 * Verify the functionality of the Categroy option on the Refine by Feature
	 */

	public boolean Tshirt(String data) {
		Search(data);
		Tshirts.click();
		String ExResult = Filters.getText();
		boolean Result = (ExResult.contains("Tshirts")) ? true : false;
		return Result;
	}

	public boolean Shirt(String data) {
		Search(data);
		Shirts.click();
		String ExResult = Filters.getText();
		boolean Result = (ExResult.contains("Shirts")) ? true : false;
		return Result;
	}

	public boolean Top(String data) {
		Search(data);
		Tops.click();
		String ExResult = Filters.getText();
		boolean Result = (ExResult.contains("Tops")) ? true : false;
		return Result;
	}

	public boolean Tee(String data) {
		Search(data);
		Tees.click();
		String ExResult = Filters.getText();
		boolean Result = (ExResult.contains("Tees")) ? true : false;
		return Result;
	}

	public boolean MaternityWear(String data) {
		Search(data);
		MaternityWear.click();
		String ExResult = Filters.getText();
		boolean Result = (ExResult.contains("Maternity")) ? true : false;
		return Result;
	}

	public boolean Cat_SelectAll(String data, WebDriver driver) {
		Search(data);
		Actions a = new Actions(driver);
		a.moveToElement(Category).perform();
		CategorySelectAll.click();
		String ExResult = Filters.getText();
		boolean Result = (ExResult.contains("Shirts")) ? true : false;
		return Result;
	}

	public boolean Cat_ClearAll(String data, WebDriver driver) {
		Search(data);
		Actions a = new Actions(driver);
		a.moveToElement(Category).perform();
		CategorySelectAll.click();
		a.moveToElement(Category).perform();
		CategoryClearAll.click();
		boolean ExResult = Shirts.isSelected();
		boolean Result = (ExResult) ? true : false;
		return Result;
	}

	/**
	 * Verify the functionality of the Price option on the Refine by Feature
	 */
	public boolean PriceOpt_1(String data) {
		Search(data);
		Gender.click();
		Category.click();
		Price.click();
		PriceOpt1.click();
		String ExResult = Filters.getText();
		boolean Result = (ExResult.contains("0")) ? true : false;
		return Result;
	}

	public boolean PriceOpt_2(String data) {
		Search(data);
		Gender.click();
		Category.click();
		Price.click();
		PriceOpt1.click();
		PriceOpt2.click();
		String ExResult = Filters.getText();
		boolean Result = (ExResult.contains("0")) ? true : false;
		return Result;
	}

	public boolean Price_SelectAll(String data, WebDriver driver) {
		Search(data);
		Gender.click();
		Category.click();
		Price.click();
		Actions a = new Actions(driver);
		a.moveToElement(Price).perform();
		PriceSelectAll.click();
		String ExResult = Filters.getText();
		boolean Result = (ExResult.contains("0")) ? true : false;
		return Result;
	}

	public boolean Price_ClearAll(String data, WebDriver driver) {
		Search(data);
		Gender.click();
		Category.click();
		Price.click();
		Actions a = new Actions(driver);
		a.moveToElement(Price).perform();
		PriceSelectAll.click();
		a.moveToElement(Price).perform();
		PriceClearAll.click();
		boolean ExResult = PriceOpt1.isSelected();
		boolean Result = (ExResult) ? true : false;
		return Result;
	}

	/**
	 * Verify the functionality of the Brand option on the Refine by Feature
	 */
	public boolean BrandOpt_1(String data) {
		Search(data);
		Gender.click();
		Category.click();
		Brands.click();
		BrandOpt1.click();
		String ExResult = Filters.getText();
		boolean Result = (ExResult.contains("1")) ? true : false;
		return Result;
	}

	public boolean BrandOpt_2(String data) {
		Search(data);
		Gender.click();
		Category.click();
		Brands.click();
		BrandOpt1.click();
		BrandOpt2.click();
		String ExResult = Filters.getText();
		boolean Result = (ExResult.contains("1")) ? true : false;
		return Result;
	}

	public boolean Brand_SelectAll(String data, WebDriver driver) {
		Search(data);
		Gender.click();
		Category.click();
		Brands.click();
		Actions a = new Actions(driver);
		a.moveToElement(Brands).perform();
		BrandsSelectAll.click();
		String ExResult = Filters.getText();
		boolean Result = (ExResult.contains("1")) ? true : false;
		return Result;
	}

	public boolean Brand_ClearAll(String data, WebDriver driver) {
		Search(data);
		Gender.click();
		Category.click();
		Brands.click();
		Actions a = new Actions(driver);
		BrandOpt1.click();
		BrandOpt2.click();
		a.moveToElement(Brands).perform();
		BrandsClearAll.click();
		boolean ExResult = BrandOpt2.isSelected();
		boolean Result = (ExResult) ? true : false;
		return Result;
	}

	/**
	 * Verify the functionality of the Occasion option on the Refine by Feature
	 */
	public boolean OccasionOpt_1(String data) {
		Search(data);
		Gender.click();
		Category.click();
		Occasion.click();
		OccasionOpt1.click();
		String ExResult = Filters.getText();
		boolean Result = (ExResult.contains("Active")) ? true : false;
		return Result;
	}

	public boolean OccasionOpt_2(String data) {
		Search(data);
		Gender.click();
		Category.click();
		Occasion.click();
		OccasionOpt1.click();
		OccasionOpt2.click();
		String ExResult = Filters.getText();
		boolean Result = (ExResult.contains("Active")) ? true : false;
		return Result;
	}

	public boolean Occasion_SelectAll(String data, WebDriver driver) {
		Search(data);
		Gender.click();
		Category.click();
		Occasion.click();
		Actions a = new Actions(driver);
		a.moveToElement(Occasion).perform();
		OccasionSelectAll.click();
		String ExResult = Filters.getText();
		boolean Result = (ExResult.contains("Active")) ? true : false;
		return Result;
	}

	public boolean Occasion_ClearAll(String data, WebDriver driver) {
		Search(data);
		Gender.click();
		Category.click();
		Occasion.click();
		Actions a = new Actions(driver);
		a.moveToElement(Occasion).perform();
		OccasionSelectAll.click();
		a.moveToElement(Occasion).perform();
		OccasionClearAll.click();
		boolean ExResult = OccasionOpt1.isSelected();
		boolean Result = (ExResult) ? true : false;
		return Result;
	}

	/**
	 * Verify the functionality of the Discount option on the Refine by Feature
	 */
	public boolean DiscountOpt_1(String data) {
		Search(data);
		Gender.click();
		Category.click();
		Discount.click();
		DiscountOpt1.click();
		String ExResult = Filters.getText();
		boolean Result = (ExResult.contains("%")) ? true : false;
		return Result;
	}

	public boolean DiscountOpt_2(String data) {
		Search(data);
		Gender.click();
		Category.click();
		Discount.click();
		DiscountOpt1.click();
		DiscountOpt2.click();
		String ExResult = Filters.getText();
		boolean Result = (ExResult.contains("%")) ? true : false;
		return Result;
	}

	public boolean Discount_SelectAll(String data, WebDriver driver) {
		Search(data);
		Gender.click();
		Category.click();
		Discount.click();
		Actions a = new Actions(driver);
		a.moveToElement(Discount).perform();
		DiscountSelectAll.click();
		String ExResult = Filters.getText();
		boolean Result = (ExResult.contains("%")) ? true : false;
		return Result;
	}

	public boolean Discount_ClearAll(String data, WebDriver driver) {
		Search(data);
		Gender.click();
		Category.click();
		Discount.click();
		Actions a = new Actions(driver);
		a.moveToElement(Discount).perform();
		DiscountSelectAll.click();
		a.moveToElement(Discount).perform();
		DiscountClearAll.click();
		boolean ExResult = DiscountOpt1.isSelected();
		boolean Result = (ExResult) ? true : false;
		return Result;
	}

	/**
	 * Verify the functionality of the Color option on the Refine by Feature
	 */
	public boolean ColorsOpt_1(String data) {
		Search(data);
		Gender.click();
		Category.click();
		Colors.click();
		ColorOpt1.click();
		String ExResult = Filters.getText();
		boolean Result = (ExResult.contains("Aqua")) ? true : false;
		return Result;
	}

	public boolean ColorsOpt_2(String data) {
		Search(data);
		Gender.click();
		Category.click();
		Colors.click();
		ColorOpt1.click();
		ColorOpt2.click();
		String ExResult = Filters.getText();
		boolean Result = (ExResult.contains("Aqua")) ? true : false;
		return Result;
	}

	public boolean Colors_SelectAll(String data, WebDriver driver) {
		Search(data);
		Gender.click();
		Category.click();
		Colors.click();
		Actions a = new Actions(driver);
		a.moveToElement(Colors).perform();
		ColorsSelectAll.click();
		String ExResult = Filters.getText();
		boolean Result = (ExResult.contains("Aqua")) ? true : false;
		return Result;
	}

	public boolean Colors_ClearAll(String data, WebDriver driver) {
		Search(data);
		Gender.click();
		Category.click();
		Colors.click();
		Actions a = new Actions(driver);
		a.moveToElement(Colors).perform();
		ColorsSelectAll.click();
		a.moveToElement(Colors).perform();
		ColorsClearAll.click();
		boolean ExResult = ColorOpt1.isSelected();
		boolean Result = (ExResult) ? true : false;
		return Result;
	}
	/**
	 * Verify the functionality of the Color option on the Refine by Feature
	 */
	public boolean SizeFitOpt1(String data) {
		Search(data);
		Gender.click();
		Category.click();
		SizeFit.click();
		SizeFitOpt1.click();
		String ExResult = Filters.getText();
		boolean Result = (ExResult.contains("M")) ? true : false;
		return Result;
	}

	public boolean SizeFitOpt2(String data) {
		Search(data);
		Gender.click();
		Category.click();
		SizeFit.click();
		SizeFitOpt1.click();
		SizeFitOpt2.click();
		String ExResult = Filters.getText();
		boolean Result = (ExResult.contains("M")) ? true : false;
		return Result;
	}

	public boolean SizeFit_SelectAll(String data, WebDriver driver) {
		Search(data);
		Gender.click();
		Category.click();
		SizeFit.click();
		Actions a = new Actions(driver);
		a.moveToElement(SizeFit).perform();
		SizeFitSelectAll.click();
		String ExResult = Filters.getText();
		boolean Result = (ExResult.contains("M")) ? true : false;
		return Result;
	}

	public boolean SizeFit_ClearAll(String data, WebDriver driver) {
		Search(data);
		Gender.click();
		Category.click();
		SizeFit.click();
		Actions a = new Actions(driver);
		a.moveToElement(SizeFit).perform();
		SizeFitSelectAll.click();
		a.moveToElement(SizeFit).perform();
		SizeFitClearAll.click();
		boolean ExResult = SizeFitOpt1.isSelected();
		boolean Result = (ExResult) ? true : false;
		return Result;
	}
/**
 * Verify that the Product Details on the Search Result Page
 * @throws InterruptedException 
 */
	public boolean ProductImage(String data) throws InterruptedException {
		Search(data);
		Thread.sleep(500);
		boolean Result = (ProImage.isDisplayed()) ? true : false;
		return Result;
	}
	public boolean ProductPrice(String data) {
		Search(data);
		boolean Result = (ProPrice.isDisplayed()) ? true : false;
		return Result;
	}
	public boolean ProductBrand(String data) {
		Search(data);
		boolean Result = (ProBrand.isDisplayed()) ? true : false;
		return Result;
	}
	public boolean ProductName(String data) {
		Search(data);
		boolean Result = (ProName.isDisplayed()) ? true : false;
		return Result;
	}
	public boolean ProductOffPrice(String data) {
		Search(data);
		boolean Result = (OffPrice.isDisplayed()) ? true : false;
		return Result;
	}
	public boolean ProductQuickview(WebDriver driver,String data) {
		Search(data);
		Actions a = new Actions(driver);
		a.moveToElement(ProImage).perform();
		boolean Result = (QuickView.isDisplayed()) ? true : false;
		return Result;
	}
	public boolean ProductDetailsPage(WebDriver driver,String data)  {
		Search(data);
		ProImage.click();
        Set<String> tabs=driver.getWindowHandles();
        List<String> wins= new ArrayList<String>(tabs);
        driver.switchTo().window(wins.get(1));
		boolean Result = (driver.getTitle().contains("Buy")) ? true : false;
		return Result;
	}



}