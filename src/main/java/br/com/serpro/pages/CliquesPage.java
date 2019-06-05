package br.com.serpro.pages;

import static br.com.serpro.appiumCore.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import br.com.serpro.appiumCore.BasePage;

public class CliquesPage extends BasePage {
	public void cliqueLongo() {
		new Actions(getDriver()).clickAndHold(getDriver().findElement(By.xpath("//*[@text='Clique Longo']"))).perform();
	}
	public String obterTextoCampo() {
		return getDriver().findElement(By.xpath("(//android.widget.TextView)[3]")).getText();
	}
}
