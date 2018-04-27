package automationwebdriver.common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageScroll {



	WebDriver driver;
	
	public PageScroll(WebDriver driver){
		
		this.driver=driver;
	}
	
	/* Creado en Octubre 24, 2017
	 * 
	 * @autor Cristian Mira
	 * 
	 * 	  
	 * Método que hace scroll hasta visualizar
	 * el elemento enviado como parámetro
	*/
	
	public void scrollingToElemento(WebElement elemento) {
		try {
			
			((JavascriptExecutor) driver).executeScript(
	                "arguments[0].scrollIntoView();", elemento);
			
		} catch (Exception e) {
			System.err.println("Error en la clase"+PageScroll.class+" " +e);
		}
		
	}
	
	/* Creado en Octubre 24, 2017
	 * 
	 * @autor Cristian Mira
	 * 
	 * 	  
	 * Método que hace scroll y va 
	 * al final de la página donde sea invocado
	*/
	
	public void scrollingToBottomOfPaga(){
		
		try {
			((JavascriptExecutor)driver)
			.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			
		} catch (Exception e) {
			System.err.println("Error en la clase"+PageScroll.class+" " +e);
			
		}
	}
	
	/* Creado en Octubre 24, 2017
	 * 
	 * @autor Cristian Mira
	 * 
	 * 	  
	 * Método que hace scroll y va 
	 * al inicio de la página donde sea invocado
	*/
		public void scrollingToUp() {
			
			try {
				((JavascriptExecutor)driver)
				.executeScript("window.scrollTo(0,0);");
				
			} catch (Exception e) {
				System.err.println("Error en la clase"+PageScroll.class+" " +e);
				
			}
			
		}	
		
		
	}
	
	

