package Utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class ReusableActions {
	  AndroidDriver driver;
	
	public ReusableActions(AndroidDriver driver) {
		
		this.driver = driver;
	}
	
	
    public WebElement waitForElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

   
    public void navigateBack() {
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }
	
    public void waitForClickable(WebElement element){
          WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
    	  wait.until(ExpectedConditions.elementToBeClickable(element));
    	
    }
    
    
    public boolean waitForVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(300));
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    
	
	
	public WebElement scrollToElementByDesc(String desc) {
	    return driver.findElement(AppiumBy.androidUIAutomator(
	        "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().description(\"" + desc + "\"))"
	    ));
	          }
	
	
	public WebElement scrollToElementByText(String text) {
	    return driver.findElement(AppiumBy.androidUIAutomator(
	        "new UiScrollable(new UiSelector().scrollable(true))" +
	        ".scrollIntoView(new UiSelector().textContains(\"" + text + "\"))"
	    ));
	            }
	
	
	public void swipeAction(WebElement ele , String direction) {
		
		 ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", 
				 ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
						 "direction", direction ,
						 "percent", 0.75
						 ));
		
	}
	
    public void scrollToEndAction() {
		
    	 boolean canScrollMore;
 		do {
 			
 			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", 
 					 ImmutableMap.of("left", 100, "top", 200, "width", 200, "height", 200,
 							 "direction", "down",
 							 "percent", 1.0
 							 ));
 		                    }while(canScrollMore);
 	
	}
	
	
	
	

}
