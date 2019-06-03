package br.com.serpro.appiumCore;

import static br.com.serpro.appiumCore.DriverFactory.getDriver;

import org.openqa.selenium.By;

public class BasePage {
	public void escrever(By by, String texto) {
	    getDriver().findElement(by).sendKeys(texto);
	}
	
	public String obterTexto(By by){
		return getDriver().findElement(by).getText();
	}

	public void clicar(By by) {
		getDriver().findElement(by).click();
	}
	
	public void clicarPorTexto(String texto) {
	    getDriver().findElement(By.xpath("//*[@text='"+texto+"']")).click();
	}
	
	public void selecionarCombo(By by, String texto) {
		getDriver().findElement(by).click();
		clicarPorTexto(texto);
	}
	
	public boolean isCheckMarcado(By by) {
		return getDriver().findElement(by).getAttribute("checked").equals("true");
	}
}
