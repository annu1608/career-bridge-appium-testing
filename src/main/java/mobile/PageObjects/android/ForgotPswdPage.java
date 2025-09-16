package mobile.PageObjects.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utils.ReusableActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ForgotPswdPage {

	
	AndroidDriver driver;
	ReusableActions actions;
	public ForgotPswdPage(AndroidDriver driver) {
		
		this.driver=driver;
		this.actions= new ReusableActions(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	
	@AndroidFindBy(xpath="//android.view.View[@content-desc=\"Forgot Password\"]")
	private WebElement forgotPasswordEle;
	
	@AndroidFindBy(accessibility="Enter your email for password reset link")
	private WebElement resetLinkEle;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Email']")
	private WebElement emailBoxEle;
	
	@AndroidFindBy(xpath="//android.view.View[@content-desc=\"Reset\"]")
	private WebElement resetEle;
	
	
	
	public String setForgotPswd() {
		
		forgotPasswordEle.click();
		String ResetLinkText = resetLinkEle.getAttribute("content-desc");
		return ResetLinkText;
	}
	
	public void getEmailField(String email) {
		emailBoxEle.click();
		emailBoxEle.sendKeys(email);
		resetEle.click();
	}
   
	

}
