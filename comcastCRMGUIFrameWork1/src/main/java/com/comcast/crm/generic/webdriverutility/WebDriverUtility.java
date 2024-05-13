package com.comcast.crm.generic.webdriverutility;

import java.util.Iterator;
import java.util.Set;

public class WebDriverUtility {
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void waitForElementPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void switchToTabOnURL(WebDriver driver, String partialurl) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();

		while (it.hasNext()) {
			String windowid = it.next();
			driver.switchTo().window(windowid);

			String acturl = driver.getCurrentUrl();
			if (acturl.contains(partialurl)) {
				break;
			}
		}
	}

	public void switchToTabOnTitle(WebDriver driver, String partialTile) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();

		while (it.hasNext()) {
			String windowid = it.next();
			driver.switchTo().window(windowid);

			String acturl = driver.getCurrentUrl();
			if (acturl.contains(partialTile)) {
				break;
			}
		}
	}

	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	public void switchToFrame(WebDriver driver, String nameId) {
		driver.switchTo().frame(nameId);
	}

	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void switchToAlertAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public void Select(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	public void Select(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	public void mouseMoveOnElement(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void doubleclick(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

}
