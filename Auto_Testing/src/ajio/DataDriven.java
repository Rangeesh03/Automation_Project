package ajio;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataDriven {
		
	
static FileInputStream fis;
static Workbook wb;

	/**
	 *Input Data  
	*/
public String Url()throws IOException ,EncryptedDocumentException{
	fis = new FileInputStream("./data/AJIO_Data.xlsx");
	wb=WorkbookFactory.create(fis);
	String Url = wb.getSheet("Sheet1").getRow(0).getCell(2).getStringCellValue();
	return Url;
}
public String Username()throws IOException ,EncryptedDocumentException{
	fis = new FileInputStream("./data/AJIO_Data.xlsx");
	wb=WorkbookFactory.create(fis);
	String Username = wb.getSheet("Sheet1").getRow(1).getCell(2).toString();
	return Username;
}	
public String Password()throws IOException ,EncryptedDocumentException{
	fis = new FileInputStream("./data/AJIO_Data.xlsx");
	wb=WorkbookFactory.create(fis);
	String Password = wb.getSheet("Sheet1").getRow(2).getCell(2).toString();
	return Password;
}	
public String Alphapets()throws IOException ,EncryptedDocumentException{
	fis = new FileInputStream("./data/AJIO_Data.xlsx");
	wb=WorkbookFactory.create(fis);
	String Alphapets = wb.getSheet("Sheet1").getRow(3).getCell(2).toString();
	return Alphapets;
}	
public String Numbers()throws IOException ,EncryptedDocumentException{
	fis = new FileInputStream("./data/AJIO_Data.xlsx");
	wb=WorkbookFactory.create(fis);
	String Numbers = wb.getSheet("Sheet1").getRow(4).getCell(2).toString();
	return Numbers;
}	
public String SpecialCharacters()throws IOException ,EncryptedDocumentException{
	fis = new FileInputStream("./data/AJIO_Data.xlsx");
	wb=WorkbookFactory.create(fis);
	String SpecialCharacters = wb.getSheet("Sheet1").getRow(5).getCell(2).toString();
	return SpecialCharacters;
}	
public String Alphanumeric()throws IOException ,EncryptedDocumentException{
	fis = new FileInputStream("./data/AJIO_Data.xlsx");
	wb=WorkbookFactory.create(fis);
	String Alphanumeric = wb.getSheet("Sheet1").getRow(6).getCell(2).toString();
	return Alphanumeric;
}	
public String MultipleString()throws IOException ,EncryptedDocumentException{
	fis = new FileInputStream("./data/AJIO_Data.xlsx");
	wb=WorkbookFactory.create(fis);
	String MultipleString = wb.getSheet("Sheet1").getRow(7).getCell(2).toString();
	return MultipleString;
}	
public String Blank()throws IOException ,EncryptedDocumentException{
	fis = new FileInputStream("./data/AJIO_Data.xlsx");
	wb=WorkbookFactory.create(fis);
	String Blank = wb.getSheet("Sheet1").getRow(8).getCell(2).toString();
	return Blank;
}	
public String LowerCase()throws IOException ,EncryptedDocumentException{
	fis = new FileInputStream("./data/AJIO_Data.xlsx");
	wb=WorkbookFactory.create(fis);
	String LowerCase = wb.getSheet("Sheet1").getRow(9).getCell(2).toString();
	return LowerCase;
}	
public String Upper_LowerCase()throws IOException ,EncryptedDocumentException{
	fis = new FileInputStream("./data/AJIO_Data.xlsx");
	wb=WorkbookFactory.create(fis);
	String Upper_LowerCase = wb.getSheet("Sheet1").getRow(10).getCell(2).toString();
	return Upper_LowerCase;
}	
public String PartialName()throws IOException ,EncryptedDocumentException{
	fis = new FileInputStream("./data/AJIO_Data.xlsx");
	wb=WorkbookFactory.create(fis);
	String PartialName = wb.getSheet("Sheet1").getRow(11).getCell(2).toString();
	return PartialName;
}	
public String BrandName()throws IOException ,EncryptedDocumentException{
	fis = new FileInputStream("./data/AJIO_Data.xlsx");
	wb=WorkbookFactory.create(fis);
	String BrandName = wb.getSheet("Sheet1").getRow(12).getCell(2).toString();
	return BrandName;
}
public String ProductName()throws IOException ,EncryptedDocumentException{
	fis = new FileInputStream("./data/AJIO_Data.xlsx");
	wb=WorkbookFactory.create(fis);
	String ProductName = wb.getSheet("Sheet1").getRow(13).getCell(2).toString();
	return ProductName;
}	

public String ProductDescription()throws IOException ,EncryptedDocumentException{
	fis = new FileInputStream("./data/AJIO_Data.xlsx");
	wb=WorkbookFactory.create(fis);
	String ProductDescription = wb.getSheet("Sheet1").getRow(14).getCell(2).toString();
	return ProductDescription;
}	
public String OtherProduct()throws IOException ,EncryptedDocumentException{
	fis = new FileInputStream("./data/AJIO_Data.xlsx");
	wb=WorkbookFactory.create(fis);
	String OtherProduct = wb.getSheet("Sheet1").getRow(15).getCell(2).toString();
	return OtherProduct;
}	

}
