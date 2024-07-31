package test.java.tia.cancelacion;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.exceptions.CsvValidationException;

import main.java.config.OpenCSV;
import main.java.pageSteps.tia.productos.MuerteAccidentalSteps;
import main.java.pageSteps.tia.transversal.TransversalSteps;
import test.java.BaseTest;

public class MuerteAccidentalTests extends BaseTest{
	@Test(priority = 1, enabled = true, dataProvider = "dataMuerteAccidental")
	public void ATMOQA53(String args[]) throws InterruptedException {
	
		test.assignCategory("Muerte_Accidental").assignDevice("Cancelacion");
		step = test.createNode("Cancelacion por Cancelación desistimiento del asegurado - Retracto de póliza en TIA con cobertura Plan");
		TransversalSteps.ingresarComoSuscriptor(userSuscriptor, passSuscriptor);
		TransversalSteps.buscarEntidad(args[0], args[1]);
		MuerteAccidentalSteps.crearPolizaAP(args[2], args[3]);
		MuerteAccidentalSteps.datosPlanes2();
		MuerteAccidentalSteps.datosRiesgos();
		MuerteAccidentalSteps.datosBeneficiarios(args[4], args[5], args[6]);
		TransversalSteps.calcularPrimaTotal();
		TransversalSteps.completarPoliza(args[7]);
		TransversalSteps.aceptarDocumentosPoliza();
		//cancelar poliza
		TransversalSteps.ingresarPolizaBusquedaRapida();
		TransversalSteps.ajustaPolizaTrans("402");
		MuerteAccidentalSteps.seleccionaCancelacionPoliza(args[8]);
		MuerteAccidentalSteps.validarEstadoCancelacionPoliza();
	}
	
	
	@Test(priority = 2, enabled = true, dataProvider = "dataMuerteAccidental")
    public void ATMOQA54(String args[]) throws InterruptedException {
        test.assignCategory("Muerte_Accidental").assignDevice("Cancelacion");;
        step = test.createNode(
                "Cancelación de una póliza de tipo Muerte Accidental,  dentro de los primeros 10 días de vigencia, con motivo Cancelación por desistimiento del asegurado - Retracto, con una cuota pagada.");
        
        // creando una póliza de AP para cancelarla
        TransversalSteps.ingresarComoSuscriptor(userSuscriptor, passSuscriptor);
		TransversalSteps.buscarEntidad(args[0], args[1]);
		MuerteAccidentalSteps.crearPolizaAP(args[2], args[3]);
		MuerteAccidentalSteps.datosPlanes2();
		MuerteAccidentalSteps.datosRiesgos();
		MuerteAccidentalSteps.datosBeneficiarios(args[4], args[5], args[6]);
		TransversalSteps.calcularPrimaTotal();
		TransversalSteps.completarPoliza(args[7]);
		TransversalSteps.aceptarDocumentosPoliza();

        //pagar una cuota
        TransversalSteps.pagarCuota();

        // ingresar a la poliza para cancelarla
        TransversalSteps.visitarPaginaHome();
        TransversalSteps.buscarEntidad(args[0], args[1]);
        TransversalSteps.ingresarPolizaBusquedaRapida();
        TransversalSteps.ajustaPolizaTrans("402");
        TransversalSteps.seleccionarMotivoCancelacionPoliza(args[8]);
        TransversalSteps.completarPoliza("endoso");
        TransversalSteps.aceptarDocumentosPoliza();

        //valida cancelación
        TransversalSteps.validaTransaccionCancelacionPoliza();

        //valida reversión del pago
        TransversalSteps.visitarPaginaHome();
        TransversalSteps.validarReversionPagoCuota();


    }

	
	@DataProvider(name = "dataMuerteAccidental")
	public Object[][] dataMascotasSalud() throws CsvValidationException, InterruptedException, IOException {
	
		Object[][] data = OpenCSV.getCSVParametersDescription("cancelacion" + File.separator + "CSVDataMuerteAccidental.csv", 1, 9);
		return data;
	}
}
