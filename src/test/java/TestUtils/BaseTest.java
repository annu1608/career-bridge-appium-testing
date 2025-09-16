package TestUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import mobile.PageObjects.android.LoginPage;

public class BaseTest {
	 
	public AppiumDriverLocalService service;
	public 	AndroidDriver driver;
	public LoginPage loginPage ;
	
	
	@BeforeMethod(alwaysRun = true)
	public void Confi() throws IOException, URISyntaxException{
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\data.properties");
		prop.load(fis);
		
		//if ipAdress is not equal to null then execute first statement if equal to null execute second statement 
		String ipAddress=System.getProperty("ipAddress")!=null ? 
				         System.getProperty("ipAddress"):prop.getProperty("ipAddress");
		
	    int port = Integer.parseInt(prop.getProperty("port"));
	    String androidDevice = prop.getProperty("AndroidDevice");
		
		//appium server location
		service = new AppiumServiceBuilder()
		        .usingDriverExecutable(new File("C:\\Users\\ANNU\\NodeJS\\node-v18.20.8-win-x64\\node.exe"))
		        .withAppiumJS(new File("C:\\Users\\ANNU\\NodeJS\\node-v18.20.8-win-x64\\node_modules\\appium\\build\\lib\\main.js"))
		        .withIPAddress(ipAddress)
		        .usingPort(port)
		        .withTimeout(Duration.ofSeconds(60))
		        .build();
         service.start();
		 
		
		UiAutomator2Options option = new UiAutomator2Options();
		option.setDeviceName(androidDevice);
		option.setApp("C:\\Users\\ANNU\\eclipse-fresh-workspace\\CareerBridgeAppium\\src\\test\\java\\Apk_App\\IP23 QA Problem Data.apk");
		option.setChromedriverExecutable("C:\\Users\\ANNU\\Downloads\\driver\\chromedriver.exe");

		driver = new AndroidDriver(new URI(("http://" + ipAddress + ":" + port+ "/")).toURL(),option);
		if (driver == null) {
		        throw new RuntimeException("Driver failed to initialize. Check Appium logs."); }
		   
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		loginPage = new LoginPage(driver);
        loginPage.setActivity(); 
	        
	       
	}
	
	 public String getScreenshot(String testCaseName, AndroidDriver driver) throws IOException {
			
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
			FileUtils.copyFile(source, file);
			return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
			
			
	    }
	
	
	public static  List<HashMap<String, String>> getJsonToMap(String JsonFilePath) throws IOException{
 	
 	      String jsonContent= FileUtils.readFileToString(new File(JsonFilePath),
 				StandardCharsets.UTF_8);
 	    
 		  ObjectMapper mapper = new ObjectMapper();
 		  List<HashMap<String,String>> data= mapper.readValue(jsonContent, 
 				new TypeReference<List<HashMap<String,String>>>(){
 		       });
 		  return data;
 	   }
	
	@DataProvider 
	   public Object[][] getData() throws IOException {
			 
			 List <HashMap<String, String>> data= getJsonToMap(System.getProperty("user.dir")+"\\src\\test\\java\\Data\\CCPC.json");
			 return new Object[][] {
			 {data.get(0)}};
			
		 } 
	
	@DataProvider 
	   public Object[][] getSignUpData() throws IOException {
			 
			 List <HashMap<String, String>> data= getJsonToMap(System.getProperty("user.dir")+"\\src\\test\\java\\Data\\CCPC.json");
			 return new Object[][] {
			 {data.get(1)}};
			
		 } 
	
	@DataProvider 
	   public Object[][] getForgotPasswordLinkiData() throws IOException {
			 
			 List <HashMap<String, String>> data= getJsonToMap(System.getProperty("user.dir")+"\\src\\test\\java\\Data\\CCPC.json");
			 return new Object[][] {
			 {data.get(2)}};
			
		 } 
	
	 @AfterMethod(alwaysRun = true)
	    public void tearDown() {
		 if (driver != null) {
		        driver.quit();
		    }
		    if (service != null && service.isRunning()) {
		        service.stop();
		    }
	        }
	 
	 
	 
	 
	 
	    }



