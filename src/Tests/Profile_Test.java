package Tests;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Profile_Test extends BasicTest {
@Test(priority=5)
	public void editProfile() throws InterruptedException {
		driver.navigate().to(this.baseUrl + "/guest-user/login-form");
		locationPopupPage.closePopupLocation();
		loginPage.getLoginBtn().click();
		loginPage.loginCustomer(this.ussername, this.password);
		Assert.assertEquals(notificationSistemPage.getMessageText(), 
				"Login Successfull", "[ERROR] Unexpected Login message");

		driver.navigate().to(this.baseUrl + "/member/profile");
		this.profilePage.updateInfo("Barbara", "Veljic", "Krusevac", 
				"37000", "00000000", "United States", "Florida","Bellview");
		Assert.assertEquals(notificationSistemPage.getMessageText(),
				"Setup Successful", "[ERROR] Unexpected Setup message");
		authPage.logout();
		Assert.assertEquals(notificationSistemPage.getMessageText(), 
				"Logout Successfull!", "[ERROR] Unexpected Logout message");
	}

	@Test(priority=10)
	public void changeProfileImage() throws IOException {
		driver.navigate().to(this.baseUrl + "/guest-user/login-form");
		locationPopupPage.closePopupLocation();
		loginPage.loginCustomer(this.ussername, this.password);
		Assert.assertEquals(notificationSistemPage.getMessageText(),
				"Login Successfull", "[ERROR] Unexpected Login message");
		driver.navigate().to(this.baseUrl + "/member/profile");
		String imgPath = new File("img/Image.jpg").getCanonicalPath();
		profilePage.uploadPhoto(imgPath);
		Assert.assertEquals(notificationSistemPage.getMessageText(),
				"Profile Image Uploaded Successfully", 
				"[ERROR] Unexpected Profile Image Uploaded message");
		notificationSistemPage.notificationDisappear();
		profilePage.removePhoto();
		Assert.assertEquals(notificationSistemPage.getMessageText(),
				"Profile Image Deleted Successfully",
				"[ERROR] Unexpected Profile Image Deleted message");
		notificationSistemPage.notificationDisappear();
		authPage.logout();
		Assert.assertEquals(notificationSistemPage.getMessageText(), 
				"Logout Successfull!", "[ERROR] Unexpected Logout message");
	}
}
