package test.java.tia.siniestros;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.exceptions.CsvValidationException;

import main.java.config.OpenCSV;
import main.java.pageSteps.tia.transversal.TransversalSteps;
import main.java.pageSteps.tia.productos.OncologicoSteps;
import test.java.BaseTest;

public class OncologicoTests extends BaseTest {

	@Test(priority = 1, enabled = true, dataProvider = "dataOncologico")
	public void ATMOQA69(String[] args) throws InterruptedException {

		test.assignCategory("Oncológico").assignDevice("Siniestros");
		step = test.createNode("Generación de siniestro asociado a una póliza vigente del producto Oncológico.");

		TransversalSteps.ingresarComoSuscriptor(userSuscriptor, passSuscriptor);
		TransversalSteps.buscarEntidad(args[0], args[1]);
		// Crear nueva póliza
		TransversalSteps.crearPolizaDiaAnterior(args[2], args[3]);
		TransversalSteps.identificarMismoAsegurado();
		OncologicoSteps.completarPlanFonasaIndividual();
		TransversalSteps.calcularPrimaTotal();
		// Completar poliza
		TransversalSteps.completarPoliza(args[10]);
		TransversalSteps.aceptarDocumentosPoliza(); 
		// Crear siniestro
		TransversalSteps.ingresarPolizaBusquedaRapida();
		TransversalSteps.ingresarSiniestroCreateClaim();
		OncologicoSteps.seleccionarProducto();
		// Completar datos siniestro
		TransversalSteps.seleccionFechaSiniestro();
		TransversalSteps.insertarDescripcionHecho(args[15]);
		OncologicoSteps.validarDesplieguePolizasAsociada();
		TransversalSteps.validarIngresoEventoCausa(args[16], args[17]);
		OncologicoSteps.ingresarDeducible(args[18]);
		TransversalSteps.seleccionarLiquidador(args[19]);
		TransversalSteps.seleccionarLugarSiniestro(args[20]);
		TransversalSteps.completarDatosInformante(args[21], args[22], args[23]);
		OncologicoSteps.asistentePreguntas(args[24], args[25], args[26], args[27], args[28], args[29]);
		TransversalSteps.generarSiniestro(args[32]);
		OncologicoSteps.recuperarNumeroSiniestro();

	}

	@Test(priority = 2, enabled = true, dataProvider = "dataOncologico")
	public void ATMOQA70(String[] args) throws InterruptedException {

		test.assignCategory("Oncológico").assignDevice("Siniestros");
		step = test.createNode(
				"Generación de siniestro asociado a una póliza vigente del producto Oncológico con un gestor de siniestros distinto al usuario actual.");

		TransversalSteps.ingresarComoSuscriptor(userSuscriptor, passSuscriptor);
		TransversalSteps.buscarEntidad(args[0], args[1]);
		// Crear nueva póliza
		TransversalSteps.crearPolizaDiaAnterior(args[2], args[3]);
		TransversalSteps.identificarMismoAsegurado();
		OncologicoSteps.completarPlanFonasaIndividual();
		TransversalSteps.calcularPrimaTotal();
		// completar poliza
		TransversalSteps.completarPoliza(args[10]);
		TransversalSteps.aceptarDocumentosPoliza();
		// completar datos siniestro
		TransversalSteps.ingresarPolizaBusquedaRapida();
		TransversalSteps.ingresarSiniestroCreateClaim();
		OncologicoSteps.seleccionarProducto();
		TransversalSteps.seleccionFechaSiniestro();
		TransversalSteps.insertarDescripcionHecho(args[15]);
		OncologicoSteps.validarDesplieguePolizasAsociada();
		TransversalSteps.validarIngresoEventoCausa(args[16], args[17]);
		OncologicoSteps.gestorSiniestro(args[30]);
		OncologicoSteps.ingresarDeducible(args[18]);
		TransversalSteps.seleccionarLiquidador(args[19]);
		TransversalSteps.seleccionarLugarSiniestro(args[20]);
		TransversalSteps.completarDatosInformante(args[21], args[22], args[23]);
		OncologicoSteps.asistentePreguntas(args[24], args[25], args[26], args[27], args[28], args[29]);
		TransversalSteps.generarSiniestro(args[32]);
		OncologicoSteps.recuperarNumeroSiniestro();

	}

	@Test(priority = 3, enabled = true, dataProvider = "dataOncologico")
	public void ATMOQA71(String[] args)
			throws InterruptedException {

		test.assignCategory("Oncológico").assignDevice("Siniestros");
		step = test.createNode(
				"Agregar nuevo ítem de costo a un siniestro asociado a una póliza vigente del producto Oncológico con Liquidador Directo.");

		TransversalSteps.ingresarComoSuscriptor(userSuscriptor, passSuscriptor);
		TransversalSteps.buscarEntidad(args[0], args[1]);
		// Crear nueva póliza
		TransversalSteps.crearPolizaDiaAnterior(args[2], args[3]);
		TransversalSteps.identificarMismoAsegurado();
		OncologicoSteps.completarPlanFonasaIndividual();
		TransversalSteps.calcularPrimaTotal();
		// completar poliza
		TransversalSteps.completarPoliza(args[10]);
		TransversalSteps.aceptarDocumentosPoliza();
		// completar datos siniestro
		TransversalSteps.ingresarPolizaBusquedaRapida();
		TransversalSteps.ingresarSiniestroCreateClaim();
		OncologicoSteps.seleccionarProducto();
		TransversalSteps.seleccionFechaSiniestro();
		TransversalSteps.insertarDescripcionHecho(args[15]);
		OncologicoSteps.validarDesplieguePolizasAsociada();
		TransversalSteps.validarIngresoEventoCausa(args[16], args[17]);
		OncologicoSteps.ingresarDeducible(args[18]);
		TransversalSteps.seleccionarLiquidador(args[19]);
		TransversalSteps.seleccionarLugarSiniestro(args[20]);
		TransversalSteps.completarDatosInformante(args[21], args[22], args[23]);
		OncologicoSteps.asistentePreguntas(args[24], args[25], args[26], args[27], args[28], args[29]);
		TransversalSteps.generarSiniestro(args[32]);
		OncologicoSteps.recuperarNumeroSiniestro();
		OncologicoSteps.seleccionarModuloReservasPagos();

		TransversalSteps.ajustarValorReserva(args[33]);
		TransversalSteps.guardarReserva();

		OncologicoSteps.crearReservaOnco(args[34], args[35], args[36], args[37]);
		OncologicoSteps.validarNumeroCobertura();
		OncologicoSteps.validarDescripcionCobertura();
		OncologicoSteps.validarNumSubCobertura();
		OncologicoSteps.validarDescripcion();
		OncologicoSteps.validarNombreDestinatario();
		OncologicoSteps.validarRol();
		OncologicoSteps.validarMoneda();
		TransversalSteps.guardarReserva();
		OncologicoSteps.validarPaid();
		OncologicoSteps.validarEstado();

	}

	@Test(priority = 4, enabled = true, dataProvider = "dataOncologico")
	public void ATMOQA72(
			String[] args) throws InterruptedException {

		test.assignCategory("Oncológico").assignDevice("Siniestros");
		step = test.createNode(
				"Liquidar en su totalidad un ítem de costo a un siniestro asociado a una póliza vigente del producto Oncológico.");

		TransversalSteps.ingresarComoSuscriptor(userSuscriptor, passSuscriptor);
		TransversalSteps.buscarEntidad(args[0], args[1]);
		// Crear nueva póliza
		TransversalSteps.crearPolizaDiaAnterior(args[2], args[3]);
		TransversalSteps.identificarMismoAsegurado();
		OncologicoSteps.completarPlanFonasaIndividual();
		TransversalSteps.calcularPrimaTotal();
		// completar poliza
		TransversalSteps.completarPoliza(args[10]);
		TransversalSteps.aceptarDocumentosPoliza();
		// completar datos siniestro
		TransversalSteps.ingresarPolizaBusquedaRapida();
		TransversalSteps.ingresarSiniestroCreateClaim();
		OncologicoSteps.seleccionarProducto();
		TransversalSteps.seleccionFechaSiniestro();
		TransversalSteps.insertarDescripcionHecho(args[15]);
		OncologicoSteps.validarDesplieguePolizasAsociada();
		TransversalSteps.validarIngresoEventoCausa(args[16], args[17]);
		OncologicoSteps.ingresarDeducible(args[18]);
		TransversalSteps.seleccionarLiquidador(args[19]);
		TransversalSteps.seleccionarLugarSiniestro(args[20]);
		TransversalSteps.completarDatosInformante(args[21], args[22], args[23]);
		OncologicoSteps.asistentePreguntas(args[24], args[25], args[26], args[27], args[28], args[29]);
		TransversalSteps.generarSiniestro(args[32]);
		OncologicoSteps.recuperarNumeroSiniestro();
		OncologicoSteps.seleccionarModuloReservasPagos();
		OncologicoSteps.seleccionarItemPago();
		OncologicoSteps.liquidarItemPago();
		OncologicoSteps.aceptarReceptor();
		OncologicoSteps.itemPago(args[38]);
		OncologicoSteps.especificacionPago(args[39]);
		OncologicoSteps.aprobarPago();
		OncologicoSteps.validarItemPagoCerrado();
	}

	@DataProvider(name = "dataOncologico")
	public Object[][] dataOncologico() throws CsvValidationException, InterruptedException, IOException {

		Object[][] data = OpenCSV.getCSVParametersDescription("siniestros" + File.separator + "CSVDataOncologico.csv",
				1, 40);
		return data;
	}
}