package seleniumpoc.pages;

import utils.ExcelReader;

public class TestExcelReading {
	
	public static void main(String[] args) {
		
		ExcelReader reader = new ExcelReader("D:\\workspace\\SeleniumFramework2024\\seleniumpoc\\data.xlsx");
		System.out.println(reader.getRowCount("Sheet1"));
		
	}

}
