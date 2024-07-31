package main.java.pageObjects.tia.productos;

public interface HogarFullElements {
	
	String selectTipoContratante = "//label[contains(text(),'Tipo de Contra')]//following::select[1]";
	String selectTipoPropiedad = "(//label[text()='Propiedad Tipo']//following::select)[1]";
	String selectRangoAniosPropiedad = "(//label[text()='Propiedad Rangos de años']//following::select)[1]";
	String selectTipoUsoPropiedad = "(//label[text()='Propiedad Tipo Uso']//following::select)[1]";
	String selectMaterialConstruccion = "(//label[text()='Propiedad Material Construccion']//following::select)[1]";
	String selectEvento = "//label[text()='Evento']/following::select[1]";
	String selectCausa = "//label[text()='Causa']/following::select[1]";
	String selectRespuesta1 = "//td[contains(text(), 'Asistente de preguntas')]/following::select";
	String selectMetodosPago = "//label[contains(text(), 'Método')]/following::select[contains(@id,'PaymentMethod')]";
	
	String inputIDPropiedad = "//label[text()='Propiedad Identificación']//following::input[1]";
	String inputPropiedadCalle = "(//label[text()='Propiedad Calle']//following::input)[1]";
	String inputPropiedadNumero = "(//label[text()='Propiedad Calle Número']//following::input)[1]";
	String inputRegion = "(//label[text()='Propiedad Región']//following::input)[1]";
	String inputComuna = "(//label[text()='Propiedad Comuna']//following::input)[1]";
	String inputNumeroCasa = "(//label[text()='Propiedad N Casa Número']//following::input)[1]";
	String inputNumeroDepto = "(//label[text()='Propiedad Depto Número']//following::input)[1]";
	String inputNumeroPisoDepto = "(//label[text()='Propiedad Depto Piso Número']//following::input)[1]";
	String inputM2Propiedad = "(//label[text()='M2Edificio']//following::input)[1]";
	String inputMontoAseguradoIncendioEdificio = "(//span[text()='Incendio Edificio']//following::input)[2]";
	String inputMontoAseguradoIncendioContenido = "(//span[text()='Incendio Contenido']//following::input)[2]";
	String inputMontoAseguradoRobo = "(//span[text()='Robo Contenido']//following::input)[2]";
	String inputDescCobertura = "//label[contains(text(),'Descripción de cobertura')]/following::input[1]";
	String inputRespuesta2 = "//label[contains(text(),'RUT del informante')]/ancestor::tr[contains(@id,'FnolQuestionWizardGroupRegionRgLc0')]//textarea";
	String inputRespuesta3 = "//label[contains(text(),'Correo del informante')]/ancestor::tr[contains(@id,'FnolQuestionWizardGroupRegionRgLc0')]//textarea";
	String inputRespuesta4 = "//label[contains(text(),'Telefono del informante')]/ancestor::tr[contains(@id,'FnolQuestionWizardGroupRegionRgLc0')]//textarea";
	String inputCobertura = "(//div[contains(text(), 'Seleccionar')]//following::input[contains(@id,'ClaimCaseRiskLOVTab')])[2]";
	String inputIdPoliza = "//input[contains(@id,'SearchAccountItemPolicyNoAlt')]";
	String inputNoCuenta = "//input[contains(@id,'AccountNo')]";
	String buttonItemCuenta = "//input[contains(@id,'AccItemNo')]//following::img";
	String inputItemCuenta = "(//input[contains(@id,'AccItemNoLovPC') and contains(@class,'x25')])[1]";
	String inputItemCuenta2 = "(//input[contains(@id,'AccItemNo') and contains(@class,'x25')])[1]";
	
	String buttonObtenerDetallesPropiedad = "//span[@class='xfx' and text()='Obtener Detalles Del Propiedad']//ancestor::a[@class='xfp']";
	String buttonProductoHogar = "(//span[contains(text(),'Hogar')]//preceding::a[@class='xgp'])[2]";
	String buttonBusquedaCobertura = "//label[text()='Cobertura N°']/following::img[1]";
	String buttonAceptaSeleccion = "(//span[contains(text(),'cepta')])[3]";
	String buttonAprobar = "//span[text()='Aprobar']";
	String buttonAmpliar = "//div[@title='Separar']/a";
	String buttonUnir = "//div[@title='Unir']/a";
	String buttonAdministracion =  "//span[contains(text(), 'Administración')]";
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
	String buttonSi2 = "/html/body/div[1]/form/div[2]/div[2]/div[1]/div[1]/table/tbody/tr/td/div/div/table/tbody/tr[3]/td[2]/table/tbody/tr/td[1]/div[1]/a";
	String buttonNuevaPolizaHF = "//span[@class='xfx' and text()='Nuevo']//ancestor::a[@class='xfp']";
	String buttonSelecFecInicioCobertura = "(//label[text()='Fecha de inicio de cobertura']//following::a)[1]";
	
	String checkboxCasaCondominio = "(//label[text()='¿Es la propiedad un condominio?']//following::input)[1]";
	String checkboxRoboContenido = "(//span[text()='Robo Contenido']//following::input)[1]";
	String checkboxSismo = "(//span[text()='Sismo']//following::input)[1]";
	String checkboxReembolsoGastosMedicos = "(//span[text()='Reembolso Gastos Médicos (AP)']//following::input)[1]";
	String checkboxMascotasRC = "(//span[text()='Responsabilidad Civil Mascotas']//following::input)[1]";
	String checkboxMuerteAccidental = "(//span[text()='Muerte Accidental (AP)']//following::input)[1]";
	String checkboxCyber = "(//span[text()='Cyber']//following::input)[1]";
	String checkboxMascotas = "(//span[text()='Mascotas']//following::input)[1]";
	String checkboxTelemedicina = "(//span[text()='Telemedicina']//following::input)[1]";
	String checkboxMedidasSeguridad = "(//label[contains(text(),'¿La propiedad a ase')]/following::input)[1]";

	String labelPaginaCrearSiniestro = "//h1[contains(text(),'Crear siniestro')]";
	String labelCobertura = "//label[text()='Cobertura']/following::span[text()='cobertura'][1]";
	String labelEstadoPreguntasOK = "//span[text()='OK']";
	String labelPaginaAdmin = "//td[contains(@title, 'Administración')]";
	String labelNoCuenta = "//span[contains(text(),'1 Factura (cuentas por cobrar)')]//preceding::span[contains(@id,'ResultsGroupAccountNo')]";
	String labelItemCuenta = "//span[contains(text(),'1 Factura (cuentas por cobrar)')]//preceding::span[contains(@id,'ResultsGroupAccItemNo')]";
	String labelEstadoPago = "(//span[contains(text(),'1 Factura (cuentas por cobrar)')]//following::span[contains(@id,'GroupPaymentStatus::content')])[1]";
	String labelMontorevertido = "//span[contains(text(),'2 Asesoramiento crediticio (Cuentas por cobrar)')]//following::span[contains(@id,'ResultsGroupCurrencyAmt::content')]";
	String labelItemCuentaSeleccionar = "//span[text()='no-item']";
	//Loanding
	String loadingTia = "//span[contains(@id,'pt_statInd')]//img[@title='Inactivo']";
	String listOpcionesHF = "//li[@role='option']";
	String buttonSiHF = "//span[@class='xfx' and text()='Sí']//ancestor::a[@class='xfp']";
	String labelManejoPolizaHF = "//h1[contains(text(),'Manejo de póliza')]";
	String selectCanalVentaHF = "(//label[text()='Canal de ventas']//following::select)[1]";
	String collapseResumenPolizaHF = "//h2[contains(@id,'PolicyAccordionContainerPolicyPolicySummaryRegionTab::head') and @class='x1en p_AFDisclosable p_AFDisclosed p_AFFlow']//a";
	String collapseInfoPolizaHF = "//h2[contains(@id,'PolicyAccordionContainerPolicyItemRegionPOTab::head') and @class='x1eo p_AFDisclosable p_AFFlow']//a";
	String collapseInfoObjetoHF = "//h2[contains(@id,'ObjectAccordionContainerGeneralInformation0AccordionTab::head') and @class='x1en p_AFDisclosable p_AFFlow']//a";
	String buttonGuardarHF = "//span[@class='xfx' and text()='Guardar']//ancestor::a[@class='xfp']";
	String buttonNuevaLineaPolizaHF = "//span[@class='xfx' and text()='Nueva línea de póliza']//ancestor::a[@class='xfp']";
	String labelManejoObjetoHF = "//h1[contains(text(),'Manejo de objetos')]";
	String labelObjetoHF = "//label[contains(text(),'Objeto N°')]/following::span[contains(@id,'ObjectNo') and @class='x25']";
	String buttonCompletarHF = "//span[@class='xfx' and text()='Completar']//ancestor::a[@class='xfp']";
	String labelModalDocumentosPolizaHF = "//div[contains(text(),'Documentos de póliza')]";
	String buttonAceptaCompletarPolizaHF = "//div[contains(@id,'CompletePopup_ok')]/a";
	String buttonAmpliarVentanaPolizasHF = "//div[contains(@_afrclmwmn,'CoverTreePolicyNoAltCol')]//div[contains(@title,'Separar')]";
	String aPolizaHF = "//span[contains(text(),'id-poliza') and contains(@id,'CoverTreePolicyNoAlt')]";
	String aPolizaAlternHF = "//span[contains(text(),'id-poliza')";
	String buttonAjustarHF = "//span[contains(text(), 'Ajustar ')]";
	String buttonAceptaAjusteHF = "//label[contains(text(), 'Fecha de ajuste ')]/following::span[contains(text(), 'Aceptar')][1]";
	String labelTipoTransaccionHF = "(//label[contains(text(),'transacción')]/following::span[@class='x2h'])[1]";
	String selectMotivoCancelacionHF = "(//label[contains(text(),'Cancelar código')]/following::select[contains(@id,'PolicyCancelCode')])[1]";
	String labelPolizaCanceladaHF = "(//span[contains(text(), 'id-poliza')]//following::span[@class='x25s policyStatusCancel'])[1]";
	String aBuscarEntidadHF = "//*[@id=\"pt:sf_c:dr0:0:pt:HomePartySearch\"]";
	String inputApellidoHF = "//label[contains(text(),'Apellido')]//following::input[@type='text'][1]";
	String buttonBuscarEntidadHF = "//span[@class='xfx' and text()='Buscar']//ancestor::a[@class='xfp']";
	String aNumeroEntidadHF = "//span[contains(text(),'Nombre')]//preceding::a[1]";
	String aNombreEntidadHF = "(//span[contains(text(),'Nombre')])[1]";
	String labelPaginaResumenEntidadHF = "//h1[contains(text(),'Resumen de entidad')]";
	String buttonIniciarSesionHF = "//*[@id=\"r1:0:pt:s1:login\"]/a";
	String inputUsuarioHF = "//*[@id=\"r1:0:pt:s1:username::content\"]";
	String inputPasswordHF = "//*[@id=\"r1:0:pt:s1:password::content\"]";
	String labelPaginaPrincipalHF = "//*[@id=\"pt:sf_c:dr0:0:pt:HomeWorkplaceRgLc0:0:pt:ph0::_afrTtxt\"]/div/h1";
	String aHomeHF = "//a[contains(text(),'Home')][1]";
	String labelMensajeErrorCancelacionHF = "//div[contains(text(),'cancelación por parte del asegurado después de 10 días')]";
	String buttonSeleccionarFechaInicioPolizaHF = "//label[text()='Fecha de inicio de cobertura']//following::a[contains(@id,'PolicyCoverStartDate')]";
	String buttonDisminuirAnnoPolizaHF = "//a[@title='Disminuir']";
	String buttonSeleccionarDiaHF = "//td[contains (@class, 'p_AFSelected')]";
	String aPolizaRenovarHF = "//span[contains(text(),'id-poliza') and contains(@id,'CoverTreePolicyNoAlt::text')]//following::span[contains(text(),'id-producto') and contains(@id,'CoverTreeProdId')][1]";
	String buttonRenovarHF = "//div[contains(@id,'CoverTreeRenewButtonGltbb')]";
	String buttonRenovacionHF = "//div[contains(@id,'RenewalPolicyOnlineRenew')]/a";
	String buttonCompletarRenovacionHF = "//div[contains(@id,'PolicyRenewalDetailsContinue')]";
	String buttonAceptarRenovacionHF = "//div[contains(@id,'CompletePopup_ok')]";
	String labelPaginaRenovacionHF = "//h1[contains(text(),' Renovación de póliza en línea')]";
	String labelPolizaRenovarHF = "//span[contains(@id,'RenewalPolicyOnlinePolicyNoAlt')]";
	String labelPaginaRenovadaHF = "//span[contains(text(),'R Renovación')]";
	String aObjetoHF = "//span[contains(text(),'id-objeto')]";
	String inputFechaAjusteHF = "//label[contains(text(), 'Fecha de ajuste ')]/following::input[1]";
	String labelEditarActivadoHF = "//img[contains(@title,'Activado')]";
	String labelPrimaTotalHF = "//span[contains(@id,'RiskPrice')]";
	String buttonCalculateHF = "//span[@class='xfx' and text()='alculate']//ancestor::a[@class='xfp']";
	String aLineaPolizaHF = "//span[contains(text(),'id-poliza')]//following::a[contains(@id,'PolicyMenuTree') and contains(@class,'TextOnly')][1]";
	String labelManejoLineaPolizaHF = "//h1[contains(text(),'Manejo de líneas de pólizas')]";
	String collapseSiniestroHF = "//td[contains(@id,'CustomerWrkPlCustomerWrkPlRegionContainerClaimTab') and @class='x1ep']//a";
	String collapsePolizaHF = "//h2[contains(@id,'CustomerWrkPlCustomerWrkPlRegionContainerCoverTab::head') and @class='x1eo p_AFDisclosable p_AFFlow']//a";
	String fechaInicioCobertura = "//td[1]/table/tbody/tr[1]/td/table/tbody/tr[2]/td/input[contains(@placeholder, 'dd.mm.yyyy')]"; 

	String buttonCrearSiniestroHF = "//span[contains(text(),'Crear siniestro')]//ancestor::a";
	String buttonCrearSiniestroAlternHF = "//span[contains(text(),'Create Claim')]//ancestor::a";
	String labelPaginaSiniestroHF = "//h1[contains(text(),'Crear siniestro')]";
	String inputFechaSiniestroHF = "//label[text()='Fecha del siniestro']//following::input[1]";
	String inputFechaDenunciaHF = "//label[text()='Fecha de denuncia']//following::input[1]";
	String buttonBusquedaPolizaAltHF = "//label[text()='Línea de póliza N°']//following::a[1]";
	String buttonAceptaSeleccionHF = "(//span[contains(text(),'cepta')])[3]";
	String inputFechaSiniestroResultado = "//label[contains(text(),'Mostrar información del objeto acordeón')]//preceding::input[2]";
	String inputIdLineaPolizaHF = "//label[contains(text(),'Mostrar información del objeto acordeón')]//following::input[3]";
	String inputObjetoHF = "//label[text()='Objeto N°']//following::input[1]";
	String labelPolizaSiniestrarHF = "//span[text()='id-poliza']";
	String inputDescripHechoHF = "//label[text()='Descripción del Hecho']//following::textarea[1]";
	String selectInformanteHF = "//label[text()='Tipo de informante']/following::select[1]";
	String selectTipoDenunciaHF = "//label[text()='Tipo de Denuncia']/following::select[1]";
	String inputNombInformHF = "//label[contains(text(), 'Nombre del informante')]//following::input[1]";
	String selectLugarHF = "//label[text()='Lugar de Siniestro']/following::select[1]";
	String buttonGenerarSiniestroHF = "//span[contains(text(),'Generar Siniestro')]";
	String buttonGuardarReservaHF = "//span[contains(text(),'Guardar')]";
	String labelNotificacionSiniestroHF = "//span[contains(text(),'Notificación de siniestro')]";
	String buttonBarraLateralHF = "//a[contains(@aria-controls,'ClaimCaseClaimCaseRegionContainerPs')]";
	String labelSiniestroHF = "//h1[contains(text(),'Nom_producto')]";
	String inputIdGestorHF = "(//label[contains(text(), 'Gestor de siniestros')]//following::input)[1]";
	String inputIdReceptorHF = "//div[contains(text(),'Seleccionar')]//following::input[3]";
	String inputNombreReceptorHF = "//label[contains(text(),'Nombre del destinatario') and @class='af_inputText_label-text']/following::input[1]";
	String inputRolReceptorHF = "//label[contains(text(),'Rol') and @class='af_inputText_label-text']/following::input[1]";
	String inputReservaHF = "//input[contains(@id,'ItemDetailCurrencyEstimate')]";
	String inputIdLiquidReceptorHF = "(//label[contains(text(),'Id receptor')]/following::input)[1]";
	String labelSiniestroErrorHF = "//td[contains(text(),'Error')]";
	String labelNombreReceptorHF = "//td[contains(@id,'ReceiverLOVNameCol')]";
	String labelRolReceptorHF = "//td[contains(@id,'ReceiverLOVRoleDescriptionCol')]";
	String labelItemsHF = "//td[contains(text(),'Items')]";
	String msgErrorFechaSiniestroSuperiorDenunciaHF = "//div[contains(text(),'Fecha del siniestro')]";
	String msgErrorFechaSiniestroEnBlancoHF = "//div[contains(text(),'Debe introducir un valor')]";
	String msgErrorFechaSiniestroSuperiorDiaActualHF = "//div[contains(text(),'Fecha del siniestro')]";
	String msgErrorFechaDenunciaSuperiorDiaActualHF = "//div[contains(text(),'Fecha de denuncia')]";
	String buttonSeleccionarFechaSiniestroHF = "//label[text()='Fecha del siniestro']//following::a[1]";
	String buttonSeleccionarFechaDenunciaHF = "//label[text()='Fecha de denuncia']//following::a[1]";
	String buttonFechaSuperiorDiaActualHF = "//td[contains (@class, 'p_AFSelected')]/following::td[1]";
	String buttonFechaAnteriorDiaActualHF = "//td[contains (@class, 'p_AFSelected')]/preceding::td[1]";
	String buttonFechaDenunciaAnteriorDiaActualHF = "//td[contains (@class, 'p_AFSelected')]/preceding::td[2]";
	//String buttonFechaDenunciaSuperiorDiaActualHF = "//td[contains (@class, 'p_AFSelected')]/following::td[1]";
	String buttonAceptarFechaHF = "(//button[contains(text(),'Aceptar')])[2]";
	String buttonReservaHF = "//span[contains(text(),'Reserva')]/ancestor::a";
	String buttonNuevoItemHF = "//span[contains(text(),'Nuevo item')]";
	String selectTipoItemHF = "//label[text()='Tipo de item']/following::select[1]";
	String selectTipoSubItemHF = "(//label[text()='Tipo de sub item']/following::select)[2]";
	String buttonBusquedaReceptorHF = "//label[text()='Id receptor']//following::img[1]";
	String inputIdLiquidadorHF = "(//label[contains(text(), 'Liquidador')]//following::input)[1]";
	String aRerservasPagosHF = "(//a[contains(text(), 'Reservas y Pagos')])[1]";
	String labelPagosReservasHF = "//h1[contains(text(), ' Total de siniestros')]";
	String selectItemsPagarHF = "(//label[contains(text(), 'Pagar')]//following::input)[1]" ;
	String buttonSiguienteHF = "//span[contains(text(),'Siguiente')]";
	String buttonSeleccionaInstPagoHF = "//label[contains(text(),'Instrucción de pago')]//following::img";
	String buttonAceptaInstPagoHF = "(//span[contains(text(),'cepta')])[2]";
	String buttonFinalizarPagoHF = "//span[contains(text(),'Finalizar pago')]";
	String buttonNoCerrarReservaHF = "(//span[contains(text(),'No')])[3]";
	String buttonLiquidarHF = "//span[contains(text(), 'Liquidar')]";
	String inputMontoLiquidHF = "(//input[following::label[contains(text(),'Nueva Reserva')]])[last()]";
	String labelInstPagoHF = "//span[contains(text(),'BANK')]";
	String labelPaidHF = "(//label[contains(text(),'Pagado')]//following::span)[1]";
	String selectTipoEndosoHF = "//select[contains(@id,'PolicyEndorReasonId')]";
	String selectTipoEndosoAlternativoHF = "//select[contains(@id,'PolicyEndorReasonIdPopup')]";
	String labelFechaSiniestro = "//input[contains(@id,'WhenIncidentDate')]";
	String labelFechaDenuncia = "(//input[contains(@id,'WhenNotificationDate')])[1]";
	String buttonReservasPagosHF = "(//a[contains(text(), 'Reservas y Pagos') and contains(@id,'ItemsAndPaymentsTopLcSdi') and @class='x164'])[1]";
	String textareaNumeroDeFactura = "//textarea[contains(@id,'PaymentTrainAccountItemItemReference::content') and @class='x25']";
	String filaConLiquidador = "//span[contains(@id,'TIADynamicTaskFlowRg') and contains(text(),'nombreLiquidador')]";
}