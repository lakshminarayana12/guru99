package genric;

import java.io.FileInputStream;
import java.util.Properties;



import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Lib {
	
	//properties method
	public static String getproperty(String path, String url) {
		Properties p = new Properties();
		try {
		p.load(new FileInputStream(path) );
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		String propertiesvalue=p.getProperty(url);
		return propertiesvalue;
	}

	//get row count from excel
	public static int getRowCount (String excelpath, String sheet) {
		int rc=0;
	try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(excelpath));
			rc=wb.getSheet(sheet).getLastRowNum();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
		return rc;
		
	}
	
	//get cell data
	public static String getCellvalue(String excelpath, String sheet, int row, int col) {
		String value="";
		try {
			
			Workbook wb = WorkbookFactory.create(new FileInputStream(excelpath));
			
			value= wb.getSheet(sheet).getRow(row).getCell(col).getStringCellValue();
		}
		catch(Exception e) {
			e.getMessage();
		}
		
		return value;
	}
	
}
