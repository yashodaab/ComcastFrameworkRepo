package com.comcast.crm.objectrepositoryutility;

public class ContactPage {
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement CreateContactLookUpBtn;
	
    public ContactPage(WebDriver driver)
    {
    	PageFactory.initElements(driver,this);
    }

	public WebElement getCreateContactLookUpBtn() {
		return CreateContactLookUpBtn;
	}
}
