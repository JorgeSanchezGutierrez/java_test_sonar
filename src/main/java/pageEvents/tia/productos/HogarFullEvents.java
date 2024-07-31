package main.java.pageEvents.tia.productos;

import main.java.config.Context;
import main.java.config.ElementFetch;
import main.java.config.Utils;
import main.java.config.Validation;
import main.java.pageEvents.tia.transversal.TransversalEvents;
import main.java.pageObjects.tia.productos.HogarFullElements;
import main.java.pageObjects.tia.transversal.TransversalElements;
import main.java.properties.EntidadProperties;
import main.java.properties.PolizaProperties;
import main.java.utils.Events;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.java.BaseTest;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static test.java.BaseTest.driver;

public class HogarFullEvents implements HogarFullElements {

	@Context(description = "Selecciona el tipo de contratante", page = "Manejo de objetos", functionality = "Emision")
	public static void seleccionarTipoContratante(String tipoContratante) {
		
		try {
			TransversalEvents.loadingTIAGeneral();
			
			int cont = 0;
			while (true) {
				String rsContratanteString = Events.selectByContainsText(selectTipoContratante, tipoContratante);
				TransversalEvents.loadingTIAGeneral();
				if(rsContratanteString != null || rsContratanteString != "") {
					break;
				}else if (cont==3) {
					Utils.eventFailed("No se pudo ingresar correctamente el contratante");
				}else {
					cont += 1;
				}
				
			} 
				
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Ingresa el ID de la propiedad a asegurar", page = "Manejo de objetos", functionality = "Emision")
	public static void ingresarIDPropiedad(String IDPropiedad) {

		try {
			Events.sendKeys(inputIDPropiedad, IDPropiedad);
			Utils.takeAdditionalScreenshot(String.format("Se ingresa id de la propiedad %s",IDPropiedad) , "extra");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona el botón 'Obtener detalles de propiedad'", page = "Manejo de objetos", functionality = "Emision")
	public static void obtenerDetallesPropiedad() {

		try {
			Events.clickButton(buttonObtenerDetallesPropiedad);
			HogarFullEvents.loadingTIAGeneral();
			Utils.takeAdditionalScreenshot("Despliegue de información de propiedad" , "extra");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Verifica que los datos de las propiedad se hayan cargado", page = "Manejo de objetos", functionality = "Emision")
	public static void verificarCargaDatosPropiedad() {

		try {
			String calle = Events.getValue(inputPropiedadCalle);
			Validation.trueBooleanCondition(!calle.equals(""),
					"El dato de la propiedad 'Calle' se ha cargado correctamente con el valor: " + calle,
					"El dato no se ha cargado correctamente");

			String numero = Events.getValue(inputPropiedadNumero);
			Validation.trueBooleanCondition(!numero.equals(""),
					"El dato de la propiedad 'Número' se ha cargado correctamente con el valor: " + numero,
					"El dato no se ha cargado correctamente");

			String region = Events.getValue(inputRegion);
			Validation.trueBooleanCondition(!region.equals(""),
					"El dato de la propiedad 'Región' se ha cargado correctamente con el valor: " + region,
					"El dato no se ha cargado correctamente");

			String comuna = Events.getValue(inputComuna);
			Validation.trueBooleanCondition(!comuna.equals(""),
					"El dato de la propiedad 'Comuna' se ha cargado correctamente con el valor: " + comuna,
					"El dato no se ha cargado correctamente");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona el tipo de propiedad'", page = "Manejo de objetos", functionality = "Emision")
	public static void seleccionarTipoPropiedad(String tipoPropiedad) {

		try {
			Events.selectByContainsText(selectTipoPropiedad, tipoPropiedad);
			Utils.takeAdditionalScreenshot(String.format("Se ingresa el tipo de propiedad %s",tipoPropiedad) , "extra");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona que la casa se encuentra en condominio'", page = "Manejo de objetos", functionality = "Emision")
	public static void seleccionarCasaCondominio(String numeroCasa) {

		try {
			Events.clickButton(checkboxCasaCondominio);
			Events.sendKeys(inputNumeroCasa, numeroCasa);
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Ingresa los metros cudrados de la propiedad'", page = "Manejo de objetos", functionality = "Emision")
	public static void ingresarM2Propiedad(String m2) {

		try {
			Events.sendKeys(inputM2Propiedad, m2);
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Ingresa los años de antiguedad de la propiedad'", page = "Manejo de objetos", functionality = "Emision")
	public static void seleccionarAntiguedadPropiedad(String rangoAnios) {

		try {
			Events.selectByContainsText(selectRangoAniosPropiedad, rangoAnios);
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona el uso que se le da a la propiedad'", page = "Manejo de objetos", functionality = "Emision")
	public static void seleccionarTipoUsoPropiedad(String uso) {

		try {
			Events.selectByContainsText(selectTipoUsoPropiedad, uso);
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona el material de construcción de la propiedad'", page = "Manejo de objetos", functionality = "Emision")
	public static void seleccionarMaterialConstruccion(String material) {

		try {
			Events.selectByContainsText(selectMaterialConstruccion, material);
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Ingresa el monto asegurado en UF para la cobertura Incendio Edificio'", page = "Manejo de objetos", functionality = "Emision")
	public static void ingresarMontoAseguradoIncendioEdificio(String montoAsegurado) {

		try {
			Events.sendKeys(inputMontoAseguradoIncendioEdificio, montoAsegurado);
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Ingresa el monto asegurado en UF para la cobertura Incendio Contenido'", page = "Manejo de objetos", functionality = "Emision")
	public static void ingresarMontoAseguradoIncendioContenido(String montoAsegurado) {

		try {
			Events.sendKeys(inputMontoAseguradoIncendioContenido, montoAsegurado);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Ingresa el número del departamento u oficina", page = "Manejo de objetos", functionality = "Emision")
	public static void ingresarNumeroDepto(String numeroDepto) {

		try {
			Events.sendKeys(inputNumeroDepto, numeroDepto);
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Ingresa el número de piso del departamento", page = "Manejo de objetos", functionality = "Emision")
	public static void ingresarNumeroPisoDepto(String numeroPiso) {

		try {
			Events.sendKeys(inputNumeroPisoDepto, numeroPiso);
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Habilita la cobertura Robo Contenido para ingresar el monto asegurado", page = "Manejo de objetos", functionality = "Emision")
	public static void habilitarCoberturaRoboContenido() {

		try {
			Events.clickButton(checkboxRoboContenido);
//			Thread.sleep(3000);
			TransversalEvents.loadingTIAGeneral(10);
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Ingresa el monto asegurado en UF para la cobertura Robo Contenido", page = "Manejo de objetos", functionality = "Emision")
	public static void ingresarMontoAseguradoRoboContenido(String montoAsegurado) {

		try {
			Events.sendKeys(inputMontoAseguradoRobo, montoAsegurado);
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Habilita la cobertura de Sismo", page = "Manejo de objetos", functionality = "Emision")
	public static void habilitarCoberturaSismo() {

		try {
			Events.clickButton(checkboxSismo);
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Habilita la cobertura de Reembolso Gastos Medicos", page = "Manejo de objetos", functionality = "Emision")
	public static void habilitarCoberturaReembolsoGastosMedicos() {

		try {
			Events.clickButton(checkboxReembolsoGastosMedicos);
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Habilita la asistencia Cyber", page = "Manejo de objetos", functionality = "Emision")
	public static void habilitarAsistenciaCyber() {

		try {
			Events.clickButton(checkboxCyber);
//			Thread.sleep(3000);
			TransversalEvents.loadingTIAGeneral(10);
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Habilita la cobertura de Responsabilidad Civil Mascotas", page = "Manejo de objetos", functionality = "Emision")
	public static void habilitarCoberturaResponsabilidadCivilMascotas() {

		try {
			Events.clickButton(checkboxMascotasRC);
//			Thread.sleep(3000);
			TransversalEvents.loadingTIAGeneral(10);
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Habilita la cobertura de Muerte Accidental", page = "Manejo de objetos", functionality = "Emision")
	public static void habilitarCoberturaMuerteAccidental() {

		try {
			Events.clickButton(checkboxMuerteAccidental);
			TransversalEvents.loadingTIAGeneral(10);
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Habilita la asistencia de Responsabilidad Civil Mascotas", page = "Manejo de objetos", functionality = "Emision")
	public static void habilitarAsistenciaMascotas() {
		try {
			Events.clickButton(checkboxMascotas);
//			Thread.sleep(3000);
			TransversalEvents.loadingTIAGeneral(10);
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Habilita la asistencia de Telemedicina", page = "Manejo de objetos", functionality = "Emision")
	public static void habilitarAsistenciaTelemedicina() {

		try {
			Events.clickButton(checkboxTelemedicina);
//			Thread.sleep(3000);
			TransversalEvents.loadingTIAGeneral(10);
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona producto Hogar Full para siniestrar", page = "Manejo Objeto", functionality = "Emisión")
	public static void seleccionarProductoSiniestrar() {
		try {
			Events.clickButton(buttonProductoHogar);
			String tituloPagina = Events.getText(labelPaginaCrearSiniestro);
			Utils.outputInfo("La sección actual es: " + tituloPagina + " Hogar Full");
			Validation.trueBooleanCondition(tituloPagina.contains("Crear siniestro"),
					"Se ha ingresado a la página para la creación de un siniestro de una póliza de tipo Hogar Full",
					"No se ha ingresado correctamente para crear un siniestro de una póliza de tipo Hogar Full");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona el evento", page = "Manejo Objeto", functionality = "Siniestros")
	public static void seleccionarEvento(String evento) {
		try {
//			Thread.sleep(3000);
			TransversalEvents.loadingTIAGeneral(10);
			Events.selectByContainsText(selectEvento, evento);
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona la causa del evento", page = "Manejo Objeto", functionality = "Siniestros")
	public static void seleccionarCausa(String causa) {
		try {
//			Thread.sleep(3000);
			TransversalEvents.loadingTIAGeneral(10);
			Events.selectByContainsText(selectCausa, causa);
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona la cobertura para el evento y causa definida", page = "Manejo Objeto", functionality = "Siniestros")
	public static void seleccionarCobertura(String cobertura) {
		try {
			Events.clickButton(buttonBusquedaCobertura);
			Events.sendKeys(inputCobertura, cobertura);
			Events.enter(inputCobertura);
			driver.findElement(By.xpath(
					"(//div[contains(text(), 'Seleccionar')]//following::input[contains(@id,'ClaimCaseRiskLOVTab')])[2]"))
					.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			Events.clickButton(labelCobertura.replace("cobertura", cobertura));
			Events.clickButton(buttonAceptaSeleccion);

			Thread.sleep(5000);
			String descripCobertura = Events.getAtributte(inputDescCobertura, "value");
			Validation.trueBooleanCondition(!descripCobertura.equalsIgnoreCase(""),
					"La cobertura se ha seleccionado correctamente. Descripción de cobertura: " + descripCobertura,
					"La cobertura no se ha seleccionado correctamente");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Responde preguntas obligatorias", page = "Manejo Objeto", functionality = "Siniestros")
	public static void responderPreguntas(String respuesta1, String respuesta2, String respuesta3, String respuesta4) {
		try {

			Events.selectByContainsText(selectRespuesta1, respuesta1);
			Events.clickButton(buttonAprobar);
//			Thread.sleep(3000);
			TransversalEvents.loadingTIAGeneral(10);
			Events.sendKeys(inputRespuesta2, respuesta2);
			Events.clickButton(buttonAprobar);
//			Thread.sleep(3000);
			TransversalEvents.loadingTIAGeneral(10);
			Events.sendKeys(inputRespuesta3, respuesta3);
			Events.clickButton(buttonAprobar);
//			Thread.sleep(3000);
			TransversalEvents.loadingTIAGeneral(10);
			Events.sendKeys(inputRespuesta4, respuesta4);
			Events.clickButton(buttonAprobar);
			String mensaje = Events.getText(labelEstadoPreguntasOK);
			Utils.outputInfo("El estado de las preguntas es: " + mensaje);
			Validation.trueBooleanCondition(mensaje.contains("OK"), "Se ha respondido la pregunta obligatoria",
					"No se ha respondido la pregunta obligatoria");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Ampliar ventana para configurar riesgo ", page = "Manejo de objetos")
	public static void ampliarVentanaRiesgos() {
		try {
			Events.clickButton(buttonAmpliar);
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Unir ventana de configuración de riesgo", page = "Manejo de objetos")
	public static void unirVentana() {
		try {
			Events.clickButton(buttonUnir);
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	//
	@Context(description = "Desmarcar cumplimiento de medidas de Seguridad", page = "Manejo de objetos")
	public static void desmarcarCumplimientoMedidasSeguridad() {
		try {
			Events.clickButton(checkboxMedidasSeguridad);
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Esperar la actualización de la ventana/módulo que se está cargando", page = "Transversal")
	public static void loadingTIAGeneral() {
		try {
			WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(50));

			WebElement element = BaseTest.driver.findElement(By.xpath(loadingTia));
			wait.until(ExpectedConditions.visibilityOf(element));

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Ir a página Administración", page = "Administración")
	public static void cargarPaginaAdmin() {
		try {
			Events.clickButton(buttonAdministracion);
			TransversalEvents.loadingTIAGeneral();
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
//			Events.clickButton(buttonCuenta3);
//			Events.clickButton(buttonSi2);
			loadingTIAGeneral();
			Events.sendKeys(inputIdPoliza, PolizaProperties.idPoliza);
			Events.clickButton(buttonBuscarItemCuenta);
			loadingTIAGeneral();
			PolizaProperties.noCuentaPagoCuota = Events.getText(labelNoCuenta);
			PolizaProperties.itemCuentaPagoCuota = Events.getText(labelItemCuenta);
			PolizaProperties.estadoPago = Events.getText(labelEstadoPago);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Buscar número de Item de Cuenta para factura de pago de cuota", page = "Administración")
	public static void buscarItem2() {
		try {
			Events.clickButton(buttonCuenta3);
			Events.clickButton(buttonContinuar);
			loadingTIAGeneral();
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

	@Context(description = "Buscar número de Item de Cuenta para factura de pago de cuota", page = "Administración")
	public static void buscarItem3() {
		try {
			Events.clickButton(buttonCuenta3);
			loadingTIAGeneral();
			Events.sendKeys(inputIdPoliza, PolizaProperties.idPoliza);
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
			Events.sendKeys(inputItemCuenta, PolizaProperties.itemCuentaPagoCuota);
			driver.findElement(By.xpath("(//input[contains(@id,'AccItemNoLovPC') and contains(@class,'x25')])[1]"))
					.sendKeys(Keys.ENTER);
			loadingTIAGeneral();
			Events.clickButton(labelItemCuentaSeleccionar.replace("no-item", PolizaProperties.itemCuentaPagoCuota));
			Events.clickButton(buttonAcepta);
			loadingTIAGeneral();
			Events.clickButton(buttonSeleccionarPago);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Crear pago para item seleccionado", page = "Administración")
	public static void crearPago() {
		try {
			Events.clickButton(buttonCrearPagoCobros);
			loadingTIAGeneral();
			Events.clickButton(buttonContinuar);
			loadingTIAGeneral();
			Events.selectByContainsText(selectMetodosPago, "CUPONERA Cuponera Digital");
			Events.sendKeys(inputNoCuenta, PolizaProperties.noCuentaPagoCuota);
			Events.sendKeys(inputItemCuenta2, PolizaProperties.itemCuentaPagoCuota);
			HogarFullEvents.loadingTIAGeneral();
			Events.clickButton(buttonCrearPago);
			// Events.clickButton(buttonAcepta);
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Validar que se haya seleccionado el item de cuenta para realizar el pago", page = "Administración")
	public static void validarEstadoItemSeleccionado() {
		try {
			buscarItem3();
			Validation.trueBooleanCondition(PolizaProperties.estadoPago.contains("2"),
					"Se ha seleccionado el item de cuenta para realizar pago  ",
					"No se ha seleccionado el item de cuenta");

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

	@Context(description = "Crea una póliza para un producto", page = "Resumen Entidad", functionality = "Emision")
	public static void crearNuevaPolizaHF(String producto) {

		try {
			validarDesplieguePolizaHF();
			Events.clickButton(buttonNuevaPolizaHF);
			TransversalEvents.loadingTIAGeneral(60);
			List<WebElement> productos = Events.getElementList(listOpcionesHF);
			for (int i = 0; i < productos.size(); i++) {
				String opcion = productos.get(i).getText();
				if (opcion.contains(producto)) {
					productos.get(i).click();
					Utils.outputInfo("Se ha seleccionado la opción: " + opcion);
					PolizaProperties.producto = producto;
					PolizaProperties.idProducto = opcion.substring(0, 2);
				}
			}

			Events.clickButton(buttonSiHF);
			TransversalEvents.loadingTIAGeneral(60);
			String tituloPoliza = Events.getText(labelManejoPolizaHF);
			Utils.outputInfo("La sección actual es: " + tituloPoliza);
			Validation.trueBooleanCondition(tituloPoliza.contains(producto),
					"Se ha creado una póliza para el producto correcto: " + producto,
					"No se ha creado la póliza correctamente");

			int inicio = tituloPoliza.indexOf("-");
			int fin = tituloPoliza.indexOf("-", inicio + 1);
			String idPoliza = tituloPoliza.substring(inicio + 2, fin - 1);
			PolizaProperties.idPoliza = idPoliza;

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona el canal de venta del producto", page = "Manejo Póliza", functionality = "Emision")
	public static void seleccionarCanalVentaHF(String canalVenta) {

		try {
			validarDespliegueModuloInfoPolizaHF();
			Events.selectByContainsText(selectCanalVentaHF, canalVenta);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Validar que el módulo de la Informacion de la línea de Póliza se encuentre desplegado ", page = "Manejo de línea de póliza")
	public static void validarDespliegueModuloInfoPolizaHF() {
		try {

			WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));

			if (!BaseTest.driver.findElements(By.xpath(collapseInfoPolizaHF)).isEmpty()) {
				WebElement element = BaseTest.driver.findElement(By.xpath(collapseInfoPolizaHF));

				wait.until(ExpectedConditions.visibilityOf(element));

				String buttonName = Events.getName(element, collapseInfoPolizaHF);
				Actions actions = new Actions(BaseTest.driver);

				actions.moveToElement(element).perform();

				if (element.isEnabled()) {
					element.click();
					Utils.outputInfo("Se ha hecho clic en el botón: " + buttonName);
				}
				HogarFullEvents.loadingTIAGeneral();
			} else {
				Utils.outputInfo("Modulo Información de la Línea de Póliza se encuentra desplegado");
			}

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}

	}

	@Context(description = "Guarda la prima calculada", page = "Manejo Objeto", functionality = "Emision")
	public static void guardarCambiosHF() {

		try {
			Events.clickButton(buttonGuardarHF);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Crea una nueva línea de póliza", page = "Manejo Póliza", functionality = "Emision")
	public static void crearNuevaLineaPolizaHF() {

		try {

			TransversalEvents.loadingTIAGeneral(60);
			Events.clickButton(buttonNuevaLineaPolizaHF);
			Events.clickButton(buttonAcepta);
			String tituloObjeto = Events.getText(labelManejoObjetoHF);
			Utils.outputInfo("La sección actual es: " + tituloObjeto);
			Validation.trueBooleanCondition(tituloObjeto.contains(PolizaProperties.producto),
					"Se ha creado el objeto de póliza para el producto correcto: " + PolizaProperties.producto,
					"No se ha creado el objeto de póliza correctamente");
			validarDespliegueModuloInfoObjetoHF();
			String idObjeto = Events.getText(labelObjetoHF);
			PolizaProperties.idObjeto = idObjeto;
			TransversalEvents.obtenerLineaPoliza();

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Validar que el módulo de la Informacion del Objeto se encuentre desplegado ", page = "Manejo de Objeto")
	public static void validarDespliegueModuloInfoObjetoHF() {
		try {

			WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));

			if (!BaseTest.driver.findElements(By.xpath(collapseInfoObjetoHF)).isEmpty()) {
				WebElement element = BaseTest.driver.findElement(By.xpath(collapseInfoObjetoHF));

				wait.until(ExpectedConditions.visibilityOf(element));

				String buttonName = Events.getName(element, collapseInfoObjetoHF);
				Actions actions = new Actions(BaseTest.driver);

				actions.moveToElement(element).perform();

				if (element.isEnabled()) {
					element.click();
					Utils.outputInfo("Se ha hecho clic en el botón: " + buttonName);
				}
				HogarFullEvents.loadingTIAGeneral();
			} else {
				Utils.outputInfo("Modulo Información del Objeto se encuentra desplegado");
			}
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}

	}

	@Context(description = "Selecciona la póliza en el listado de pólizas del resumen de la entidad seleccionada previamente", page = "Manejo Poliza", functionality = "Endosos")
	public static void ingresarPolizaHF() {

		try {
			TransversalEvents.loadingTIAGeneral();
			Events.clickButton(buttonAmpliarVentanaPolizasHF);
			Events.clickButton(aPolizaHF.replace("id-poliza", PolizaProperties.idPoliza));
			TransversalEvents.loadingTIAGeneral();
			String tituloPaginaPoliza = Events.getText(labelManejoPolizaHF);
			Utils.outputInfo("La sección actual es: " + tituloPaginaPoliza);
			Validation.trueBooleanCondition(tituloPaginaPoliza.contains(PolizaProperties.idPoliza),
					"Se ha ingresado a la póliza correcta: " + PolizaProperties.idPoliza,
					"No se ha ingresado a la póliza correctamente");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Se desplaza hacia el nivel de la póliza", page = "Manejo Línea de Póliza", functionality = "Emision")
	public static void seleccionarTipoEndosoHF(String tipoEndoso) {
		try {
			Events.clickButton(aPolizaAlternHF.replace("id-poliza", PolizaProperties.idPoliza));
			HogarFullEvents.loadingTIAGeneral();
			Events.selectByContainsText(selectTipoEndosoHF, tipoEndoso);
			guardarCambiosHF();

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Se desplaza hacia el nivel de la póliza", page = "Manejo Línea de Póliza", functionality = "Emision")
	public static void seleccionarTipoEndosoAlternativoHF(String tipoEndoso) {
		try {

			Events.selectByContainsText(selectTipoEndosoAlternativoHF, tipoEndoso);
			Events.clickButton(buttonAceptaAjusteHF);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Inicia el ajuste de una Póliza para realizar cancelaciones", page = "Manejo Póliza", functionality = "Cancelación")
	public static void ajustarPolizaHF(String tipoEndoso) {

		try {
			Events.clickButton(buttonAjustarHF);
			Events.selectByContainsText(selectTipoEndosoAlternativoHF, tipoEndoso);
			Events.clickButton(buttonAceptaAjusteHF);
			HogarFullEvents.loadingTIAGeneral();

			String tipoTransaccion = Events.getText(labelTipoTransaccionHF);
			Validation.trueBooleanCondition(tipoTransaccion.contains("Ajuste"),
					"Se ha ingresado al ajuste de la póliza correctamente: ",
					"No se ha ingresado al ajuste de la póliza correctamente");

			guardarCambiosHF();
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona el motivo de cancelación", page = "Manejo Póliza", functionality = "Cancelación")
	public static void seleccionarMotivoCancelacionPolizaHF(String motivoCancelacion) {
		try {
			Events.selectByContainsText(selectMotivoCancelacionHF, motivoCancelacion);
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Valida estado de cancelación", page = "Manejo Póliza", functionality = "Cancelación")
	public static void validarTransaccionCancelacionPolizaHF() {
		try {
			String tipoTransaccion = Events
					.getText(labelPolizaCanceladaHF.replace("id-poliza", PolizaProperties.idPoliza));
			Validation.trueBooleanCondition(tipoTransaccion.contains("- Cancelado"),
					"El estado de la póliza: " + PolizaProperties.idPoliza + tipoTransaccion,
					"No se ha cancelado la póliza correctamente");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Buscar entidad por apellido", page = "Buscar Entidades", functionality = "Transversal")
	public static void buscarEntidadHF(String apellido) {

		try {
			Events.clickButton(aBuscarEntidadHF);
			loadingTIAGeneral();
			Events.sendKeys(inputApellidoHF, apellido);
			Events.clickButton(buttonBuscarEntidadHF);
			loadingTIAGeneral();

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona el ID según el nombre completo dentro del resultado de la búsqueda por apellido", page = "Buscar Entidades", functionality = "Transversal")
	public static void seleccionarContratanteHF(String nombreCompleto) {

		try {
			TransversalEvents.loadingTIAGeneral();
			Events.clickButton(aNumeroEntidadHF.replace("Nombre", nombreCompleto));
			TransversalEvents.loadingTIAGeneral();
			String tituloPagina = Events.getText(labelPaginaResumenEntidadHF);
			Utils.outputInfo("La sección actual es: " + tituloPagina);
			Validation.trueBooleanCondition(tituloPagina.contains(nombreCompleto),
					"Se ha ingresado al resumen de la entidad correctamente: " + nombreCompleto,
					"No se ha ingresado al resumen de la entidad");
			EntidadProperties.nombreContratante = nombreCompleto;

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona la entidad del contrante activo, por nombre y apellidos", page = "Manejo de Entidad", functionality = "Transversal")
	public static void seleccionarContratanteActivoHF(String nombre, String apellido) {

		try {
			Events.clickButton(aNombreEntidadHF.replace("Nombre", nombre + " " + apellido));
			TransversalEvents.loadingTIAGeneral();
			String tituloPagina = Events.getText(labelPaginaResumenEntidadHF);
			Utils.outputInfo("La sección actual es: " + tituloPagina);
			Validation.trueBooleanCondition(tituloPagina.contains(nombre),
					"Se ha ingresado al resumen de la entidad correctamente: " + nombre,
					"No se ha ingresado al resumen de la entidad");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Valida que se haya ingresado a la URL de TIA QA", page = "Login", functionality = "Transversal")
	public static void validarAmbienteTIAHF() {

		try {
			WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(50));
			ElementFetch elementFetch = new ElementFetch();

			Thread.sleep(5000);
			Utils.outputInfo("Tiempo de espera de 5 segundos para carga de la plataforma TIA");
			WebElement element = elementFetch.getWebElement("XPATH", buttonIniciarSesionHF);
			Utils.takeAdditionalScreenshot("tia_segundo_plano", "extra");
			wait.until(ExpectedConditions.visibilityOf(element));
			String url = BaseTest.driver.getCurrentUrl().toString();
			Validation.trueBooleanCondition(url.contains("qa"), "Se ha ingresado al ambiente QA de TIA correctamente",
					"No se ha ingresado al ambiente QA de TIA");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Entrar al sistema TIA", page = "Login", functionality = "Transversal")
	public static void iniciarSesionHF(String user, String pass) {

		try {
			Events.sendKeys(inputUsuarioHF, user);
			Events.sendKeys(inputPasswordHF, pass);
			Events.clickButton(buttonIniciarSesionHF);
			Thread.sleep(10000);
			String tittle = Events.getText(labelPaginaPrincipalHF);
			Utils.outputInfo("La sección actual es: " + tittle);
			Validation.trueBooleanCondition(tittle.contains("Página principal"),
					"Se ha ingresado al sistema correctamente", "No se ha ingresado al sistema de forma correcta");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Ir a la página Home", page = "Pagina Home", functionality = "Transversal")
	public static void visitarPaginaHomeHF() {
		try {
			Events.clickButton(aHomeHF);
			HogarFullEvents.loadingTIAGeneral();
			String tittle = Events.getText(labelPaginaPrincipalHF);
			Utils.outputInfo("La sección actual es: " + tittle);
			Validation.trueBooleanCondition(tittle.contains("Página principal"),
					"Se ha ingresado a la Página Principal",
					"No se ha ingresado a la Página Principal de forma correcta");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Verifica la aparición del mensaje que no permite la cancelación de una póliza a solicitud del asegurado en los primeros días de vigencia.", page = "Manejo Poliza", functionality = "Cancelación")
	public static void validarMensajeErrorCancelacionHF(String estado) {
		try {
			Events.clickButton(buttonCompletarHF);
			String mensaje = Events.getText(labelMensajeErrorCancelacionHF);
			Utils.outputInfo("Ha aparecido el siguiente mensaje: " + mensaje);
			Validation.trueBooleanCondition(mensaje.contains("por parte del asegurado después de 10 días"),
					"El mensaje ha aparecido correctamente", "No ha aparecido el mensaje correcto");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona la fecha de inicio de cobertura de la póliza", page = "Manejo Póliza", functionality = "Emision")
	public static void seleccionarFechaInicioPolizaHF() {

		try {
			Events.clickButton(buttonSeleccionarFechaInicioPolizaHF);
			Events.clickButton(buttonDisminuirAnnoPolizaHF);
			Events.clickButton(buttonSeleccionarDiaHF);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Renovar manualmente una póliza.", page = "Manejo Poliza", functionality = "Renovación")
	public static void renovarPolizaHF() {
		try {
			Events.clickButton(buttonAmpliarVentanaPolizasHF);
			Events.clickButton(aPolizaRenovarHF.replace("id-poliza", PolizaProperties.idPoliza).replace("id-producto",
					PolizaProperties.idProducto));
			Events.clickButton(buttonRenovarHF);
			HogarFullEvents.loadingTIAGeneral();
			String tituloPagina = Events.getText(labelPaginaRenovacionHF);
			String polizaRenovar = Events.getText(labelPolizaRenovarHF);
			Utils.outputInfo("Ha ingresado a la página: " + tituloPagina);
			Validation.trueBooleanCondition(PolizaProperties.idPoliza.equals(polizaRenovar),
					"Se ha cargado la página correctamente", "No se ha cargado la página correcta");
			Events.clickButton(buttonRenovacionHF);
			Events.clickButton(buttonCompletarRenovacionHF);
			Events.clickButton(buttonAceptarRenovacionHF);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Valida que la poliza ha sido renovada de forma automática", page = "Manejo Poliza", functionality = "Renovacion")
	public static void validarRenovacionHF() {
		try {
			String tituloLineaPoliza = Events.getText(labelPaginaRenovadaHF);
			Utils.outputInfo("La sección actual es: " + tituloLineaPoliza);
			Validation.trueBooleanCondition(tituloLineaPoliza.contains("R Renovación"),
					"Se ha renovado la póliza. El estado es: " + tituloLineaPoliza,
					"No se ha renovado la póliza correctamente");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Valida que la prima no haya sido modificada con la renovación", page = "Manejo Objeto", functionality = "Renovacion")
	public static void validarPrimaSinModificacionHF() {
		try {
			String primaAntesRenovacion = PolizaProperties.primaSinDescuento;
			ingresarObjetoHF();
			String primaDespuesRenovacion = Events.getText(labelPrimaTotalHF);
			Validation.trueBooleanCondition(primaAntesRenovacion.equals(primaDespuesRenovacion),
					"la renovación ha ocurrido correctamente sin modificación de prima: Prima Poliza Antigua = "
							+ primaAntesRenovacion + " Prima Poliza Renovada = " + primaDespuesRenovacion + ".",
					"La renovación no ha sido correcta; ocurrió modificación de prima.");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Valida que la prima haya sido modificada con la renovación", page = "Manejo Objeto", functionality = "Renovacion")
	public static void validarPrimaConModificacionHF() {
		try {
			String primaAntesRenovacion = PolizaProperties.primaSinDescuento;
			ingresarObjetoHF();
			String primaDespuesRenovacion = Events.getText(TransversalElements.labelPrimaTotalUFParteSuperior);
			Validation.trueBooleanCondition(!primaAntesRenovacion.equals(primaDespuesRenovacion),
					"la renovación ha ocurrido correctamente con modificación de prima, como correspondía",
					"La renovación no ha sido correcta; no ocurrió modificación de prima.");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona el Objeto en el árbol de pólizas de la entidad seleccionada previamente", page = "Manejo Objeto", functionality = "Endosos")
	public static void ingresarObjetoHF() {
		try {
			Events.clickButton(aObjetoHF.replace("id-objeto", PolizaProperties.idObjeto));
			String tituloPaginaObjeto = Events.getText(labelManejoObjetoHF);
			Utils.outputInfo("La sección actual es: " + tituloPaginaObjeto);
			Validation.trueBooleanCondition(tituloPaginaObjeto.contains(PolizaProperties.idObjeto),
					"Se ha ingresado al objeto correcto: " + PolizaProperties.idObjeto,
					"No se ha ingresado al objeto correctamente");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Inicia el ajuste de un Objeto para realizar algún tipo de endoso con fecha de ajuste por defecto", page = "Manejo Objeto", functionality = "Endosos")
	public static void ajustarObjetoHF() {

		try {
			Events.clickButton(buttonAjustarHF);
			Events.clickButton(buttonAceptaAjusteHF);
			loadingTIAGeneral();
			String estadoPaginaEdicion = Events.getAtributte(labelEditarActivadoHF, "title");
			Validation.trueBooleanCondition(estadoPaginaEdicion.contains("Activado"),
					"Se ha ingresado al ajuste del objeto correctamente: ",
					"No se ha ingresado al ajuste del objeto correctamente");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Recalcula la prima de la póliza ante un endoso complejo", page = "Manejo Objeto", functionality = "Endoso")
	public static void calcularPrimaTotalEndosoComplejoHF() {

		try {
			String primaTotalAntesEndoso = Events.getText(labelPrimaTotalHF);
			Events.clickButton(buttonCalculateHF);
			loadingTIAGeneral();
			String primaTotalDespuesEndoso = Events.getText(labelPrimaTotalHF);
			Validation.trueBooleanCondition(!primaTotalAntesEndoso.equals(primaTotalDespuesEndoso),
					"Ha sido calculada correctamente la nueva prima, cambió de " + primaTotalAntesEndoso + " a "
							+ primaTotalDespuesEndoso,
					"No se ha calculado correctamente la nueva prima");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Se desplaza hasta la línea de póliza", page = "Manejo Línea de Póliza", functionality = "Emision")
	public static void ingresarLineaPolizaHF() {
		try {
			Events.clickButton(aLineaPolizaHF.replace("id-poliza", PolizaProperties.idPoliza));
			String tituloLineaPoliza = Events.getText(labelManejoLineaPolizaHF);
			Utils.outputInfo("La sección actual es: " + tituloLineaPoliza);
			Validation.trueBooleanCondition(tituloLineaPoliza.contains(PolizaProperties.producto),
					"Se ha ingresado a la línea de póliza para el producto correcto: " + PolizaProperties.producto,
					"No se ha ingresado a la línea de póliza para el objeto de póliza correctamente");
			int inicio = tituloLineaPoliza.indexOf("-");
			int fin = tituloLineaPoliza.indexOf("-", inicio + 1);
			String idLineaPoliza = tituloLineaPoliza.substring(inicio + 2, fin - 1);
			PolizaProperties.idLineaPoliza = idLineaPoliza;
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Valida endoso de objeto", page = "Manejo Póliza", functionality = "Cancelación")
	public static void validarEndosoHF() {
		try {
			String tipoTransaccion = Events.getText(labelTipoTransaccionHF);
			Validation.trueBooleanCondition(tipoTransaccion.contains("Ajuste"),
					"Se ha realizado el ajuste correctamente, el código de transacción es :" + tipoTransaccion,
					"No se ha realizado el ajuste correctamente");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

//	@Context(description = "Validar que el módulo Siniestro se encuentre desplegado ", page = "Manejo de objetos")
//	public static void validarDespliegueSiniestroHF() {
//		try {
//
//			WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(10));
//			wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
//
//			if (!BaseTest.driver.findElements(By.xpath(collapseSiniestroHF)).isEmpty()) {
//				WebElement element = BaseTest.driver.findElement(By.xpath(collapseSiniestroHF));
//
//				wait.until(ExpectedConditions.visibilityOf(element));
//
//				String buttonName = Events.getName(element, collapseSiniestroHF);
//				Actions actions = new Actions(BaseTest.driver);
//
//				actions.moveToElement(element).perform();
//
//				if (element.isEnabled()) {
//					element.click();
//					Utils.outputInfo("Se ha hecho clic en el botón: " + buttonName);
//				}
//				loadingTIAGeneral();
//			} else {
//				Utils.outputInfo("Modulo Siniestro se encuentra desplegado");
//			}
//
//		} catch (Exception e) {
//			Utils.eventFailed(e.getMessage());
//		}
//
//	}

	@Context(description = "Validar que el módulo Póliza se encuentre desplegado ", page = "Manejo de objetos")
	public static void validarDesplieguePolizaHF() {
		try {

			WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));

			if (!BaseTest.driver.findElements(By.xpath(collapsePolizaHF)).isEmpty()) {
				WebElement element = BaseTest.driver.findElement(By.xpath(collapsePolizaHF));

				wait.until(ExpectedConditions.visibilityOf(element));

				String buttonName = Events.getName(element, collapsePolizaHF);
				Actions actions = new Actions(BaseTest.driver);

				actions.moveToElement(element).perform();

				if (element.isEnabled()) {
					element.click();
					Utils.outputInfo("Se ha hecho clic en el botón: " + buttonName);
				}
				loadingTIAGeneral();
			} else {
				Utils.outputInfo("Modulo Póliza se encuentra desplegado");
			}

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}

	}

	@Context(description = "Crea siniestro para una póliza vigente", page = "Siniestro", functionality = "Siniestros")
	public static void crearSiniestroHF() {

		try {
			TransversalEvents.validarDespliegueSiniestro();
			Events.clickButton(buttonCrearSiniestroHF);
			String tittle = Events.getText(labelPaginaSiniestroHF);
			Utils.outputInfo("La sección actual es: " + tittle);
			Validation.trueBooleanCondition(tittle.contains("Crear siniestro"),
					"Se ha ingresado a la página para la creación de un siniestro",
					"No se ha ingresado correctamente para crear un siniestro");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Crea siniestro de forma alternativa, desde el manejo de una póliza", page = "Manejo de póliza", functionality = "Siniestros")
	public static void crearSiniestroAlternativoHF() {

		try {
			TransversalEvents.validarDespliegueSiniestro();
			Events.clickButton(buttonCrearSiniestroAlternHF);
			String tittle = Events.getText(labelPaginaSiniestroHF);
			Utils.outputInfo("La sección actual es: " + tittle);
			Validation.trueBooleanCondition(tittle.contains("Crear siniestro"),
					"Se ha ingresado a la página para la creación de un siniestro",
					"No se ha ingresado correctamente para crear un siniestro");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Inserta fecha del siniestro", page = "Siniestro", functionality = "Siniestros")
	public static void insertarFechaSiniestroHF(String fechaSiniestro) {

		try {
			Events.sendKeys(inputFechaSiniestroHF, fechaSiniestro);
			Validation.trueBooleanCondition(!(fechaSiniestro.equals("")),
					"Se ha introducido correctamente la fecha del siniestro",
					"No se ha introducido fecha del siniestro");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Inserta fecha de denuncia", page = "Siniestro", functionality = "Siniestros")
	public static void insertarFechaDenunciaHF(String fechaDenuncia) {

		try {
			Events.sendKeys(inputFechaDenunciaHF, fechaDenuncia);
			Validation.trueBooleanCondition(!(fechaDenuncia.equals("")),
					"Se ha introducido correctamente la fecha de denuncia", "No se ha introducido fecha de denuncia");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Busca póliza vigente", page = "Siniestro", functionality = "Siniestros")
	public static void buscarPolizaHF(String idPoliza) {

		try {
			loadingTIAGeneral();
			Events.clickButton(buttonBusquedaPolizaAltHF);
			loadingTIAGeneral();
			Events.sendKeys(inputFechaSiniestroResultado, "");
			loadingTIAGeneral();
			Events.sendKeys(inputIdLineaPolizaHF, idPoliza);
			driver.findElement(By
					.xpath("//label[contains(text(),'Mostrar información del objeto acordeón')]//following::input[3]"))
					.sendKeys(Keys.ENTER);
			loadingTIAGeneral();
			Events.clickButton(labelPolizaSiniestrarHF.replace("id-poliza", idPoliza));
			loadingTIAGeneral();
			Events.clickButton(buttonAceptaSeleccionHF);
			loadingTIAGeneral();
			Events.clickButton(buttonBusquedaPolizaAltHF);
			loadingTIAGeneral();
			Events.clickButton(buttonAceptaSeleccionHF);
			loadingTIAGeneral();

			String objeto = Events.getAtributte(inputObjetoHF, "value");
			Validation.trueBooleanCondition(!objeto.equalsIgnoreCase(""),
					"La póliza se ha seleccionado correctamente, el No.Objeto es: " + objeto,
					"La póliza no se ha seleccionado correctamente");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Inserta descripción del hecho", page = "Siniestro", functionality = "Siniestros")
	public static void insertarDescripHechoHF(String descripHecho) {

		try {
			Events.sendKeys(inputDescripHechoHF, descripHecho);
			Validation.trueBooleanCondition(!(descripHecho.equals("")),
					"Se ha introducido correctamente la descripción del hecho",
					"No se ha introducido descripción del hecho");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona el tipo de informante", page = "Siniestro", functionality = "Siniestros")
	public static void seleccionarTipoInformanteHF(String tipoInform) {

		try {
			loadingTIAGeneral();
			Events.selectByContainsText(selectInformanteHF, tipoInform);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Inserta el nombre del informante", page = "Siniestro", functionality = "Siniestros")
	public static void insertarNombInformanteHF(String nombInform) {

		try {
			Events.sendKeys(inputNombInformHF, nombInform);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona el tipo de denuncia", page = "Siniestro", functionality = "Siniestros")
	public static void seleccionarTipoDenunciaHF(String tipoDenuncia) {

		try {
			loadingTIAGeneral();
			Events.selectByContainsText(selectTipoDenunciaHF, tipoDenuncia);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona el lugar donde ocurrió el siniestro", page = "Siniestro", functionality = "Siniestros")
	public static void seleccionarLugarSiniestroHF(String lugar) {

		try {
			loadingTIAGeneral();
			Events.selectByContainsText(selectLugarHF, lugar);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

//	@Context(step = "Verifica si está despleagada la bitácora del Siniestro", page = "Siniestro", functionality = "Siniestro")
//	public static void verificaBitacoraDesplegadaHF() {
//
//		try {
//			String bitacoraDesplegado = Events.getAtributte(buttonBarraLateralHF, "aria-expanded");
//			if (!bitacoraDesplegado.equals("true")) {
//				Events.clickButton(buttonBarraLateralHF);
//			}
//
//		} catch (Exception e) {
//			Utils.eventFailed(e.getMessage());
//		}
//	}

	@Context(step = "Se genera un siniestro en estado abierto", page = "Siniestro", functionality = "Siniestro")
	public static void generarSiniestroHF(String nombEvento) {

		try {
			loadingTIAGeneral();
			Events.clickButton(buttonGenerarSiniestroHF);
			loadingTIAGeneral();
			TransversalEvents.verificaBitacoraDesplegada();
			String tittle = Events.getText(labelNotificacionSiniestroHF);
			String tittle2 = Events.getText(labelSiniestroHF.replace("Nom_producto", nombEvento));
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

	@Context(description = "Selecciona un gestor de siniestro", page = "Siniestro", functionality = "Siniestros")
	public static void seleccionarGestorHF(String gestor) {

		try {

			Events.sendKeys(inputIdGestorHF, gestor);
			Events.enter(inputIdGestorHF);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(step = "Se intenta generar un siniestro pero no se culmina por errores controlados ", page = "Siniestro", functionality = "Siniestro")
	public static void generarSiniestroAlternativoHF() {

		try {
			loadingTIAGeneral();
			Events.clickButton(buttonGenerarSiniestroHF);
			String mensaje = Events.getText(labelSiniestroErrorHF);
			Utils.outputInfo("Se ha mostrado el mensaje: " + mensaje);
			Validation.trueBooleanCondition(mensaje.contains("Error"), "Se ha mostrado el mensaje de Error",
					"No se ha mostrado el mensaje de Error");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Valida mensaje de error en Fecha de siniestro superior que fecha de denuncia", page = "Siniestro", functionality = "Siniestros")
	public static void validarMensajeErrorFechaSiniestroSuperiorFechaDenunciaHF() {
		try {
			String mensaje = Events.getText(msgErrorFechaSiniestroSuperiorDenunciaHF);
			Utils.outputInfo("Ha aparecido el siguiente mensaje: " + mensaje);
			Validation.trueBooleanCondition(mensaje.contains("Fecha del siniestro"),
					"El mensaje ha aparecido correctamente ", "No  ha aparecido el mensaje correcto");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Valida mensaje de error en Fecha de siniestro en blanco", page = "Siniestro", functionality = "Siniestros")
	public static void validarMensajeErrorFechaSiniestroEnBlancoHF() {
		try {
			String mensaje = Events.getText(msgErrorFechaSiniestroEnBlancoHF);
			Utils.outputInfo("Ha aparecido el siguiente mensaje: " + mensaje);
			Validation.trueBooleanCondition(mensaje.contains("Debe introducir"),
					"El mensaje ha aparecido correctamente ", "No  ha aparecido el mensaje correcto");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona fecha de siniestro", page = "Siniestro", functionality = "Siniestros")
	public static void seleccionarFechaSiniestroHF() {
		try {
			Events.clickButton(buttonSeleccionarFechaSiniestroHF);
			Events.clickButton(buttonFechaSuperiorDiaActualHF);
			Events.clickButton(buttonAceptarFechaHF);
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona fecha de siniestro", page = "Siniestro", functionality = "Siniestros")
	public static void seleccionarFechasHF() {
		try {
			Events.clickButton(buttonSeleccionarFechaSiniestroHF);
			Events.clickButton(buttonFechaAnteriorDiaActualHF);
			Events.clickButton(buttonAceptarFechaHF);
			loadingTIAGeneral();
			String fecha = Events.getValue(labelFechaSiniestro);
			Events.sendKeys(labelFechaDenuncia, fecha);
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona fecha de denuncia", page = "Siniestro", functionality = "Siniestros")
	public static void seleccionarFechaDenunciaHF() {

		try {
			Events.clickButton(buttonSeleccionarFechaDenunciaHF);
			Events.clickButton(buttonFechaSuperiorDiaActualHF);
			Events.clickButton(buttonAceptarFechaHF);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona fecha de denuncia", page = "Siniestro", functionality = "Siniestros")
	public static void seleccionarFechaDenunciaAnteriorHF() {

		try {
			Events.clickButton(buttonSeleccionarFechaDenunciaHF);
			Events.clickButton(buttonFechaDenunciaAnteriorDiaActualHF);
			Events.clickButton(buttonAceptarFechaHF);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Valida mensaje de error en Fecha de siniestro superior al día actual", page = "Siniestro", functionality = "Siniestros")
	public static void validarMensajeErrorFechaSiniestroSuperiorDiaActualHF() {
		try {
			String mensaje = Events.getText(msgErrorFechaSiniestroSuperiorDiaActualHF);
			Utils.outputInfo("Ha aparecido el siguiente mensaje: " + mensaje);
			Validation.trueBooleanCondition(mensaje.contains("Fecha del siniestro"),
					"El mensaje ha aparecido correctamente ", "No  ha aparecido el mensaje correcto");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Valida mensaje de error en Fecha de denuncia superior al día actual", page = "Siniestro", functionality = "Siniestros")
	public static void validarMensajeErrorFechaDenunciaSuperiorDiaActualHF() {

		try {

			String mensaje = Events.getText(msgErrorFechaDenunciaSuperiorDiaActualHF);
			Utils.outputInfo("Ha aparecido el siguiente mensaje: " + mensaje);
			Validation.trueBooleanCondition(mensaje.contains("Fecha de denuncia"),
					"El mensaje ha aparecido correctamente ", "No  ha aparecido el mensaje correcto");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(step = "Se ingresa a la página para crear una reserva", page = "Siniestro", functionality = "Siniestro")
	public static void crearReservaHF() {

		try {
			loadingTIAGeneral();
			Events.clickButton(buttonReservaHF);
			loadingTIAGeneral();
			String tittle = Events.getText(labelItemsHF);
			Utils.outputInfo("La sección actual es: " + tittle);
			Validation.trueBooleanCondition(tittle.contains("Items"),
					"Se ha generado ingresado a la página para la creación de una reserva",
					"No se ha ingresado correctamente a la página de creación de reserva");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(step = "Crea nuevo item", page = "Siniestro", functionality = "Siniestro")
	public static void crearNuevoItemHF() {

		try {
			loadingTIAGeneral();
			Events.clickButton(buttonNuevoItemHF);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona tipo de ítem dentro de las opciones disponibles", page = "Siniestro", functionality = "Siniestros")
	public static void seleccionarTipoItemHF(String tipoItem) {

		try {
			loadingTIAGeneral();
			Events.selectByContainsText(selectTipoItemHF, tipoItem);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona tipo de sub ítem dentro de las opciones disponibles", page = "Siniestro", functionality = "Siniestros")
	public static void seleccionarTipoSubItemHF(String tipoSubItem) {

		try {
			loadingTIAGeneral();
			Events.selectByContainsText(selectTipoSubItemHF, tipoSubItem);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona el receptor del pago en el cual se basa el ítem o reserva", page = "Siniestro", functionality = "Siniestros")
	public static void seleccionarReceptorHF(String idReceptor) {

		try {
			Events.clickButton(buttonBusquedaReceptorHF);
			Events.sendKeys(inputIdReceptorHF, idReceptor);
			Events.enter(inputIdReceptorHF);
			Events.clickButton(labelNombreReceptorHF);
			String nombreReceptor = Events.getText(labelNombreReceptorHF);
			String rolReceptor = Events.getText(labelRolReceptorHF);
			Events.clickButton(buttonAceptaSeleccion);
			loadingTIAGeneral();
			Utils.outputInfo("Se ha seleccionado el Receptor con Id: " + idReceptor + ", Nombre: " + nombreReceptor
					+ " y Rol: " + rolReceptor);
			validarNombreReceptorHF(nombreReceptor);
			validarRolReceptorHF(rolReceptor);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Modifica la reserva de un ´tem", page = "Siniestro", functionality = "Siniestros")
	public static void modificarMontoReservaHF(String montoReserva) {

		try {
			Events.clickButton(buttonReservasPagosHF);
			String reservaActual = Events.getValue(inputReservaHF);
			Events.sendKeys(inputReservaHF, montoReserva);
			Events.clickButton(buttonGuardarReservaHF);
			Validation.trueBooleanCondition(!reservaActual.equals(montoReserva),
					"Se ha actualizado correctamente el valor de la reserva",
					"No se ha actualizado correctamente el valor de la reserva");
			loadingTIAGeneral();
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Inserta la reserva que corresponda según el tipo de siniestro", page = "Siniestro", functionality = "Siniestros")
	public static void insertarMontoReservaHF(String montoReserva) {

		try {
			Events.sendKeys(inputReservaHF, montoReserva);
			Validation.trueBooleanCondition(!montoReserva.equals(""),
					"Se ha introducido correctamente el valor de la reserva",
					"No se ha introducido correctamente el valor de la reserva");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Valida que se cargue automáticamente el nombre del Receptor", page = "Siniestro", functionality = "Siniestros")
	public static void validarNombreReceptorHF(String nombreReceptor) {

		try {

			String nombre = Events.getAtributte(inputNombreReceptorHF, "value");
			Validation.trueBooleanCondition(nombre.equalsIgnoreCase(nombreReceptor),
					"Se ha cargado correctamente el nombre del receptor",
					"No se ha cargado correctamente el nombre del receptor");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Valida que se cargue automáticamente el rol del Receptor", page = "Siniestro", functionality = "Siniestros")
	public static void validarRolReceptorHF(String rolReceptor) {

		try {

			String rol = Events.getAtributte(inputRolReceptorHF, "value");
			Validation.trueBooleanCondition(rol.equalsIgnoreCase(rolReceptor),
					"Se ha cargado correctamente el rol del receptor",
					"No se ha cargado correctamente el rol del receptor");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Valida que se cargue automáticamente el id del Liquidador", page = "Siniestro", functionality = "Siniestros")
	public static void validarIdLiquidadorHF(String idLiquidador) {

		try {

			String nombre = Events.getAtributte(inputIdLiquidReceptorHF, "value");
			Validation.trueBooleanCondition(nombre.equalsIgnoreCase(idLiquidador),
					"Se ha cargado correctamente el Id del liquidador",
					"No se ha cargado correctamente el Id del liquidador");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Guarda los datos de reserva", page = "Siniestro", functionality = "Siniestros")
	public static void guardarReservaHF() {

		try {

			Events.clickButton(buttonGuardarReservaHF);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Busca el liquidador designado para la atención del siniestro", page = "Siniestro", functionality = "Siniestros")
	public static void seleccionarLiquidadorHF(String idLiquidador) {

		try {

			Events.sendKeys(inputIdLiquidadorHF, idLiquidador);
			Events.enter(inputIdLiquidadorHF);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Liquida un item de una reserva", page = "Reserva", functionality = "Siniestros")
	public static void liquidarReservaHF(String monto, String numFactura) {
		try {
			Events.clickButton(aRerservasPagosHF);
			String tituloPaginaReservaPagos = Events.getText(labelPagosReservasHF);
			Utils.outputInfo("La sección actual es: " + tituloPaginaReservaPagos);
			Events.clickButton(selectItemsPagarHF);
			Events.clickButton(buttonLiquidarHF);
			String tituloVentanaPago = Events.getText("//div[contains(text(),'Pago')]");
			Validation.trueBooleanCondition(tituloVentanaPago.contains("Pago"),
					"Se ha cargado la ventana para ejecutar el pago correctamente",
					"No se ha cargado la ventana para ejecutar el pago");
			// se define monto y indicar realizar el pago
			Events.sendKeys(inputMontoLiquidHF, monto);
			Events.clickButton(buttonSiguienteHF);
			Events.sendKeys(textareaNumeroDeFactura, numFactura);
			loadingTIAGeneral();
			TransversalEvents.seleccionarFechaFactura();
			loadingTIAGeneral();
			Events.clickButton(buttonSeleccionaInstPagoHF);
			Events.clickButton(labelInstPagoHF);
			Events.clickButton(buttonAceptaInstPagoHF);
			loadingTIAGeneral();
			Events.clickButton(buttonSiguienteHF);
			Events.clickButton(buttonFinalizarPagoHF);
			loadingTIAGeneral();
			// validar que se muestre lo pagado en
			String montoPagado = Events.getText(labelPaidHF);
			Validation.trueBooleanCondition(!montoPagado.equalsIgnoreCase(""),
					"La liquidación se ha realizado correctamente, el monto pagado es: " + montoPagado,
					"No se ha realizado la liquidación correctamente");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Calcula la prima total de la póliza", page = "Manejo Objeto", functionality = "Emision")
	public static void calcularPrimaTotalHF() {

		try {
			loadingTIAGeneral();
			Events.clickButton(buttonCalculateHF);
			loadingTIAGeneral();
			WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(50));
			wait.until(ExpectedConditions
					.not(ExpectedConditions.attributeContains(By.xpath(labelPrimaTotalHF), "innerText", "0,000000")));
			String primaTotal = Events.getText(labelPrimaTotalHF);
			Utils.outputInfo("La prima total es: " + primaTotal);
			Validation.trueBooleanCondition(!primaTotal.contains("0,000000"),
					"La prima total se ha calculado correctamente", "La prima total no se ha calculado");
			PolizaProperties.primaSinDescuento = primaTotal;
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(step = "Selecciona una fecha anterior para una poliza a siniestrar.", page = "Manejo Objeto", functionality = "Siniestro")
	public static void seleccionarFechaPolizaDosDiasAntes() {

		try {
//			loadingTIAGeneral();
//			Events.clickButton(buttonSelecFecInicioCobertura);
			loadingTIAGeneral();
			
			//
			LocalDateTime hora = LocalDateTime.now();
	        DateTimeFormatter fa = DateTimeFormatter.ofPattern("dd.MM.yyyy");
	        String fecha = hora.plusDays(-2).format(fa);
	        System.out.println("Fecha actual = " + fecha);
			//
			
	        Events.sendKeys(fechaInicioCobertura, fecha);
//			LocalDate fechaHoy = LocalDate.now();
//			int numDiaAntesDeAyer = (fechaHoy.getDayOfMonth()) - 2;
//			String diaString = String.valueOf(numDiaAntesDeAyer);
//			Events.clickButton(TransversalElements.buttonSeleccionarDiaHora.replace("dia", diaString));
			loadingTIAGeneral();
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}
	
	@Context(description = "Clic para seleccionar al liquidador", page = "Siniestro", functionality = "Siniestros")
	public static void clicLiquidadorHF(String nombreLiquidador) {

		try {
			loadingTIAGeneral();
			Events.clickButton(filaConLiquidador.replace("nombreLiquidador", nombreLiquidador));
			loadingTIAGeneral();
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}
}
