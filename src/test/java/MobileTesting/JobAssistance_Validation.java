package MobileTesting;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestUtils.BaseTest;
import mobile.PageObjects.android.JobAssistancePage;

public class JobAssistance_Validation extends BaseTest {

	
	@Test(dataProvider = "getData")
	public void jobSectionChecking(HashMap<String,String> input) throws InterruptedException {
		
		
		JobAssistancePage jobPage = new JobAssistancePage(driver);
		
		loginPage.startApp(input.get("Email"), input.get("Password"));
	   
		 
		
	    boolean jobAssistanceTab = jobPage.getIntoJobAssistanceSection();
	   Assert.assertTrue(jobAssistanceTab, "jobAssistance tab is not visible!");
	    
	    
	   String industrialEventTitle = jobPage.lookingForIndustrals();
	   System.out.println(" \n "+ industrialEventTitle  );
	   Assert.assertEquals(industrialEventTitle, "Industrial Events", "industrial Event title not matched !");
		
		String CorporateSustainabilityTitle= jobPage.lookingForIntoEvent();
		System.out.println(" \n "+ CorporateSustainabilityTitle  );
	    Assert.assertEquals(CorporateSustainabilityTitle, "Corporate Sustainability and Biodiversity",
		               "CorporateSustainability  titile not matched !");
		
	   String simmitTitle =jobPage.lokkingForSummit();
	   System.out.println(" \n "+ simmitTitle  );
		Assert.assertEquals(simmitTitle, "Summit 2022", "simmit 2022  titile not matched !");
		
	  String EcvTitle=jobPage.LookingForEcvInternation();
	  System.out.println(" \n "+ EcvTitle  );
	Assert.assertEquals(EcvTitle, "ECV International", "ECV International titile not matched !");
		
	 String basicSkillTitle =jobPage.basicSkillInfo();
	  System.out.println(" \n "+ basicSkillTitle  );
	Assert.assertEquals(basicSkillTitle, "Basic Skills");
		
		String learnWithoutlimitTitle = jobPage.learnWithoutLimitsInfo();
	   System.out.println(" \n "+ learnWithoutlimitTitle  );
	Assert.assertEquals(learnWithoutlimitTitle, "Learn without Limits");
		
	String byProfessionalText = jobPage.professionalsInfo();
	  System.out.println(" \n "+ byProfessionalText  );
	Assert.assertEquals(byProfessionalText, "Recommended by Professionals");
		
		
		
		
		
		
		
		
		
	
}
}