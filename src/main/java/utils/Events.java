package main.java.utils;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import main.java.config.Context;
import main.java.config.ElementFetch;
import main.java.config.Utils;
import main.java.config.Validation;
import test.java.BaseTest;
import org.openqa.selenium.interactions.WheelInput;

public class Events extends BaseTest {

	@Context(description = "Obtiene el texto de un elemento")
	public static String getText(String xpathElement) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

			WebElement element = driver.findElement(By.xpath(xpathElement));
			wait.until(ExpectedConditions.visibilityOf(element));
			return element.getText();
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
			return null;
		}
	}
	
	@Context(description = "Obtiene el valor de un elemento")
	public static String getValue(String xpathElement) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

			WebElement element = driver.findElement(By.xpath(xpathElement));
			wait.until(ExpectedConditions.visibilityOf(element));
			return element.getAttribute("value");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
			return null;
		}
	}

	@Context(description = "Obtiene el valor dado un atributo de un elemento")
	public static String getAtributte(String xpathElement, String atributte) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

			WebElement element = driver.findElement(By.xpath(xpathElement));
			wait.until(ExpectedConditions.visibilityOf(element));
			return element.getAttribute(atributte);
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
			return null;
		}
	}

	@Context(description = "Escribe dentro de un campo de texto ubicado según xpath")
	public static void sendKeys(String xpathElement, String text) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

			WebElement element = BaseTest.driver.findElement(By.xpath(xpathElement));
			wait.until(ExpectedConditions.visibilityOf(element));

			String inputName = getName(element, xpathElement);
			if (element.isDisplayed() && element.isEnabled()) {
				int caracteres = element.getAttribute("value").toCharArray().length;
				for (int i = 0; i < caracteres; i++) {
					element.sendKeys(Keys.BACK_SPACE);
				}
				element.sendKeys(text);
				Utils.outputInfo("Se ha ingresado el texto '" + text + "' en el campo: " + inputName);
				Validation.trueBooleanCondition(element.getAttribute("value").contains(text) || element.getAttribute("value").contains(text.replaceAll(" ", "")),
						"El texto se ha ingresado correctamente", String.format("El texto no se ha ingresado correctamente. Valor ingresado %s, Valor que se requiere ingresar %s", element.getAttribute("value"),text));
			} else {
				Utils.eventFailed("El campo '" + inputName + "' no se encuentra habilitado o desplegado");
			}
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}
	
	@Context(description = "Escribe dentro de un campo de texto ubicado según xpath pero indicando en el mensaje el nombre de la varibale en vez de indicar el ID del elemento web")
	public static void sendKeysWithReturnVariableName(String xpathElement, String text) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

			WebElement element = BaseTest.driver.findElement(By.xpath(xpathElement));
			wait.until(ExpectedConditions.visibilityOf(element));

			String inputName = Events.getVariableName(xpathElement);
			if (element.isDisplayed() && element.isEnabled()) {
				int caracteres = element.getAttribute("value").toCharArray().length;
				for (int i = 0; i < caracteres; i++) {
					element.sendKeys(Keys.BACK_SPACE);
				}
				element.sendKeys(text);
				Utils.outputInfo("Se ha ingresado el texto '" + text + "' en el campo: " + inputName);
				Validation.trueBooleanCondition(element.getAttribute("value").contains(text) || element.getAttribute("value").contains(text.replaceAll(" ", "")),
						"El texto se ha ingresado correctamente", String.format("El texto no se ha ingresado correctamente. Valor ingresado %s, Valor que se requiere ingresar %s", element.getAttribute("value"),text));
			} else {
				Utils.eventFailed("El campo '" + inputName + "' no se encuentra habilitado o desplegado");
			}
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona un botón")
	public static void clickButton(String xpathElement) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

			WebElement element = BaseTest.driver.findElement(By.xpath(xpathElement));
			wait.until(ExpectedConditions.elementToBeClickable(element));

			String buttonName = getName(element, xpathElement);
			
			if (element.isEnabled()) {
				element.click();
				Utils.outputInfo("Se ha hecho clic en el botón: " + buttonName);
			} else {
				Utils.eventFailed("El botón '" + buttonName + "' no está desplegado o habilitado");
			}
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}
	
	@Context(description = "Obtiene el nombre del elemento, de lo contrario obtiene el nombre de la variable")
	public static String getName(WebElement element, String xpathElement) {
		String name = "";
		try {
			name = Utils.getName(element, xpathElement);
			if (Objects.equals(name, "") || name.isEmpty() || name.equals("null")) {
				name = Utils.elementName(xpathElement);
			}
			return name;
		}
		catch(Exception e){
			name = Utils.elementName(xpathElement);
			return name;
		}
	}
	
	@Context(description = "Obtiene el nombre de la variable")
	public static String getVariableName(String xpathElement) {
		return  Utils.elementNameRelativeClass(xpathElement);
	}

	@Context(description = "Presiona la tecla ENTER en el contexto de ingresar texto en un campo")
	public static void enter(String inputXpath) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			Actions actions = new Actions(driver);

			WebElement element = BaseTest.driver.findElement(By.xpath(inputXpath));
			wait.until(ExpectedConditions.visibilityOf(element));

			actions.moveToElement(element).build().perform();
			actions.sendKeys(Keys.ENTER);
			Utils.outputInfo("Se ha presionado la tecla ENTER");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Devuelve una lista de elementos")
	public static List<WebElement> getElementList(String listXpath) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

			List<WebElement> elements = BaseTest.driver.findElements(By.xpath(listXpath));
			wait.until(ExpectedConditions.visibilityOfAllElements(elements));
			return elements;

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
			return null;
		}
	}
	
	@BeforeMethod(description = "Selecciona un elemento de la lista donde el texto contenga la opción a seleccionar")
	public static String selectByContainsText(String xpathElement, String option) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

			WebElement element = BaseTest.driver.findElement(By.xpath(xpathElement));
			wait.until(ExpectedConditions.visibilityOf(element));
			String name = getName(element, xpathElement);

			Select select = new Select(driver.findElement(By.xpath(xpathElement)));
						
			for (int i = 0; i < select.getOptions().size(); i++) {
				String opcion = select.getOptions().get(i).getText();
				if (opcion.contains(option)) {
					select.getOptions().get(i).click();
					break;
				}
			}
			
			String selectedOption = select.getFirstSelectedOption().getText();
			Utils.outputInfo(
					"Se ha seleccionado la opción '" + selectedOption + "' en la lista desplegable '" + name + "'");
			
			return selectedOption;
			
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
			return null;
		}
	}
	@Context(description = "Presiona la tecla ENTER en el contexto de ingresar texto en un campo")
	public static void enterAlt(String inputXpath) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			Actions actions = new Actions(driver);

			WebElement element = BaseTest.driver.findElement(By.xpath(inputXpath));
			wait.until(ExpectedConditions.visibilityOf(element));

			actions.moveToElement(element).build().perform();
			actions.sendKeys(Keys.RETURN);
			Utils.outputInfo("Se ha presionado la tecla RETURN");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}
	
	@Context(description = "Se hace scroll para encontrar la póliza generada")
	public static void scroll(String inputXpath) {
		try {
			Actions actions = new Actions(driver);
			
			WebElement element = BaseTest.driver.findElement(By.xpath(inputXpath));

			actions.scrollToElement(element).perform();
			Utils.outputInfo("Se ha hecho scroll correctamente hasta:"+element.getText());

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}
	
	@Context(description = "Limpiara la caja de texto", page = "Login", functionality = "Transversal")
	public static void limpiarCajaDeTexto(String limiparFecha) {

		try {
			WebElement element = BaseTest.driver.findElement(By.xpath(limiparFecha));
			element.clear();
			
//			Actions actions = new Actions(driver);
//			actions.sendKeys(Keys.ENTER);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}
	
}
