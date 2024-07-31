package main.java.pageObjects.tia.transversal;

import org.apache.commons.beanutils.converters.StringArrayConverter;

public interface TransversalElements {

	String inputUsuario = "//*[@id=\"r1:0:pt:s1:username::content\"]";
	String buttonAjustartransversal= "//span[contains(text(), 'Ajustar ')]";
	String selectTipoEndosoTransversal = "//select[contains(@id,'PolicyEndorReasonIdPopup')]";
	String buttonAceptaAjusteTransversal = "//label[contains(text(), 'Fecha de ajuste ')]/following::span[contains(text(), 'Aceptar')][1]";
	String inputPassword = "//*[@id=\"r1:0:pt:s1:password::content\"]";
	String labelTipoTransaccionTransversal = "(//label[contains(text(),'transacción')]/following::span[@class='x2h'])[1]";
	String inputApellido = "//label[contains(text(),'Apellido')]//following::input[@type='text'][1]";
	String inputCodigoDescuento = "//label[text()='Campaña']//following::input[1]";
	String inputPorcentajeDescuento = "//label[text()='Porcentaje de descuento']//following::input[1]";
	String inputNombreContratante = "//label[text()='Contratante Nombres']//following::input[1]";
	String inputRutContratante = "//label[text()='Contratante RUT']//following::input[1]";
	String inputNacimientoContratante = "//label[text()='Contratante Fecha Nacimiento']//following::input[1]";
	String inputNombreAsegurado = "//label[text()='Asegurado Nombre']//following::input[1]";
	String inputRutAsegurado = "//label[text()='Asegurado RUT']//following::input[1]";
	String inputNacimientoAsegurado = "//label[text()='Asegurado Fecha Nacimiento']//following::input[1]";
	String inputNombInform = "//label[contains(text(), 'Nombre del informante')]//following::input[1]";
	String inputDescripHecho = "//label[text()='Descripción del Hecho']//following::textarea[1]";
	String inputFechaSiniestro = "//label[text()='Fecha del siniestro']//following::input[1]";
	String inputFechaDenuncia = "//label[text()='Fecha de denuncia']//following::input[1]";
	String inputIdLineaPoliza = "//label[contains(text(),'Mostrar información del objeto acordeón')]//following::input[3]";
	String inputObjeto = "//label[text()='Objeto N°']//following::input[1]";
	String inputIdReceptor = "//div[contains(text(),'Seleccionar')]//following::input[3]";
	String inputNombreReceptor = "//label[contains(text(),'Nombre del destinatario') and @class='af_inputText_label-text']/following::input[1]";
	String inputRolReceptor = "//label[contains(text(),'Rol') and @class='af_inputText_label-text']/following::input[1]";
	String inputReserva = "(//label[@class='af_panelLabelAndMessage_label-text' and contains(text(),'Reserva')]//following::input)[1]";
	String inputIdLiquidReceptor = "(//label[contains(text(),'Id receptor')]/following::input)[1]";
	String inputIdGestor = "(//label[contains(text(), 'Gestor de siniestros')]//following::input)[1]";
	String inputFechaAjuste = "//label[contains(text(), 'Fecha de ajuste ')]/following::input[1]";
	String inputIdEntidad = "//label[contains(text(),'Id Entidad')]//following::input[@type='text'][1]";
	String inputMontoLiquid = "(//input[following::label[contains(text(),'Nueva Reserva')]])[last()]";
	String inputBusqueda = "//*[@id=\"pt:sf_t:searchTB:pt_it1::content\"]";
	
	String inputBusquedaRapida = "//*[@id='pt:sf_t:searchTB:pt_it1::content']";
	String inputReservaPagosReserva = "//input[contains(@id,'ItemDetailCurrencyEstimate')]";
	String fechaSiniestroLimpiarCaja = "//td[2]/table/tbody/tr[2]/td[2]/input[@placeholder='dd.mm.yyyy H:mm']";
	String clicEntidad = "//*[@id='pt:sf_c:dr2:0:pt:PartyTreeParentTree:0:cl0::text']";
	String clicPoliza = "//tbody/tr[1]/td[1]/div/span[2][@class='af_column_data-container']";  
	String inputIdPoliza = "//input[contains(@id,'SearchAccountItemPolicyNoAlt')]";
	String buttonBuscarItemCuenta = "//div[contains(@id,\"SearchAccountItemSearch\")]//span[contains(text(), 'Buscar')]";
	String labelNoCuenta = "//span[contains(text(),'1 Factura (cuentas por cobrar)')]//preceding::span[contains(@id,'ResultsGroupAccountNo')]";
	String labelItemCuenta = "//span[contains(text(),'1 Factura (cuentas por cobrar)')]//preceding::span[contains(@id,'ResultsGroupAccItemNo')]";
	String labelEstadoPago = "(//span[contains(text(),'1 Factura (cuentas por cobrar)')]//following::span[contains(@id,'GroupPaymentStatus::content')])[1]";
	String buttonPagosCobros = "//a[contains(@id,'12') and contains(@title,'Ampliar')]";
	String buttonSeleccionarItemPagar = "//span[contains(text(),'Seleccionar elementos vencidos para pago / cobro')]";
	String buttonContinuar = "//div[contains(@id,'pendingChangesDialogWithinCurrentTab_yes')]//a";
	String selectMetodosPago = "//label[contains(text(), 'Método')]/following::select[contains(@id,'PaymentMethod')]";
	String inputNoCuenta = "//input[contains(@id,'AccountNo')]";
	String buttonItemCuenta = "//input[contains(@id,'AccItemNo')]//following::img";
	String inputItemCuenta = "(//input[contains(@id,'AccItemNoLovPC') and contains(@class,'x25')])[1]";
	String labelItemCuentaSeleccionar = "//span[text()='no-item']";
	String buttonAceptar1 = "//div[@class='AFDetectContraction']//following::span[@class='xfx' and text()='cepta']//ancestor::a[@class='xfp']";
	String buttonSeleccionarPago = "//span[contains(text(),'Seleccione Pago')]";
	String buttonCuenta33 = "//span[contains(text(),'Buscar item de cuenta')]";
	String buttonCrearPagoCobros = "//span[contains(text(),'Crear pagos / cobros')]";
	String inputItemCuenta2 = "(//input[contains(@id,'AccItemNo') and contains(@class,'x25')])[1]";
	String buttonCrearPago = "//div[contains(@id,'CreatePayment')]//span[contains(text(),'Crear pago')]";
	String labelMontorevertido = "//span[contains(text(),'2 Asesoramiento crediticio (Cuentas por cobrar)')]//following::span[contains(@id,'ResultsGroupCurrencyAmt::content')]";

	// buttons
	String buttonIniciarSesion = "//*[@id=\"r1:0:pt:s1:login\"]/a";
	String buttonBuscarEntidad = "//span[@class='xfx' and text()='Buscar']//ancestor::a[@class='xfp']";
	String buttonAdministracion =  "//span[contains(text(), 'Administración')]";
	String labelPaginaAdmin = "//td[contains(@title, 'Administración')]";
	String buttonCuenta = "(//span[contains(text(),'Siniestro')])//following::a[contains(@title,'Ampliar')]";
	String buttonCuenta2 = "//span[contains(text(),'Cuenta')]//following::a[contains(@title,'Ampliar')]";
	String buttonCuenta3 = "//span[contains(text(),'Buscar item de cuenta')]";
	String buttonNuevaPoliza = "//span[@class='xfx' and text()='Nuevo']//ancestor::a[@class='xfp']";
	String buttonSi = "//span[@class='xfx' and text()='Sí']//ancestor::a[@class='xfp']";
	String buttonNuevaLineaPoliza = "//span[@class='xfx' and text()='Nueva línea de póliza']//ancestor::a[@class='xfp']";
	String buttonAceptar = "//div[@class='AFDetectContraction']//following::span[@class='xfx' and text()='cepta']//ancestor::a[@class='xfp']";
	String buttonCalculate = "//div[contains(@id,'PojPriceArealCalculate')]//a[@class='xfp']";
	String buttonGuardar = "//span[@class='xfx' and text()='Guardar']//ancestor::a[@class='xfp']";
	String buttonCompletar = "//span[@class='xfx' and text()='Completar']//ancestor::a[@class='xfp']";
	String buttonNuevo = "//span[@class='xfx' and text()='Nuevo']//ancestor::a[@class='xfp']";
	String buttonCerrar = "//div[contains(text(),'Póliza')]//following::a[@aria-label='Cerrar'][1]";
	String buttonCerrarSeleccion = "//div[contains(text(),'Seleccionar producto')]//following::a[@aria-label = 'Cerrar'][1]";
	String buttonCrearSiniestro = "//span[contains(text(),'Crear siniestro')]//ancestor::a";
	String buttonGenerarSiniestro = "//span[contains(text(),'Generar Siniestro')]";
	String buttonGuardarReserva = "//span[contains(text(),'Guardar')]";
	String labelNotificacionSiniestro = "//span[contains(text(),'Notificación de siniestro')]";
	String buttonBusquedaPoliza = "//label[text()='Línea de póliza N°']//following::img[1]";
	String buttonBusquedaPolizaAlt = "//label[text()='Línea de póliza N°']//following::a[1]";
	String buttonAceptaSeleccion = "(//span[contains(text(),'cepta')])[3]";
	String buttonNuevoItem = "//span[contains(text(),'Nuevo item')]";
	String buttonBusquedaReceptor = "//label[text()='Id receptor']//following::img[1]";
	String buttonReserva = "//span[contains(text(),'Reserva')]/ancestor::a";
	String buttonSeleccionarFechaSiniestro = "//label[text()='Fecha del siniestro']//following::a[1]";
	String buttonSeleccionarFechaDenuncia = "//label[text()='Fecha de denuncia']//following::a[1]";
	String buttonFechaSuperiorDiaActual = "//td[contains (@class, 'p_AFSelecsted')]/following::td[1]";
	String buttonAceptarFecha = "(//button[contains(text(),'Aceptar')])[2]";
	String buttonBarraLateral = "//a[contains(@aria-controls,'ClaimCaseClaimCaseRegionContainerPs')]";
	String buttonNuevoScroll = "//*[contains(text(),'Nuevo')]";
	String buttonSeleccionarFechaHora = "(//a[@title='Seleccionar Fecha'])[1]";
	String buttonDiaFactura = "//td[contains(text(),'dia')]";
//	String buttonAceptaCompletarPoliza = "//div[contains(text(),'Documentos de póliza')]//following::a[@class='xfp'][1]";
//	String buttonAceptaCompletarPoliza = "//div[contains(@id,'CompletePopup_ok')]/a";
//	String buttonAceptaCompletarPoliza = "//div[contains(text(),'Documentos de póliza')]//following::a[@class='xfp'][1]";
//	String buttonAceptaCompletarPoliza = "//div[contains(@id,'CompletePopup_ok')]/a";
	String buttonAjustar = "//span[contains(text(), 'Ajustar ')]";
	String buttonAjustarPoliza = "//span[contains(text(),'Ajustar póliza')]";
	String buttonAceptaAjuste = "//label[contains(text(), 'Fecha de ajuste ')]/following::span[contains(text(), 'Aceptar')][1]";
	String buttonAmpliarVentanaPolizas = "//div[contains(@_afrclmwmn,'CoverTreePolicyNoAltCol')]//div[contains(@title,'Separar')]";
	String buttonOrdenDescendenteListaPolizas = "//th[contains(@id,'CoverTreeFirstStartDateCol')]//td[@_afrsortdesc='1']//a[@tabindex='-1' and @title='Orden Descendente']";
	String aPolizaRenovar = "//span[contains(text(),'id-poliza') and contains(@id,'CoverTreePC:CoverTreeTab:3:CoverTreePolicyNoAlt')]//following::span[contains(text(),'id-producto')][1]";
	String bPolizaRenovar = "//div[contains(@id,'CoverTreePC::popup-container')]//span[contains(@id, 'CoverTreePolicyNoAlt::text') and text()='id-poliza']//ancestor::tr[@class='x17d']//span[text()='id-producto']";
	String buttonDetallesRenovacion = "//span[contains(text(), 'Detalles de renovación')]";
	String labelPaginaRenovacion = "//h1[contains(text(),' Renovación de póliza en línea')]";
	String labelPolizaRenovar = "//span[contains(@id,'RenewalPolicyOnlinePolicyNoAlt')]";
	String buttonSiguiente = "//span[contains(text(),'Siguiente')]";
	String buttonSeleccionaInstPago = "//label[contains(text(),'Instrucción de pago')]//following::img";
	String buttonAceptaInstPago = "(//span[contains(text(),'cepta')])[2]";
	String buttonFinalizarPago = "//span[contains(text(),'Finalizar pago')]";
	String buttonNoCerrarReserva = "(//span[contains(text(),'No')])[3]";
	String buttonLiquidar = "//span[contains(text(), 'Liquidar')]";
	// String buttonBarraLateral =
	// "//a[contains(@aria-controls,'ClaimCaseClaimCaseRegionContainerPs')]";
	String buttonAceptaCompletarPoliza = "//div[contains(@id,'CompletePopup_ok')]/a";
	String buttonCancelarCompletarPoliza = "//div[contains(@id,'CompletePopup_cancel')]/a";
	String buttonSiCancelarTransaccion = "//div[contains(@id,'CancelPopupRegionContainer_yes')]/a";
	String buttonRenovacion = "//div[contains(@id,'RenewalPolicyOnlineRenew')]/a";
	String buttonCompletarRenovacion = "//div[contains(@id,'PolicyRenewalDetailsContinue')]";
	String buttonAceptarRenovacion = "//div[contains(@id,'CompletePopup_ok')]";
	String buttonAceptarAjuste = "//div[contains(@id, 'AdjustPolicyPopup_ok')]";
	String buttonOrdDesc = "//td[@afrsortdesc=\"1\"]";
	String buttonRenovar = "//div[contains(@id,'CoverTreeRenewButtonGltbb')]";
	String buttonCreateclaim = "//span[contains(text(),'Create Claim')]//ancestor::a";
	String buttonSeleccionarDiaHora = "//td[contains(text(),'dia')]";
	String buttonSelectFechadeAjuste = "(//label[text()='Fecha de ajuste de la póliza']//following::a)[1]";
	String buttonSeleccionarLiquidador = "(//span[contains(text(),'IDLiquidador')])[1]";
	String buttonAceptarLiquidador = "//td[contains(@id,'dialog0')]//a[@accesskey='A']";
	String buttonNuevoAgente = "(//div[contains (@id, 'PolicyAgentPC:PolicyAgentArl')]//span[contains(text(),'Nuevo')])";
	String buttonSeleccionarCorredor = "//span[contains(@id, 'AgentLOVAgentNoAlt')][contains(text(),'numAgente')]";
	
	// labels
	String labelPaginaPrincipal = "//*[@id=\"pt:sf_c:dr0:0:pt:HomeWorkplaceRgLc0:0:pt:ph0::_afrTtxt\"]/div/h1";
	String labelPaginaResumenEntidad = "//h1[contains(text(),'Resumen de entidad')]";
	String labelManejoPoliza = "//h1[contains(text(),'Manejo de póliza')]";
	String labelSiniestro = "//h1[contains(text(),'Nom_producto')]";
	String labelManejoLineaPoliza = "//h1[contains(text(),'Manejo de líneas de póliza')]"; 
	String labelManejoLineaPolizaV2 = "//tbody/tr[2]/td/div/span[2]/span/a/span[contains(text(),'Elotro Onco Automa Tia')]";
	String labelNumeroLineaPoliza = "//tr[contains(@id,'DynamicObjectAgrLineNo')]/td/span[contains(@id,'DynamicObjectAgrLineNo::content')]";
	String labelManejoObjeto = "//h1[contains(text(),'Manejo de objetos')]";
	String labelPrimaTotal = "//span[contains(@id,'RiskPrice')]";
	String LabelPrecioTarifa = "//label[text()='Precio de tarifa:']//following::span[1]";
	String labelPrecioPagado = "//label[text()='Precio pagado:']//following::span[1]";
	String labelMensajeContratanteFallecido = "//div[@class='x18e' and text()='El contratista no está vivo. ']";
	String labelMensajeContratanteErroneo = "//div[contains(text(), 'Sólo los particulares pueden comprar pólizas personales ')]";
	String labelMensajeContratanteInhabilitado = "//div[contains(text(), 'está suspendido')]";
	String labelModalDocumentosPoliza = "//div[contains(text(),'Documentos de póliza')]";
	String labelMensajeContratanteMenorEdad = "//div[@class='x18e' and text()='La edad del contratante no puede ser menor de 18 años. ']";
	String labelPaginaSiniestro = "//h1[contains(text(),'Crear siniestro')]";
	String labelSiniestroAbierto = "//h1[contains(text(),'Notificado')]";
	// String labelSiniestro = "//h1[contains(text(),'Nom_producto')]";
	String labelSiniestroError = "//td[contains(text(),'Error')]";
	String labelNombreReceptor = "(//label[contains(text(),'Nombre')]/following::table[@role='presentation']/following::span[@class='x25'])[1]";
	String labelRolReceptor = "(//label[contains(text(),'Nombre')]/following::table[@role='presentation']/following::span[@class='x25'])[2]";
	String labelItems = "//td[contains(text(),'Items')]";
	String msgErrorFechaSiniestroSuperiorDenuncia = "//div[contains(text(),'fecha del siniestro')]";
	String msgErrorFechaSiniestroEnBlanco = "//div[contains(text(),'Debe introducir un valor')]";
	String msgErrorFechaSiniestroSuperiorDiaActual = "//div[contains(text(),'Fecha del siniestro')]";
	String msgErrorFechaDenunciaSuperiorDiaActual = "//div[contains(text(),'Fecha de denuncia')]";
	String labelEditarActivado = "//img[contains(@title,'Activado')]";
	String labelPaginaInformacionEntidad = "//h1[contains(text(), 'Información de la entidad')]";
	String labelTipoTransaccion = "(//label[contains(text(),'transacción')]/following::span[@class='x2h'])[1]";
	String labelPolizaCancelada = "(//span[contains(text(), 'id-poliza')]//following::span[@class='x25s policyStatusCancel'])[1]";
	String labelPolizaCancelada2 = "(//span[contains(text(), 'id-poliza')]//following::span[contains(text(), '- Cancelado')])[1]";
	String labelIngresarPoliza = "//*[contains(text(), 'id-poliza')]";
	String labelEstadoPolizaCancelada = "//*[contains(text(), 'C Cancelar póliza')]";
	String labelObjeto = "//label[contains(text(),'Objeto N°')]/following::span[contains(@id,'ObjectNo') and @class='x25']";
	String labelDetallesRenovacion = "//h1[contains(text(),'Detalles de renovación')]";
	String labelNoRenovacion = "//span[contains(text(),'No se encontraron filas')]";
	String labelLoteRenovacion = "//span[contains(@id,'PolicyRenewalDetailsRenewalBatchNo')]";
	String labelPolizaSiniestrar = "//span[text()='id-poliza']";
	String labelPagosReservas = "//h1[contains(text(), ' Total de siniestros')]";
	String labelInstPago = "//span[contains(text(),'BANK')]";
	String labelPaid = "(//label[contains(text(),'Pagado')]//following::span)[1]";
	String LabelDetalleSiniestro = "//div/div[1]/a[contains(text(),'Detalles de siniestro')]";
	String labelSiniestro2 = "//*[contains(text(),'N° de siniestro')]//following::input[1]";
	String labelHome = "//*[@id='pt:sf_t:dynTabsPane:0:tabIndex::disclosureAnchor']";
	String labelInformacionDelPago = "//tr/td[contains(text(),'Información del pago')]";
	String labelEstadoTransaccion = "//tr[contains(@id,'PolicyTransactionType')]";
	String labelPrimaTotalUFParteSuperior = "//span[contains(@id,'DynamicObjectTariffPrice::content')]";
	String labelCoberturaActiva = "//div[contains(@id,'ClaimCaseRiskLOVPC:ClaimCaseRiskLOVTab')]//span[text()='*']";
	
	// a
	String aBuscarEntidad = "//*[@id=\"pt:sf_c:dr0:0:pt:HomePartySearch\"]";
	String aNumeroEntidad = "//span[contains(text(),'Nombre')]//preceding::a[1]";
	String aLineaPoliza = "//span[contains(text(),'id-poliza')]//following::a[contains(@id,'PolicyMenuTree') and contains(@class,'TextOnly')][1]";
	String aLineaPolizaV2 = "(//a[contains(@id,'PolicyMenuTree') and contains(@class,'TextOnly')]//following::span[contains(text(),'id-linea-poliza')])[1]";
	String aPoliza = "//a[contains(@id,'CoverTreePolicyNoAlt')]/span[contains(text(),'id-poliza')]";
	String aPolizaV2 = "//tr[@role='treeitem' and @aria-level='3']/preceding-sibling::tr[@role='treeitem' and @aria-level='1']";
	String aPolizav3 = "//*/tbody/tr[*]/td[1]/div/span[2]/a/span[contains(text(),'id-poliza')]";
	String aObjeto = "//span[contains(text(),'id-objeto')]";
	String aEntidad = "//span[contains(text(), 'id-entidad')]";
	String aHome = "//a[contains(text(),'Home')][1]";
	String aCerrarPaginaBusqueda = "//a[contains(text(),'Buscar entidades')]/following::a";
	String aOrdenarFechaRenov = "//table[contains(@id,'CoverTreeRenewalDateCol')]//a[contains(@title,'Orden Ascendente')]";
	String aRerservasPagos = "(//a[contains(text(), 'Reservas y Pagos')])[1]";
	String aNombreEntidadSeccionRelacion = "//a[contains(@id,'PartyTreeParentTree:0:cl0')]";

	// option
	String listOpciones = "//li[@role='option']";
	String listOpcionBusquedaRapida = "//ul[contains(@id,'afrautosuggestpopup')]/li[1]";
	
	// Checkbox
	String checkBoxSeleccionSiniestro = "(//span[@class='xk4']//input)[1]";
	String checkBoxFechaEstimadaTrans = "//input[contains(@id,'WhenExactIncidentDate')]";

	// select
	String selectFinicio = "//input[contains(@id,'PolicyCoverStartDate::content')]";
	String selectCanalVenta = "(//label[text()='Canal de ventas']//following::select)[1]";
	String selectLugar = "//label[text()='Lugar de Siniestro']/following::select[1]";
	String selectInformante = "//label[text()='Tipo de informante']/following::select[1]";
	String selectTipoDenuncia = "//label[text()='Tipo de Denuncia']/following::select[1]";
	String selectTipoEndoso = "//select[contains(@id,'PolicyEndorReasonIdPopup::content')]";
	String selectTipoItem = "//label[text()='Tipo de item']/following::select[1]";
	String selectTipoSubItem = "(//label[text()='Tipo de sub item']/following::select)[2]";
	String selectMotivoCancelacion = "(//label[contains(text(),'Cancelar código')]/following::select[contains(@id,'PolicyCancelCode')])[1]";
	String selectItemsPagar = "(//label[contains(text(), 'Pagar')]//following::input)[1]";
	String selectTipoRespuesta = "(//label[text()='Tipo de respuesta']//following::select)[1]";
	String selectListaEvento = "//select[contains(@id,'WhatHappenedEventType')]";
	String selectCasua = "//select[contains(@id,'WhatHappenedCauseType')]";
	String selectSubCoberturaNumero = "//select[contains(@id,'WhatHappenedSubriskNo')]";
	String selectPlataforma = "(//label[text()='Plataforma']//following::select)[1]";
	String selectCategoriaAgente = "//select[contains(@id, 'PolicyAgentAgentRole')]";

	// Loading
	String loadingTia = "//span[contains(@id,'pt_statInd')]//img[@title='Inactivo']";
	String loadingBusquedaRapida = "//div[contains(@id,'_afrautosuggestbusydiv')]";
	
	//
	String listaPoliza = "//*[@id='pt:sf_c:dr2:0:pt:PolicyTreeRgLc0:0:pt:PolicyMenuTree::scroller']";
	String inputFechaDenuncia1 = "//td[3]/table/tbody/tr/td/table/tbody/tr[2]/td/input[contains(@placeholder,'dd.mm.yyyy H:mm')]";
	
	//Transversal
	String collapseSiniestroHF = "//td[contains(@id,'CustomerWrkPlCustomerWrkPlRegionContainerClaimTab') and @class='x1ep']//a";
	String buttonBarraLateralHF = "//a[contains(@aria-controls,'ClaimCaseClaimCaseRegionContainerPs')]";
	String buttonCerrarSegventana = "//*[@id='pt:sf_t:dynTabsPane:2:tabIndex::rmAbv']"; 
	String buttonSeleccionarFechaInicioPoliza = "//label[text()='Fecha de inicio de cobertura']//following::a[contains(@id,'PolicyCoverStartDate')]";
	String buttonDisminuirAnnoPoliza = "//a[@title='Disminuir']";
	String buttonSeleccionarDia = "//td[contains (@class, 'p_AFSelected')]";
	String OrderByASCRenovacion = "//th[contains(@id,'CoverTreeRenewalDateCol')]//td[1]/a";
	String buttonFechaRenovacionTEST = "//th[contains(@id,'CoverTreeRenewalDateCol')]";
	String buttonNumPoliza = "//th[contains(@id,'CoverTreePolicyNoAltCol')]";
	String fechaInicioCobertura = "//td[1]/table/tbody/tr[1]/td/table/tbody/tr[2]/td/input[contains(@placeholder, 'dd.mm.yyyy')]"; 
	String fechaInicioPoliza = "//*[@id='pt:sf_c:dr2:0:pt:TIADynamicTaskFlowRg:1:pt:PolicyCoverStartDate::content']"; 
	String buttonEncabezadoPoliza = "//span[contains(@id,'CoverTreeTab:ol0')]";
	
	String collapseLateralBar = "//img[contains(@src,'collapsed')]//ancestor::a[@aria-label='nombre-seccion']";
	
	String BusquedaTransversal = "//input[contains(@id,'pt:sf_t:searchTB:pt_it1::content')]";
	
	String imgDespliegueModuloInteroObjeto = "//td[contains(@title,'TituloModulo')]//ancestor::td[@class='x1es']//preceding-sibling::td//img[contains(@src,'collapsed')]/parent::a";
	
	String enlaceLineaPolizaEnPolizaMaestra = "//span[contains(@id,'ViewPolicyLinesAgrLineNo::text')]/parent::a";

	//img
	String imgBuscarLiquidador = "//img[contains(@id,'sbi1')]/ancestor::span";
	String imgBuscarNumAgente = "//img[contains(@id,'PolicyAgentAgentNoAltIcon')]";
	
	//span
	String spanBuscarNumeroCobertura = "//img[contains(@id,'WhatHappenedRiskNoIcon')]//ancestor::a";
}
