package nab.homeloans.pages;

import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import nab.homeloans.library.ThinkTime;
import nab.homeloans.pagefactory.NabHomeLoansPageFactory;
import net.thucydides.core.annotations.Step;

/**
 * Validates the confirmation message for the non NAB customer
 * 
 * @author chandra
 *
 */
public class NabHomeLoansEnquiryConfirmationPage {
	WebDriver driver = null;
	private NabHomeLoansPageFactory pageFactory;
	private ThinkTime thinkTime;

	public NabHomeLoansEnquiryConfirmationPage() {

	}

	public NabHomeLoansEnquiryConfirmationPage(WebDriver driver) {

		this.driver = driver;
		pageFactory = PageFactory.initElements(driver, NabHomeLoansPageFactory.class);
		thinkTime = new ThinkTime();
	}

	// Compare the actual and expected confirmation message
	@Step("Step for validating the confirmation message")
	public void validateConfirmationMessage(Properties prop) {
		String expectedConfirmMsg = prop.getProperty("ConfirmationMessage");
		thinkTime.wait(driver, pageFactory.confirmationMsg);
		String actualConfirmMsg = pageFactory.confirmationMsg.getText();
		Assert.assertTrue(actualConfirmMsg.equalsIgnoreCase(expectedConfirmMsg));
	}
}
