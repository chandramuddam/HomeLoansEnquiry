package nab.homeloans.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import nab.homeloans.library.ThinkTime;
import nab.homeloans.pagefactory.NabHomeLoansPageFactory;
import net.thucydides.core.annotations.Step;

/**
 * Fill in the details and submit the enquiry form
 * 
 * @author chandra
 *
 */
public class NabHomeLoansEnquiryPage {
	WebDriver driver = null;
	private NabHomeLoansPageFactory pageFactory;
	private ThinkTime thinkTime;

	public NabHomeLoansEnquiryPage() {

	}

	public NabHomeLoansEnquiryPage(WebDriver driver) {

		this.driver = driver;
		pageFactory = PageFactory.initElements(driver, NabHomeLoansPageFactory.class);
		thinkTime = new ThinkTime();
	}

	// Submit the details for non NAB customer
	@Step("Step for submitting the home loans enquiry form")
	public void submitting_the_home_loans_enquiry_page(String firstName, String lastName, String phoneNumber,
			String email) {

		thinkTime.waitUntillElementClickable(driver, pageFactory.noButton);
		pageFactory.noButton.click();
		pageFactory.firstName.sendKeys(firstName);
		pageFactory.lastName.sendKeys(lastName);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Actions action = new Actions(driver);
		action.sendKeys(Keys.TAB).build().perform();
		action.sendKeys(Keys.ARROW_DOWN).build().perform();
		action.sendKeys(Keys.ARROW_DOWN).build().perform();
		action.sendKeys(Keys.ENTER).build().perform();
		pageFactory.phoneNumber.sendKeys(phoneNumber);
		pageFactory.emailId.sendKeys(email);
		thinkTime.waitUntillElementClickable(driver, pageFactory.submitButton);
		pageFactory.submitButton.click();

	}
}
