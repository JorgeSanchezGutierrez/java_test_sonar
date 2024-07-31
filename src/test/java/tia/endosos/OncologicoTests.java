package test.java.tia.endosos;

import java.io.File;
import java.io.IOException;

import org.apache.commons.collections.functors.FalsePredicate;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.exceptions.CsvValidationException;

import main.java.config.OpenCSV;
import main.java.pageSteps.tia.productos.OncologicoSteps;
import main.java.pageSteps.tia.transversal.TransversalSteps;
import test.java.BaseTest;

public class OncologicoTests extends BaseTest{
	
	@Test(priority = 1, enabled = true,  dataProvider = "dataOncologico")
	public void ATMOQA74(String[] args) {

		test.assignCategory("Oncológico").assignDevice("Endoso_Poliza");
		step = test.createNode("Generación de un Endoso, modificando el plan de fonasa a isapre luego de emitir una póliza.");

		TransversalSteps.ingresarComoSuscriptor(userSuscriptor, passSuscriptor);
		TransversalSteps.buscarEntidad(args[0], args[1]);
		TransversalSteps.crearPoliza(args[2], args[3]);
		TransversalSteps.identificarMismoAsegurado();
		OncologicoSteps.completarPlanFonasaIndividual();
		TransversalSteps.calcularPrimaTotal();
		TransversalSteps.completarPoliza(args[10]);
		TransversalSteps.aceptarDocumentosPoliza();
		//completar datos endoso
  		TransversalSteps.ingresarPolizaBusquedaRapida();
	    TransversalSteps.ingresarTipoEndoso(args[14]);
        TransversalSteps.ingresarObjeto();
        TransversalSteps.ajustarObjeto();
		OncologicoSteps.completarPlanIsapreFamiliar(args[6]);
		OncologicoSteps.agregarAseguradoAdicionalCambioTarifa(args[15], args[16], args[17]);
		TransversalSteps.calcularPrimaTotal();
		TransversalSteps.completarPoliza(args[18]);
		TransversalSteps.aceptarDocumentosPoliza();
		 //validar endoso
        TransversalSteps.validarEndoso();
	}

	@Test(priority = 2, enabled = false, dataProvider = "dataOncologico")
	public void EmisionPolizaFonasaFamiliar(String args[]) throws InterruptedException {

		test.assignCategory("Oncológico").assignDevice("Endosos");
		step = test.createNode("Emisión de póliza en TIA de un plan Fonasa Familiar con distinto asegurado y contratante");
		
		TransversalSteps.ingresarComoSuscriptor(userSuscriptor, passSuscriptor);
		TransversalSteps.buscarEntidad(args[0], args[1]);
		TransversalSteps.crearPoliza(args[2], args[3]);
		TransversalSteps.identificarDiferenteAsegurado(args[4], args[5]);
		OncologicoSteps.completarPlanFonasaFamiliar();
		TransversalSteps.calcularPrimaTotal();
		OncologicoSteps.agregarAseguradoAdicional(args[7], args[8], args[9]);
		TransversalSteps.completarPoliza(args[10]);
		TransversalSteps.aceptarDocumentosPoliza();
		//completar datos endoso
  		TransversalSteps.ingresarPoliza();
	    TransversalSteps.ingresarTipoEndoso(args[14]);
        TransversalSteps.ingresarObjeto();
        TransversalSteps.ajustarObjeto();
        OncologicoSteps.completarPlanFonasaFamiliar();
		TransversalSteps.calcularPrimaTotal();
		OncologicoSteps.agregarAseguradoAdicional(args[15], args[16], args[17]);
        TransversalSteps.completarPoliza(args[18]);
		TransversalSteps.aceptarDocumentosPoliza();
		 //validar endoso
        TransversalSteps.validarEndoso();
	}
	
	@DataProvider(name = "dataOncologico")
	public Object[][] dataOncologico() throws CsvValidationException, InterruptedException, IOException {

		Object[][] data = OpenCSV.getCSVParametersDescription("endosos" + File.separator + "CSVDataOncologico.csv", 1, 19);
		return data;
	}
}
