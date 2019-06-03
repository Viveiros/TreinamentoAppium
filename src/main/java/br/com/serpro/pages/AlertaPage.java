package br.com.serpro.pages;

import org.openqa.selenium.By;

import br.com.serpro.appiumCore.BasePage;

public class AlertaPage extends BasePage {
	public void clicarAlertaConfirm() {
		clicarPorTexto("ALERTA CONFIRM");
	}
	public String obterTextoTitulo() {
		return obterTexto(By.id("android:id/alertTitle"));
	}
	public String obterMensagem() {
		return obterTexto(By.id("android:id/message"));
	}
	public void clicarConfirmar() {
		clicar(By.id("android:id/button2"));
	}
	public void clicarSair() {
		clicar(By.id("android:id/button1"));
	}	
}
