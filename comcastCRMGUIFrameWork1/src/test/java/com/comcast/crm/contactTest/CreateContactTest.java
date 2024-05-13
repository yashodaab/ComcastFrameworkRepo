package com.comcast.crm.contactTest;

import com.comcast.crm.basetest.BaseClass;

public class CreateContactTest extends BaseClass{
	@Test
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

	}

}
