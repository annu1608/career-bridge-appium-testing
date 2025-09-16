package MobileTesting;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import TestUtils.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class BoilerCode extends BaseTest {
	@Test
	public void code() throws InterruptedException {
   	 
		 boolean canScrollMore;
		
//LOGIN PAGE	 
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"NEXT >\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"NEXT >\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='Get Started ']")).click();
        WebElement emailBox = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Email']"));
        emailBox.click();
        emailBox.sendKeys("annu.crpf@gmail.com");
        WebElement passBox = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Password']"));
        passBox.click();
        passBox.sendKeys("Annu@123");
        driver.findElement(AppiumBy.xpath("(//android.view.View[@content-desc=\"Login\"])[2]")).click();
//HOME PAGE 
        WebElement hiElement = driver.findElement(AppiumBy.accessibilityId("Hi,"));
        System.out.println(hiElement.getAttribute("content-desc"));
        String nameText=driver.findElement(AppiumBy.xpath("//android.view.View[@index='1']")).getAttribute("content-desc");  
        WebElement backendEngineer = driver.findElement(AppiumBy.accessibilityId("Backend Engineer\nWmware\nCA\nFresher\nFull-Time"));
        backendEngineer.click();
        WebElement companyTab = driver.findElement(AppiumBy.accessibilityId("Company\nTab 2 of 3"));
        companyTab.click();
        driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='Reviews\nTab 3 of 3']")).click();
        do {
 			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", 
 					 ImmutableMap.of("left", 100, "top", 200, "width", 200, "height", 200,
 							 "direction", "down",  "percent", 1.0 ));
 							}while(canScrollMore);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", 
				 ImmutableMap.of("elementId",((RemoteWebElement)backendEngineer).getId(),
						 "direction", "Left" , "percent", 0.75 ));
		WebElement internshipBox = driver.findElement(
	    AppiumBy.xpath("//android.widget.ScrollView/android.widget.HorizontalScrollView[3]")	);
	    ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", 
				 ImmutableMap.of("elementId",((RemoteWebElement)internshipBox).getId(),
						 "direction", "Left" , "percent", 0.75  ));
		driver.findElement(AppiumBy.androidUIAutomator(
			    "new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"Placements\"))"));
		String BlogsText=driver.findElement(AppiumBy.accessibilityId("Blogs")).getAttribute("content-desc");
	    driver.findElement(AppiumBy.accessibilityId("See more")).click();
	    driver.findElement(AppiumBy.androidUIAutomator(
				    "new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"VISIT BLOG NOW\"))"));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
//INTERNSHIP PAGE       
	    driver.findElement(AppiumBy.accessibilityId("Intership\nTab 1 of 5")).click();
	    String summerInterns= driver.findElement(AppiumBy.accessibilityId("We are looking for a \nSummer Intern")).getAttribute("content-desc");
	    driver.findElement(AppiumBy.accessibilityId("View details")).click();
	    driver.findElement(AppiumBy.accessibilityId("Requirements\nTab 2 of 3")).click();
	    driver.findElement(AppiumBy.accessibilityId("Eligibility \nTab 3 of 3")).click();
	    driver.pressKey(new KeyEvent(AndroidKey.BACK));
	    do {
 			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", 
 					 ImmutableMap.of("left", 100, "top", 200, "width", 200, "height", 200,
 							 "direction", "down",  "percent", 1.0));
 							}while(canScrollMore);
	    driver.pressKey(new KeyEvent(AndroidKey.BACK));
//JOBASSISTANCE PAGE 
	    driver.findElement(AppiumBy.accessibilityId("Job Assistance\nTab 2 of 5")).click();
	    String  industrialEventText = driver.findElement(AppiumBy.accessibilityId("Industrial Events")).getAttribute("content-desc");
		WebElement event = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(2)"));
		event.click();
		String corporateSustainability=driver.findElement(AppiumBy.accessibilityId("Corporate Sustainability and Biodiversity")).getAttribute("content-desc");
		String summit =driver.findElement(AppiumBy.accessibilityId("Summit 2022")).getAttribute("content-desc");
		String ecv =driver.findElement(AppiumBy.accessibilityId("ECV International")).getAttribute("content-desc");
		do {
 			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", 
 					 ImmutableMap.of("left", 100, "top", 200, "width", 200, "height", 200,
 							 "direction", "down",  "percent", 1.0));
 							}while(canScrollMore);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		String basicSkill =driver.findElement(AppiumBy.accessibilityId("Basic Skills")).getAttribute("content-desc");
		WebElement curriculumVitae  = driver.findElement(AppiumBy.xpath("//android.widget.ScrollView/android.widget.HorizontalScrollView[1]/android.widget.ImageView[1]"));
	    ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", 
				 ImmutableMap.of("elementId",((RemoteWebElement)curriculumVitae).getId(),
						 "direction", "Left" , "percent", 0.75 ));
		do {
 			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", 
 					 ImmutableMap.of("left", 100, "top", 200, "width", 200, "height", 200,
 							 "direction", "down",  "percent", 1.0));
 							}while(canScrollMore);
		String learnwithoutLimits =driver.findElement(AppiumBy.accessibilityId("Learn without Limits")).getAttribute("content-desc");
		WebElement creativitySkill  = driver.findElement(AppiumBy.xpath("//android.widget.ScrollView/android.widget.HorizontalScrollView[2]/android.widget.ImageView[1]"));
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", 
				 ImmutableMap.of("elementId",((RemoteWebElement)creativitySkill).getId(),
						 "direction", "Left" , "percent", 0.75 ));
		String recommendedbyProfessionals =driver.findElement(AppiumBy.accessibilityId("Recommended by Professionals")).getAttribute("content-desc");
		WebElement emotionalIntelligence  = driver.findElement(AppiumBy.xpath("//android.widget.ScrollView/android.widget.HorizontalScrollView[3]/android.widget.ImageView[1]"));
	    ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", 
				 ImmutableMap.of("elementId",((RemoteWebElement)emotionalIntelligence).getId(),
						 "direction", "Left" , "percent", 0.75));
//CAREERGUIDANCE PAGE
        driver.findElement(AppiumBy.accessibilityId("Career Guidance\nTab 4 of 5")).click();
        String todayEvent= driver.findElement(AppiumBy.accessibilityId("Today’s Event")).getAttribute("content-desc");
        do {
 			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", 
 					 ImmutableMap.of("left", 100, "top", 200, "width", 200, "height", 200,
 							 "direction", "down", "percent", 1.0 ));
 							}while(canScrollMore);
 		driver.findElement(AppiumBy.accessibilityId("Register Now")).click();
        do {
 			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", 
 					 ImmutableMap.of("left", 100, "top", 200, "width", 200, "height", 200,
 							 "direction", "down",  "percent", 1.0));
 							}while(canScrollMore);
   	    String upComingEventText =driver.findElement(AppiumBy.accessibilityId("Upcoming Events")).getAttribute("content-desc");
		WebElement bigDataImg = driver.findElement(AppiumBy.xpath("//android.widget.ScrollView/android.widget.HorizontalScrollView[1]/android.widget.ImageView[3]"));
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", 
				 ImmutableMap.of("elementId",((RemoteWebElement)bigDataImg).getId(),
						 "direction", "Left" ,  "percent", 0.75 ));
		String completeWebniarText =driver.findElement(AppiumBy.accessibilityId("Completed Webinars")).getAttribute("content-desc");
		WebElement uiUxDesign = driver.findElement(AppiumBy.xpath("//android.widget.ScrollView/android.widget.HorizontalScrollView[2]/android.widget.ImageView[1]"));
	    ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", 
					 ImmutableMap.of("elementId",((RemoteWebElement)uiUxDesign).getId(),
							 "direction", "Left" ,"percent", 0.75 ));
	    driver.pressKey(new KeyEvent(AndroidKey.BACK));
//PROFILE PAGE
        driver.findElement(AppiumBy.accessibilityId("Profile\nTab 5 of 5")).click();
        List<WebElement> elements = driver.findElements(AppiumBy.className("android.view.View"));
        int index = 1;
        WebElement element = elements.get(index);
        String text = element.getText();
        if (text == null || text.trim().isEmpty()) {
            text = element.getAttribute("content-desc");  }
        if (text != null && !text.trim().isEmpty() && !"null".equalsIgnoreCase(text.trim())) {
            System.out.println("Profile Name:  " + index + " => " + text.trim());  }
        driver.findElement(AppiumBy.accessibilityId("Log Out")).click();

    
	
    }}