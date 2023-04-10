package nab.homeloans.steps;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nab.homeloans.library.GetConfigProperties;
import nab.homeloans.library.SetDrivers;
import nab.homeloans.pagefactory.NabHomeLoansPageFactory;
import nab.homeloans.pages.NabHomeLoansEnquiryConfirmationPage;
import nab.homeloans.pages.NabHomeLoansEnquiryPage;
import nab.homeloans.pages.NabHomeLoansPage;
import nab.homeloans.pages.NabHomeLoansTopicPage;
import nab.homeloans.pages.NabHomePage;
import net.thucydides.core.annotations.Steps;

/**
 * Step definitions for NAB home loans scenario
 * 
 * @author chandra
 *
 */
public class NabHomeLoansStepDefinition {
	public static Logger log = LogManager.getLogger(NabHomeLoansStepDefinition.class.getName());

	public NabHomeLoansStepDefinition() {
		// TODO Auto-generated constructor stub
	}

	WebDriver driver;

	NabHomeLoansPageFactory pageFactory;
	@Steps
	NabHomePage homePage;
	@Steps
	NabHomeLoansEnquiryPage homeLoansEnquiryPage;
	@Steps
	NabHomeLoansPage homeLoansPage;
	@Steps
	NabHomeLoansTopicPage homeLoansTopicPage;
	@Steps
	NabHomeLoansEnquiryConfirmationPage homeLoansEnquiryConfirmationPage;

	GetConfigProperties getProps = new GetConfigProperties();
	SetDrivers setDrivers = new SetDrivers();
	Properties prop = new Properties();

	// Initialize the driver and configuration properties file
	@Before
	public void init() {
		prop = getProps.getConfigProperty();
		String runEnv = System.getProperty("runEnv");
		driver = setDrivers.setDrivers(runEnv);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		log.info("NAB Init");
	}

	// Launch the home page url
	@Given("^I am in nab home page$")
	public void i_am_in_nab_home_page() {

		String url = prop.getProperty("URL");
		driver.get(url);
		log.info("I am in nab home page");
	}

	// Navigate to home loan page
	@When("^I navigate to home loan page$")
	public void i_navigate_to_home_loan_page() {
		homePage = new NabHomePage(driver);
		homePage.navigate_to_home_loan_page();
		log.info("I navigate to home loan page");
	}

	// Navigate to home loan topic page
	@And("^I navigate to home loan topic page$")
	public void i_navigate_to_home_loan_topic_page() {
		homeLoansPage = new NabHomeLoansPage(driver);
		homeLoansPage.navigate_to_home_loan_topic_page();
		log.info("I navigate to home loan topic page");
	}

	// Navigate to home loan enquiry page
	@And("^I navigate to home loan enquiry page$")
	public void i_navigate_to_home_loan_enquiry_page() {
		homeLoansTopicPage = new NabHomeLoansTopicPage(driver);
		homeLoansTopicPage.navigate_to_home_loan_enquiry_form();
		log.info("I navigate to home loan enquiry page");
	}

	// Submit new home loan enquiry details
	@And("^I submit new home loan enquiry details (.+) (.+) (.+) (.+)$")
	public void i_submit_new_home_loan_enquiry_details(String firstName, String lastName, String phoneNumber,
			String email) {
		homeLoansEnquiryPage = new NabHomeLoansEnquiryPage(driver);
		homeLoansEnquiryPage.submitting_the_home_loans_enquiry_page(firstName, lastName, phoneNumber, email);
		log.info("I submit new home loan enquiry details");
	}

	// Validate the enquiry details confirmation message
	@Then("^I validate the confirmation message$")
	public void i_validate_the_confirmation_message() {
		homeLoansEnquiryConfirmationPage = new NabHomeLoansEnquiryConfirmationPage(driver);
		homeLoansEnquiryConfirmationPage.validateConfirmationMessage(prop);
		log.info("I validate the confirmation message");
	}

	// Quit the browsers
	@After
	public void quitBrowsers() {
		driver.quit();
		log.info("Quit Browser");
	}
}
