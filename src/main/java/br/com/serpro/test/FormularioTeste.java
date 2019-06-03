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
		
	    //Escrever o nome
		formulario.escreverNome("André Viveiros");
	    
	    //Verificar nome escrito
	    Assert.assertEquals("André Viveiros", formulario.obterNome());
	    

	}

	
	@Test
	public void devePreencherCombo() throws MalformedURLException {

	    
	   //Selecionar item no combo
		formulario.selecionarComboConsole("PS4");
		
		//Verificar valor
	    Assert.assertEquals("PS4", formulario.obterTextoConsole());

	}
	
	@Test
	public void deveUsarCheckBoxSwitch() throws MalformedURLException {

	    
	    //Verificar status dos elemento
	    //Se o CheckBox está desabilitado
	    Assert.assertEquals(false, formulario.isCheckMarcado() ); 
	    //Se o Switch está habilitado
	    Assert.assertEquals(true, formulario.isSwitchMarcado()); 
	    
	    //Clicar nos elementos
	    formulario.clicarCheck();
	    formulario.clicarSwitch();
	    
	    //Verificar status dos elemento alterados
	    //Se o CheckBox está desabilitado
	    Assert.assertEquals(true, formulario.isCheckMarcado()); 
	    //Se o Switch está habilitado
	    Assert.assertEquals(false, formulario.isSwitchMarcado());
	    
	}
	
	@Test
	public void salvarFormlario() throws MalformedURLException {
	    
	    //Nome
		formulario.escreverNome("André Pereira Viveiros");
	    //CheckBox
		formulario.clicarCheck();
	    //Switch
		formulario.clicarSwitch();
	    //ComboBox
	    formulario.selecionarComboConsole("PS4");

	    //Salvar Formulário
	    formulario.Salvar();
	    
	    //Verificar valores Salvos
	    Assert.assertEquals("André Pereira Viveir", formulario.obterNome());
	    Assert.assertEquals("Console: ps4", formulario.obterConsoleCadastrado());
	    Assert.assertEquals("Switch: Off", formulario.obterSwitchCadastrado());
	    Assert.assertEquals("Checkbox: Marcado", formulario.obterCheckboxCadastrado());
	    
	}

}
