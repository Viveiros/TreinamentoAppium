package br.com.serpro.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.serpro.appiumCore.BaseTest;
import br.com.serpro.pages.AbasPage;
import br.com.serpro.pages.MenuPage;

public class AbasTest extends BaseTest {
	private MenuPage menuPage = new MenuPage();
	private AbasPage abasPage = new AbasPage();

	@Test
	public void mudarDeAbas() {
		menuPage.acessarAbas();
		assertTrue(abasPage.existeElementoPorTexto("Este é o conteúdo da Aba 1"));
		abasPage.clicarAba2();
		assertTrue(abasPage.existeElementoPorTexto("Este é o conteúdo da Aba 2"));
		abasPage.clicarAba1();
		assertTrue(abasPage.existeElementoPorTexto("Este é o conteúdo da Aba 1"));		
	}

}
