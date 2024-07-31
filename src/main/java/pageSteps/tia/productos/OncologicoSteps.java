package main.java.pageSteps.tia.productos;

import main.java.config.Context;
import main.java.config.Utils;
import main.java.pageEvents.tia.productos.OncologicoEvents;
import main.java.pageEvents.tia.transversal.TransversalEvents;

public class OncologicoSteps {

	@Context(step = "Completar plan fonasa individual", page = "Manejo Objeto")
	public static void completarPlanFonasaIndividual() {

		Utils.stepStarted();
		OncologicoEvents.seleccionarPlan("Individual");
		OncologicoEvents.seleccionarTipoCobertura("Fonasa");
		OncologicoEvents.verificarAsistenciaCancer();
	}

	@Context(step = "Completar plan fonasa familiar", page = "Manejo Objeto")
	public static void completarPlanFonasaFamiliar() {

		Utils.stepStarted();
		OncologicoEvents.seleccionarPlan("Familiar");
		OncologicoEvents.seleccionarTipoCobertura("Fonasa");
		OncologicoEvents.verificarAsistenciaCancer();
	}

	@Context(step = "Completar plan isapre individual", page = "Manejo Objeto")
	public static void completarPlanIsapreIndividual(String isapre) {

		Utils.stepStarted();
		OncologicoEvents.seleccionarPlan("Individual");
		OncologicoEvents.seleccionarTipoCobertura("Isapre");
		OncologicoEvents.seleccionarIsapre(isapre);
		OncologicoEvents.verificarAsistenciaCancer();
	}

	@Context(step = "Completar plan isapre familiar", page = "Manejo Objeto")
	public static void completarPlanIsapreFamiliar(String isapre) {

		Utils.stepStarted();
		OncologicoEvents.seleccionarPlan("Familiar");
		OncologicoEvents.seleccionarTipoCobertura("Isapre");
		OncologicoEvents.seleccionarIsapre(isapre);
		OncologicoEvents.verificarAsistenciaCancer();
	}

	@Context(step = "Agregar asegurado adicional", page = "Manejo Objeto")
	public static void agregarAseguradoAdicional(String apellidoAA, String nombreAA, String parentesco) {

		Utils.stepStarted();
		OncologicoEvents.nuevoAseguradoAdicional(apellidoAA);
		OncologicoEvents.seleccionarAseguradoAdicional(nombreAA);
		OncologicoEvents.seleccionarParentesco(parentesco);
		TransversalEvents.guardarCambios();
		OncologicoEvents.verificarRangoEdad();
		OncologicoEvents.validarNoCambioPrima();
	}

	@Context(step = "Seleccionar opción Oncológico dentro de la creación de Siniestro", page = "Manejo Objeto")
	public static void seleccionarProducto() {
		Utils.stepStarted();
		OncologicoEvents.seleccionarProducto();

	}

	@Context(step = "Validar que se despliegue texto en el campo 'Texto de Póliza'", page = "Manejo Objeto")
	public static void validarDesplieguePolizasAsociada() {
		Utils.stepStarted();
		OncologicoEvents.validarDesplieguePolizasAsociada();

	}

	@Context(step = "Validar ingreso de ducible", page = "Manejo Objeto")
	public static void ingresarDeducible(String deducible) {
		Utils.stepStarted();
		OncologicoEvents.ingresarDeducible(deducible);
	}

	@Context(step = "Validar que no ingrese liquidador", page = "Manejo Objeto")
	public static void seleccionarLiquidador() {
		Utils.stepStarted();
		OncologicoEvents.seleccionarLiquidadorVacio();
	}

	@Context(step = "Validar despliegue de modulo siniestro", page = "Manejo Objeto")
	public static void validarDespliegueModuloSiniestro() {
		Utils.stepStarted();
		OncologicoEvents.validarDespliegueSiniestro();

	}

	@Context(step = "Rellenar los campos del asistente de preguntas", page = "Manejo Objeto")
	public static void asistentePreguntas(String biopsia, String informe, String rutInformante, String correoInformante,
			String telefonoInformante) {
		Utils.stepStarted();
		OncologicoEvents.diagnosticoCancerBiopsiaAsistentePreguntas(biopsia);
		OncologicoEvents.informeAnatomopatologicoAsistentePreguntas(informe);
		OncologicoEvents.rutInformanteAsistentePreguntas(rutInformante);
		OncologicoEvents.correoInformanteAsistentePreguntas(correoInformante);
		OncologicoEvents.telefonoInformanteAsistentePreguntas(telefonoInformante);

	}

	@Context(step = "Rellenar los campos del asistente de preguntas", page = "Manejo Objeto")
	public static void asistentePreguntas(String biopsia, String informe, String diagnosticoUCCHRISTUS,
			String rutInformante, String correoInformante, String telefonoInformante) {
		Utils.stepStarted();
		OncologicoEvents.diagnosticoCancerBiopsiaAsistentePreguntas(biopsia);
		OncologicoEvents.informeAnatomopatologicoAsistentePreguntas(informe);
		OncologicoEvents.diagnosticoUCCHRISTUS(diagnosticoUCCHRISTUS);
		OncologicoEvents.rutInformanteAsistentePreguntas(rutInformante);
		OncologicoEvents.correoInformanteAsistentePreguntas(correoInformante);
		OncologicoEvents.telefonoInformanteAsistentePreguntas(telefonoInformante);

	}

	@Context(step = "Rellenar los campos del asistente de preguntas", page = "Manejo Objeto")
	public static void gestorSiniestro(String nombreGestor) {
		Utils.stepStarted();
		OncologicoEvents.gestorSiniestro(nombreGestor);

	}

	@Context(step = "Extraer numero del siniestro creado", page = "Manejo Objeto")
	public static void recuperarNumeroSiniestro() {
		Utils.stepStarted();
		OncologicoEvents.extraerNumeroSiniestro();
	}

	@Context(step = "Buscar Siniestro creado", page = "Manejo Objeto")
	public static void buscarSiniestro(String numeroSiniestro) {
		Utils.stepStarted();
		OncologicoEvents.buscarSiniestro(numeroSiniestro);
	}

	@Context(step = "Seleccionar modulo de Reservas y Pagos", page = "Manejo Objeto")
	public static void seleccionarModuloReservasPagos() {
		Utils.stepStarted();
		OncologicoEvents.seleccionarModuloReservasPagos();
	}

	@Context(step = "Crea un item de reserva", page = "Reserva", functionality = "Siniestros")
	public static void crearReservaOnco(String tipoItem, String tipoSubItem, String idReceptor, String reserva) {

		Utils.stepStarted();
		TransversalEvents.crearNuevoItem();
		TransversalEvents.seleccionarTipoItem(tipoItem);
		TransversalEvents.seleccionarTipoSubItem(tipoSubItem);
		OncologicoEvents.seleccionarReceptor(idReceptor);
		OncologicoEvents.insertarMontoReserva(reserva);

	}

	@Context(step = "Busca Poliza a siniestrar", page = "Crear Siniestro", functionality = "Siniestros")
	public static void buscarPoliza(String idPoliza) {
		Utils.stepStarted();
		OncologicoEvents.buscarPoliza(idPoliza);
	}

	@Context(step = "tiempo de espera esto es temrporal", page = "Manejo Objeto")
	public static void tiempoEspera() {
		Utils.stepStarted();
		OncologicoEvents.tiempoEspera();

	}

	@Context(step = "validar número de cobertura seleccionado automaticamente", page = "Manejo Objeto")
	public static void validarNumeroCobertura() {
		Utils.stepStarted();
		OncologicoEvents.validarNumeroCobertura();

	}

	public static void validarDescripcionCobertura() {
		Utils.stepStarted();
		OncologicoEvents.validarDescripcionCobertura();
	}

	public static void validarNumSubCobertura() {
		Utils.stepStarted();
		OncologicoEvents.validarNumSubCobertura();

	}

	public static void validarDescripcion() {
		Utils.stepStarted();
		OncologicoEvents.validarDescripcion();
	}

	public static void validarNombreDestinatario() {
		Utils.stepStarted();
		OncologicoEvents.validarNombreDestinatario();

	}

	public static void validarRol() {
		Utils.stepStarted();
		OncologicoEvents.validarRol();

	}

	public static void validarMoneda() {
		Utils.stepStarted();
		OncologicoEvents.validarMoneda();

	}

	public static void ingresarReserva(String montoReserva) {
		Utils.stepStarted();
		OncologicoEvents.ingresarReserva(montoReserva);

	}

	public static void validarPaid() {
		Utils.stepStarted();
		OncologicoEvents.validarPaid();

	}

	public static void validarEstado() {
		Utils.stepStarted();
		OncologicoEvents.validarEstado();

	}

	public static void seleccionarItemPago() {
		Utils.stepStarted();
		OncologicoEvents.seleccionarItemPago();

	}

	public static void liquidarItemPago() {
		Utils.stepStarted();
		OncologicoEvents.liquidarItemPago();

	}

	public static void aceptarReceptor() {
		Utils.stepStarted();
		OncologicoEvents.aceptarReceptor();
	}

	public static void itemPago(String tipoPago) {
		Utils.stepStarted();
		OncologicoEvents.itemPago(tipoPago);
	}

	public static void especificacionPago(String numFactura) {
		Utils.stepStarted();
		OncologicoEvents.especificacionPago(numFactura);

	}

	public static void aprobarPago() {
		Utils.stepStarted();
		OncologicoEvents.aprobarPago();
	}

	public static void validarItemPagoCerrado() {
		Utils.stepStarted();
		OncologicoEvents.validarItemPagoCerrado();

	}

	@Context(step = "Agrega un código de descuento a la póliza", page = "Línea Póliza")
	public static void incluirDescuentoOnco(String codigo, String respuesta) {
		Utils.stepStarted();
		OncologicoEvents.agregarDescuentoOnco(codigo, respuesta);
		TransversalEvents.guardarCambios();
		TransversalEvents.crearNuevaLineaPoliza();
	}

	@Context(step = "Calcula la prima total del seguro", page = "Objeto Póliza")
	public static void calcularPrimaTotalOncoDsct() {
		Utils.stepStarted();
		TransversalEvents.calcularPrimaTotal();
		TransversalEvents.guardarCambios();
		TransversalEvents.ingresarPolizaV2();
		TransversalEvents.ingresarLineaPolizaV2();
		TransversalEvents.loadingTIAGeneral();
		OncologicoEvents.confirmarDescuento();
	}
	
	@Context(step = "Crea una nueva póliza para siniestrar, del producto seleccionado para la entidad buscada", page = "Resumen Entidad")
    public static void crearPolizaSiniestroOnco(String producto, String canalVenta) {
        Utils.stepStarted();
        TransversalEvents.crearNuevaPoliza(producto);
        //OncologicoEvents.seleccionarFechaPolizaDosDiasAntes();
        TransversalEvents.seleccionarCanalVenta(canalVenta);
        TransversalEvents.guardarCambios();
        TransversalEvents.crearNuevaLineaPoliza();
    }
	
	@Context(step = "Agregar asegurado adicional", page = "Manejo Objeto")
	public static void agregarAseguradoAdicionalCambioTarifa(String apellidoAA, String nombreAA, String parentesco) {

		Utils.stepStarted();
		OncologicoEvents.nuevoAseguradoAdicional(apellidoAA);
		OncologicoEvents.seleccionarAseguradoAdicional(nombreAA);
		OncologicoEvents.seleccionarParentesco(parentesco);
		TransversalEvents.guardarCambios();
		OncologicoEvents.verificarRangoEdad();
	}
	
}
