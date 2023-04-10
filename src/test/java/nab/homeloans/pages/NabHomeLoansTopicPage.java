package nab.homeloans.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import nab.homeloans.library.ThinkTime;
import nab.homeloans.library.Utils;
import nab.homeloans.pagefactory.NabHomeLoansPageFactory;
import net.thucydides.core.annotations.Step;

/**
 * Navigate to home loans enquiry form
 * 
 * @author chandra
 *
 */
public class NabHomeLoansTopicPage {
	WebDriver driver = null;
	private NabHomeLoansPageFactory pageFactory;
	private ThinkTime thinkTime;
	private Utils utils = new Utils();

	public NabHomeLoansTopicPage() {

	}

	public NabHomeLoansTopicPage(WebDriver driver) {

		this.driver = driver;
		pageFactory = PageFactory.initElements(driver, NabHomeLoansPageFactory.class);
		thinkTime = new ThinkTime();
	}

	// Navigate to home loans enquiry form
	@Step("Step for navigating to home loans enquiry form")
	public void navigate_to_home_loan_enquiry_form() {

		WebElement homeLoanRoot = utils.getShadowRootElement(driver, pageFactory.rootElement);
		WebElement newHomeLoansRaioButton = homeLoanRoot.findElement(By.cssSelector("div[id='myRadioButton-0']"));
		thinkTime.waitUntillElementClickable(driver, newHomeLoansRaioButton);
		newHomeLoansRaioButton.click();
		WebElement nextButton = homeLoanRoot.findElement(By.cssSelector("button[data-component-id='Button']"));

		String mainWindow = driver.getWindowHandle();

		new Actions(driver).moveToElement(nextButton).perform();
		nextButton.click();

		Set<String> set = driver.getWindowHandles();
		Iterator<String> itr = set.iterator();
		while (itr.hasNext()) {
			String childWindow = itr.next();
			if (!mainWindow.equals(childWindow)) {
				driver.switchTo().window(childWindow);
			}
		}

	}
}
