/*@author: Cristian Mira
 * Esta clase es la encargada de dar tiempos de espera a las solicitudes realizadas en otras 
 * clases
 * */

package automationwebdriver.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public  class TiempoPruebas  {
	
	WebDriver driver;
	
	public TiempoPruebas(WebDriver driver) {

		this.driver = driver;
	}

	public  void tiempoElemento(WebElement elemento) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		//ExpectedConditions.. es una espera explicita.. en este caso espera a que sea visible
		//el elemento enviado hasta que se cumpla el "timeout"de 5
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(elemento)));	
		wait.until(ExpectedConditions.visibilityOf(elemento));
	}
	
	
	public  void tiempoPresencia (WebElement elemento) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		//wait.until(ExpectedConditions.presenceOfElementLocated(elemento));
		wait.until(ExpectedConditions.elementToBeClickable(elemento));
	}
	
	public  void tiempoAlerta () {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public  void tiempoSegundos (long segundos) {
		
		try {
		
			Thread.sleep(TimeUnit.MILLISECONDS.convert(segundos, TimeUnit.SECONDS));
			
		} catch (Exception e) {
			
			System.err.println("Error en la espera "+e);
		
		}

	}
	
	
	/* Creado en Octubre 26, 2017
	 * 
	 * @autor Cristian Mira
	 * 
	 * Método que retorna valor true
	 * en caso de existir alertas 
	 * cuando este es invocado
	*/
	
	public  boolean validarPresentaAlerta() {
		boolean alertaPresent; 
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			Alert alerta = wait.until(ExpectedConditions.alertIsPresent());
			
			if (alerta!=null) {
				alertaPresent= true;
			}
			else{
				System.out.println("No Hay alerta");
				alertaPresent= false;
			}
			
		return alertaPresent;

		} catch (Exception e) {
			return false;
			// TODO: handle exception
		}
		
		
		
		
	}
	
	/* Creado en Octubre 26, 2017
	 * 
	 * @autor Cristian Mira
	 * 
	 * Método que da clic
	 * sobre las alertas que se presenten
	 *  cuando este es invocado
	*/
	
	public void SetClickAlerta(){
		
		boolean alert=validarPresentaAlerta();
		
		while (alert) {	
				driver.switchTo().alert().accept();		
				alert=validarPresentaAlerta();
		}
	}
	
}
