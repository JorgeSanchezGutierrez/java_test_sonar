package main.java.pageSteps.tia.productos;

import main.java.config.Context;
import main.java.config.Utils;
import main.java.pageEvents.tia.productos.MuerteAccidentalEvents;
import main.java.pageEvents.tia.transversal.TransversalEvents;

public class MuerteAccidentalSteps {
	
	@Context(step = "Completar datos de emision", page = "Manejo Objeto", functionality = "Emision")
	public static void datosPlanes2() {
	
		Utils.stepStarted();
		MuerteAccidentalEvents.seleccionarTipodeCobertura2();
	}
	
	@Context(step = "Completar datos de emision", page = "Manejo Objeto", functionality = "Emision")
	public static void renovacion() {
	
		Utils.stepStarted();
		MuerteAccidentalEvents.buttonRenovar();
	}
	
	@Context(step = "Completar datos de emision", page = "Manejo Objeto", functionality = "Emision")
	public static void crearNuevapoliza() {
	
		Utils.stepStarted();
		MuerteAccidentalEvents.crearNuevaLineaPolizaAP();
	}
	@Context(step = "Crea una nueva póliza del producto seleccionado para la entidad buscada", page = "Resumen Entidad")
	public static void crearPolizaAP (String producto, String canalVenta){
		Utils.stepStarted();
		TransversalEvents.crearNuevaPoliza(producto);
		TransversalEvents.seleccionarCanalVenta(canalVenta);
		TransversalEvents.guardarCambios();
		TransversalEvents.seleccionarFechaPolizaDosDiasAntes();
		MuerteAccidentalEvents.crearNuevaLineaPolizaAP();
	}
	
	@Context(step = "Crea una nueva póliza del producto seleccionado para la entidad buscada", page = "Resumen Entidad")
	public static void crearPolizaAP2 (String producto, String Finicio, String canalVenta) throws InterruptedException{
		Utils.stepStarted();
		TransversalEvents.crearNuevaPoliza(producto);
		TransversalEvents.seleccionarFechaPoliza(Finicio);
		TransversalEvents.guardarCambios();
		Thread.sleep(4000);
		TransversalEvents.seleccionarCanalVenta(canalVenta);
		MuerteAccidentalEvents.crearNuevaLineaPolizaAP();
	}
	
	@Context(step = "Crea una nueva póliza del producto seleccionado para la entidad buscada", page = "Resumen Entidad")
	public static void seleccionarFechaInicio (String Finicio){
		Utils.stepStarted();
		TransversalEvents.seleccionarFechaPoliza(Finicio);
	}
	
	
	@Context(step = "Ingreso a la seccion de manejo de póliza ", page = "Manejo Póliza", functionality = "Cancelación")
	public static void manejoPoliza(){
		Utils.stepStarted();
		MuerteAccidentalEvents.ingresarManejoPoliza();
		
	}
	
	@Context(step = "Ingreso al model de ajuste de objeto ", page = "Manejo Póliza", functionality = "Cancelación")
	public static void ajustarPoliza(){
		Utils.stepStarted();
		MuerteAccidentalEvents.ajustePoliza();	
	}
	
	/*@Context(step = "Valida que ocurra la reversión del pago de una cuota que ha sido cancelada", page = "Administración")
	public static void validarReversionPagoCuota() {
		Utils.stepStarted();
		MuerteAccidentalEvents.cargarPaginaAdmin();
		//MuerteAccidentalEvents.cargarPaginaBuscarItemCuenta2();
		MuerteAccidentalEvents.buscarItem2();
		MuerteAccidentalEvents.validarMontoRevertido();
	}*/
	
	/*@Context(step = "Pagar una cuota de la póliza seleccionada", page = "Administración")
	public static void pagarCuota() throws InterruptedException {
		Utils.stepStarted();
		TransversalSteps.visitarPaginaHome();
		MuerteAccidentalEvents.cargarPaginaAdmin();
		MuerteAccidentalEvents.cargarPaginaBuscarItemCuenta();
		MuerteAccidentalEvents.buscarItem();
		MuerteAccidentalEvents.seleccionarItemPagar();
		MuerteAccidentalEvents.validarEstadoItemSeleccionado();
		MuerteAccidentalEvents.crearPago();
		MuerteAccidentalEvents.validarEstadoEnviadoSistemaPago();
	}*/
	
	@Context(step = "Selecciona el motivo de la cancelacion ", page = "Manejo Póliza", functionality = "Cancelación")
	public static void seleccionaCancelacionPoliza(String motivoCancelacion){
		Utils.stepStarted();
		MuerteAccidentalEvents.seleccionarCancelacionPoliza(motivoCancelacion);	
	}
	
	@Context(step = "Selecciona el motivo de la cancelacion ", page = "Manejo Póliza", functionality = "Cancelación")
	public static void validarEstadoCancelacionPoliza(){
		Utils.stepStarted();
		MuerteAccidentalEvents.validarPolizaCancelada();	
	}
	
	@Context(step = "Se revisa el estado de la poliza ", page = "Manejo Póliza", functionality = "Cancelación")
	public static void validarEstadoRenovadaPoliza(){
		Utils.stepStarted();
		MuerteAccidentalEvents.validarPolizaRenovado();	
	}
	
	@Context(step = "Completar datos de emision", page = "Manejo Objeto", functionality = "Emision")
	public static void datosPlanes() {
	
		Utils.stepStarted();
		MuerteAccidentalEvents.seleccionarTipodeCobertura();
	}
	@Context(step = "Selecciona producto MuerteAccidental para siniestrar", page = "Manejo Objeto", functionality = "Emisión")
	public static void seleccionarProducto(){
		Utils.stepStarted();
		MuerteAccidentalEvents.seleccionarProductoSiniestrar();
	}
	@Context(step = "Selecciona producto MuerteAccidental para siniestrar", page = "Manejo Objeto", functionality = "Emisión")
	public static void seleccionarProductoSiniestrarSaludAP(){
		Utils.stepStarted();
		MuerteAccidentalEvents.seleccionarProductoSiniestrarSaludAP();
	}
	@Context(step = "Responde preguntas obligatorias definidas", page = "Manejo Objeto", functionality = "Siniestros")
	public static void responderPreguntasAP(String respuesta1, String respuesta3, String respuesta4 ,String respuesta5){
		Utils.stepStarted();
		MuerteAccidentalEvents.responderPreguntas(respuesta1, respuesta3, respuesta4, respuesta5);
	}
	@Context(step = "Genera un siniestro para una póliza vigente", page = "Manejo Objeto", functionality = "Siniestros")
	public static void generarSiniestro(){
		
		Utils.stepStarted();
		MuerteAccidentalEvents.generarSiniestro();
				
	}
	@Context(step = "Completa datos del evento", page = "Manejo Objeto", functionality = "Siniestros")
	public static void completarEvento(String evento, String causa){
		Utils.stepStarted();
		MuerteAccidentalEvents.seleccionarEvento(evento);
		MuerteAccidentalEvents.seleccionarCausa(causa);
		MuerteAccidentalEvents.seleccionarCobertura();
	}
	
	@Context(step = "Completar datos de emision", page = "Manejo Objeto", functionality = "Emision")
	public static void datosRiesgos() {
	
		Utils.stepStarted();
		MuerteAccidentalEvents.seleccionarCheckBoxComision();
	}
	
	@Context(step = "Completar datos de emision", page = "Manejo Objeto", functionality = "Emision")
	public static void validarEndosoAP() {
	
		Utils.stepStarted();
		MuerteAccidentalEvents.ingresarLineaPolizaAP();
	}
	
	@Context(step = "Completar datos de emision", page = "Manejo Objeto", functionality = "Emision")
	public static void datosBeneficiarios(String apellido, String nombreCompleto, String porcentaje) {
	
		Utils.stepStarted();
		TransversalEvents.loadingTIAGeneral(60);
		MuerteAccidentalEvents.nuevoBeneficiario(apellido, nombreCompleto);
		MuerteAccidentalEvents.datosBeneficiarios(porcentaje);
		TransversalEvents.guardarCambios();
	}
	
	@Context(step = "Completar datos de emision", page = "Manejo Objeto", functionality = "Emision")
	public static void cambiarPorcentajeAP(String porcentaje) {
	
		Utils.stepStarted();
		MuerteAccidentalEvents.datosBeneficiarios(porcentaje);
		TransversalEvents.guardarCambios();
	}
	
	@Context(step = "Completar datos de emision", page = "Manejo Objeto", functionality = "Emision")
	public static void eliminarBeneficiarioAP() {
		
		Utils.stepStarted();
		MuerteAccidentalEvents.eliminarBeneficiario();
	}
	
	@Context(step = "Inicia ajuste de póliza con fecha de ajuste por defecto del sistema", page = "Manejo Póliza", functionality = "Cancelación")
	public static void ajustarPolizaMA(String tipoEndoso){
		Utils.stepStarted();
		MuerteAccidentalEvents.ajustarPolizaMA(tipoEndoso);
	}
	
	@Context(step = "Renovar una póliza manualmente", page = "Manejo Poliza", functionality = "Renovacion")
	public static void renovarPolizaMA(){
		Utils.stepStarted();
		MuerteAccidentalEvents.renovarPolizaMA();
	}
	
}
