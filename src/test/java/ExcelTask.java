import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTask {

	public static void main(String[] args) throws IOException {
		// To identify File location
File loc= new File ("C:\\Users\\User\\eclipse-workspace\\DataDrivenTasks\\TestData\\TestDataDemo.xlsx");

//create object
FileInputStream stream = new FileInputStream(loc);

//create workbook

Workbook w = new XSSFWorkbook(stream);

//Read sheet of the workbook

Sheet s = w.getSheet("Sheet1");
System.out.println(s.getPhysicalNumberOfRows());

//Read rows and cells in that sheet

		
		 for (int i = 0; i < s.getPhysicalNumberOfRows(); i++) { Row r = s.getRow(i);
		  
		  System.out.println(i);
		  
		  for (int j = 0; j < r.getPhysicalNumberOfCells(); j++) { Cell c =
		  r.getCell(j); System.out.println(c); }
		 
		  }
		 

	}

}
