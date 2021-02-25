package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.util.WebTestBase;

public class UserAddress extends WebTestBase {
	
	public UserAddress(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.ID ,using = "id_gender1")
	private WebElement Mr;
	
	@FindBy(id = "id_gender2")
	private WebElement Mrs;
	
	@FindBy(id = "customer_firstname")
	private WebElement customerFirstName;
	
	@FindBy(id = "customer_lastname")
	private WebElement customerLastName;
	
	@FindBy(id = "email")
	private WebElement e_Mail;
	
	@FindBy(id = "passwd")
	private WebElement passWord;
	
	@FindBy(id = "days")
	private WebElement date;
	
	@FindBy(id = "months")
	private WebElement month;
	
	@FindBy(id = "years")
	private WebElement year;
	
	@FindBy(id = "firstname")
	private WebElement firstName;
	
	@FindBy(id = "lastname")
	private WebElement lastName;
	
	@FindBy(id = "company")
	private WebElement company;
	
	@FindBy(id = "address1")
	private WebElement address;
	
	@FindBy(id = "address2")
	private WebElement address2;
	
	@FindBy(id = "city")
	private WebElement city;
	
	@FindBy(id = "id_state")
	private WebElement state;
	
	@FindBy(id = "postcode")
	private WebElement postcode;
	
	@FindBy(id = "id_country")
	private WebElement country;
	
	@FindBy(id = "other")
	private WebElement additionalInformation;
	
	@FindBy(id = "phone_mobile")
	private WebElement mobilePhone;
	
	@FindBy(id = "phone")
	private WebElement homePhone;
	
	@FindBy(id = "alias")
	private WebElement alias;
	
	@FindBy(id = "submitAccount")
	private WebElement register;
	
	@FindBy(id = "submitAddress")
	private WebElement saveButton;
	
	@FindBy(xpath = "//a[@title='Addresses']")
	private WebElement myaddress;
	
	@FindBy(xpath = "//a[@title='Add an address']")
	private WebElement addNewAddress;

	public WebElement getMr() {
		return Mr;
	}

	public WebElement getMrs() {
		return Mrs;
	}

	public WebElement getCustomerFirstName() {
		return customerFirstName;
	}

	public WebElement getCustomerLastName() {
		return customerLastName;
	}

	public WebElement getE_Mail() {
		return e_Mail;
	}

	public WebElement getPassWord() {
		return passWord;
	}

	public WebElement getDate() {
		return date;
	}

	public WebElement getMonth() {
		return month;
	}

	public WebElement getYear() {
		return year;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getCompany() {
		return company;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getAddress2() {
		return address2;
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement getState() {
		return state;
	}

	public WebElement getPostcode() {
		return postcode;
	}

	public WebElement getCountry() {
		return country;
	}

	public WebElement getAdditionalInformation() {
		return additionalInformation;
	}

	public WebElement getMobilePhone() {
		return mobilePhone;
	}

	public WebElement getHomePhone() {
		return homePhone;
	}

	public WebElement getAlias() {
		return alias;
	}

	public WebElement getRegister() {
		return register;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getMyaddress() {
		return myaddress;
	}

	public WebElement getAddNewAddress() {
		return addNewAddress;
	}
}
