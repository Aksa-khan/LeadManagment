package com.ind.Page;

import com.ind.Base.TestBase;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesPage extends TestBase {
	
	@FindBy(xpath = "(//span[@class='slds-truncate'])[3]")
	WebElement opportunity;

	@FindBy(linkText = "New")
	WebElement Newopp;

	@FindBy(xpath = "(//input[@class='slds-input'])[4]")
	WebElement oppname;

	@FindBy(xpath = "(//input[@class='slds-input'])[3]")
	WebElement closedate;

	@FindBy(xpath = "(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[1]")
	WebElement satge;
	
	@FindBy(xpath="(//div[@class='slds-listbox slds-listbox_vertical slds-dropdown slds-dropdown_fluid slds-dropdown_left'])[2]")
	WebElement stagevalues;

//	@FindBy(xpath = "(//input[@class='slds-combobox__input slds-input'])[1]")
	@FindBy(xpath="(//div[@class='slds-combobox__form-element slds-input-has-icon slds-input-has-icon_right'])[1]")
	WebElement accountname;

//	@FindBy(xpath = "(//input[@class='slds-combobox__input slds-input'])[2]")
	@FindBy(xpath="(//div[@class='slds-combobox__form-element slds-input-has-icon slds-input-has-icon_right'])[5]")
	WebElement cmpgname;

	@FindBy(xpath = "//button[@class='slds-button slds-button_brand']")
	WebElement save;
	
	@FindBy(xpath="//lightning-formatted-text[@slot='primaryField']")
	WebElement verifyopp;
	
	@FindBy(xpath="(//li[@class='slds-tabs_default__item'])[1]")
	WebElement details;
	
	@FindBy(xpath="(//button[@class='test-id__inline-edit-trigger slds-shrink-none inline-edit-trigger slds-button slds-button_icon-bare'])[8]")
	WebElement editstage;
	
	@FindBy(xpath="(//lightning-base-combobox[@class='slds-combobox_container'])[4]")
	WebElement selectstage;
	
	@FindBy(xpath="(//div[@class='slds-float--right forceDeferredDropDownAction'])[1]")
	WebElement addproduct;
	
	@FindBy(xpath="//a[@title='Add Products']")
	WebElement product;
	
	@FindBy(xpath="//a[@title='Choose Price Book']")
	WebElement CPB;

	@FindBy(xpath="//div[@class='uiMenu uiInput uiInputSelect forceInputPicklist uiInput--default uiInput--select']")
	WebElement PBPicklist;
	
	@FindBy(xpath="(//span[@class=' label bBody'])[6]")
	WebElement PBsave;
	
	@FindBy(xpath="//button[@class='slds-button slds-button--neutral uiButton--default uiButton--brand uiButton forceActionButton']")
	WebElement PBconfsave;

	@FindBy(xpath="(//span[@class='slds-checkbox--faux'])[2]")
	WebElement Productcheckbox;
	
	@FindBy(xpath=" //button[@class='slds-button slds-button--neutral uiButton--default uiButton--brand uiButton forceActionButton']")
	WebElement nextbtn;
	
	@FindBy(xpath="//input[@class='slds-grow input uiInputSmartNumber']")
	WebElement quantity;
	
	@FindBy(xpath="//button[@class='slds-button slds-button--neutral uiButton--default uiButton--brand uiButton forceActionButton']")
	WebElement savequantity;
	
	public OpportunitiesPage() {

		PageFactory.initElements(driver, this);

	}

	public void creatopp(String OpportunityName, String CloseDate, String Stage, String AccountName, String CampName,String UpdateStage) throws InterruptedException {

		TestBase.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		JavascriptExecutor js = (JavascriptExecutor) TestBase.driver;
		js.executeScript("arguments[0].click();", opportunity);
		
		Newopp.click();
    	Thread.sleep(5000);
		
		oppname.sendKeys(OpportunityName);
		
		closedate.sendKeys("12/29/2022");
		
		JavascriptExecutor js1 = (JavascriptExecutor) TestBase.driver;
		js1.executeScript("arguments[0].click();", satge);
		
		satge.sendKeys(Keys.ARROW_DOWN);
		satge.sendKeys(Keys.ARROW_DOWN);
		satge.sendKeys(Keys.ENTER);

//		List<WebElement> counList=driver.findElements(By.xpath("(//div[@class='slds-listbox slds-listbox_vertical slds-dropdown slds-dropdown_fluid slds-dropdown_left'])[2]"));
//		for(WebElement ele :counList)
//		{
//			String coun=ele.getText();
//			if(coun.equalsIgnoreCase(Stage))
//			{
//				ele.click();
//				Thread.sleep(2000);
//				break;
//				
//			}
//			
//			System.out.println(coun);
//		}
		
		JavascriptExecutor js3 = (JavascriptExecutor) TestBase.driver;
		js3.executeScript("arguments[0].click();", accountname);
		
		accountname.sendKeys(AccountName);
		Thread.sleep(7000);
		accountname.sendKeys(Keys.ARROW_DOWN);
		accountname.sendKeys(Keys.ENTER);
		
		JavascriptExecutor js4 = (JavascriptExecutor) TestBase.driver;
		js4.executeScript("arguments[0].click();", cmpgname);
		cmpgname.sendKeys(CampName);
		Thread.sleep(7000);
		cmpgname.sendKeys(Keys.ARROW_DOWN);
		cmpgname.sendKeys(Keys.ENTER);	
		
		save.click();
		
		JavascriptExecutor js9 = (JavascriptExecutor) TestBase.driver;
		js9.executeScript("arguments[0].click();", details);
		
//		JavascriptExecutor js7 = (JavascriptExecutor) TestBase.driver;
//		js7.executeScript("arguments[0].click();", addproduct);
//		Thread.sleep(5000);
//		JavascriptExecutor js8 = (JavascriptExecutor) TestBase.driver;
//		js8.executeScript("arguments[0].click();", CPB);
//		
//		JavascriptExecutor js10 = (JavascriptExecutor) TestBase.driver;
//		js10.executeScript("arguments[0].click();", PBsave);
//		
		JavascriptExecutor js5 = (JavascriptExecutor) TestBase.driver;
		js5.executeScript("arguments[0].click();", editstage);
		
		JavascriptExecutor js6 = (JavascriptExecutor) TestBase.driver;
		js6.executeScript("arguments[0].click();", selectstage);
		satge.sendKeys(Keys.ARROW_DOWN);
		satge.sendKeys(Keys.ARROW_DOWN);
		satge.sendKeys(Keys.ARROW_DOWN);
		satge.sendKeys(Keys.ENTER);
		
		save.click();
		
		
		
	}

	
	public String verifyedopp() {
		return verifyopp.getText();
	}
	

}
