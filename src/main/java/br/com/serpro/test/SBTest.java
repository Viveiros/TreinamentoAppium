package br.com.serpro.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.com.serpro.appiumCore.BaseTest;
import br.com.serpro.pages.MenuPage;
import br.com.serpro.pages.SBAbasPage;
import br.com.serpro.pages.SBContasPage;
import br.com.serpro.pages.SBLoginPage;

public class SBTest extends BaseTest {
	private MenuPage menuPage = new MenuPage();
	private SBLoginPage loginPage = new SBLoginPage();
	private SBAbasPage abasPage = new SBAbasPage();
	private SBContasPage contasPage = new SBContasPage();
	
	@Before
	public void login() {
		menuPage.acessarSeuBarrigaNativo();
		loginPage.logar();
	}
	@Test
	public void inserirConta() {
		abasPage.clicarAbaContas();
		contasPage.preencherConta("Conta01");
		contasPage.salvar();
		Assert.assertTrue(contasPage.existeElementoPorTexto("Conta adicionada com sucesso"));
	}	
	@Test
	public void excluirConta() {
		abasPage.clicarAbaContas();
		contasPage.cliqueLongo(By.xpath("//android.widget.TextView[@text='Conta mesmo nome']"));
		contasPage.excluir();
		Assert.assertTrue(contasPage.existeElementoPorTexto("Conta excluída com sucesso"));
	}		
}
