package com.comcast.crm.orgTest;

import com.comcast.crm.basetest.BaseClass;

public class CreateOrganizationTest extends BaseClass{
	@Test
	public void createOrganizationTest() throws Throwable {

		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		// read testscript data from excel file
		String orgName = elib.getDataFromExcel("org", 1, 2) + jlib.getRandonNumber();

		// step2 navigate to the organization module
		UtilityClassObject.getTest().log(Status.INFO, "navigate to org page");
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// step3 click on create organization button
		UtilityClassObject.getTest().log(Status.INFO, "navigate to create org page");
		OragnizationsPage op = new OragnizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		// step4 enter all the details and create new organization
		UtilityClassObject.getTest().log(Status.INFO, "create new org pagee");
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName);

		// verify header msg Expected Result
		UtilityClassObject.getTest().log(Status.INFO, "navigate to org page");
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String headerinfo = oip.getHeaderOrgName().getText();
//		if (headerinfo.contains(orgName)) {
//			System.out.println(orgName + "is created==pass");
//		} else {
//			System.out.println(orgName + "is notcreated==fail");
//		}
		Assert.assertEquals(orgName,headerinfo);

	}

}
