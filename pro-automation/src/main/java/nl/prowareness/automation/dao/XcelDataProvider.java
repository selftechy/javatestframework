package nl.prowareness.automation.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import nl.prowareness.automation.dao.model.ExcelData;
import nl.prowareness.automation.dao.model.ExcelData.ExcelSheet;
import nl.prowareness.automation.selenium.exceptions.AutomationDataException;

@Component
public class XcelDataProvider {


	FileInputStream file = null;
	String xlSheetTobeRead = null;

	private static final String XCEL_DATA_FILE_PATH="xceldata.path";

	private static final Logger LOGGER = Logger.getLogger(XcelDataProvider.class);

	@Autowired
	public XcelDataProvider(Environment prop) throws AutomationDataException{

		try {
			this.file = new FileInputStream(new File(prop.getProperty(XCEL_DATA_FILE_PATH)));
		} catch (FileNotFoundException e) {
			LOGGER.error("FileNotFoundException: "+e);
			throw new AutomationDataException("Please check the data file path: "+e.getMessage());
		}
	}
	
	
	public ExcelData getData() throws AutomationDataException {
		ExcelData xlData =  new ExcelData(XCEL_DATA_FILE_PATH);
		List<ExcelSheet>sheetData = new ArrayList<ExcelSheet>();
		Map<String,ExcelSheet>sheetDataByName = new HashMap<String,ExcelSheet>();
		ExcelSheet xlSheet = null;
		Map<Integer,String>columnData = null;
		List<Map<Integer,String>>rowData = null;
		Integer colIndex = 0;
        
		// Create a DataFormatter to format and get each cell's value as String
        DataFormatter dataFormatter = new DataFormatter();
        
		try {
			Workbook workbook = WorkbookFactory.create(this.file);
			xlData.setNoOfSheets(workbook.getNumberOfSheets());
			
			Iterator<Sheet> sheetIterator = workbook.sheetIterator();
			
	        while (sheetIterator.hasNext()) {
	            Sheet sheet = sheetIterator.next();
	            xlSheet = xlData.new ExcelSheet();
	            xlSheet.setSheetName(sheet.getSheetName());
	            rowData = new ArrayList<Map<Integer,String>>();
	            
	            Iterator<Row> rowIterator = sheet.rowIterator();
	            
	            //Iterate over each row of the excel sheet
	            while (rowIterator.hasNext()) {
	                Row row = rowIterator.next();
	                colIndex = 0;
	                columnData = new HashMap<Integer,String>();

	                Iterator<Cell> cellIterator = row.cellIterator();

	                //Iterating over each row data
	                while (cellIterator.hasNext()) {
	                    Cell cell = cellIterator.next();
	                    String cellValue = dataFormatter.formatCellValue(cell);
	                    columnData.put(colIndex, cellValue);
	                    colIndex++;
	                }
	                
                    rowData.add(columnData);
	            }
	            
	            //Adding row data to sheet
	            xlSheet.setRowData(rowData);
	            sheetData.add(xlSheet);
	            sheetDataByName.put(xlSheet.getSheetName(), xlSheet);
	            
	        }
	        
	        
			
		} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
			LOGGER.error("Could not read excel data file: "+e);
			throw new AutomationDataException("Check file format: "+e.getMessage());
		}
		

		
		
		return xlData;
	}

/**
 * 
 * Things to done:
 * 1. Excel data provider - provide data in table format - for user - give sheet name or sheet number starting from 0 and 
 * then he should get all the rows & columns data 
 * 2. Data from database - get help from TAF
 * 3. Integrate RestAssure - https://mvnrepository.com/artifact/io.rest-assured/rest-assured/3.0.0
 *  http://rest-assured.io/
 * 4. Separate cucumber & TestNG 
 * http://testng.org/doc/maven.html
 * https://mvnrepository.com/artifact/org.testng/testng
 * 
 * 
 */


}
