package com.comcast.crm.orgTest;

import com.comcast.crm.basetest.BaseClass;

public class CreateOrganizationWithPhoneNum extends BaseClass{
	@Test

	public void createOrganizationWithPhoneNum() throws Throwable {

		// read testscript data from excel file
		String orgName = elib.getDataFromExcel("org", 7, 2) + jlib.getRandonNumber();
		String phonenumber = elib.getDataFromExcel("org", 7, 3);

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		OragnizationsPage op = new OragnizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrgWithPhoneNo(orgName, phonenumber);

		// verify header phone num info and expected result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actphonenumber = oip.getHeaderPhoneNo().getText();
		if (actphonenumber.contains(phonenumber)) {
			System.out.println(phonenumber + "info is created==pass");
		} else {
			System.out.println(phonenumber + "info is notcreated==fail");
		}

	}


}
