package automationwebdriver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import automationwebdriver.common.PageScroll;

public class AgregarDoctorPage {
	
	//Se instancia el objeto driver
	WebDriver driver;
	
	/**
	 * Método constructor
	 * Este método recibe el driver que se usará en la ejecución 
	 * de los pasos de la prueba
	 * @author Usuario
	 *
	 * @param driver
	 */
	public AgregarDoctorPage(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
		
		
	}
	
	
	/**
	 * De aqui en adelante se declaran los elementos de la página web
	 * 
	 */
	//PAGEFACTORY
	@FindBy(linkText="Agregar Doctor")
	WebElement btnAgregarDoctor;
	
	@FindBy(id="name")
	WebElement txtNombre;
	
	@FindBy(id="telephone")
	WebElement txtTelefono;
	
	@FindBy(id="identification_type")
	WebElement listTipoDoc;
	
	@FindBy(id="identification")
	WebElement txtNumDoc;
	
	@FindBy(linkText="Guardar")
	WebElement btnGuardar;
	
	@FindBy(xpath="//*[@id='page-wrapper']/div/div[2]/div[1]/h3")
	WebElement msjConfirmacion;
	
	//POM
	By txtApellido =  By.id("last_name");
	
	
	
	
	
	/**
	 * Método ingresarSesionTshirt
	 * Este método se encarga de ingresar a la sesion de crear doctores
	 * @throws InterruptedException 
	 * 
	 */
	public void ingresarAregistroDoctor(){
		try {
			btnAgregarDoctor.click();
		} catch (Exception e) {
			System.err.println("Este es el error: "+e);
			// TODO: handle exception
		}
		
		
		
		
	}
	
	public void ingresarInfoDoctor(){
		
		try {
			
			
			//Acceder a objeto con pagefactory
			txtNombre.sendKeys("Cristian");
			
			txtTelefono.sendKeys("3000303030303");
			
			Select listTDoc = new Select(listTipoDoc);
			listTDoc.selectByIndex(0);
			txtNumDoc.sendKeys("1099549495");
			//Acceder a objeto con POM
			driver.findElement(txtApellido).sendKeys("Mira");
			btnGuardar.click();
			Thread.sleep(3000);
			
			
			
			
		} catch (Exception e) {
			
			System.err.println("Este es el error: "+e);
			// TODO: handle exception
		}
		
	}
	
	
	public String getMensajeConfirmacion(){
		
		return msjConfirmacion.getText();
		
	}
	
	
	
	
	

}
