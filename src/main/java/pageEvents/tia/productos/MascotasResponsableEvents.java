package main.java.pageEvents.tia.productos;

import main.java.pageObjects.tia.productos.MascotasResponsableElements;
import main.java.utils.Events;

import java.time.LocalDate;

import main.java.config.Context;
import main.java.config.Utils;
import main.java.config.Validation;
import main.java.pageEvents.tia.transversal.TransversalEvents;

public class MascotasResponsableEvents implements MascotasResponsableElements {

	@Context(description = "Selecciona el tipo de mascota", page = "Manejo Objeto", functionality = "Emisión")
	public static void seleccionarTipoMascota(String tipoMascota) {

		try {
			Events.selectByContainsText(selectTipoMascota, tipoMascota);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona la edad de la mascota", page = "Manejo Objeto", functionality = "Emisión")
	public static void seleccionarEdadMascota(String edadMascota) {

		try {
			Events.selectByContainsText(selectEdadMascota, edadMascota);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Inserta nombre de la mascota", page = "Manejo Objeto", functionality = "Emisión")
	public static void insertarNombreMascota(String nombreMascota) {

		try {
			Events.sendKeys(inputNombreMascota, nombreMascota);
			Validation.trueBooleanCondition(!(nombreMascota == ""),
					"Se ha introducido correctamente el nombre de la mascota",
					"No se ha introducido nombre de mascota");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona chip de la mascota", page = "Manejo Objeto", functionality = "Emisión")
	public static void seleccionarChipMascota() {

		try {
			Events.clickButton(checkboxChipMascota);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona el sexo de la mascota", page = "Manejo Objeto", functionality = "Emisión")
	public static void seleccionarSexoMascota(String sexoMascota) {

		try {
			Events.selectByContainsText(selectSexoMascota, sexoMascota);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona el linaje de la mascota", page = "Manejo Objeto", functionality = "Emisión")
	public static void seleccionarLinajeMascota(String linajeMascota) {

		try {
			Events.selectByContainsText(selectLinajeMascota, linajeMascota);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona la raza de la mascota", page = "Manejo Objeto", functionality = "Emisión")
	public static void seleccionarRazaMascota(String razaMascota) {

		try {
			Thread.sleep(7000);
			Events.selectByContainsText(selectRazaMascota, razaMascota);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Acepta Términos", page = "Manejo Objeto", functionality = "Emisión")
	public static void aceptarTerminos(String aceptaTerminos) {

		try {
			if (aceptaTerminos.equalsIgnoreCase("No"))
				Events.clickButton(checkboxTerminos);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Acepta Coberturas", page = "Manejo Objeto", functionality = "Emisión")
	public static void aceptarCoberturas(String aceptaCoberturas) {

		try {
			if (aceptaCoberturas.equalsIgnoreCase("No"))
				Events.clickButton(checkboxCobertura);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Crea objeto Mascota Responsable", page = "Manejo Objeto", functionality = "Emisión")
	public static void crearObjetoMascotaResponsable() {

		try {
			Events.clickButton(buttonGuardarObjeto);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona producto Mascota Responsable para siniestrar", page = "Manejo Objeto", functionality = "Emisión")
	public static void seleccionarProductoSiniestrar() {

		try {
			Events.clickButton(buttonProductoMRsiniestro);
			String tituloPagina = Events.getText(labelPaginaCrearSiniestro);
			Utils.outputInfo("La sección actual es: " + tituloPagina + " Mascota Responsable");
			Validation.trueBooleanCondition(tituloPagina.contains("Crear siniestro"),
					"Se ha ingresado a la página para la creación de un siniestro de una póliza de tipo Mascota Responsable",
					"No se ha ingresado correctamente para crear un siniestro de una póliza de tipo Mascota Responsable");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	

	
		
	
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
			Events.clickButton(spanCobertura2);
			Events.clickButton(buttonAceptaSeleccion);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona evento principal", page = "Manejo Objeto", functionality = "Siniestros")
	public static void seleccionarEventoPrincipal(String eventoPrinc) {

		try {
			Events.clickButton(buttonBusquedaEventoPrincipal);
			Events.clickButton(spanEventoPrincipal);
			Events.clickButton(buttonAceptaSeleccion);

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	
	

	

	

	@Context(description = "Responde preguntas obligatorias", page = "Manejo Objeto", functionality = "Siniestros")
	public static void responderPreguntas(String respuesta1, String respuesta2, String respuesta3, String respuesta4, String respuesta5) {

		try {
			Events.sendKeys(inputRespuesta, respuesta1);
			Events.clickButton(buttonAprobar);
			HogarFullEvents.loadingTIAGeneral();
			
			Events.selectByContainsText(selectRespuesta, respuesta2);
			Events.clickButton(buttonAprobar);
			HogarFullEvents.loadingTIAGeneral();

			Events.sendKeys(inputRespuestaRut, respuesta3);
			Events.clickButton(buttonAprobar);
			HogarFullEvents.loadingTIAGeneral();
			
			Events.sendKeys(inputRespuestaEmail, respuesta4);
			Events.clickButton(buttonAprobar);
			HogarFullEvents.loadingTIAGeneral();
			
			Events.sendKeys(inputRespuestaFono, respuesta5);
			Events.clickButton(buttonAprobar);
			HogarFullEvents.loadingTIAGeneral();
			
			String mensaje = Events.getText(labelEstadoPreguntasOK);
			Utils.outputInfo("El estado de las preguntas es: " + mensaje);
			Validation.trueBooleanCondition(mensaje.contains("OK"), "Se ha respondido la pregunta obligatoria",
					"No se ha respondido la pregunta obligatoria");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}
	
	@Context(description = "Agrega un código de descuento a la prima total", page = "Manejo Línea de póliza", functionality = "Emision")
    public static void agregarDescuentoMascotaResponsable(String codigo, String respuesta) {

        try {
            Events.sendKeys(inputCodigoDescuento, codigo);
            Events.selectByContainsText(selectTipoRespuesta, respuesta);
            Thread.sleep(5000);

        } catch (Exception e) {
            Utils.eventFailed(e.getMessage());
        }
    }

	@Context(description = "Inicia el ajuste de una Póliza para realizar cancelaciones", page = "Manejo Póliza", functionality = "Cancelación")
	public static void ajustarPolizaMR(String tipoEndoso) {

		try {
			Events.clickButton(buttonAjustarMR);
			Events.selectByContainsText(selectTipoEndosoAlternativoMR, tipoEndoso);
			Events.clickButton(buttonAceptaAjusteMR);
			HogarFullEvents.loadingTIAGeneral();

			String tipoTransaccion = Events.getText(labelTipoTransaccionMR);
			Validation.trueBooleanCondition(tipoTransaccion.contains("Ajuste"),
					"Se ha ingresado al ajuste de la póliza correctamente: ",
					"No se ha ingresado al ajuste de la póliza correctamente");

			TransversalEvents.guardarCambios();
            //guardarCambiosHF();
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Selecciona la póliza en el listado de pólizas del resumen de la entidad seleccionada previamente", page = "Manejo Poliza", functionality = "Endosos")
	public static void ingresarPolizaMR(String idPoliza) {

		try {
			Thread.sleep(5000);
			Events.clickButton(buttonAmpliarVentanaPolizas);
			Events.clickButton(aPolizav3.replace("id-poliza", idPoliza));
			Thread.sleep(7000);
			String tituloPaginaPoliza = Events.getText(labelManejoPoliza);
			Utils.outputInfo("La sección actual es: " + tituloPaginaPoliza);
			Validation.trueBooleanCondition(tituloPaginaPoliza.contains(idPoliza),
					"Se ha ingresado a la póliza correcta: " + idPoliza,
					"No se ha ingresado a la póliza correctamente");
			
//			Events.clickButton(buttonAmpliarVentanaPolizas);
//			Thread.sleep(1500);
//			Events.clickButton(aPolizav3.replace("id-poliza", PolizaProperties.idPoliza));
//			Thread.sleep(7000);
//			String tituloPaginaPoliza = Events.getText(labelManejoPoliza);
//			Utils.outputInfo("La sección actual es: " + tituloPaginaPoliza);
//			Validation.trueBooleanCondition(tituloPaginaPoliza.contains(PolizaProperties.idPoliza),
//					"Se ha ingresado a la póliza correcta: " + PolizaProperties.idPoliza,
//					"No se ha ingresado a la póliza correctamente");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}
	
	@Context(step = "Selecciona la fecha 2 dias antes", page = "Manejo Objeto", functionality = "Siniestro")
	public static void seleccionarFechaDosDiasAntes() {

		try {
			TransversalEvents.loadingTIAGeneral();
			Events.clickButton(buttonSelecFecInicioCobertura);
			TransversalEvents.loadingTIAGeneral();
			LocalDate fechaHoy = LocalDate.now();
			int numDiaAntesDeAyer = (fechaHoy.getDayOfMonth()) - 2;
			String diaString = String.valueOf(numDiaAntesDeAyer);
			Events.clickButton(buttonSeleccionarDiaHora.replace("dia", diaString));
			TransversalEvents.loadingTIAGeneral();
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}
			
	}
