package br.com.serpro.pages.pagesSB;

import br.com.serpro.appiumCore.BasePage;

public class SBAbasPage extends BasePage {
	public void clicarAbaContas() {
		clicarPorTexto("CONTAS");
	}
	public void clicarAbaMov() {
		clicarPorTexto("MOV...");
	}
	public void clicarAbaResumo() {
		clicarPorTexto("RESUMO");
	}
	public void clicarAbaHome() {
		clicarPorTexto("HOME");
	}	
}
