package appobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CustomerAppObject {
	private WebDriver driver;
	
	public CustomerAppObject (WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getBootstrapCombobox() {
		return driver.findElement(By.id("switch-version-select"));
	}
	
	public WebElement getBootstrapV4Select() {
		return driver.findElement(By.xpath("//option[text()='Bootstrap V4 Theme']"));
	}
	
	public WebElement getAddCustomerButton() {
		return driver.findElement(By.cssSelector("div.floatL.t5 a"));
	}
	
	public WebElement getCampoNomeTextField() {
		return driver.findElement(By.id("field-customerName"));
	}
	
	public WebElement getCampoSobrenomeTextFiels() {
		return driver.findElement(By.id("field-contactLastName"));
	}
	
	public WebElement getCampoNomeContatoTextField() {
		return driver.findElement(By.id("field-contactFirstName"));
	}
	
	public WebElement getCampoPhoneTextField() {
		return driver.findElement(By.id("field-phone"));
	}
	
	public WebElement getAddressOneTextField() {
		return driver.findElement(By.id("field-addressLine1"));
	}
	
	public WebElement getAddressTwoTextField() {
		return driver.findElement(By.id("field-addressLine2"));
	}
	
	public WebElement getCityTextField() {
		return driver.findElement(By.id("field-city"));
	}
	
	public WebElement getStateTextField() {
		return driver.findElement(By.id("field-state"));
	}
	
	public WebElement getPostalCodeTextField() {
		return driver.findElement(By.id("field-postalCode"));
	}
	
	public WebElement getCountryTextField() {
		return driver.findElement(By.id("field-country"));
	}
	
	public WebElement getEmployeerCombobox() {
		return driver.findElement(By.cssSelector("#field_salesRepEmployeeNumber_chosen a div b"));
	}
	
	public WebElement getCreditLimit() {
		return driver.findElement(By.id("field-creditLimit"));
	}
	
	public WebElement getSaveButton() {
		return driver.findElement(By.id("form-button-save"));
	}
	
	public WebElement getValidarLabel() {
		return driver.findElement(By.cssSelector("div#report-success > p"));
	}
}
