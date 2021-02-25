package pages;

import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.util.WebTestBase;

public class BookingDetails extends WebTestBase{
	
	public BookingDetails(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public List<WebElement> getCategorys() {
		return categorys;
	}

	public WebElement getQuantity() {
		return quantity;
	}

	public WebElement getSize() {
		return size;
	}

	public List<WebElement> getColor() {
		return color;
	}

	public WebElement getAddToCart() {
		return addToCart;
	}

	public WebElement getProceedToCheckOut() {
		return proceedToCheckOut;
	}

	public List<WebElement> getPrices() {
		return prices;
	}

	public WebElement getContinueShopping() {
		return continueShopping;
	}

	public WebElement getProceedToCheckOutMainPage() {
		return proceedToCheckOutMainPage;
	}

	public WebElement getProceedToCheckOutAddress() {
		return proceedToCheckOutAddress;
	}

	public WebElement getProceedToCheckOutShipping() {
		return proceedToCheckOutShipping;
	}

	public WebElement getTos() {
		return tos;
	}

	public WebElement getConformMyOrder() {
		return conformMyOrder;
	}

	public WebElement getPayByBanWire() {
		return payByBanWire;
	}

	public WebElement getOrderHistory() {
		return orderHistory;
	}
	
	public WebElement getListView() {
		return listView;
	}
	
	public WebElement getLastOrderDetails() {
		return lastOrderDetails;
	}
	
	public static WebElement more(int index) {
		return driver.findElement(By.xpath("(//a[@title='View'])["+index+"]"));
	}

	@FindBys({
		@FindBy(how = How.XPATH, using = "//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']//li") 
	})
	private List<WebElement> categorys;
	
	@FindBy(how = How.ID, using = "quantity_wanted")
	private WebElement quantity;
	
	@FindBy(id = "group_1")
	private WebElement size;
	
	@FindBys({
		@FindBy(xpath = "//ul[@id='color_to_pick_list']//li//a")
	})
	private List<WebElement> color;
	
	@FindBy(xpath = "//button[@name='Submit']")
	private WebElement addToCart;
	
	@FindBy(xpath = "//a[@title='Proceed to checkout']")
	private WebElement proceedToCheckOut;
	
	@FindBys({
		@FindBy(xpath = "//div[@class='content_price col-xs-5 col-md-12']//span[@class='price product-price']")
	})
	private List<WebElement> prices;
	
	@FindBy(xpath = "//div[@class='button-container']//span[@title='Continue shopping']")
	private WebElement continueShopping;
	
	@FindBy(xpath = "//a[@title='Proceed to checkout']//span[text()='Proceed to checkout']")
	private WebElement proceedToCheckOutMainPage;
	
	@FindBy(name = "processAddress")
	private WebElement proceedToCheckOutAddress;
	
	@FindBy(name = "processCarrier")
	private WebElement proceedToCheckOutShipping;
	
	@FindBy(id = "cgv")
	private WebElement tos;
	
	@FindBy(xpath = "//button[@class='button btn btn-default button-medium']")
	private WebElement conformMyOrder;
	
	@FindBy(xpath = "//a[@title='Pay by bank wire']")
	private WebElement payByBanWire;
	
	@FindBy(xpath = "//a[@title='Orders']")
	private WebElement orderHistory;
	
	@FindBy(xpath = "//li[@id='list']")
	private WebElement listView;
	
	@FindBy(xpath = "(//a[@class='btn btn-default button button-small'])[2]")
	private WebElement lastOrderDetails;
}
