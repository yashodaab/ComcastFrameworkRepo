package com.comcast.crm.objectrepositoryutility;

public class OrganizationsPage {
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement CreateNewOrgBtn;
	
	
	@FindBy(name = "search_text")
	private WebElement searchEdt;
	
	@FindBy(name = "submit")
	private WebElement SearchBtn;
	
	@FindBy(name = "search_field")
	private WebElement SearchDD;
	
	public OragnizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getCreateNewOrgBtn() {
		return CreateNewOrgBtn;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchBtn() {
		return SearchBtn;
	}

	public WebElement getSearchDD() {
		return SearchDD;
	}

}
