package br.com.serpro.pages;

import static br.com.serpro.appiumCore.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.serpro.appiumCore.BasePage;
import br.com.serpro.appiumCore.DriverFactory;
import io.appium.java_client.MobileBy;

public class MenuPage extends BasePage{
	

	public void acessarFormulario() {
		clicarPorTexto("Formulário");
	}
	public void acessarSplash() {
		clicarPorTexto("Splash");
	}	
	public void acessarSwipe() {
		clicarPorTexto("Swipe");
	}	
	public void acessarAlerta() {
		clicarPorTexto("Alertas");
	}
	public void acessarAbas() {
		clicarPorTexto("Abas");
	}
	public void acessarAccordion() {
		clicarPorTexto("Accordion");
	}
	public void acessarCliques() {
		clicarPorTexto("Cliques");
	}
	public void acessarDragNDrop() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
		scrollDown();
		clicarPorTexto("Drag and drop");
	}
}
