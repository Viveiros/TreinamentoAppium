package br.com.serpro.test;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

import br.com.serpro.appiumCore.BaseTest;
import br.com.serpro.pages.MenuPage;
import br.com.serpro.pages.SwipePage;

public class SwipeTest extends BaseTest {
	MenuPage menuPage = new MenuPage();
	SwipePage swipePage = new SwipePage();

	@Test
	public void testarSwipe(){
		menuPage.acessarSwipe();
		Assert.assertTrue(swipePage.existeElementoPorTexto("Mova a tela para"));
		Assert.assertTrue(swipePage.existeElementoPorTexto("a esquerda"));
		swipePage.swipeLeft();
		Assert.assertTrue(swipePage.existeElementoPorTexto("E veja se"));
		swipePage.clicarPorTexto("›");
		Assert.assertTrue(swipePage.existeElementoPorTexto("Chegar até o fim!"));
		swipePage.swipeRigth();
		swipePage.clicarPorTexto("‹");
		Assert.assertTrue(swipePage.existeElementoPorTexto("a esquerda"));
		
	}
}
