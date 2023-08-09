package com.misc.unsorted;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;

public class ExcelTools {
	
	private final Sheet sheet;
	private final int numberOfRows;

    public ExcelTools(String pathToExcelFile) throws IOException, EncryptedDocumentException {
	    try(FileInputStream input = new FileInputStream(pathToExcelFile);
	    	Workbook wb = WorkbookFactory.create(input)) {
	    	sheet = wb.getSheetAt(0);
	    	numberOfRows = sheet.getLastRowNum();
	    }
	}
	
	// http://poi.apache.org/spreadsheet/quick-guide.html#ReadWriteWorkbook
	// Another example of code : http://stackoverflow.com/questions/1516144/how-to-read-and-write-excel-file-in-java

    public static void basicExcelReader(String pathToExcelFile) {
		InputStream inp;
		int totalRows;
		Workbook wb;
		Sheet sheet;
		Row row;
		
		try {
            inp = Files.newInputStream(Paths.get(pathToExcelFile));
			wb = WorkbookFactory.create(inp);
			sheet = wb.getSheetAt(0);
			totalRows = sheet.getLastRowNum();
			for(int i=1;  i<10 && i<=totalRows; i++){
				row = sheet.getRow(i);
				if(null!=row){
					System.out.println(row.getCell(0).getStringCellValue() + " | " + row.getCell(1).getStringCellValue());
				}
			}
        } catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
        }
    }

	public String searchForValue(String value){
		String result="";
		Row row;
		int i=1;
		
		while(result.isEmpty() && i<numberOfRows){
			row = sheet.getRow(i);
			if(null!=row && value.equals(row.getCell(0).getStringCellValue())){
				result = row.getCell(1).getStringCellValue();
			}
			i++;
		}
		return result;
	}
	
	public Map<String, String> getTreeMap(){
		Map<String, String> tm = new TreeMap<String, String>();
		int lastRowNum = sheet.getLastRowNum();
		Row row = null;
		for(int i=2; i<lastRowNum;i++){
			row = sheet.getRow(i);
			tm.put(row.getCell(0).getStringCellValue(), row.getCell(1).getStringCellValue());
		}
		return tm;
	}
	
	
}
