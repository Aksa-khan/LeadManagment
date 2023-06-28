package com.ind.Test;

import com.ind.Base.TestBase;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ind.Page.ContactPage;
import com.ind.Page.LeadPage;
import com.ind.Page.LoginPage;
import com.ind.Utilities.ExcelUtilities;

public class ContactPageTest extends TestBase {
	
	LoginPage loginpage;
	ContactPage contactpage;
	String websheet="Contact";
	
	public ContactPageTest() {
		super();
	}
	
	@Parameters("browser")
	//@BeforeMethod
	@BeforeTest
    public void login(String browser) throws InterruptedException
    {
        
        launch(browser);
        loginpage=new LoginPage();
        contactpage=new ContactPage();
        loginpage.login(p.getProperty("username1"),p.getProperty("Password1"));
        //loginpage.llogin();
//        Assert.assertEquals(loginpage.loginverify(),"Setup","Login fail");
//        System.out.println("Assertion pass");    
        }
	
	@DataProvider
    public Object getContact() {
        Object[][] obj1=ExcelUtilities.getExcel(websheet);
        return obj1;
    }
	
	 @Test(dataProvider="getContact")
	    public void createcontact(String fname, String lname) throws InterruptedException, IOException
	    {
		    contactpage.newcontact(fname, lname);
		    System.out.println("Contact Created");
		    //String fullname="Ms. "+fname+" "+lname;
	    //	Assert.assertEquals(contactpage.verifycontactname(),fullname,"Contact Creation failed");
	        //System.out.println("Assertion Pass");
	        
	    }
	 
//	@AfterMethod
//	 //@AfterClass
//	  public void teardown() throws IOException
//	   {
//	       //driver.close();
//	        //takeScreenshotAtEndOfTest("company creation");
//	    }
//	 
//	


}
