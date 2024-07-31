package main.java.pageEvents.tia.productos;

import main.java.config.Context;
import main.java.config.Utils;
import main.java.config.Validation;
import main.java.pageEvents.tia.transversal.TransversalEvents;
import main.java.pageObjects.tia.productos.MascotasSaludElements;
import main.java.pageObjects.tia.productos.MuerteAccidentalElements;
import main.java.pageObjects.tia.transversal.TransversalElements;
import main.java.properties.PolizaProperties;
import main.java.utils.Events;
import test.java.BaseTest;

import java.time.Duration;
import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MuerteAccidentalEvents implements MuerteAccidentalElements, TransversalElements {

	@Context(step = "Se completan los datos para Poliza Muerte Accidental", page = "Planes", functionality = "Emision")
	public static void seleccionarTipodeCobertura() {

		try {
			Thread.sleep(2000);
			Events.clickButton(ClickPlanCobertura);
			Events.clickButton(SeleccionPlan1);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Esperar la actualización de la ventana/módulo que se está cargando", page = "Transversal")
	public static void loadingTIAGeneral() {
		try {
			WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(50));

			WebElement element = BaseTest.driver.findElement(By.xpath(MuerteAccidentalElements.loadingTia));
			wait.until(ExpectedConditions.visibilityOf(element));

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Ir a página Administración", page = "Administración")
	public static void cargarPaginaAdmin() {
		try {
			Events.clickButton(buttonAdministracion2);
			loadingTIAGeneral();
			String paginaAdmin = Events.getText(labelPaginaAdmin2);
			Validation.trueBooleanCondition(paginaAdmin.equalsIgnoreCase("Administración"),
					"Se ha cargado correctamente la página Administración",
					"No se ha cargado la página de Administración");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	/*@Context(description = "Ir a página Buscar item Cuenta", page = "Administración")
	public static void cargarPaginaBuscarItemCuenta() {
		try {
			Events.clickButton(buttonCuenta1);
			loadingTIAGeneral();
			Events.clickButton(buttonCuenta22);
			loadingTIAGeneral();
			Events.clickButton(buttonCuenta33);
			loadingTIAGeneral();
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}*/

	@Context(description = "Ir a página Buscar item Cuenta", page = "Administración")
	public static void cargarPaginaBuscarItemCuenta2() {
		try {
			Events.clickButton(buttonCuenta3);
			loadingTIAGeneral();
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	/*@Context(description = "Buscar número de Item de Cuenta para factura de pago de cuota", page = "Administración")
	public static void buscarItem() {
		try {
			loadingTIAGeneral();
			Events.sendKeys(inputIdPoliza1, PolizaProperties.idPoliza);
			loadingTIAGeneral();
			Events.clickButton(buttonBuscarItemCuenta1);
			loadingTIAGeneral();
			PolizaProperties.noCuentaPagoCuota = Events.getText(labelNoCuenta1);
			PolizaProperties.itemCuentaPagoCuota = Events.getText(labelItemCuenta1);
			PolizaProperties.estadoPago = Events.getText(labelEstadoPago1);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}*/

	/*@Context(description = "Buscar número de Item de Cuenta para factura de pago de cuota", page = "Administración")
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
	}*/
	
	/*@Context(description = "Buscar número de Item de Cuenta para factura de pago de cuota", page = "Administración")
	public static void buscarItem3() {
		try {
			Events.clickButton(buttonCuenta3);
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
	}*/

	/*@Context(description = "Seleccionar item para pago ", page = "Administración")
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
			Events.clickButton(TransversalElements.buttonAceptar);
			loadingTIAGeneral();
			Events.clickButton(buttonSeleccionarPago);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}*/

	/*@Context(description = "Validar que se haya seleccionado el item de cuenta para realizar el pago", page = "Administración")
	public static void validarEstadoItemSeleccionado() {
		try {
			buscarItem3();
			Validation.trueBooleanCondition(PolizaProperties.estadoPago.contains("2"),
					"Se ha seleccionado el item de cuenta para realizar pago  ",
					"No se ha seleccionado el item de cuenta");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}*/

	/*@Context(description = "Crear pago para item seleccionado", page = "Administración")
	public static void crearPago() {
		try {
			Events.clickButton(buttonCrearPagoCobros);
			loadingTIAGeneral();
			Events.clickButton(buttonContinuar);
			loadingTIAGeneral();
			Events.selectByContainsText(selectMetodosPago, "CUPONERA Cuponera Digital");
			Events.sendKeys(inputNoCuenta, PolizaProperties.noCuentaPagoCuota);
			Events.sendKeys(inputItemCuenta2, PolizaProperties.itemCuentaPagoCuota);
			Thread.sleep(3000);
			Events.clickButton(buttonCrearPago);
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}*/

	/*@Context(description = "Validar que se haya realizado el pago correctamente", page = "Administración")
	public static void validarEstadoEnviadoSistemaPago() {
		try {
			buscarItem3();
			Validation.trueBooleanCondition(PolizaProperties.estadoPago.contains("3"),
					"Se ha enviado el pago del a sistema correctamente", "No se ha enviado el pago");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}*/

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

	@Context(step = "Se completan los datos para Poliza Muerte Accidental", page = "Planes", functionality = "Emision")
	public static void eliminarBeneficiario() {

		try {
			Thread.sleep(2000);
			Events.clickButton(eliminarBeneficiario);
			Events.clickButton(eleminarSi);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	/*@Context(description = "Validar monto revertido", page = "Administración")
	public static void validarMontoRevertido() {
		try {
			String montorevertido = Events.getText(labelMontorevertido);
			Validation.trueBooleanCondition(montorevertido.contains("-"), "Se ha revertido el pago correctamente",
					"No se ha realizado la reversión del pago");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}*/

	@Context(description = "Selecciona el evento", page = "Manejo Objeto", functionality = "Siniestros")
	public static void seleccionarEvento(String evento) {
		try {
			Thread.sleep(7000);
			Events.selectByContainsText(selectEvento, evento);
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona la causa del evento", page = "Manejo Objeto", functionality = "Siniestros")
	public static void seleccionarCausa(String causa) {
		try {
			Thread.sleep(7000);
			Events.selectByContainsText(selectCausa, causa);
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona la cobertura para el evento y causa definida", page = "Manejo Objeto", functionality = "Siniestros")
	public static void seleccionarCobertura() {
		try {
			Events.clickButton(buttonBusquedaCobertura);
			Events.clickButton(labelCobertura);
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
	public static void responderPreguntas(String respuesta1, String respuesta3, String respuesta4, String respuesta5) {
		try {
			Thread.sleep(5000);
			Events.selectByContainsText(selectRespuesta1, respuesta1);
			Events.clickButton(buttonAprobar);
			Thread.sleep(4000);
			Events.sendKeys(selectRespuesta12, respuesta3);
			Events.clickButton(buttonAprobar);
			Thread.sleep(3000);
			Events.sendKeys(selectRespuesta13, respuesta4);
			Events.clickButton(buttonAprobar);
			Thread.sleep(3000);
			Events.sendKeys(selectRespuesta14, respuesta5);
			Events.clickButton(buttonAprobar);
			String mensaje = Events.getText(labelEstadoPreguntasOK);
			Utils.outputInfo("El estado de las preguntas es: " + mensaje);
			Validation.trueBooleanCondition(mensaje.contains("OK"), "Se ha respondido la pregunta obligatoria",
					"No se ha respondido la pregunta obligatoria");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Se desplaza hasta la línea de póliza", page = "Manejo Línea de Póliza", functionality = "Emision")
	public static void ingresarLineaPolizaAP() {
		try {
			Events.clickButton(buttonAmpliarVentanaPolizas);
			Events.clickButton(aLineaPoliza.replace("id-poliza", PolizaProperties.idPoliza));
			String tituloLineaPoliza = Events.getText(labelManejoLineaPoliza);
			Utils.outputInfo("La sección actual es: " + tituloLineaPoliza);
			Validation.trueBooleanCondition(tituloLineaPoliza.contains("Muerte Accidental"),
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

	@Context(step = "Se genera un siniestro en estado abierto", page = "Siniestro", functionality = "Siniestro")
	public static void generarSiniestro() {

		try {
			Thread.sleep(1000);
			Events.clickButton(buttonGenerarSiniestro);
			String tittle = Events.getText(labelSiniestroAbierto);
			Utils.outputInfo("La sección actual es: " + tittle);
			Validation.trueBooleanCondition(tittle.contains("(Notificado)"),
					"Se ha generado el siniestro correctamente", "No se ha generado el siniestro de forma correcta");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Crea una nueva línea de póliza", page = "Manejo Póliza", functionality = "Emision")
	public static void crearNuevaLineaPolizaAP() {

		try {

			Thread.sleep(3000);
			Events.clickButton(buttonNuevaLineaPoliza);
			Events.clickButton(TransversalElements.buttonAceptar);
			String tituloObjeto = Events.getText(labelManejoObjeto);
			Utils.outputInfo("La sección actual es: " + tituloObjeto);
			Validation.trueBooleanCondition(tituloObjeto.contains("Muerte Accidental"),
					"Se ha creado el objeto de póliza para el producto correcto: " + "Muerte Accidental",
					"No se ha creado el objeto de póliza correctamente");
			String idObjeto = Events.getText(labelObjeto);
			PolizaProperties.idObjeto = idObjeto;

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Se desplaza hasta la línea de póliza", page = "Manejo Línea de Póliza", functionality = "Emision")
	public static void ingresarManejoPoliza() {
		try {
			TransversalEvents.loadingTIAGeneral();
			Events.clickButton(aManejoPoliza.replace("id-poliza", PolizaProperties.idPoliza));
			String tituloLineaPoliza = Events.getText(labelManejoPoliza);
			Utils.outputInfo("La sección actual es: " + tituloLineaPoliza);
			Validation.trueBooleanCondition(tituloLineaPoliza.contains("Accidentes Personales"),
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

	@Context(description = "Valida pagina de ajuste de la poliza", page = "Manejo Objeto", functionality = "cancelacion")
	public static void ajustePoliza() {

		try {
			Events.clickButton(TransversalElements.buttonAjustar);
			Events.clickButton(TransversalElements.buttonAceptaAjuste);
			Thread.sleep(3000);
			Validation.trueBooleanCondition(labelPaginaAjuste.contains("M Ajuste a medio plazo"),
					"Se ha ingresado al ajuste del objeto correctamente: ",
					"No se ha ingresado al ajuste del objeto correctamente");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Valida que la poliza se haya cancelado", page = "Manejo Póliza", functionality = "Cancelación")
	public static void validarPolizaCancelada() {
		try {
			//Events.clickButton(aManejoPoliza.replace("id-poliza", PolizaProperties.idPoliza));
			TransversalEvents.ingresarPolizaBusquedaRapida();
			String tituloLineaPoliza = Events.getText(labelPaginaCancelada);
			Utils.outputInfo("La sección actual es: " + tituloLineaPoliza);
			Validation.trueBooleanCondition(tituloLineaPoliza.contains("C Cancelar póliza"),
					"Se ha ingresado a estado de la póliza correctamente: " + tituloLineaPoliza,
					"No se ha ingresado a estado de la póliza correctamente");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Valida que la poliza se haya renovado", page = "Manejo Póliza", functionality = "Cancelación")
	public static void validarPolizaRenovado() {
		try {
			String tituloLineaPoliza = Events.getText(labelPaginaRenovada);
			Utils.outputInfo("La sección actual es: " + tituloLineaPoliza);
			Validation.trueBooleanCondition(tituloLineaPoliza.contains("R Renovación"),
					"Se ha ingresado a estado de la póliza correctamente: " + tituloLineaPoliza,
					"No se ha ingresado a estado de la póliza correctamente");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona el motivo de cancelación", page = "Manejo Póliza", functionality = "Cancelación")
	public static void seleccionarCancelacionPoliza(String motivoCancelacion) {
		try {
			Events.selectByContainsText(selectMotivoCancelacionPoliza, motivoCancelacion);
			Events.clickButton(TransversalElements.buttonGuardar);
			Events.clickButton(TransversalElements.buttonCompletar);
			Events.clickButton(MascotasSaludElements.aAceptaEndoso);
			Events.clickButton(TransversalElements.buttonSi);
			Thread.sleep(5000);
			Events.clickButton(TransversalElements.buttonAceptaCompletarPoliza);
			Thread.sleep(20000);
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(step = "Se completan los datos para Poliza Muerte Accidental", page = "Planes", functionality = "Emision")
	public static void seleccionarTipodeCobertura2() {

		try {
			Thread.sleep(2000);
			Events.clickButton(ClickPlanCobertura);
			Events.clickButton(SeleccionPlan2);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(step = "Se completan los datos para Poliza Muerte Accidental", page = "Riesgos", functionality = "Emision")
	public static void seleccionarCheckBoxComision() {

		try {
			Thread.sleep(2000);
			Events.clickButton(CheckboxComision);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona producto Muerte Accidental para siniestrar", page = "Manejo Objeto", functionality = "Emisión")
	public static void seleccionarProductoSiniestrar() {
		try {
			Events.clickButton(seleccionarProductoMA);
			String tituloPagina = Events.getText(labelpageSiniestros);
			Utils.outputInfo("La sección actual es: " + tituloPagina + " Salud / Accidente personal");
			Validation.trueBooleanCondition(tituloPagina.contains("Crear siniestro"),
					"Se ha ingresado a la página para la creación de un siniestro de una póliza de tipo Muerte Accidental",
					"No se ha ingresado correctamente para crear un siniestro de una póliza de tipo Muerte Accidental");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona producto Muerte Accidental para siniestrar", page = "Manejo Objeto", functionality = "Emisión")
	public static void seleccionarProductoSiniestrarSaludAP() {
		try {
			Events.clickButton(seleccionarProductoSaludAP);
			String tituloPagina = Events.getText(labelpageSiniestros);
			Utils.outputInfo("La sección actual es: " + tituloPagina + " Salud / Accidente personal");
			Validation.trueBooleanCondition(tituloPagina.contains("Crear siniestro"),
					"Se ha ingresado a la página para la creación de un siniestro de una póliza de tipo Muerte Accidental",
					"No se ha ingresado correctamente para crear un siniestro de una póliza de tipo Muerte Accidental");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(step = "Se completan los datos para Poliza Muerte Accidental", page = "Beneficiarios", functionality = "Emision")
	public static void nuevoBeneficiario(String apellido, String nombreCompleto) {

		try {
			Thread.sleep(2000);
			Events.clickButton(buttonNuevoBene);
			Events.clickButton(buscarEntidad);
			Events.sendKeys(inputApellido, apellido);
			Events.clickButton(buttonBuscarEntidad1);
			Events.clickButton(aNumeroEntidad.replace("Nombre", nombreCompleto));

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(step = "Se completan los datos para Poliza Muerte Accidental", page = "Beneficiarios", functionality = "Emision")
	public static void datosBeneficiarios(String porcentaje) {

		try {
			Thread.sleep(2000);
			Events.clickButton(comboBoxParentesco);
			Events.sendKeys(inputPorcentaje, porcentaje);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}
	
	@Context(description = "Inicia el ajuste de una Póliza para realizar cancelaciones", page = "Manejo Póliza", functionality = "Cancelación")
	public static void ajustarPolizaMA(String tipoEndoso) {

		try {
			Events.clickButton(buttonAjustarMA);
			Events.selectByContainsText(selectTipoEndosoAlternativoMA, tipoEndoso);
			Events.clickButton(buttonSelectFechadeAjuste);
			LocalDate fechaHoy2 = LocalDate.now();
			int numDiaDespues = (fechaHoy2.getDayOfMonth()) + 31;
			//fechaHoy2.plusDays(15); 
			String diaString = String.valueOf(numDiaDespues);
			Events.clickButton(buttonSeleccionarDiaHora.replace("dia", diaString));

			Events.clickButton(buttonAceptaAjusteMA);
			HogarFullEvents.loadingTIAGeneral();

			String tipoTransaccion = Events.getText(labelTipoTransaccionMA);
			Validation.trueBooleanCondition(tipoTransaccion.contains("Ajuste"),
					"Se ha ingresado al ajuste de la póliza correctamente: ",
					"No se ha ingresado al ajuste de la póliza correctamente");
			
			TransversalEvents.guardarCambios();
            //guardarCambiosHF();
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}
	
	@Context(description = "Renovar manualmente una póliza.", page = "Manejo Poliza", functionality = "Renovación")
	public static void renovarPolizaMA() {
		try {
			Events.clickButton(buttonAmpliarVentanaPolizasMA);
			Events.clickButton(aPolizaRenovarMA.replace("id-poliza", PolizaProperties.idPoliza).replace("id-producto",PolizaProperties.idProducto));
			Events.clickButton(buttonRenovarMA);
			HogarFullEvents.loadingTIAGeneral();
			String tituloPagina = Events.getText(labelPaginaRenovacionMA);
			String polizaRenovar = Events.getText(labelPolizaRenovarMA);
			Utils.outputInfo("Ha ingresado a la página: " + tituloPagina);
			Validation.trueBooleanCondition(PolizaProperties.idPoliza.equals(polizaRenovar), "Se ha cargado la página correctamente",
					"No se ha cargado la página correcta");
			Events.clickButton(buttonRenovacionMA);
			Events.clickButton(buttonCompletarRenovacionMA);
			Events.clickButton(buttonAceptarRenovacionMA);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

}
