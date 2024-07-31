package test.java.portalSB.emision;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.exceptions.CsvValidationException;

import test.java.BaseTest;
import main.java.config.OpenCSV;
import main.java.pageEvents.portalSB.transversal.TransversalPortalSBEvents;
import main.java.pageEvents.tia.transversal.TransversalEvents;
import main.java.pageSteps.portalSB.productos.MascotaSaludPortalSBSteps;
import main.java.pageSteps.portalSB.transversal.TransversalPortalSBSteps;
import main.java.pageSteps.tia.transversal.TransversalSteps;
import main.java.properties.EntidadProperties;

public class MascotaSaludPortalSBTests extends BaseTest{

	@Test(priority = 1, enabled = true, dataProvider = "dataMascotasSalud")
	public void prueba123 (String args[])  throws InterruptedException{
        test.assignCategory("MascotaPortalSB").assignDevice("Emisión");
        step = test.createNode("prueba de ejecucion");
        TransversalPortalSBSteps.validarAmbientePortalSB("Mascota");
        TransversalPortalSBSteps.ingresarNombreApellido(args[0],args[1]);
        TransversalPortalSBSteps.ingresarCorreo(args[2]);
        TransversalPortalSBSteps.aprobarTerminoCondiciones();
        TransversalPortalSBSteps.avanzarSiguientePagina("mascota");
        MascotaSaludPortalSBSteps.datosMascota("Andres","perro", "golden retriever", "8 meses", "Macho");
        TransversalPortalSBSteps.avanzarSiguientePagina("plan");
        TransversalPortalSBSteps.seleccionarPlan("BÁSICO", "0,54","Datos");
        TransversalPortalSBSteps.rellenarFormularioInfo("1998","febrero", "23", "36521478", "19.509.337-7", "12356789" ,"lebreles" , "8682", "", "Metropolitana de santiago", "pudahuel");
        TransversalPortalSBSteps.avanzarResumen();
        MascotaSaludPortalSBSteps.resumenContratacion();
        TransversalPortalSBSteps.aprobarTerminoCondiciones();
        TransversalPortalSBSteps.irPagar("credito","4051885600446623","12/28","123","TEST COMMERCE BANK", "11.111.111-1","123");
        MascotaSaludPortalSBSteps.confirmacionPoliza();
        TransversalSteps.ingresarComoSuscriptor(userSuscriptor, passSuscriptor);
        TransversalSteps.busquedaRapidaElemento(EntidadProperties.rutContratante.replace(".", ""));
	}
	@DataProvider(name = "dataMascotasSalud")
	public Object[][] dataMascotasSalud() throws CsvValidationException, InterruptedException, IOException {

		Object[][] data = OpenCSV.getCSVParametersDescription("portalSB" + File.separator + "CSVDataMascotasSalud.csv",1, 4);
		return data;
	}
}
