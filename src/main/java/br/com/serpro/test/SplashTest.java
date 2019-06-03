package br.com.serpro.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.serpro.appiumCore.BaseTest;
import br.com.serpro.pages.MenuPage;
import br.com.serpro.pages.SplashPage;

public class SplashTest extends BaseTest{
	
	private MenuPage menu = new MenuPage();
	private SplashPage splashPage = new SplashPage();
	
	@Test
	public void deveAguardarSplash() {
	
		menu.acessarSplash();
		splashPage.isTelaSplashVisivel();
		splashPage.aguardarSplashSumir();
		Assert.assertTrue(splashPage.existeElementoPorTexto("Formulário"));
	}

}
