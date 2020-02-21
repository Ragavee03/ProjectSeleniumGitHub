import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Snapdeal  extends BaseClass{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launchURL();
		maximize();
		delCookies();
		openBrowser("https://www.snapdeal.com/");
		getTiltle();

		WebElement btnClick = driver.findElement(By.xpath("//input[@id='inputValEnter']"));
		click(btnClick);
		fillDetails(btnClick, "iphone");
		
		WebElement btnSearch = driver.findElement(By.xpath("//span[text()='Search']"));
		click(btnSearch);
		
		List<WebElement> options = driver.findElements(By.xpath("//p[@class='product-title']"));
		
		/*
		 * for (WebElement text : options) { System.out.println(text.getText()); }
		 */
		 
		
		  for (int i = 0; i < options.size(); i++) { WebElement text =options.get(i);
		  System.out.println(text.getText());
		  
		  System.out.println("Creating conflict in git and try");
		  }
		 
		
	}

}
