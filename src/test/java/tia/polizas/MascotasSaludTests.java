package test.java.tia.polizas;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.exceptions.CsvValidationException;

import main.java.pageSteps.tia.productos.MascotasSaludSteps;
import main.java.pageSteps.tia.transversal.TransversalSteps;
import main.java.config.OpenCSV;
import test.java.BaseTest;

public class MascotasSaludTests extends BaseTest {

	@Test(priority = 1, enabled = false, dataProvider = "dataMascotasSalud")
	public void ATMOQA38(String args[]) throws InterruptedException {

		test.assignCategory("Mascotas_Salud").assignDevice("Emision_Poliza");
		step = test.createNode(
				"Emisión de póliza en TIA con cobertura Plan de cobertura asegurando una mascota de tipo perro mestizo");

		TransversalSteps.ingresarComoSuscriptor(userSuscriptor, passSuscriptor);
		TransversalSteps.buscarEntidad(args[0], args[1]);
		TransversalSteps.crearPoliza(args[2], args[3]);
		// completar datos objeto
		MascotasSaludSteps.datosMascotas(args[4], args[5], args[6], args[7]);
		MascotasSaludSteps.datosMascotasMestizo();
		MascotasSaludSteps.datosPlan(args[8]);
		TransversalSteps.calcularPrimaTotal();
		// completar poliza
		TransversalSteps.completarPoliza(args[9]);
		TransversalSteps.aceptarDocumentosPoliza();
	}

	@Test(priority = 2, enabled = false, dataProvider = "dataMascotasSalud")
	public void ATMOQA39(String args[]) throws InterruptedException {

		test.assignCategory("Mascotas_Salud").assignDevice("Emision_Poliza");
		step = test.createNode(
				"Emisión de póliza en TIA con cobertura Plan de cobertura asegurando una mascota de tipo perro raza");

		TransversalSteps.ingresarComoSuscriptor(userSuscriptor, passSuscriptor);
		TransversalSteps.buscarEntidad(args[0], args[1]);
		TransversalSteps.crearPoliza(args[2], args[3]);
		// completar datos objeto
		MascotasSaludSteps.datosMascotas(args[4], args[5], args[6], args[7]);
		MascotasSaludSteps.datosMascotasRaza(args[10]);
		MascotasSaludSteps.datosPlan(args[8]);
		TransversalSteps.calcularPrimaTotal();
		// comlpetar poliza
		TransversalSteps.completarPoliza(args[9]);
		TransversalSteps.aceptarDocumentosPoliza();
	}

	@Test(priority = 3, enabled = false, dataProvider = "dataMascotasSalud")
	public void ATMOQA40(String args[]) throws InterruptedException {

		test.assignCategory("Mascotas_Salud").assignDevice("Emision_Poliza");
		step = test.createNode(
				"Emisión de póliza en TIA con cobertura Plan de cobertura asegurando una mascota de tipo perro mestizo, añadiendo cremación");

		TransversalSteps.ingresarComoSuscriptor(userSuscriptor, passSuscriptor);
		TransversalSteps.buscarEntidad(args[0], args[1]);
		TransversalSteps.crearPoliza(args[2], args[3]);
		// completar datos objeto
		MascotasSaludSteps.datosMascotas(args[4], args[5], args[6], args[7]);
		MascotasSaludSteps.datosMascotasRaza(args[10]);
		MascotasSaludSteps.datosPlan(args[8]);
		MascotasSaludSteps.seleccionCremacion();
		TransversalSteps.calcularPrimaTotal();
		// comlpetar poliza
		TransversalSteps.completarPoliza(args[9]);
		TransversalSteps.aceptarDocumentosPoliza();
	}

	@Test(priority = 4, enabled = false, dataProvider = "dataMascotasSalud")
	public void ATMOQA41(String args[]) throws InterruptedException {

		test.assignCategory("Mascotas_Salud").assignDevice("Emision_Poliza");
		step = test.createNode(
				"Emisión de póliza en TIA con cobertura Plan de cobertura asegurando una mascota de tipo perro mestizo, añadiendo examenes");

		TransversalSteps.ingresarComoSuscriptor(userSuscriptor, passSuscriptor);
		TransversalSteps.buscarEntidad(args[0], args[1]);
		TransversalSteps.crearPoliza(args[2], args[3]);
		// completar datos objeto
		MascotasSaludSteps.datosMascotas(args[4], args[5], args[6], args[7]);
		MascotasSaludSteps.datosMascotasRaza(args[10]);
		MascotasSaludSteps.datosPlan(args[8]);
		MascotasSaludSteps.seleccionExamenes();
		TransversalSteps.calcularPrimaTotal();
		// comlpetar poliza
		TransversalSteps.completarPoliza(args[9]);
		TransversalSteps.aceptarDocumentosPoliza();
	}

	@Test(priority = 5, enabled = false, dataProvider = "dataMascotasSalud")
	public void ATMOQA42(String args[]) throws InterruptedException {

		test.assignCategory("Mascotas_Salud").assignDevice("Emision_Poliza");
		step = test.createNode(
				"Emisión de póliza en TIA con cobertura Plan de cobertura asegurando una mascota de tipo perro mestizo, añadiendo examenes y cremación");

		TransversalSteps.ingresarComoSuscriptor(userSuscriptor, passSuscriptor);
		TransversalSteps.buscarEntidad(args[0], args[1]);
		TransversalSteps.crearPoliza(args[2], args[3]);
		// completar datos objeto
		MascotasSaludSteps.datosMascotas(args[4], args[5], args[6], args[7]);
		MascotasSaludSteps.datosMascotasMestizo();
		MascotasSaludSteps.datosPlan(args[8]);
		MascotasSaludSteps.seleccionCremacion();
		MascotasSaludSteps.seleccionExamenes();
		TransversalSteps.calcularPrimaTotal();
		// comlpetar poliza
		TransversalSteps.completarPoliza(args[9]);
		TransversalSteps.aceptarDocumentosPoliza();
	}

	@Test(priority = 6, enabled = true, dataProvider = "dataMascotasSalud")
	public void ATMOQA37(String args[]) throws InterruptedException {

		test.assignCategory("Mascotas_Salud").assignDevice("Emision_Poliza");
		step = test.createNode(
				"Emisión de póliza en TIA con cobertura Plan de cobertura asegurando una mascota de tipo perro mestizo con un asegurador menor de edad");

		TransversalSteps.ingresarComoSuscriptor(userSuscriptor, passSuscriptor);
		TransversalSteps.buscarEntidad("Lamen Orcita", "Anita Lamen Orcita");
		TransversalSteps.crearPoliza(args[2], args[3]);
		// completar datos objeto
		MascotasSaludSteps.datosMascotas(args[4], args[5], args[6], args[7]);
		MascotasSaludSteps.datosMascotasMestizo();
		MascotasSaludSteps.datosPlan(args[8]);
		TransversalSteps.validarMensajeContratanteMenorEdad(args[9]);
	}

	@Test(priority = 7, enabled = false, dataProvider = "dataMascotasSalud")
	public void ATMOQA43(String args[]) throws InterruptedException {

		test.assignCategory("Mascotas_Salud").assignDevice("Emision_Poliza");
		step = test.createNode(
				"Emisión de póliza en TIA con cobertura Plan de cobertura asegurando una mascota de tipo perro mestizo con un asegurador fallecido");

		TransversalSteps.ingresarComoSuscriptor(userSuscriptor, passSuscriptor);
		TransversalSteps.buscarEntidad("El Fallecido", "Juan Antonio El Fallecido");
		TransversalSteps.crearPoliza(args[2], args[3]);
		// completar datos objeto
		MascotasSaludSteps.datosMascotas(args[4], args[5], args[6], args[7]);
		MascotasSaludSteps.datosMascotasMestizo();
		MascotasSaludSteps.datosPlan(args[8]);
		TransversalSteps.validarMensajeContratanteFallecido(args[9]);
	}

	@DataProvider(name = "dataMascotasSalud")
	public Object[][] dataMascotasSalud() throws CsvValidationException, InterruptedException, IOException {

		Object[][] data = OpenCSV.getCSVParametersDescription("emision" + File.separator + "CSVDataMascotasSalud.csv",
				1, 13);
		return data;
	}
}
