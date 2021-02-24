package org.reusable;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtilities {

	public WebDriver getDriver(String location) {
		System.setProperty("wedriver.chrome.driver", location);
		WebDriver driver = new ChromeDriver();
		return driver;
	}

	public void loadUrl(WebDriver driver, String url) {
		driver.get(url);
	}

	public void quiteBrowser(WebDriver driver) {
		driver.quit();
	}

	public void closeBrowser(WebDriver driver) {
		driver.close();
	}

	public void getCurrentUrl(WebDriver driver) {
		driver.getCurrentUrl();
	}

	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void getTitle(WebDriver driver) {
		driver.getTitle();
	}

	public void findElementById(WebDriver driver, String id) {
		driver.findElement(By.id(id));
	}

	public void findElementByName(WebDriver driver, String name) {
		driver.findElement(By.name(name));
	}

	public void findElementByXpath(WebDriver driver, String locator) {
		driver.findElement(By.xpath(locator));
	}

	public void typeIn(WebElement element, String data) {
		element.sendKeys(data);
	}

	public void btnClick(WebElement element) {
		element.click();
	}

	public String getTextUsingId(WebDriver driver, String locator) {
		String Text = driver.findElement(By.id(locator)).getText();
		return Text;
	}

	public String getTextUsingName(WebDriver driver, String locator) {
		String Text = driver.findElement(By.name(locator)).getText();
		return Text;
	}

	public String getTextUsingXpath(WebDriver driver, String objLocator) {
		String Text = driver.findElement(By.xpath(objLocator)).getText();
		return Text;
	}

	public String getAttributeValueUsingId(WebDriver driver, String locator, String tagName) {
		String Text = driver.findElement(By.id(locator)).getAttribute(tagName);
		return Text;
	}
	
	public String getAttributeValueUsingName(WebDriver driver, String locator,String attribute) {
		String Text = driver.findElement(By.name(locator)).getAttribute(attribute);
		return Text;
	}

	public String getAttributeValueUsingXpath(WebDriver driver, String objLocator, String attribute) {
		String Text = driver.findElement(By.xpath(objLocator)).getAttribute(attribute);
		return Text;
	}

	public void switchToFrameByIndex(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	public void switchToFrameByName(WebDriver driver, String name) {
		driver.switchTo().frame(name);
	}

	public void switchToDefaultFrame(WebDriver driver, WebElement element) {
		driver.switchTo().defaultContent();
	}

	public void switchToFrameByName(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	public Boolean isEnable(WebDriver driver, String objLocator) {
		boolean textBox = driver.findElement(By.xpath(objLocator)).isEnabled();
		return textBox;
	}

	public Boolean isDisplayed(WebDriver driver, String objLocator) {
		boolean textBox = driver.findElement(By.xpath(objLocator)).isDisplayed();
		return textBox;
	}

	public Boolean isSelected(WebDriver driver, String objLocator) {
		boolean textBox = driver.findElement(By.xpath(objLocator)).isSelected();
		return textBox;
	}

	public Dimension getSize(WebDriver driver, String objLocator) {
		Dimension size = driver.findElement(By.xpath(objLocator)).getSize();
		return size;
	}

	public void selectByVisibleText(WebDriver driver,String objLocator, String locator, String text) {
		WebElement mySelectedElement = driver.findElement(By.id(locator));
		Select dropdown= new Select(mySelectedElement);
		dropdown.selectByVisibleText(text);
	}

	public void selectByVisibleValue(WebDriver driver,String objLocator, String locator, String value) {
		WebElement mySelectedElement = driver.findElement(By.id(locator));
		Select dropdown= new Select(mySelectedElement);
		dropdown.selectByValue(value);
	}

	public void selectByIndexNumber(WebDriver driver,String objLocator, String locator, int index) {
		WebElement mySelectedElement = driver.findElement(By.id(locator));
		Select dropdown= new Select(mySelectedElement);
		dropdown.selectByIndex(index);
	}

	public void deSelectByVisibleText(WebDriver driver,String objLocator, String locator, String text) {
		WebElement mySelectedElement = driver.findElement(By.id(locator));
		Select dropdown= new Select(mySelectedElement);
		dropdown.deselectByVisibleText(text);
	}

	public void deSelectByVisibleValue(WebDriver driver,String objLocator, String locator, String value) {
		WebElement mySelectedElement = driver.findElement(By.id(locator));
		Select dropdown= new Select(mySelectedElement);
		dropdown.deselectByValue(value);
	}

	public void deSelectByIndexNumber(WebDriver driver,String objLocator, String locator, int index) {
		WebElement mySelectedElement = driver.findElement(By.id(locator));
		Select dropdown= new Select(mySelectedElement);
		dropdown.deselectByIndex(index);
	}

	public void navigateBack(WebDriver driver) {
		driver.navigate().back();
	}

	public void navigateForword(WebDriver driver) {
		driver.navigate().forward();
	}

	public void navigateTo(WebDriver driver, String locator) {
		driver.navigate().to(locator);
	}

	public void takeScreenShotAsFile(WebDriver driver,String location) throws IOException {
		File shot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(shot, new File(location));
	}

	public void moveToElement(WebDriver driver,String location) {
		Actions actions = new Actions(driver);
		WebElement mouseHover = driver.findElement(By.xpath(location));
		actions.moveToElement(mouseHover);
		actions.perform();
	}

	public void dragAndDrop(WebDriver driver,String fromLocation,String toLocation) {
		WebElement sourceLocator = driver.findElement(By.xpath(fromLocation));
		WebElement destinationLocator = driver.findElement(By.xpath(toLocation));
		Actions actions=new Actions(driver);
		actions.dragAndDrop(sourceLocator, destinationLocator).build().perform();
	}

	public void switchToAlert(WebDriver driver) {
		driver.switchTo().alert();
	}

	public void alertAccept(WebDriver driver) {
		Alert alert = (Alert) driver;
		alert.accept();
	}
	public void dismissAccept(WebDriver driver) {
		Alert alert = (Alert) driver;
		alert.dismiss();
	}
	public void sendTextToAlert(WebDriver driver, String value) {
		Alert alert = (Alert) driver;
		alert.sendKeys(value);
	}

	public void threadsleep(long time) throws InterruptedException {
		Thread.sleep(time);
	}

	public void driverWaitBySeconds(WebDriver driver, int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public void elementWaitBySeconds(WebDriver driver, String locator) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}
}
