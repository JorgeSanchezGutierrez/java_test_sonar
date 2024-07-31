package test.java.tia.siniestros;

import com.opencsv.exceptions.CsvValidationException;
import main.java.config.OpenCSV;
import main.java.pageSteps.tia.productos.HogarFullSteps;
import main.java.pageSteps.tia.transversal.TransversalSteps;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.java.BaseTest;

import java.io.File;
import java.io.IOException;

public class HogarFullTests extends BaseTest {
	// Generación de un siniestro para una póliza Hogar Full
	@Test(priority = 1, enabled = true, dataProvider = "dataHogarFull")
	public void ATMOQA79(String args[]) throws InterruptedException {
		test.assignCategory("Hogar_Full").assignDevice("Siniestros");
		step = test.createNode("Generación de un siniestro en TIA para una póliza vigente Hogar Full");

		TransversalSteps.ingresarComoSuscriptor(userSuscriptor, passSuscriptor);
		TransversalSteps.buscarEntidad(args[0], args[1]);
		// Crear nueva póliza
		TransversalSteps.crearPolizaDiaAnterior(args[27], args[28]); 
		HogarFullSteps.seleccionarTipoContratante(args[29]);
		HogarFullSteps.identificarPropiedad(args[30]);
		HogarFullSteps.seleccionarPropiedadCasaCondominio(args[31]);
		HogarFullSteps.completarInformacionPropiedad(args[32], args[33], args[34], args[35]);
		HogarFullSteps.seleccionarCoberturaIncendio(args[36], args[37]);
		TransversalSteps.calcularPrimaTotal();
		// completar poliza
		TransversalSteps.completarPoliza(args[38]);
		TransversalSteps.aceptarDocumentosPoliza();
		// completar datos siniestro
		TransversalSteps.ingresarPolizaBusquedaRapida();
		TransversalSteps.ingresarSiniestroCreateClaim();
		HogarFullSteps.seleccionarProducto();
		// completa datos de un siniestro Hogar Full
		TransversalSteps.seleccionFechaSiniestro();
		HogarFullSteps.completarEvento(args[6], args[7], args[8]);
		HogarFullSteps.insertarDescripcionHechoHF(args[4]);
		HogarFullSteps.seleccionarLugarSiniestroHF(args[9]);
		HogarFullSteps.completarDatosInformanteHF(args[10], args[11], args[12]);
		HogarFullSteps.responderPreguntas(args[13], args[14], args[15], args[16]);
		// generar siniestro
		HogarFullSteps.generarSiniestroHF(args[6]);
	}

	// Generación de un siniestro para una póliza Hogar Full definiendo un
	// gestor de siniestro diferente
	@Test(priority = 2, enabled = true, dataProvider = "dataHogarFull")
	public void ATMOQA80(String args[]) throws InterruptedException {
		test.assignCategory("Hogar_Full").assignDevice("Siniestros");
		step = test.createNode(
				"Generación de un siniestro en TIA para una póliza vigente Hogar Full con un gestor de siniestro distinto al usuario autenticado");
		TransversalSteps.ingresarComoSuscriptor(userSuscriptor, passSuscriptor);
		TransversalSteps.buscarEntidad(args[0], args[1]);
		// Crear nueva póliza
		TransversalSteps.crearPolizaDiaAnterior(args[27], args[28]);
		HogarFullSteps.seleccionarTipoContratante(args[29]);
		HogarFullSteps.identificarPropiedad(args[30]);
		HogarFullSteps.seleccionarPropiedadCasaCondominio(args[31]);
		HogarFullSteps.completarInformacionPropiedad(args[32], args[33], args[34], args[35]);
		HogarFullSteps.seleccionarCoberturaIncendio(args[36], args[37]);
		TransversalSteps.calcularPrimaTotal();
		// completar poliza
		TransversalSteps.completarPoliza(args[38]);
		TransversalSteps.aceptarDocumentosPoliza();
		// completar datos siniestro
		TransversalSteps.ingresarPolizaBusquedaRapida();
		TransversalSteps.ingresarSiniestroCreateClaim();
		// selecciona siniestro de tipo Hogar Full
		HogarFullSteps.seleccionarProducto();
		// completa datos de un siniestro Hogar Full
		TransversalSteps.seleccionFechaSiniestro();
		HogarFullSteps.completarEvento(args[6], args[7], args[8]);
		HogarFullSteps.insertarDescripcionHechoHF(args[4]);
		HogarFullSteps.seleccionarGestorHF(args[17]);
		HogarFullSteps.seleccionarLugarSiniestroHF(args[9]);
		HogarFullSteps.completarDatosInformanteHF(args[10], args[11], args[12]);
		HogarFullSteps.responderPreguntas(args[13], args[14], args[15], args[16]);
		// generar siniestro
		HogarFullSteps.generarSiniestroHF(args[6]);
	}

	// Generación de un siniestro para una póliza Hogar Full agregando una reserva
	@Test(priority = 3, enabled = true, dataProvider = "dataHogarFull")
	public void ATMOQA81(String args[]) throws InterruptedException {
		test.assignCategory("Hogar_Full").assignDevice("Siniestros");
		step = test.createNode(
				"Generación de un siniestro en TIA para una póliza vigente Hogar Full agregando una reserva");

		TransversalSteps.ingresarComoSuscriptor(userSuscriptor, passSuscriptor);
		TransversalSteps.buscarEntidad(args[0], args[1]);
		// Crear nueva póliza
		TransversalSteps.crearPolizaDiaAnterior(args[27], args[28]);
		HogarFullSteps.seleccionarTipoContratante(args[29]);
		HogarFullSteps.identificarPropiedad(args[30]);
		HogarFullSteps.seleccionarPropiedadCasaCondominio(args[31]);
		HogarFullSteps.completarInformacionPropiedad(args[32], args[33], args[34], args[35]);
		HogarFullSteps.seleccionarCoberturaIncendio(args[36], args[37]);
		HogarFullSteps.calcularPrimaTotalHF();
		// completar poliza
		TransversalSteps.completarPoliza(args[38]);
		TransversalSteps.aceptarDocumentosPoliza();
		// completar datos siniestro
		TransversalSteps.ingresarPolizaBusquedaRapida();
		TransversalSteps.ingresarSiniestroCreateClaim();
		// selecciona siniestro de tipo Hogar Full
		HogarFullSteps.seleccionarProducto();
		// completa datos de un siniestro Hogar Full
		TransversalSteps.seleccionFechaSiniestro();
//		HogarFullSteps.insertarFechaSiniestroHF(args[2]);
//		HogarFullSteps.insertarFechaDenunciaHF(args[3]);
//		HogarFullSteps.buscarPolizaHF(args[5]);
		HogarFullSteps.completarEvento(args[6], args[7], args[8]);
		HogarFullSteps.insertarDescripcionHechoHF(args[4]);
		HogarFullSteps.seleccionarLugarSiniestroHF(args[9]);
		HogarFullSteps.completarDatosInformanteHF(args[10], args[11], args[12]);
		HogarFullSteps.responderPreguntas(args[13], args[14], args[15], args[16]);
		// generar reserva
		HogarFullSteps.crearReservaHF(args[20], args[21], args[22], args[23]);
		HogarFullSteps.guardarReservaHF();
		// generar siniestro
		HogarFullSteps.generarSiniestroHF(args[6]);
	}

	// Generación de un siniestro en TIA para una póliza vigente Hogar Full
	// asignando un Liquidador
	@Test(priority = 4, enabled = true, dataProvider = "dataHogarFull")
	public void ATMOQA82(String args[]) throws InterruptedException {
		test.assignCategory("Hogar_Full").assignDevice("Siniestros");
		step = test.createNode(
				"Generación de un siniestro en TIA para una póliza vigente Hogar Full asignando un Liquidador");

		TransversalSteps.ingresarComoSuscriptor(userSuscriptor, passSuscriptor);
		TransversalSteps.buscarEntidad(args[0], args[1]);
		// Crear nueva póliza
		TransversalSteps.crearPolizaDiaAnterior(args[27], args[28]);
		HogarFullSteps.seleccionarTipoContratante(args[29]);
		HogarFullSteps.identificarPropiedad(args[30]);
		HogarFullSteps.seleccionarPropiedadCasaCondominio(args[31]);
		HogarFullSteps.completarInformacionPropiedad(args[32], args[33], args[34], args[35]);
		HogarFullSteps.seleccionarCoberturaIncendio(args[36], args[37]);
		HogarFullSteps.calcularPrimaTotalHF();
		// completar poliza
		TransversalSteps.completarPoliza(args[38]);
		TransversalSteps.aceptarDocumentosPoliza();
		// completar datos siniestro
		TransversalSteps.ingresarPolizaBusquedaRapida();
		TransversalSteps.ingresarSiniestroCreateClaim();
		// selecciona siniestro de tipo Hogar Full
		HogarFullSteps.seleccionarProducto();
		// completa datos de un siniestro Hogar Full
		TransversalSteps.seleccionFechaSiniestro();
		HogarFullSteps.completarEvento(args[6], args[7], args[8]);
		HogarFullSteps.insertarDescripcionHechoHF(args[4]);
		HogarFullSteps.seleccionarLugarSiniestroHF(args[9]);
		HogarFullSteps.completarDatosInformanteHF(args[10], args[11], args[12]);
		HogarFullSteps.seleccionarLiquidadorHF(args[24]);
		HogarFullSteps.responderPreguntas(args[13], args[14], args[15], args[16]);
		// validar reserva automática con Liquidador asignado
		HogarFullSteps.validarReservaAutomaticaHF(args[24], args[25], args[39]);
		HogarFullSteps.guardarReservaHF();
		// generar siniestro
		HogarFullSteps.generarSiniestroHF(args[6]);
	}

	// Liquidación de un siniestro en TIA para una póliza vigente Hogar Full
	@Test(priority = 5, enabled = true, dataProvider = "dataHogarFull")
	public void ATMOQA84(String args[]) throws InterruptedException {
		test.assignCategory("Hogar_Full").assignDevice("Siniestros");
		step = test.createNode(
				"Liquidación de ítem de un siniestro asociado a una póliza vigente del producto Hogar Full.");

		TransversalSteps.ingresarComoSuscriptor(userSuscriptor, passSuscriptor);
		TransversalSteps.buscarEntidad(args[0], args[1]);
		// Crear nueva póliza
		TransversalSteps.crearPolizaDiaAnterior(args[27], args[28]);
		HogarFullSteps.seleccionarTipoContratante(args[29]);
		HogarFullSteps.identificarPropiedad(args[30]);
		HogarFullSteps.seleccionarPropiedadCasaCondominio(args[31]);
		HogarFullSteps.completarInformacionPropiedad(args[32], args[33], args[34], args[35]);
		HogarFullSteps.seleccionarCoberturaIncendio(args[36], args[37]);
		HogarFullSteps.calcularPrimaTotalHF();
		// completar poliza
		TransversalSteps.completarPoliza(args[38]);
		TransversalSteps.aceptarDocumentosPoliza();
		// completar datos siniestro
		TransversalSteps.ingresarPolizaBusquedaRapida();
		TransversalSteps.ingresarSiniestroCreateClaim();
		// selecciona siniestro de tipo Hogar Full
		HogarFullSteps.seleccionarProducto();
		// completa datos de un siniestro Hogar Full
		TransversalSteps.seleccionFechaSiniestro();
		HogarFullSteps.completarEvento(args[6], args[7], args[8]);
		HogarFullSteps.insertarDescripcionHechoHF(args[4]);
		HogarFullSteps.seleccionarLugarSiniestroHF(args[9]);
		HogarFullSteps.completarDatosInformanteHF(args[10], args[11], args[12]);
		HogarFullSteps.responderPreguntas(args[13], args[14], args[15], args[16]);
		// generar reserva
		HogarFullSteps.crearReservaHF(args[20], args[21], args[22], args[23]);
		HogarFullSteps.guardarReservaHF();
		// generar siniestro
		HogarFullSteps.generarSiniestroHF(args[6]);
		// liquidar reserva
		HogarFullSteps.liquidarReservaHF(args[26], "0001");
	}

	@DataProvider(name = "dataHogarFull")
	public Object[][] dataHogarFull() throws CsvValidationException, InterruptedException, IOException {

		Object[][] data = OpenCSV.getCSVParametersDescription("siniestros" + File.separator + "CSVDataHogarFull.csv", 1,
				40);
		return data;
	}
}
