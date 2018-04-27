package automationwebdriver.test;

import org.junit.Test;


import automationwebdriver.common.BaseClass;
import automationwebdriver.pages.AgregarDoctorPage;
import junit.framework.Assert;

public class IngresoDoctorTest extends BaseClass{
	
	
	
	@Test
	public void ingresarDoctorTest() throws InterruptedException{
		
		//Se abre la página de prueba
		driver.get(urlBase);
		// Se maximiza la página
		driver.manage().window().maximize();
		
		AgregarDoctorPage AgregarDoctorPage= new AgregarDoctorPage(driver);
		
		AgregarDoctorPage.ingresarAregistroDoctor();
	
		AgregarDoctorPage.ingresarInfoDoctor();
		
		Assert.assertEquals("Guardado", AgregarDoctorPage.getMensajeConfirmacion());
		
	}
	

}
