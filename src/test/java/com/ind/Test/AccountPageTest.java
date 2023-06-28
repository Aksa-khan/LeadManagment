package com.ind.Test;

import com.ind.Base.TestBase;

import java.io.IOException;

import org.testng.Assert;
//import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.ind.Page.AccountPage;
import com.ind.Page.ContactPage;
import com.ind.Page.LoginPage;
import com.ind.Utilities.ExcelUtilities;

public class AccountPageTest extends TestBase {
	
	LoginPage loginpage;
	AccountPage accountpage;
	String websheet="Account";
	
	public AccountPageTest() {
		super();
	}
	
//	@BeforeMethod
//    public void login() throws InterruptedException
//    {
//        
//        launch();
//        loginpage=new LoginPage();
//        accountpage = new AccountPage();
//        loginpage.login(p.getProperty("username1"),p.getProperty("Password1"));
////        Assert.assertEquals(loginpage.loginverify(),"Setup","Login fail");
////        System.out.println("Assertion pass");    
//        }
	@Parameters("browser")
	//@BeforeMethod
	@BeforeTest
    public void login(String browser) throws InterruptedException
    {
        
        launch(browser);
        loginpage=new LoginPage();
        accountpage = new AccountPage();
        loginpage.login(p.getProperty("username1"),p.getProperty("Password1"));
        //loginpage.llogin();
//        Assert.assertEquals(loginpage.loginverify(),"Setup","Login fail");
//        System.out.println("Assertion pass");    
        }
	
	
	@DataProvider
    public Object getAccount() {
        Object[][] obj1=ExcelUtilities.getExcel(websheet);
        return obj1;
    }
	
	@Test(priority = 2,dataProvider="getAccount")
    public void createAcc(String AccountName,String ChildAccountName) throws InterruptedException, IOException
    {
        accountpage.newaccount(AccountName,ChildAccountName);
        Assert.assertEquals(accountpage.verifyaccname(),AccountName,"Account Creation failed");
        System.out.println("Assertion Pass");

    }

 @Test(priority = 1,dataProvider="getAccount")
    public void addparentacc(String AccountName,String ChildAccountName) throws InterruptedException, IOException
    {

        accountpage.addparentaccount(AccountName,ChildAccountName);
        System.out.println("Added parent account");
    }
	
	 @AfterMethod
	  public void teardown() throws IOException
	   {
	       driver.close();
	        //takeScreenshotAtEndOfTest("company creation");
	    }

}
