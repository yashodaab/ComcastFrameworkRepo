package com.comcast.crm.orgTest;

import com.comcast.crm.basetest.BaseClass;

public class CreateOrganizationWithIndustryType extends BaseClass{
	@Test

	public void createOrganizationWithIndustriesType() throws Throwable {

		// read testscript data from excel file
		String orgName = elib.getDataFromExcel("org", 1, 2) + jlib.getRandonNumber();
		String industry = elib.getDataFromExcel("org", 4, 3);
		String type = elib.getDataFromExcel("org", 4, 4);

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		OragnizationsPage op = new OragnizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrgWithIndustryType(orgName, industry, type);

		// verify dropdown and type info
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actindustries = oip.getHeaderIndstry().getText();
		if (actindustries.contains(industry)) {
			System.out.println(industry + "is created==pass");
		} else {
			System.out.println(industry + "is notcreated==fail");
		}

		String acttype = oip.getHeaderTypeName().getText();
		if (acttype.contains(type)) {
			System.out.println(type + "info is created==pass");
		} else {
			System.out.println(type + "info is notcreated==fail");
		}

	}

}
