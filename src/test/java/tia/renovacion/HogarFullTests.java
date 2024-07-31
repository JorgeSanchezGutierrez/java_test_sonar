package test.java.tia.renovacion;


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

    @Test(priority = 1, enabled = true, dataProvider = "dataHogarFull")
    public void ATMOQA23(String args[]) throws InterruptedException {
        test.assignCategory("Hogar_Full").assignDevice("Renovacion");
        step = test.createNode(
                "Renovación manual de una póliza de tipo Hogar Full en la plataforma TIA cumplido el año de vigencia.");

        TransversalSteps.ingresarComoSuscriptor(userSuscriptor, passSuscriptor);
        TransversalSteps.buscarEntidad(args[0], args[1]);
        // creando una póliza de HF para renovarla

        TransversalSteps.crearPolizaRenovar(args[2], args[3]); //se toma el id
        HogarFullSteps.seleccionarTipoContratante(args[4]);
        HogarFullSteps.identificarPropiedad(args[5]);
        HogarFullSteps.seleccionarPropiedadDepartamentoAlternativo();
        HogarFullSteps.completarInformacionPropiedad(args[6], args[7], args[8], args[9]);
        HogarFullSteps.seleccionarCoberturaIncendio(args[10],args[11]);
        HogarFullSteps.calcularPrimaTotalHF();
      
		TransversalSteps.completarPoliza(args[12]);
		TransversalSteps.aceptarDocumentosPoliza();

        // ingresar a la poliza para validar estado
        TransversalSteps.renovarPoliza();
		TransversalSteps.ingresarPolizaBusquedaRapida();
		TransversalSteps.validarEstadoPoliza("renovación");
		
        
    }
    @Test(priority = 2, enabled = true, dataProvider = "dataHogarFull")
    public void ATMOQA28(String args[]) throws InterruptedException {
        test.assignCategory("Hogar_Full").assignDevice("Renovacion");
        step = test.createNode(
                "Renovación manual de una póliza de tipo Hogar Full en la plataforma TIA cumplido el año de vigencia, pero con ajuste de prima de un 15%");

        TransversalSteps.ingresarComoSuscriptor(userSuscriptor, passSuscriptor);
        TransversalSteps.buscarEntidad(args[0], args[1]);
        // creando una póliza de HF para renovarla
        TransversalSteps.crearPolizaRenovar(args[2], args[3]);
        HogarFullSteps.seleccionarTipoContratante(args[4]);
        HogarFullSteps.identificarPropiedad(args[5]);
        HogarFullSteps.seleccionarPropiedadDepartamentoAlternativo();
        HogarFullSteps.completarInformacionPropiedad(args[6], args[7], args[8], args[9]);
        HogarFullSteps.seleccionarCoberturaIncendio(args[10],args[11]);
        TransversalSteps.calcularPrimaTotal();
		// completar póliza
		TransversalSteps.completarPoliza(args[12]);
		TransversalSteps.aceptarDocumentosPoliza();

        TransversalSteps.ingresarPolizaBusquedaRapida();
        HogarFullSteps.crearSiniestroAlternativoHF();
        // selecciona siniestro de tipo Hogar Full
        HogarFullSteps.seleccionarProducto();
        // completa datos de un siniestro Hogar Full
        HogarFullSteps.seleccionarFechasHF();
        HogarFullSteps.completarEvento("Incendio Edificio", "INC", "202");
        TransversalSteps.insertarDescripcionHecho("Descripción del hecho");
        HogarFullSteps.seleccionarLugarSiniestroHF("BUI Edificio");
        HogarFullSteps.completarDatosInformanteHF( "IN", "Martha", "EMI");
        HogarFullSteps.responderPreguntas("Si","28139712-5", "marticaonline@gmail.com", "53389671");
        // generar siniestro
        HogarFullSteps.generarSiniestroHF("Incendio Edificio");
        HogarFullSteps.modificarMontoReservaHF("3");

        TransversalSteps.ingresarResumenEntidad();
//        // ingresar a la poliza para validar estado
        TransversalSteps.renovarPoliza();
		TransversalSteps.ingresarPolizaBusquedaRapida();
		TransversalSteps.validarEstadoPoliza("renovación");
        // validar prima con modificación
        HogarFullSteps.validarPrimaConModificacionHF();

    }
    @DataProvider(name = "dataHogarFull")
    public Object[][] dataHogarFull() throws CsvValidationException, InterruptedException, IOException {

        Object[][] data = OpenCSV.getCSVParametersDescription("renovacion" + File.separator + "CSVDataHogarFull.csv",
                1, 13);
        return data;
    }
}
