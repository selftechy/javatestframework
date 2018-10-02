package nl.prowareness.automation.dao.model;

import java.util.List;
import java.util.Map;


public class ExcelData {
	
	private String fileName;
	private Integer noOfSheets;
	private List<ExcelSheet>sheetData;
	private Map<String,ExcelSheet>sheetDataByName;
	

	public ExcelData() {
		
	}

	public ExcelData(String excelfileName) {
		this.fileName = excelfileName;
	}
	
	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Integer getNoOfSheets() {
		return noOfSheets;
	}


	public void setNoOfSheets(Integer noOfSheets) {
		this.noOfSheets = noOfSheets;
	}



	public List<ExcelSheet> getSheetData() {
		return sheetData;
	}


	public void setSheetData(List<ExcelSheet> sheetData) {
		this.sheetData = sheetData;
	}

	
	public Map<String, ExcelSheet> getSheetDataByName() {
		return sheetDataByName;
	}

	public void setSheetDataByName(Map<String, ExcelSheet> sheetDataByName) {
		this.sheetDataByName = sheetDataByName;
	}



	public class ExcelSheet{

		private String sheetName;
		private List<Map<Integer,String>>rowData;
		
		public String getSheetName() {
			return sheetName;
		}
		
		public void setSheetName(String sheetName) {
			this.sheetName = sheetName;
		}
		
		public List<Map<Integer, String>> getRowData() {
			return rowData;
		}
		
		public void setRowData(List<Map<Integer, String>> rowData) {
			this.rowData = rowData;
		}
		
		
		
	}

}
