package mobile.PageObjects.android;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import Utils.ReusableActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class JobAssistancePage {
	
	AndroidDriver driver;
	ReusableActions actions;
	public JobAssistancePage(AndroidDriver driver) {
		
		this.driver=driver;
		this.actions = new ReusableActions(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy( accessibility= "Job Assistance\nTab 2 of 5")
	   private WebElement jobAssistanceEle;

	
	@AndroidFindBy(accessibility = "Industrial Events")
	 private WebElement industrialEvent;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(2)")
	 private WebElement eventEle;
	
	@AndroidFindBy(accessibility = "Corporate Sustainability and Biodiversity")
	 private WebElement corporateSustainability;
	
	@AndroidFindBy(accessibility = "Summit 2022")
	 private WebElement Summit;
	
	@AndroidFindBy(accessibility = "ECV International")
	 private WebElement ECV;
	
	@AndroidFindBy(accessibility = "Basic Skills")
	 private WebElement basicSkills;

	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.HorizontalScrollView[1]/android.widget.ImageView[1]")
	 private WebElement curriculumVitae;
	
	@AndroidFindBy(accessibility = "Learn without Limits")
	 private WebElement learnwithoutLimits;


	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.HorizontalScrollView[2]/android.widget.ImageView[1]")
	 private WebElement creativitySkill;
	
	@AndroidFindBy(accessibility = "Recommended by Professionals")
	 private WebElement recommendedbyProfessionals;

	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.HorizontalScrollView[3]/android.widget.ImageView[1]")
	 private WebElement emotionalIntelligence;
	

	public boolean getIntoJobAssistanceSection() {
		 jobAssistanceEle.click();
	    return jobAssistanceEle.isDisplayed();
		
	}
		
	public String lookingForIndustrals() {
			
		String  industrialEventText = industrialEvent.getAttribute("content-desc");
		return industrialEventText;
	}
	
	
	public String lookingForIntoEvent() {
		eventEle.click();
		String CorporateSustainabilityText=corporateSustainability.getAttribute("content-desc");
		return CorporateSustainabilityText;
		
	}
	
	public String lokkingForSummit() {
		 String summitText= Summit.getAttribute("content-desc");
	        return summitText;
	}
	
   public String LookingForEcvInternation() {
	 
	      String ecvInternationalText = ECV.getAttribute("content-desc");
        	return ecvInternationalText;
	 
	 }

	public String basicSkillInfo() {
		
		  actions.scrollToEndAction();
		  actions.navigateBack();
	      String basicSkillText =  basicSkills.getAttribute("content-desc");
	      actions.swipeAction(curriculumVitae, "Left");
		  return basicSkillText;
	}
	
	
	public String learnWithoutLimitsInfo() {
		 actions.scrollToEndAction();
		 String learnwithoutLimitsText = learnwithoutLimits.getAttribute("content-desc");
		 actions.swipeAction(creativitySkill, "Left");
		 return learnwithoutLimitsText;
	}
	
	public String professionalsInfo() {
		  String recommendedbyProfessionalsText= recommendedbyProfessionals.getAttribute("content-desc");
		  actions.swipeAction(emotionalIntelligence, "Left");
		  return recommendedbyProfessionalsText;
	}
	
	
	
	
	
	
	

}
