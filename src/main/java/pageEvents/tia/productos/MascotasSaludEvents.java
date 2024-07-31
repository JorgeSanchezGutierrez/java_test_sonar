package main.java.pageEvents.tia.productos;

import main.java.pageObjects.tia.productos.MascotasSaludElements;
import main.java.pageObjects.tia.transversal.TransversalElements;
import main.java.properties.PolizaProperties;

import java.time.Duration;
import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import main.java.config.Context;
import main.java.utils.Events;
import test.java.BaseTest;
import main.java.config.Utils;
import main.java.config.Validation;
import main.java.pageEvents.tia.transversal.TransversalEvents;

public class MascotasSaludEvents implements MascotasSaludElements, TransversalElements {

	@Context(step = "Se completan los datos de la mascota seleccionando Tipo mascota", page = "Datos de la mascota", functionality = "Emision")
	public static void seleccionarTipoMascota(String tipoMascota) {

		try {
			Thread.sleep(2000);
			Events.selectByContainsText(selectTipoMascota, tipoMascota);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(step = "Se completan los datos de la mascota seleccionando el nombre", page = "Datos de la mascota", functionality = "Emision")
	public static void seleccionarNombre(String mascotaNombre) {

		try {
			Thread.sleep(2000);
			Events.sendKeys(inputMascotaNombre, mascotaNombre);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(step = "Se completan los datos de la mascota seleccionando la edad", page = "Datos de la mascota", functionality = "Emision")
	public static void seleccionarEdad(String mascotaEdad) {

		try {
			Thread.sleep(2000);
			Events.selectByContainsText(selectMascotaEdad, mascotaEdad);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(step = "Se completan los datos de la mascota seleccionando el sexo", page = "Datos de la mascota", functionality = "Emision")
	public static void seleccionarSexo(String mascotaSexo) {

		try {
			Thread.sleep(2000);
			Events.selectByContainsText(selectMascotaSexo, mascotaSexo);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(step = "Se complementan los datos de la mascota seleccionando linaje", page = "Datos de la mascota", functionality = "Emision")
	public static void seleccionarLinaje(String linaje) {

		try {
			TransversalEvents.loadingTIAGeneral(60);
			Events.selectByContainsText(selectMascotaLinaje, linaje);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(step = "Se complementan los datos de la mascota seleccionando la raza", page = "Datos de la mascota Raza", functionality = "Emision")
	public static void seleccionarTipoRaza(String tipoRaza) {

		try {
			TransversalEvents.loadingTIAGeneral(60);
			Events.selectByContainsText(selectTipoRaza, tipoRaza);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(step = "Se completan los datos del plan seleccionando la cobertura ", page = "Datos de la mascota", functionality = "Emision")
	public static void seleccionTipoCobertura(String tipoCobertura) {

		try {
			TransversalEvents.loadingTIAGeneral(60);
			Events.selectByContainsText(selectTipoCobertura, tipoCobertura);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(step = "Se complementan los datos de la mascota con la seleccion de cremacion", page = "Datos de la mascota", functionality = "Emision")
	public static void seleccionarCremacion() {

		try {
			Thread.sleep(2000);
			Utils.outputInfo("Se selecciona el check de Cremación");
			Events.clickButton(inputCremacion);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(step = "Se complementan los datos de la mascota con la seleccion de examenes", page = "Datos de la mascota", functionality = "Emision")
	public static void seleccionarExamenes() {

		try {
			Thread.sleep(2000);
			Utils.outputInfo("Se selecciona el check de Examenes");
			Thread.sleep(1000);
			Events.clickButton(inputExamenes);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(step = "Se selecciona los servicios adicionales o calcula el riesgo ", page = "Riesgos del plan", functionality = "Emision")
	public static void calcularRiesgos() {

		try {
			Thread.sleep(2000);
			Events.clickButton(buttonCalcular);
			Thread.sleep(4000);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(step = "Selecciona el producto", page = "Manejo Objeto", functionality = "Siniestro")
	public static void seleccionarProducto() {

		try {

			Events.clickButton(buttonProductoMascotasSalud);
			String tituloPagina = Events.getText(labelPaginaCrearSiniestro);
			Utils.outputInfo("La sección actual es: " + tituloPagina + " Mascotas Salud");
			Validation.trueBooleanCondition(tituloPagina.contains("Crear siniestro"),
					"Se ha ingresado a la página para la creación de un siniestro de una póliza de tipo Mascota Salud",
					"No se ha ingresado correctamente para crear un siniestro de una póliza de tipo Mascota Salud");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

//	@Context(step = "Selecciona la fecha de siniestro", page = "Manejo Objeto" , functionality = "Siniestro")
//	public static void seleccionarHoyFechaSiniestro() {
//		
//		try {
//			loadingTIAGeneral();
//			Events.clickButton(MascotasSaludElements.inputFechaSiniestro);
//			loadingTIAGeneral();
//			LocalDate fechaHoy = LocalDate.now();
//			int numDiaHoy = fechaHoy.getDayOfMonth();
//			String diaString = String.valueOf(numDiaHoy);
//			Events.clickButton(MascotasSaludElements.buttonSeleccionarDiaHoraSiniestro.replace("dia", diaString));
//			loadingTIAGeneral();
//			Events.clickButton(MascotasSaludElements.buttonAceptarFechaSiniestro);
//
//		} catch (Exception e) {
//			Utils.eventFailed(e.getMessage());
//		}
//	}

	@Context(step = "Selecciona la fecha invalida de siniestro ", page = "Manejo Objeto", functionality = "Siniestro")
	public static void seleccionarInvalidaFechaSiniestro(String fechaInvalida) {

		try {
			Thread.sleep(1000);
			Events.sendKeys(TransversalElements.inputFechaSiniestro, fechaInvalida);
			Thread.sleep(1000);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(step = "Valida la fecha invalida de siniestro ", page = "Manejo Objeto", functionality = "Siniestro")
	public static void validarFechaInvalida() {

		try {
			Thread.sleep(1000);
			Events.clickButton(buttonBusquedaPoliza);
			Thread.sleep(3000);

			String resultadosFechaInvalida = Events.getText(labelResultadosFechaInvalida);
			Utils.outputInfo("La sección actual es: " + resultadosFechaInvalida);
			Validation.trueBooleanCondition(resultadosFechaInvalida.contains("No se encontraron filas"),
					"Se ha validado correctamente", "Se presento una validación esperada");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(step = "Se ingresa el Linea Poliza N", page = "Manejo Objeto", functionality = "Siniestro")
	public static void ingresarNumeroLineaPoliza() {

		try {
			Thread.sleep(1000);
			Events.clickButton(buttonBusquedaPoliza);
			Thread.sleep(3000);
			Events.clickButton(MascotasSaludElements.spanSeleccionNumeroLineaPoliza);
			Thread.sleep(3000);
			Events.clickButton(MascotasSaludElements.buttonAceptarModalInformacionPoliza);
			Thread.sleep(3000);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(step = "Se ingresa descripcion lugar", page = "Manejo Objeto", functionality = "Siniestro")
	public static void ingresarDescripcionLugar(String descripcionLugar) {

		try {
			Thread.sleep(1000);
			Events.sendKeys(inputDescripcionLugar, descripcionLugar);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(step = "Se ingresa contacto informante", page = "Manejo Objeto", functionality = "Siniestro")
	public static void ingresarContactoInformante(String contactoInformante) {

		try {
			Thread.sleep(1000);
			Events.sendKeys(inputContactoInformante, contactoInformante);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(step = "Se ingresa monto reclamado", page = "Manejo Objeto", functionality = "Siniestro")
	public static void ingresarMontoReclamado(String montoReclamado) {

		try {
			Thread.sleep(1000);
			Events.sendKeys(textAreaMontoReclamado, montoReclamado);
			Events.clickButton(MascotasSaludElements.buttonAprobarMontoReclamado);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(step = "Se responde si es necesario asignar liquidador", page = "Manejo Objeto", functionality = "Siniestro")
	public static void ingresarPregAsigLiquidador(String asignarLiquidador) {

		try {
			Thread.sleep(1000);
			Events.selectByContainsText(selectNecesarioAsigLiquid, asignarLiquidador);
			Events.clickButton(MascotasSaludElements.buttonAprobarAsigLiquid);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(step = "Se responde la pregunta ingresando el Rut del informante", page = "Manejo Objeto", functionality = "Siniestro")
	public static void ingresarRutInformante(String rutInformante) {

		try {
			Thread.sleep(1000);
			Events.sendKeys(textAreaRutInformante, rutInformante);
			Events.clickButton(MascotasSaludElements.buttonAprobarRutInformante);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(step = "Se hace clic en Reserva", page = "Manejo Objeto", functionality = "Siniestro")
	public static void crearReserva() {

		try {
			Thread.sleep(1000);
			Events.clickButton(MascotasSaludElements.buttonCrearReserva);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(step = "Validar pagina de reserva", page = "Manejo Objeto", functionality = "Siniestro")
	public static void validarPaginaReserva() {

		try {
			Thread.sleep(2000);
			String tituloPagina = Events.getText(aLabelReserva);
			Utils.outputInfo("La sección actual es: " + tituloPagina);
			Validation.trueBooleanCondition(tituloPagina.contains("Reserva"),
					"Se ha ingresado correctamente a: " + tituloPagina, "No se ha ingresado al resumen de la entidad");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(step = "Ingresar nuevo item", page = "Manejo Objeto", functionality = "Siniestro")
	public static void ingresarItem() {

		try {
			Thread.sleep(1000);
			Events.clickButton(MascotasSaludElements.buttonNuevoItem);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(step = "Se ingresa tipo item", page = "Manejo Objeto", functionality = "Siniestro")
	public static void ingresarTipoItem(String tipoItem) {

		try {
			Thread.sleep(1000);
			Events.selectByContainsText(selectTipoItem, tipoItem);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(step = "Se ingresa tipo sub item", page = "Manejo Objeto", functionality = "Siniestro")
	public static void ingresarTipoSubItem(String tipoSubItem) {

		try {
			Thread.sleep(1000);
			Events.selectByContainsText(selectTipoSubItem, tipoSubItem);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(step = "Se ingresa reserva en el item", page = "Manejo Objeto", functionality = "Siniestro")
	public static void ingresarReservaItem(String reserva) {

		try {
			Thread.sleep(1000);
			Events.sendKeys(inputReservaItem, reserva);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(step = "Se ingresa gestor distinto al usuario actual", page = "Manejo Objeto", functionality = "Siniestro")
	public static void ingresarGestorSiniestro(String gestor) {

		try {
			Thread.sleep(1000);
			Events.sendKeys(inputGestorSiniestros, gestor);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(step = "guardar nuevo item", page = "Manejo Objeto", functionality = "Siniestro")
	public static void guardarItem() {

		try {
			Thread.sleep(1000);
			Events.clickButton(MascotasSaludElements.buttonGuardarItem);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(step = "Se genera un siniestro en estado abierto", page = "Siniestro", functionality = "Siniestro")
	public static void generarSiniestro() {

		try {
			Thread.sleep(1000);
			Events.clickButton(buttonGenerarSiniestroMS);
			TransversalEvents.verificaBitacoraDesplegada();
			String tittle = Events.getText(labelSiniestroNotificado);
			Utils.outputInfo("La sección actual es: " + tittle);
			int inicio = tittle.indexOf("-");
			int fin = tittle.indexOf("(", inicio + 1);
			String idSiniestro = tittle.substring(inicio + 2, fin - 1);
			Validation.trueBooleanCondition(tittle.contains("(Notificado)"),
					"Se ha generado el siniestro correctamente con ID: " + idSiniestro,
					"No se ha generado el siniestro de forma correcta");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Se desplaza hasta la línea de póliza", page = "Manejo Línea de Póliza", functionality = "Emision")
	public static void ingresarLineaPoliza() {
		try {
			Events.clickButton(aLineaPoliza.replace("id-poliza", PolizaProperties.idPoliza));
			String tituloLineaPoliza = Events.getText(labelManejoLineaPoliza);
			Utils.outputInfo("La sección actual es: " + tituloLineaPoliza);
			Validation.trueBooleanCondition(tituloLineaPoliza.contains("Mascota"),
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

	@Context(description = "Selecciona el motivo de cancelación", page = "Manejo Póliza", functionality = "Cancelación")
	public static void seleccionarCancelacionPoliza(String motivoCancelacion) {
		try {
			Events.selectByContainsText(selectMotivoCancelacionPoliza, motivoCancelacion);
			Events.clickButton(TransversalElements.buttonGuardar);
			Events.clickButton(TransversalElements.buttonCompletar);
			Events.clickButton(MascotasSaludElements.aAceptaEndoso);
			Events.clickButton(TransversalElements.buttonSi);
			Events.clickButton(TransversalElements.buttonAceptaCompletarPoliza);
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Aceptar cancelacion", page = "Manejo Póliza", functionality = "Cancelación")
	public static void seleccionarCancelar(String motivoCancelacion) {
		try {
			Events.selectByContainsText(selectMotivoCancelacionPoliza, motivoCancelacion);
			Events.clickButton(TransversalElements.buttonGuardar);
			Events.clickButton(TransversalElements.buttonCompletar);
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Valida que la poliza se haya cancelado", page = "Manejo Póliza", functionality = "Cancelación")
	public static void validarPolizaCancelada() {
		try {
			TransversalEvents.loadingTIAGeneral(50);
			Events.clickButton(aManejoPoliza.replace("id-poliza", PolizaProperties.idPoliza));
			TransversalEvents.loadingTIAGeneral(50);
			String tituloLineaPoliza = Events.getText(labelPaginaCancelada);
			Utils.outputInfo("La sección actual es: " + tituloLineaPoliza);
			Validation.trueBooleanCondition(tituloLineaPoliza.contains("C Cancelar póliza"),
					"Se ha ingresado a estado de la póliza correctamente: " + tituloLineaPoliza,
					"No se ha ingresado a estado de la póliza correctamente");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Valida que la poliza se haya cancelado", page = "Manejo Póliza", functionality = "Cancelación")
	public static void validarErrorPolizaCancelada() {
		try {
			String tituloLineaPoliza = Events.getText(labelErrorCancelacionAseg);
			Utils.outputInfo("La sección actual es: " + tituloLineaPoliza);
			Validation.trueBooleanCondition(tituloLineaPoliza.contains(
					"Sólo se permite la cancelación por parte del asegurado después de 10 días desde la emisión de la póliza."),
					"Se ha validado la póliza correctamente: " + tituloLineaPoliza,
					"No se ha valdiado la póliza correctamente");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(step = "Extrae numero manejo de pólizas", page = "Manejo Objeto", functionality = "emision")
	public static void extraeNumeroManejoPoliza() {

		try {

			String numeroManejoPoliza = Events.getText("");
			Utils.outputInfo("La sección actual es: " + numeroManejoPoliza);

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

	@Context(description = "Se desplaza hasta la línea de póliza", page = "Manejo Línea de Póliza", functionality = "Emision")
	public static void ingresarManejoPoliza() {
		try {
			Events.clickButton(aManejoPoliza.replace("id-poliza", PolizaProperties.idPoliza));
			TransversalEvents.loadingTIAGeneral();
			String tituloLineaPoliza = Events.getText(labelManejoPoliza);
			Utils.outputInfo("La sección actual es: " + tituloLineaPoliza);
			Validation.trueBooleanCondition(tituloLineaPoliza.contains("Mascota"),
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
	public static void validarEndoso() {
		try {
			String tipoTransaccion = Events.getText(labelTipoTransaccionMS);
			Validation.trueBooleanCondition(tipoTransaccion.contains("Ajuste"),
					"Se ha realizado el ajuste correctamente, el código de transacción es :" + tipoTransaccion,
					"No se ha realizado el ajuste correctamente");
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	/*@Context(description = "Ir a página Administración", page = "Administración")
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
	}*/

	@Context(description = "Esperar la actualización de la ventana/módulo que se está cargando", page = "Transversal")
	public static void loadingTIAGeneral() {
		try {
			WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(50));

			WebElement element = BaseTest.driver.findElement(By.xpath(MascotasSaludElements.loadingTia));
			wait.until(ExpectedConditions.visibilityOf(element));

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	/*@Context(description = "Ir a página Buscar item Cuenta", page = "Administración")
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
	}*/

	/*@Context(description = "Buscar número de Item de Cuenta para factura de pago de cuota", page = "Administración")
	public static void buscarItem() {
		try {
			Thread.sleep(2000);
//			Events.clickButton(buttonCuenta3);
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
			Thread.sleep(2000);
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
			Events.clickButton(MascotasSaludElements.buttonAcepta);
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
			Thread.sleep(2000);
			Events.clickButton(buttonCrearPago);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}*/

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

	@Context(description = "Activar casilla 'Fecha Aproximada'", page = "Manejo de objetos")
	public static void seleccionarFechaAproximada() {
		try {
			Events.clickButton(checkBoxFechaEstimada);
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Inicia el ajuste de una Póliza para realizar cancelaciones", page = "Manejo Póliza", functionality = "Cancelación")
	public static void ajustarPoliza(String tipoEndoso) {

		try {
			Events.clickButton(buttonAjustarHF);
			Events.selectByContainsText(selectTipoEndosoAlternativoHF, tipoEndoso);
			Events.clickButton(buttonAceptaAjusteHF);
			loadingTIAGeneral();

			String tipoTransaccion = Events.getText(labelTipoTransaccionHF);
			Validation.trueBooleanCondition(tipoTransaccion.contains("Ajuste"),
					"Se ha ingresado al ajuste de la póliza correctamente: ",
					"No se ha ingresado al ajuste de la póliza correctamente");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}
	
	@Context(description = "Selecciona y acepta transacción de endoso.", page = "Manejo Póliza", functionality = "Cancelación")
	public static void aceptarYCompletarEndoso() {
		try {
			
			Events.clickButton(MascotasSaludElements.aAceptaEndoso);
			Events.clickButton(TransversalElements.buttonSi);
			Events.clickButton(TransversalElements.buttonAceptaCompletarPoliza);
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}
	
}
