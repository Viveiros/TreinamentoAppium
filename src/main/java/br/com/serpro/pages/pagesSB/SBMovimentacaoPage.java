package br.com.serpro.pages.pagesSB;

import org.openqa.selenium.By;

import br.com.serpro.appiumCore.BasePage;

public class SBMovimentacaoPage extends BasePage {
	
	public void salvar() {
		clicarPorTexto("SALVAR");
	}
	public void setDescricao(String texto) {
		escrever(By.xpath("//android.widget.EditText[@text='Descrição']"), texto);
	}
	public void setInteressado(String texto) {
		escrever(By.xpath("//android.widget.EditText[@text='Interessado']"), texto);
	}
	public void setValor(String texto) {
		escrever(By.xpath("//android.widget.EditText[@text='Valor']"), texto);
	}	
	public void setConta(String texto) {
		selecionarCombo(By.xpath("//android.widget.Spinner[2]"), texto);
	}
}
