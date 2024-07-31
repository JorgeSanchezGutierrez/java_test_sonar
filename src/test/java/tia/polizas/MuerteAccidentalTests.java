package test.java.tia.polizas;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.exceptions.CsvValidationException;

import main.java.config.OpenCSV;
import main.java.pageSteps.tia.productos.MuerteAccidentalSteps;
import main.java.pageSteps.tia.transversal.TransversalSteps;
import test.java.BaseTest;

public class MuerteAccidentalTests extends BaseTest {
	
	@Test(priority = 1, enabled = true, dataProvider = "dataMuerteAccidental")
	public void ATMOQA12(String args[]) throws InterruptedException {

		test.assignCategory("Muerte_Accidental").assignDevice("Emision_Poliza");
		step = test.createNode("Emisión de póliza en TIA para producto Muerte Accidental con Plan de cobertura Plan 1 con comision y 1 beneficiario");

		TransversalSteps.ingresarComoSuscriptor(userSuscriptor, passSuscriptor);
		TransversalSteps.buscarEntidad(args[0], args[1]);
		TransversalSteps.crearPoliza(args[2], args[3]);
		MuerteAccidentalSteps.datosPlanes();
		MuerteAccidentalSteps.datosRiesgos();
		MuerteAccidentalSteps.datosBeneficiarios(args[4], args[5], args[6]);
		TransversalSteps.calcularPrimaTotal();
		TransversalSteps.completarPoliza(args[7]);
		TransversalSteps.aceptarDocumentosPoliza();
	}
	
	@Test(priority = 2, enabled = true, dataProvider = "dataMuerteAccidental")
	public void ATMOQA14(String args[]) throws InterruptedException {

		test.assignCategory("Muerte_Accidental").assignDevice("Emision_Poliza");
		step = test.createNode("Emisión de póliza en TIA para producto Muerte Accidental con Plan de cobertura Plan 2 con comision y 1 beneficiario");

		TransversalSteps.ingresarComoSuscriptor(userSuscriptor, passSuscriptor);
		TransversalSteps.buscarEntidad(args[0], args[1]);
		TransversalSteps.crearPoliza(args[2], args[3]);
		MuerteAccidentalSteps.datosPlanes2();
		MuerteAccidentalSteps.datosRiesgos();
		MuerteAccidentalSteps.datosBeneficiarios(args[4], args[5], args[6]);
		TransversalSteps.calcularPrimaTotal();
		TransversalSteps.completarPoliza(args[7]);
		TransversalSteps.aceptarDocumentosPoliza();
	}
	
	@Test(priority = 3, enabled = true, dataProvider = "dataMuerteAccidental")
	public void ATMOQA16(String args[]) throws InterruptedException {

		test.assignCategory("Muerte_Accidental").assignDevice("Emision_Poliza");
		step = test.createNode("Emisión de póliza en TIA para producto Muerte Accidental con Plan de cobertura Plan 1 sin comision y 1 beneficiario");

		TransversalSteps.ingresarComoSuscriptor(userSuscriptor, passSuscriptor);
		TransversalSteps.buscarEntidad(args[0], args[1]);
		TransversalSteps.crearPoliza(args[2], args[3]);
		MuerteAccidentalSteps.datosPlanes();
		MuerteAccidentalSteps.datosBeneficiarios(args[4], args[5], args[6]);
		TransversalSteps.calcularPrimaTotal();
		TransversalSteps.completarPoliza(args[7]);
		TransversalSteps.aceptarDocumentosPoliza();
	}
	
	@Test(priority = 4, enabled = true, dataProvider = "dataMuerteAccidental")
	public void ATMOQA17(String args[]) throws InterruptedException {

		test.assignCategory("Muerte_Accidental").assignDevice("Emision_Poliza");
		step = test.createNode("Emisión de póliza en TIA para producto Muerte Accidental con Plan de cobertura Plan 2 sin comision y 1 beneficiario");

		TransversalSteps.ingresarComoSuscriptor(userSuscriptor, passSuscriptor);
		TransversalSteps.buscarEntidad(args[0], args[1]);
		TransversalSteps.crearPoliza(args[2], args[3]);
		MuerteAccidentalSteps.datosPlanes2();
		MuerteAccidentalSteps.datosBeneficiarios(args[4], args[5], args[6]);
		TransversalSteps.calcularPrimaTotal();
		TransversalSteps.completarPoliza(args[7]);
		TransversalSteps.aceptarDocumentosPoliza();
	}
	
	@DataProvider(name = "dataMuerteAccidental")
	public Object[][] dataMuerteAccidental() throws CsvValidationException, InterruptedException, IOException {

		Object[][] data = OpenCSV.getCSVParametersDescription("emision" + File.separator + "CSVDataMuerteAccidental.csv", 1, 8);
		return data;
	}

}
