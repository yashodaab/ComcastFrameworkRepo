package com.comcast.crm.orgTest;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.HomePage;

public class CreateOrgTest extends BaseClass{
	@Test//(groups="smokeTest")
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
		
		UtilityClassObject.getTest().log(Status.INFO, "navigate to org page");
		// verify header msg Expected Result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String headerinfo = oip.getHeaderOrgName().getText();
		boolean status = headerinfo.contains(orgName);
//		if (headerinfo.contains(orgName)) {
//			System.out.println(orgName + "is created==pass");
//		} else {
//			System.out.println(orgName + "is notcreated==fail");
//		}
		Assert.assertEquals(status, true);

	}
	
	@Test//(groups = "regressionTest")

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
		boolean status = actindustries.contains(industry);
//		if (actindustries.contains(industry)) {
//			System.out.println(industry + "is created==pass");
//		} else {
//			System.out.println(industry + "is notcreated==fail");
//		}
		Assert.assertEquals(status, true);

		String acttype = oip.getHeaderTypeName().getText();
		boolean status1 = acttype.contains(type);
//		if (acttype.contains(type)) {
//			System.out.println(type + "info is created==pass");
//		} else {
//			System.out.println(type + "info is notcreated==fail");
//		}
		Assert.assertEquals(status1, true);

	}
	
	@Test//(groups = "regressionTest")

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
		boolean status3 = actphonenumber.contains(phonenumber);
//		if (actphonenumber.contains(phonenumber)) {
//			System.out.println(phonenumber + "info is created==pass");
//		} else {
//			System.out.println(phonenumber + "info is notcreated==fail");
//		}
		Assert.assertEquals(status3, true);

	}

}
