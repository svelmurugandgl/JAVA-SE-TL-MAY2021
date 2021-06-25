package testutils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetExcelData {

	@SuppressWarnings("resource")
	public static Object[][] getExcelItems(String fileName) throws IOException {
		XSSFWorkbook wb = new XSSFWorkbook("./data/" + fileName + ".xlsx");
		XSSFSheet ws = wb.getSheet("sheet1");
		int row = ws.getLastRowNum();
		int col = ws.getRow(0).getLastCellNum();
		String excelData[][] = new String[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col ; j++) {
				excelData[i][j] = ws.getRow(i + 1).getCell(j).getStringCellValue();
			}

		}

		return excelData;

	}

}
