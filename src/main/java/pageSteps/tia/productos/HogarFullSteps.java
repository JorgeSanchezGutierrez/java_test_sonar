package main.java.pageSteps.tia.productos;

import main.java.config.Context;
import main.java.config.Utils;
import main.java.pageEvents.tia.productos.HogarFullEvents;
import main.java.pageEvents.tia.transversal.TransversalEvents;

public class HogarFullSteps {

	@Context(step = "Seleccionar tipo de contratante", page = "Manejo Objeto")
	public static void seleccionarTipoContratante(String tipoContratante) {

		Utils.stepStarted();
		TransversalEvents.loadingTIAGeneral();
		HogarFullEvents.seleccionarTipoContratante(tipoContratante);
		TransversalEvents.loadingTIAGeneral();
	}

	@Context(step = "Identificar propiedad a asegurar", page = "Manejo Objeto")
	public static void identificarPropiedad(String IDPropiedad) {

		Utils.stepStarted();
		HogarFullEvents.ingresarIDPropiedad(IDPropiedad);
		HogarFullEvents.obtenerDetallesPropiedad();
		HogarFullEvents.verificarCargaDatosPropiedad();
	}

	@Context(step = "Completar información de propiedad casa en condominio", page = "Manejo Objeto")
	public static void seleccionarPropiedadCasaCondominio(String NCasa) {

		Utils.stepStarted();
		HogarFullEvents.seleccionarTipoPropiedad("Casa");
		HogarFullEvents.seleccionarCasaCondominio(NCasa);
	}

	@Context(step = "Completar información de propiedad casa en avenida", page = "Manejo Objeto")
	public static void seleccionarCasaAvenida() {

		Utils.stepStarted();
		HogarFullEvents.seleccionarTipoPropiedad("Casa");
	}

	@Context(step = "Completar información de propiedad departamento", page = "Manejo Objeto")
	public static void seleccionarPropiedadDepartamento(String numeroDepto, String numeroPiso) {

		Utils.stepStarted();
		HogarFullEvents.seleccionarTipoPropiedad("Departamento");
		HogarFullEvents.ingresarNumeroDepto(numeroDepto);
		HogarFullEvents.ingresarNumeroPisoDepto(numeroPiso);
	}

	@Context(step = "Completar información de propiedad departamento alternativo", page = "Manejo Objeto")
	public static void seleccionarPropiedadDepartamentoAlternativo() {
		Utils.stepStarted();
		HogarFullEvents.seleccionarTipoPropiedad("Departamento");
	}

	@Context(step = "Completar información construcción de propiedad", page = "Manejo Objeto")
	public static void completarInformacionPropiedad(String m2, String rangoAnios, String uso, String material) {

		Utils.stepStarted();
		HogarFullEvents.ingresarM2Propiedad(m2);
		HogarFullEvents.seleccionarAntiguedadPropiedad(rangoAnios);
		HogarFullEvents.seleccionarTipoUsoPropiedad(uso);
		HogarFullEvents.seleccionarMaterialConstruccion(material);
		Utils.takeAdditionalScreenshot("Se rellena la informacion relevante" , "extra");

	}

	@Context(step = "Selecciona la cobertura Incendio Edificio e Incendio Contenido", page = "Manejo Objeto")
	public static void seleccionarCoberturaIncendio(String montoAseguradoIE, String montoAseguradoIC) {

		Utils.stepStarted();
		HogarFullEvents.ingresarMontoAseguradoIncendioEdificio(montoAseguradoIE);
		HogarFullEvents.ingresarMontoAseguradoIncendioContenido(montoAseguradoIC);
		Utils.takeAdditionalScreenshot(String.format("montocoberturaIncendioEdificio%s,paraIncendiocontenido%s", montoAseguradoIE,montoAseguradoIC) , "extra");
	}

	@Context(step = "Agrega la cobertura Robo Contenido", page = "Manejo Objeto")
	public static void agregarCoberturaRoboContenido(String montoAsegurado) {

		Utils.stepStarted();
		HogarFullEvents.habilitarCoberturaRoboContenido();
		HogarFullEvents.ingresarMontoAseguradoRoboContenido(montoAsegurado);
	}

	@Context(step = "Agrega la cobertura Sismo", page = "Manejo Objeto")
	public static void agregarCoberturaSismo() {

		Utils.stepStarted();
		HogarFullEvents.habilitarCoberturaSismo();
	}

	@Context(step = "Agrega la cobertura Reembolso Gastos Medicos", page = "Manejo Objeto")
	public static void agregarCoberturaReembolsoGastosMedicos() {

		Utils.stepStarted();
		HogarFullEvents.habilitarCoberturaReembolsoGastosMedicos();
	}

	@Context(step = "Agrega la asistencia Cyber", page = "Manejo Objeto")
	public static void agregarAsistenciaCyber() {

		Utils.stepStarted();
		HogarFullEvents.habilitarAsistenciaCyber();
	}

	@Context(step = "Agrega la asistencia Mascotas", page = "Manejo Objeto")
	public static void agregarAsistenciaMascotas() {

		Utils.stepStarted();
		HogarFullEvents.habilitarCoberturaResponsabilidadCivilMascotas();
		HogarFullEvents.habilitarAsistenciaMascotas();
	}

	@Context(step = "Agrega la asistencia Telemedicina", page = "Manejo Objeto")
	public static void agregarAsistenciaTelemedicina() {

		Utils.stepStarted();
		HogarFullEvents.habilitarCoberturaMuerteAccidental();
		HogarFullEvents.habilitarAsistenciaTelemedicina();
	}

	@Context(step = "Selecciona producto Hogar Full para siniestrar", page = "Manejo Objeto", functionality = "Emisión")
	public static void seleccionarProducto() {
		Utils.stepStarted();
		HogarFullEvents.seleccionarProductoSiniestrar();
	}

	@Context(step = "Completa datos del evento", page = "Manejo Objeto", functionality = "Siniestros")
	public static void completarEvento(String evento, String causa, String cobertura) {
		Utils.stepStarted();
		HogarFullEvents.seleccionarEvento(evento);
		HogarFullEvents.seleccionarCausa(causa);
		HogarFullEvents.seleccionarCobertura(cobertura);
		Utils.takeAdditionalScreenshot("Ingreso de datos del evento", "extra");
	}

	@Context(step = "Responde preguntas obligatorias definidas", page = "Manejo Objeto", functionality = "Siniestros")
	public static void responderPreguntas(String respuesta1, String respuesta2, String respuesta3, String respuesta4) {
		Utils.stepStarted();
		HogarFullEvents.responderPreguntas(respuesta1, respuesta2, respuesta3, respuesta4);

	}

	@Context(step = "Ampliar ventana de configuración de coberturas del riesgo", page = "Manejo Objeto")
	public static void ampliarVentana() {
		Utils.stepStarted();
		HogarFullEvents.ampliarVentanaRiesgos();
	}

	@Context(step = "Unir ventana de configuración de coberturas del riesgo", page = "Manejo Objeto")
	public static void unirVentana() {
		Utils.stepStarted();
		HogarFullEvents.unirVentana();
	}

	@Context(step = "Desmarcar cumplimiento de medidas de Seguridad", page = "Manejo Objeto")
	public static void desmarcarCumplimientoMedidasSeguridad() {
		Utils.stepStarted();
		HogarFullEvents.desmarcarCumplimientoMedidasSeguridad();
	}

	@Context(step = "Pagar una cuota de la póliza seleccionada", page = "Administración")
	public static void pagarCuota() {
		Utils.stepStarted();
		HogarFullEvents.visitarPaginaHomeHF();
		HogarFullEvents.cargarPaginaAdmin();
		HogarFullEvents.cargarPaginaBuscarItemCuenta();
		HogarFullEvents.buscarItem();
		HogarFullEvents.seleccionarItemPagar();
		HogarFullEvents.validarEstadoItemSeleccionado();
		HogarFullEvents.crearPago();
		HogarFullEvents.validarEstadoEnviadoSistemaPago();
	}

	@Context(step = "Valida que ocurra la reversión del pago de una cuota que ha sido cancelada", page = "Administración")
	public static void validarReversionPagoCuota() {
		Utils.stepStarted();
		HogarFullEvents.cargarPaginaAdmin();
		HogarFullEvents.buscarItem2();
		HogarFullEvents.validarMontoRevertido();
	}

	@Context(step = "Crea una nueva póliza del producto seleccionado para la entidad buscada", page = "Resumen Entidad")
	public static void crearPolizaHF(String producto, String canalVenta) {
		Utils.stepStarted();
		HogarFullEvents.crearNuevaPolizaHF(producto);
		HogarFullEvents.seleccionarCanalVentaHF(canalVenta);
		HogarFullEvents.guardarCambiosHF();
		HogarFullEvents.crearNuevaLineaPolizaHF();
	}

	@Context(step = "Calcula la prima total del seguro", page = "Objeto Póliza")
	public static void calcularPrimaTotalHF() {
		Utils.stepStarted();
		HogarFullEvents.calcularPrimaTotalHF();
		HogarFullEvents.guardarCambiosHF();
		Utils.takeAdditionalScreenshot("Se guarda el cambio con la prima total asignada" , "extra");
	}

	@Context(step = "Ingresa al manejo de una póliza", page = "Manejo Poliza", functionality = "Endosos")
	public static void ingresarPolizaHF() {
		Utils.stepStarted();
		HogarFullEvents.ingresarPolizaHF();
	}

	@Context(step = "Ingresa al manejo de una  y selecciona el tipo de endoso", page = "Manejo Poliza", functionality = "Endosos")
	public static void seleccionarTipoEndosoHF(String tipoEndoso) {
		Utils.stepStarted();
		HogarFullEvents.seleccionarTipoEndosoHF(tipoEndoso);
	}

	@Context(step = "Inicia ajuste de póliza con fecha de ajuste por defecto del sistema", page = "Manejo Póliza", functionality = "Cancelación")
	public static void ajustarPolizaHF(String tipoEndoso) {
		Utils.stepStarted();
		HogarFullEvents.ajustarPolizaHF(tipoEndoso);
	}

	@Context(step = "Selecciona motivo de cancelacion de la póliza", page = "Manejo Póliza", functionality = "Cancelación")
	public static void seleccionarMotivoCancelacionPolizaHF(String motivoCancelacion) {
		Utils.stepStarted();
		HogarFullEvents.seleccionarMotivoCancelacionPolizaHF(motivoCancelacion);
	}

	@Context(step = "Valida que se haya cancelado la póliza correctamente", page = "Manejo Póliza", functionality = "Cancelación")
	public static void validaTransaccionCancelacionPolizaHF() {
		Utils.stepStarted();
		HogarFullEvents.validarTransaccionCancelacionPolizaHF();
	}

	@Context(step = "Busca una entidad por su apellido o razón social", page = "Página Principal")
	public static void buscarEntidadHF(String apellido, String nombre) {
		Utils.stepStarted();
		HogarFullEvents.buscarEntidadHF(apellido);
		HogarFullEvents.seleccionarContratanteHF(nombre);
	}

	@Context(step = "Selecciona la entidad activa por su nombre y apellido", page = "Manejo de entidad")
	public static void seleccionarContratanteActivoHF(String apellido, String nombre) {
		Utils.stepStarted();
		HogarFullEvents.seleccionarContratanteActivoHF(nombre, apellido);
	}

	@Context(step = "Ingresa como usuario suscriptor", page = "TIA")
	public static void ingresarComoSuscriptorHF(String user, String pass) {
		Utils.stepStarted();
		HogarFullEvents.validarAmbienteTIAHF();
		HogarFullEvents.iniciarSesionHF(user, pass);
	}

	@Context(step = "Visita Página Principal", page = "Manejo Entidad", functionality = "Endosos")
	public static void visitarPaginaHomeHF() {
		Utils.stepStarted();
		HogarFullEvents.visitarPaginaHomeHF();
	}

	@Context(step = "Verifica que se muestre mensaje de error por motivo de cancelación", page = "Objeto Póliza")
	public static void validarMensajeErrorCancelacionHF(String estado) {
		Utils.stepStarted();
		HogarFullEvents.validarMensajeErrorCancelacionHF(estado);
	}

	@Context(step = "Crea una póliza para validar la renovación", page = "Resumen Entidad")
	public static void crearPolizaRenovarHF(String producto, String canalVenta) {
		Utils.stepStarted();
		HogarFullEvents.crearNuevaPolizaHF(producto);
		HogarFullEvents.seleccionarCanalVentaHF(canalVenta);
		HogarFullEvents.seleccionarFechaInicioPolizaHF();
		HogarFullEvents.guardarCambiosHF();
		HogarFullEvents.crearNuevaLineaPolizaHF();
	}

	@Context(step = "Renovar una póliza manualmente", page = "Manejo Poliza", functionality = "Renovacion")
	public static void renovarPolizaHF() {
		Utils.stepStarted();
		HogarFullEvents.renovarPolizaHF();
	}

	@Context(step = "Valida que se haya realizado la renovación automática de una póliza", page = "Manejo Poliza", functionality = "Renovacion")
	public static void validarRenovacionHF() {
		Utils.stepStarted();
		HogarFullEvents.validarRenovacionHF();
	}

	@Context(step = "Valida que la prima no se haya modificado cuando ocurrió la renovación", page = "Manejo Objeto", functionality = "Renovacion")
	public static void validarPrimaSinModificacionHF() {
		Utils.stepStarted();
		HogarFullEvents.validarPrimaSinModificacionHF();
	}

	@Context(step = "Valida que la prima no se haya modificado cuando ocurrió la renovación", page = "Manejo Objeto", functionality = "Renovacion")
	public static void validarPrimaConModificacionHF() {
		Utils.stepStarted();
		HogarFullEvents.validarPrimaConModificacionHF();
	}

	@Context(step = "Ingresa al manejo de un objeto", page = "Manejo Objeto", functionality = "Endosos")
	public static void ingresarObjetoHF() {
		Utils.stepStarted();
		HogarFullEvents.ingresarObjetoHF();
	}

	@Context(step = "Ajusta un objeto", page = "Manejo Objeto", functionality = "Endosos")
	public static void ajustarObjetoHF() {
		Utils.stepStarted();
		HogarFullEvents.ajustarObjetoHF();
	}

	@Context(step = "Recalcula la prima total del seguro ante un endoso complejo", page = "Objeto Póliza")
	public static void calcularPrimaTotalEndosoComplejoHF() {
		Utils.stepStarted();
		HogarFullEvents.calcularPrimaTotalEndosoComplejoHF();
		HogarFullEvents.guardarCambiosHF();
	}

	@Context(step = "Valida que se haya realizado correctamente el endoso", page = "Manejo Póliza", functionality = "Cancelación")
	public static void validarEndosoHF() {
		Utils.stepStarted();
		HogarFullEvents.ingresarLineaPolizaHF();
		HogarFullEvents.validarEndosoHF();
	}

	@Context(step = "Inicia creación de un siniestro para una póliza vigente", page = "Crear Siniestro", functionality = "Siniestros")
	public static void crearSiniestroHF() {
		Utils.stepStarted();
		HogarFullEvents.crearSiniestroHF();
	}

	@Context(step = "Inicia creación de un siniestro para una póliza vigente", page = "Crear Siniestro", functionality = "Siniestros")
	public static void crearSiniestroAlternativoHF() {
		Utils.stepStarted();
		HogarFullEvents.crearSiniestroAlternativoHF();
	}

	@Context(step = "Inserta fecha de siniestro", page = "Crear Siniestro", functionality = "Siniestros")
	public static void insertarFechaSiniestroHF(String fechaSiniestro) {
		Utils.stepStarted();
		HogarFullEvents.insertarFechaSiniestroHF(fechaSiniestro);
	}

	@Context(step = "Inserta fecha de denuncia", page = "Crear Siniestro", functionality = "Siniestros")
	public static void insertarFechaDenunciaHF(String fechaDenuncia) {
		Utils.stepStarted();
		HogarFullEvents.insertarFechaDenunciaHF(fechaDenuncia);
	}

	@Context(step = "Busca Poliza a siniestrar", page = "Crear Siniestro", functionality = "Siniestros")
	public static void buscarPolizaHF(String idPoliza) {
		Utils.stepStarted();
		HogarFullEvents.buscarPolizaHF(idPoliza);
	}

	@Context(step = "Inserta Descripcion Hecho", page = "Crear Siniestro", functionality = "Siniestros")
	public static void insertarDescripcionHechoHF(String descripHecho) {
		Utils.stepStarted();
		HogarFullEvents.insertarDescripHechoHF(descripHecho);
		
		
	}

	@Context(step = "Completa datos del informante del siniestro en TIA", page = "Crear Siniestro", functionality = "Siniestros")
	public static void completarDatosInformanteHF(String informante, String nombInform, String tipoDenuncia) {
		Utils.stepStarted();
		HogarFullEvents.seleccionarTipoInformanteHF(informante);
		HogarFullEvents.insertarNombInformanteHF(nombInform);
		HogarFullEvents.seleccionarTipoDenunciaHF(tipoDenuncia);
	}

	@Context(step = "Selecciona lugar de siniestro en TIA", page = "Crear Siniestro", functionality = "Siniestros")
	public static void seleccionarLugarSiniestroHF(String lugar) {
		Utils.stepStarted();
		HogarFullEvents.seleccionarLugarSiniestroHF(lugar);
	}

	@Context(step = "Genera un siniestro para una póliza vigente", page = "Crear Siniestro", functionality = "Siniestros")

	public static void generarSiniestroHF(String nombEvento) {
		Utils.stepStarted();
		HogarFullEvents.generarSiniestroHF(nombEvento);

	}

	@Context(step = "Selecciona un gestor diferente al usuario autenticado", page = "Crear Siniestro", functionality = "Siniestros")
	public static void seleccionarGestorHF(String gestor) {
		Utils.stepStarted();
		HogarFullEvents.seleccionarGestorHF(gestor);
	}

	@Context(step = "Intenta generar un siniestro para una póliza vigente pero con errores", page = "Manejo Objeto", functionality = "Siniestros")
	public static void generarSiniestroAlternativoHF() {
		Utils.stepStarted();
		HogarFullEvents.generarSiniestroAlternativoHF();
	}

	@Context(step = "Valida mensaje de error de fecha de siniestro superior a fecha de denuncia ", page = "Crear Siniestro", functionality = "Siniestros")
	public static void validarMensajeErrorFechaSiniestroSuperiorFechaDenunciaHF() {
		Utils.stepStarted();
		HogarFullEvents.validarMensajeErrorFechaSiniestroSuperiorFechaDenunciaHF();
	}

	@Context(step = "Valida mensaje de error de fecha de siniestro en blanco", page = "Crear Siniestro", functionality = "Siniestros")
	public static void validarMensajeErrorFechaSiniestroEnBlancoHF() {
		Utils.stepStarted();
		HogarFullEvents.validarMensajeErrorFechaSiniestroEnBlancoHF();
	}

	@Context(step = "Seleccionar fecha de siniestro", page = "Crear Siniestro", functionality = "Siniestros")
	public static void seleccionarFechaSiniestroHF() {
		Utils.stepStarted();
		HogarFullEvents.seleccionarFechaSiniestroHF();
	}

	@Context(step = "Seleccionar fecha de siniestro un día anterior a la actual", page = "Crear Siniestro", functionality = "Siniestros")
	public static void seleccionarFechasHF() {
		Utils.stepStarted();
		HogarFullEvents.seleccionarFechasHF();
	}

	@Context(step = "Seleccionar fecha de denuncia", page = "Crear Siniestro", functionality = "Siniestros")
	public static void seleccionarFechaDenunciaHF() {
		Utils.stepStarted();
		HogarFullEvents.seleccionarFechaDenunciaHF();
	}

	@Context(step = "Valida mensaje de error de fecha de siniestro superior a día actual", page = "Crear Siniestro", functionality = "Siniestros")
	public static void validarMensajeErrorFechaSiniestroSuperiorDiaActualHF() {
		Utils.stepStarted();
		HogarFullEvents.validarMensajeErrorFechaSiniestroSuperiorDiaActualHF();
	}

	@Context(step = "Valida mensaje de error de fecha de denuncia superior a día actual", page = "Crear Siniestro", functionality = "Siniestros")
	public static void validarMensajeErrorFechaDenunciaSuperiorDiaActualHF() {
		Utils.stepStarted();
		HogarFullEvents.validarMensajeErrorFechaDenunciaSuperiorDiaActualHF();
	}

	@Context(step = "Crea un item de reserva", page = "Reserva", functionality = "Siniestros")
	public static void crearReservaHF(String tipoItem, String tipoSubItem, String idReceptor, String reserva) {
		Utils.stepStarted();
		HogarFullEvents.crearReservaHF();
		HogarFullEvents.crearNuevoItemHF();
		HogarFullEvents.seleccionarTipoItemHF(tipoItem);
		HogarFullEvents.seleccionarTipoSubItemHF(tipoSubItem);
		HogarFullEvents.seleccionarReceptorHF(idReceptor);
		HogarFullEvents.insertarMontoReservaHF(reserva);
	}

	@Context(step = "Modifica un el monto de reserva", page = "Reserva", functionality = "Siniestros")
	public static void modificarMontoReservaHF(String reserva) {
		Utils.stepStarted();
		HogarFullEvents.modificarMontoReservaHF(reserva);
	}

	@Context(step = "Guarda datos de item de reserva", page = "Crear Siniestro", functionality = "Siniestros")
	public static void guardarReservaHF() {
		Utils.stepStarted();
		HogarFullEvents.guardarReservaHF();
	}

	@Context(step = "Selecciona el liquidador que será designado para la atención del siniestro", page = "Crear Siniestro", functionality = "Siniestros")
	public static void seleccionarLiquidadorHF(String idLiquidador) {
		Utils.stepStarted();
		HogarFullEvents.seleccionarLiquidadorHF(idLiquidador);
	}

	@Context(step = "Valida que se cree automáticamente el ítem de Costo, sub ítem de Honorarios del liquidador con el ID del liquidador seleccionada previamente", page = "Reserva", functionality = "Siniestros")
	public static void validarReservaAutomaticaHF(String idLiquidador, String nombLiquidador, String nombreLiquidador) {
		Utils.stepStarted();
		HogarFullEvents.crearReservaHF();
		HogarFullEvents.clicLiquidadorHF(nombreLiquidador);
		HogarFullEvents.validarIdLiquidadorHF(idLiquidador);
		HogarFullEvents.validarNombreReceptorHF(nombLiquidador);
		HogarFullEvents.validarRolReceptorHF("Proveedor de servicios");
	}

	@Context(step = "Liquida item de reserva ", page = "reserva", functionality = "Siniestro")
	public static void liquidarReservaHF(String monto, String numFactura) {
		Utils.stepStarted();
		HogarFullEvents.liquidarReservaHF(monto, numFactura);
	}

	@Context(step = "Crea una nueva póliza para siniestrar, del producto seleccionado para la entidad buscada", page = "Resumen Entidad")
	public static void crearPolizaSiniestroHF(String producto, String canalVenta) {
		Utils.stepStarted();
		TransversalEvents.crearNuevaPoliza(producto);
		HogarFullEvents.seleccionarFechaPolizaDosDiasAntes();
		TransversalEvents.seleccionarCanalVenta(canalVenta);
		TransversalEvents.guardarCambios();
		TransversalEvents.crearNuevaLineaPoliza();
	}
}
