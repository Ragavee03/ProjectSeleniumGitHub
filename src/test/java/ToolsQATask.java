import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ToolsQATask extends BaseClass{

	public static void main(String[] args) throws IOException {

launchURL();
maximize();
delCookies();
openBrowser("https://www.toolsqa.com/automation-practice-form/");
getTiltle();

WebElement fname = driver.findElement(By.xpath("//input[@name='firstname']"));
fillDetails(fname, xcelInput(1, 0));


WebElement lname = driver.findElement(By.xpath("//input[@id='lastname']"));
fillDetails(lname, xcelInput(1, 1));


WebElement dateEnter = driver.findElement(By.xpath("//input[@id='datepicker']"));
fillDetails(dateEnter, xcelInput(1, 2));

WebElement drp1 = driver.findElement(By.xpath("//select[@id='continents']"));
dropDown(drp1);

driver.findElement(By.xpath("//option[text()='Australia'][1]"));
singleSelect("Australia");


WebElement drp2 = driver.findElement(By.xpath("//select[@id='continentsmultiple']"));
dropDown(drp2);
driver.findElement(By.xpath("//option[text()='Australia'][1]"));
singleSelect("South America");




//WebElement onClick = driver.findElement(By.xpath("//button[@id='submit1']"));
//click(onClick);




	}

}
