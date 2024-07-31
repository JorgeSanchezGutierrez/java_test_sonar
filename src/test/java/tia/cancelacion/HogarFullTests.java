package test.java.tia.cancelacion;

import com.opencsv.exceptions.CsvValidationException;
import main.java.config.OpenCSV;
import main.java.pageSteps.tia.productos.HogarFullSteps;
import main.java.pageSteps.tia.transversal.TransversalSteps;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.java.BaseTest;

import java.io.File;
import java.io.IOException;

public class HogarFullTests extends BaseTest  {
        @Test(priority = 1, enabled = true, dataProvider = "dataHogarFull")
        public void ATMOQA87(String args[]) throws InterruptedException {
            test.assignCategory("Hogar_Full").assignDevice("Cancelacion");
            step = test.createNode(
                    "Cancelación de una póliza de tipo Hogar Full, dentro de los primeros 10 días de vigencia, con motivo Cancelación por desistimiento del asegurado - Retracto.");

            TransversalSteps.ingresarComoSuscriptor(userSuscriptor, passSuscriptor);
            TransversalSteps.buscarEntidad(args[0], args[1]);

            // creando una póliza de HF para cancelarla
            TransversalSteps.crearPoliza(args[2], args[3]);
            HogarFullSteps.seleccionarTipoContratante(args[4]);
            HogarFullSteps.identificarPropiedad(args[5]);
            HogarFullSteps.seleccionarPropiedadDepartamentoAlternativo();
            HogarFullSteps.completarInformacionPropiedad(args[6], args[7], args[8], args[9]);
            HogarFullSteps.seleccionarCoberturaIncendio(args[10],args[11]);
            TransversalSteps.calcularPrimaTotal();
            TransversalSteps.completarPoliza(args[12]);
            TransversalSteps.aceptarDocumentosPoliza();

            // ingresar a la póliza para cancelarla
            TransversalSteps.ingresarPolizaBusquedaRapida();
            TransversalSteps.ajustaPolizaTrans("402");
            TransversalSteps.seleccionarMotivoCancelacionPoliza(args[14]);
            TransversalSteps.completarPoliza("endoso");
            TransversalSteps.aceptarDocumentosPoliza();

            //valida cancelación
            TransversalSteps.ingresarPolizaBusquedaRapida();
            HogarFullSteps.validaTransaccionCancelacionPolizaHF();
        }

    @Test(priority = 2, enabled = true, dataProvider = "dataHogarFull")
    public void ATMOQA88(String args[]) throws InterruptedException {
        test.assignCategory("Hogar_Full").assignDevice("Cancelacion");
        step = test.createNode(
                "Cancelación de una póliza de tipo Hogar Full,  dentro de los primeros 10 días de vigencia, con motivo Cancelación por desistimiento del asegurado - Retracto, con una cuota pagada.");

        TransversalSteps.ingresarComoSuscriptor(userSuscriptor, passSuscriptor);
        TransversalSteps.buscarEntidad(args[0], args[1]);

        // creando una póliza de HF para cancelarla
        TransversalSteps.crearPoliza(args[2], args[3]);
        HogarFullSteps.seleccionarTipoContratante(args[4]);
        HogarFullSteps.identificarPropiedad(args[5]);
        HogarFullSteps.seleccionarPropiedadDepartamentoAlternativo();
        HogarFullSteps.completarInformacionPropiedad(args[6], args[7], args[8], args[9]);
        HogarFullSteps.seleccionarCoberturaIncendio(args[10],args[11]);
        TransversalSteps.calcularPrimaTotal();
        TransversalSteps.completarPoliza(args[12]);
        TransversalSteps.aceptarDocumentosPoliza();

        //pagar una cuota
        TransversalSteps.pagarCuota();

        // ingresar a la poliza para cancelarla
        TransversalSteps.ingresarPolizaBusquedaRapida();
        TransversalSteps.ajustaPolizaTrans("402");
        TransversalSteps.seleccionarMotivoCancelacionPoliza(args[14]);
        TransversalSteps.completarPoliza("endoso");
        TransversalSteps.aceptarDocumentosPoliza();

        //valida cancelación
        TransversalSteps.validaTransaccionCancelacionPoliza();

        //valida reversión del pago
        TransversalSteps.visitarPaginaHome();
        TransversalSteps.validarReversionPagoCuota();
    }

    @Test(priority = 3, enabled = true, dataProvider = "dataHogarFull")
    public void ATMOQA89(String args[]) throws InterruptedException {
        test.assignCategory("Hogar_Full").assignDevice("Cancelacion");
        step = test.createNode(
                "Cancelación de una póliza de tipo Hogar Full, dentro de los primeros 10 días de vigencia, con motivo Cancelación a solicitud del asegurado");

        TransversalSteps.ingresarComoSuscriptor(userSuscriptor, passSuscriptor);
        TransversalSteps.buscarEntidad(args[0], args[1]);

        // creando una póliza de HF para cancelarla
        TransversalSteps.crearPoliza(args[2], args[3]);
        HogarFullSteps.seleccionarTipoContratante(args[4]);
        HogarFullSteps.identificarPropiedad(args[5]);
        HogarFullSteps.seleccionarPropiedadDepartamentoAlternativo();
        HogarFullSteps.completarInformacionPropiedad(args[6], args[7], args[8], args[9]);
        HogarFullSteps.seleccionarCoberturaIncendio(args[10],args[11]);
        TransversalSteps.calcularPrimaTotal();
        TransversalSteps.completarPoliza(args[12]);
        TransversalSteps.aceptarDocumentosPoliza();

        // ingresar a la póliza para cancelarla
        TransversalSteps.ingresarPolizaBusquedaRapida();
        TransversalSteps.seleccionarTipoEndosoConDiasPosterior("402");
        TransversalSteps.seleccionarMotivoCancelacionPoliza(args[15]);
        HogarFullSteps.validarMensajeErrorCancelacionHF("endoso");
    }

    @DataProvider(name = "dataHogarFull")
    public Object[][] dataHogarFull() throws CsvValidationException, InterruptedException, IOException {
        Object[][] data = OpenCSV.getCSVParametersDescription("cancelacion" + File.separator + "CSVDataHogarFull.csv", 1, 16);
        return data;
    }
}
