package Resources;

import org.testng.annotations.DataProvider;

public class TestData {
	@DataProvider(name="InputData")
	public Object[][] getData()
	{
		Object[][] data=new Object[1][2];
		//0th row

		data[0][0]="anasssattis@gmail.com";
		data[0][1]="Anass";
		return data;
	}	

}
