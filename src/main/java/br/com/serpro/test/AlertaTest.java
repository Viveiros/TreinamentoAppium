package br.com.serpro.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.serpro.appiumCore.BaseTest;
import br.com.serpro.pages.AlertaPage;
import br.com.serpro.pages.MenuPage;

public class AlertaTest extends BaseTest{
	private MenuPage menuPage = new MenuPage();
	private AlertaPage alertaPage = new AlertaPage();

	@Test
	public void deveConfirmarAlert() {
		menuPage.acessarAlerta();
		alertaPage.clicarAlertaConfirm();
		Assert.assertEquals("Info", alertaPage.obterTextoTitulo());
		Assert.assertEquals("Confirma a operação?", alertaPage.obterMensagem());
		alertaPage.clicarConfirmar();
		Assert.assertEquals("Info", alertaPage.obterTextoTitulo());
		Assert.assertEquals("Confirmado", alertaPage.obterMensagem());
		alertaPage.clicarSair();
		Assert.assertTrue(alertaPage.existeElementoPorTexto("Alerta de confirmação"));
		
	}

}
