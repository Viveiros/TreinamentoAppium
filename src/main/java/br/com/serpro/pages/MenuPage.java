package br.com.serpro.pages;

import br.com.serpro.appiumCore.BasePage;
import io.appium.java_client.MobileBy;

public class MenuPage extends BasePage{
	

	public void acessarFormulario() {
		clicarPorTexto("Formul�rio");
	}
	public void acessarSplash() {
		clicarPorTexto("Splash");
	}	

}
