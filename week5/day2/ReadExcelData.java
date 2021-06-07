package week5.day2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

	@SuppressWarnings("resource")
	public String[][] getExcelData(String fileName, int tillColumn) throws IOException {
		XSSFWorkbook wb = new XSSFWorkbook("./data/" + fileName + ".xlsx");
		XSSFSheet ws = wb.getSheet("Sheet1");
		int row = ws.getLastRowNum();
		int col = ws.getRow(0).getLastCellNum();
		String excelData[][] = new String[row][col - tillColumn];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col - tillColumn; j++) {
				excelData[i][j] = ws.getRow(i + 1).getCell(j).getStringCellValue();
			}

		}

		return excelData;

	}

}
