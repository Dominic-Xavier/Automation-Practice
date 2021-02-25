package demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.util.WebTestBase;

import exceSheetdata.ExcelSheet;

public class TestPrograms extends ExcelSheet {

	public static void main(String[] args) throws IOException {
		Object[][] user_Details = ExcelSheet.User_Details("SampleData.xlsx", "Order Details");
		  for (int i = 0; i < 1; i++) { 
			  for (int j = 0; j < 5; j++) {
				  System.out.print(user_Details[i][j]+" "); 
			  } 
			  System.out.println(); 
		  }
	}
}
