package br.com.serpro.test;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.serpro.appiumCore.BaseTest;
import br.com.serpro.pages.FormularioPage;
import br.com.serpro.pages.MenuPage;

public class FormularioTeste extends BaseTest{
	
	private MenuPage menu = new MenuPage();
	private FormularioPage formulario = new FormularioPage();
	
	@Before
	public void inicializarAppium() throws MalformedURLException {
		menu.acessarFormulario();
	}
	
	
	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {

    
//	    List<WebElement> elementosEncontrados = driver.findElements(By.className("android.widget.TextView"));
//	    for (WebElement element: elementosEncontrados)
//	    	System.out.println(element.getText());
//	    Acionar item do menu Formulário
//	    elementosEncontrados.get(1).click();
		
		formulario.escreverNome("André Viveiros");
	    
	    Assert.assertEquals("André Viveiros", formulario.obterNome());
	    

	}

	
	@Test
	public void devePreencherCombo() throws MalformedURLException {

	    
		formulario.selecionarComboConsole("PS4");
		
	    Assert.assertEquals("PS4", formulario.obterTextoConsole());

	}
	
	@Test
	public void deveUsarCheckBoxSwitch() throws MalformedURLException {

	    
	    Assert.assertEquals(false, formulario.isCheckMarcado() ); 
	    Assert.assertEquals(true, formulario.isSwitchMarcado()); 
	    
	    formulario.clicarCheck();
	    formulario.clicarSwitch();
	    
	    Assert.assertEquals(true, formulario.isCheckMarcado()); 
	    Assert.assertEquals(false, formulario.isSwitchMarcado());
	    
	}
	
	@Test
	public void salvarFormlario() throws MalformedURLException {
	    
		formulario.escreverNome("André Pereira Viveiros");
		formulario.clicarCheck();
		formulario.clicarSwitch();
	    formulario.selecionarComboConsole("PS4");

	    formulario.Salvar();
	    
	    Assert.assertEquals("André Pereira Viveir", formulario.obterNome());
	    Assert.assertEquals("Console: ps4", formulario.obterConsoleCadastrado());
	    Assert.assertEquals("Switch: Off", formulario.obterSwitchCadastrado());
	    Assert.assertEquals("Checkbox: Marcado", formulario.obterCheckboxCadastrado());
	    
	}

}
