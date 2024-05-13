package com.comcast.crm.contactTest;

import com.comcast.crm.basetest.BaseClass;

public class CreateContTest extends BaseClass{
	@Test//(groups="smokeTest")
	public void createContactTest() throws Throwable {

		// read testscript data from excelfile
		String lastname = elib.getDataFromExcel("contact", 1, 2) + jlib.getRandonNumber();

		// step2 navigate to contact module
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		// step3 click on create contact button
		ContactPage cp = new ContactPage(driver);
		cp.getCreateContactLookUpBtn().click();

		// step4 enter all the details and create new contact
		CreatingNewContactPage ccp = new CreatingNewContactPage(driver);
		ccp.createContactWithLastName(lastname);

		// verify header phonenumber info expected result
		ContactInfoPage cip = new ContactInfoPage(driver);
		String actlastname = cip.getHeaderLastname().getText();
		if (actlastname.contains(lastname)) {
			System.out.println(lastname + "info is verified==pass");
		} else {
			System.out.println(lastname + "info is notverified==fail");
		}
		Assert.assertEquals(lastname, actlastname);

	}
	
	@Test(groups = "regressionTest")

	public void createContactWithOrgTest() throws Throwable {
		
		// create object
		JavaUtility jlib = new JavaUtility();

		// read testscript data fromexcel file
		String orgName = elib.getDataFromExcel("org", 7, 2) + jlib.getRandonNumber();
		String lastname = elib.getDataFromExcel("contact", 1, 2) + jlib.getRandonNumber();

		//step2 navigate to the contact module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		//step3 click on create organization button
		OragnizationsPage orp = new OragnizationsPage(driver);
		orp.getCreateNewOrgBtn().click();
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName);

		// verify header msg Expected Result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actorgname = oip.getHeaderMsg().getText();
		if (actorgname.contains(orgName)) {
			System.out.println(orgName + "is created==pass");
		} else {
			System.out.println(orgName + "is notcreated==fail");
		}

		hp.getContactLink().click();

		ContactPage cp = new ContactPage(driver);
		cp.getCreateContactLookUpBtn().click();

		CreatingNewContactPage ccp = new CreatingNewContactPage(driver);
		ccp.getLastnameEdt().sendKeys(lastname);
		ccp.getChooseOrgFromLookUp().click();

		// switch to child browser
		wlib.switchToTabOnURL(driver, "module=Accounts");
		OrganizationPopup orpop = new OrganizationPopup(driver);
		orpop.getSearchEdt().sendKeys(orgName);
		orpop.getSearchBtnEdt().click();
		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();

		// switch to parent window
		wlib.switchToTabOnURL(driver, "Contacts&action");
		ccp.getSaveBtnEdt().click();

		// verification
		ContactInfoPage cip = new ContactInfoPage(driver);
		String actlastname = cip.getHeaderLastname().getText();
		if (actlastname.contains(lastname)) {
			System.out.println(lastname + "is verified==pass");
		} else {
			System.out.println(lastname + "is notverified==fail");
		}

		// verification

		String actorgname1 = oip.getHeaderOrgName().getText();
		if (actorgname1.equals(orgName)) {
			System.out.println(orgName + "info is created==pass");
		} else {
			System.out.println(orgName + "info is notcreated==fail");
		}

	}
	
	@Test(groups = "regressionTest")

	public void createContactWithSupportDateTest() throws Throwable {

		// read testscript data from excel file
		String lastname = elib.getDataFromExcel("contact", 4, 2) + jlib.getRandonNumber();

		//step2 navigate to the contact module
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		//step3 click on create contact button
		ContactPage cp = new ContactPage(driver);
		cp.getCreateContactLookUpBtn().click();

		// capture current system date and after 30 days date
		String startdate = jlib.getSystemDateYYYYDDMM();
		String enddate = jlib.getRequiredDateYYYYDDMM(30);
		CreatingNewContactPage cnop = new CreatingNewContactPage(driver);
		cnop.createContactWithSupportDate(lastname, startdate, enddate);

		// verify startdate and enddate with expected result
		ContactInfoPage coni = new ContactInfoPage(driver);
		String actstartdate = coni.getHeaderstartDate().getText();
		System.out.println(actstartdate);
		if (actstartdate.contains(startdate)) {
			System.out.println(startdate + "info is verified==pass");
		} else {
			System.out.println(startdate + "info is notverified==fail");
		}

		String actenddate = coni.getHeaderendDate().getText();
		System.out.println(actenddate);
		if (actenddate.contains(enddate)) {
			System.out.println(enddate + "info is verified==pass");
		} else {
			System.out.println(enddate + "info is notverified==fail");
		}

	}

}
