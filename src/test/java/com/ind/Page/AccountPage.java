package com.ind.Page;

import com.ind.Base.TestBase;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AccountPage extends TestBase {
	

	@FindBy(xpath="(//span[@class='slds-truncate'])[5]")
	WebElement Acc;
	
	@FindBy(linkText = "New")
	WebElement newacc;
	
	@FindBy(xpath="//input[@name='Name']")
	WebElement Accname;
	
	@FindBy(xpath="//button[@class='slds-button slds-button_brand']")
	WebElement save;
	
	@FindBy(xpath="//input[@class='slds-combobox__input slds-input']")
	WebElement parentaccName;
	
	@FindBy(xpath="//lightning-formatted-text[@class='custom-truncate']")
	WebElement verifyaccName;
	
	
	public AccountPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void newaccount(String AccountName,String ChildAccountName) throws InterruptedException {

        TestBase.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        JavascriptExecutor js=(JavascriptExecutor)TestBase.driver;
        js.executeScript("arguments[0].click();",Acc);

        newacc.click();

        Accname.click();
        Accname.sendKeys(AccountName);
        save.click();
    }

 

public void addparentaccount(String AccountName,String ChildAccountName) throws InterruptedException {

    TestBase.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    JavascriptExecutor js=(JavascriptExecutor)TestBase.driver;
    js.executeScript("arguments[0].click();",Acc);

    newacc.click();

    Accname.click();
    Accname.sendKeys(ChildAccountName);

    parentaccName.click();
    Thread.sleep(5000);
    parentaccName.sendKeys(Keys.ARROW_DOWN);
    parentaccName.sendKeys(Keys.ARROW_DOWN);
    parentaccName.sendKeys(Keys.ENTER);

    save.click();
}
	
public String verifyaccname() {
	return verifyaccName.getText();
}
	

}
