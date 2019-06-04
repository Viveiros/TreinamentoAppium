package br.com.serpro.test;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.serpro.appiumCore.BaseTest;
import br.com.serpro.pages.FormularioPage;
import br.com.serpro.pages.MenuPage;
import io.appium.java_client.MobileBy;

public class FormularioTeste extends BaseTest{
	
	private MenuPage menuPage = new MenuPage();
	private FormularioPage formularioPage = new FormularioPage();
	
	@Before
	public void inicializarAppium() throws MalformedURLException {
		menuPage.acessarFormulario();
	}
	
	
	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {

    
//	    List<WebElement> elementosEncontrados = driver.findElements(By.className("android.widget.TextView"));
//	    for (WebElement element: elementosEncontrados)
//	    	System.out.println(element.getText());
//	    Acionar item do menu Formulário
//	    elementosEncontrados.get(1).click();
		
		formularioPage.escreverNome("André Viveiros");
	    
	    Assert.assertEquals("André Viveiros", formularioPage.obterNome());
	    

	}

	
	@Test
	public void devePreencherCombo() throws MalformedURLException {

	    
		formularioPage.selecionarComboConsole("PS4");
		
	    Assert.assertEquals("PS4", formularioPage.obterTextoConsole());

	}
	
	@Test
	public void deveUsarCheckBoxSwitch() throws MalformedURLException {

	    
	    Assert.assertEquals(false, formularioPage.isCheckMarcado() ); 
	    Assert.assertEquals(true, formularioPage.isSwitchMarcado()); 
	    
	    formularioPage.clicarCheck();
	    formularioPage.clicarSwitch();
	    
	    Assert.assertEquals(true, formularioPage.isCheckMarcado()); 
	    Assert.assertEquals(false, formularioPage.isSwitchMarcado());
	    
	}
	
	@Test
	public void salvarFormlario() throws MalformedURLException {
	    
		formularioPage.escreverNome("André Pereira Viveiros");
		formularioPage.clicarCheck();
		formularioPage.clicarSwitch();
	    formularioPage.selecionarComboConsole("PS4");

	    formularioPage.Salvar();
	    
	    Assert.assertEquals("André Pereira Viveir", formularioPage.obterNome());
	    Assert.assertEquals("Console: ps4", formularioPage.obterConsoleCadastrado());
	    Assert.assertEquals("Switch: Off", formularioPage.obterSwitchCadastrado());
	    Assert.assertEquals("Checkbox: Marcado", formularioPage.obterCheckboxCadastrado());
	    
	}
	
	@Test
	public void testarDeveAlerarData() {
		formularioPage.clicarPorTexto("01/01/2000");
		formularioPage.clicarPorTexto("20");
		formularioPage.clicarPorTexto("OK");
		Assert.assertTrue(formularioPage.existeElementoPorTexto("20/2/2000"));
		
	}
	@Test
	public void testarDeveAlerarHora() {
		formularioPage.clicarPorTexto("06:00");
		formularioPage.clicar(MobileBy.AccessibilityId("14"));
		formularioPage.clicar(MobileBy.AccessibilityId("10"));
		formularioPage.clicarPorTexto("OK");
		Assert.assertTrue(formularioPage.existeElementoPorTexto("14:10"));
		
	}	

}
