package nab.homeloans.pagefactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Global file for locating the elements for NAB home loans scenario
 * 
 * @author chandra
 *
 */
public class NabHomeLoansPageFactory {

	@FindBy(css = "a[data-submenu-item='1']")
	public WebElement personal;

	@FindBy(css = "ul[data-type= 'mega-menu'] a[href='/personal/home-loans']")
	public List<WebElement> homeLoans;

	@FindBy(css = "li.parent a[href='/personal/home-loans']")
	public WebElement personalHomeLoans;

	@FindBy(css = "ul.link-list.linklist li  a[href='https://www.nab.com.au/personal/home-loans/home-loan-enquiry?own_cid=19079-1']")
	public List<WebElement> enquireAboutNewHomeLoan;

	@FindBy(xpath = "//span[contains(text(),'No')]")
	public WebElement noButton;

	@FindBy(css = "input#field-page-Page1-aboutYou-firstName")
	public WebElement firstName;

	@FindBy(css = "input#field-page-Page1-aboutYou-lastName")
	public WebElement lastName;

	@FindBy(css = "div#page-Page1-aboutYou-state div.body div.css-1pcexqc-container")
	public WebElement state;

	@FindBy(css = "input#field-page-Page1-aboutYou-phoneNumber")
	public WebElement phoneNumber;

	@FindBy(css = "input#field-page-Page1-aboutYou-email")
	public WebElement emailId;

	@FindBy(css = "button#page-Page1-btnGroup-submitBtn")
	public WebElement submitButton;

	@FindBy(id = "contact-form-shadow-root")
	public WebElement rootElement;

	@FindBy(css = "div#page-outcome-rowthankyoupageheader-columns3-thankyoupageheadercontent2")
	public WebElement confirmationMsg;

}
