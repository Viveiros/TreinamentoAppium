package br.com.serpro.pages;

import br.com.serpro.appiumCore.BasePage;
import io.appium.java_client.MobileBy;

public class MenuPage extends BasePage{
	

	public void acessarFormulario() {
		clicar(MobileBy.xpath("//android.widget.TextView[@text='Formul�rio']"));
	}

}
