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

public class ExcelCellType {

	public static void main(String[] args) throws IOException {
		
		// To identify File location
		File loc= new File ("C:\\Users\\User\\eclipse-workspace\\DataDrivenTasks\\TestData\\TestDataDemo.xlsx");

		//create object
		FileInputStream stream = new FileInputStream(loc);

		//create workbook

		Workbook w = new XSSFWorkbook(stream);

		//Read sheet of the workbook

		Sheet s = w.getSheet("Sheet1");
		Row r = s.getRow(1);
		Cell c = r.getCell(10);
		
		//To find cell type
		int cellType = c.getCellType();
		System.out.println(cellType);
		
		//if string
		if (cellType==1) {
			String stringCellValue = c.getStringCellValue();
			System.out.println(stringCellValue);
		}
		else if (cellType==0) {
			if(DateUtil.isCellDateFormatted(c))
			{
				Date dateCellValue = c.getDateCellValue();
			SimpleDateFormat sd= new SimpleDateFormat("MM/dd/yyyy");
			System.out.println (sd.format(dateCellValue));
			}
			else 
			{
				double numericCellValue = c.getNumericCellValue();
				long l= (long) numericCellValue;
				System.out.println(String.valueOf(l));
				
			}
		}
		
	}

}
