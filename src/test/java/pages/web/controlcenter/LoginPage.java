package pages.web.controlcenter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.PageBase;

public class LoginPage extends PageBase {

    //*********Constructor*********
    public LoginPage(WebDriver driver) {
        super(driver);
    }

 	
 	//*********Web Elements*************
    By txt_Username = By.name("username");
    By txt_Password = By.name("password");
    By btn_Login = By.id("kt_login_submit2");
    By txt_OtpField = By.name("OneTimePassword");
    By btn_DevamEt = By.id("kt_login_submit2");
	By lbl_AlertText = By.className("alert-text");
 	
	// *********Page Methods*********
	// Go to LoginPage
	public LoginPage goToUrl(String url) {
		navigateToURL(url);
		return this;
	}
	
	public LoginPage Login(String user_phone_number, String password) {
		click(btn_Login);
		assertEquals(lbl_AlertText, "Kullanıcı adı veya şifreniz hatalı"); 
		writeText(txt_Username, user_phone_number);
		writeText(txt_Password, password);
		click(btn_Login);
		writeText(txt_OtpField, "1234");
		click(btn_DevamEt);
		return this;
	}
}
