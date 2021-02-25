package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.util.WebTestBase;

public class Register extends WebTestBase {
	
	public Register(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.CLASS_NAME, using = "account")
	private WebElement account;
	
	@FindBy(xpath = "//input[@id='email_create']")
	private WebElement createAccountEmailAddress;
	
	@FindBy(id = "SubmitCreate")
	private WebElement createAccountButton;
	
	@FindBy(linkText = "Sign out")
	private WebElement signOut;

	public WebElement getSignOut() {
		return signOut;
	}

	public WebElement getAccount() {
		return account;
	}

	public WebElement getCreateAccountEmailAddress() {
		return createAccountEmailAddress;
	}

	public WebElement getCreateAccountButton() {
		return createAccountButton;
	}
}
