package com.comcast.crm.objectrepositoryutility;

public class OrganizationInfoPage {
	@FindBy(className = "dvHeaderText")
	private WebElement headerMsg;
	
	@FindBy(id = "mouseArea_Organization Name")
	private WebElement headerOrgName;
	
	@FindBy(id = "mouseArea_Industry")
	private WebElement headerIndstry;
	
	@FindBy(id = "mouseArea_Type")
	private WebElement headerTypeName;
	
	@FindBy(id = "dtlview_Phone")
	private WebElement headerPhoneNo;
	
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getHeaderMsg() {
		return headerMsg;
	}
    
	public WebElement getHeaderOrgName() {
		return headerOrgName;
	}

	public WebElement getHeaderIndstry() {
		return headerIndstry;
	}

	public WebElement getHeaderTypeName() {
		return headerTypeName;
	}

	public WebElement getHeaderPhoneNo() {
		return headerPhoneNo;
	}

}
