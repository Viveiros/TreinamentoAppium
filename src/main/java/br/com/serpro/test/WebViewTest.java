package br.com.serpro.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.serpro.appiumCore.BaseTest;
import br.com.serpro.pages.MenuPage;
import br.com.serpro.pages.WebViewPage;


public class WebViewTest extends BaseTest {
	MenuPage menuPage = new MenuPage();
	WebViewPage WVPage = new WebViewPage();
	
	@Test
	public void deveFazerLogin() {
		menuPage.acessarSeuBarrigaHibrido();
		esperar(3000);
		WVPage.entrarContexto();
		WVPage.setEmail("andreviveiros@hotmail.com");		
		WVPage.setPass("12345");
		WVPage.entrar();
		esperar(3000);
		Assert.assertEquals("Bem vindo, Viveiros!", WVPage.verificarLogin());
	}
	
}
