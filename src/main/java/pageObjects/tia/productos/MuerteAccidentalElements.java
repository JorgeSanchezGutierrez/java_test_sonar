package main.java.pageObjects.tia.productos;

public interface MuerteAccidentalElements {
	
	//Select
	
	String selectRespuesta1 = "//td[contains(text(), 'Asistente de preguntas')]/following::select[1]";
	String selectRespuesta12 = "//td[contains(text(), 'Asistente de preguntas')]/following::textarea[1]";
	String selectRespuesta13 = "//td[contains(text(), 'Asistente de preguntas')]/following::textarea[2]";
	String selectRespuesta14 = "//td[contains(text(), 'Asistente de preguntas')]/following::textarea[3]";
	String selectEvento = "//label[text()='Evento']/following::select[1]";
	String selectCausa = "//label[text()='Causa']/following::select[1]";
	
	//Input
	String inputPorcentaje = "/html/body/div[1]/form/div[1]/div[2]/div/div/div/div[2]/div/div[1]/div[2]/div/div[2]/div/div[2]/div/div[3]/div/div[2]/div/div[1]/div[2]/div/div[2]/div/div/div/div/div/div/div[7]/div/div/div/div[5]/div/div/div/div/div[2]/div/div/div/div[1]/div[2]/div/div[2]/table/tbody/tr/td[2]/div/table/tbody/tr/td[6]/span/span/span/input";
	String inputDescCobertura = "//label[contains(text(),'Descripción de cobertura')]/following::input[1]";
	String ClickPlanCobertura = "/html/body/div[1]/form/div[1]/div[2]/div/div/div/div[2]/div/div[1]/div[2]/div/div[2]/div/div[2]/div/div[3]/div/div[2]/div/div[1]/div[2]/div/div[2]/div/div/div/div/div/div/div[7]/div/div/div/div[3]/div/div/div/div/div[2]/div/div[2]/div/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr[2]/td/select";
	String SeleccionPlan1 = "//option[text()='Plan 1']";
	String SeleccionPlan2 = "//option[text()='Plan 2']";
	
	//label
	String labelCobertura = "/html/body/div[1]/form/div[2]/div[2]/div[1]/div[1]/table/tbody/tr/td/div/div/table/tbody/tr[2]/td[2]/div/div/div[1]/div[2]/div/div[2]/div/div/div/div[1]/div[2]/div/div[2]/table/tbody/tr/td[2]/div/table/tbody/tr";
	
	//Span
	String CheckboxComision = "//span[text()='commissions']//following::input[1]";
	String labelpageSiniestros = "//h1[contains(text(),'Crear siniestro')]";
	String labelEstadoPreguntasOK = "//span[text()='OK']";
	String buttonHome = "//a[contains(text(),'Home')]";
	
	//Button
	String labelMontorevertido = "//span[contains(text(),'2 Asesoramiento crediticio (Cuentas por cobrar)')]//following::span[contains(@id,'ResultsGroupCurrencyAmt::content')]";
	String inputItemCuenta2 = "(//input[contains(@id,'AccItemNo') and contains(@class,'x25')])[1]";
	String labelItemCuentaSeleccionar = "//span[text()='no-item']";
	String buttonAceptar = "//div[@class='AFDetectContraction']//following::span[@class='xfx' and text()='cepta']//ancestor::a[@class='xfp']";
	String inputNoCuenta = "//input[contains(@id,'AccountNo')]";
	String buttonItemCuenta = "//input[contains(@id,'AccItemNo')]//following::img";
	String inputItemCuenta = "(//input[contains(@id,'AccItemNoLovPC') and contains(@class,'x25')])[1]";
	String selectMetodosPago = "//label[contains(text(), 'Método')]/following::select[contains(@id,'PaymentMethod')]";
	String buttonPagosCobros = "//a[contains(@id,'12') and contains(@title,'Ampliar')]";
	String buttonSeleccionarItemPagar = "//span[contains(text(),'Seleccionar elementos vencidos para pago / cobro')]";
	String buttonContinuar = "//div[contains(@id,'pendingChangesDialogWithinCurrentTab_yes')]//a";
	String buttonSeleccionarPago = "//span[contains(text(),'Seleccione Pago')]";
	String buttonCrearPagoCobros = "//span[contains(text(),'Crear pagos / cobros')]";
	String buttonCrearPago = "//div[contains(@id,'CreatePayment')]//span[contains(text(),'Crear pago')]";
	String labelItemCuenta = "//span[contains(text(),'1 Factura (cuentas por cobrar)')]//preceding::span[contains(@id,'ResultsGroupAccItemNo')]";
	String labelEstadoPago = "(//span[contains(text(),'1 Factura (cuentas por cobrar)')]//following::span[contains(@id,'GroupPaymentStatus::content')])[1]";
	String labelNoCuenta = "//span[contains(text(),'1 Factura (cuentas por cobrar)')]//preceding::span[contains(@id,'ResultsGroupAccountNo')]";
	String buttonBuscarItemCuenta = "//div[contains(@id,\"SearchAccountItemSearch\")]//span[contains(text(), 'Buscar')]";
	String inputIdPoliza = "//input[contains(@id,'SearchAccountItemPolicyNoAlt')]";
	String buttonCuenta1 = "(//span[contains(text(),'Siniestro')])//following::a[contains(@title,'Ampliar')]";
	String buttonCuenta22 = "//span[contains(text(),'Cuenta')]//following::a[contains(@title,'Ampliar')]";
	String buttonSi2 = "/html/body/div[1]/form/div[2]/div[2]/div[1]/div[1]/table/tbody/tr/td/div/div/table/tbody/tr[3]/td[2]/table/tbody/tr/td[1]/div[1]/a";
	String buttonCuenta33 = "//span[contains(text(),'Buscar item de cuenta')]";
	String buttonNuevoBene = "/html/body/div[1]/form/div[1]/div[2]/div/div/div/div[2]/div/div[1]/div[2]/div/div[2]/div/div[2]/div/div[3]/div/div[2]/div/div[1]/div[2]/div/div[2]/div/div/div/div/div/div/div[7]/div/div/div/div[5]/div/div/div/div/div[2]/div/div/div/div[1]/div[1]/div/div/table/tbody/tr/td[2]/div/div[1]/div[1]/table/tbody/tr/td/div/a";
	String buttonBuscarEntidad1 = "/html/body/div[1]/form/div[1]/div[2]/div/div/div/div[2]/div/div[1]/div[2]/div/div[2]/div/div[2]/div/div[3]/div/div[2]/div/div[1]/div[3]/table/tbody/tr/td/div/div/table/tbody/tr/td[1]/div/div[1]/div[1]/table/tbody/tr/td[1]/div";
	String apellidoBene = "//*[@id=\"pt:sf_c:dr1:0:pt:TIADynamicTaskFlowRg:3:pt:SearchP2000PartySearchSurnameSearch::content\"]";
	String buscarEntidad = "/html/body/div[1]/form/div[1]/div[2]/div/div/div/div[2]/div/div[1]/div[2]/div/div[2]/div/div[2]/div/div[3]/div/div[2]/div/div[1]/div[2]/div/div[2]/div/div/div/div/div/div/div[7]/div/div/div/div[5]/div/div/div/div/div[2]/div/div/div/div[1]/div[2]/div/div[2]/table/tbody/tr/td[2]/div/table/tbody/tr/td[1]/span/span/table/tbody/tr/td[2]/table/tbody/tr/td[2]/span/a/span/img";
	String seleccionarProductoMA = "//*[text()='Muerte Accidental']//preceding::div[3]";
	String seleccionarProductoSaludAP = "//*[text()='Salud / Accidente personal']//preceding::div[3]";
	String buttonAprobar = "//span[text()='Aprobar']";
	String buttonBusquedaCobertura = "//label[text()='Cobertura N°']/following::img[1]";
	String labelPaginaCancelada = "//span[contains(text(),'C Cancelar póliza')]";
	String labelPaginaRenovada = "//span[contains(text(),'R Renovación')]";
	String selectMotivoCancelacionPoliza = "(//label[contains(text(),'Cancelar código')]/following::select[contains(@id,'PolicyCancelCode')])[1]";
	String buttonRenovar = "//div[contains(@id,'CoverTreeRenewButtonGltbb')]";

	
	//Combobox
	String labelPaginaAdmin2 = "//td[contains(@title, 'Administración')]";
	String loadingTia = "//span[contains(@id,'pt_statInd')]//img[@title='Inactivo']";
	String comboBoxParentesco = "/html/body/div[1]/form/div[1]/div[2]/div/div/div/div[2]/div/div[1]/div[2]/div/div[2]/div/div[2]/div/div[3]/div/div[2]/div/div[1]/div[2]/div/div[2]/div/div/div/div/div/div/div[7]/div/div/div/div[5]/div/div/div/div/div[2]/div/div/div/div[1]/div[2]/div/div[2]/table/tbody/tr/td[2]/div/table/tbody/tr/td[5]/span/span/span/select/option[2]";
	
	//a
	String buttonAdministracion2 =  "//span[contains(text(), 'Administración')]";
	String eleminarSi = "//span[(text()='Si')]";
	String labelPaginaAjuste= "//span[contains(text(),'M Ajuste a medio plazo')]";
	String aManejoPoliza = "//span[contains(@class, 'x1al') and contains(text(), concat('Accidentes Personales - ', 'id-poliza'))]";
	String eliminarBeneficiario = "/html/body/div[1]/form/div[1]/div[2]/div/div/div/div[2]/div/div[1]/div[2]/div/div[2]/div/div[2]/div/div[3]/div/div[2]/div/div[1]/div[2]/div/div[2]/div/div/div/div/div/div/div[7]/div/div/div/div[5]/div/div/div/div/div[2]/div/div/div/div[1]/div[2]/div/div[2]/table/tbody/tr/td[1]/span/table/tbody/tr/td/a";
	
	//
	String buttonAjustarMA = "//span[contains(text(), 'Ajustar ')]";
	String selectTipoEndosoAlternativoMA = "//select[contains(@id,'PolicyEndorReasonIdPopup')]";
	String buttonAceptaAjusteMA = "//label[contains(text(), 'Fecha de ajuste ')]/following::span[contains(text(), 'Aceptar')][1]";
	String labelTipoTransaccionMA = "(//label[contains(text(),'transacción')]/following::span[@class='x2h'])[1]";
	
	//
	String buttonAmpliarVentanaPolizasMA = "//div[contains(@_afrclmwmn,'CoverTreePolicyNoAltCol')]//div[contains(@title,'Separar')]";
	String aPolizaRenovarMA = "//span[contains(text(),'id-poliza') and contains(@id,'CoverTreePolicyNoAlt::text')]//following::span[contains(text(),'id-producto') and contains(@id,'CoverTreeProdId')][1]";
	String buttonRenovarMA = "//div[contains(@id,'CoverTreeRenewButtonGltbb')]";
	String labelPaginaRenovacionMA = "//h1[contains(text(),' Renovación de póliza en línea')]";
	String labelPolizaRenovarMA = "//span[contains(@id,'RenewalPolicyOnlinePolicyNoAlt')]";
	String buttonRenovacionMA = "//div[contains(@id,'RenewalPolicyOnlineRenew')]/a";
	String buttonCompletarRenovacionMA = "//div[contains(@id,'PolicyRenewalDetailsContinue')]";
	String buttonAceptarRenovacionMA = "//div[contains(@id,'CompletePopup_ok')]";
	
	
	
}
