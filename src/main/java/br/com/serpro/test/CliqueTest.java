package br.com.serpro.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.serpro.appiumCore.BaseTest;
import br.com.serpro.pages.CliquesPage;
import br.com.serpro.pages.MenuPage;

public class CliqueTest extends BaseTest {
	
	MenuPage menu = new MenuPage();
	CliquesPage cliquesPage = new CliquesPage();
	
	@Test
	public void cliqueLongo() {
		menu.acessarCliques();
		cliquesPage.cliqueLongo();
		Assert.assertEquals("Clique Longo", cliquesPage.obterTextoCampo());
	}
	@Test
	public void cliqueDuplo() {
		menu.acessarCliques();
		cliquesPage.clicarPorTexto("Clique duplo");
		cliquesPage.clicarPorTexto("Clique duplo");
		Assert.assertEquals("Duplo Clique", cliquesPage.obterTextoCampo());
	}
}
