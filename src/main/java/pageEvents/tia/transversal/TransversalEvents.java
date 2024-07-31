package main.java.pageEvents.tia.transversal;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.lang.invoke.ConstantCallSite;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ch.qos.logback.classic.pattern.Util;
import main.java.config.Context;
import main.java.pageObjects.tia.productos.MuerteAccidentalElements;
import main.java.pageObjects.tia.transversal.TransversalElements;
import main.java.properties.EntidadProperties;
import main.java.properties.PolizaProperties;
import main.java.config.ElementFetch;
import main.java.utils.Constants;
import main.java.utils.Events;
import main.java.config.Utils;
import main.java.config.Validation;
import test.java.BaseTest;

public class TransversalEvents extends BaseTest implements TransversalElements {
	static String rutAsegurado = "";

	@Context(description = "Valida que se haya ingresado a la URL de TIA QA", page = "Login", functionality = "Transversal")
	public static void validarAmbienteTIA() {
			//Se debe ingresar aqui la URL correspondiente
			driver.get(Constants.url);
		try {
			WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(50));
			ElementFetch elementFetch = new ElementFetch();

			 wait.until(new ExpectedCondition<Boolean>(){
				  public Boolean apply( WebDriver driver) {
					  return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
				  }
			  });
			
//			Thread.sleep(5000);
			Utils.outputInfo("Tiempo de espera de 5 segundos para carga de la plataforma TIA");
			WebElement element = elementFetch.getWebElement("XPATH", buttonIniciarSesion);
			Utils.takeAdditionalScreenshot("tia_segundo_plano", "extra");
			wait.until(ExpectedConditions.visibilityOf(element));
			String url = BaseTest.driver.getCurrentUrl().toString();
			Validation.trueBooleanCondition(url.contains("qa"), "Se ha ingresado al ambiente QA de TIA correctamente",
					"No se ha ingresado al ambiente QA de TIA");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Valida que la poliza se haya renovado", page = "Manejo Póliza", functionality = "Cancelación")
	public static void validarPolizaRenovado() {
		try {
			String tituloLineaPoliza = Events.getText(MuerteAccidentalElements.labelPaginaRenovada);
			Utils.outputInfo("La sección actual es: " + tituloLineaPoliza);
			Validation.trueBooleanCondition(tituloLineaPoliza.contains("R Renovación"),
					"Se ha ingresado a estado de la póliza correctamente: " + tituloLineaPoliza,
					"No se ha ingresado a estado de la póliza correctamente");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Pagina Entidad ", page = "Entidad", functionality = "Renovacion")
	public static void buttonRenovar() {
		try {
			Events.clickButton(buttonRenovacion);
			Events.clickButton(buttonCompletarRenovacion);
			Events.clickButton(buttonAceptarRenovacion);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Entrar al sistema TIA", page = "Login", functionality = "Transversal")
	public static void iniciarSesion(String user, String pass) {

		try {
			Events.sendKeys(inputUsuario, user);
			Events.sendKeys(inputPassword, pass);
			Events.clickButton(buttonIniciarSesion);
//			Thread.sleep(10000);
			((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete"); 
			String tittle = Events.getText(labelPaginaPrincipal);
			
			Utils.outputInfo("La sección actual es: " + tittle);
			Validation.trueBooleanCondition(tittle.contains("Página principal"),
					"Se ha ingresado al sistema correctamente", "No se ha ingresado al sistema de forma correcta");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Buscar entidad por apellido", page = "Buscar Entidades", functionality = "Transversal")
	public static void buscarEntidad(String apellido) {

		try {
			Events.clickButton(aBuscarEntidad);
			Events.sendKeys(inputApellido, apellido);
			Events.clickButton(buttonBuscarEntidad);
			loadingTIAGeneral();
			Utils.takeAdditionalScreenshot(String.format("Se ingresa y busca a la entidad %s", apellido), "extra");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona el ID según el nombre completo dentro del resultado de la búsqueda por apellido", page = "Buscar Entidades", functionality = "Transversal")
	public static void seleccionarContratante(String nombreCompleto) {

		try {
			Events.clickButton(aNumeroEntidad.replace("Nombre", nombreCompleto));
			loadingTIAGeneral();
			String tituloPagina = Events.getText(labelPaginaResumenEntidad);
			Utils.outputInfo("La sección actual es: " + tituloPagina);
			Validation.trueBooleanCondition(tituloPagina.contains(nombreCompleto),
					"Se ha ingresado al resumen de la entidad correctamente: " + nombreCompleto,
					"No se ha ingresado al resumen de la entidad");
			EntidadProperties.nombreContratante = nombreCompleto;
			Utils.takeAdditionalScreenshot(String.format("Ingreso al resumen de la entidad %s", nombreCompleto),
					"extra");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Crea una póliza para un producto", page = "Resumen Entidad", functionality = "Emision")
	public static void crearNuevaPoliza(String producto) {

		try {
			TransversalEvents.loadingTIAGeneral();
			Events.clickButton(buttonNuevaPoliza);
			loadingTIAGeneral(60);
			List<WebElement> productos = Events.getElementList(listOpciones);
			for (int i = 0; i < productos.size(); i++) {
				String opcion = productos.get(i).getText();
				if (opcion.contains(producto)) {
					productos.get(i).click();
					Utils.outputInfo("Se ha seleccionado la opción: " + opcion);
					PolizaProperties.producto = producto;
					PolizaProperties.idProducto = opcion.substring(0, 2);
				}
			}
			Utils.takeAdditionalScreenshot(String.format("Se selecciona el producto %s", PolizaProperties.producto),
					"extra");
			Events.clickButton(buttonSi);
			String tituloPoliza = Events.getText(labelManejoPoliza);
			Utils.outputInfo("La sección actual es: " + tituloPoliza);
			Validation.trueBooleanCondition(tituloPoliza.contains(producto),
					"Se ha creado una póliza para el producto correcto: " + producto,
					"No se ha creado la póliza correctamente");

			int inicio = tituloPoliza.indexOf("-");
			int fin = tituloPoliza.indexOf("-", inicio + 1);
			String idPoliza = tituloPoliza.substring(inicio + 2, fin - 1);
			PolizaProperties.idPoliza = idPoliza;
			Utils.takeAdditionalScreenshot(String.format("Poliza creada incialmente %s", PolizaProperties.idPoliza),
					"extra");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Inicia la creación de una póliza para un producto, pero no culmina el proceso", page = "Resumen Entidad", functionality = "Emision")
	public static void crearNuevaPolizaAlternativo(String producto) {

		try {
			Events.clickButton(buttonNuevaPoliza);
			List<WebElement> productos = Events.getElementList(listOpciones);
			for (int i = 0; i < productos.size(); i++) {
				String opcion = productos.get(i).getText();
				if (opcion.contains(producto)) {
					productos.get(i).click();
					Utils.outputInfo("Se ha seleccionado la opción: " + opcion);
					PolizaProperties.producto = producto;
				}
			}

			Events.clickButton(buttonSi);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona el canal de venta del producto", page = "Manejo Póliza", functionality = "Emision")
	public static void seleccionarFechaPoliza(String Finicio) {

		try {
			Events.sendKeys(selectFinicio, Finicio);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona el canal de venta del producto", page = "Manejo Póliza", functionality = "Emision")
	public static void seleccionarCanalVenta(String canalVenta) {

		try {
			loadingTIAGeneral(60);
			validarDespliegueModulos(imgDespliegueModuloInteroObjeto.replace("TituloModulo", "Información de póliza"));
			loadingTIAGeneral();
			Events.clickButton(selectCanalVenta);
			loadingTIAGeneral();
			String rtContenido = Events.selectByContainsText(selectCanalVenta, canalVenta);
			Utils.takeAdditionalScreenshot(String.format("Se ingresa el canal de venta %s", rtContenido), "extra");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Crea una nueva línea de póliza", page = "Manejo Póliza", functionality = "Emision")
	public static void crearNuevaLineaPoliza() {

		try {

			Thread.sleep(3000);
			Events.clickButton(buttonNuevaLineaPoliza);
			Events.clickButton(buttonAceptar);
			loadingTIAGeneral(60);
			String tituloObjeto = Events.getText(labelManejoObjeto);
			Utils.outputInfo("La sección actual es: " + tituloObjeto);
			if (!tituloObjeto.contains(PolizaProperties.producto)) {
				Validation.trueBooleanCondition(tituloObjeto.contains("Muerte Accidental"),
						"Se ha creado el objeto de póliza para el producto correcto: " + PolizaProperties.producto,
						"No se ha creado el objeto de póliza correctamente");
			} else {
				Validation.trueBooleanCondition(tituloObjeto.contains(PolizaProperties.producto),
						"Se ha creado el objeto de póliza para el producto correcto: " + PolizaProperties.producto,
						"No se ha creado el objeto de póliza correctamente");
			}

			validarDespliegueModulos(
					imgDespliegueModuloInteroObjeto.replace("TituloModulo", "Información general del objeto"));
			String idObjeto = Events.getText(labelObjeto);
			PolizaProperties.idObjeto = idObjeto;

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Calcula la prima total de la póliza", page = "Manejo Objeto", functionality = "Emision")
	public static void calcularPrimaTotal() {

		try {
			loadingTIAGeneral();
			Events.scroll(buttonCalculate);
			loadingTIAGeneral();
			Events.clickButton(buttonCalculate);
			loadingTIAGeneral();
			WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(50));
			wait.until(ExpectedConditions
					.not(ExpectedConditions.attributeContains(By.xpath(labelPrimaTotal), "innerText", "0,000000")));
			String primaTotal = Events.getText(labelPrimaTotal);
			Utils.outputInfo("La prima total es: " + primaTotal);
			Validation.trueBooleanCondition(!primaTotal.contains("0,000000"),
					"La prima total se ha calculado correctamente", "La prima total no se ha calculado");
			PolizaProperties.primaSinDescuento = primaTotal;
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Calcula la prima total de la póliza sin validación de cambio en la prima", page = "Manejo Objeto", functionality = "Emision")
	public static void calcularPrimaTotalAlternativo() {

		try {
			Events.clickButton(buttonCalculate);
			String primaTotal = Events.getText(labelPrimaTotal);
			Utils.outputInfo("La prima total es: " + primaTotal);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Guarda la prima calculada", page = "Manejo Objeto", functionality = "Emision")
	public static void guardarCambios() {

		try {
			Events.clickButton(buttonGuardar);
			loadingTIAGeneral(60);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Se desplaza hasta el Manejo de póliza", page = "Manejo de Póliza", functionality = "Emision")
	public static void ingresarPolizaMaestra() {
		try {
			Events.clickButton(aPolizaV2);
			String tituloLineaPoliza = Events.getText(labelManejoPoliza);
			Utils.outputInfo("La sección actual es: " + tituloLineaPoliza);
			Validation.trueBooleanCondition(tituloLineaPoliza.contains(PolizaProperties.producto),
					"Se ha ingresado a la línea de póliza para el producto correcto: " + PolizaProperties.producto,
					"No se ha ingresado a la línea de póliza para el objeto de póliza correctamente");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Se desplaza hasta la línea de póliza", page = "Manejo Línea de Póliza", functionality = "Emision")
	public static void ingresarLineaPoliza() {
		try {
			validarDespliegueModulos(
					imgDespliegueModuloInteroObjeto.replace("TituloModulo", "Resumen de la línea de póliza"));
			Events.scroll(enlaceLineaPolizaEnPolizaMaestra);
			Events.clickButton(enlaceLineaPolizaEnPolizaMaestra);
			loadingTIAGeneral(60);
			String tituloLineaPoliza = Events.getText(labelManejoLineaPoliza);
			TransversalEvents.loadingTIAGeneral();
			Utils.outputInfo("La sección actual es: " + tituloLineaPoliza);
			String lineaPoliza = "";
			if (PolizaProperties.producto.toLowerCase().contains("Accidentes Personales".toLowerCase())) {
				lineaPoliza = "Muerte Accidental";
			} else if (PolizaProperties.producto.toLowerCase().contains("Mascota Salud".toLowerCase())) {
				lineaPoliza = "Mascota";
			} else {
				lineaPoliza = PolizaProperties.producto;
			}
			Validation.trueBooleanCondition(tituloLineaPoliza.contains(lineaPoliza),
					"Se ha ingresado a la línea de póliza para el producto correcto: " + lineaPoliza,
					"No se ha ingresado a la línea de póliza para el objeto de póliza correctamente");
			int inicio = tituloLineaPoliza.indexOf("-");
			int fin = tituloLineaPoliza.indexOf("-", inicio + 1);
			String idLineaPoliza = tituloLineaPoliza.substring(inicio + 2, fin - 1);
			PolizaProperties.idLineaPoliza = idLineaPoliza;
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Se desplaza hasta la línea de póliza", page = "Manejo Línea de Póliza", functionality = "Emision")
	public static void ingresarLineaPolizaV2() {
		try {
			TransversalEvents.loadingTIAGeneral();
			Thread.sleep(5000);
			Events.clickButton(labelManejoLineaPolizaV2);
			String tituloLineaPoliza = Events.getText(labelManejoLineaPoliza);
			Utils.outputInfo("La sección actual es: " + tituloLineaPoliza);
			Validation.trueBooleanCondition(tituloLineaPoliza.contains("Manejo de líneas de pólizas -"),
					"Se ha ingresado a la línea de póliza para el producto correcto: " + PolizaProperties.producto,
					"No se ha ingresado a la línea de póliza para el objeto de póliza correctamente");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Obtiene la línea de póliza", page = "Manejo Línea de Póliza", functionality = "Emision")
	public static void obtenerLineaPoliza() {
		try {

			String idLineaPoliza = Events.getText(labelNumeroLineaPoliza);
			PolizaProperties.idLineaPoliza = idLineaPoliza;
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Agrega un código de descuento a la prima total", page = "Manejo Línea de póliza", functionality = "Emision")
	public static void agregarDescuento(String codigo) {

		try {
			Events.sendKeys(inputCodigoDescuento, codigo);
			Events.clickButton(buttonGuardar);
			Thread.sleep(5000);
			WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(50));
			wait.until(ExpectedConditions
					.attributeToBeNotEmpty(BaseTest.driver.findElement(By.xpath(inputPorcentajeDescuento)), "value"));
			String porcentajeDescuento = Events.getAtributte(inputPorcentajeDescuento, "value");
			Validation.trueBooleanCondition(!porcentajeDescuento.equalsIgnoreCase(""),
					"El código se ha aplicado correctamente, el porcentaje de descuento es: " + porcentajeDescuento,
					"El código no se ha aplicado correctamente");

			String precioConDescuento = Events.getText(labelPrecioPagado);
			Utils.outputInfo("La nueva prima con el descuento aplicado es: " + precioConDescuento);
			PolizaProperties.primaConDescuento = precioConDescuento;
			String primaCalculada = calcularDescuento(porcentajeDescuento);
			Validation.trueBooleanCondition(primaCalculada.contains(precioConDescuento),
					"El descuento se ha aplicado correctamente, la prima cambió de "
							+ PolizaProperties.primaSinDescuento + " a " + PolizaProperties.primaConDescuento,
					"El descuento no se ha aplicado correctamente");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Confirmar descuento realizado a la póliza", page = "Manejo Línea de póliza", functionality = "Emision")
	public static void confirmarDescuento() {

		try {
//			
			String tituloLineaPoliza = Events.getText(labelManejoLineaPoliza);
			Utils.outputInfo("La sección actual es: " + tituloLineaPoliza);
			Validation.trueBooleanCondition(tituloLineaPoliza.contains(PolizaProperties.producto),
					"Se ha ingresado a la línea de póliza para el producto correcto: " + PolizaProperties.producto,
					"No se ha ingresado a la línea de póliza para el objeto de póliza correctamente");
			WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(50));
			wait.until(ExpectedConditions
					.attributeToBeNotEmpty(BaseTest.driver.findElement(By.xpath(inputPorcentajeDescuento)), "value"));
			String porcentajeDescuento = Events.getAtributte(inputPorcentajeDescuento, "value");
			Validation.trueBooleanCondition(!porcentajeDescuento.equalsIgnoreCase(""),
					"El código se ha aplicado correctamente, el porcentaje de descuento es: " + porcentajeDescuento,
					"El código no se ha aplicado correctamente");

			Events.clickButton(buttonGuardar);
			TransversalEvents.loadingTIAGeneral();

			String precioConDescuento = Events.getText(labelPrecioPagado);
			Utils.outputInfo("La nueva prima con el descuento aplicado es: " + precioConDescuento);
			PolizaProperties.primaConDescuento = precioConDescuento;
			String precioSinDscto = Events.getText(LabelPrecioTarifa);
			PolizaProperties.primaSinDescuento = precioSinDscto;
			System.out.println("Valor prima sin descuento:" + PolizaProperties.primaSinDescuento);
			String primaCalculada = calcularDescuento(porcentajeDescuento);
			Validation.trueBooleanCondition(primaCalculada.contains(precioConDescuento),
					"El descuento se ha aplicado correctamente, la prima cambió de "
							+ PolizaProperties.primaSinDescuento + " a " + PolizaProperties.primaConDescuento,
					"El descuento no se ha aplicado correctamente");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Agrega un código de descuento a la prima total", page = "Manejo Línea de póliza", functionality = "Emision")
	public static String calcularDescuento(String porcentaje) {

		try {
			float primaTotal = Float.parseFloat(PolizaProperties.primaSinDescuento.replace(",", "."));
			float porcentajeNum = Float.parseFloat(porcentaje);
			float descuento = (primaTotal * (porcentajeNum / 100));
			float primaConDescuento = primaTotal - descuento;
			String formattedNumber = String.format("%.6f", primaConDescuento).replace(".", ",");
			return formattedNumber;
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
			return null;
		}
	}

	@Context(description = "Completa la póliza según el estado", page = "Manejo Objeto", functionality = "Emision")
	public static void completarPoliza(String estado) {

		try {
			TransversalEvents.loadingTIAGeneral();
			Events.clickButton(buttonCompletar);
			loadingTIAGeneral();
			List<WebElement> productos = Events.getElementList(listOpciones);
			for (int i = 0; i < productos.size(); i++) {
				String opcion = productos.get(i).getText();
				if (opcion.toLowerCase().contains(estado.toLowerCase())) {
					productos.get(i).click();
					Utils.outputInfo("Se ha seleccionado la opción: " + opcion);
					PolizaProperties.estado = estado;
					break;
				} else if (i == productos.size()) {
					Utils.eventFailed(String.format("No se encontro el elemento indicado: %s", estado));
				}
			}

			Events.clickButton(buttonSi);
			TransversalEvents.loadingTIAGeneral();
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Quita la modal para visualizar el mensaje de error", page = "Manejo Objeto", functionality = "Emision")
	public static void quitarModalCompletarPoliza() {

		try {
			Events.clickButton(buttonCerrar);
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Quita la modal de Selección de producto para visualizar el mensaje de error", page = "Manejo Objeto", functionality = "Emision")
	public static void quitarModalSeleccionarProducto() {

		try {
			Events.clickButton(buttonCerrarSeleccion);
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Valida la aparición del mensaje que no permite la contratación por parte de un menor de edad", page = "Manejo Objeto", functionality = "Emision")
	public static void validarMensajeContratanteMenorEdad() {

		try {
			String mensaje = Events.getText(labelMensajeContratanteMenorEdad);
			Utils.outputInfo("Ha aparecido el siguiente mensaje: " + mensaje);
			Validation.trueBooleanCondition(mensaje.contains("18 años"), "El mensaje ha aparecido correctamente",
					"No ha aparecido el mensaje correcto");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Valida la aparición del mensaje que no permite la contratación por parte de un fallecido", page = "Manejo Objeto", functionality = "Emision")
	public static void validarMensajeContratanteFallecido() {

		try {
			String mensaje = Events.getText(labelMensajeContratanteFallecido);
			Utils.outputInfo("Ha aparecido el siguiente mensaje: " + mensaje);
			Validation.trueBooleanCondition(mensaje.contains("no está vivo"), "El mensaje ha aparecido correctamente",
					"No ha aparecido el mensaje correcto");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "No aceptar los documentos de la póliza y cancelar la transacción.", page = "Manejo Objeto", functionality = "Emision")
	public static void cancelarPoliza() {

		try {
			Events.clickButton(buttonCancelarCompletarPoliza);
			loadingTIAGeneral();
			Events.clickButton(buttonSiCancelarTransaccion);
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Valida la aparición del mensaje que no permite la contratación de una entidad errónea", page = "Manejo Objeto", functionality = "Emision")
	public static void validarMensajeContratanteErroneo() {

		try {
			String mensaje = Events.getText(labelMensajeContratanteErroneo);
			Utils.outputInfo("Ha aparecido el siguiente mensaje: " + mensaje);
			Validation.trueBooleanCondition(mensaje.contains("Sólo los particulares"),
					"El mensaje ha aparecido correctamente", "No ha aparecido el mensaje correcto");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Valida la aparición del mensaje que no permite la contratación de una persona inahbilitada", page = "Manejo Objeto", functionality = "Emision")
	public static void validarMensajeContratanteInahabilitado() {

		try {
			String mensaje = Events.getText(labelMensajeContratanteInhabilitado);
			Utils.outputInfo("Ha aparecido el siguiente mensaje: " + mensaje);
			Validation.trueBooleanCondition(mensaje.contains("está suspendido"),
					"El mensaje ha aparecido correctamente", "No ha aparecido el mensaje correcto");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Acepta documentos de póliza", page = "Manejo Objeto", functionality = "Emision")
	public static void aceptarDocumentosPoliza() {

		try {
			TransversalEvents.loadingTIAGeneral();
			String tituloPagina = Events.getText(labelModalDocumentosPoliza);
			Utils.outputInfo("La sección actual es: " + tituloPagina);
			Validation.trueBooleanCondition(tituloPagina.contains("Documentos de póliza"),
					"Se ha ingresado al resumen de la entidad correctamente: " + tituloPagina,
					"No se ha ingresado al resumen de la entidad");

			int inicio = tituloPagina.indexOf("-");
			int fin = tituloPagina.length();
			String idPoliza = tituloPagina.substring(inicio + 2, fin);
			PolizaProperties.idPoliza = idPoliza;

			Utils.outputInfo("Numero de Póliza: " + idPoliza);

			Events.clickButton(buttonAceptaCompletarPoliza);

			TransversalEvents.loadingTIAGeneral();
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Verifica que los datos del contratantes correspondan con la entidad seleccionada", page = "Manejo Objeto", functionality = "Emision")
	public static void BusquedaTransversalPoliza() {

		try {
			Events.clickButton(BusquedaTransversal.replace("id-poliza", PolizaProperties.idPoliza));

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Verifica que los datos del contratantes correspondan con la entidad seleccionada", page = "Manejo Objeto", functionality = "Emision")
	public static void verificarDatosContratante() {

		try {
			String nombreContratante = Events.getValue(inputNombreContratante);
			Validation.trueBooleanCondition(nombreContratante.equalsIgnoreCase(EntidadProperties.nombreContratante),
					"El contratante corresponde con la entidad seleccionada: " + nombreContratante,
					"El contratante no corresponde con la entidad seleccionada, se esperaba: "
							+ EntidadProperties.nombreContratante + ", y se encontró: " + nombreContratante);
			String rutContratante = Events.getValue(inputRutContratante);
			Utils.outputInfo("El rut del contratante es: " + rutContratante);
			EntidadProperties.rutContratante = rutContratante;
			String fechaNacimiento = Events.getValue(inputNacimientoContratante);
			Utils.outputInfo("La fecha de nacimiento del contratante es: " + fechaNacimiento);
			EntidadProperties.fechaNacimientoContratante = fechaNacimiento;

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	/*
	 * @Context(description = "Acepta documentos de póliza", page = "Manejo Objeto",
	 * functionality = "Emision") public static void aceptarDocumentosPoliza() {
	 * 
	 * try { Thread.sleep(2000); String tituloPagina =
	 * Events.getText(labelModalDocumentosPoliza);
	 * Utils.outputInfo("La sección actual es: " + tituloPagina);
	 * Validation.trueBooleanCondition(tituloPagina.contains("Documentos de póliza"
	 * ), "Se ha ingresado al resumen de la entidad correctamente: " + tituloPagina,
	 * "No se ha ingresado al resumen de la entidad");
	 * 
	 * int inicio = tituloPagina.indexOf("-"); int fin = tituloPagina.length();
	 * String idPoliza = tituloPagina.substring(inicio+2, fin);
	 * PolizaProperties.idPoliza = idPoliza;
	 * 
	 * Events.clickButton(buttonAceptaCompletarPoliza); Thread.sleep(3000); } catch
	 * (Exception e) { Utils.eventFailed(e.getMessage()); } }
	 */

//	@Context(description = "Acepta documentos de póliza", page = "Manejo Objeto", functionality = "Emision")
//	public static void aceptarDocumentosPoliza() {
//
//		try {
//			Thread.sleep(2000);
//			String tituloPagina = Events.getText(labelModalDocumentosPoliza);
//			Utils.outputInfo("La sección actual es: " + tituloPagina);
//			Validation.trueBooleanCondition(tituloPagina.contains("Documentos de póliza"),
//					"Se ha ingresado al resumen de la entidad correctamente: " + tituloPagina,
//					"No se ha ingresado al resumen de la entidad");
//
//			int inicio = tituloPagina.indexOf("-");
//			int fin = tituloPagina.length();
//			String idPoliza = tituloPagina.substring(inicio+2, fin);
//			PolizaProperties.idPoliza = idPoliza;
//
//			Events.clickButton(buttonAceptaCompletarPoliza);
//			Thread.sleep(3000);
//		} catch (Exception e) {
//			Utils.eventFailed(e.getMessage());
//		}
//	}

	@Context(description = "Verifica que los datos del asegurado sean los mismos que los del contratante", page = "Manejo Objeto", functionality = "Emision")
	public static void verificarMismosDatosContratanteAsegurado() {

		try {
			String nombreAsegurado = Events.getValue(inputNombreAsegurado);
			Validation.trueBooleanCondition(nombreAsegurado.equalsIgnoreCase(EntidadProperties.nombreContratante),
					"El asegurado corresponde con el contratante: " + nombreAsegurado,
					"El asegurado no es igual al contratante, se esperaba: " + EntidadProperties.nombreContratante
							+ ", y se encontró: " + nombreAsegurado);
			rutAsegurado = Events.getValue(inputRutAsegurado);
			Utils.outputInfo("El rut del asegurado es: " + rutAsegurado);
			String fechaNacimiento = Events.getValue(inputNacimientoAsegurado);
			Utils.outputInfo("La fecha de nacimiento del asegurado es: " + fechaNacimiento);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Crea siniestro para una póliza vigente", page = "Siniestro", functionality = "Siniestros")
	public static void crearSiniestro() {

		try {
			Events.clickButton(buttonCrearSiniestro);
			String tittle = Events.getText(labelPaginaSiniestro);
			Utils.outputInfo("La sección actual es: " + tittle);
			Validation.trueBooleanCondition(tittle.contains("Crear siniestro"),
					"Se ha ingresado a la página para la creación de un siniestro",
					"No se ha ingresado correctamente para crear un siniestro");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

//	@Context(step = "Se genera un siniestro en estado abierto", page = "Siniestro" , functionality = "Siniestro")
//	public static void generarSiniestro() {
//		
//		try {
//			Thread.sleep(1000);
//			Events.clickButton(buttonGenerarSiniestro);
//			String tittle = Events.getText(labelSiniestroAbierto);
//			Utils.outputInfo("La sección actual es: " + tittle);
//			int inicio = tittle.indexOf("-");
//			int fin = tittle.indexOf("(", inicio+ 1);
//			String idSiniestro = tittle.substring(inicio+2, fin-1);
//			Validation.trueBooleanCondition(tittle.contains("(Notificado)"),
//					"Se ha generado el siniestro correctamente con ID: " + idSiniestro, "No se ha generado el siniestro de forma correcta");
//
//		} catch (Exception e) {
//			Utils.eventFailed(e.getMessage());
//		}
//	}

//	@Context(step = "Se genera un siniestro en estado abierto", page = "Siniestro" , functionality = "Siniestro")
//	public static void generarSiniestro(String nombProducto) {
//		
//		try {
//			TransversalEvents.loadingTIAGeneral();
//			Events.clickButton(buttonGenerarSiniestro);
//			Events.clickButton(buttonBarraLateral);
//			String tittle = Events.getText(labelNotificacionSiniestro);
//			String tittle2 = Events.getText(labelSiniestro.replace("Nom_producto", nombProducto));
//			int inicio = tittle2.indexOf("-");
//			int fin = tittle2.indexOf("(", inicio+ 1);
//			String idSiniestro = tittle2.substring(inicio+2, fin-1);
//			Validation.trueBooleanCondition(tittle.contains("Notificación"),
//					"Se ha generado el siniestro correctamente con ID: " + idSiniestro, "No se ha generado el siniestro de forma correcta");
//		} catch (Exception e) {
//			Utils.eventFailed(e.getMessage());
//		}
//	}

	@Context(step = "Se intenta generar un siniestro pero no se culmina por errores controlados ", page = "Siniestro", functionality = "Siniestro")
	public static void generarSiniestroAlternativo() {

		try {
			TransversalEvents.loadingTIAGeneral();
			Events.clickButton(buttonGenerarSiniestro);
			String mensaje = Events.getText(labelSiniestroError);
			Utils.outputInfo("Se ha mostrado el mensaje: " + mensaje);
			Validation.trueBooleanCondition(mensaje.contains("Error"), "Se ha mostrado el mensaje de Error",
					"No se ha mostrado el mensaje de Error");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	// enviar al grupo

	@Context(description = "Selecciona el lugar donde ocurrió el siniestro", page = "Siniestro", functionality = "Siniestros")
	public static void seleccionarLugarSiniestro(String lugar) {

		try {
			Thread.sleep(7000);
			Events.selectByContainsText(selectLugar, lugar);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona el tipo de informante", page = "Siniestro", functionality = "Siniestros")
	public static void seleccionarTipoInformante(String tipoInform) {

		try {
			Thread.sleep(7000);
			Events.selectByContainsText(selectInformante, tipoInform);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Inserta el nombre del informante", page = "Siniestro", functionality = "Siniestros")
	public static void insertarNombInformante(String nombInform) {

		try {
			Events.sendKeys(inputNombInform, nombInform);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona el tipo de denuncia", page = "Siniestro", functionality = "Siniestros")
	public static void seleccionarTipoDenuncia(String tipoDenuncia) {

		try {
			Thread.sleep(7000);
			Events.selectByContainsText(selectTipoDenuncia, tipoDenuncia);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Inserta descripción del hecho", page = "Siniestro", functionality = "Siniestros")
	public static void insertarDescripHecho(String descripHecho) {

		try {
			Events.sendKeys(inputDescripHecho, descripHecho);
			Validation.trueBooleanCondition(!(descripHecho.equals("")),
					"Se ha introducido correctamente la descripción del hecho",
					"No se ha introducido descripción del hecho");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Guarda los datos de reserva", page = "Siniestro", functionality = "Siniestros")
	public static void guardarReserva() {

		try {

			Events.clickButton(buttonGuardarReserva);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Busca el liquidador designado para la atención del siniestro", page = "Siniestro", functionality = "Siniestros")
	public static void seleccionarLiquidador(String idLiquidador) {

		try {

			Events.clickButton(imgBuscarLiquidador);
			TransversalEvents.loadingTIAGeneral();
			Events.clickButton(buttonSeleccionarLiquidador.replace("IDLiquidador", idLiquidador));
			TransversalEvents.loadingTIAGeneral();
			Events.clickButton(buttonAceptarLiquidador);
			TransversalEvents.loadingTIAGeneral();

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Inserta fecha del siniestro", page = "Siniestro", functionality = "Siniestros")
	public static void insertarFechaSiniestro(String fechaSiniestro) {

		try {
			Events.sendKeys(inputFechaSiniestro, fechaSiniestro);
			Validation.trueBooleanCondition(!(fechaSiniestro.equals("")),
					"Se ha introducido correctamente la fecha del siniestro",
					"No se ha introducido fecha del siniestro");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Ingresa la fecha de hoy como la 'Fecha de Siniestro'", page = "Manejo de objetos")
	public static void ingresarFechaSiniestro() {
		try {
			Date fechaActual = new Date();
			SimpleDateFormat formatDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
			String fechaFormatedaString = formatDateFormat.format(fechaActual);
			Events.sendKeys(inputFechaSiniestro, fechaFormatedaString);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}

	}

	@Context(description = "Activar casilla 'Fecha Aproximada'", page = "Manejo de objetos")
	public static void seleccionarFechaAproximadaTrans() {
		try {
			Events.clickButton(checkBoxFechaEstimadaTrans);
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}

	}

	@Context(description = "Inserta fecha de denuncia", page = "Siniestro", functionality = "Siniestros")
	public static void insertarFechaDenuncia(String fechaDenuncia) {

		try {
			Events.sendKeys(inputFechaDenuncia, fechaDenuncia);
			Validation.trueBooleanCondition(!(fechaDenuncia.equals("")),
					"Se ha introducido correctamente la fecha de denuncia", "No se ha introducido fecha de denuncia");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Busca póliza vigente", page = "Siniestro", functionality = "Siniestros")
	public static void buscarPoliza(String idPoliza) {

		try {
			Thread.sleep(3000);
			Events.clickButton(buttonBusquedaPolizaAlt);
			Thread.sleep(3000);
			Events.sendKeys(inputIdLineaPoliza, idPoliza);
			driver.findElement(By
					.xpath("//label[contains(text(),'Mostrar información del objeto acordeón')]//following::input[3]"))
					.sendKeys(Keys.ENTER);
			TransversalEvents.loadingTIAGeneral();
			Events.clickButton(labelPolizaSiniestrar.replace("id-poliza", idPoliza));
			TransversalEvents.loadingTIAGeneral();
			Events.clickButton(buttonAceptaSeleccion);
			TransversalEvents.loadingTIAGeneral();

			String objeto = Events.getAtributte(inputObjeto, "value");
			Validation.trueBooleanCondition(!objeto.equalsIgnoreCase(""),
					"La póliza se ha seleccionado correctamente, el No.Objeto es: " + objeto,
					"La póliza no se ha seleccionado correctamente");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Busca póliza vigente", page = "Siniestro", functionality = "Siniestros")
	public static void buscarPolizaAlt() {

		try {
			Thread.sleep(3000);
			Events.clickButton(buttonBusquedaPolizaAlt);
			Thread.sleep(3000);
			//
			Events.limpiarCajaDeTexto(fechaSiniestroLimpiarCaja);
			//
			Thread.sleep(5000);
			Events.sendKeys(inputIdLineaPoliza, PolizaProperties.idPoliza);
			driver.findElement(By
					.xpath("//label[contains(text(),'Mostrar información del objeto acordeón')]//following::input[3]"))
					.sendKeys(Keys.ENTER);
			TransversalEvents.loadingTIAGeneral();
			Events.clickButton(labelPolizaSiniestrar.replace("id-poliza", PolizaProperties.idPoliza));
			TransversalEvents.loadingTIAGeneral();
			Events.clickButton(buttonAceptaSeleccion);
			TransversalEvents.loadingTIAGeneral();

			String objeto = Events.getAtributte(inputObjeto, "value");
			Validation.trueBooleanCondition(!objeto.equalsIgnoreCase(""),
					"La póliza se ha seleccionado correctamente, el No.Objeto es: " + objeto,
					"La póliza no se ha seleccionado correctamente");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(step = "Crea nuevo item", page = "Siniestro", functionality = "Siniestro")
	public static void crearNuevoItem() {

		try {
			Thread.sleep(1000);
			Events.clickButton(buttonNuevoItem);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona tipo de ítem dentro de las opciones disponibles", page = "Siniestro", functionality = "Siniestros")
	public static void seleccionarTipoItem(String tipoItem) {

		try {
			Thread.sleep(7000);
			Events.selectByContainsText(selectTipoItem, tipoItem);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona tipo de sub ítem dentro de las opciones disponibles", page = "Siniestro", functionality = "Siniestros")
	public static void seleccionarTipoSubItem(String tipoSubItem) {

		try {
			Thread.sleep(7000);
			Events.selectByContainsText(selectTipoSubItem, tipoSubItem);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona el receptor del pago en el cual se basa el ítem o reserva", page = "Siniestro", functionality = "Siniestros")
	public static void seleccionarReceptor(String idReceptor) {

		try {
			Events.clickButton(buttonBusquedaReceptor);
			Events.sendKeys(inputIdReceptor, idReceptor);
			Events.enter(inputIdReceptor);
			Events.clickButton(labelNombreReceptor);
			String nombreReceptor = Events.getText(labelNombreReceptor);
			String rolReceptor = Events.getText(labelRolReceptor);
			Events.clickButton(buttonAceptaSeleccion);
			Thread.sleep(7000);
			Utils.outputInfo("Se ha seleccionado el Receptor con Id: " + idReceptor + ", Nombre: " + nombreReceptor
					+ " y Rol: " + rolReceptor);
			validarNombreReceptor(nombreReceptor);
			validarRolReceptor(rolReceptor);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Inserta la reserva que corresponda según el tipo de siniestro", page = "Siniestro", functionality = "Siniestros")
	public static void insertarMontoReserva(String montoReserva) {

		try {
			Events.sendKeys(inputReserva, montoReserva);
			Validation.trueBooleanCondition(!montoReserva.equals(""),
					"Se ha introducido correctamente el valor de la reserva",
					"No se ha introducido correctamente el valor de la reserva");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Valida que se cargue automáticamente el nombre del Receptor", page = "Siniestro", functionality = "Siniestros")
	public static void validarNombreReceptor(String nombreReceptor) {

		try {

			String nombre = Events.getAtributte(inputNombreReceptor, "value");
			Validation.trueBooleanCondition(nombre.equalsIgnoreCase(nombreReceptor),
					"Se ha cargado correctamente el nombre del receptor",
					"No se ha cargado correctamente el nombre del receptor");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Valida que se cargue automáticamente el rol del Receptor", page = "Siniestro", functionality = "Siniestros")
	public static void validarRolReceptor(String rolReceptor) {

		try {

			String rol = Events.getAtributte(inputRolReceptor, "value");
			Validation.trueBooleanCondition(rol.equalsIgnoreCase(rolReceptor),
					"Se ha cargado correctamente el rol del receptor",
					"No se ha cargado correctamente el rol del receptor");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(step = "Se ingresa a la página para crear una reserva", page = "Siniestro", functionality = "Siniestro")
	public static void crearReserva() {

		try {

			Events.clickButton(buttonReserva);
			Thread.sleep(7000);
			String tittle = Events.getText(labelItems);
			Utils.outputInfo("La sección actual es: " + tittle);
			Validation.trueBooleanCondition(tittle.contains("Items"),
					"Se ha generado ingresado a la página para la creación de una reserva",
					"No se ha ingresado correctamente a la página de creación de reserva");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Valida que se cargue automáticamente el id del Liquidador", page = "Siniestro", functionality = "Siniestros")
	public static void validarIdLiquidador(String idLiquidador) {

		try {

			String nombre = Events.getAtributte(inputIdLiquidReceptor, "value");
			Validation.trueBooleanCondition(nombre.equalsIgnoreCase(idLiquidador),
					"Se ha cargado correctamente el Id del liquidador",
					"No se ha cargado correctamente el Id del liquidador");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona fecha de siniestro", page = "Siniestro", functionality = "Siniestros")
	public static void seleccionarFechaSiniestro() {
		try {
			Events.clickButton(buttonSeleccionarFechaSiniestro);
			Events.clickButton(buttonFechaSuperiorDiaActual);
			Events.clickButton(buttonAceptarFecha);
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona fecha de denuncia", page = "Siniestro", functionality = "Siniestros")
	public static void seleccionarFechaDenuncia() {

		try {
			Events.clickButton(buttonSeleccionarFechaDenuncia);
			Events.clickButton(buttonFechaSuperiorDiaActual);
			Events.clickButton(buttonAceptarFecha);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Valida mensaje de error en Fecha de siniestro superior al día actual", page = "Siniestro", functionality = "Siniestros")
	public static void validarMensajeErrorFechaSiniestroSuperiorDiaActual() {
		try {
			String mensaje = Events.getText(msgErrorFechaSiniestroSuperiorDiaActual);
			Utils.outputInfo("Ha aparecido el siguiente mensaje: " + mensaje);
			Validation.trueBooleanCondition(mensaje.contains("Fecha del siniestro"),
					"El mensaje ha aparecido correctamente ", "No  ha aparecido el mensaje correcto");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Valida mensaje de error en Fecha de denuncia superior al día actual", page = "Siniestro", functionality = "Siniestros")
	public static void validarMensajeErrorFechaDenunciaSuperiorDiaActual() {

		try {

			String mensaje = Events.getText(msgErrorFechaDenunciaSuperiorDiaActual);
			Utils.outputInfo("Ha aparecido el siguiente mensaje: " + mensaje);
			Validation.trueBooleanCondition(mensaje.contains("Fecha de denuncia"),
					"El mensaje ha aparecido correctamente ", "No  ha aparecido el mensaje correcto");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Valida mensaje de error en Fecha de siniestro superior que fecha de denuncia", page = "Siniestro", functionality = "Siniestros")
	public static void validarMensajeErrorFechaSiniestroSuperiorFechaDenuncia() {
		try {
			String mensaje = Events.getText(msgErrorFechaSiniestroSuperiorDenuncia);
			Utils.outputInfo("Ha aparecido el siguiente mensaje: " + mensaje);
			Validation.trueBooleanCondition(mensaje.contains("no cubren la fecha del siniestro"),
					"El mensaje ha aparecido correctamente ", "No  ha aparecido el mensaje correcto");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Valida mensaje de error en Fecha de siniestro en blanco", page = "Siniestro", functionality = "Siniestros")
	public static void validarMensajeErrorFechaSiniestroEnBlanco() {
		try {
			String mensaje = Events.getText(msgErrorFechaSiniestroEnBlanco);
			Utils.outputInfo("Ha aparecido el siguiente mensaje: " + mensaje);
			Validation.trueBooleanCondition(mensaje.contains("Debe introducir"),
					"El mensaje ha aparecido correctamente ", "No  ha aparecido el mensaje correcto");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona un gestor de siniestro", page = "Siniestro", functionality = "Siniestros")
	public static void seleccionarGestor(String gestor) {

		try {

			Events.sendKeys(inputIdGestor, gestor);
			Events.enter(inputIdGestor);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(step = "Se genera un siniestro en estado abierto", page = "Siniestro", functionality = "Siniestro")
	public static void generarSiniestro() {

		try {
			TransversalEvents.loadingTIAGeneral();
			Events.clickButton(buttonGenerarSiniestro);
			TransversalEvents.loadingTIAGeneral();
			Events.clickButton(buttonBarraLateral);
			Thread.sleep(3000);
			String tittle = Events.getText(labelNotificacionSiniestro);
			Events.clickButton(LabelDetalleSiniestro);
			String tittle2 = Events.getValue(labelSiniestro2);
			int inicio = tittle2.indexOf("-");
			int fin = tittle2.indexOf("(", inicio + 1);
			String idSiniestro = tittle2.substring(inicio + 2, fin - 1);
			Validation.trueBooleanCondition(tittle.contains("Notificación"),
					"Se ha generado el siniestro correctamente con ID: " + idSiniestro,
					"No se ha generado el siniestro de forma correcta");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(step = "Se genera un siniestro en estado abierto", page = "Siniestro", functionality = "Siniestro")
	public static void generarSiniestroAlt() {

		try {
			TransversalEvents.loadingTIAGeneral();
			Events.clickButton(buttonGenerarSiniestro);
			TransversalEvents.loadingTIAGeneral();
			Thread.sleep(1500);
			TransversalEvents.verificaBitacoraDesplegada();
			String tittle = Events.getText(labelNotificacionSiniestro);
			Events.clickButton(LabelDetalleSiniestro);
			String tittle2 = Events.getValue(labelSiniestro2);
			String idSiniestro = tittle2;// tittle2.substring(inicio + 2, fin - 1);
			Validation.trueBooleanCondition(tittle.contains("Notificación"),
					"Se ha generado el siniestro correctamente con ID: " + idSiniestro,
					"No se ha generado el siniestro de forma correcta");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(step = "Se genera un siniestro en estado abierto", page = "Siniestro", functionality = "Siniestro")
	public static void generarSiniestro(String nombEvento) {

		try {
			TransversalEvents.loadingTIAGeneral();
			Events.clickButton(buttonGenerarSiniestro);
			TransversalEvents.loadingTIAGeneral();
			TransversalEvents.verificaBitacoraDesplegada();
			String tittle = Events.getText(labelNotificacionSiniestro);
			String tittle2 = Events.getText(labelSiniestro.replace("Nom_producto", nombEvento));
			int inicio = tittle2.indexOf("-");
			int fin = tittle2.indexOf("(", inicio + 1);
			String idSiniestro = tittle2.substring(inicio + 2, fin - 1);
			Validation.trueBooleanCondition(tittle.contains("Notificación"),
					"Se ha generado el siniestro correctamente con ID: " + idSiniestro,
					"No se ha generado el siniestro de forma correcta");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona la póliza en el listado de pólizas del resumen de la entidad seleccionada previamente", page = "Manejo Poliza", functionality = "Endosos")
	public static void ingresarPoliza() {

		try {
			/*
			 * Events.clickButton(buttonOrdDesc); Thread.sleep(3000);
			 * Events.clickButton(buttonAmpliarVentanaPolizas);
			 * Events.clickButton(aPoliza.replace("id-poliza", PolizaProperties.idPoliza));
			 */
			Events.sendKeys(inputBusqueda, PolizaProperties.idPoliza);
			Events.clickButton(listOpciones);
			Robot robot2 = new Robot();
			robot2.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			robot2.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(1500);
			Events.scroll(buttonNuevoScroll);
			Thread.sleep(2000);
			String tituloPaginaPoliza = Events.getText(labelManejoPoliza);
			Utils.outputInfo("La sección actual es: " + tituloPaginaPoliza);
			Validation.trueBooleanCondition(tituloPaginaPoliza.contains(PolizaProperties.idPoliza),
					"Se ha ingresado a la póliza correcta: " + PolizaProperties.idPoliza,
					"No se ha ingresado a la póliza correctamente");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Ir a página Administración", page = "Administración")
	public static void cargarPaginaAdmin() {
		try {
			Events.clickButton(buttonAdministracion);
			loadingTIAGeneral();
			String paginaAdmin = Events.getText(labelPaginaAdmin);
			Validation.trueBooleanCondition(paginaAdmin.equalsIgnoreCase("Administración"),
					"Se ha cargado correctamente la página Administración",
					"No se ha cargado la página de Administración");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Ir a página Buscar item Cuenta", page = "Administración")
	public static void cargarPaginaBuscarItemCuenta() {
		try {
			Events.clickButton(buttonCuenta);
			loadingTIAGeneral();
			Events.clickButton(buttonCuenta2);
			loadingTIAGeneral();
			Events.clickButton(buttonCuenta3);
			loadingTIAGeneral();
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Buscar número de Item de Cuenta para factura de pago de cuota", page = "Administración")
	public static void buscarItem() {
		try {
			TransversalEvents.loadingTIAGeneral();
			Events.sendKeys(inputIdPoliza, PolizaProperties.idPoliza);
			loadingTIAGeneral();
			Events.clickButton(buttonBuscarItemCuenta);
			loadingTIAGeneral();
			PolizaProperties.noCuentaPagoCuota = Events.getText(labelNoCuenta);
			PolizaProperties.itemCuentaPagoCuota = Events.getText(labelItemCuenta);
			PolizaProperties.estadoPago = Events.getText(labelEstadoPago);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Seleccionar item para pago ", page = "Administración")
	public static void seleccionarItemPagar() {
		try {
			Events.clickButton(buttonPagosCobros);
			loadingTIAGeneral();
			Events.clickButton(buttonSeleccionarItemPagar);
			loadingTIAGeneral();
			Events.clickButton(buttonContinuar);
			loadingTIAGeneral();
			Events.selectByContainsText(selectMetodosPago, "CUPONERA Cuponera Digital");
			Events.sendKeys(inputNoCuenta, PolizaProperties.noCuentaPagoCuota);
			Events.clickButton(buttonItemCuenta);
			TransversalEvents.loadingTIAGeneral();
			Events.sendKeys(inputItemCuenta, PolizaProperties.itemCuentaPagoCuota);
			driver.findElement(By.xpath("(//input[contains(@id,'AccItemNoLovPC') and contains(@class,'x25')])[1]"))
					.sendKeys(Keys.ENTER);
			loadingTIAGeneral();
			Events.clickButton(labelItemCuentaSeleccionar.replace("no-item", PolizaProperties.itemCuentaPagoCuota));
			Events.clickButton(buttonAceptar1);
			loadingTIAGeneral();
			Events.clickButton(buttonSeleccionarPago);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Validar que se haya seleccionado el item de cuenta para realizar el pago", page = "Administración")
	public static void validarEstadoItemSeleccionado() {
		try {
			TransversalEvents.loadingTIAGeneral();
			buscarItem3();
			Validation.trueBooleanCondition(PolizaProperties.estadoPago.contains("2"),
					"Se ha seleccionado el item de cuenta para realizar pago  ",
					"No se ha seleccionado el item de cuenta");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Inicia el ajuste de una Póliza para realizar cancelaciones", page = "Manejo Póliza", functionality = "Cancelación")
	public static void ajustarPolizaTransversal(String tipoEndoso) {

		try {
			Events.clickButton(buttonAjustartransversal);
			Events.selectByContainsText(selectTipoEndosoTransversal, tipoEndoso);
			Events.clickButton(buttonAceptaAjusteTransversal);
			loadingTIAGeneral();

			String tipoTransaccion = Events.getText(labelTipoTransaccionTransversal);
			Validation.trueBooleanCondition(tipoTransaccion.contains("Ajuste"),
					"Se ha ingresado al ajuste de la póliza correctamente: ",
					"No se ha ingresado al ajuste de la póliza correctamente");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Buscar número de Item de Cuenta para factura de pago de cuota", page = "Administración")
	public static void buscarItem3() {
		try {
			Events.clickButton(buttonCuenta3);
			TransversalEvents.loadingTIAGeneral();
			Events.sendKeys(inputIdPoliza, PolizaProperties.idPoliza);
			TransversalEvents.loadingTIAGeneral();
			Events.clickButton(buttonBuscarItemCuenta);
			TransversalEvents.loadingTIAGeneral();
			PolizaProperties.noCuentaPagoCuota = Events.getText(labelNoCuenta);
			PolizaProperties.itemCuentaPagoCuota = Events.getText(labelItemCuenta);
			PolizaProperties.estadoPago = Events.getText(labelEstadoPago);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Crear pago para item seleccionado", page = "Administración")
	public static void crearPago() {
		try {
			Events.clickButton(buttonCrearPagoCobros);
			TransversalEvents.loadingTIAGeneral();
			Events.clickButton(buttonContinuar);
			TransversalEvents.loadingTIAGeneral();
			Events.selectByContainsText(selectMetodosPago, "CUPONERA Cuponera Digital");
			Events.sendKeys(inputNoCuenta, PolizaProperties.noCuentaPagoCuota);
			Events.sendKeys(inputItemCuenta2, PolizaProperties.itemCuentaPagoCuota);
			Thread.sleep(3000);
			Events.clickButton(buttonCrearPago);
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Buscar número de Item de Cuenta para factura de pago de cuota", page = "Administración")
	public static void buscarItem2() {
		try {
			Events.clickButton(buttonCuenta3);
			Events.clickButton(buttonContinuar);
			TransversalEvents.loadingTIAGeneral();
			Events.sendKeys(inputIdPoliza, PolizaProperties.idPoliza);
			TransversalEvents.loadingTIAGeneral();
			Events.clickButton(buttonBuscarItemCuenta);
			TransversalEvents.loadingTIAGeneral();
			PolizaProperties.noCuentaPagoCuota = Events.getText(labelNoCuenta);
			PolizaProperties.itemCuentaPagoCuota = Events.getText(labelItemCuenta);
			PolizaProperties.estadoPago = Events.getText(labelEstadoPago);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Validar monto revertido", page = "Administración")
	public static void validarMontoRevertido() {
		try {
			String montorevertido = Events.getText(labelMontorevertido);
			Validation.trueBooleanCondition(montorevertido.contains("-"), "Se ha revertido el pago correctamente",
					"No se ha realizado la reversión del pago");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Validar que se haya realizado el pago correctamente", page = "Administración")
	public static void validarEstadoEnviadoSistemaPago() {
		try {
			buscarItem3();
			Validation.trueBooleanCondition(PolizaProperties.estadoPago.contains("3"),
					"Se ha enviado el pago del a sistema correctamente", "No se ha enviado el pago");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona la póliza en el listado de pólizas del resumen de la entidad seleccionada previamente", page = "Manejo Poliza", functionality = "Endosos")
	public static void ingresarPolizaMA() {

		try {
			Events.clickButton(buttonAmpliarVentanaPolizas);
			Thread.sleep(1500);
			Events.clickButton(aPolizav3.replace("id-poliza", PolizaProperties.idPoliza));
			Thread.sleep(7000);
			String tituloPaginaPoliza = Events.getText(labelManejoPoliza);
			Utils.outputInfo("La sección actual es: " + tituloPaginaPoliza);
			Validation.trueBooleanCondition(tituloPaginaPoliza.contains(PolizaProperties.idPoliza),
					"Se ha ingresado a la póliza correcta: " + PolizaProperties.idPoliza,
					"No se ha ingresado a la póliza correctamente");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona la póliza en el listado de pólizas del resumen de la entidad seleccionada previamente", page = "Manejo Poliza", functionality = "Endosos")
	public static void ingresarPolizaBusquedaRapida() {

		try {
			Events.clickButton(labelHome);
			loadingTIAGeneral();

			String idP = PolizaProperties.idPoliza;

			WebElement elemnt = driver.findElement(By.xpath(inputBusquedaRapida));
			Actions builder = new Actions(driver);

			elemnt.clear();
			Events.sendKeys(inputBusquedaRapida, idP);
			Utils.takeAdditionalScreenshot(String.format("Busqueda de poliza %s", PolizaProperties.idPoliza), "extra");
			Action seriesOfActions = builder.keyDown(elemnt, Keys.ARROW_DOWN).keyUp(elemnt, Keys.ARROW_DOWN)
					.keyDown(elemnt, Keys.ENTER).build();
			// loadingTIAGeneral();
			Thread.sleep(3000);
			seriesOfActions.perform();

			loadingTIAGeneral();
			Events.clickButton(labelInformacionDelPago);
			loadingTIAGeneral();

			String tituloPaginaPoliza = Events.getText(labelManejoPoliza);
			Utils.outputInfo("La sección actual es: " + tituloPaginaPoliza);
			Validation.trueBooleanCondition(tituloPaginaPoliza.contains(PolizaProperties.idPoliza),
					"Se ha ingresado a la póliza correcta: " + PolizaProperties.idPoliza,
					"No se ha ingresado a la póliza correctamente");
			Utils.takeAdditionalScreenshot(String.format("despliegue de poliza %s", PolizaProperties.idPoliza),
					"extra");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona la póliza en el listado de pólizas del resumen de la entidad seleccionada previamente", page = "Manejo Poliza", functionality = "Endosos")
	public static void ingresarBusquedaRapida(String valorBuscarString) {
		try {
			Events.sendKeys(inputBusquedaRapida, valorBuscarString);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			
			Boolean rsLoading = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(loadingBusquedaRapida)));
			
			if (!rsLoading) {
				Utils.eventFailed("El tiempo de carga al buscar un elemento en busqueda rapida, excedio los 60 segundos");
			}
			
			Events.clickButton(listOpcionBusquedaRapida);
			WebElement elemento = driver.findElement(By.xpath(inputBusquedaRapida));
			elemento.sendKeys(Keys.ENTER);
			loadingTIAGeneral();
					
			
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}
	
//	@Context(description = "Renovar manualmente una póliza.", page = "Manejo Poliza", functionality = "Renovación")
//	public static void renovarPoliza() {
//		try {
//			Events.clickButton(buttonAmpliarVentanaPolizas);
//			Events.clickButton(buttonFechaRenovacionTEST);
//			Events.clickButton(OrderByASCRenovacion);
//			Events.clickButton(bPolizaRenovar.replace("id-poliza", PolizaProperties.idPoliza).replace("id-producto",PolizaProperties.idProducto)); //fallando
//			loadingTIAGeneral();
//			Events.clickButton(MuerteAccidentalElements.buttonRenovar);
//			String tituloPagina = Events.getText(labelPaginaRenovacion);
//			String polizaRenovar = Events.getText(labelPolizaRenovar);
//			Utils.outputInfo("Ha ingresado a la página: " + tituloPagina);
//			Validation.trueBooleanCondition(PolizaProperties.idPoliza.equals(polizaRenovar),
//					"Se ha cargado la página correctamente", "No se ha cargado la página correcta");
//			Events.clickButton(buttonRenovacion);
//			loadingTIAGeneral();
//			Events.clickButton(buttonCompletarRenovacion);
//			loadingTIAGeneral();
//			String nomDoc = Events.getText(labelModalDocumentosPoliza);
//			Validation.trueBooleanCondition(nomDoc.contains(PolizaProperties.idPoliza),String.format("Poliza a renovar %s correctamente", PolizaProperties.idPoliza) ,  "Poliza a renovar no es la correcta");
//			Events.clickButton(buttonAceptarRenovacion);
//			loadingTIAGeneral();
//			
//
//		} catch (Exception e) {
//			Utils.eventFailed(e.getMessage());
//		}
//	}

	@Context(description = "Renovar manualmente una póliza.", page = "Manejo Poliza", functionality = "Renovación")
	public static void renovarPoliza() {
		try {
			loadingTIAGeneral();
			Events.clickButton(buttonAmpliarVentanaPolizas);
			loadingTIAGeneral();

			String xpathSet = bPolizaRenovar.replace("id-poliza", PolizaProperties.idPoliza).replace("id-producto",
					PolizaProperties.idProducto);
			float contador = 0;
			while (true) {
				boolean rsElementVis = validarElementoPantalla(xpathSet);

				if (rsElementVis == true) {
					Events.clickButton(xpathSet);
					Utils.takeAdditionalScreenshot(
							String.format("Se hace click en la poliza %s", PolizaProperties.idPoliza), "extra");
					break;
				} else if (contador == 20) {
					Utils.eventFailed(
							String.format("No se encontro la póliza luego de realizar %.0f scroll/s", contador));
				}
				WebElement element = driver.findElement(By.xpath("//div[contains(@id,'CoverTreeTab::scroller')]"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop += 100;", element);
				Utils.outputInfo(String.format("Se han realizado %.0f scroll/s", contador += 1));
				loadingTIAGeneral();
			}

			loadingTIAGeneral();
			Events.clickButton(buttonRenovar);
			String tituloPagina = Events.getText(labelPaginaRenovacion);
			String polizaRenovar = Events.getText(labelPolizaRenovar);
			Utils.outputInfo("Ha ingresado a la página: " + tituloPagina);
			Validation.trueBooleanCondition(PolizaProperties.idPoliza.equals(polizaRenovar),
					"Se ha cargado la página correctamente", "No se ha cargado la página correcta");
			Events.clickButton(buttonRenovacion);
			loadingTIAGeneral();
			Utils.takeAdditionalScreenshot("Despliegue ventana renovacion", "extra");
			Events.clickButton(buttonCompletarRenovacion);
			loadingTIAGeneral();
			Utils.takeAdditionalScreenshot("Despliegue confirmacion renovacion", "extra");
			String nomDoc = Events.getText(labelModalDocumentosPoliza);
			Validation.trueBooleanCondition(nomDoc.contains(PolizaProperties.idPoliza),
					String.format("Poliza a renovar %s correctamente", PolizaProperties.idPoliza),
					"Poliza a renovar no es la correcta");
			Events.clickButton(buttonAceptarRenovacion);
			loadingTIAGeneral(180);
			Utils.takeAdditionalScreenshot("Finalizacion renovacion", "extra");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona el tipo de endoso que se modificará posteriormente", page = "Manejo Poliza", functionality = "Endosos")
	public static void seleccionarTipoEndoso(String tipoEndoso) {

		try {
			loadingTIAGeneral();
			Events.clickButton(buttonAjustarPoliza);
			loadingTIAGeneral();
			Events.selectByContainsText(selectTipoEndoso, tipoEndoso);
			Events.clickButton(buttonAceptarAjuste);
			loadingTIAGeneral();
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona el Objeto en el árbol de pólizas de la entidad seleccionada previamente", page = "Manejo Objeto", functionality = "Endosos")
	public static void ingresarObjeto(String nombre) {

		try {
			TransversalEvents.loadingTIAGeneral();
			Events.clickButton(buttonCerrarSegventana);
			TransversalEvents.loadingTIAGeneral();
			TransversalEvents.seleccionarContratante(nombre);
			TransversalEvents.loadingTIAGeneral();
			Events.clickButton(buttonAmpliarVentanaPolizas);
			TransversalEvents.loadingTIAGeneral();
			Events.clickButton(aPolizav3.replace("id-poliza", PolizaProperties.idPoliza));
			TransversalEvents.loadingTIAGeneral();
			Events.clickButton(aObjeto.replace("id-objeto", PolizaProperties.idObjeto));
			String tituloPaginaObjeto = Events.getText(labelManejoObjeto);
			Utils.outputInfo("La sección actual es: " + tituloPaginaObjeto);
			Validation.trueBooleanCondition(tituloPaginaObjeto.contains(PolizaProperties.idObjeto),
					"Se ha ingresado al objeto correcto: " + PolizaProperties.idObjeto,
					"No se ha ingresado al objeto correctamente");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona el Objeto en el árbol de pólizas de la entidad seleccionada previamente", page = "Manejo Objeto", functionality = "Endosos")
	public static void ingresarObjeto() {

		try {
			Events.clickButton(aObjeto.replace("id-objeto", PolizaProperties.idObjeto));
			TransversalEvents.loadingTIAGeneral();
			String tituloPaginaObjeto = Events.getText(labelManejoObjeto);
			Utils.outputInfo("La sección actual es: " + tituloPaginaObjeto);
			Validation.trueBooleanCondition(tituloPaginaObjeto.contains(PolizaProperties.idObjeto),
					"Se ha ingresado al objeto correcto: " + PolizaProperties.idObjeto,
					"No se ha ingresado al objeto correctamente");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Inicia el ajuste de un Objeto para realizar algún tipo de endoso actualizando fecha de ajuste", page = "Manejo Objeto", functionality = "Endosos")
	public static void ajustarObjeto(String fechaAjuste) {

		try {
			Events.clickButton(buttonAjustar);
			Events.sendKeys(inputFechaAjuste, fechaAjuste);
			Events.clickButton(buttonAceptaAjuste);
			String estadoPaginaEdicion = Events.getAtributte(labelEditarActivado, "title");
			Validation.trueBooleanCondition(estadoPaginaEdicion.contains("Activado"),
					"Se ha ingresado al ajuste del objeto correctamente: ",
					"No se ha ingresado al ajuste del objeto correctamente");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Inicia el ajuste de un Objeto para realizar algún tipo de endoso con fecha de ajuste por defecto", page = "Manejo Objeto", functionality = "Endosos")
	public static void ajustarObjeto() {

		try {
			loadingTIAGeneral(60);
			Events.clickButton(buttonAjustar);
			Events.clickButton(buttonAceptaAjuste);
			loadingTIAGeneral(60);
			String estadoPaginaEdicion = Events.getAtributte(labelEditarActivado, "title");
			Validation.trueBooleanCondition(estadoPaginaEdicion.contains("Activado"),
					"Se ha ingresado al ajuste del objeto correctamente: ",
					"No se ha ingresado al ajuste del objeto correctamente");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona id de una entidad para acceder a su información", page = "Manejo entidad", functionality = "Endosos")
	public static void seleccionarEntidad(String idEntidad) {

		try {
			Events.clickButton(aEntidad.replace("id-entidad", idEntidad));
			String paginaInformacionEntidad = Events.getText(labelPaginaInformacionEntidad);
			Validation.trueBooleanCondition(paginaInformacionEntidad.contains("Información de la entidad"),
					"Se ha ingresado correctamente a la información de la entidad: " + idEntidad,
					"No se ha ingresado a la información de la entidad correctamente");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Buscar entidad por su Id", page = "Buscar Entidades", functionality = "Transversal")
	public static void buscarEntidadAlternativo(String idEntidad) {
		try {
			Events.clickButton(aBuscarEntidad);
			Events.sendKeys(inputIdEntidad, idEntidad);
			Events.clickButton(buttonBuscarEntidad);
			Events.clickButton(aEntidad.replace("id-entidad", idEntidad));
			Thread.sleep(5000);
			String tituloPagina = Events.getText(labelPaginaResumenEntidad);
			Utils.outputInfo("La sección actual es: " + tituloPagina);
			Validation.trueBooleanCondition(tituloPagina.contains("Resumen de entidad"),
					"Se ha ingresado al resumen de la entidad correctamente: " + idEntidad,
					"No se ha ingresado al resumen de la entidad");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Cierra la página de Búsqueda Entidades", page = "Pagina Búsqueda", functionality = "Transversal")
	public static void cerrarPaginaBusqueda() {
		try {
			Thread.sleep(5000);
			Events.clickButton(aCerrarPaginaBusqueda);
			Thread.sleep(10000);
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Ir a la página Home", page = "Pagina Home", functionality = "Transversal")
	public static void visitarPaginaHome() {
		try {
			TransversalEvents.loadingTIAGeneral();
			Events.clickButton(aHome);
			TransversalEvents.loadingTIAGeneral();
			String tittle = Events.getText(labelPaginaPrincipal);
			Utils.outputInfo("La sección actual es: " + tittle);
			Validation.trueBooleanCondition(tittle.contains("Página principal"),
					"Se ha ingresado a la Página Principal",
					"No se ha ingresado a la Página Principal de forma correcta");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Inicia el ajuste de una Póliza para realizar cancelaciones", page = "Manejo Póliza", functionality = "Cancelación")
	public static void ajustarPoliza(String fechaAjuste) {

		try {
			Events.clickButton(buttonAjustar);
			Events.sendKeys(inputFechaAjuste, fechaAjuste);
			Events.clickButton(buttonAceptaAjuste);
			String tipoTransaccion = Events.getText(labelTipoTransaccion);
			Validation.trueBooleanCondition(tipoTransaccion.contains("Ajuste"),
					"Se ha ingresado al ajuste de la póliza correctamente: ",
					"No se ha ingresado al ajuste de la póliza correctamente");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Inicia el ajuste de una Póliza para realizar cancelaciones", page = "Manejo Póliza", functionality = "Cancelación")
	public static void ajustarPoliza() {

		try {
			Events.clickButton(buttonAjustar);
			Events.clickButton(buttonAceptaAjuste);
			Thread.sleep(7000);
			String tipoTransaccion = Events.getText(labelTipoTransaccion);
			Validation.trueBooleanCondition(tipoTransaccion.contains("Ajuste"),
					"Se ha ingresado al ajuste de la póliza correctamente: ",
					"No se ha ingresado al ajuste de la póliza correctamente");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona el motivo de cancelación", page = "Manejo Póliza", functionality = "Cancelación")
	public static void seleccionarMotivoCancelacionPoliza(String motivoCancelacion) {
		try {
			Events.selectByContainsText(selectMotivoCancelacion, motivoCancelacion);
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Valida estado de cancelación", page = "Manejo Póliza", functionality = "Cancelación")
	public static void validarTransaccionCancelacionPoliza() {
		try {
			String tipoTransaccion = Events
					.getText(labelPolizaCancelada2.replace("id-poliza", PolizaProperties.idPoliza));
			Validation.trueBooleanCondition(tipoTransaccion.contains("- Cancelado"),
					"El estado de la póliza: " + PolizaProperties.idPoliza + tipoTransaccion,
					"No se ha cancelado la póliza correctamente");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Valida estado de cancelación", page = "Manejo Póliza", functionality = "Cancelación")
	public static void validarTransaccionCancelacionPolizaMR() {
		try {
			Events.clickButton(labelIngresarPoliza.replace("id-poliza", PolizaProperties.idPoliza));
			Thread.sleep(3000);

			String tipoTransaccion = Events.getText(labelEstadoPolizaCancelada);
			Validation.trueBooleanCondition(tipoTransaccion.contains("Cancelar"),
					"El estado de la póliza: " + PolizaProperties.idPoliza + " " + tipoTransaccion,
					"No se ha cancelado la póliza correctamente");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Valida endoso de objeto", page = "Manejo Póliza", functionality = "Cancelación")
	public static void validarEndoso() {
		try {
			String tipoTransaccion = Events.getText(labelTipoTransaccion);
			Validation.trueBooleanCondition(tipoTransaccion.contains("Ajuste"),
					"Se ha realizado el ajuste correctamente, el código de transacción es :" + tipoTransaccion,
					"No se ha realizado el ajuste correctamente");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Esperar la actualziacion de la ventana/modulo", page = "Manejo de objetos", functionality = "Transversal")
	public static void loadingTIAGeneral() {
		try {
			WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(50));
			LocalDateTime horaAntesEjeDateTime = LocalDateTime.now();

			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(loadingTia)));

			LocalDateTime horaDespsEjeDateTime = LocalDateTime.now();

			Utils.outputInfo(String.format("La espera de carga finalizo luego de %s segundos con una espera configurada de 50 segundos", 
					String.valueOf(
							horaDespsEjeDateTime.toEpochSecond(java.time.ZoneOffset.UTC) - 
							horaAntesEjeDateTime.toEpochSecond(java.time.ZoneOffset.UTC))));
			
		} catch (Exception e) {
			Utils.eventFailed(String.format("La espera de carga en TIA excedio el tiempo de %s segundos", "50"));
		}
	}

	@Context(description = "Esperar la actualziacion de la ventana/modulo", page = "Manejo de objetos", functionality = "Transversal")
	public static void loadingTIAGeneral(long tiempoEspera) {
		try {
			WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(tiempoEspera));

			LocalDateTime horaAntesEjeDateTime = LocalDateTime.now();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(loadingTia)));
			LocalDateTime horaDespsEjeDateTime = LocalDateTime.now();
			Utils.outputInfo(String.format("La espera de carga finalizo luego de %s segundos con una espera configurada de %s segundos", 
											String.valueOf(horaDespsEjeDateTime.toEpochSecond(java.time.ZoneOffset.UTC) - horaAntesEjeDateTime.toEpochSecond(java.time.ZoneOffset.UTC)), 
											String.valueOf(tiempoEspera)));


		} catch (Exception e) {
			Utils.eventFailed(String.format("La espera de carga en TIA excedio el tiempo de %s segundos",
					String.valueOf(tiempoEspera)));
		}
	}

	@Context(description = "Selecciona una póliza en el listado de pólizas del resumen de la entidad seleccionada previamente", page = "Manejo Poliza", functionality = "Renovación")
	public static void ingresarPoliza(String idPoliza) {
		try {
			Events.clickButton(aOrdenarFechaRenov);
			Thread.sleep(5000);
			Events.clickButton(buttonAmpliarVentanaPolizas);
			Events.clickButton(aPoliza.replace("id-poliza", idPoliza));
			Thread.sleep(7000);
			String tituloPaginaPoliza = Events.getText(labelManejoPoliza);
			Utils.outputInfo("La sección actual es: " + tituloPaginaPoliza);
			Validation.trueBooleanCondition(tituloPaginaPoliza.contains(idPoliza),
					"Se ha ingresado a la póliza correcta: " + idPoliza,
					"No se ha ingresado a la póliza correctamente");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(step = "Selecciona la fecha de siniestro", page = "Manejo Objeto", functionality = "Siniestro")
	public static void seleccionarFechaDiaHoy() {

		try {
			TransversalEvents.loadingTIAGeneral();
			Events.clickButton(buttonSeleccionarFechaSiniestro);
			TransversalEvents.loadingTIAGeneral();
			Events.clickButton(buttonAceptarFecha);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(step = "Selecciona la fecha de siniestro", page = "Manejo Objeto", functionality = "Siniestro")
	public static void seleccionarFechaDenunciaDiaSiguiente() {

		try {
			TransversalEvents.loadingTIAGeneral();

			//
			LocalDateTime hora = LocalDateTime.now();
			DateTimeFormatter fa = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
			String fecha = hora.plusDays(1).format(fa);
			System.out.println("Fecha de mañana = " + fecha);
			//

			Events.sendKeys(inputFechaDenuncia1, fecha);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(step = "Selecciona la fecha de siniestro", page = "Manejo Objeto", functionality = "Siniestro")
	public static void seleccionarFechaDenunciaDiaSiguiente2() {

		try {
			TransversalEvents.loadingTIAGeneral();
			//
			LocalDateTime hora = LocalDateTime.now();
			DateTimeFormatter fa = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
			String fecha = hora.plusDays(1).format(fa);
			System.out.println("Fecha de mañana = " + fecha);
			//

			Events.sendKeys(buttonAceptarFecha, fecha);

			TransversalEvents.loadingTIAGeneral();
			Events.clickButton(buttonAceptarFecha);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Valida que la poliza ha sido renovada de forma automática", page = "Manejo Poliza", functionality = "Renovacion")
	public static void validarRenovacionAutomatica() {
		try {
			Events.clickButton(buttonDetallesRenovacion);
			String tituloPaginaDetallesRenovacion = Events.getText(labelDetallesRenovacion);
			Utils.outputInfo("La sección actual es: " + tituloPaginaDetallesRenovacion);
			String loteRenovacion = Events.getText(labelLoteRenovacion);
			Validation.trueBooleanCondition(!tituloPaginaDetallesRenovacion.contains(" "),
					"Se ha realizado la renovación automática de forma correcta. El lote de renovación es: "
							+ loteRenovacion,
					"No se ha realizado la renovación automática correctamente. Se muestra el siguiente mensaje: "
							+ Events.getText(labelNoRenovacion));
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(step = "Selecciona la fecha en que se realiza la factura", page = "Manejo Objeto", functionality = "Siniestro")
	public static void seleccionarFechaFactura() {

		try {
			TransversalEvents.loadingTIAGeneral();
			Events.clickButton(buttonSeleccionarFechaHora);
			TransversalEvents.loadingTIAGeneral();
			LocalDate fechaHoy = LocalDate.now();
			int numDiaHoy = fechaHoy.getDayOfMonth();
			String diaString = String.valueOf(numDiaHoy);
			Events.clickButton(buttonDiaFactura.replace("dia", diaString));

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(step = "Selecciona la fecha de siniestro", page = "Manejo Objeto", functionality = "Siniestro")
	public static void seleccionarFechaDenunciaDiaAnterior() {

		try {
			TransversalEvents.loadingTIAGeneral();
			Events.clickButton(buttonSeleccionarFechaDenuncia);
			TransversalEvents.loadingTIAGeneral();
			LocalDate fechaHoy = LocalDate.now();
			int numDiaSiguiente = (fechaHoy.getDayOfMonth()) - 1;
			String diaString = String.valueOf(numDiaSiguiente);
			Events.clickButton(buttonSeleccionarDiaHora.replace("dia", diaString));
			TransversalEvents.loadingTIAGeneral();
			Events.clickButton(buttonAceptarFecha);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Seleccionar siniestro actual para modificar valor de reserva.")
	public static void seleccionarSiniestroLista(String nuevoValorReserva) {
		try {
			TransversalEvents.loadingTIAGeneral();
			Events.clickButton(checkBoxSeleccionSiniestro);
			TransversalEvents.loadingTIAGeneral();
			Events.sendKeys(inputReservaPagosReserva, nuevoValorReserva);
			TransversalEvents.loadingTIAGeneral();
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}

	}

	@Context(description = "Liquida un item de una reserva", page = "Reserva", functionality = "Siniestros")
	public static void liquidarReserva(String monto) {
		try {
			Events.clickButton(aRerservasPagos);
			String tituloPaginaReservaPagos = Events.getText(labelPagosReservas);
			Utils.outputInfo("La sección actual es: " + tituloPaginaReservaPagos);
			Events.clickButton(selectItemsPagar);
			Thread.sleep(2000);
			Events.clickButton(buttonLiquidar);
			String tituloVentanaPago = Events.getText("//div[contains(text(),'Pago')]");
			Validation.trueBooleanCondition(tituloVentanaPago.contains("Pago"),
					"Se ha cargado la ventana para ejecutar el pago correctamente",
					"No se ha cargado la ventana para ejecutar el pago");
			// se define monto y indicar realizar el pago
			Events.sendKeys(inputMontoLiquid, monto);
			Events.clickButton(buttonSiguiente);
			Events.clickButton(buttonSeleccionaInstPago);
			Events.clickButton(labelInstPago);
			Events.clickButton(buttonAceptaInstPago);
			Thread.sleep(2000);
			Events.clickButton(buttonSiguiente);
			Events.clickButton(buttonFinalizarPago);
			Thread.sleep(2000);
			// validar que se muestre lo pagado en
			String montoPagado = Events.getText(labelPaid);
			Validation.trueBooleanCondition(!montoPagado.equalsIgnoreCase(""),
					"La liquidación se ha realizado correctamente, el monto pagado es: " + montoPagado,
					"No se ha realizado la liquidación correctamente");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Recalcula la prima de la póliza ante un endoso complejo", page = "Manejo Objeto", functionality = "Endoso")
	public static void calcularPrimaTotalEndosoComplejo() {

		try {
			String primaTotalAntesEndoso = Events.getText(labelPrimaTotal);
			Events.clickButton(buttonCalculate);
			loadingTIAGeneral();
			String primaTotalDespuesEndoso = Events.getText(labelPrimaTotal);
			Validation.trueBooleanCondition(!primaTotalAntesEndoso.equals(primaTotalDespuesEndoso),
					"Ha sido calculada correctamente la nueva prima, cambió de " + primaTotalAntesEndoso + " a "
							+ primaTotalDespuesEndoso,
					"No se ha calculado correctamente la nueva prima");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Crea siniestro de forma alternativa, desde el manejo de una póliza", page = "Manejo de póliza", functionality = "Siniestros")
	public static void crearSiniestroCreateClaim() {

		try {
			// OncologicoEvents.validarDespliegueSiniestro();
			Thread.sleep(15000);
			Events.clickButton(buttonCreateclaim);
			String tittle = Events.getText(labelPaginaSiniestro);
			Utils.outputInfo("La sección actual es: " + tittle);
			Validation.trueBooleanCondition(tittle.contains("Crear siniestro"),
					"Se ha ingresado a la página para la creación de un siniestro",
					"No se ha ingresado correctamente para crear un siniestro");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Crea siniestro de forma alternativa, desde el manejo de una póliza", page = "Manejo de póliza", functionality = "Siniestros")
	public static void crearSiniestroCreateClaimAlt() {

		try {
			// OncologicoEvents.validarDespliegueSiniestro();
			Thread.sleep(15000);
			Events.clickButton(buttonCreateclaim);
			String tittle = Events.getText(labelPaginaSiniestro);
			Utils.outputInfo("La sección actual es: " + tittle);
			Validation.trueBooleanCondition(tittle.contains("Crear siniestro"),
					"Se ha ingresado a la página para la creación de un siniestro",
					"No se ha ingresado correctamente para crear un siniestro");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Crea siniestro de forma alternativa, desde el manejo de una póliza", page = "Manejo de póliza", functionality = "Siniestros")
	public static void tab() {

		try {
			WebElement elemnt = driver.findElement(By.xpath(inputFechaSiniestro));

			Actions builder = new Actions(driver);
			Action seriesOfActions = builder.keyDown(elemnt, Keys.TAB).keyUp(elemnt, Keys.TAB).build();
			Thread.sleep(5000);
			seriesOfActions.perform();

			String tittle = Events.getText(labelSiniestroError);
			Utils.outputInfo("Se ha mostrado el mensaje: " + tittle);
			Validation.trueBooleanCondition(tittle.contains("Error"), "Se ha mostrado el mensaje de Error",
					"No se ha mostrado el mensaje de Error");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Scroll arriba", page = "Manejo Poliza", functionality = "Endosos")
	public static void scrollArriba() {

		try {
			Thread.sleep(1500);
			Events.scroll(buttonNuevoScroll);
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona la póliza en el listado de pólizas del resumen de la entidad seleccionada previamente", page = "Manejo Poliza", functionality = "Endosos")
	public static void ingresarPolizaV2() {

		try {
			Events.clickButton(clicEntidad);
			TransversalEvents.loadingTIAGeneral();

			String tituloClicPoliza = Events.getText(clicPoliza);
			Events.clickButton(clicPoliza);
			TransversalEvents.loadingTIAGeneral();

			String tituloPaginaPoliza = Events.getText(labelManejoPoliza);
			Utils.outputInfo("La sección actual es: " + tituloPaginaPoliza);
			Validation.trueBooleanCondition(tituloPaginaPoliza.contains(tituloClicPoliza),
					"Se ha ingresado a la póliza correcta: " + PolizaProperties.idPoliza,
					"No se ha ingresado a la póliza correctamente");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Validar que el módulo Siniestro se encuentre desplegado ", page = "Manejo de objetos")
	public static void validarDespliegueSiniestro() {
		try {

			WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));

			if (!BaseTest.driver.findElements(By.xpath(collapseSiniestroHF)).isEmpty()) {
				WebElement element = BaseTest.driver.findElement(By.xpath(collapseSiniestroHF));

				wait.until(ExpectedConditions.visibilityOf(element));

				String buttonName = Events.getName(element, collapseSiniestroHF);
				Actions actions = new Actions(BaseTest.driver);

				actions.moveToElement(element).perform();

				if (element.isEnabled()) {
					element.click();
					Utils.outputInfo("Se ha hecho clic en el botón: " + buttonName);
				}
				loadingTIAGeneral();
			} else {
				Utils.outputInfo("Modulo Siniestro se encuentra desplegado");
			}

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}

	}

	@Context(step = "Verifica si está despleagada la bitácora del Siniestro", page = "Siniestro", functionality = "Siniestro")
	public static void verificaBitacoraDesplegada() {

		try {
			String bitacoraDesplegado = Events.getAtributte(buttonBarraLateralHF, "aria-expanded");
			if (!bitacoraDesplegado.equals("true")) {
				Events.clickButton(buttonBarraLateralHF);
			}

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona la fecha de inicio de cobertura de la póliza", page = "Manejo Póliza", functionality = "Emision")
	public static void seleccionarFechaInicioPoliza() {

		try {
			Events.clickButton(buttonSeleccionarFechaInicioPoliza);
			Events.clickButton(buttonDisminuirAnnoPoliza);
			Events.clickButton(buttonSeleccionarDia);
			Utils.takeAdditionalScreenshot("Se ingresa fecha inicio de póliza", "extra");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Manejo de abertura de secciones barra lateral izquierda", page = "Manejo Póliza", functionality = "Transversal")
	public static void desplegarSeccionBarraLateral(String nombreSeccion) {
		try {

			loadingTIAGeneral(5);

			boolean rsValidacionBoolean = validarElementoPantalla(
					collapseLateralBar.replace("nombre-seccion", nombreSeccion));

			if (rsValidacionBoolean == true) {
				List<WebElement> elements = BaseTest.driver
						.findElements(By.xpath(collapseLateralBar.replace("nombre-seccion", nombreSeccion)));
				elements.get(0).click();
				loadingTIAGeneral(40);
				Utils.takeAdditionalScreenshot(String.format("Se desplego el elemento %s", nombreSeccion), "extra");
			} else {
				Utils.outputInfo(String.format("El elemento %s ya se encontraba desplegado", nombreSeccion));
				Utils.takeAdditionalScreenshot(
						String.format("El elemento %s ya se encontraba desplegado", nombreSeccion), "extra");

			}

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());

		}
	}

	@Context(description = "Manejo de estados de pólizas", page = "Manejo Póliza", functionality = "Transversal")
	public static void validarEstadoPoliza(String estadoPoliza) {
		try {
			loadingTIAGeneral();
			String estadoPolString = Events.getText(labelEstadoTransaccion);

			Validation.trueBooleanCondition(
					estadoPolString.trim().toLowerCase().contains(estadoPoliza.trim().toLowerCase()),
					String.format("Poliza con estado %s ", estadoPoliza.toUpperCase()),
					String.format("Se esperaba una póliza con estado %s y se visualiza con estado %s ",
							estadoPoliza.toUpperCase(), estadoPolString.toUpperCase()));
			Utils.takeAdditionalScreenshot(String.format("Poliza con estado %s correctamente", estadoPoliza), "extra");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}

	}

	@Context(description = "Confirmar despliegue de elemtentos en pantalla", page = "Manejo Elementos", functionality = "Transversal")
	public static boolean validarElementoPantalla(String xpathString) {
		try {
			WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(3));

			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpathString))));
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Context(description = "Ingresar en resumen entidad", page = "Manejo Elementos", functionality = "Transversal")
	public static void ingresarResumenEntidad() {
		try {
			boolean rsValidacion = validarElementoPantalla(collapseLateralBar.replace("nombre-seccion", "Relaciones"));
			if (rsValidacion == true) {
				Events.clickButton(aNombreEntidadSeccionRelacion);
				loadingTIAGeneral();
			}
			loadingTIAGeneral();
			Events.clickButton(aNombreEntidadSeccionRelacion);
			loadingTIAGeneral();
			String resumen = Events.getText(labelPaginaResumenEntidad);

			Validation.trueBooleanCondition(resumen.trim().toLowerCase().contains("resumen de entidad"),
					"Se ha retornado de forma correcta a la ventana Resumen de Entidad",
					"No se redirecciono a la ventana Resumen de entidad");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}

	}

	@Context(description = "Despliegue de modulos", page = "Manejo Elementos", functionality = "Transversal")
	public static void validarDespliegueModulos(String xpathString) {

		try {
			boolean rsVal = validarElementoPantalla(xpathString);
			if (rsVal == true) {
				Events.scroll(xpathString);
				Events.clickButton(xpathString);
				loadingTIAGeneral(60);
			} else {
				Utils.outputInfo("El elemento ya se encuentra desplegado");
			}

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}

	}

	@Context(step = "Selecciona una fecha anterior para una poliza a siniestrar.", page = "Manejo Objeto", functionality = "Siniestro")
	public static void seleccionarFechaPolizaDosDiasAntes() {

		try {
			loadingTIAGeneral();

			//
			LocalDateTime fechaDiaAnterior = LocalDateTime.now();
			DateTimeFormatter fa = DateTimeFormatter.ofPattern("dd.MM.yyyy");
			String fecha = fechaDiaAnterior.plusDays(-2).format(fa);
			System.out.println("Fecha actual = " + fecha);
			//

			Events.sendKeys(fechaInicioPoliza, fecha);
			loadingTIAGeneral();
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona el tipo de endoso que se modificará posteriormente", page = "Manejo Poliza", functionality = "Endosos")
	public static void seleccionarTipoEndosoConDiasPosterior(String tipoEndoso) {

		try {
			loadingTIAGeneral();
			Events.clickButton(buttonAjustarPoliza);
			loadingTIAGeneral();
			String fechaSiniestro = LocalDateTime.now().plusDays(30).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
			Events.sendKeys(inputFechaAjuste, fechaSiniestro);
			Events.selectByContainsText(selectTipoEndoso, tipoEndoso);
			Events.clickButton(buttonAceptarAjuste);
			loadingTIAGeneral();
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Seleccionar evento en siniestro ", page = "Manejo de objetos")
	public static void seleccionarEvento(String opcionEvento) {
		try {
			String opcionRetornadaString = Events.selectByContainsText(selectListaEvento, opcionEvento);
			// TransversalEvents.loadingTIAGeneral();
			Validation.trueBooleanCondition(opcionRetornadaString.contains(opcionEvento),
					String.format("Se selecciono correctamente la opción %s", opcionEvento),
					String.format("No se encontro el valor %s dentro del listado del Evento", opcionEvento));
			TransversalEvents.loadingTIAGeneral();
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}

	}

	@Context(description = "Seleccionar Causa en siniestro ", page = "Manejo de objetos")
	public static void seleccionarCausa(String opcionCausa) {
		try {
			String opcionRetornadaString = Events.selectByContainsText(selectCasua, opcionCausa);
			// TransversalEvents.loadingTIAGeneral();
			Validation.trueBooleanCondition(opcionRetornadaString.contains(opcionCausa),
					String.format("Se selecciono correctamente la opción %s en el listado de Causa", opcionCausa),
					String.format("No se encontro el valor %s dentro del listado de la causa", opcionCausa));
			TransversalEvents.loadingTIAGeneral();
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}

	}

	@Context(description = "Validar selección de cobertura", page = "Manejo de objetos")
	public static void seleccionarNumeroCobertura() {
		try {
			Events.clickButton(spanBuscarNumeroCobertura);
			TransversalEvents.loadingTIAGeneral();
			Events.clickButton(labelCoberturaActiva);
			Events.clickButton(buttonAceptar);
			TransversalEvents.loadingTIAGeneral();

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}

	}

	@Context(description = "Validar el rellenado de la subcobertura de forma automatica ", page = "Manejo de objetos")
	public static void validarLlenadoSubCoberturaAutomatico() {
		try {
			String opcionSeleccionada = Events.getAtributte(selectSubCoberturaNumero, "textContent");
			Validation.trueBooleanCondition(opcionSeleccionada.trim() != null || opcionSeleccionada.trim() != "",
					String.format("Se selecciono correctamente la opción %s de forma auotmatiza", opcionSeleccionada),
					"No se realizo de forma automatica el llenado del campo 'Sub Cobertura N°'");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}

	}
	
	@Context(description = "Selecciona plataforma de venta del producto", page = "Manejo Póliza", functionality = "Emision")
	public static void seleccionarPlataforma(String plataforma) {

		try {
			loadingTIAGeneral();
			Events.clickButton(selectPlataforma);
			loadingTIAGeneral();
			String rtContenido = Events.selectByContainsText(selectPlataforma, plataforma);
			Utils.takeAdditionalScreenshot(String.format("Se selecciona la plataforma %s", rtContenido), "extra");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}
	
	@Context(description = "Selecciona el canal de venta del producto", page = "Manejo Póliza", functionality = "Emision")
	public static void seleccionarAgente(String numAgente) {

		try {
			loadingTIAGeneral(60);
			validarDespliegueModulos(imgDespliegueModuloInteroObjeto.replace("TituloModulo", "Agentes de pólizas"));
			loadingTIAGeneral();
			Events.clickButton(buttonNuevoAgente);
			loadingTIAGeneral();
			Events.clickButton(selectCategoriaAgente);
			loadingTIAGeneral();
			String rtContenido = Events.selectByContainsText(selectCategoriaAgente, "Corredor");
			Utils.takeAdditionalScreenshot(String.format("Se selecciona la opción %s", rtContenido), "extra");
			Events.clickButton(imgBuscarNumAgente);
			loadingTIAGeneral();
			Events.clickButton(buttonSeleccionarCorredor.replace("numAgente", numAgente));
			loadingTIAGeneral();
			Events.clickButton(buttonAceptar1);
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}
}
