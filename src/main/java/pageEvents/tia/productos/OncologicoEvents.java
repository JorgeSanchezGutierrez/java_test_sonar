package main.java.pageEvents.tia.productos;

import main.java.pageObjects.tia.productos.OncologicoElements;
import main.java.pageObjects.tia.transversal.TransversalElements;
import main.java.properties.PolizaProperties;
import main.java.properties.SiniestroProperties;
import main.java.utils.Events;
import test.java.BaseTest;
import main.java.config.Context;
import main.java.config.Utils;
import main.java.config.Validation;
import main.java.pageEvents.tia.transversal.TransversalEvents;

import java.time.Duration;
import java.util.Arrays;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OncologicoEvents implements OncologicoElements, TransversalElements {

	@Context(description = "Busca un asegurado distinto al contratante", page = "Manejo de objetos")
	public static void buscarAsegurado(String apellido) {

		try {
			Events.clickButton(aBuscarAsegurado);
			Events.sendKeys(inputApellido, apellido);
			Events.clickButton(buttonBuscarEntidad);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona un plan de salud", page = "Manejo de objetos")
	public static void seleccionarPlan(String plan) {

		try {
			Events.selectByContainsText(selectPlan, plan);
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona un tipo de cobertura", page = "Manejo de objetos")
	public static void seleccionarTipoCobertura(String tipoCobertura) {

		try {
			Events.selectByContainsText(selectCobertura, tipoCobertura);
			Thread.sleep(6000);
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona un tipo de Isapre", page = "Manejo de objetos")
	public static void seleccionarIsapre(String isapre) {

		try {
			Events.selectByContainsText(selectIsapre, isapre);
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Agrega un nuevo asegurado adicional", page = "Manejo de objetos")
	public static void nuevoAseguradoAdicional(String apellido) {

		try {
			Events.clickButton(buttonNuevo);
			Events.clickButton(aBuscarAseguradoAdicional);
			Events.sendKeys(inputApellido, apellido);
			Events.clickButton(buttonBuscarEntidad);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona el ID según el nombre completo dentro del resultado de la búsqueda por apellido")
	public static void seleccionarAsegurado(String nombreCompleto) {

		try {

			Thread.sleep(4000);
			Events.clickButton(aNumeroEntidad.replace("Nombre", nombreCompleto));

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona el ID según el nombre completo dentro del resultado de la búsqueda por apellido")
	public static void seleccionarAseguradoAdicional(String nombreCompleto) {

		try {

			Events.clickButton(aNumeroEntidad.replace("Nombre", nombreCompleto));

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona el parentesco del asegurado adicional", page = "Manejo de objetos")
	public static void seleccionarParentesco(String parentesco) {

		try {
			Events.selectByContainsText(selectParentesco, parentesco);
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Verifica que se haya calculado la edad de forma automática", page = "Manejo de objetos")
	public static void verificarRangoEdad() {

		try {
			String rangoEdad = Events.getText(selectRangoEdad);
			Utils.outputInfo("Se ha calculado el siguiente rango de edad: " + rangoEdad);
			Validation.trueBooleanCondition(!rangoEdad.isEmpty(), "Se ha calculado el rango de edad correctamente",
					"No se ha calculado en rango de edad");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Verifica que se incluya la asistencia de Cáncer", page = "Manejo de objetos")
	public static void verificarAsistenciaCancer() {

		try {
			String asistencia = Events.getText(labelAsistenciaCancer);
			Utils.outputInfo(asistencia);
			Validation.trueBooleanCondition(asistencia.contains("tratamiento de cáncer de UC Christus"),
					"Se ha incluído la asistencia correcta", "No se ha incluído la asistencia correcta");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Verifica que al incluir asegurados adicionales no se modifique la prima", page = "Manejo de objetos")
	public static void validarNoCambioPrima() {

		try {
			String primaTotal = Events.getText(labelPrimaTotal);
			Utils.outputInfo("La prima total después de agregar asegurados adicionales es: " + primaTotal);
			Validation.trueBooleanCondition(primaTotal.equalsIgnoreCase(PolizaProperties.primaSinDescuento),
					"La prima no ha sufrido modificaciones", "La prima ha sufrido modificaciones");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona el producto Oncologico", page = "Manejo de objetos")
	public static void seleccionarProducto() {
		try {
			Events.clickButton(spanOpcionOncologia);
			String tituloDanio = Events.getText(labelEncabezadoQueFueDanioString);
			Validation.trueBooleanCondition(tituloDanio.contains("dañado"),
					"Se ingreso correctamente a la creación del siniestro", "No se ingreso a la creación de siniestro");
			TransversalEvents.loadingTIAGeneral();
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}

	}

	@Context(description = "Activar casilla 'Fecha Aproximada'", page = "Manejo de objetos")
	public static void validarDesplieguePolizasAsociada() {
		try {
			String textoPoliza = Events.getText(labeltextoPoliza);

			Validation.trueBooleanCondition(textoPoliza.trim() != "" || textoPoliza.trim() != null,
					"Se despliega polizas asociadas", "No se despliega polizas asociadas");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}

	}

	@Context(description = "Ingresar el deducible", page = "Manejo de objetos")
	public static void ingresarDeducible(String deducible) {
		try {
			Events.sendKeys(textoDeducible, deducible);
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}

	}

	@Context(description = "Dejar el campo vacio en liquidador que constará como liquidador directo ", page = "Manejo de objetos")
	public static void seleccionarLiquidadorVacio() {
		try {
			String opcionSeleccionada = Events.getAtributte(selectLiquidador, "textContent");
			Validation.trueBooleanCondition(
					opcionSeleccionada.trim() == null || opcionSeleccionada.trim().equals("")
							|| opcionSeleccionada.isEmpty(),
					"No se selecciono un liquidador ya que se contemplara como liquidador directo",
					String.format(
							"Se selecciono un valor de forma automatica a pesar que no se selecciono un liquidador. Seleccion campo Liquidador: %s",
							opcionSeleccionada));
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}

	}

	@Context(description = "Validar que modulo siniestro se encuentre desplegado ", page = "Manejo de objetos")
	public static void validarDespliegueSiniestro() {
		try {

			WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));

			if (!BaseTest.driver.findElements(By.xpath(collapseSiniestro)).isEmpty()) {
				WebElement element = BaseTest.driver.findElement(By.xpath(collapseSiniestro));

				wait.until(ExpectedConditions.visibilityOf(element));

				String buttonName = Events.getName(element, collapseSiniestro);
				Actions actions = new Actions(BaseTest.driver);

				actions.moveToElement(element).perform();

				if (element.isEnabled()) {
					element.click();
					Utils.outputInfo("Se ha hecho clic en el botón: " + buttonName);
				}
				TransversalEvents.loadingTIAGeneral();
			} else {
				Utils.outputInfo("Modulo siniestro se encuentra desplegado");
			}

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}

	}

	@Context(description = "Seleccionar si posee diagnostico de biopsia por cancer", page = "Manejo de objetos")
	public static void diagnosticoCancerBiopsiaAsistentePreguntas(String opcionCancerBiopsia)// las opciones validas son
																								// Si,No y No Aplica.
	{
		try {
			String opcionBiopsia = Events.selectByContainsText(selectBiopsiaCancer, opcionCancerBiopsia);
			// TransversalEvents.loadingTIAGeneral();
			Events.clickButton(buttonAceptarPreguntaAsistente);
			TransversalEvents.loadingTIAGeneral();
			Validation.trueBooleanCondition(opcionBiopsia.contains(opcionCancerBiopsia),
					String.format("Se selecciono correctamente la opción %s", opcionBiopsia),
					String.format("No se encontro el valor %s dentro del listado del Evento", opcionBiopsia));

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}

	}

	@Context(description = "Seleccionar si posee el informe de Anatomopatologico", page = "Manejo de objetos")
	public static void informeAnatomopatologicoAsistentePreguntas(String opcionInforme) // las opciones validas son
																						// Si,No y No Aplica.
	{
		try {
			String opcInf = Events.selectByContainsText(selectInformeanatomopatologico, opcionInforme);
			// TransversalEvents.loadingTIAGeneral();
			Events.clickButton(buttonAceptarPreguntaAsistente);
			TransversalEvents.loadingTIAGeneral();
			Validation.trueBooleanCondition(opcInf.contains(opcionInforme),
					String.format("Se selecciono correctamente la opción %s", opcInf),
					String.format("No se encontro el valor %s dentro del listado del Evento", opcionInforme));

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}

	}

	@Context(description = "Ingresar rut del informante", page = "Manejo de objetos")
	public static void rutInformanteAsistentePreguntas(String rutInformante) {
		try {
			Events.sendKeys(textareaRutInformante, rutInformante);
			Events.clickButton(buttonAceptarPreguntaAsistente);
			TransversalEvents.loadingTIAGeneral();
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Ingresar el correo del informante", page = "Manejo de objetos")
	public static void correoInformanteAsistentePreguntas(String correoInformante) {
		try {
			Events.sendKeys(textareaCorreoInformante, correoInformante);
			Events.clickButton(buttonAceptarPreguntaAsistente);
			TransversalEvents.loadingTIAGeneral();
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Ingresar telefono del informante", page = "Manejo de objetos")
	public static void telefonoInformanteAsistentePreguntas(String telefonoInformante) {
		try {

			Actions actions = new Actions(BaseTest.driver);
			actions.moveToElement(BaseTest.driver.findElement(By.xpath(textareaTelefonoInformante))).perform();

			Events.sendKeys(textareaTelefonoInformante, telefonoInformante);
			Events.clickButton(buttonAceptarPreguntaAsistente);
			TransversalEvents.loadingTIAGeneral();
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Seleccionar si posee diagnostico UCCHRISTUS", page = "Manejo de objetos")
	public static void diagnosticoUCCHRISTUS(String diagnosticoUCCHRISTUS) {
		try {
			String opcInf = Events.selectByContainsText(selectDiagnosticoUCCHRISTUS, diagnosticoUCCHRISTUS);
			// TransversalEvents.loadingTIAGeneral();
			Events.clickButton(buttonAceptarPreguntaAsistente);
			TransversalEvents.loadingTIAGeneral();
			Validation.trueBooleanCondition(opcInf.contains(diagnosticoUCCHRISTUS),
					String.format("Se selecciono correctamente la opción %s", opcInf),
					String.format("No se encontro el valor %s dentro del listado del Evento", diagnosticoUCCHRISTUS));

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}

	}

	@Context(description = "Seleccionar si posee diagnostico UCCHRISTUS", page = "Manejo de objetos")
	public static void gestorSiniestro(String nombreGestor) {
		try {
			Events.clickButton(aBuscarGestorSiniestro);
			TransversalEvents.loadingTIAGeneral();
			OncologicoEvents.sendKeysActions(textoBuscarGestorSiniestro, nombreGestor);
			TransversalEvents.loadingTIAGeneral();
			Events.clickButton(filaGestorSiniestro);
			String idUsuario = Events.getText(celdaIdUsuario);
			Events.clickButton(aAceptarGestorSiniestro);
			TransversalEvents.loadingTIAGeneral();
			String nombreGestorSeleccionadoString = Events.getValue(gestorSiniestroSeleccionado);
			Validation.trueBooleanCondition(idUsuario.equalsIgnoreCase(nombreGestorSeleccionadoString),
					String.format("Se selecciono correctamente la opción %s", idUsuario),
					String.format(
							"Valor ingresado %s no coincide con el valor %s que se visualiza en el campo gestor de siniestro",
							idUsuario, nombreGestorSeleccionadoString));

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}

	}

	@Context(description = "Escribe dentro de un campo de texto ubicado según xpath")
	public static void sendKeysActions(String xpathElement, String text) {
		try {
			WebElement element = BaseTest.driver.findElement(By.xpath(xpathElement));
			String inputName = Events.getName(element, xpathElement);
			if (element.isDisplayed() && element.isEnabled()) {
				int caracteres = element.getAttribute("value").toCharArray().length;

				for (int i = 0; i < caracteres; i++) {
					element.sendKeys(Keys.BACK_SPACE);
				}
				Actions actions = new Actions(BaseTest.driver);
				actions.sendKeys(element, text).perform();
				actions.keyDown(element, Keys.ENTER).perform();
				Utils.outputInfo("Se ha ingresado el texto '" + text + "' en el campo: " + inputName);
				Validation.trueBooleanCondition(element.getAttribute("value").contains(text),
						"El texto se ha ingresado correctamente",
						String.format(
								"El texto no se ha ingresado correctamente. Valor ingresado %s, Valor que se requiere ingresar %s",
								element.getAttribute("value"), text));
				TransversalEvents.loadingTIAGeneral();
			} else {
				Utils.eventFailed("El campo '" + inputName + "' no se encuentra habilitado o desplegado");
			}

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Extraer el número de siniestro")
	public static void extraerNumeroSiniestro() {
		try {
			String tituloSiniestro = Events.getText(labelTituloSiniestro);

			String limpiezaTituloString = tituloSiniestro.substring(tituloSiniestro.indexOf("-") + 1);
			limpiezaTituloString = limpiezaTituloString.substring(0, limpiezaTituloString.indexOf("(")).trim();

//			SiniestroProperties siniestro = new SiniestroProperties();
//			siniestro.numeroSiniestro = limpiezaTituloString;
			
			SiniestroProperties.numeroSiniestro = limpiezaTituloString;
			System.out.println(SiniestroProperties.numeroSiniestro);

			Utils.outputInfo("Número del siniestro es " + limpiezaTituloString);
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}

	}

	@Context(description = "Buscar Siniestro")
	public static void buscarSiniestro(String numeroSinestro) {
		try {
			Events.clickButton(buttonDesplegarConsultaEjemploSiniestro);
			TransversalEvents.loadingTIAGeneral();
			sendKeysActions(inputBuscarSiniestro, numeroSinestro);
			Events.clickButton(filaBuscarSiniestro.replace("id-siniestro", numeroSinestro));
			TransversalEvents.loadingTIAGeneral();
			String obtenerTituloSiniestro = Events.getText(labelSiniestroAbierto);

			Validation.trueBooleanCondition(obtenerTituloSiniestro.contains(numeroSinestro),
					String.format("Se ingreso correctamente al siniestro '%s'", numeroSinestro),
					String.format(
							"Siniestro ingresado es inválido ya que el enunciado posee '%s' y debe contener el número de siniestro '%s'",
							obtenerTituloSiniestro, numeroSinestro));
			if (!BaseTest.driver.findElements(By.xpath(labelAdvertencia)).isEmpty()) {
				Utils.eventFailed(Events.getText(labelMensajeAdvertencia));
			}

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}

	}

	@Context(description = "Seleccionar el modulo Reservas y Pagos")
	public static void seleccionarModuloReservasPagos() {
		try {
			if (BaseTest.driver
					.findElements(By.xpath(aModuloReservasPagos.replace("addParams", "and @aria-selected = 'true'")))
					.isEmpty()) {
				Events.clickButton(aModuloReservasPagos.replace("addParams", ""));
			}

			TransversalEvents.loadingTIAGeneral();
			String tituloPagosReserva = Events.getText(labelPagosReservas);

			Validation.trueBooleanCondition(tituloPagosReserva.equalsIgnoreCase("total de siniestros"),
					"Se despliega correctamente el modulo Reservas y Pagos",
					"No se desplego el modulo Resrvas y Pagos");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}

	}

	public static void tiempoEspera() {
		try {
			Thread.sleep(20);
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}

	}

	@Context(description = "Selecciona el receptor del pago en el cual se basa el ítem o reserva", page = "Siniestro", functionality = "Siniestros")
	public static void seleccionarReceptor(String idReceptor) {

		try {
			Events.clickButton(buttonBusquedaReceptor);
			TransversalEvents.loadingTIAGeneral();
			Events.sendKeys(inputIdReceptor, idReceptor);
			Events.enter(inputIdReceptor);
			TransversalEvents.loadingTIAGeneral();
			Events.clickButton(filaIdReceptor);
			Events.clickButton(aAceptarGestorSiniestro);
			TransversalEvents.loadingTIAGeneral();
			String nombreReceptor = Events.getText(inputNombreReceptor);
			String rolReceptor = Events.getText(inputRolReceptor);

			TransversalEvents.loadingTIAGeneral();
			Utils.outputInfo("Se ha seleccionado el Receptor con Id: " + idReceptor + ", Nombre: " + nombreReceptor
					+ " y Rol: " + rolReceptor);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Busca póliza vigente", page = "Siniestro", functionality = "Siniestros")
	public static void buscarPoliza(String idPoliza) {

		try {
			Events.clickButton(buttonBusquedaPoliza);
			Events.sendKeys(inputIdLineaPoliza, idPoliza);
			BaseTest.driver
					.findElement(By.xpath(
							"//label[contains(text(),'Mostrar información del objeto acordeón')]//following::input[3]"))
					.sendKeys(Keys.ENTER);
			TransversalEvents.loadingTIAGeneral();
			Events.clickButton(labelPolizaSiniestrar.replace("id-poliza", idPoliza));
			TransversalEvents.loadingTIAGeneral();
			Events.clickButton(buttonAceptaSeleccion);
			TransversalEvents.loadingTIAGeneral();

			/*
			 * Events.enter(inputIdLineaPoliza); Events.enterAlt(inputIdLineaPoliza);
			 * Thread.sleep(3000);
			 * Events.clickButton(labelPolizaSiniestrar.replace("id-poliza", idPoliza));
			 * Events.clickButton(buttonAceptaSeleccion);
			 * 
			 * Events.sendKeys(inputIdLineaPoliza2,idPoliza);
			 * Events.enter(inputIdLineaPoliza2);
			 */
			// Thread.sleep(7000);
			String objeto = Events.getAtributte(inputObjeto, "value");
			Validation.trueBooleanCondition(!objeto.equalsIgnoreCase(""),
					"La póliza se ha seleccionado correctamente, el No.Objeto es: " + objeto,
					"La póliza no se ha seleccionado correctamente");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Validar que el número del siniestro de cobertura se despliegue de forma automatica.", page = "Siniestro", functionality = "Siniestros")
	public static void validarNumeroCobertura() {
		try {
			String valorSeleccionadoString = Events.getValue(selectNumCobetura);

			Validation.trueBooleanCondition(!valorSeleccionadoString.isEmpty() || valorSeleccionadoString.trim() != "",
					String.format("Se selecciono de forma automatica el valor %s correctamente.",
							valorSeleccionadoString),
					"El campo Numero de cobertura se encuentra en blanco");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}

	}

	@Context(description = "Validar que se rellene de forma automatica el campo descripción de cobertura", page = "Siniestro", functionality = "Siniestros")
	public static void validarDescripcionCobertura() {
		try {
			String valorSeleccionadoString = Events.getValue(inputDescripcionCobertura);

			Validation.trueBooleanCondition(!valorSeleccionadoString.isEmpty() || valorSeleccionadoString.trim() != "",
					String.format("Se relleno correctamente de forma automatica la descripción de la cobertura '%s'.",
							valorSeleccionadoString),
					"El campo descripción de la cobertura se encuentra vacío.");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}

	}

	@Context(description = "Validar que se seleccione de forma automatica el número de sub cobertura.", page = "Siniestro", functionality = "Siniestros")
	public static void validarNumSubCobertura() {
		try {
			String valorSeleccionadoString = Events.getAtributte(selectSubCoberturaNum, "textContent");

			Validation.trueBooleanCondition(!valorSeleccionadoString.isEmpty() || valorSeleccionadoString.trim() != "",
					String.format("Se selecciono correctamente de forma automatica el numero de Sub cobertura '%s'.",
							valorSeleccionadoString),
					"El campo descripción de la cobertura se encuentra vacío.");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}

	}

	public static void validarDescripcion() {
		try {
			WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(5));
			WebElement element = BaseTest.driver.findElement(By.xpath(textareaDescripcionReservaPago));
			wait.until(ExpectedConditions.visibilityOf(element));

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}

	}

	public static void validarNombreDestinatario() {
		try {
			String valorSeleccionado = Events.getValue(inputNombreDestinatario);
			Validation.trueBooleanCondition(!valorSeleccionado.isEmpty() || valorSeleccionado.trim() != "",
					String.format("Se ingreso correctamente de forma automatica el nombre del destinatario '%s'.",
							valorSeleccionado),
					"El campo Nombre del destinatario se encuentra vacío");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}

	}

	public static void validarRol() {
		try {
			String valorSeleccionado = Events.getValue(inputRol);
			Validation.trueBooleanCondition(!valorSeleccionado.isEmpty() || valorSeleccionado.trim() != "",
					String.format("Se ingreso correctamente de forma automatica el rol '%s'.", valorSeleccionado),
					"El campo rol se encuentra vacío");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}

	}

	public static void validarMoneda() {
		try {
			String valorSeleccionado = Events.getAtributte(selectTipoMoneda, "title");
			Validation.trueBooleanCondition(!valorSeleccionado.isEmpty() || valorSeleccionado.trim() != "",
					String.format("Se selecciono correctamente de forma automatica el tipo de moneda '%s'.",
							valorSeleccionado),
					"El campo tipo de moneda se encuentra vacío");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}

	}

	public static void ingresarReserva(String montoReserva) {
		try {
			Float.parseFloat(montoReserva);
			Events.sendKeys(inputReserva, montoReserva);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}

	}

	public static void validarPaid() {
		try {
			TransversalEvents.loadingTIAGeneral();
			Events.clickButton(filaItem);
			TransversalEvents.loadingTIAGeneral();
			String textPago = Events.getText(spanCampoPagadoReservaPago);

			Validation.trueBooleanCondition(!textPago.isEmpty(), "Se despliega el campo pago correctamente",
					"Campo pago no se despliega o no devuelve valor.");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}

	}

	public static void validarEstado() {
		try {
			WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(5));
			WebElement element = BaseTest.driver.findElement(By.xpath(selectEstadoPagoReserva));
			wait.until(ExpectedConditions.visibilityOf(element));
			String[] arrayOptionConf = { "CL Cerrado", "DC Rechazado y cerrado", "EC Abierto por error y cerrado",
					"NO Notificado", "OP Abierto", "RO Reaperturado" };
			if (element.isDisplayed() && element.isEnabled()) {
				String optionSelectString = Events.getAtributte(selectEstadoPagoReserva, "outerText");
				System.out.println("Primer print:" + optionSelectString);
				String optSelected = Events.getAtributte(selectEstadoPagoReserva, "title");
				System.out.println("Segundo print:" + optSelected);
				String[] arrayOption = optionSelectString.split("\n");
				System.out.println("Tercer print:" + arrayOption);
				Events.clickButton(selectEstadoPagoReserva);
				Validation.trueBooleanCondition(
						Arrays.asList(arrayOptionConf).equals(Arrays.asList(arrayOption))
								&& optSelected.contains("OP Abierto"),
						"El campo estado se encuentra desplegado correctamente y con las opciones correctas",
						String.format(
								"El campo estado no esta desplegado o no posee las opciones requeridas lista 1: %s y lista 2: %s",
								Arrays.asList(arrayOptionConf), Arrays.asList(arrayOption)));

			}
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}

	}

	@Context(description = "Inserta la reserva que corresponda según el tipo de siniestro", page = "Siniestro", functionality = "Siniestros")
	public static void insertarMontoReserva(String montoReserva) {

		try {
			Events.sendKeys(inputReservaPagosReserva, montoReserva);
			Validation.trueBooleanCondition(!montoReserva.equals(""),
					"Se ha introducido correctamente el valor de la reserva",
					"No se ha introducido correctamente el valor de la reserva");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Seleccionar item a pagar", page = "Siniestro", functionality = "Siniestros")
	public static void seleccionarItemPago() {
		try {
			Events.clickButton(inputCheckBoxSeleccionarItemPago);
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}

	}

	public static void liquidarItemPago() {
		try {
			Events.clickButton(buttonLiquidar);
			TransversalEvents.loadingTIAGeneral();
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}

	}

	public static void aceptarReceptor() {
		try {
			String nombreRecep = Events.getText(spanNombreDestinatario);
			if (nombreRecep.trim().isEmpty()) {
				Events.clickButton(spanAprobarReceptor);
				TransversalEvents.loadingTIAGeneral();
			} else {
				Utils.outputInfo("Item de pago ya tiene un receptor aprobado.");
			}
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}

	}

	public static void itemPago(String tipoPago) {
		try {
			String tituloItemPago = Events.getText(labelTituloItemPago);
			Validation.trueBooleanCondition(tituloItemPago.trim().equalsIgnoreCase("Items de pago"),
					"Se ingreso correctamente al item de pago en liquidar.",
					"No se ingreso a la ventana de items de pago al liquidar");
			Events.selectByContainsText(selectTipoPago, tipoPago);
			TransversalEvents.loadingTIAGeneral();
			String seleccionTipoPago = Events.getAtributte(selectTipoPago, "title");

			Validation.trueBooleanCondition(!seleccionTipoPago.isEmpty(),
					String.format("Se ingreso el valor %s en el campo tipo pago", seleccionTipoPago),
					"No se pudo seleccionar un valor en el campo Tipo pago");

			Events.clickButton(buttonSiguiente);
			TransversalEvents.loadingTIAGeneral();

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	public static void especificacionPago(String numFactura) {
		try {
			String tituloItemPago = Events.getText(labelTituloEspecificacionPago);
			Validation.trueBooleanCondition(tituloItemPago.trim().equalsIgnoreCase("Especificación de pago"),
					"Se ingreso correctamente a la Especificación de pago en liquidar.",
					"No se ingreso a la ventana de Especificación de pago al liquidar");

			Events.clickButton(aBuscarInstruccionPago);
			TransversalEvents.loadingTIAGeneral();
			Events.clickButton(spanInstruccionPago);
			TransversalEvents.loadingTIAGeneral();
			Events.clickButton(TransversalElements.buttonAceptar);
			Thread.sleep(2000);
			Events.sendKeys(textareaNumeroDeFactura, numFactura);
			TransversalEvents.loadingTIAGeneral();
			TransversalEvents.seleccionarFechaFactura();
			TransversalEvents.loadingTIAGeneral();
			String getContenidoInstruccionPago = Events.getValue(inputInstruccionPago);
			Validation.trueBooleanCondition(!getContenidoInstruccionPago.trim().isEmpty(),
					String.format("Se selecciono correctamente el valor %s dentro del campo Instruccion de pago",
							getContenidoInstruccionPago.trim()),
					"No se pudo seleccionar un valor dentro del campo Instruccion de pago.");

			Events.clickButton(buttonSiguiente);
			TransversalEvents.loadingTIAGeneral();
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}

	}

	public static void aprobarPago() {
		try {
			String tituloItemPago = Events.getText(labelTituloItemPago);
			Validation.trueBooleanCondition(tituloItemPago.trim().equalsIgnoreCase("Items de pago"),
					"Se ingreso correctamente al item de pago en liquidar.",
					"No se ingreso a la ventana de items de pago al liquidar");
			Events.clickButton(aFinalizarPago);

			TransversalEvents.loadingTIAGeneral();
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}

	}

	public static void validarItemPagoCerrado() {
		try {
			String estadoItemPago = Events.getText(spanEstadoItemPago);
			Validation.trueBooleanCondition(estadoItemPago.trim().equalsIgnoreCase("cerrado"),
					"El item de pago se encuentra cerrado.", "El item de pago se cuentra abierto.");
			String pag1 = Events.getText(spanCampoPagadoReservaPago);
			String pagadoItem = Events.getText(spanPagadoItemPago);

			Validation.trueBooleanCondition(pag1.trim().equalsIgnoreCase(pagadoItem.trim()),
					"item de pago posee el pago correcto",
					"No coincide el campo pagado con la columna pagado del item de pago");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}

	}

	@Context(description = "Agrega un código de descuento a la prima total", page = "Manejo Línea de póliza", functionality = "Emision")
	public static void agregarDescuentoOnco(String codigo, String respuesta) {

		try {
			Events.sendKeys(inputCodigoDescuento, codigo);
			Events.selectByContainsText(selectTipoRespuesta, respuesta);
			Thread.sleep(5000);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Confirmar descuento realizado a la póliza", page = "Manejo Línea de póliza", functionality = "Emision")
	public static void confirmarDescuento() {

		try {
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
			String primaCalculada = TransversalEvents.calcularDescuento(porcentajeDescuento);
			Validation.trueBooleanCondition(primaCalculada.contains(precioConDescuento),
					"El descuento se ha aplicado correctamente, la prima cambió de "
							+ PolizaProperties.primaSinDescuento + " a " + PolizaProperties.primaConDescuento,
					"El descuento no se ha aplicado correctamente");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

}
