package pages.web.controlcenter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.PageBase;

public class HomePage extends PageBase {

	// *********Constructor*********
	public HomePage(WebDriver driver) {
		super(driver);
	}

	// *********Dynamic Variables*********

	
	
	// ****Web Elements****
	By btn_Account = By.className("kt-header__topbar-wrapper");
	By btn_Cikis = By.cssSelector("a[href='/account/signout']");
	By assert_LoginPage = By.cssSelector("h3");
	
	// *********Page Methods*********
	// Go to HomePage
	public HomePage goToUrl(String base_url) {
		goToWebPage(base_url);
		return this;
	}
	
	public HomePage Logout() {
		click(btn_Account);
		click(btn_Cikis);
		assertEquals(assert_LoginPage, "Martı Call Center");
		return this;
	}
}
