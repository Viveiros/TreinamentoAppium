package br.com.serpro.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.serpro.appiumCore.BaseTest;
import br.com.serpro.pages.AccordionPage;
import br.com.serpro.pages.MenuPage;

public class AccordionTest extends BaseTest {
	private MenuPage menuPage = new MenuPage();
	private AccordionPage accordionPage = new AccordionPage();

	@Test
	public void selecionarAccordion() {
		menuPage.acessarAccordion();
		accordionPage.clicarOpcao(1);
		Assert.assertTrue(accordionPage.existeElementoPorTexto("Esta é a descrição da opção 1"));
		accordionPage.clicarOpcao(2);
		Assert.assertTrue(accordionPage.existeElementoPorTexto("Esta é a descrição da opção 2"));		
	}

}
