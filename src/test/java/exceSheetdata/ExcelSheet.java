package exceSheetdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelSheet {
	static FileInputStream fis;
	static Workbook wb;
	static Sheet sheet;
	static Row row;
	static Object[][] datas;
	static String value;
	
	public static Object[][] User_Details(String fileName, String sheetName) throws IOException {
		File f = new File("./src/test/java/excelSheet/"+fileName);
		String[] split = fileName.split("\\.");
		fis = new FileInputStream(f);
		if(split[1].equals("xlsx"))
			wb = new XSSFWorkbook(fis);
		else if(split[1].equals("xls"))
			wb = new HSSFWorkbook(fis);
		
		sheet = wb.getSheet(sheetName);
		
		int noOfRows = sheet.getLastRowNum()+1;
		int noOfColumns = sheet.getRow(0).getLastCellNum();
		
		datas = new Object[noOfRows][noOfColumns];
		System.out.println("Total NoOf Rows:"+noOfRows);
		System.out.println("Total NoOf Columns:"+noOfColumns);
		for(int i=1;i<noOfRows;i++) {
			row = sheet.getRow(i);
			for (int j = 1; j <noOfColumns; j++) {
				Cell cell = row.getCell(j);
				CellType cellType = cell.getCellType();
				if(cellType.equals(CellType.STRING))
					value = cell.getStringCellValue();
				else if(cellType.equals(CellType.NUMERIC)) {
					int numericCellValue = (int) cell.getNumericCellValue();
					value = String.valueOf(numericCellValue);
				}
					
				datas[i-1][j-1] = value;
				
				//System.out.print(datas[i-1][j-1]+" ");
			}
			//System.out.println();
		}
		
		return datas;
	}
}
