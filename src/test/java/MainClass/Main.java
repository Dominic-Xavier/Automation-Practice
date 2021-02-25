package MainClass;

import java.io.IOException;
import java.util.Properties;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.properties.BrowserLaunch;
import com.util.WebTestBase;
import exceSheetdata.ExcelSheet;
import operation.OperationMethods;

public class Main extends OperationMethods {
	
	static ExtentHtmlReporter html;
	static ExtentReports report;
	static ExtentTest tests;
	static Properties data;
	
	@BeforeClass
	public void setUpReport() throws IOException {
		
		data = BrowserLaunch.readPropertiesFile("application");
		String BrowserName = data.getProperty("BrowserName");
		String URL = data.getProperty("url");
		WebTestBase.browserLaunch(BrowserName);
		WebTestBase.passURL(URL);
		WebTestBase.pageLoadTimeOut(10);
		
		html = new ExtentHtmlReporter("./target/extentReports/extent.html");
		html.config().setEncoding("UTF-8");
		html.config().setDocumentTitle("Automation Practice");
		html.config().setReportName("Order Details");
		html.config().setTheme(Theme.STANDARD);
		
		report = new ExtentReports();
		report.setSystemInfo("Company", "Zoho Corp");
		report.setSystemInfo("Browser", "Chrome");
		report.attachReporter(html);
	}
	
	//@AfterClass
	public void tearDownReport(ITestResult result) throws Exception {
		String methodName = result.getMethod().getMethodName();
		System.out.println("Mothod Name is:"+methodName);
		if(result.getStatus() == ITestResult.SUCCESS) {
			try {
				MediaEntityBuilder.createScreenCaptureFromPath("./ScreenShot").build();
			} catch (IOException e) {
				System.err.println("Unable to attach ScreenShot"+e.getMessage());
			}
		}
		
		String log = "<br> Successfully Added";
		Markup createLabel = MarkupHelper.createLabel(log, ExtentColor.GREEN);
		tests.log(Status.PASS, createLabel);
		
	}
	
	
	
	@DataProvider(name = "userDetails")
	private Object[][] userDetails() throws IOException {
		Object[][] datas = ExcelSheet.User_Details("SampleData.xlsx", "User Details");
		return datas;
	}
	
	@DataProvider(name = "OrderDetails")
	private Object[][] order_Details() throws IOException {
		Object[][] datas = ExcelSheet.User_Details("SampleData.xlsx", "Order Details");
		return datas;
	}
	
	@Test(priority = 1, enabled = true)
	private void login() throws IOException {
		String emailId = data.getProperty("email"); 
		String passWord = data.getProperty("password");
		login(emailId, passWord);
		tests = report.createTest("Login Scenario", "Username is valid");
		tests.log(Status.PASS, "Login Scenario Passed");
	}
	
	@Test(dataProvider = "userDetails", priority = 2, enabled = true, dependsOnMethods = {"login"})
	private void addAddress(String firstname, String last_name, String company, String address,String city,String state,String zip_code,
			String country,String mobileNo, String address_title, String a) {
		if(firstname!=null) {
			addAddress(firstname, last_name, company, address, city, state, zip_code, country, mobileNo, address_title);
			tests.log(Status.PASS, "Address Added");
		}
	}
	
	@Test(dataProvider = "OrderDetails" ,priority = 3, dependsOnMethods = {"login"})
	private void category(String mainCategory, String subCategory, String quantity, String size, String color, String b) {
		if(mainCategory!=null) {
			category(mainCategory, subCategory);
			selectDress(quantity, size, color);
			proceedToCheckOut();
			tests.log(Status.PASS, "Proceed to checkout is Passed");
		}
	}
	
	@Test(priority = 4, dependsOnMethods = {"login"})
	public void ordersList() throws IOException {
		orderList();
		logOut();
		WebTestBase.closeBrowser();
		tests.log(Status.PASS, "Taken Screen Shot and Logged off successfully");
		report.flush();
	}
}