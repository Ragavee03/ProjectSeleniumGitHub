import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {

	static WebDriver driver;

	public static void launchURL() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\User\\eclipse-workspace\\DataDrivenTasks\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	public static void maximize() {
		driver.manage().window().maximize();

	}

	public static void delCookies() {
		driver.manage().deleteAllCookies();

	}

	public static void openBrowser(String Value) {
		driver.get(Value);

	}

	public static void getTiltle() {
		System.out.println(driver.getTitle());

	}
	
	public static void fillDetails(WebElement ele, String input) {
		ele.sendKeys(input);
	}
	
	public static void click(WebElement ele) {
		ele.click();
	}
	
	static Select s;
	public static void dropDown(WebElement ele) {
		s= new Select(ele);
		boolean multiple = s.isMultiple();
	System.out.println(multiple);	
	}
	
		public static void singleSelect(String option) {
			s.selectByVisibleText(option);
		}
		
	public static String xcelInput(int rowname, int cellname) throws IOException {

		// To identify File location
		File loc = new File("C:\\Users\\User\\eclipse-workspace\\DataDrivenTasks\\TestData\\ToolsQaTestdata.xlsx");

		// create object
		FileInputStream stream = new FileInputStream(loc);

		// create workbook

		Workbook w = new XSSFWorkbook(stream);

		// Read sheet of the workbook

		Sheet s = w.getSheet("Sheet1");
		Row r = s.getRow(rowname);
		Cell c = r.getCell(cellname);

		// To find cell type
		int cellType = c.getCellType();
		System.out.println(cellType);

		String strVal = null;

		// if string
		if (cellType == 1) {
			strVal = c.getStringCellValue();
			System.out.println(strVal);
		} else if (cellType == 0) {
			if (DateUtil.isCellDateFormatted(c)) {
				Date dateCellValue = c.getDateCellValue();
				SimpleDateFormat sd = new SimpleDateFormat("MM/dd/yyyy");
				strVal = sd.format(dateCellValue);
				System.out.println(strVal);
			} else {
				double numericCellValue = c.getNumericCellValue();
				long l = (long) numericCellValue;
				strVal = String.valueOf(l);
				System.out.println(strVal);

			}

		}
		return strVal;
	}
	
	
}
