package main.java.pageSteps.tia.transversal;

import main.java.config.Context;
import main.java.config.Utils;
import main.java.pageEvents.tia.productos.MuerteAccidentalEvents;
import main.java.pageEvents.tia.productos.OncologicoEvents;
import main.java.pageEvents.tia.transversal.TransversalEvents;

public class TransversalSteps {
	@Context(step = "Ingresa como usuario suscriptor", page = "TIA")
	public static void ingresarComoSuscriptor(String user, String pass) {
		Utils.stepStarted();
		TransversalEvents.validarAmbienteTIA();
		TransversalEvents.iniciarSesion(user, pass);
	}

	@Context(step = "Busca una entidad por su apellido o razón social", page = "Página Principal")
	public static void buscarEntidad(String apellido, String nombre) {
		Utils.stepStarted();
		TransversalEvents.desplegarSeccionBarraLateral("Flujos de trabajo de usuario");
		TransversalEvents.buscarEntidad(apellido);
		TransversalEvents.seleccionarContratante(nombre);
	}

	@Context(step = "Completar datos de emision", page = "Manejo Objeto", functionality = "Emision")
	public static void renovacion() {

		Utils.stepStarted();
		TransversalEvents.buttonRenovar();
	}

	@Context(step = "Pagar una cuota de la póliza seleccionada", page = "Administración")
	public static void pagarCuota() throws InterruptedException {
		Utils.stepStarted();
		TransversalSteps.visitarPaginaHome();
		TransversalEvents.cargarPaginaAdmin();
		TransversalEvents.cargarPaginaBuscarItemCuenta();
		TransversalEvents.buscarItem();
		TransversalEvents.seleccionarItemPagar();
		TransversalEvents.validarEstadoItemSeleccionado();
		TransversalEvents.crearPago();
		TransversalEvents.validarEstadoEnviadoSistemaPago();
	}

	@Context(step = "Valida que ocurra la reversión del pago de una cuota que ha sido cancelada", page = "Administración")
	public static void validarReversionPagoCuota() {
		Utils.stepStarted();
		TransversalEvents.cargarPaginaAdmin();
		// MuerteAccidentalEvents.cargarPaginaBuscarItemCuenta2();
		TransversalEvents.buscarItem2();
		TransversalEvents.validarMontoRevertido();
	}

	@Context(step = "Se revisa el estado de la poliza ", page = "Manejo Póliza", functionality = "Cancelación")
	public static void validarEstadoRenovadaPoliza() {
		Utils.stepStarted();
		MuerteAccidentalEvents.validarPolizaRenovado();
	}

	@Context(step = "Crea una nueva póliza del producto seleccionado para la entidad buscada", page = "Resumen Entidad")
	public static void crearPolizaAP2(String producto, String Finicio, String canalVenta) throws InterruptedException {
		Utils.stepStarted();
		TransversalEvents.crearNuevaPoliza(producto);
		TransversalEvents.seleccionarFechaPoliza(Finicio);
		TransversalEvents.guardarCambios();
		Thread.sleep(4000);
		TransversalEvents.seleccionarCanalVenta(canalVenta);
		MuerteAccidentalEvents.crearNuevaLineaPolizaAP();
	}

	@Context(step = "Crea una nueva póliza del producto seleccionado para la entidad buscada", page = "Resumen Entidad")
	public static void crearPolizaParaRenovar(String producto, String Finicio, String canalVenta)
			throws InterruptedException {
		Utils.stepStarted();
		TransversalEvents.crearNuevaPoliza(producto);
		TransversalEvents.seleccionarFechaPoliza(Finicio);
		TransversalEvents.guardarCambios();
		Thread.sleep(4000);
		TransversalEvents.seleccionarCanalVenta(canalVenta);
		TransversalEvents.crearNuevaLineaPoliza();
	}

	@Context(step = "Crea una nueva póliza del producto seleccionado para la entidad buscada", page = "Resumen Entidad")
	public static void crearPoliza(String producto, String canalVenta) {
		Utils.stepStarted();
		TransversalEvents.crearNuevaPoliza(producto);
		TransversalEvents.seleccionarCanalVenta(canalVenta);
		TransversalEvents.guardarCambios();
		TransversalEvents.crearNuevaLineaPoliza();
	}

	@Context(step = "Crea una nueva póliza con dia anterior del producto seleccionado para la entidad buscada", page = "Resumen Entidad")
	public static void crearPolizaDiaAnterior(String producto, String canalVenta) {
		Utils.stepStarted();
		TransversalEvents.crearNuevaPoliza(producto);
		TransversalEvents.seleccionarCanalVenta(canalVenta);
		TransversalEvents.guardarCambios();
		TransversalEvents.seleccionarFechaPolizaDosDiasAntes();
		TransversalEvents.crearNuevaLineaPoliza();
	}

	@Context(step = "Crea una nueva póliza del producto seleccionado para la entidad buscada", page = "Resumen Entidad")
	public static void crearPolizaOncoDsct(String producto, String canalVenta) {
		Utils.stepStarted();
		TransversalEvents.crearNuevaPoliza(producto);
		TransversalEvents.seleccionarCanalVenta(canalVenta);
	}

	@Context(step = "Crea una póliza para validar la renovación", page = "Resumen Entidad")
	public static void crearPolizaRenovar(String producto, String canalVenta) {
		Utils.stepStarted();
		TransversalEvents.crearNuevaPoliza(producto);
		TransversalEvents.seleccionarCanalVenta(canalVenta);
		TransversalEvents.seleccionarFechaInicioPoliza();
		TransversalEvents.guardarCambios();
		TransversalEvents.crearNuevaLineaPoliza();
	}

	@Context(step = "Inicia la creación de una nueva póliza del producto seleccionado para un contratante de tipo de entidad errónea, por lo que no continúa el proceso", page = "Resumen Entidad")
	public static void crearPolizaAlternativo(String producto) {
		Utils.stepStarted();
		TransversalEvents.crearNuevaPolizaAlternativo(producto);
		TransversalEvents.quitarModalSeleccionarProducto();
	}

	@Context(step = "Calcula la prima total del seguro", page = "Objeto Póliza")
	public static void calcularPrimaTotal() {
		Utils.stepStarted();
		TransversalEvents.calcularPrimaTotal();
		TransversalEvents.guardarCambios();
	}

//	@Context(step = "Recalcula la prima total del seguro ante un endoso complejo", page = "Objeto Póliza")
//	public static void calcularPrimaTotalEndosoComplejo(){
//		Utils.stepStarted();
//		TransversalEvents.calcularPrimaTotalEndosoComplejo();
//		TransversalEvents.guardarCambios();
//	}

	@Context(step = "Guardar cambios", page = "Objeto Póliza")
	public static void guardarCambios() {
		Utils.stepStarted();
		TransversalEvents.guardarCambios();
	}

	@Context(step = "Agrega un código de descuento a la póliza", page = "Línea Póliza")
	public static void incluirDescuento(String codigo) {
		Utils.stepStarted();
		TransversalEvents.ingresarPolizaMaestra();
		TransversalEvents.agregarDescuento(codigo);
	}

	@Context(step = "Emite una cotización del producto", page = "Objeto Póliza")
	public static void completarCotizacion(String estado) {
		Utils.stepStarted();
		TransversalEvents.completarPoliza(estado);
		// validar estado
		// validar numero de cotizacion
	}

	@Context(step = "Emite una póliza del producto", page = "Objeto Póliza")
	public static void completarPoliza(String estado) {
		Utils.stepStarted();
		TransversalEvents.completarPoliza(estado);
		Utils.takeAdditionalScreenshot(String.format("Se da por compleatado la póliza"), "extra");
	}

	@Context(step = "Cancelar la transacción actual.", page = "Objeto Póliza")
	public static void cancelarPoliza() {
		Utils.stepStarted();
		TransversalEvents.cancelarPoliza();
	}

	@Context(step = "Valida mensaje contrante menor edad", page = "Objeto Póliza")
	public static void validarMensajeContratanteMenorEdad(String estado) {
		Utils.stepStarted();
		TransversalEvents.calcularPrimaTotalAlternativo();
		TransversalEvents.completarPoliza(estado);
		TransversalEvents.quitarModalCompletarPoliza();
		TransversalEvents.loadingTIAGeneral();
		TransversalEvents.validarMensajeContratanteMenorEdad();
	}

	@Context(step = "Verifica el mensaje del fallecido", page = "Objeto Póliza")
	public static void validarMensajeContratanteFallecido(String estado) {
		Utils.stepStarted();
		TransversalEvents.calcularPrimaTotalAlternativo();
		TransversalEvents.completarPoliza(estado);
		TransversalEvents.quitarModalCompletarPoliza();
		TransversalEvents.validarMensajeContratanteFallecido();
	}

	@Context(step = "Verifica el mensaje del contratante erróneo", page = "Objeto Póliza")
	public static void validarMensajeContratanteErroneo() {
		Utils.stepStarted();
		TransversalEvents.validarMensajeContratanteErroneo();
	}

	@Context(step = "Verifica el mensaje del contratante inhabilitado", page = "Objeto Póliza")
	public static void validarMensajeContratanteInhabilitado() {
		Utils.stepStarted();
		TransversalEvents.validarMensajeContratanteInahabilitado();
	}

	@Context(step = "Acepta documentos de póliza", page = "Objeto Póliza")
	public static void aceptarDocumentosPoliza() {
		Utils.stepStarted();
		TransversalEvents.aceptarDocumentosPoliza();
		Utils.takeAdditionalScreenshot("Se acepta la creacion de la poliza", "extra");
	}

	@Context(step = "Genera un siniestro para una póliza vigente", page = "Crear Siniestro", functionality = "Siniestros")
	public static void generarSiniestroAlt() {
		Utils.stepStarted();
		TransversalEvents.generarSiniestroAlt();

	}

	@Context(step = "Genera un siniestro para una póliza vigente", page = "Crear Siniestro", functionality = "Siniestros")
	public static void ajustaPolizaTrans(String tipoEndoso) {
		Utils.stepStarted();
		TransversalEvents.ajustarPolizaTransversal(tipoEndoso);

	}

	@Context(step = "Inicia creación de un siniestro para una póliza vigente", page = "Crear Siniestro", functionality = "Siniestros")
	public static void crearSiniestro() {
		Utils.stepStarted();
		TransversalEvents.crearSiniestro();
	}

	@Context(step = "Genera un siniestro para una póliza vigente", page = "Crear Siniestro", functionality = "Siniestros")

	public static void generarSiniestro(String nombEvento) {
		Utils.stepStarted();
		TransversalEvents.generarSiniestro(nombEvento);

	}

	@Context(step = "Intenta generar un siniestro para una póliza vigente pero con errores", page = "Manejo Objeto", functionality = "Siniestros")
	public static void generarSiniestroAlternativo() {
		Utils.stepStarted();
		TransversalEvents.generarSiniestroAlternativo();
	}

	@Context(step = "Identificar al mismo contratante como asegurado", page = "Manejo Objeto", functionality = "Emision")
	public static void identificarMismoAsegurado() {
		TransversalEvents.verificarDatosContratante();
		TransversalEvents.verificarMismosDatosContratanteAsegurado();
	}

	@Context(step = "Identificar al asegurado diferente del contratante", page = "Manejo Objeto", functionality = "Emision")
	public static void identificarDiferenteAsegurado(String apellidoAsegurado, String nombreAsegurado) {
		Utils.stepStarted();
		TransversalEvents.verificarDatosContratante();
		OncologicoEvents.buscarAsegurado(apellidoAsegurado);
		OncologicoEvents.seleccionarAsegurado(nombreAsegurado);
		TransversalEvents.guardarCambios();
	}

	@Context(step = "Completa datos del informante del siniestro en TIA", page = "Crear Siniestro", functionality = "Siniestros")
	public static void completarDatosInformante(String informante, String nombInform, String tipoDenuncia) {
		Utils.stepStarted();
		TransversalEvents.seleccionarTipoInformante(informante);
		TransversalEvents.insertarNombInformante(nombInform);
		TransversalEvents.seleccionarTipoDenuncia(tipoDenuncia);
	}

	@Context(step = "Selecciona lugar de siniestro en TIA", page = "Crear Siniestro", functionality = "Siniestros")
	public static void seleccionarLugarSiniestro(String lugar) {
		Utils.stepStarted();
		TransversalEvents.seleccionarLugarSiniestro(lugar);
	}

	@Context(step = "Inserta Descripcion Hecho", page = "Crear Siniestro", functionality = "Siniestros")
	public static void insertarDescripcionHecho(String descripHecho) {
		Utils.stepStarted();
		TransversalEvents.insertarDescripHecho(descripHecho);
	}

	@Context(step = "Guarda datos de item de reserva", page = "Crear Siniestro", functionality = "Siniestros")
	public static void guardarReserva() {
		Utils.stepStarted();
		TransversalEvents.guardarReserva();
	}

	@Context(step = "Selecciona el liquidador que será designado para la atención del siniestro", page = "Crear Siniestro", functionality = "Siniestros")
	public static void seleccionarLiquidador(String idLiquidador) {
		Utils.stepStarted();
		TransversalEvents.seleccionarLiquidador(idLiquidador);
	}

	@Context(step = "Inserta fecha de siniestro", page = "Crear Siniestro", functionality = "Siniestros")
	public static void insertarFechaSiniestro(String fechaSiniestro) {
		Utils.stepStarted();
		TransversalEvents.insertarFechaSiniestro(fechaSiniestro);
	}

	@Context(step = "Inserta fecha de siniestro sin parámetro", page = "Crear Siniestro", functionality = "Siniestros")
	public static void insertarFechaSiniestroSinParametro() {
		Utils.stepStarted();
		TransversalEvents.ingresarFechaSiniestro();
	}

	@Context(step = "Inserta fecha de denuncia", page = "Crear Siniestro", functionality = "Siniestros")
	public static void insertarFechaDenuncia(String fechaDenuncia) {
		Utils.stepStarted();
		TransversalEvents.insertarFechaDenuncia(fechaDenuncia);
	}

	@Context(step = "Busca Poliza a siniestrar", page = "Crear Siniestro", functionality = "Siniestros")
	public static void buscarPolizaAlt() {
		Utils.stepStarted();
		TransversalEvents.buscarPolizaAlt();
	}

	@Context(step = "Busca Poliza a siniestrar", page = "Crear Siniestro", functionality = "Siniestros")
	public static void buscarPoliza(String idPoliza) {
		Utils.stepStarted();
		TransversalEvents.buscarPoliza(idPoliza);
	}

	@Context(step = "Crea un item de reserva", page = "Reserva", functionality = "Siniestros")
	public static void crearReserva(String tipoItem, String tipoSubItem, String idReceptor, String reserva) {
		Utils.stepStarted();
		TransversalEvents.crearReserva();
		TransversalEvents.crearNuevoItem();
		TransversalEvents.seleccionarTipoItem(tipoItem);
		TransversalEvents.seleccionarTipoSubItem(tipoSubItem);
		TransversalEvents.seleccionarReceptor(idReceptor);
		TransversalEvents.insertarMontoReserva(reserva);
	}

	@Context(step = "Valida que se cree automáticamente el ítem de Costo, sub ítem de Honorarios del liquidador con el ID del liquidador seleccionada previamente", page = "Reserva", functionality = "Siniestros")
	public static void validarReservaAutomatica(String idLiquidador, String nombLiquidador) {
		Utils.stepStarted();
		TransversalEvents.crearReserva();
		TransversalEvents.validarIdLiquidador(idLiquidador);
		TransversalEvents.validarNombreReceptor(nombLiquidador);
		TransversalEvents.validarRolReceptor("Proveedor de servicios");
	}

	@Context(step = "Valida mensaje de error de fecha de siniestro superior a fecha de denuncia ", page = "Crear Siniestro", functionality = "Siniestros")
	public static void validarMensajeErrorFechaSiniestroSuperiorFechaDenuncia() {
		Utils.stepStarted();
		TransversalEvents.validarMensajeErrorFechaSiniestroSuperiorFechaDenuncia();
	}

	@Context(step = "Valida mensaje de error de fecha de siniestro en blanco", page = "Crear Siniestro", functionality = "Siniestros")
	public static void validarMensajeErrorFechaSiniestroEnBlanco() {
		Utils.stepStarted();
		TransversalEvents.validarMensajeErrorFechaSiniestroEnBlanco();
	}

	@Context(step = "Seleccionar fecha de siniestro", page = "Crear Siniestro", functionality = "Siniestros")
	public static void seleccionarFechaSiniestro() {
		Utils.stepStarted();
		TransversalEvents.seleccionarFechaSiniestro();
	}

	@Context(step = "Seleccionar fecha de denuncia", page = "Crear Siniestro", functionality = "Siniestros")
	public static void seleccionarFechaDenuncia() {
		Utils.stepStarted();
		TransversalEvents.seleccionarFechaDenuncia();
	}

	@Context(step = "Ingresa al manejo de una póliza", page = "Manejo Poliza", functionality = "Endosos")
	public static void ingresarPolizaMA() {
		Utils.stepStarted();
		TransversalEvents.ingresarPolizaMA();
	}

	@Context(step = "Valida mensaje de error de fecha de siniestro superior a día actual", page = "Crear Siniestro", functionality = "Siniestros")
	public static void validarMensajeErrorFechaSiniestroSuperiorDiaActual() {
		Utils.stepStarted();
		TransversalEvents.validarMensajeErrorFechaSiniestroSuperiorDiaActual();
	}

	@Context(step = "Ingresa al manejo de una póliza", page = "Manejo Poliza", functionality = "Endosos")
	public static void ingresarPolizaBusquedaRapida() {
		Utils.stepStarted();
		TransversalEvents.ingresarPolizaBusquedaRapida();
	}

	@Context(step = "Valida mensaje de error de fecha de denuncia superior a día actual", page = "Crear Siniestro", functionality = "Siniestros")
	public static void validarMensajeErrorFechaDenunciaSuperiorDiaActual() {
		Utils.stepStarted();
		TransversalEvents.validarMensajeErrorFechaDenunciaSuperiorDiaActual();
	}

	@Context(step = "Ingresa al manejo de una póliza", page = "Manejo Poliza", functionality = "Endosos")
	public static void ingresarSiniestroCreateClaimAlt() {
		Utils.stepStarted();
		TransversalEvents.crearSiniestroCreateClaimAlt();
	}

	@Context(step = "Selecciona un gestor diferente al usuario autenticado", page = "Crear Siniestro", functionality = "Siniestros")
	public static void seleccionarGestor(String gestor) {
		Utils.stepStarted();
		TransversalEvents.seleccionarGestor(gestor);
	}

	@Context(step = "Ingresa a la póliza", page = "Manejo Poliza", functionality = "Endosos")
	public static void ingresarPoliza() {
		Utils.stepStarted();
		TransversalEvents.ingresarPoliza();

	}

	@Context(step = "Ingresa al manejo de una póliza", page = "Manejo Poliza", functionality = "Endosos")
	public static void ingresarTipoEndoso(String tipoEndoso) {
		Utils.stepStarted();
		TransversalEvents.seleccionarTipoEndoso(tipoEndoso);
	}

	@Context(step = "Ingresa al manejo de una póliza", page = "Manejo Poliza", functionality = "Endosos")
	public static void seleccionarTipoEndosoConDiasPosterior(String tipoEndoso) {
		Utils.stepStarted();
		TransversalEvents.seleccionarTipoEndosoConDiasPosterior(tipoEndoso);
	}

	@Context(step = "Ingresa Siniestro CreateClaim", page = "Manejo Poliza", functionality = "Endosos")
	public static void ingresarSiniestroCreateClaim() {
		Utils.stepStarted();
		TransversalEvents.crearSiniestroCreateClaim();
	}

	@Context(step = "Ingresa a la póliza a Renovar", page = "Manejo Poliza", functionality = "Endosos")
	public static void ingresarPolizaRenovar() {
		Utils.stepStarted();
		TransversalEvents.renovarPoliza();
	}

	@Context(step = "Ingresa al manejo de un objeto", page = "Manejo Objeto", functionality = "Endosos")
	public static void ingresarObjeto(String nombre) {
		Utils.stepStarted();
		TransversalEvents.ingresarObjeto(nombre);
	}

	@Context(step = "Ingresa al manejo de un objeto", page = "Manejo Objeto", functionality = "Endosos")
	public static void ingresarObjeto() {
		Utils.stepStarted();
		TransversalEvents.ingresarObjeto();
	}

	@Context(step = "Ajusta un objeto", page = "Manejo Objeto", functionality = "Endosos")
	public static void ajustarObjeto(String fechaAjuste) {
		Utils.stepStarted();
		TransversalEvents.ajustarObjeto(fechaAjuste);
	}

	@Context(step = "Ajusta un objeto", page = "Manejo Objeto", functionality = "Endosos")
	public static void ajustarObjeto() {
		Utils.stepStarted();
		TransversalEvents.ajustarObjeto();
	}

	@Context(step = "Selecciona una entidad", page = "Manejo Entidad", functionality = "Endosos")
	public static void buscarEntidadAlternativo(String idEntidad) {
		Utils.stepStarted();
		TransversalEvents.buscarEntidadAlternativo(idEntidad);
		TransversalEvents.seleccionarEntidad(idEntidad);
	}

	@Context(step = "Valida que se haya cancelado la póliza correctamente", page = "Manejo Póliza", functionality = "Cancelación")
	public static void validaTransaccionCancelacionPolizaMR() {
		Utils.stepStarted();
		TransversalEvents.validarTransaccionCancelacionPolizaMR();
	}

	@Context(step = "Cierra Página de Búsqueda ", page = "Manejo Entidad", functionality = "Endosos")
	public static void cerrarPaginaBusqueda() {
		Utils.stepStarted();
		TransversalEvents.cerrarPaginaBusqueda();
	}

	@Context(step = "Visita Página Principal", page = "Manejo Entidad", functionality = "Endosos")
	public static void visitarPaginaHome() {
		Utils.stepStarted();
		TransversalEvents.visitarPaginaHome();
	}

	@Context(step = "Inicia ajuste de póliza definiendo fecha de ajuste", page = "Manejo Póliza", functionality = "Cancelación")
	public static void ajustarPoliza(String fechaAjuste) {
		Utils.stepStarted();
		TransversalEvents.ajustarPoliza(fechaAjuste);
	}

	@Context(step = "Inicia ajuste de póliza con fecha de ajuste por defecto del sistema", page = "Manejo Póliza", functionality = "Cancelación")
	public static void ajustarPoliza() {
		Utils.stepStarted();
		TransversalEvents.ajustarPoliza();
	}

	@Context(step = "Selecciona motivo de cancelacion de la póliza", page = "Manejo Póliza", functionality = "Cancelación")
	public static void seleccionarMotivoCancelacionPoliza(String motivoCancelacion) {
		Utils.stepStarted();
		TransversalEvents.seleccionarMotivoCancelacionPoliza(motivoCancelacion);
	}

	@Context(step = "Valida que se haya cancelado la póliza correctamente", page = "Manejo Póliza", functionality = "Cancelación")
	public static void validaTransaccionCancelacionPoliza() {
		Utils.stepStarted();
		TransversalEvents.validarTransaccionCancelacionPoliza();
	}

	@Context(step = "Valida que se haya realizado correctamente el endoso", page = "Manejo Póliza", functionality = "Cancelación")
	public static void validarEndoso() {
		Utils.stepStarted();
		TransversalEvents.ingresarPolizaBusquedaRapida();
		TransversalEvents.ingresarLineaPoliza();
		TransversalEvents.validarEndoso();
	}

	@Context(step = "Renovar una póliza manualmente", page = "Manejo Poliza", functionality = "Renovacion")
	public static void tab() {
		Utils.stepStarted();
		TransversalEvents.tab();
	}

	@Context(step = "Ingresa al manejo de una póliza, pasando el id de la póliza", page = "Manejo Poliza", functionality = "Renovacion")
	public static void ingresarPoliza(String idPoliza) {
		Utils.stepStarted();
		TransversalEvents.ingresarPoliza(idPoliza);
	}

	@Context(step = "Valida que se haya realizado la renovación automática de una póliza", page = "Manejo Poliza", functionality = "Renovacion")
	public static void validarRenovacion() {
		Utils.stepStarted();
		// TransversalEvents.validarRenovacion();
	}

	@Context(step = "Liquida item de reserva ", page = "reserva", functionality = "Siniestro")
	public static void liquidarReserva(String monto) {
		Utils.stepStarted();
		TransversalEvents.liquidarReserva(monto);
	}

	@Context(step = "Recalcula la prima total del seguro ante un endoso complejo", page = "Objeto Póliza")
	public static void calcularPrimaTotalEndosoComplejo() {
		Utils.stepStarted();
		TransversalEvents.calcularPrimaTotalEndosoComplejo();
		TransversalEvents.guardarCambios();
	}

	@Context(step = "Verifica que se muestre mensaje de error por motivo de cancelación", page = "Objeto Póliza")
	public static void validarMensajeErrorCancelacion(String estado) {
		Utils.stepStarted();
		// TransversalEvents.validarMensajeErrorCancelacion(estado);
	}

//	@Context(step = "Renovar una póliza manualmente", page = "Manejo Poliza", functionality = "Renovacion")
//	public static void renovarPoliza() {
//		Utils.stepStarted();
//		TransversalEvents.renovarPoliza();
//	}

	@Context(step = "Renovar una póliza manualmente", page = "Manejo Poliza", functionality = "Renovacion")
	public static void renovarPoliza() {
		Utils.stepStarted();
		TransversalEvents.renovarPoliza();
	}

	@Context(step = "Ingresa fecha del siniestro", page = "Manejo Objeto", functionality = "Siniestro")
	public static void seleccionFechaSiniestro() {

		Utils.stepStarted();
		TransversalEvents.seleccionarFechaDiaHoy();
	}

	@Context(step = "Seleccionar fecha de denuncia", page = "Crear Siniestro", functionality = "Siniestros")
	public static void seleccionarFechaDenunciaSuperior() {
		Utils.stepStarted();
		TransversalEvents.seleccionarFechaDenunciaDiaSiguiente();
	}

	@Context(step = "Seleccionar fecha de denuncia", page = "Crear Siniestro", functionality = "Siniestros")
	public static void seleccionarFechaDenunciaSuperior2() {
		Utils.stepStarted();
		TransversalEvents.seleccionarFechaDenunciaDiaSiguiente2();
	}

	@Context(step = "Seleccionar fecha de denuncia", page = "Crear Siniestro", functionality = "Siniestros")
	public static void seleccionarFechaDenunciaInferior() {
		Utils.stepStarted();
		TransversalEvents.seleccionarFechaDenunciaDiaAnterior();
	}

	@Context(step = "Ajustar valor base de la reserva", page = "Manejo Objeto")
	public static void ajustarValorReserva(String nuevoValorReserva) {
		Utils.stepStarted();
		TransversalEvents.seleccionarSiniestroLista(nuevoValorReserva);
	}

	@Context(step = "Comprobar el estado esperado de la póliza", page = "Manejo Objeto")
	public static void validarEstadoPoliza(String estadoPoliza) {
		Utils.stepStarted();
		TransversalEvents.validarEstadoPoliza(estadoPoliza);
	}

	@Context(step = "Redirrecionar al resumen de la entidad", page = "Resumen Entidad", functionality = "Transversal")
	public static void ingresarResumenEntidad() {
		Utils.stepStarted();
		TransversalEvents.ingresarResumenEntidad();

	}

	@Context(step = "Validar que se seleccione la causa", page = "Manejo Objeto")
	public static void validarIngresoEventoCausa(String opcEvento, String opcCausa) {
		Utils.stepStarted();
		TransversalEvents.seleccionarEvento(opcEvento);
		TransversalEvents.seleccionarCausa(opcCausa);
		TransversalEvents.seleccionarNumeroCobertura();
		TransversalEvents.validarLlenadoSubCoberturaAutomatico();

	}
	
	@Context(step = "Crea una nueva póliza por corredora del producto seleccionado para la entidad buscada", page = "Resumen Entidad")
	public static void crearPolizaIntermediador(String producto, String canalVenta, String plataforma, String numAgente) {
		Utils.stepStarted();
		TransversalEvents.crearNuevaPoliza(producto);
		TransversalEvents.seleccionarCanalVenta(canalVenta);
		TransversalEvents.seleccionarPlataforma(plataforma);
		TransversalEvents.seleccionarAgente(numAgente);
		TransversalEvents.guardarCambios();
		TransversalEvents.crearNuevaLineaPoliza();
	}

	@Context(step = "Busqueda Rapida por rut/numero poliza/id/etc", page = "Resumen Entidad")
	public static void busquedaRapidaElemento(String elementoBuscar) {
		Utils.stepStarted();
		TransversalEvents.ingresarBusquedaRapida(elementoBuscar);
	}
}
