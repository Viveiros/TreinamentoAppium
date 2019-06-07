package br.com.serpro.pages;

import static br.com.serpro.appiumCore.DriverFactory.getDriver;

import java.util.List;

import org.openqa.selenium.By;

import br.com.serpro.appiumCore.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class DragAndDropPage extends BasePage {
	
	public void arrastar(String origem, String destino) {
		MobileElement elOrigem = (MobileElement) getDriver().findElement(By.xpath("//*[@text='"+origem+"']"));
		MobileElement elDestino = (MobileElement) getDriver().findElement(By.xpath("//*[@text='"+destino+"']"));
		
		TouchAction action = new TouchAction(getDriver());

		action.longPress(new LongPressOptions().withElement( new ElementOption().element(elOrigem)))
			.moveTo(new ElementOption().element(elDestino))
			.release()
			.perform();
		
//		new TouchActions(getDriver())
//			.longPress(elOrigem)
//			.moveToElement(elDestino)
//			.release()
//			.perform();

	}
	
	public String[] obterLista() {
		List<MobileElement> elements = getDriver().findElements(By.xpath("//android.widget.TextView"));
		String[] retorno = new String[elements.size()];
		for(int i =0; i < elements.size();i++) {
			retorno[i] = elements.get(i).getText();
//			System.out.print("\"" + retorno[i] + "\", ");
		}
		return retorno;
	}
}
