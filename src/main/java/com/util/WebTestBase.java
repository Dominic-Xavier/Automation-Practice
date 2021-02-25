package com.util;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class WebTestBase {
	public static WebDriver driver;
	private static Wait<WebDriver> wait;
	private static JavascriptExecutor js;
	private static Actions mouse;
	public static void browserLaunch(String browserName) {
		
		switch (browserName.toLowerCase()) {
		
		case "chrome":{
			System.setProperty("webdriver.chrome.driver", "./src/test/java/browserDriver/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		}
		
		case "firefox":{
			System.setProperty("webdriver.gecko.driver", "./src/test/java/browserDriver/geckodriver.exe");
			driver = new ChromeDriver();
			break;
		}
		
		case "internetexplorer":{
			System.setProperty("webdriver.ie.driver", "./src/test/java/browserDriver/IEDriverServer.exe");
			driver = new ChromeDriver();
			break;
		}
		
		default:
			System.err.println("Invalid browser name");
			break;
		}
		
		driver.manage().window().maximize();
	}
	
	public static void passURL(String url) {
		driver.get(url);
	}
	
	public static void implicitwait(int SECONDS) {
		driver.manage().timeouts().implicitlyWait(SECONDS, TimeUnit.SECONDS);
	}
	
	public static void explicitWait(WebDriver driver, WebElement element,int SECONDS) {
		wait = new WebDriverWait(driver, SECONDS);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void fluentWait(final WebElement element,int SECONDS, int pollEvery) {
		wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(SECONDS))
				.pollingEvery(Duration.ofSeconds(pollEvery))
				.ignoring(NoSuchElementException.class);
		WebElement ele = wait.until((drivers)-> {
				return element;
		});
		ele.click();
	}
	
	public static void javaScriptMethods(String script, WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript(script, element);
	}
	
	public static void javaScriptMethods(String script) {
		js = (JavascriptExecutor) driver;
		js.executeScript(script);
	}
	
	public static void screenShot(String FileName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs, new File("./ScreenShot/"+FileName+".png"));
	}
	
	public static void scroll(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public static void click(WebElement element) {
		element.click();
	}
	
	public static void clear(WebElement element) {
		element.clear();
	}
	
	public static void sendKeys(WebElement element, String keysToSend) {
		element.sendKeys(keysToSend);
	}
	
	public static void mouseOver(WebElement element) {
		mouse = new Actions(driver);
		mouse.moveToElement(element).build().perform();
	}
	
	public static void fullScreenShot(String fileName) throws IOException {
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		ImageIO.write(screenshot.getImage(), "PNG", new File("./ScreenShot/"+fileName+".png"));
	}
	
	public static void pageLoadTimeOut(int Seconds) {
		driver.manage().timeouts().pageLoadTimeout(Seconds, TimeUnit.SECONDS);
	}
	
	public static void closeWindow() {
		driver.close();
	}
	
	public static void closeBrowser() {
		driver.quit();
	}
}
