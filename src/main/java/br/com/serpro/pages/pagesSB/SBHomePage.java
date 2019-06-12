package br.com.serpro.pages.pagesSB;

import org.openqa.selenium.By;

import br.com.serpro.appiumCore.BasePage;

public class SBHomePage extends BasePage {
	public String obterSaldoConta(String conta) {
		return obterTexto(By.xpath("//*[@text='"+conta+"']/following-sibling::android.widget.TextView"));
	}
}
