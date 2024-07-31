package main.java.pageObjects.tia.productos;

public interface MascotasResponsableElements {

	// select
	String selectTipoMascota = "//label[text()='Tipo De Mascota']//following::select[1]";
	String selectEdadMascota = "//label[text()='Mascota Edad']//following::select[1]";
	String selectSexoMascota = "//label[text()='Mascota Sexo']//following::select[1]";
	String selectLinajeMascota = "//label[text()='Mascota Sexo']//following::select[2]";
	String selectRazaMascota = "//label[contains(text(),'Mascota Raza')]//following::select[contains(@class,'x2h')][1]";
	String selectEvento = "//label[text()='Evento']/following::select[1]";
	String selectCausa = "//label[text()='Causa']/following::select[1]";
	String selectRespuesta = "//td[contains(text(), 'Asistente de preguntas')]/following::select";
	String selectTipoRespuesta = "(//label[text()='Tipo de respuesta']//following::select)[1]";

	// input
	String inputNombreMascota = "//label[text()='Mascota Nombre']//following::input[1]";
	String inputRespuesta = "//td[contains(text(), 'Asistente de preguntas')]/following::textarea[1]";
	String inputRespuestaRut = "//td[contains(text(), 'Asistente de preguntas')]/following::textarea[2]";
	String inputRespuestaEmail = "//td[contains(text(), 'Asistente de preguntas')]/following::textarea[3]";
	String inputRespuestaFono = "//td[contains(text(), 'Asistente de preguntas')]/following::textarea[4]";

	// checkbox
	String inputCodigoDescuento = "//label[text()='Campaña']//following::input[1]";
	String checkboxChipMascota = "//label[text()='Marcar si la mascota tiene chip']//following::input[1]";
	String checkboxTerminos = "//label[text()='Terminos Condiciones']//following::input[1]";
	String checkboxCobertura = "//label[text()='Coberturas']//following::input[1]";
	String checkBoxFechaEstimada = "//input[contains(@id,'WhenExactIncidentDate')]";

	// button
	String buttonGuardarObjeto = "//span[text()='Guardar']//ancestor::a";
	String buttonProductoMR = "(//span[contains(text(),'Mascota Responsable')]//preceding::a[@class='xgp'])[3]";
	String buttonProductoMRsiniestro = "//*[text()='Mascota Responsable']//preceding::div[3]";
	String buttonAceptaSeleccion = "(//span[contains(text(),'cepta')])[3]";
	String buttonBusquedaCobertura = "//label[text()='Cobertura N°']/following::img[1]";
	String buttonBusquedaEventoPrincipal = "//label[text()='Evento principal N°']/following::img[1]";
	String buttonAprobar = "//span[text()='Aprobar']";
	String buttonGenerarSiniestro = "//span[text()='Generar Siniestro']";
	String buttonFechaSuperiorDiaActual = "//td[contains (@class, 'p_AFSelected')]/following::td[1]";
	String buttonReserva = "//span[contains(text(),'Reserva')]/ancestor::a";
	String buttonNuevoItem = "//span[contains(text(),'Nuevo item')]";
	String buttonGuardarReserva = "//span[contains(text(),'Guardar')]";

	// label
	String labelEstadoPreguntasOK = "//span[text()='OK']";
	String labelPaginaCrearSiniestro = "//h1[contains(text(),'Crear siniestro')]";
	String spanCobertura = "//label[text()='Cobertura']/following::span[text()='*'][1]";
	String spanCobertura2 = "//label[text()='Cobertura']/following::span[text()='Responsabilidad Civil']";
	String spanEventoPrincipal = "//label[text()='Evento principal N°']/following::span[text()='282']";

	//
	String buttonAjustarMR = "//span[contains(text(), 'Ajustar ')]";
	String selectTipoEndosoAlternativoMR = "//select[contains(@id,'PolicyEndorReasonIdPopup')]";
	String buttonAceptaAjusteMR = "//label[contains(text(), 'Fecha de ajuste ')]/following::span[contains(text(), 'Aceptar')][1]";
	String labelTipoTransaccionMR = "(//label[contains(text(),'transacción')]/following::span[@class='x2h'])[1]";

	//
	String buttonAmpliarVentanaPolizas = "//div[contains(@_afrclmwmn,'CoverTreePolicyNoAltCol')]//div[contains(@title,'Separar')]";
	String aPolizav3 = "//*/tbody/tr[1]/td[1]/div/span[2]/a/span[contains(text(),'id-poliza')]";
	String labelManejoPoliza = "//h1[contains(text(),'Manejo de póliza')]";
	String labelFechaDeInicioCobertura = "//td[1]/table/tbody/tr[1]/td/table/tbody/tr[2]/td/input[@placeholder='dd.mm.yyyy']";
	String buttonSelecFecInicioCobertura = "(//label[text()='Fecha de inicio de cobertura']//following::a)[1]";
	String buttonSeleccionarDiaHora = "//td[contains(text(),'dia')]";
	

}
