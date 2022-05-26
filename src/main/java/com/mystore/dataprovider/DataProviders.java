package com.mystore.dataprovider;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.mystore.utility.NewExcelLibrary;

public class DataProviders {
	NewExcelLibrary obj = new NewExcelLibrary();

	@DataProvider(name="credentials")
	public Object[][] getCredentials(){
	
	int rows=obj.getRowCount("Credentials");
	int column=obj.getColumnCount("Credentials");
	int actRows = rows - 1;
	Object[][] data =new Object[actRows][column];
	for(int i=0;i<actRows;i++) {
		for(int j=0;j<column;j++) {
			data[i][j]=obj.getCellData("Credentials", j, i+2);
		}
	}
	return data;
}
	@DataProvider(name = "email")
	public Object[][] getEmail() {
		// Totals rows count
		int rows = obj.getRowCount("Email");
		// Total Columns
		int column = obj.getColumnCount("Email");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("Email", j, i + 2);
			}
		}
		return data;
	}
	@DataProvider(name = "getProduct")
	public Object[][] getProduct() {
		// Totals rows count
		int rows = obj.getRowCount("ProductDetails");
		// Total Columns
		int column = obj.getColumnCount("ProductDetails");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("ProductDetails", j, i + 2);
			}
		}
		return data;
	}

	// Class --> SearchResultPageTest, Test Case--> productAvailabilityTest
	@DataProvider(name = "searchProduct")
	public Object[][] getProductPrice() {
		// Totals rows count
		int rows = obj.getRowCount("SearchProduct");
		// Total Columns
		int column = obj.getColumnCount("SearchProduct");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("SearchProduct", j, i + 2);
			}
		}
		return data;
	}
	@DataProvider(name = "newAcountDetailsData")
	public Object[][] accountCreation() {
		Object[][] data = new Object[1][1];
		/*int rows = obj.getRowCount("AccountCreationData");
		int column = obj.getColumnCount("AccountCreationData");
		int actRows = rows - 1;
		Object[][] data = new Object[actRows][1];
		for (int i = 0; i < actRows; i++) {
			Map<String, String> hashMap = new HashMap<>();
			for (int j = 0; j < column; j++) {
				hashMap.put(obj.getCellData("AccountCreationData", j, 1), 
						obj.getCellData("AccountCreationData", j, i+2));
			}
			data[i][0]=hashMap;
		}*/
		Map<String, String> hashMap = new HashMap<>();
		hashMap.put("Email", "gundunai@gmail.com");
		hashMap.put("Gender", "Mrs");
		hashMap.put("FirstName", "TestUser");
		hashMap.put("LastName","UserTest");
		hashMap.put("SetPassword","hgsdtyf");
		hashMap.put("Day", "27");
		hashMap.put("Month", "5");
		hashMap.put("Year", "1990");
		hashMap.put("Company", "abc");
		hashMap.put("Address", "chn");
		hashMap.put("City", "San");
		hashMap.put("State", "Alabama");
		hashMap.put("Zipcode", "91436");
		hashMap.put("Country", "United States");
		hashMap.put("MobilePhone", "12345");
		data[0][0]=hashMap;
		return data;
	}
}
