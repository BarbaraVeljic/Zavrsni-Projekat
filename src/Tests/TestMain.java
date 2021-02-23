
	package Tests;

import org.testng.annotations.Test;

public class TestMain extends BasicTest{
	@Test
		public void Test1() throws InterruptedException{
		driver.navigate().to("http://demo.yo-meals.com");
		
       locationPopupPage.setLocation("City Center - Albany");
      Thread.sleep(5000);
     // loginPage.loginCustomer("customer@dummyid.com","12345678a");
      Thread.sleep(5000);
      loginPage.getLogin().click();
     loginPage.getLoginBtn().click();
      profilePage.getPersonalInfo().click();
      profilePage.getMyAccount().click();
      profilePage.getProfilePage().click();
      profilePage.uploadPhoto("C:\\Users\\PC\\Desktop\\BarBara.jpg");
      Thread.sleep(5000);
	}
	}

