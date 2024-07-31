package main.java.pageSteps.portalSB.transversal;

import main.java.config.Context;
import main.java.config.Utils;
import main.java.pageEvents.portalSB.transversal.TransversalPortalSBEvents;

public class TransversalPortalSBSteps {
	@Context(step = "validar ingreso al portal de SB", page = "Portal")
	public static void validarAmbientePortalSB(String opcionPortal) {

		Utils.stepStarted();
		TransversalPortalSBEvents.validarAmbientePortalSB(opcionPortal);
	}
	
	@Context(step = "Ingresar nombre y apellido del contratante", page = "Inicio")
	public static void ingresarNombreApellido(String nombre,String apellido) {

		Utils.stepStarted();
		TransversalPortalSBEvents.ingresarNombreContratante(nombre);
		TransversalPortalSBEvents.ingresarApellidoContratante(apellido);
		Utils.takeAdditionalScreenshot("nombreApellidoContratante", "extra");
	}
	
	@Context(step = "Ingresar Correo del contratante", page = "Inicio")
	public static void ingresarCorreo(String correo) {

		Utils.stepStarted();
		TransversalPortalSBEvents.ingresarCorreoContratante(correo);
		Utils.takeAdditionalScreenshot("Correo", "extra");
	}
	
	@Context(step = "validar y aprobar terminos y condiciones", page = "Inicio")
	public static void aprobarTerminoCondiciones() {

		Utils.stepStarted();
		TransversalPortalSBEvents.validarTerminosCondiciones();
		Utils.takeAdditionalScreenshot("aprobarTerminoCondiciones", "extra");
	}
	
	@Context(step = "Avanzar a la siguiente pagina", page = "Transversal")
	public static void avanzarSiguientePagina(String seccionFlujo) {

		Utils.stepStarted();
		TransversalPortalSBEvents.avanzarSiguientePagina(seccionFlujo);
	}
	
	@Context(step = "Seleccionar Plan", page = "Transversal")
	public static void seleccionarPlan(String nombrePlan, String montoUF,String seccionFlujo) {

		Utils.stepStarted();
		TransversalPortalSBEvents.seleccionaPlan(nombrePlan, montoUF, seccionFlujo);
	}

	@Context(step = "Rellenar formulario de la sección info", page = "Transversal")
	public static void rellenarFormularioInfo( String anio, String mes, String dia, String telefono, String rut, String numeroDoc, String nombreCalle, String numeroCalle, String depto, String region, String comuna) {
		Utils.stepStarted();
		TransversalPortalSBEvents.rellenarFomularioInfo(anio, mes, dia, telefono, rut, numeroDoc, nombreCalle, numeroCalle, depto, region, comuna);
		
	}
	@Context(step = "Rellenar formulario de la sección info", page = "Transversal")
	public static void avanzarResumen() {
		Utils.stepStarted();
		TransversalPortalSBEvents.avanzarResumen();
		
	}
	@Context(step = "Avanzar al medio de pago", page = "Transversal")
	public static void irPagar(String tipoTarjeta, String numeroTarjeta, String fechaExpiracion, String CVV, String nombreBanco,String rutTransbank, String contaseniaTransbank) {
		Utils.stepStarted();
		TransversalPortalSBEvents.irapagar();
		TransversalPortalSBEvents.ingresarTarjeta(tipoTarjeta,numeroTarjeta,fechaExpiracion,CVV,nombreBanco);
		TransversalPortalSBEvents.aprobarPago(rutTransbank,contaseniaTransbank);
		
	}
}
