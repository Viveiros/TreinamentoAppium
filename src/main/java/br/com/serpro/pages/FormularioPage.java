package br.com.serpro.pages;

import org.openqa.selenium.By;

import br.com.serpro.appiumCore.BasePage;
import io.appium.java_client.MobileBy;

public class FormularioPage extends BasePage{
	
	public void escreverNome(String nome) {
		escrever(By.xpath("//android.widget.EditText[@text='Nome']"), nome);
	}
	public String obterNome() {
		return obterTexto(MobileBy.AccessibilityId("nome"));
	}
	public void selecionarComboConsole(String console) {
		selecionarCombo(By.xpath("//android.widget.Spinner"), console);
	}
	public String obterTextoConsole() {
		return obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
	}
	public boolean isCheckMarcado() {
		return isCheckMarcado(MobileBy.xpath("//android.widget.CheckBox"));		
	}
	public boolean isSwitchMarcado() {
		return isCheckMarcado(MobileBy.xpath("//android.widget.Switch"));		
	}
	public void clicarCheck() {
		clicar(MobileBy.xpath("//android.widget.CheckBox"));
	}
	public void clicarSwitch() {
		clicar(MobileBy.xpath("//android.widget.Switch"));
	}	
	public void Salvar() {
	    clicar(MobileBy.AccessibilityId("save"));
	}
	public String obterNomeCadastrado() {
		return obterTexto(By.xpath("//android.widget.TextView[contains(@text,'Nome:')]"));
	}
	public String obterConsoleCadastrado() {
		return obterTexto(By.xpath("//android.widget.TextView[contains(@text,'Console:')]"));
	}
	public String obterSwitchCadastrado() {
		return obterTexto(By.xpath("//android.widget.TextView[contains(@text,'Switch:')]"));
	}
	public String obterCheckboxCadastrado() {
		return obterTexto(By.xpath("//android.widget.TextView[contains(@text,'Checkbox:')]"));
	}

}
