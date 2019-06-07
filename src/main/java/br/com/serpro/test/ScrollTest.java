package br.com.serpro.test;

import org.junit.Test;

import br.com.serpro.appiumCore.BaseTest;
import br.com.serpro.pages.MenuPage;

public class ScrollTest extends BaseTest {
	
	MenuPage menuPage = new MenuPage();
	
	@Test
	public void escolherOpcaoEscondida() {
		
		menuPage.scroll(0.8, 0.1);
		esperar(1000);
		menuPage.clicarPorTexto("Op��o bem escondida");
//		menuPage.existeElementoPorTexto("Voc� achou essa op��o");
//		menuPage.clicarPorTexto("OK");
	}
}
