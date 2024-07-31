package main.java.pageObjects.tia.productos;

public interface OncologicoElements {

	String aBuscarAsegurado = "//label[contains(text(),'Asegurado')]//following::a[1]";
	String aBuscarAseguradoAdicional = "//label[contains(text(),'Identificación')]//following::a[contains(@class,'xgp')][last()]";
	String aBuscarGestorSiniestro = "//img[contains(@id,'WhatHappenedHandlerIcon')]/ancestor::a";
	String aAceptarGestorSiniestro = "//div[contains(@id,'popup-container')]//a[@accesskey='A']";
	String aModuloReservasPagos = "(//a[contains(@id,'ItemsAndPaymentsTopLcSdi::disAcr' ) and text()='Reservas y Pagos'  addParams])[1]"; // para
																																			// utilizarlo
																																			// se
																																			// debe
																																			// hacer
																																			// el
																																			// reemplazo
																																			// al
																																			// texto
																																			// 'addParams'
	String aBuscarInstruccionPago = "//img[contains(@id,'PaymentTrainAccountItemPaymentInstrIcon')]/ancestor::a";
	String aFinalizarPago = "//span[text()='Finalizar pago']/parent::a";

	String selectPlan = "//label[contains(text(),'Plan')]//following::select[1]";
	String selectCobertura = "//label[contains(text(),'Cobertura')]//following::select[1]";
	String selectIsapre = "//label[contains(text(),'Isapre')]//following::select[1]";
	String selectParentesco = "//label[contains(text(),'Parentesco')]//following::select[1]";
	String selectRangoEdad = "//label[contains(text(),'Rango')]//following::select[1]";
	String selectLiquidador = "//input[contains(@id,'PolicyInformationN901::content')]";
	String selectBiopsiaCancer = "//label[contains(text(),'¿Tiene diagnóstico de cáncer mediante biopsia?')]/ancestor::tr[contains(@id,'FnolQuestionWizardGroupRegionRgLc0')]//select";
	String selectInformeanatomopatologico = "//label[contains(text(),'¿Tiene informe anatomopatológico?')]/ancestor::tr[contains(@id,'FnolQuestionWizardGroupRegionRgLc0')]//select";
	String selectDiagnosticoUCCHRISTUS = "//label[contains(text(),'¿El diagnóstico fue realizado por UC CHRISTUS?')]/ancestor::tr[contains(@id,'FnolQuestionWizardGroupRegionRgLc0')]//select";
	String selectSubCoberturaNum = "//select[contains(@id,'ItemDetailSubriskNo')]";
	String selectTipoPago = "//select[contains(@id,'PaymentTrainPaymentItemDetailsPaymentType')]";

	// labels
	String labelEncabezadoQueFueDanioString = "//td[@title='Qué fue dañado?']";
	String labelAsistenciaCancer = "//span[contains(text(),'Asistencia')]";
	String labeltextoPoliza = "//textarea[contains(@id,'PolicyInformationPolicyClauses')]";
	String labelTituloSiniestro = "//div[contains(@id,'phClaimCaseTabs')]//h1";
	String labelAdvertencia = "//td[text()='Advertencia']";
	String labelMensajeAdvertencia = "//td[text()='Advertencia']/ancestor::table/following-sibling::div//td[@class='af|message::detail-cell']/div";
	String labelTituloItemPago = "//div[@title='Items de pago']/h1";
	String labelTituloEspecificacionPago = "//div[contains(@title,'Especificación de pago')]/h1";

	// Span
	String spanOpcionOncologia = "(//span[contains(text(),'Oncología')]//preceding::a[@class='xgp'])[2]";
	String spanBuscarLiquidador = "//img[contains(@id,'sbi1')]/ancestor::span";
	String spanCampoPagadoReservaPago = "//span[contains(@id,'ItemDetailPaid::content')]";
	String spanAprobarReceptor = "//span[text()='Aprobar receptor']/parent::a";
	String spanInstruccionPago = "(//span[contains(@id,'MaintainPartyPaymentDetailPaymentMethod::content')])[1]";
	String spanEstadoItemPago = "(//input[contains(@id,'ItemListPay::content') ])[last()]/ancestor::td[contains(@id,'ItemListPayCol')]/following-sibling::td[contains(@id,'ItemListStatusDescriptionCol')]//span[contains(@id,'ItemListStatusDescription::content')]";
	String spanPagadoItemPago = "(//input[contains(@id,'ItemListPay::content') ])[last()]/ancestor::td[contains(@id,'ItemListPayCol')]/following-sibling::td[contains(@id,'ItemListPaidCol')]//span[contains(@id,'ItemListPaid::content')]";
	String spanNombreDestinatario = "(//input[contains(@id,'ItemListPay::content') ])[last()]/ancestor::td[contains(@id,'ItemListPayCol')]/following-sibling::td[contains(@id,'ItemListReceiverNameCol')]//span[contains(@id,'ItemListReceiverName::content')]";

	// CheckBox

	// Loading
	String loadingTia = "//span[contains(@id,'pt_statInd')]//img[@title='Inactivo']";

	// Select
	String selectNumCobetura = "//input[contains(@id,'ItemDetailRiskNo')]";
	String selectTipoMoneda = "//select[contains(@id,'ItemDetailCurrencyCode')]";
	String selectEstadoPagoReserva = "//select[contains(@id,'ItemDetailStatus')]";

	// button
	String buttonAceptar = "//div[contains(@id,'TIADynamicTaskFlowRg')]//a[@accesskey='A']";
	String buttonAceptarLiquidador = "//td[contains(@id,'dialog0')]//a[@accesskey='A']";
	String buttonAceptarPreguntaAsistente = "//span[text()='Aprobar']/parent::a";
	String buttonDesplegarConsultaEjemploSiniestro = "//div[contains(@id,'PartyClaimOverviewPC:_qbeTbr')]";
	String buttonSelecFecInicioCobertura = "(//label[text()='Fecha de inicio de cobertura']//following::a)[1]";

	// Text
	String textoDeducible = "//input[contains(@id,'WhatHappenedDeductible')]";
	String textoIDLiquidador = "//input[contains(@id,'_afrFltrMdlServiceSupplierLovIdNoAltCol')]";
	String seleccionarLiquidador = "(//span[contains(text(),'IDLiquidador')])[1]";
	String textoBuscarGestorSiniestro = "//input[contains(@id,'_afrFltrMdlUserIdLookupUserNameCol')]";

	// Fila tabla
	String filaTablaLiquidador = "(//td[contains(@id,'ServiceSupplierLovServiceSupplierTypeCol')])[1]";
	String filaGestorSiniestro = "//div[contains(@id,'UserIdLookupPC:UserIdLookupTab::db')]/table/tbody/tr[1]";
	String filaBuscarSiniestro = "(//span[contains(@id,'PartyClaimOverviewClaCaseNoAlt') and text()='id-siniestro'])[1]";
	String filaItem = "//td[contains(@id,'ItemListTab:1:ItemListReceiverNameCol')]//span[contains(@id,'ItemListReceiverName::content')]";
	String filaIdReceptor = "//td[contains(@id,'ReceiverLOVNameCol')]";

	// Celda tabla
	String celdaIdUsuario = "//div[contains(@id,'UserIdLookupPC:UserIdLookupTab::db')]/table/tbody/tr[1]//span[contains(@id,'UserIdLookupUserId::content')][1]";

	// Siniestro despliegue
	String collapseSiniestro = "//h2[contains(@id,'CustomerWrkPlCustomerWrkPlRegionContainerClaimTab::head') and @class='x1eo p_AFDisclosable p_AFFlow']//a";

	// TextArea
	String textareaRutInformante = "//label[contains(text(),'RUT del informante')]/ancestor::tr[contains(@id,'FnolQuestionWizardGroupRegionRgLc0')]//textarea";
	String textareaCorreoInformante = "//label[contains(text(),'Correo del informante')]/ancestor::tr[contains(@id,'FnolQuestionWizardGroupRegionRgLc0')]//textarea";
	String textareaTelefonoInformante = "//label[contains(text(),'Telefono del informante')]/ancestor::tr[contains(@id,'FnolQuestionWizardGroupRegionRgLc0')]//textarea";
	String textareaDescripcionReservaPago = "//textarea[contains(@id,'ItemDetailDescription')]";
	String textareaNumeroDeFactura = "//textarea[contains(@id,'PaymentTrainAccountItemItemReference::content') and @class='x25']";

	// input
	String gestorSiniestroSeleccionado = "//input[contains(@id,'WhatHappenedHandler')]";
	String inputBuscarSiniestro = "//input[contains(@id,'PartyClaimOverviewTab:id0')]";
	String inputDescripcionCobertura = "//input[contains(@id,'ItemDetailRiskDescription')]";
	String inputNombreDestinatario = "//input[contains(@id,'ItemDetailReceiverName')]";
	String inputRol = "//input[contains(@id,'ItemDetailRoleDescription')]";
	String inputCheckBoxSeleccionarItemPago = "(//input[contains(@id,'ItemListPay::content') ])[last()]";
	String inputInstruccionPago = "//input[contains(@id,'PaymentTrainAccountItemPaymentInstr')]";
}
