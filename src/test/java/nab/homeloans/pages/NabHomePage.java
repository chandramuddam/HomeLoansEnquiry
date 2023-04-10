package nab.homeloans.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import nab.homeloans.library.ThinkTime;
import nab.homeloans.pagefactory.NabHomeLoansPageFactory;
import net.thucydides.core.annotations.Step;

/**
 * Navigate to home loans page
 * 
 * @author chandra
 *
 */

public class NabHomePage {
	WebDriver driver = null;
	private NabHomeLoansPageFactory pageFactory;
	private ThinkTime thinkTime;

	public NabHomePage() {

	}

	public NabHomePage(WebDriver driver) {
		this.driver = driver;
		pageFactory = PageFactory.initElements(driver, NabHomeLoansPageFactory.class);
		thinkTime = new ThinkTime();
	}

	// Navigate to home loans page
	@Step("Step for navigating to home loans page")
	public void navigate_to_home_loan_page() {
		thinkTime.waitUntillElementClickable(driver, pageFactory.personal);
		pageFactory.personal.click();
		thinkTime.waitUntillElementClickable(driver, pageFactory.homeLoans.get(0));
		pageFactory.homeLoans.get(0).click();
		thinkTime.waitUntillElementClickable(driver, pageFactory.personalHomeLoans);
		pageFactory.personalHomeLoans.click();

	}

}