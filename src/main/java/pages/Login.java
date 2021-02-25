package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.util.WebTestBase;

public class Login extends WebTestBase {
	
	public Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Sign in")
	private WebElement signIn;
	
	@FindBy(how = How.NAME, using="email")
	private WebElement emailId;
	
	@FindBy(id = "passwd")
	private WebElement passWord;
	
	@FindBy(id = "Forgot your password?")
	private WebElement forgotPassWrod;
	
	@FindBy(id = "SubmitLogin")
	private WebElement loginButton;

	@FindBy(linkText = "Sign out")
	private WebElement logOut;
	
	@FindBy(xpath = "//a[@title='View my customer account']")
	private WebElement myAccount;
	
	public WebElement getSignIn() {
		return signIn;
	}

	public WebElement getEmailId() {
		return emailId;
	}

	public WebElement getPassWord() {
		return passWord;
	}

	public WebElement getForgotPassWrod() {
		return forgotPassWrod;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getLogOut() {
		return logOut;
	}
	
	public WebElement getMyAccount() {
		return myAccount;
	}
}
