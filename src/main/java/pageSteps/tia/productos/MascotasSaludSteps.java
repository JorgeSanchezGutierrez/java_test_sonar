package main.java.pageSteps.tia.productos;

import main.java.config.Context;
import main.java.config.Utils;
import main.java.pageEvents.tia.productos.MascotasSaludEvents;
import main.java.pageEvents.tia.transversal.TransversalEvents;

public class MascotasSaludSteps {

	@Context(step = "Completar datos de mascota", page = "Manejo Objeto", functionality = "Emision")
	public static void datosMascotas(String tipoMascota, String mascotaEdad, String mascotaNombre, String mascotaSexo) {

		Utils.stepStarted();
		MascotasSaludEvents.seleccionarTipoMascota(tipoMascota);
		MascotasSaludEvents.seleccionarEdad(mascotaEdad);
		MascotasSaludEvents.seleccionarNombre(mascotaNombre);
		MascotasSaludEvents.seleccionarSexo(mascotaSexo);
	}

	@Context(step = "Completar datos de una mascota mestizo", page = "Manejo Objeto", functionality = "Emision")
	public static void datosMascotasMestizo() {

		Utils.stepStarted();
		MascotasSaludEvents.seleccionarLinaje("Mestizo");

	}

	@Context(step = "Completa datos de una mascota de raza", page = "Manejo Objeto", functionality = "Emision")
	public static void datosMascotasRaza(String tipoRaza) {

		Utils.stepStarted();
		MascotasSaludEvents.seleccionarLinaje("Raza");
		MascotasSaludEvents.seleccionarTipoRaza(tipoRaza);

	}

	@Context(step = "Completar datos del plan de salud", page = "Manejo Objeto", functionality = "Emision")
	public static void datosPlan(String tipoCobertura) {

		Utils.stepStarted();
		MascotasSaludEvents.seleccionTipoCobertura(tipoCobertura);

	}

	@Context(step = "Seleccionar cobertura cremación", page = "Manejo Objeto", functionality = "Emision")
	public static void seleccionCremacion() {

		Utils.stepStarted();
		MascotasSaludEvents.seleccionarCremacion();

	}

	@Context(step = "Seleccionar cobertura exámenes", page = "Manejo Objeto", functionality = "Emision")
	public static void seleccionExamenes() {

		Utils.stepStarted();
		MascotasSaludEvents.seleccionarExamenes();

	}

	@Context(step = "Calcula la prima del plan", page = "Manejo Objeto", functionality = "Emision")
	public static void riesgosPlan() {

		Utils.stepStarted();
		MascotasSaludEvents.calcularRiesgos();

	}

	@Context(step = "Agrega un código de descuento a la póliza", page = "Línea Póliza", functionality = "Emision")
	public static void incluirDescuento(String codigo) {
		Utils.stepStarted();
		MascotasSaludEvents.ingresarLineaPoliza();
		MascotasSaludEvents.agregarDescuento(codigo);
	}

	// Siniestros

	@Context(step = "Selecciona producto", page = "Manejo Objeto", functionality = "Siniestro")
	public static void seleccionProducto() {

		Utils.stepStarted();
		MascotasSaludEvents.seleccionarProducto();

	}

	@Context(step = "Ingresa fecha invalida del siniestro", page = "Manejo Objeto", functionality = "Siniestro")
	public static void seleccionFechaInvalidaSiniestro(String fechaInvalida) {

		Utils.stepStarted();
		MascotasSaludEvents.seleccionarInvalidaFechaSiniestro(fechaInvalida);
	}

	@Context(step = "Valida fecha invalida del siniestro", page = "Manejo Objeto", functionality = "Siniestro")
	public static void validaFechaInvalida() {

		Utils.stepStarted();
		MascotasSaludEvents.validarFechaInvalida();
	}

	@Context(step = "Ingresa numero linea poliza", page = "Manejo Objeto", functionality = "Siniestro")
	public static void ingresarNumeroLineaPoliza() {

		Utils.stepStarted();
		MascotasSaludEvents.ingresarNumeroLineaPoliza();

	}

	@Context(step = "Ingresa descripcion lugar", page = "Manejo Objeto", functionality = "Siniestro")
	public static void ingresarDescripcionLugar(String descripcionLugar) {

		Utils.stepStarted();
		MascotasSaludEvents.ingresarDescripcionLugar(descripcionLugar);

	}

	@Context(step = "Ingresa contacto informante", page = "Manejo Objeto", functionality = "Siniestro")
	public static void ingresarContactoInformante(String contactoInformante) {

		Utils.stepStarted();
		MascotasSaludEvents.ingresarContactoInformante(contactoInformante);

	}

	@Context(step = "Ingresa el monto reclamado", page = "Manejo Objeto", functionality = "Siniestro")
	public static void ingresaMontoReclamado(String montoReclamado) {

		Utils.stepStarted();
		MascotasSaludEvents.ingresarMontoReclamado(montoReclamado);

	}

	@Context(step = "Se responde si es necesario asignar liquidador", page = "Manejo Objeto", functionality = "Siniestro")
	public static void ingresarPregAsigLiquidador(String asignarLiquidador) {

		Utils.stepStarted();
		MascotasSaludEvents.ingresarPregAsigLiquidador(asignarLiquidador);

	}

	@Context(step = "Se responde con el rut del informante", page = "Manejo Objeto", functionality = "Siniestro")
	public static void ingresarRutInformante(String rutInformante) {

		Utils.stepStarted();
		MascotasSaludEvents.ingresarRutInformante(rutInformante);

	}

	@Context(step = "Se ingresa a generar reserva", page = "Manejo Objeto", functionality = "Siniestro")
	public static void crearReserva() {

		Utils.stepStarted();
		MascotasSaludEvents.crearReserva();

	}

	@Context(step = "Se valida pagina de generar reserva", page = "Manejo Objeto", functionality = "Siniestro")
	public static void validarPaginaReserva() {

		Utils.stepStarted();
		MascotasSaludEvents.validarPaginaReserva();

	}

	@Context(step = "Se ingresa a nuevo item", page = "Manejo Objeto", functionality = "Siniestro")
	public static void ingresarNuevoItem() {

		Utils.stepStarted();
		MascotasSaludEvents.ingresarItem();

	}

	@Context(step = "Se ingresa tipo item", page = "Manejo Objeto", functionality = "Siniestro")
	public static void ingresarTipoItem(String tipoItem) {

		Utils.stepStarted();
		MascotasSaludEvents.ingresarTipoItem(tipoItem);

	}

	@Context(step = "Se ingresa tipo sub item", page = "Manejo Objeto", functionality = "Siniestro")
	public static void ingresarTipoSubItem(String tipoSubItem) {

		Utils.stepStarted();
		MascotasSaludEvents.ingresarTipoSubItem(tipoSubItem);

	}

	@Context(step = "Se ingresa gestor de siniestro", page = "Manejo Objeto", functionality = "Siniestro")
	public static void ingresaGestorSiniestro(String gestor) {

		Utils.stepStarted();
		MascotasSaludEvents.ingresarGestorSiniestro(gestor);

	}

	@Context(step = "Se guarda item", page = "Manejo Objeto", functionality = "Siniestro")
	public static void ingresaReserva(String reserva) {

		Utils.stepStarted();
		MascotasSaludEvents.ingresarReservaItem(reserva);

	}

	@Context(step = "Se guarda item", page = "Manejo Objeto", functionality = "Siniestro")
	public static void guardarItem() {

		Utils.stepStarted();
		MascotasSaludEvents.guardarItem();
	}

	@Context(step = "Genera un siniestro para una póliza vigente", page = "Crear Siniestro", functionality = "Siniestros")
	public static void generarSiniestro() {
		Utils.stepStarted();
		MascotasSaludEvents.generarSiniestro();
	}

	@Context(step = "Valida que se haya realizado correctamente el endoso", page = "Manejo Póliza", functionality = "Cancelación")
	public static void validarEndoso() {
		Utils.stepStarted();
		MascotasSaludEvents.ingresarLineaPoliza();
		MascotasSaludEvents.validarEndoso();
	}

	@Context(step = "Ingreso a la seccion de manejo de póliza ", page = "Manejo Póliza", functionality = "Cancelación")
	public static void manejoPoliza() {
		Utils.stepStarted();
		MascotasSaludEvents.ingresarManejoPoliza();

	}

	@Context(step = "Ingreso al model de ajuste de objeto ", page = "Manejo Póliza", functionality = "Cancelación")
	public static void ajustarPoliza() {
		Utils.stepStarted();
		MascotasSaludEvents.ajustePoliza();
	}

	@Context(step = "Selecciona el motivo de la cancelacion ", page = "Manejo Póliza", functionality = "Cancelación")
	public static void seleccionaCancelacionPoliza(String motivoCancelacion) {
		Utils.stepStarted();
		MascotasSaludEvents.seleccionarCancelacionPoliza(motivoCancelacion);
	}

	@Context(step = "Selecciona completar al cancelar la poliza ", page = "Manejo Póliza", functionality = "Cancelación")
	public static void seleccionaCancelacion(String motivoCancelacion) {
		Utils.stepStarted();
		MascotasSaludEvents.seleccionarCancelar(motivoCancelacion);
	}

	@Context(step = "Selecciona el motivo de la cancelacion ", page = "Manejo Póliza", functionality = "Cancelación")
	public static void validarEstadoCancelacionPoliza() {
		Utils.stepStarted();
		MascotasSaludEvents.validarPolizaCancelada();
	}

	@Context(step = "Valida el error arrojado por Tia ", page = "Manejo Póliza", functionality = "Cancelación")
	public static void validarErrorCancelacionAseg() {
		Utils.stepStarted();
		MascotasSaludEvents.validarErrorPolizaCancelada();
	}

	@Context(step = "Inicia ajuste de póliza con fecha de ajuste por defecto del sistema", page = "Manejo Póliza", functionality = "Cancelación")
	public static void ajustarPoliza(String tipoEndoso) {
		Utils.stepStarted();
		MascotasSaludEvents.ajustarPoliza(tipoEndoso);
		TransversalEvents.guardarCambios();
	}

	@Context(step = "Inicia ajuste de póliza con fecha de ajuste por defecto del sistema", page = "Manejo Póliza", functionality = "Cancelación")
	public static void ajustarPolizaCancelación(String tipoEndoso) {
		Utils.stepStarted();
		MascotasSaludEvents.ajustarPoliza(tipoEndoso);
	}

	@Context(step = "Selecciona 'aceptar endoso' y completa la transacción", page = "Manejo Póliza", functionality = "Cancelación")
	public static void aceptarYCompletarEndoso() {
		Utils.stepStarted();
		MascotasSaludEvents.aceptarYCompletarEndoso();
	}
}