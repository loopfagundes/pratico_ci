package tasks;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import appobjects.CustomerAppObject;
import frameworks.utils.WaitElementFw;

public class CustomerTask {
	private WebDriver driver;
	private CustomerAppObject customerAppObject;
	
	public CustomerTask (WebDriver driver) {
		this.driver = driver;
		this.customerAppObject = new CustomerAppObject(driver);
	}
	
	public void mudarSelect() {
		customerAppObject.getBootstrapCombobox().click();
		customerAppObject.getBootstrapV4Select().click();
		customerAppObject.getAddCustomerButton().click();
	}
	
	public void cadastrarNome(String name, String sobrenome) {
		customerAppObject.getCampoNomeTextField().sendKeys(name);
		customerAppObject.getCampoSobrenomeTextFiels().sendKeys(sobrenome);
	}
	
	public void cadastrarContato(String nomeContato, String telefone) {
		customerAppObject.getCampoNomeContatoTextField().sendKeys(nomeContato);
		customerAppObject.getCampoPhoneTextField().sendKeys(telefone);
	}
	
	public void cadastrarEndereco(
			String endereco1, 
			String endereco2, 
			String city, 
			String state, 
			String postalCode, 
			String country) {
		customerAppObject.getAddressOneTextField().sendKeys(endereco1);
		customerAppObject.getAddressTwoTextField().sendKeys(endereco2);
		customerAppObject.getCityTextField().sendKeys(city);
		customerAppObject.getStateTextField().sendKeys(state);
		customerAppObject.getPostalCodeTextField().sendKeys(postalCode);
		customerAppObject.getCountryTextField().sendKeys(country);
	}
	
	public void empregadorClick() {
		customerAppObject.getEmployeerCombobox().click();
	}
	
	public void creditLimit(String limit) {
		customerAppObject.getCreditLimit().sendKeys(limit);
	}
	
	public void saveCadastrar() {
		customerAppObject.getSaveButton().click();
	}
	
	public void validarSucesso() {
		WaitElementFw.visibilityOf(driver, customerAppObject.getValidarLabel());
		String expected = "Your data has been successfully stored into the database. Edit Customer or Go back to list";
        String actual = customerAppObject.getValidarLabel().getText();
        Assert.assertEquals(expected, actual);
	}
}
