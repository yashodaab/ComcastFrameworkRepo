package com.comcast.crm.contactTest;

import com.comcast.crm.basetest.BaseClass;

public class CreateContactWithSupportDateTest extends BaseClass{
	@Test

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
