package com.comcast.crm.contactTest;

import com.comcast.crm.basetest.BaseClass;

public class CreateContactWithOrgTest extends BaseClass{
	@Test

	public void createContactWithOrgTest() throws Throwable {
		
		// create object
		JavaUtility jlib = new JavaUtility();

		// read testscript data fromexcel file
		String orgName = elib.getDataFromExcel("org", 7, 2) + jlib.getRandonNumber();
		// String contactlastname = elib.getDataFromExcel("contact", 7, 3);
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

}
