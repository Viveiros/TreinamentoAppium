package br.com.serpro.pages;

import org.openqa.selenium.By;

import br.com.serpro.appiumCore.BasePage;

public class SBLoginPage extends BasePage {
	
	public void preencherNome(String nome) {
		escrever(By.xpath("//android.widget.EditText[@text='Nome']"), nome);
	}
	public void preencherSenha(String senha) {
		escrever(By.xpath("//android.widget.EditText[@text='Senha']"), senha);
	}
	public void entrar() {
		clicar(By.xpath("//android.widget.TextView[@text='ENTRAR']"));
	}
	public void logar() {
		this.preencherNome("andre@andre");
		this.preencherSenha("12345");
		this.entrar();
	}
}
