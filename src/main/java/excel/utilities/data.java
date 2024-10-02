package excel.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class data {

	public String fetchingData(String parameter) throws IOException {
		String value = "";
		FileInputStream fp = new FileInputStream(
				"C:\\Users\\U1133463\\eclipse-workspace\\FrameWorkP\\TestInput\\data.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fp);
		XSSFSheet sheet;
		if (parameter == "username" || parameter == "password") {
			sheet = wb.getSheet("Sheet1");
		} else {
			System.out.println("product sheet fetched");
			sheet=wb.getSheet("Sheet2");
		}
		Row r = sheet.getRow(0);
		int valueCol = -1;
		for (Cell c : r) {
			
			if (c.getStringCellValue().equalsIgnoreCase(parameter)) {
				valueCol = c.getColumnIndex();
				System.out.println(valueCol);
			}
		}
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i);

			// Get the username and password from the row
			value = getCellValueAsString(row.getCell(valueCol));
			System.out.println(value);

		}
		System.out.println(value);

		return value;
	}

	private static String getCellValueAsString(Cell cell) {
		if (cell == null) {
			return "";
		}
		if (cell.getCellType() == CellType.STRING) {
			return cell.getStringCellValue();
		} else if (cell.getCellType() == CellType.NUMERIC) {
			return String.valueOf(cell.getNumericCellValue());
		} else if (cell.getCellType() == CellType.BOOLEAN) {
			return String.valueOf(cell.getBooleanCellValue());
		} else {
			return "";
		}
	}

}
