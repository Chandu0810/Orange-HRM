package ABC_DataProvider2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ExcelUtil.ExcelApiTest4;


public class TC01_Add_Skills {
	
	WebDriver driver;
	
	//Step1 - Declare global variables
	//String TestURL="https://opensource-demo.orangehrmlive.com/";
	//String username="Admin" , password="admin123";
	//String skillname ="Java14" , skilldescr="Java14 descr";
	
	
	//Step1
	 @DataProvider(name = "Orange13")
	 public Object[] myDataProvider66() {
	      
	     Object data[][]=  new Object[2][5];
	     
	     // First student details
	     data[0][0]= "https://opensource-demo.orangehrmlive.com/"; 
	     data[0][1]= "Admin";
	     data[0][2]= "admin123";
	     data[0][3]= "Java12";
	     data[0][4]= "Java12 descr";
	
	      
	     // Second student details
	     data[1][0]= "https://opensource-demo.orangehrmlive.com/"; 
	     data[1][1]= "Admin";
	     data[1][2]= "admin123";
	     data[1][3]= "Java13";
	     data[1][4]= "Java13 descr";
	     
	     return data;
	      
	 }
	
	
	 
	 
	 @DataProvider(name = "Orange14")
	  public static Object[][] Test1() throws Exception {
	 
	        return new Object[][] { 
	        	
	        	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","Java1","Java1 Descr" },
	        	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","Java2","Java2 Descr"  },
	           	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","Java3","Java3 Descr"  },
	           	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","Java4","Java4 Descr"  },
	         	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","Java5","Java5 Descr"  }
	        	};
	  }
	 
	 
	 
	 @DataProvider(name = "TC01_Add_Skills")
		public  Object[][] Authentication1() throws Exception {
			
			ExcelApiTest4 eat = new ExcelApiTest4();
			Object[][] testObjArray = eat.getTableArray("C://HTML Report//OrangeHRM6//TC01_Skills78.xlsx", "Sheet1");
			
			
			System.out.println(testObjArray.length);
			return (testObjArray);
		}
		
		
	
	
  @Test(dataProvider="TC01_Add_Skills")//Step2
  public void SkillsTest(String TestURL,String username,String password,
		  String skillname,String skilldescr) throws Exception {
	  
	
	  TC01_Add_Skills T1=new TC01_Add_Skills();
	  
		T1.OpenChromeBrowser();
		T1.OpenOrangeHRM(TestURL);
		T1.Login(username,password);
		T1.AddSkills(skillname,skilldescr);

	

	  
  }
  
  
  
  public void OpenChromeBrowser() throws Exception {
	
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;
  }
  
  
  
 public void OpenOrangeHRM(String TestURL1) throws Exception {
	
		driver.get(TestURL1);
  }
 
 
 public void Login(String username,String password) throws Exception {
	
		findElement(By.id("txtUsername")).sendKeys(username);
		findElement(By.id("txtPassword")).sendKeys(password);
		findElement(By.id("btnLogin")).click();
 }
 
 
 public void AddSkills(String SkillName,String SkillDescr) throws Exception {
	  
		
		findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_Qualifications")).click();
		findElement(By.id("menu_admin_viewSkills")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("skill_name")).sendKeys(SkillName);
		findElement(By.id("skill_description")).sendKeys(SkillDescr);
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
