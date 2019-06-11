package br.com.serpro.pages;

import static br.com.serpro.appiumCore.DriverFactory.getDriver;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.com.serpro.appiumCore.BaseTest;
import io.appium.java_client.MobileBy;

public class WebViewPage extends BaseTest {
	
	public void entrarContexto() {
		Set<String> contextHandles = getDriver().getContextHandles();
		for(String valor: contextHandles)
			System.out.println(valor);
		getDriver().context((String) contextHandles.toArray()[0]);
		List<WebElement> textViews = getDriver().findElements(By.className("android.widget.EditText"));
		for (int i=0; i<textViews.size(); i++) {
//		  if(textViews.get(i).getText().toLowerCase().contains("Email")) {
			  System.out.println(textViews.get(i).getText());
//		    textViews.get(i).click();
		  }
		} 		
		
	public void setEmail(String email) {
		getDriver().findElement(By.xpath("//android.widget.EditText[@text='Email']")).clear();
		getDriver().findElement(By.xpath("//android.widget.EditText[@text='Email']")).sendKeys(email);
	}
	public void setPass(String senha) {
		getDriver().findElement(By.xpath("//android.widget.EditText[@text='Password']")).clear();
		getDriver().findElement(By.xpath("//android.widget.EditText[@text='Password']")).sendKeys(senha);
	}	
	public void entrar() {
		getDriver().findElement(MobileBy.AccessibilityId("Entrar")).click();
	}

	public String verificarLogin() {
		WebElement findElement = getDriver().findElement(By.xpath("//android.view.View[@content-desc='Bem vindo, Viveiros!']"));
		return findElement.getTagName();
	}	
}
