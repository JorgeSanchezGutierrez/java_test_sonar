package main.java.pageObjects.portalSB.transversal;

public interface TransversalPortalSBElements {

	//titulo
	String tituloPortalSB = "//h1[@class='etiqueta']";
	String tituloTerminosCondiciones ="//div[contains(@class,'v-dialog__content--active')]//div[@class='v-card__title']//span";
	String tituloResumen  = "//h3[contains(text(),'ESTAMOS A UN PASO')]";
	
	//Contents
	String contenidoTerminoCondiciones = "//div[contains(@class,'v-dialog__content--active')]//div[@class='v-card__text']";
	
	//input
	String inputNombre = "//input[@id='input-20' or @id='input-22']";
	String inputApellido = "//input[@id='input-23' or @id='input-25']";
	String inputCorreo = "//input[@id='input-26' or @id='input-28']";
	String inputNombreInfo = "(//div[@class='form-container']/div[contains(@class,'col')]/div[contains(@class,'v-text-field--enclosed')]//input)[1]";
	String inputApellidoInfo = "(//div[@class='form-container']/div[contains(@class,'col')]/div[contains(@class,'v-text-field--enclosed')]//input)[2]";
	String inputCorreoInfo = "(//div[@class='form-container']/div[contains(@class,'col')]/div[contains(@class,'v-text-field--enclosed')]//input)[3]";
	String inputTelefonoInfo = "(//div[@class='form-container']/div[contains(@class,'col')]/div[contains(@class,'v-text-field--enclosed')]//input)[4]";
	String inputRutInfo = "(//div[@class='form-container']/div[contains(@class,'col')]/div[contains(@class,'v-text-field--enclosed')]//input)[5]";
	String inputNumeroDoc = "(//div[@class='form-container']/div[contains(@class,'col')]/div[contains(@class,'v-text-field--enclosed')]//input)[6]";
	String inputNombreCalle = "(//div[@class='form-container']/div[contains(@class,'col')]/div[contains(@class,'v-text-field--enclosed')]//input)[7]";
	String inputNumeroTarjetaWebPay = "//input[@aria-describedby='card-number']";
	String inputFechaExpiracionWebPay = "//input[@aria-describedby='card-exp']";
	String inputCVVWebPay = "//input[@aria-describedby='card-cvv']";
	String inputRutTransbank ="//input[@id='rutClient']";
	String inputContraseniaTransbank = "//input[@id='passwordClient']";
	
	//Select
	String selectRegionInfo = "(//div[@class='form-container']/div[contains(@class,'col')]/div[contains(@class,'v-text-field--enclosed')]//input)[8]";
	String selectComunaInfo = "(//div[@class='form-container']/div[contains(@class,'col')]//div[contains(@class,'v-select__selections')]//input)[5]";
	String selectMesInfo = "(//div[@class='row']//div[@aria-haspopup='listbox']//div[@class='v-select__selections']//input)[1]";
	String selectDiaInfo = "(//div[@class='row']//div[@aria-haspopup='listbox']//div[@class='v-select__selections']//input)[2]";
	String selectAnioInfo = "(//div[@class='row']//div[@aria-haspopup='listbox']//div[@class='v-select__selections']//input)[3]";
	String inputNumeroCalle = "(//div[@class='number-address']//input)[1]";
	String inputtDepto = "(//div[@class='number-address']//input)[2]";
	String selectBancoWebPay = "//button[contains(@class,'combobox-button')]";
	String selectOpcionTransbank = "//select[@id='vci']";
	
	//Lista Select
	String listaSelect = "//div[@role='listbox' and contains(@id,'numeroId')]/div";
	
	//img
	String imgLogoSB = "//div[@class='desktop-logo-container']/img[contains(@src,'SB_logo')]";
	String imgPlanDog = "//img[contains(@src,'dog')]";
	String imgWebpay = "//img[contains(@alt, 'Webpay')]";
	
	//CheckBox
	String checkBoxTerminoCondiciones = "//div[contains(@class,'input--checkbox')]//input";///parent::div
	String checkBoxConfirmarCorreoWebPay = "//input[@id='accept-terms']/following-sibling::span";
	
	//enlaces
	String aTerminosCondiciones = "//div[contains(@class,'input--checkbox')]//a";
	
	//button
	String buttonAceptarTerminoCondiciones = "//div[contains(@class,'v-dialog__content--active')]//button";
	String buttonContinuar = "//div[@class='button-container']//button";
	String buttonIrPagar = "//button[contains(@class,'v-btn--is-elevated')]";
	String buttonConfirmarPago = "//button[contains(@class,'submit')]";
	String buttonTipoTarjeta = "//button[@id='id-tipotarjeta']";
	String buttonAceptarTransbank = "//input[@value='Aceptar']";
	String buttpnContinuarTransbank = "//input[@value='Continuar']";
	String buttonRevisarDetalle = "//button[text()='Revisar detalle']";
	
	//Label
	String labelFlujoNavegacion = "//div[contains(@class,'v-stepper__step--active')]//div[@class='v-stepper__label']";
	String labelTodosNombrePlan = "//div[@class='planContainer' or @class='plan-container']//*[contains(text(),'Plan')]";
	String labelNombreContratanteResumen = "//div[contains(@class,'v-card')]/div/label[2]";
	String labelRutResumen = "//div[contains(@class,'v-card')]/div/label[4]";
	String labelTelefonoResumen = "//div[contains(@class,'v-card')]/div/label[6]";
	String labelEmailResumen = "//div[contains(@class,'v-card')]/div/label[8]";
	String labelConfirmacionContratacion = "//div[@role='dialog']/div[contains(text(),'éxito')]";
	String labelMensajeErrorPortal ="//label[contains(text(),'Al parecer ocurrio un error con el sistema de pago')]";
	
	//Circle
	String circleLoading = "//div[@role='progressbar']";
	
	//Informacion termino y condiciones.
	String informacionTerminoCondioneString = "Por este acto, y según lo dispuesto en la Ley N° 19.628 sobre Protección de la Vida Privada y sus modificaciones, autorizo expresamente a Southbridge Compañía de Seguros Generales S.A. para que haga tratamiento, almacene, transmita y comunique mis datos personales y la información que le he proporcionado voluntariamente, a su matriz, filiales, sociedades coligadas, empresas relacionadas, sociedades del Grupo Empresarial al que pertenece y terceros prestadores de servicios, estén ubicados dentro o fuera de Chile, con el propósito de que tanto Southbridge Compañía de Seguros Generales S.A. como dichas entidades i) me contacten y pongan a mi disposición, en la forma que estimen pertinente, la más completa información y oferta de sus productos y servicios; ii) procedan al almacenamiento y tratamiento de mis datos personales y de mi información personal para los objetivos del cumplimiento de este Contrato de Seguro; y iii) hagan efectivos el o los convenios que pudieren estar asociados a los seguros que he contratado. Además, por este acto, autorizo expresamente a que cualquier información, comunicación, declaración o notificación que debe efectuar Southbridge Compañía de Seguros Generales S.A. en virtud del presente contrato de seguros sea realizada a través de correo electrónico o de cualquier sistema de transmisión o registro digital de la palabra escrita o verbal o por cualquier otro medio de comunicación fehaciente. El asegurado declara que conoce, acepta y concuerda que cualquier transacción que se realice en el sitio www.sbseguros.cl con su Rut y clave personal, se entenderá y se reputará, para todos los efectos legales, como realizada por él mismo. En tal sentido, el asegurado se hace entera y totalmente responsable del uso y seguridad de su clave, no cabiéndole Southbridge Compañía de Seguros Generales S.A.. ninguna responsabilidad por el uso indebido de la misma por un tercero distinto del asegurado. El asegurable se hace responsable por la veracidad de la información entregada para la contratación del seguro y del uso de las claves o códigos, liberando a Southbridge Compañía de Seguros Generales S.A. de responsabilidad por cualquier mal uso que hagan terceros de la información que Southbridge Compañía de Seguros Generales S.A. entregue exclusivamente a la persona del asegurable.";
}
