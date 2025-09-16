package mobile.PageObjects.android;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;

import Utils.ReusableActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage {
	
    AndroidDriver driver;
    ReusableActions actions;
    
	public LoginPage(AndroidDriver driver) {
		this.driver = driver;
	    this.actions = new ReusableActions(driver);
		PageFactory.initElements( new AppiumFieldDecorator(driver), this);
	}


    @AndroidFindBy(xpath="//android.widget.Button[@content-desc=\"NEXT >\"]")
	public WebElement next;
	
	@AndroidFindBy(xpath="//android.view.View[@content-desc='Get Started ']")
	private WebElement getStarted;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Email']")
	private WebElement emailBox;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Password']")
	private WebElement passwordBox;
	
	@AndroidFindBy(xpath="(//android.view.View[@content-desc=\"Login\"])[2]")
	private WebElement loginButton;
	
	
	
		
	public void setActivity() {
		
//  mCurrentFocus=Window{4f0b5db u0 com.example.ccpc/com.example.ccpc.MainActivity}		
		    ((JavascriptExecutor) driver).executeScript(
		        "mobile: startActivity",
		        ImmutableMap.of("intent", "com.example.ccpc/com.example.ccpc.MainActivity")
		    );
		}

          
       
	
    public void nextSetup() {
    	
    	actions.waitForVisibility(next);
		 next.click();
		 actions.waitForVisibility(next);
		 next.click();
		 getStarted.click();
		 }
	
	 public void setEmail(String Email) {
		 emailBox.click();
	     emailBox.sendKeys(Email);
	     }
	 
	 public void setPassword(String Password) {
	     passwordBox.click();
	     passwordBox.sendKeys(Password);
		 }
	
	public void clickLoginButton() {
		loginButton.click();
		
		}
	
	 public String getToastMessage() {
		 try {
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		        WebElement toast = wait.until(
		            ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.Toast"))
		        );

		        // toast text can be available via different attributes on different setups
		        String text = toast.getAttribute("name");
		        if (text == null || text.isEmpty()) text = toast.getAttribute("text");
		        if (text == null || text.isEmpty()) text = toast.getText();
		        return text;
		    } catch (Exception e) {
		        // no toast appeared within timeout
		        return null;
		    }
          }
	 
	 
	
	 
	 
	 public void startApp(String Email, String Password) throws InterruptedException {
		 
		 next.click();
		 next.click();
		 getStarted.click();
		 emailBox.click();
	     emailBox.sendKeys(Email);
	     passwordBox.click();
	     passwordBox.sendKeys(Password);
	     actions.waitForClickable(loginButton);
	     loginButton.click();
	     Thread.sleep(2000);
	 

	    	 }

	 public void getStart() {
		 
		 next.click();
		 next.click();
		 getStarted.click();
	 }
	 
	 
	 
	 
}
