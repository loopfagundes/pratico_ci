package testcases;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import frameworks.utils.BaseTestFw;
import tasks.CustomerTask;


public class RunTestCase extends BaseTestFw {
	private WebDriver driver = getDriver();
	  private CustomerTask customerTask = new CustomerTask(driver);
	  
	  @Test
	  public void test() {
	        driver.get("https://www.grocerycrud.com/demo/bootstrap_theme");
	        customerTask.mudarSelect();
	        customerTask.cadastrarNome("Teste Sicredi", "Teste");
	        customerTask.cadastrarContato("Luciano", "51 9999-9999");
	        customerTask.cadastrarEndereco("Av Assis Brasil, 3970", "Torre D", "Porto Alegre", "RS", "91000-000", "Brasil");
	        customerTask.empregadorClick();
	        customerTask.creditLimit("200");
	        customerTask.saveCadastrar();
	        customerTask.validarSucesso();
	  }
}
