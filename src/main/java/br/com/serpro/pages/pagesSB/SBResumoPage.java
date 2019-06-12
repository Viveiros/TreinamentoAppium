package br.com.serpro.pages.pagesSB;

import static br.com.serpro.appiumCore.DriverFactory.getDriver;

import org.openqa.selenium.By;

import br.com.serpro.appiumCore.BasePage;
import io.appium.java_client.MobileElement;

public class SBResumoPage extends BasePage {
	
	public void excluirMovimentacao(String conta) {
		MobileElement el = (MobileElement) getDriver().findElement(By.xpath("//*[@text='"+conta+"']/.."));
		swipeElment(el, 0.9, 0.1);
		clicarPorTexto("Del");
	}
}
