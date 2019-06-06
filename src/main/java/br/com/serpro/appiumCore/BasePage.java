package br.com.serpro.appiumCore;

import static br.com.serpro.appiumCore.DriverFactory.getDriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.touch.TouchActions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class BasePage {
	public void escrever(By by, String texto) {
	    getDriver().findElement(by).sendKeys(texto);
	}
	
	public String obterTexto(By by){
		return getDriver().findElement(by).getText();
	}

	public void clicar(By by) {
		getDriver().findElement(by).click();
	}
	
	public void clicarPorTexto(String texto) {
	    getDriver().findElement(By.xpath("//*[@text='"+texto+"']")).click();
	}
	
	public void selecionarCombo(By by, String texto) {
		getDriver().findElement(by).click();
		clicarPorTexto(texto);
	}
	
	public boolean isCheckMarcado(By by) {
		return getDriver().findElement(by).getAttribute("checked").equals("true");
	}
	public boolean existeElementoPorTexto(String texto) {
		List<MobileElement> elementos = getDriver().findElements(By.xpath("//*[@text='"+texto+"']"));
		return !elementos.isEmpty();
	}
	
	public void tap(int xPoint, int yPoint) {
		new TouchAction(getDriver()).tap(PointOption.point(xPoint, yPoint)).perform();
	}

	public void scroll(double inicio, double fim) {
		Dimension size = getDriver().manage().window().getSize();
		int x = size.width/2;
		int start_y = (int) (size.height * inicio);
		int end_y = (int) (size.height * fim);

		 TouchAction action = new TouchAction(getDriver());
		 WaitOptions waitOptions = new WaitOptions(); 
		 waitOptions.withDuration(Duration.ofMillis(500));
		 
		 action.press(PointOption.point(x, start_y))
		 	.waitAction(waitOptions )
		 	.moveTo(PointOption.point(x, end_y))
		 	.release()
		 	.perform();
	}
	
    public void scrollA(double startPercentage, double endPercentage) {
        Dimension size = getDriver().manage().window().getSize();
		int x = size.width/2;
        int startPoint = (int) (size.height * startPercentage);
        int endPoint = (int) (size.height * endPercentage);
 
        new TouchActions(getDriver())
        		.scroll(x, endPoint)
                .release().perform();
    }
	
}
