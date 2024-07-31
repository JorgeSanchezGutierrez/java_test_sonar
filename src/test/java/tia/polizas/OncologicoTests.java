package test.java.tia.polizas;

import main.java.pageSteps.tia.productos.OncologicoSteps;
import main.java.pageSteps.tia.transversal.TransversalSteps;
import main.java.config.OpenCSV;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.exceptions.CsvValidationException;

import test.java.BaseTest;

public class OncologicoTests extends BaseTest {

	@Test(priority = 1, enabled = true, dataProvider = "dataOncologico")
	public void ATMOQA63(String[] args) {

		test.assignCategory("Oncológico").assignDevice("Emision_Poliza");
		step = test.createNode("Emisión de póliza en TIA de un plan Fonasa Individual con mismo asegurado y contratante");

		TransversalSteps.ingresarComoSuscriptor(userSuscriptor, passSuscriptor);
		TransversalSteps.buscarEntidad(args[0], args[1]);
		TransversalSteps.crearPoliza(args[2], args[3]);
		TransversalSteps.identificarMismoAsegurado();
		OncologicoSteps.completarPlanFonasaIndividual();
		TransversalSteps.calcularPrimaTotal();
		TransversalSteps.completarPoliza(args[10]);

	}

	@Test(priority = 2, enabled = true, dataProvider = "dataOncologico")
	public void ATMOQA64(String args[]) throws InterruptedException {

		test.assignCategory("Oncológico").assignDevice("Emision_Poliza");
		step = test.createNode("Emisión de póliza en TIA de un plan Fonasa Familiar con distinto asegurado y contratante");

		TransversalSteps.ingresarComoSuscriptor(userSuscriptor, passSuscriptor);
		TransversalSteps.buscarEntidad(args[0], args[1]);
		TransversalSteps.crearPoliza(args[2], args[3]);
		TransversalSteps.identificarDiferenteAsegurado(args[4], args[5]);
		OncologicoSteps.completarPlanFonasaFamiliar();
		TransversalSteps.calcularPrimaTotal();
		OncologicoSteps.agregarAseguradoAdicional(args[7], args[8], args[9]);
		TransversalSteps.completarPoliza(args[10]);
	}

	@Test(priority = 3, enabled = true, dataProvider = "dataOncologico")
	public void ATMOQA65(String args[]) throws InterruptedException {

		test.assignCategory("Oncológico").assignDevice("Emision_Poliza");
		step = test.createNode("Emisión de póliza en TIA de un plan Isapre Individual con mismo asegurado y contratante aplicando un descuento");

		TransversalSteps.ingresarComoSuscriptor(userSuscriptor, passSuscriptor);
		TransversalSteps.buscarEntidad(args[0], args[1]);
		TransversalSteps.crearPolizaOncoDsct(args[2], args[3]);
		OncologicoSteps.incluirDescuentoOnco(args[11], args[14]);
		TransversalSteps.identificarMismoAsegurado();
		OncologicoSteps.completarPlanIsapreIndividual(args[6]);
		OncologicoSteps.calcularPrimaTotalOncoDsct();
		TransversalSteps.completarPoliza(args[10]);
		TransversalSteps.cancelarPoliza();
	}

	@Test(priority = 4, enabled = true, dataProvider = "dataOncologico")
	public void ATMOQA66(String args[]) throws InterruptedException {

		test.assignCategory("Oncológico").assignDevice("Emision_Poliza");
		step = test.createNode("Emisión de póliza en TIA de un plan Isapre Familiar con mismo asegurado y contratante");

		TransversalSteps.ingresarComoSuscriptor(userSuscriptor, passSuscriptor);
		TransversalSteps.buscarEntidad(args[0], args[1]);
		TransversalSteps.crearPoliza(args[2], args[3]);
		TransversalSteps.identificarDiferenteAsegurado(args[4], args[5]);
		OncologicoSteps.completarPlanIsapreFamiliar(args[6]);
		TransversalSteps.calcularPrimaTotal();
		OncologicoSteps.agregarAseguradoAdicional(args[7], args[8], args[9]);
		TransversalSteps.completarPoliza(args[10]);
	}

	@Test(priority = 5, enabled = true, dataProvider = "dataOncologico")
	public void ATMOQA67(String args[]) throws InterruptedException {

		test.assignCategory("Oncológico").assignDevice("Emision_Poliza");
		step = test.createNode("Emisión de póliza en TIA donde el contratante sea menor de edad");

		TransversalSteps.ingresarComoSuscriptor(userSuscriptor, passSuscriptor);
		TransversalSteps.buscarEntidad(args[7], args[8]);
		TransversalSteps.crearPoliza(args[2], args[3]);
		TransversalSteps.identificarMismoAsegurado();
		OncologicoSteps.completarPlanFonasaIndividual();
		TransversalSteps.validarMensajeContratanteMenorEdad(args[10]);
	}

	@Test(priority = 6, enabled = true, dataProvider = "dataOncologico")
	public void ATMOQA68(String args[]) throws InterruptedException {

		test.assignCategory("Oncológico").assignDevice("Emision_Poliza");
		step = test.createNode("Emisión de póliza en TIA donde el contratante tenga fecha de fallecimiento");

		TransversalSteps.ingresarComoSuscriptor(userSuscriptor, passSuscriptor);
		TransversalSteps.buscarEntidad(args[12], args[13]);
		TransversalSteps.crearPoliza(args[2], args[3]);
		TransversalSteps.identificarMismoAsegurado();
		OncologicoSteps.completarPlanFonasaIndividual();
		TransversalSteps.validarMensajeContratanteFallecido(args[10]);
	}

	@Test(priority = 7, enabled = true, dataProvider = "dataOncologico")
	public void ATMOQA151(String[] args) {

		test.assignCategory("Oncológico").assignDevice("Emision_Poliza");
		step = test.createNode("Emisión de póliza intermediada con canal de venta \"Brokers\" y plataforma \"Marsh\" en TIA de un plan Fonasa Individual.");

		TransversalSteps.ingresarComoSuscriptor(userSuscriptor, passSuscriptor);
		TransversalSteps.buscarEntidad(args[0], args[1]);
		TransversalSteps.crearPolizaIntermediador(args[2], args[15], args[18], args[20]);
//		TransversalSteps.identificarMismoAsegurado();
//		OncologicoSteps.completarPlanFonasaIndividual();
//		TransversalSteps.calcularPrimaTotal();
//		TransversalSteps.completarPoliza(args[10]);

	}

	@DataProvider(name = "dataOncologico")
	public Object[][] dataOncologico() throws CsvValidationException, InterruptedException, IOException {

		Object[][] data = OpenCSV.getCSVParametersDescription("emision" + File.separator + "CSVDataOncologico.csv", 1,
				22);
		return data;
	}
}
