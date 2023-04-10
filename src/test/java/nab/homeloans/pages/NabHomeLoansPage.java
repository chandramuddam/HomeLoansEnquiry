package nab.homeloans.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import nab.homeloans.library.ThinkTime;
import nab.homeloans.pagefactory.NabHomeLoansPageFactory;
import net.thucydides.core.annotations.Step;

/**
 * Navigate to home loans topics page
 * 
 * @author chandra
 *
 */
public class NabHomeLoansPage {
	WebDriver driver = null;
	private NabHomeLoansPageFactory pageFactory;
	private ThinkTime thinkTime;

	public NabHomeLoansPage() {

	}

	public NabHomeLoansPage(WebDriver driver) {

		this.driver = driver;
		pageFactory = PageFactory.initElements(driver, NabHomeLoansPageFactory.class);
		thinkTime = new ThinkTime();
	}

	// Click on enquire about new home loan link
	@Step("Step for navigating to home loans topic page")
	public void navigate_to_home_loan_topic_page() {
		thinkTime.waitUntillElementClickable(driver, pageFactory.enquireAboutNewHomeLoan.get(0));
		pageFactory.enquireAboutNewHomeLoan.get(0).click();
	}
}
