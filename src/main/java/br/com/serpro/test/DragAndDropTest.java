package br.com.serpro.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.serpro.appiumCore.BaseTest;
import br.com.serpro.pages.DragAndDropPage;
import br.com.serpro.pages.MenuPage;

public class DragAndDropTest extends BaseTest {
	
	MenuPage menuPage = new MenuPage();
	DragAndDropPage dragAndDropPage = new DragAndDropPage();
	private String[] estadoInicial = new String[]{"Esta", "é uma lista", "Drag em Drop!", "Faça um clique longo,", "e arraste para", "qualquer local desejado."};
	private String[] estadoIntermediario = new String[]{"é uma lista", "Drag em Drop!", "Faça um clique longo,", "e arraste para", "Esta", "qualquer local desejado."};
	
	@Test
	public void DrogAndDropTest() {
		menuPage.acessarDragNDrop();
		esperar(1000);
		Assert.assertArrayEquals(estadoInicial, dragAndDropPage.obterLista());
		dragAndDropPage.arrastar("Esta", "e arraste para");
		Assert.assertArrayEquals(estadoIntermediario, dragAndDropPage.obterLista());
		
	}
}
