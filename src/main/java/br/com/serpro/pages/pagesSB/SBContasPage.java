package br.com.serpro.pages.pagesSB;

import org.openqa.selenium.By;

import br.com.serpro.appiumCore.BasePage;

public class SBContasPage extends BasePage {
	public void preencherConta(String nome) {
		escrever(By.xpath("//android.widget.EditText[@text='Conta']"), nome);
	}
	public void salvar() {
		clicar(By.xpath("//android.widget.TextView[@text='SALVAR']"));
	}
	public void excluir() {
		clicar(By.xpath("//android.widget.TextView[@text='EXCLUIR']"));
	}
	public void clicarConta(String conta) {
		clicarPorTexto(conta);
	}
}
