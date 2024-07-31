package main.java.pageSteps.portalSB.productos;

import main.java.config.Context;
import main.java.config.Utils;
import main.java.pageEvents.portalSB.productos.MascotaSaludPortalSBEvents;
import main.java.pageEvents.portalSB.transversal.TransversalPortalSBEvents;


public class MascotaSaludPortalSBSteps {
	
	@Context(step = "Seleccionar tipo de mascota a asegurar", page = "Tipo Mascota")
	public static void datosMascota(String nombreMascota,String tipoMascota, String raza, String edadMascota, String generoMascota) {

		Utils.stepStarted();
		MascotaSaludPortalSBEvents.seleccionarTipoMascota(tipoMascota);
		MascotaSaludPortalSBEvents.ingresarNombreMascota(nombreMascota);
		MascotaSaludPortalSBEvents.ingresarEdadMascota(edadMascota);
		MascotaSaludPortalSBEvents.ingresarRazaMascota(raza);
		MascotaSaludPortalSBEvents.ingresarGeneroMascota(generoMascota);
		Utils.takeAdditionalScreenshot("aprobarTerminoCondiciones", "extra");
		
		
	}
	@Context(step = "Resumen contratación", page = "Tipo Mascota")
	public static void resumenContratacion() {
		Utils.stepStarted();
		TransversalPortalSBEvents.resumenEntidad();
		MascotaSaludPortalSBEvents.resumenMascota();
		
	}
	@Context(step = "Confirmación contratación", page = "Tipo Mascota")
	public static void confirmacionPoliza() {
		Utils.stepStarted();
		TransversalPortalSBEvents.confirmacionPopUp();
		MascotaSaludPortalSBEvents.mensajeContratacion();
	}
	

}
