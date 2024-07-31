package main.java.pageEvents.portalSB.productos;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import main.java.config.Context;
import main.java.config.ElementFetch;
import main.java.config.Utils;
import main.java.config.Validation;
import main.java.pageEvents.portalSB.transversal.TransversalPortalSBEvents;
import main.java.pageObjects.portalSB.productos.MascotaSaludPortalSBElements;
import main.java.properties.EntidadProperties;
import main.java.properties.MascotaProperties;
import main.java.utils.Constants;
import main.java.utils.Events;
import test.java.BaseTest;

public class MascotaSaludPortalSBEvents extends BaseTest implements MascotaSaludPortalSBElements {

	@Context(description = "Seleccionar tipo de mascota", page = "TipoMascota", functionality = "Mascota")
	public static void seleccionarTipoMascota(String tipoMascota) {
		try {
			String xpathTipoMascota = "";
			if(tipoMascota.equalsIgnoreCase("perro")) {
				xpathTipoMascota = radioButtonPerro;
			}
			else if(tipoMascota.equalsIgnoreCase("gato")){
				xpathTipoMascota = radioButtonGato;
			}
			else {
				Utils.eventFailed(String.format("Tipo de mascota inválido, se esperaba Perro o Gato y se ingreso %s", tipoMascota));
			}
				
			TransversalPortalSBEvents.activarCheckRadio(xpathTipoMascota);
			MascotaProperties.tipoMascota = tipoMascota;
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
			
	}
	
	
	
	@Context(description = "Ingresar nombre de mascota", page = "Mascota", functionality = "Ingresar Nombre")
	public static void ingresarNombreMascota(String nombreMascota) {
		try {
			Events.sendKeysWithReturnVariableName(inputNombreMascota, nombreMascota.trim());
			MascotaProperties.nombreMascota = nombreMascota;
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}
	@Context(description = "Ingresar raza mascota", page = "Mascota", functionality = "Ingresar raza")
	public static void ingresarRazaMascota(String raza) {
		try {
			TransversalPortalSBEvents.seleccionarItemEnComboBox(selectRazaMascota,raza);
			MascotaProperties.razaMascota = raza;
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}
	
	@Context(description = "Ingresar Edad de la mascota", page = "Masctoa", functionality = "Ingresar Edad")
	public static void ingresarEdadMascota(String edadMascota) {
		try {
			TransversalPortalSBEvents.seleccionarItemEnComboBox(selectEdadMascota,edadMascota);
			
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}
	
	@Context(description = "Ingresar Genero de la mascota", page = "Masctoa", functionality = "Ingresar Genero")
	public static void ingresarGeneroMascota(String generoMascota) {
		try {
			String opcGenString = "";
			if (generoMascota.trim().toLowerCase().contains("macho") || generoMascota.trim().toLowerCase().contains("masculino")) {
				opcGenString = "macho";
			}
			else if (generoMascota.trim().toLowerCase().contains("hembra") || generoMascota.trim().toLowerCase().contains("femenino")) {
				opcGenString = "hembra";
			}
			else {
				Utils.eventFailed(String.format("Opción ingresa '%s' es invalida, se debe ingresar Macho o Hembra", generoMascota));
			}
			TransversalPortalSBEvents.seleccionarItemEnComboBox(selectGeneroMascotaString,opcGenString);
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}


	@Context(description = "resumen contratación detalle mascota", page = "Mascota", functionality = "Resumen")
	public static void resumenMascota() {
		try {
			String nombreMascota =  Events.getText(labelNombreMascotaResumen);
			String tipoMascota = Events.getText(labelEspecieMascotaResumen);
			String razaMascota = Events.getText(labelRazaMascotaResumen);
			
			Validation.trueBooleanCondition(nombreMascota.trim().contains(MascotaProperties.nombreMascota.trim()), 
					"Nombre Mascota es correcto.", String.format("El nombre de la mascota visualizado en pantalla '%s', no coincide con lo ingresado %s", nombreMascota, MascotaProperties.nombreMascota) );
			Validation.trueBooleanCondition(tipoMascota.trim().toLowerCase().contains(MascotaProperties.tipoMascota.trim().toLowerCase()), 
					"Tipo Mascota es correcto.", String.format("El tipo de mascota visualizado en pantalla '%s', no coincide con lo ingresado %s", tipoMascota, MascotaProperties.tipoMascota) );
			Validation.trueBooleanCondition(razaMascota.trim().toLowerCase().contains(MascotaProperties.razaMascota.trim().toLowerCase()), 
					"Raza Mascota es correcto.", String.format("El nombre de la mascota visualizado en pantalla '%s', no coincide con lo ingresado %s", razaMascota, MascotaProperties.razaMascota) );

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
		
	}
	
	@Context(description = "mensaje de póliza contratada", page = "Mascota", functionality = "Confirmacion")
	public static void mensajeContratacion() {
		try {
			String mensajeHazContratado = Events.getText(labelContratado);
			String mensajeEnvioPol = Events.getText(labelMensajeEnvioPol);
			String tituloMascota = Events.getText(labelTituloMascotaPolContratado);
			
			if (!tituloMascota.trim().toLowerCase().contains("mascota")) {
				Utils.eventFailed("No ha retornado al portal de mascota correctamente");
			}
			
			if (!mensajeHazContratado.trim().toLowerCase().contains(EntidadProperties.nombreContratante.toLowerCase().trim())) {
				Utils.eventFailed(String.format("Nombre del contratante no coincide, dentro del mensaje obtenido '%s' no se encontro el nombre '%s'",mensajeHazContratado.trim(),EntidadProperties.nombreContratante ));	
			}
			
			if (!mensajeEnvioPol.trim().toLowerCase().contains(EntidadProperties.correoContratante.toLowerCase().trim())) {
				Utils.eventFailed(String.format("En el mensaje visualizado que indica el envpio de la poliza, no se encontro el correo '%s'", EntidadProperties.correoContratante));
			}
			Utils.outputInfo("Contratacion realizada con exito");
			Utils.takeAdditionalScreenshot("confirmacionPolEmitida", "extra");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
