package main.java.pageSteps.tia.productos;

import main.java.config.Context;
import main.java.config.Utils;
import main.java.pageEvents.tia.productos.MascotasResponsableEvents;
import main.java.pageEvents.tia.productos.OncologicoEvents;
import main.java.pageEvents.tia.transversal.TransversalEvents;

public class MascotasResponsableSteps {

	@Context(step = "Completa datos de una mascota de tipo mestizo", page = "Manejo Objeto", functionality = "Emisión")
	public static void completarDatosMascotaMestiza(String tipoMascota, String edadMascota, String nombreMascota,
			String sexoMascota, String linajeMascota) {

		Utils.stepStarted();
		MascotasResponsableEvents.seleccionarTipoMascota(tipoMascota);
		MascotasResponsableEvents.seleccionarEdadMascota(edadMascota);
		MascotasResponsableEvents.insertarNombreMascota(nombreMascota);
		MascotasResponsableEvents.seleccionarSexoMascota(sexoMascota);
		MascotasResponsableEvents.seleccionarLinajeMascota(linajeMascota);
		Utils.takeAdditionalScreenshot("Ingreso de informacion de la mascota" , "extra");
	}

	@Context(step = "Completa datos de una mascota de raza", page = "Manejo Objeto", functionality = "Emisión")
	public static void completarDatosMascotaRaza(String tipoMascota, String edadMascota, String nombreMascota,
			String sexoMascota, String linajeMascota, String razaMascota) {

		Utils.stepStarted();
		MascotasResponsableEvents.seleccionarTipoMascota(tipoMascota);
		MascotasResponsableEvents.seleccionarEdadMascota(edadMascota);
		MascotasResponsableEvents.insertarNombreMascota(nombreMascota);
		MascotasResponsableEvents.seleccionarSexoMascota(sexoMascota);
		MascotasResponsableEvents.seleccionarLinajeMascota(linajeMascota);
		MascotasResponsableEvents.seleccionarRazaMascota(razaMascota);
	}

	@Context(step = "Selecciona chip para la mascota", page = "Manejo Objeto", functionality = "Emisión")
	public static void seleccionarChip() {

		Utils.stepStarted();
		MascotasResponsableEvents.seleccionarChipMascota();
	}

	@Context(step = "Selecciona producto Mascota Responsable para siniestrar", page = "Manejo Objeto", functionality = "Emisión")
	public static void seleccionarProducto() {

		Utils.stepStarted();
		MascotasResponsableEvents.seleccionarProductoSiniestrar();
	}

	
	
	
	@Context(step = "Completa datos del evento", page = "Manejo Objeto", functionality = "Siniestros")
	public static void completarEvento(String evento, String causa) {

		Utils.stepStarted();

		MascotasResponsableEvents.seleccionarEvento(evento);
		MascotasResponsableEvents.seleccionarCausa(causa);
		MascotasResponsableEvents.seleccionarCobertura();

	}

	@Context(step = "Selecciona evento principal", page = "Manejo Objeto", functionality = "Siniestros")
	public static void seleccionarEventoPrincipal(String eventoPrincipal) {

		Utils.stepStarted();
		MascotasResponsableEvents.seleccionarEventoPrincipal(eventoPrincipal);

	}
	
	@Context(step = "Crea una nueva póliza del producto seleccionado para la entidad buscada", page = "Resumen Entidad")
    public static void crearPolizaMascotaResponsableDsct(String producto, String canalVenta) {
        Utils.stepStarted();
        TransversalEvents.crearNuevaPoliza(producto);
        TransversalEvents.seleccionarCanalVenta(canalVenta);
    }
	
	@Context(step = "Agrega un código de descuento a la póliza", page = "Línea Póliza")
    public static void incluirDescuentoMascotaResponsable(String codigo, String respuesta) {
        Utils.stepStarted();
        MascotasResponsableEvents.agregarDescuentoMascotaResponsable(codigo, respuesta);
        TransversalEvents.guardarCambios();
        TransversalEvents.crearNuevaLineaPoliza();
    }

	@Context(step = "Responde preguntas obligatorias definidas", page = "Manejo Objeto", functionality = "Siniestros")
	public static void responderPreguntas(String respuesta1, String respuesta2, String respuesta3, String respuesta4, String respuesta5) {

		Utils.stepStarted();

		MascotasResponsableEvents.responderPreguntas(respuesta1, respuesta2, respuesta3, respuesta4, respuesta5);

	}
	
	@Context(step = "Calcula la prima total del seguro", page = "Objeto Póliza")
    public static void calcularPrimaTotalMascotaResponsableDsct() {
        Utils.stepStarted();
        TransversalEvents.calcularPrimaTotal();
        TransversalEvents.guardarCambios();
        TransversalEvents.ingresarLineaPolizaV2();
        TransversalEvents.loadingTIAGeneral();
        OncologicoEvents.confirmarDescuento();
    }

	@Context(step = "Inicia ajuste de póliza con fecha de ajuste por defecto del sistema", page = "Manejo Póliza", functionality = "Cancelación")
	public static void ajustarPolizaMR(String tipoEndoso){
		Utils.stepStarted();
		MascotasResponsableEvents.ajustarPolizaMR(tipoEndoso);
	}
	
	@Context(step = "Inicia ajuste de póliza con fecha de ajuste por defecto del sistema", page = "Manejo Póliza", functionality = "Cancelación")
	public static void ingresarPolizaMR(String idPoliza){
		Utils.stepStarted();
		MascotasResponsableEvents.ingresarPolizaMR(idPoliza);
	}
	
	@Context(step = "Inicia ajuste de póliza con fecha de ajuste por defecto del sistema", page = "Manejo Póliza", functionality = "Cancelación")
	public static void seleccionarFechaDosDiasAntes(){
		Utils.stepStarted();
		MascotasResponsableEvents.seleccionarFechaDosDiasAntes();
	}
	
	@Context(step = "Crea una nueva póliza del producto MR", page = "Resumen Entidad")
	public static void crearPolizaMR(String producto, String canalVenta) {
		Utils.stepStarted();
		TransversalEvents.crearNuevaPoliza(producto);
		TransversalEvents.seleccionarCanalVenta(canalVenta);
		TransversalEvents.guardarCambios();
		TransversalEvents.seleccionarFechaPolizaDosDiasAntes();
		TransversalEvents.crearNuevaLineaPoliza();
	}

	
}
