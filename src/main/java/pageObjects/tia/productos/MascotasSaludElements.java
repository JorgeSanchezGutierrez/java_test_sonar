package main.java.pageObjects.tia.productos;

public interface MascotasSaludElements {

	// Buttons
	String buttonNuevaLineaPoliza = "//*[@id=\"pt:sf_c:dr2:0:pt:TIADynamicTaskFlowRg:10:pt:PolicyNewPolicyLine\"]/a";
	String buttonAceptaNuevaLineaNegocio = "//*[@id=\"pt:sf_c:dr2:0:pt:TIADynamicTaskFlowRg:19:pt:PolicyNewPolicyLine\"]";
	String buttonCalcular = "//span[text()='alculate']";
	String buttonCompletar = "//*[@id=\"pt:sf_c:dr2:0:pt:TIADynamicTaskFlowRg:2:pt:DynamicObjectComplete\"]/a";
	String buttonSiCompletar = "//*[@id=\"pt:sf_c:dr2:0:pt:TIADynamicTaskFlowRg:2:pt:ActionsAllowedRegionContainer_yes\"]/a";
	String buttonAdministracion =  "//span[contains(text(), 'Administración')]";
	String buttonProductoMascotasSalud = "(//span[contains(text(),'Mascota Salud')]//preceding::a[@class='xgp'])[2]";
//	String buttonAceptarFechaSiniestro = "(//button[contains(text(),'Aceptar')])[2]";
	String buttonCrearSiniestro = "//span[contains(text(),'Crear siniestro')]";
	String buttonAceptarModalInformacionPoliza = "(//span[contains(text(),'cepta')])[3]";
	String buttonAceptarModalCobertura = "(//span[contains(text(),'cepta')])[3]";
	String buttonAprobarMontoReclamado = "//span[contains(text(),'Aprobar')]";
	String buttonAprobarRutInformante = "//span[contains(text(),'Aprobar')]";
	String buttonAprobarAsigLiquid = "//span[contains(text(),'Aprobar')]";
	String buttonCrearReserva = "//span[contains(text(),'Reserva')]";
	String buttonNuevoItem = "//span[contains(text(),'Nuevo item')]";
	String buttonGuardarItem = "//span[contains(text(),'Guardar')]";
	String buttonGenerarSiniestroMS = "//span[contains(text(),'Generar Siniestro')]";
	String buttonCuenta = "(//span[contains(text(),'Siniestro')])//following::a[contains(@title,'Ampliar')]";
	String buttonCuenta2 = "//span[contains(text(),'Cuenta')]//following::a[contains(@title,'Ampliar')]";
	String buttonCuenta3 = "//span[contains(text(),'Buscar item de cuenta')]";
	String buttonBuscarItemCuenta = "//div[contains(@id,\"SearchAccountItemSearch\")]//span[contains(text(), 'Buscar')]";
	String buttonPagosCobros = "//a[contains(@id,'12') and contains(@title,'Ampliar')]";
	String buttonSeleccionarItemPagar = "//span[contains(text(),'Seleccionar elementos vencidos para pago / cobro')]";
	String buttonContinuar = "//div[contains(@id,'pendingChangesDialogWithinCurrentTab_yes')]//a";
	String buttonSeleccionarPago = "//span[contains(text(),'Seleccione Pago')]";
	String buttonAcepta = "//div[@class='AFDetectContraction']//following::span[@class='xfx' and text()='cepta']//ancestor::a[@class='xfp']";
	String buttonCrearPagoCobros = "//span[contains(text(),'Crear pagos / cobros')]";
	String buttonCrearPago = "//div[contains(@id,'CreatePayment')]//span[contains(text(),'Crear pago')]";
	String buttonItemCuenta = "//input[contains(@id,'AccItemNo')]//following::img";
	String buttonSi = "//span[contains(text(),'Si') and contains(@class,'xfx')]";
//	String buttonSeleccionarDiaHoraSiniestro = "//td[contains(text(),'dia')]";
	String buttonAjustarHF = "//span[contains(text(), 'Ajustar ')]";
	String buttonAceptaAjusteHF = "//label[contains(text(), 'Fecha de ajuste ')]/following::span[contains(text(), 'Aceptar')][1]";

	// Labels
	String labelModalNuevaLineaNegocio = "//*[@id=\"pt:sf_c:dr2:0:pt:TIADynamicTaskFlowRg:10:pt:NewPolicyLinePopup::_ttxt\"]";
	String labelInformacionGeneralObjeto = "//*[@id=\"pt:sf_c:dr2:0:pt:TIADynamicTaskFlowRg:11:pt:DynamicObjectAccordionContainerGeneralInformation0AccordionTab::head\"]/table/tbody/tr/td[3]/table/tbody/tr/td[2]/table/tbody/tr/td";
	String labelModalPolizaCompleta = "//*[@id=\"pt:sf_c:dr1:0:pt:TIADynamicTaskFlowRg:2:pt:ActionsAllowedRegionContainer::_ttxt\"]";
	String labelModalDocumentosPoliza = "//div[contains(text(),'Documentos de póliza')]";
	String labelTipoTransaccionMS = "(//label[contains(text(),'transacción')]/following::span[@class='x2h'])[1]";
	String labelManejoLineaPolizaMS = "//h1[contains(text(),'Manejo de líneas de pólizas')]";
	String labelResultadosFechaInvalida = "//*[@id='pt:sf_c:dr2:0:pt:TIADynamicTaskFlowRg:7:pt:region0:1:pt:ClaPolicyLineLOVF5610PC:ClaPolicyLineLOVF5610Tab::db']";
	String labelPaginaCrearSiniestro = "//h1[contains(text(),'Crear siniestro')]";
	String labelSiniestroNotificado = "//h1[contains(text(),'Notificado')]";
	String labelPaginaAjuste= "//span[contains(text(),'M Ajuste a medio plazo')]";
	String labelPaginaCancelada = "//span[contains(text(),'C Cancelar póliza')]";
	String labelErrorCancelacionAseg = "//div[contains(text(),'Sólo se permite la cancelación por parte del asegurado después de 10 días desde la emisión de la póliza.')]";
	String labelPolizaCancelada = "//span[contains(text(), concat('Mascota Salud - ', 'id-poliza'))]/following::span[contains(text(), '- Cancelado')]";
	String labelPaginaAdmin = "//td[contains(@title, 'Administración')]";
	String labelNoCuenta = "//span[contains(text(),'1 Factura (cuentas por cobrar)')]//preceding::span[contains(@id,'ResultsGroupAccountNo')]";
	String labelItemCuenta = "//span[contains(text(),'1 Factura (cuentas por cobrar)')]//preceding::span[contains(@id,'ResultsGroupAccItemNo')]";
	String labelEstadoPago = "(//span[contains(text(),'1 Factura (cuentas por cobrar)')]//following::span[contains(@id,'GroupPaymentStatus::content')])[1]";
	String labelEstadoPagoEnviado = "(//span[contains(text(),'3 Enviado a sistema de pago')]//following::span[contains(@id,'GroupPaymentStatus::content')])[1]";
	String labelItemCuentaSeleccionar = "//span[text()='no-item']";
	String labelMontorevertido = "//span[contains(text(),'2 Asesoramiento crediticio (Cuentas por cobrar)')]//following::span[contains(@id,'ResultsGroupCurrencyAmt::content')]";
	String labelTipoTransaccionHF = "(//label[contains(text(),'transacción')]/following::span[@class='x2h'])[1]";
	
	// Select
	String selectTipoMascota = "(//td[@valign='top']//following::select)[2]";
	String selectMascotaEdad = "(//td[@valign='top']//following::select)[3]";
	String selectMascotaSexo = "(//td[@valign='top']//following::select)[4]";
	String selectMascotaLinaje = "(//td[@valign='top']//following::select)[5]";
	String selectTipoCobertura = "(//td[@valign='top']//following::select)[7]";
	String selectTipoRaza = "(//td[@valign='top']//following::select)[6]";
	String selectNecesarioAsigLiquid = "(//select[@class='x2h'])[9]";
	String selectMotivoCancelacionPoliza = "(//label[contains(text(),'Cancelar código')]/following::select[contains(@id,'PolicyCancelCode')])[1]";
	String selectMetodosPago = "//label[contains(text(), 'Método')]/following::select[contains(@id,'PaymentMethod')]";
	String selectTipoEndosoAlternativoHF = "//select[contains(@id,'PolicyEndorReasonIdPopup')]";
	
	// Input
	String inputMascotaNombre = "//*[@id=\"pt:sf_c:dr2:0:pt:TIADynamicTaskFlowRg:2:pt:TIA_IT2::content\"]";
	String inputCremacion = "//*[@id=\"pt:sf_c:dr2:0:pt:TIADynamicTaskFlowRg:2:pt:PO2PCTEST:PO2TabPoj:8:TIA_CB1::content\"]";
	String inputExamenes = "//*[@id=\"pt:sf_c:dr2:0:pt:TIADynamicTaskFlowRg:2:pt:PO2PCTEST:PO2TabPoj:9:TIA_CB1::content\"]";
	String inputIdPoliza = "//input[contains(@id,'SearchAccountItemPolicyNoAlt')]";
	String inputNoCuenta = "//input[contains(@id,'AccountNo')]";
	String inputItemCuenta = "(//input[contains(@id,'AccItemNoLovPC') and contains(@class,'x25')])[1]";
//	String inputFechaSiniestro = "(//a[@title='Seleccionar Fecha y Hora'])[1]";
	String inputIdObjeto = "//*[@id=\"pt:sf_c:dr2:0:pt:TIADynamicTaskFlowRg:1:pt:cl0::text\"]";
	String inputLineaPolizaN = "//*[@id=\"pt:sf_c:dr2:0:pt:TIADynamicTaskFlowRg:1:pt:PolicyInformationPolicyLineNo::content\"]";
	String inputDescripcionLugar = "//textarea[@id='pt:sf_c:dr2:0:pt:TIADynamicTaskFlowRg:7:pt:WherePlaceDesc::content']";
	String inputContactoInformante = "//*[@id='pt:sf_c:dr2:0:pt:TIADynamicTaskFlowRg:7:pt:InformerInformerContact::content']";
//	String inputLupaLineaPoliza = "//*[@id=\"pt:sf_c:dr2:0:pt:TIADynamicTaskFlowRg:1:pt:PolicyInformationPolicyLineNoIcon\"]";
//	String inputFechaInvalidaSiniestro = "//*[@id=\"pt:sf_c:dr2:0:pt:TIADynamicTaskFlowRg:1:pt:WhenIncidentDate::content\"]";
	String inputReservaItem = "//input[contains(@id,'DetailCurrencyEstimate::content')]";
	String inputGestorSiniestros = "//input[contains(@id,'WhatHappenedHandler')]";
	String inputItemCuenta2 = "(//input[contains(@id,'AccItemNo') and contains(@class,'x25')])[1]";
	
	// Check
	String checkChip = "//*[@id=\"pt:sf_c:dr2:0:pt:TIADynamicTaskFlowRg:6:pt:TIA_CB1::content\"]";
	String checkCobertura = "//*[@id=\"pt:sf_c:dr2:0:pt:TIADynamicTaskFlowRg:6:pt:TIA_CB2::content\"]";
	String checkTerminos = "//*[@id=\"pt:sf_c:dr2:0:pt:TIADynamicTaskFlowRg:6:pt:TIA_CB3::content\"]";
	String checkBoxFechaEstimada = "//input[contains(@id,'WhenExactIncidentDate')]";

	// option
	String listOpciones = "//li[@role='option']";
	
	//Span
	String spanNumeroPolizaModal = "(//span[@class='x25'])[6]";
	String spanSeleccionNumeroLineaPoliza = "//span[contains(text(),'MS Mascota Salud')]";

	//Text Area
	String textAreaMontoReclamado = "//*[@id='pt:sf_c:dr2:0:pt:TIADynamicTaskFlowRg:7:pt:FnolQuestionWizardGroupRegionRgLc0:2:pt:Qwi1:0:qwInputTextId::content']";
	String textAreaRutInformante = "//*[@id='pt:sf_c:dr2:0:pt:TIADynamicTaskFlowRg:7:pt:FnolQuestionWizardGroupRegionRgLc0:2:pt:Qwi1:2:qwInputTextId::content']";
	
	//a
	String aManejoPolizasMS = "//span[contains(text(),'id-poliza')]";
	String aLineaPolizaMS = "//span[contains(text(),'id-poliza')]//following::a[contains(@id,'PolicyMenuTree') and contains(@class,'TextOnly')][1]";
	String aLabelReserva = "//a[contains(text(), 'Reserva')]";
	String aManejoPoliza = "//span[contains(@class, 'x1al') and contains(text(), concat('Mascota Salud - ', 'id-poliza'))]";
	String aAceptaEndoso = "//li[@class='x1b4' and @title='Acepta transacción de endoso']";
	
	//Loanding
	String loadingTia = "//span[contains(@id,'pt_statInd')]//img[@title='Inactivo']";
}
