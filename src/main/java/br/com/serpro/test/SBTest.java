package br.com.serpro.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.com.serpro.appiumCore.BaseTest;
import br.com.serpro.pages.MenuPage;
import br.com.serpro.pages.pagesSB.SBAbasPage;
import br.com.serpro.pages.pagesSB.SBContasPage;
import br.com.serpro.pages.pagesSB.SBHomePage;
import br.com.serpro.pages.pagesSB.SBLoginPage;
import br.com.serpro.pages.pagesSB.SBMovimentacaoPage;
import br.com.serpro.pages.pagesSB.SBResumoPage;

public class SBTest extends BaseTest {
	private MenuPage menuPage = new MenuPage();
	private SBLoginPage loginPage = new SBLoginPage();
	private SBAbasPage abasPage = new SBAbasPage();
	private SBContasPage contasPage = new SBContasPage();
	private SBMovimentacaoPage movPage = new SBMovimentacaoPage();
	private SBHomePage homePage = new SBHomePage();
	private SBResumoPage resumoPage = new SBResumoPage();
	
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
	@Test
	public void deveValidarInclusaoMovimentacao() {
		abasPage.clicarAbaMov();
		movPage.salvar();
		Assert.assertTrue(movPage.existeElementoPorTexto("Descrição é um campo obrigatório"));
		
		movPage.setDescricao("Desc");
		movPage.salvar();
		Assert.assertTrue(movPage.existeElementoPorTexto("Interessado é um campo obrigatório"));

		movPage.setInteressado("Inte");
		movPage.salvar();
		Assert.assertTrue(movPage.existeElementoPorTexto("Valor é um campo obrigatório"));
		
		movPage.setValor("10");
		movPage.salvar();
		Assert.assertTrue(movPage.existeElementoPorTexto("Conta é um campo obrigatório"));
		
		movPage.setConta("Conta para saldo");
		movPage.salvar();
		Assert.assertTrue(movPage.existeElementoPorTexto("Movimentação cadastrada com sucesso"));
	}
	@Test
	public void deveAtualizarSaldoExcluindoMovimentacao() {
		Assert.assertEquals("534.00", homePage.obterSaldoConta("Conta para saldo"));
		abasPage.clicarAbaResumo();
		resumoPage.excluirMovimentacao("Movimentacao 3, calculo saldo");
		Assert.assertTrue(resumoPage.existeElementoPorTexto("Movimentação removida com sucesso!"));
		abasPage.clicarAbaHome();
		esperar(1000);
		abasPage.scroll(0.2, 0.9);
		Assert.assertEquals("-1000.00", homePage.obterSaldoConta("Conta para saldo"));
		
		
	}	
}
