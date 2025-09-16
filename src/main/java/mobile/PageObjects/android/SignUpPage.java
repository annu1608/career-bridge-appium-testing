package mobile.PageObjects.android;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.ReusableActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SignUpPage {

	 AndroidDriver driver;
	 ReusableActions actions;

	public SignUpPage(AndroidDriver driver) {
		this.driver = driver;
		this.actions = new ReusableActions(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(accessibility="Sign up")
	private WebElement forSignUp;
	
	@AndroidFindBy(accessibility="Sign Up")
	private WebElement signUpText;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text=\"Username\"]")
	private WebElement userNameField;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text=\"Email\"]")
	private WebElement emailField;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text=\"Password\"]")
	private WebElement passwordField;
	
	@AndroidFindBy(accessibility="Enter Valid Password(Min. 6 Character)")
	private WebElement minPasswordLength;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text=\"Confirm Password\"]")
	private WebElement confirmPasswordField;
	
	@AndroidFindBy(accessibility="Agree Terms and Conditions")
	private WebElement agreeTermsCondition;
	
	@AndroidFindBy(className="android.widget.CheckBox")
	private WebElement checkBoxTick;
	
	@AndroidFindBy(xpath="//android.view.View[@content-desc=\"Sign up\"]")
	private WebElement signUpButton;
	
	@AndroidFindBy(xpath="//android.view.View[@content-desc=\"Login\"]")
	private WebElement loginButton;
	
	
	
	 public String getIntoSignUpSection() {
		
		forSignUp.click();
		return signUpText.getAttribute("content-desc");
		 }
	
	  public void enterUserName(String name) {
		  userNameField.click();
		  userNameField.sendKeys(name);
	    }
  
      
	   public void enterUserEmail(String email) {
		 emailField.click();
		 emailField.sendKeys(email);
	      }	
	
	   public void enterUserPassword(String password) {
		  passwordField.click();
		  passwordField.sendKeys(password);
	       }
	
	   public String lenghtOfPswdMustBe() {
		   
		return  minPasswordLength.getAttribute("content-desc");

	   }
	   public void enterUserConfirmedPassword(String confirmPassword) {
		   confirmPasswordField.click();
		   confirmPasswordField.sendKeys(confirmPassword);
	         }
	   
	   public String tickCheckBox() {
		   String ConditonsText =agreeTermsCondition.getAttribute("content-desc");
		     checkBoxTick.click();
		     return ConditonsText;
	         }
	
       public void clickSignUpTab() {
    	   signUpButton.click();
           }
	
	   public void clickLoginTab() {
		    loginButton.click();
		
	        }
	   
	   
	   public String getToastMessage() {
			 try {
			        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
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
		 
	
	
}
