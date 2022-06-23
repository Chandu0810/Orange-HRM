package ABC_DataProvider2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ExcelUtil.ExcelApiTest4;

public class TC01_Add_jobs4_Methods_Prameters {
	
	WebDriver driver;
	
	//Declaration - Step1 - Declare Global Variables
	//String TestURL="https://opensource-demo.orangehrmlive.com/";
	//String username="Admin",password="admin123";
	//String JobTitle="Sales8",JobDescr="Sales8 descr",JobNote="Sales8 Note"	;
	
	 @DataProvider(name = "Orange12")
	 public Object[] myDataProvider66() {
	      
	     Object data[][]=  new Object[3][6];
	     
	     // First student details
	     data[0][0]= "https://opensource-demo.orangehrmlive.com/"; 
	     data[0][1]= "Admin";
	     data[0][2]= "admin123";
	     data[0][3]= "Sales15";
	     data[0][4]= "Sales15 descr";
	     data[0][5]= "Sales15 Note";
	      
	     // Second student details
	     data[1][0]= "https://opensource-demo.orangehrmlive.com/"; 
	     data[1][1]= "Admin";
	     data[1][2]= "admin123";
	     data[1][3]= "Sales16";
	     data[1][4]= "Sales16 descr";
	     data[1][5]= "Sales16 Note";
	     
	     // Second student details
	     data[2][0]= "https://opensource-demo.orangehrmlive.com/"; 
	     data[2][1]= "Admin";
	     data[2][2]= "admin123";
	     data[2][3]= "Sales17";
	     data[2][4]= "Sales17 descr";
	     data[2][5]= "Sales17 Note";
	     
	     
	     
	     return data;
	      
	 }
	 
	 @DataProvider(name = "Orange14")
	  public static Object[][] Test1() throws Exception {
	 
	        return new Object[][] { 
	        	
	        	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","Sales18","Salaes18 descr","Sales18 Note" },
	        	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","Sales19","Salaes19 descr","Sales19 Note" },
	        	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","Sales20","Salaes20 descr","Sales20 Note" }
	        	};
	  }
	

	 
	 
	 
	 @DataProvider(name = "Orange17")
		public static Object[][] Authentication1() throws Exception {
			
			ExcelApiTest4 eat = new ExcelApiTest4();
			Object[][] testObjArray = eat.getTableArray("C://HTML Report//OrangeHRM6//TC01_Jobs124.xlsx", "Sheet1");
			
			
			System.out.println(testObjArray.length);
			return (testObjArray);
		}
	 
	
  @Test(dataProvider="Orange17")  //Step2
  public void JobsTest(String TestURL,String username,String password,
		  String JobTitle,String JobDescr,String  JobNote) throws Exception {  //Step3
	  
	  TC01_Add_jobs4_Methods_Prameters T1= new TC01_Add_jobs4_Methods_Prameters();
	  
	  T1.OpenChromeBrowser();
	  T1.OpenOrangeHRM(TestURL);  //Step2 - Pass Global Variable to the main Test methods
	  T1.Login(username,password);//Step2 - Pass Global Variable to the main Test methods
	  T1.AddJobs(JobTitle,JobDescr,JobNote);//Step2 - Pass Global Variable to the main Test methods
		
		
  }
  
  
  
  
  public void OpenChromeBrowser() throws Exception {
	 
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;
	  
  }
  
  
  public void OpenOrangeHRM(String TestURL1) throws Exception {
	  
		driver.get(TestURL1);
  }
  
  public void Login(String username1,String password1) throws Exception {
	  
		findElement(By.id("txtUsername")).sendKeys(username1);
		findElement(By.id("txtPassword")).sendKeys(password1);
		findElement(By.id("btnLogin")).click();	
  }
  
  
  public void AddJobs(String JobTitle1,String JobDescr1,String JobNote1) throws Exception {
	  
		findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_Job")).click();
		findElement(By.id("menu_admin_viewJobTitleList")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("jobTitle_jobTitle")).sendKeys(JobTitle1);
		findElement(By.id("jobTitle_jobDescription")).sendKeys(JobDescr1);
		findElement(By.id("jobTitle_note")).sendKeys(JobNote1);
		findElement(By.id("btnSave")).click();
  }
  
  
  public  WebElement findElement(By by) throws Exception 
	{

		WebElement elem = driver.findElement(by);  
		
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		return elem;
	}
  
  
  
  
  
  
  
  
  
}
