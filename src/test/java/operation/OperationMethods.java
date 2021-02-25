package operation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.util.WebTestBase;

import pages.BookingDetails;
import pages.Login;
import pages.Register;
import pages.UserAddress;

public class OperationMethods extends WebTestBase {
	
	static Login login = new Login(driver);
	static UserAddress user = new UserAddress(driver);
	static BookingDetails bookingDetails = new BookingDetails(driver);
	static Register reg = new Register(driver);
	static Select select;
	
	public static void login(String Email, String password) {
		WebTestBase.click(login.getSignIn());
		explicitWait(driver,login.getEmailId(), 10);
		sendKeys(login.getEmailId(), Email);
		sendKeys(login.getPassWord(), password);
		click(login.getLoginButton());
	}
	
	public static void addAddress(String firstname, String last_name, String company, String address,String city,String state,
			String zip_code,String country,String mobileNo, String address_title) {
		click(user.getMyaddress());
		click(user.getAddNewAddress());
		sendKeys(user.getFirstName(),firstname);
		sendKeys(user.getLastName(), last_name);
		sendKeys(user.getCompany(), company);
		sendKeys(user.getAddress(), address);
		scroll(user.getSaveButton());
		sendKeys(user.getCity(), city);
		select = new Select(user.getState());
		select.selectByVisibleText(state);
		sendKeys(user.getPostcode(), zip_code);
		sendKeys(user.getCountry(), country);
		sendKeys(user.getMobilePhone(), mobileNo);
		sendKeys(user.getAlias(), address_title);
		click(user.getSaveButton());
	}
	
	public static void category(String mainCategory, String subCategory) {
		List<WebElement> categorys = bookingDetails.getCategorys();
		for (WebElement webElement : categorys) {
			String category = webElement.getText();
			System.out.println("Category:"+category);
			if(category.equalsIgnoreCase(mainCategory)) {
				mouseOver(webElement);//Mouseover is not working why?
				//click(webElement); //It is working
				break;
			}
				
		}
		for (WebElement webElement : categorys) {
			String category = webElement.getText();
			if(category.equalsIgnoreCase(subCategory)) {
				click(webElement);
				click(bookingDetails.getListView());
				break;
			}
		}
		
	}
	
	//User Selects the highest price dress
	public static void selectDress(String Quantity, String size, String color) {
		boolean b = false;
		List<WebElement> price = bookingDetails.getPrices();
		List<Double> ls= new ArrayList<Double>();
		for (WebElement webElement : price) {
			String text = webElement.getText();
			String replaceAll = text.replaceAll("[^0.000-9.999]", "");
			ls.add(Double.parseDouble(replaceAll));
		}
		Double max = Collections.max(ls);
		int indexOf = ls.indexOf(max);
		click(BookingDetails.more(indexOf+1));
		clear(bookingDetails.getQuantity());
		sendKeys(bookingDetails.getQuantity(), Quantity);
		select = new Select(bookingDetails.getSize());
		select.selectByVisibleText(size);
		List<WebElement> colors = bookingDetails.getColor();
		for (WebElement webElement : colors) {
			String colour = webElement.getAttribute("title");
			System.out.println("Color is:"+colour);
			if(colour.equals(color)) {
				click(webElement);
				b = true;
				break;
			}
		}
		if(b==false)
			System.err.println("invalid Color Name");
		click(bookingDetails.getAddToCart());
		explicitWait(driver,bookingDetails.getProceedToCheckOut(), 10);
		click(bookingDetails.getProceedToCheckOut());
	}
	
	public static void proceedToCheckOut() {
		explicitWait(driver, bookingDetails.getProceedToCheckOutMainPage(), 10);
		scroll(bookingDetails.getProceedToCheckOutMainPage());
		click(bookingDetails.getProceedToCheckOutMainPage());
		scroll(bookingDetails.getProceedToCheckOutAddress());
		click(bookingDetails.getProceedToCheckOutAddress());
		scroll(bookingDetails.getProceedToCheckOutShipping());
		click(bookingDetails.getTos());
		click(bookingDetails.getProceedToCheckOutShipping());
		click(bookingDetails.getPayByBanWire());
		click(bookingDetails.getConformMyOrder());
	}
	
	public static void orderList() throws IOException {
		click(login.getMyAccount());
		click(bookingDetails.getOrderHistory());
		click(bookingDetails.getLastOrderDetails());
		fullScreenShot("orderDetails");
	}
	
	public static void logOut() {
		scroll(reg.getSignOut());
		click(reg.getSignOut());
	}
}