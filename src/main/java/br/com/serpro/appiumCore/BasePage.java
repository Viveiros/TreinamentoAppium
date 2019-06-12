package br.com.serpro.appiumCore;

import static br.com.serpro.appiumCore.DriverFactory.getDriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
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
	
	public void cliqueLongo(By by) {
		MobileElement el = (MobileElement) getDriver().findElement(by);
		new TouchAction(getDriver()).longPress(new ElementOption().element(el)).perform();
	}	
	
	public void clicarPorTexto(String texto) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.until(ExpectedConditions.attributeToBe(getDriver().findElement(By.xpath("//*[@text='"+texto+"']")), "Enabled", "true"));
//		System.out.println("     Text:"+getDriver().findElement(By.xpath("//*[@text='"+texto+"']")).getText());
//		System.out.println("  Enabled:"+getDriver().findElement(By.xpath("//*[@text='"+texto+"']")).isEnabled());
//		System.out.println("Displayed:"+getDriver().findElement(By.xpath("//*[@text='"+texto+"']")).isDisplayed());
//		System.out.println(" Selected:"+getDriver().findElement(By.xpath("//*[@text='"+texto+"']")).isSelected());
//		System.out.println("  TagName:"+getDriver().findElement(By.xpath("//*[@text='"+texto+"']")).getTagName());
//		System.out.println("---------------");
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
	public void swipe(double inicio, double fim) {
		Dimension size = getDriver().manage().window().getSize();
		int y = size.height/2;
		int start_x = (int) (size.width * inicio);
		int end_x = (int) (size.width * fim);

		 TouchAction action = new TouchAction(getDriver());
		 WaitOptions waitOptions = new WaitOptions(); 
		 waitOptions.withDuration(Duration.ofMillis(500));
		 
		 action.press(PointOption.point(start_x, y))
		 	.waitAction(waitOptions )
		 	.moveTo(PointOption.point(end_x, y))
		 	.release()
		 	.perform();
	}
	
	public void swipeElment(MobileElement el, double inicio, double fim) {
		Dimension size = getDriver().manage().window().getSize();
		Dimension sizeEl = el.getSize();
		int y = size.height/2;
		int start_x = (int) (sizeEl.width * inicio);
		int end_x = (int) (sizeEl.width * fim);
		
//		System.out.println("   Size:"+size);
//		System.out.println(" SizeEl:"+sizeEl);
//		System.out.println("      y:"+y);
//		System.out.println("start_x:"+start_x);
//		System.out.println("  end_x:"+end_x);
		
		TouchAction action = new TouchAction(getDriver());
		 WaitOptions waitOptions = new WaitOptions(); 
		 waitOptions.withDuration(Duration.ofMillis(500));
		 
		 action.press(new ElementOption().element(el))
//		 action.press(PointOption.point(start_x, y))
		 	.waitAction(waitOptions )
		 	.moveTo(PointOption.point(end_x, y))
		 	.release()
		 	.perform();		 	
//		 action.press(PointOption.point(start_x, y))
//		 	.waitAction(waitOptions )
//		 	.moveTo(PointOption.point(end_x, y))
//		 	.release()
//		 	.perform();
	}	
	public void scrollDown() {
		scroll(0.9,0.1);
	}
	public void scrollUp() {
		scroll(0.1,0.9);
	}
	public void swipeLeft() {
		swipe(0.9,0.1);
	}
	public void swipeRigth() {
		swipe(0.1,0.9);
	}
}
