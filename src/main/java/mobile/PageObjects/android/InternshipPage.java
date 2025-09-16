package mobile.PageObjects.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utils.ReusableActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class InternshipPage {
	
	AndroidDriver driver;
	ReusableActions actions;

	public InternshipPage (AndroidDriver driver) {
		this.driver = driver;
		this.actions= new ReusableActions(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	@AndroidFindBy(accessibility = "Intership\nTab 1 of 5")
	private WebElement internshipEle ;
	
	@AndroidFindBy(accessibility = "We are looking for a \nSummer Intern")
	private WebElement lookingSummerInternText;
	
	@AndroidFindBy(accessibility = "View details")
	private WebElement viewDetailsEle;
	
	@AndroidFindBy(accessibility = "Requirements\nTab 2 of 3")
	private WebElement requirementEle;
	
	@AndroidFindBy(accessibility =  "Eligibility \nTab 3 of 3")
	private WebElement eligibilityEle;


	public void getIntershipSection() {
		
		    internshipEle.click();
	}
	
	public String lookIntoSummerIntern() {
	        String summerInterns= lookingSummerInternText.getAttribute("content-desc");
		    return summerInterns;
		
	}
	
	
	public WebElement knowInternDetalis() {
		
		     viewDetailsEle.click();
		     requirementEle.click();
		 	return requirementEle;
	}
		
	
	public boolean checkEligibility() {	
		
	    eligibilityEle.click();
	  return eligibilityEle.isDisplayed();
	}
	
	
	public void lastActions() {
	   
		    actions.scrollToEndAction();
		    actions.navigateBack();
		    actions.scrollToEndAction();
	}
	
	
}
