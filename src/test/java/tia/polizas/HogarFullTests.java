package test.java.tia.polizas;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.exceptions.CsvValidationException;

import main.java.config.OpenCSV;
import main.java.pageSteps.tia.productos.HogarFullSteps;
import main.java.pageSteps.tia.transversal.TransversalSteps;
import test.java.BaseTest;

public class HogarFullTests extends BaseTest {
	@Test(priority = 1, enabled = true,  dataProvider = "dataHogarFull")
	public void ATMOQA10(String[] args) {

		test.assignCategory("Hogar_Full").assignDevice("Emision_Poliza");
		step = test.createNode("Emisión de póliza en TIA asegurando una propiedad de tipo casa en condominio sin coberturas ni asistencias adicionales");

		TransversalSteps.ingresarComoSuscriptor(userSuscriptor, passSuscriptor);
        TransversalSteps.buscarEntidad(args[0], args[1]);
        TransversalSteps.crearPoliza(args[2], args[3]);
		HogarFullSteps.seleccionarTipoContratante(args[4]);
		HogarFullSteps.identificarPropiedad(args[5]);
		HogarFullSteps.seleccionarPropiedadCasaCondominio(args[6]);
		HogarFullSteps.completarInformacionPropiedad(args[9], args[10], args[11], args[12]);
		HogarFullSteps.seleccionarCoberturaIncendio(args[13],args[14]);
		TransversalSteps.calcularPrimaTotal();
		TransversalSteps.completarPoliza(args[15]);
		TransversalSteps.aceptarDocumentosPoliza();
		
	}
	
	@Test(priority = 2, enabled = true,  dataProvider = "dataHogarFull")
	public void ATMOQA19(String[] args) {
		test.assignCategory("Hogar_Full").assignDevice("Emision_Poliza");
		step = test.createNode("Emisión de póliza en TIA asegurando una propiedad de tipo departamento con cobertura adicional de Robo");
		TransversalSteps.ingresarComoSuscriptor(userSuscriptor, passSuscriptor);
        TransversalSteps.buscarEntidad(args[0], args[1]);
        TransversalSteps.crearPoliza(args[2], args[3]);
		HogarFullSteps.seleccionarTipoContratante(args[4]);
		HogarFullSteps.identificarPropiedad(args[5]);
		HogarFullSteps.seleccionarPropiedadDepartamento(args[7], args[8]);
		HogarFullSteps.completarInformacionPropiedad(args[9], args[10], args[11], args[12]);
		HogarFullSteps.seleccionarCoberturaIncendio(args[13],args[14]);
		HogarFullSteps.agregarCoberturaRoboContenido(args[18]);
		TransversalSteps.calcularPrimaTotal();
		TransversalSteps.completarPoliza(args[15]);
		TransversalSteps.aceptarDocumentosPoliza();
	}
	
	@Test(priority = 3, enabled = true,  dataProvider = "dataHogarFull")
	public void ATMOQA21(String[] args) {
		test.assignCategory("Hogar_Full").assignDevice("Emision_Poliza");
		step = test.createNode("Emisión de póliza en TIA asegurando una propiedad añadiendo todas las coberturas y asistencias adicionales");
		TransversalSteps.ingresarComoSuscriptor(userSuscriptor, passSuscriptor);
        TransversalSteps.buscarEntidad(args[0], args[1]);
        TransversalSteps.crearPoliza(args[2], args[3]);
		HogarFullSteps.seleccionarTipoContratante(args[4]);
		HogarFullSteps.identificarPropiedad(args[5]);
		HogarFullSteps.seleccionarPropiedadDepartamento(args[7], args[8]);
		HogarFullSteps.completarInformacionPropiedad(args[9], args[10], args[11], args[12]);
		HogarFullSteps.seleccionarCoberturaIncendio(args[13],args[14]);
		HogarFullSteps.ampliarVentana();
		HogarFullSteps.agregarCoberturaRoboContenido(args[18]);
		HogarFullSteps.agregarCoberturaSismo();
		HogarFullSteps.agregarCoberturaReembolsoGastosMedicos();
		HogarFullSteps.agregarAsistenciaCyber();
		HogarFullSteps.agregarAsistenciaMascotas();
		HogarFullSteps.agregarAsistenciaTelemedicina();
		HogarFullSteps.unirVentana();
		TransversalSteps.calcularPrimaTotal();
		TransversalSteps.completarPoliza(args[15]);
		TransversalSteps.aceptarDocumentosPoliza();
	}

	@DataProvider(name = "dataHogarFull")
	public Object[][] dataHogarFull() throws CsvValidationException, InterruptedException, IOException {

		Object[][] data = OpenCSV.getCSVParametersDescription("emision" + File.separator + "CSVDataHogarFull.csv", 1, 19);
		return data;
	}
}
