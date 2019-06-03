package br.com.serpro.pages;

import br.com.serpro.appiumCore.BasePage;

public class AccordionPage extends BasePage {
	public void clicarOpcao(int num) {
		clicarPorTexto("Opção "+ num);
	}
}
