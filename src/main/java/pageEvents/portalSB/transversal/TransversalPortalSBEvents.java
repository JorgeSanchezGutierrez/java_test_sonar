package main.java.pageEvents.portalSB.transversal;

import java.security.PublicKey;
import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v119.eventbreakpoints.EventBreakpoints;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.gherkin.model.And;
import com.google.common.base.CaseFormat;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import main.java.config.Context;
import main.java.config.ElementFetch;
import main.java.config.Utils;
import main.java.config.Validation;
import main.java.pageEvents.portalSB.productos.MascotaSaludPortalSBEvents;
import main.java.pageObjects.portalSB.transversal.TransversalPortalSBElements;
import main.java.pageObjects.tia.transversal.TransversalElements;
import main.java.properties.EntidadProperties;
import main.java.properties.PolizaProperties;
import main.java.utils.Constants;
import main.java.utils.Events;
import test.java.BaseTest;

public class TransversalPortalSBEvents extends BaseTest implements TransversalPortalSBElements {

	@Context(description = "Valida que se haya ingresado a la URL de Portal SB", page = "inicio", functionality = "Transversal")
	// como parametro se debe escoger mascota, oncologico o ap
	public static void validarAmbientePortalSB(String opcionPortal) {
			//Se debe ingresar aqui la URL correspondiente
		try {
			switch (opcionPortal.toLowerCase()) {
			case "mascota":
				opcionPortal = "mascota";
				driver.get(Constants.urlPortalSBMascota);
				break;
			case "oncologico":
				opcionPortal = "oncológico";
				driver.get(Constants.urlPortalSBOncologico);
				break;
			case "ap":
				opcionPortal = "accidentes personales";
				driver.get(Constants.urlPortalSBAP);
				break;
			default:
				Utils.eventFailed("La opción ingresada para desplegar el portal SB es inválida, favor escoger entre las siguientes opciones: Mascota; Oncologico; AP");
			}
			
			WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(20));
			 wait.until(new ExpectedCondition<Boolean>(){
				  public Boolean apply( WebDriver driver) {
					  return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
				  }
			  });
			
			 String tituloPagina = Events.getText(tituloPortalSB);
			Boolean rsImgPortal = validarElementoPantalla(imgLogoSB);
			 Validation.trueBooleanCondition(tituloPagina.toLowerCase().contains(opcionPortal) && 
					 rsImgPortal, 
					 String.format("Se ha ingresado correctamente al portal SB %s", opcionPortal.toUpperCase()),
					String.format("Se ha ingresado al portal SB %s cuando se esperaba ingresar a %s", tituloPagina.toUpperCase(),opcionPortal.toUpperCase()));
			 Utils.takeAdditionalScreenshot(String.format("portalSB%s", opcionPortal.substring(0, 3)), "extra");

		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}
	
	
	@Context(description = "Confirmar despliegue de elemtentos en pantalla", page = "Manejo Elementos", functionality = "Transversal")
	public static boolean validarElementoPantalla(String xpathString) {
		try {
			WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(10));

			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpathString))));
			return true;
		} catch (Exception e) {
			return false;
		}

	}
	
	@Context(description = "Confirmar despliegue de elemtentos en pantalla", page = "Manejo Elementos", functionality = "Transversal")
	public static boolean validarElementoPantalla(String xpathString, int duracionBusqueda) {
		try {
			WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(duracionBusqueda));

			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpathString))));
			return true;
		} catch (Exception e) {
			return false;
		}

	}
	
	@Context(description = "Ingresar nombre en el incio del portal", page = "inicio",functionality = "Transversal")
	public static void ingresarNombreContratante(String nombre) {
		try {
			Boolean rsName = validarElementoPantalla(inputNombre);
			if(!rsName) {
				Utils.eventFailed("No se encontro el campo Nombre");
			}
			Events.sendKeysWithReturnVariableName(inputNombre,nombre);
			EntidadProperties.nombreContratante = nombre.trim();
			
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}
	
	@Context(description = "Ingresar apellido en el incio del portal", page = "inicio",functionality = "Transversal")
	public static void ingresarApellidoContratante(String apellido) {
		try {
			Boolean rsApellido = validarElementoPantalla(inputApellido);
			if(!rsApellido) {
				Utils.eventFailed("No se encontro el campo Apellido");
			}
			Events.sendKeysWithReturnVariableName(inputApellido,apellido);
			EntidadProperties.apellidoContratante = apellido.trim();
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}
	
	@Context(description = "Ingresar apellido en el incio del portal", page = "inicio",functionality = "Transversal")
	public static void ingresarCorreoContratante(String correo) {
		try {
			Boolean rsCorreo = validarElementoPantalla(inputCorreo);
			if(!rsCorreo) {
				Utils.eventFailed("No se encontro el campo Correo");
			}
			String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
			 // Compilar la expresión regular
	        Pattern pattern = Pattern.compile(EMAIL_REGEX);
	        // Crear un matcher con el correo proporcionado
	        Matcher matcher = pattern.matcher(correo);
	        if(!matcher.matches()) {
	        	Utils.eventFailed(String.format("Correo ingresado por data no cumple con las caracteristicas: %s", correo));
	        }
	        
			Events.sendKeysWithReturnVariableName(inputCorreo,correo);
			EntidadProperties.correoContratante = correo.trim();
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}
	
	@Context(description = "Valida y activa campo terminos y condiciones", page = "Inicio", functionality = "Transversal")
	public static void validarTerminosCondiciones() {
		try {
			Boolean rsEnlaceTermCond = validarElementoPantalla(aTerminosCondiciones);
			if (!rsEnlaceTermCond) {
				Utils.eventFailed("No se visualiza el elemento Termino y condiciones en el portal");
			}
			Events.clickButton(aTerminosCondiciones);
			Boolean rsTituloTermCond = validarElementoPantalla(tituloTerminosCondiciones);
			if (!rsTituloTermCond) {
				Utils.eventFailed("No se desplego el pop-up de los terminos y condiciones");
			}
			String infoTerminoCond = Events.getText(contenidoTerminoCondiciones);
			
			Validation.trueBooleanCondition(infoTerminoCond.trim().equals(infoTerminoCond.trim()),"La información entregada en los terminos y condiciones es correcta" , "Hay discordancia entre los terminos y condiciones desplegados contra lo validado");
			
			Utils.takeAdditionalScreenshot("TerminoCondiciones", "extra");
			Boolean rsAceptar = validarElementoPantalla(buttonAceptarTerminoCondiciones);
			if (!rsAceptar) {
				Utils.eventFailed("No se visualiza el botón aceptar en el pop-up de terminos y condiciones");
			}
			
			Events.clickButton(buttonAceptarTerminoCondiciones);
						
			activarCheckRadio(checkBoxTerminoCondiciones);
			
			
			
			
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}
	
	@Context(description = "Avanzar a la siguiente pagina", page = "transversal", functionality = "Transversal")
	public static void avanzarSiguientePagina( String seccionFlujo) {
		try {
			Boolean rsContinuar = validarElementoPantalla(buttonContinuar);
			if(!rsContinuar) {
				Utils.eventFailed("No se encontro el botón Continuar");
			}
			Events.clickButton(buttonContinuar);
			
			WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(20));
			 wait.until(new ExpectedCondition<Boolean>(){
				  public Boolean apply( WebDriver driver) {
					  return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
				  }
			  });
			
			Boolean rsPasoNav = validarElementoPantalla(labelFlujoNavegacion);
			if (!rsPasoNav ) {
				Utils.eventFailed("No se localizo el elemento de paso activo");
			}
			int contar = 0;
			Boolean rsBoolean = false;
			while (!rsBoolean) {
				String pasoActivo = Events.getText(labelFlujoNavegacion);
				if(!pasoActivo.trim().toLowerCase().contains(seccionFlujo.trim().toLowerCase()) ){
					Utils.outputInfo("Se ingreso correctamente a la siguiente pagina");
					Utils.takeAdditionalScreenshot(String.format("ingresoPagina%s", pasoActivo.toLowerCase()), "extra");
					rsBoolean = true;
					
				}
				else if (contar == 5) {
					Utils.eventFailed(String.format("No se ingreso al paso esperado, se visualiza la pagina %s y se esperaba ingresar a %s", pasoActivo, seccionFlujo));
				}
				else {
					contar++;
					Thread.sleep(2000);
				}
				
			}
			
			
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
		
	}
	
	@Context(description = "Activar un check/radio", page = "Transversal", functionality = "Transversal")
	public static void activarCheckRadio(String xpath) {
		try {
			WebElement checkbox = driver.findElement(By.xpath(xpath)); 
			String nameVarible = Events.getVariableName(xpath);
            if (!checkbox.isEnabled()) {
				Utils.eventFailed(String.format("No se encuentra disponible el elemento %s", nameVarible));
			}
            else if (!checkbox.isSelected()) {
            	WebElement element = driver.findElement(By.xpath(xpath));
            	element.findElement(By.xpath("./parent::div")).click();
			}
          Utils.outputInfo(String.format("El elemento %s fue activado", nameVarible));
            
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
		
	}
	
	@Context(description = "Seleccionar plan", page = "Transversal", functionality = "Transversal")
	public static void seleccionaPlan(String nombrePlan, String montoUF, String seccionFlujo) {
		try {
			List<WebElement> listPlanElements = Events.getElementList(labelTodosNombrePlan);
			WebElement rsElement = null;
			for (WebElement element: listPlanElements) {
				
				if (element.getAttribute("innerText").toLowerCase().contains(nombrePlan.toLowerCase())) {
					rsElement = element;
					PolizaProperties.planPoliza = element.getAttribute("innerText");
					break;
				}
				
			}
			if (rsElement == null) {
				Utils.eventFailed(String.format("Plan ingresado '%s' no fue encontrado", nombrePlan));
			}
			Utils.outputInfo(String.format("Se ha encontrado el %s", rsElement.getAttribute("innerText")));
			String valorUf = rsElement.findElement(By.xpath(".//following-sibling::label[contains(text(),'UF')]")).getText();
			if (!valorUf.trim().replace(",", ".").contains(montoUF.trim().replace(",", "."))) {
				
				Utils.eventFailed(String.format("El %s no posee el monto correcto de UF, en pantalla se visualiza %s y se esperaba %s" , rsElement.getAttribute("innerText"), valorUf.split(" ")[1].trim(), montoUF));
			}
			Utils.outputInfo(String.format("El monto %s es correcto", valorUf));
			
			Utils.takeAdditionalScreenshot(String.format("plan%s", rsElement.getAttribute("innerText")), "extra");
			
			rsElement.findElement(By.xpath("./parent::div/following-sibling::div/button")).click();
			Utils.outputInfo(String.format("Se ha seleccionado el %s", rsElement.getAttribute("innerText")));
			
			String numeroPasoActivoActual = Events.getText(labelFlujoNavegacion.concat("/preceding-sibling::span"));
			validarElementoPantalla(labelFlujoNavegacion.concat(String.format("/preceding-sibling::span[contains(text(),%d)]", (Integer.parseInt(numeroPasoActivoActual)+1))));
			String pasoActivo = Events.getText(labelFlujoNavegacion);
			if(!pasoActivo.trim().toLowerCase().contains(seccionFlujo.trim().toLowerCase()) ){
				Utils.eventFailed(String.format("No se ingreso al paso esperado, se visualiza la pagina %s y se esperaba ingresar a %s", pasoActivo, seccionFlujo));
			}
			
			Utils.outputInfo("Se ingreso correctamente a la siguiente pagina");
			Utils.takeAdditionalScreenshot(String.format("ingresoPagina%s", pasoActivo.toLowerCase()), "extra");
			
			
            
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
		
	}


	public static void rellenarFomularioInfo( String anio, String mes, String dia, String telefono, String rut, String numeroDoc, String nombreCalle, String numeroCalle, String depto, String region, String comuna) {
		try {
			String nombre =  Events.getValue(inputNombreInfo);
			String apellido = Events.getValue(inputApellidoInfo);
			String correo = Events.getValue(inputCorreoInfo);
			
			if(nombre.isBlank() || nombre.isEmpty() || nombre.equals("") || !nombre.trim().equalsIgnoreCase(EntidadProperties.nombreContratante.trim()) 
					|| apellido.isBlank() || apellido.isEmpty() || apellido.equals("")|| !apellido.trim().equalsIgnoreCase(EntidadProperties.apellidoContratante.trim()) 
					|| correo.isBlank() || correo.isEmpty() || correo.equals("") || !correo.trim().equalsIgnoreCase(EntidadProperties.correoContratante.trim()) ) {
				Utils.eventFailed("No retorno la información de forma correcta");
			}
			seleccionarItemEnComboBox(selectAnioInfo, anio.trim());
			seleccionarItemEnComboBox(selectMesInfo, mes.trim());
			seleccionarItemEnComboBox(selectDiaInfo, dia.trim());
			
			Events.sendKeysWithReturnVariableName(inputTelefonoInfo, telefono.trim());
			EntidadProperties.telefonoContratante = telefono.trim();
			Events.sendKeysWithReturnVariableName(inputRutInfo, rut.trim());
			EntidadProperties.rutContratante = rut;
			Events.sendKeysWithReturnVariableName(inputNumeroDoc, numeroDoc.trim());
			Events.sendKeysWithReturnVariableName(inputNombreCalle,nombreCalle.trim());
			Events.sendKeysWithReturnVariableName(inputNumeroCalle,numeroCalle.trim());
			Events.sendKeysWithReturnVariableName(inputtDepto,depto.trim());
			
			seleccionarItemEnComboBox(selectRegionInfo, region.trim());
			
			seleccionarItemEnComboBox(selectComunaInfo, comuna.trim());
			Utils.outputInfo("Se ha rellenado el formulario correctamente");
			Utils.takeAdditionalScreenshot("formularioInfo", "extra");
				
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
		
	}
	
	@Context(description = "Seleccionar opcion en combobox", page = "Mascota", functionality = "Transversal")
	public static void seleccionarItemEnComboBox(String xpathString, String opcionEscoger) {
		try {
			Actions action = new Actions(driver);
			WebElement element = driver.findElement(By.xpath(xpathString));
			element.findElement(By.xpath("./parent::div")).click();
			String getID =(element.getAttribute("id").split("-"))[1];
			TransversalPortalSBEvents.validarElementoPantalla(listaSelect.replace("numeroId", getID));
			Boolean boolWhl = false;
			int cantidadOpc = 0;
			while (!boolWhl) {
				List<WebElement> listaOpciones = driver.findElements(By.xpath(listaSelect.replace("numeroId", getID)));
				for (int opc = cantidadOpc; opc < listaOpciones.size(); opc++) {
					
					if(listaOpciones.get(opc).getText().trim().equalsIgnoreCase(opcionEscoger.trim())) {
						listaOpciones.get(opc).click();
						TransversalPortalSBEvents.validarElementoPantalla(xpathString.concat("//ancestor::div[@aria-expanded='false']"));
						Utils.outputInfo(String.format("Se ha hecho click a la opción: %s",listaOpciones.get(opc).getText() ));
						Utils.takeAdditionalScreenshot("seleccionarOpc", "extra");
						boolWhl = true;
						break;
					}
					else if (opc == (listaOpciones.size()-1)) {
						action.moveToElement(listaOpciones.get(opc)).perform();
					}
				}
				if(cantidadOpc == listaOpciones.size()-1) {
					Utils.eventFailed("No se encontro la opción: " + opcionEscoger);
				}
				cantidadOpc = listaOpciones.size()-1;
			}			
			
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(description = "Avanzar a la pagina de resumen", page = "info", functionality = "Transversal")
	public static void avanzarResumen() {
		try {
			Events.clickButton(buttonContinuar);
			validarElementoPantalla(tituloResumen);
			Utils.outputInfo("Se ha ingresado a la ventana Resumen");
			Utils.takeAdditionalScreenshot("resumen", "extra");
			
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
		
	}

	@Context(description = "resumen general de la contratacion, informacion contratante", page = "resumen", functionality = "Transversal")
	public static void resumenEntidad() {
		try {
			String nombreContratante =  Events.getText(labelNombreContratanteResumen);
			String rutContratante = Events.getText(labelRutResumen);
			String correoContratante = Events.getText(labelEmailResumen);
			String telefonoContratante = Events.getText(labelTelefonoResumen);
			
			Validation.trueBooleanCondition(nombreContratante.trim().contentEquals(EntidadProperties.nombreContratante +" " +EntidadProperties.apellidoContratante), 
					"Nombre del contratante es correcto.", String.format("El nombre visualizado en pantalla '%s', no coincide con lo ingresado %s", nombreContratante, EntidadProperties.nombreContratante +" " +EntidadProperties.apellidoContratante) );

			Validation.trueBooleanCondition(rutContratante.equalsIgnoreCase(EntidadProperties.rutContratante), 
					"Rut del contratante es correcto.", String.format("El rut visualizado en pantalla '%s', no coincide con lo ingresado %s", rutContratante, EntidadProperties.rutContratante ));

			Validation.trueBooleanCondition(correoContratante.trim().contentEquals(EntidadProperties.correoContratante.trim()), 
					"Correo del contratante es correcto.", String.format("El correo visualizado en pantalla '%s', no coincide con lo ingresado %s", correoContratante, EntidadProperties.correoContratante) );
			
			Validation.trueBooleanCondition(telefonoContratante.trim().contains(EntidadProperties.telefonoContratante.trim()), 
					"Telefono del contratante es correcto.", String.format("El correo visualizado en pantalla '%s', no coincide con lo ingresado %s", telefonoContratante, EntidadProperties.telefonoContratante) );
		
		
		
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
		
	}

	@Context(description = "avanzar al portal de pago", page = "resumen", functionality = "Transversal")
	public static void irapagar() {
		try {
			Events.clickButton(buttonIrPagar);
			Boolean rsLoading = validarElementoPantalla(circleLoading);
			if(!rsLoading) {
				Utils.eventFailed("No se encontro el elemento de carga luego presionar el botón pagar");
			}
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(circleLoading)));
			
			Boolean rsMensajeError = validarElementoPantalla(labelMensajeErrorPortal);
			if (rsMensajeError) {
				Utils.eventFailed("Al presionar el botón pagar, se visualiza mensaje de error");
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(imgWebpay)));
			String urlWebpay = driver.getCurrentUrl();
			Validation.trueBooleanCondition(urlWebpay.contains("https://webpay3gint.transbank.cl/"), "Se ha ingresado correctamente al portal WebPay", String.format("No se ingreso correctamente al portal Webpay, se desplego la URL:%s", urlWebpay));
			
			
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
		
	}
	@Context(description = "Ingresar Tarjeta credito y pagar", page = "WebPay", functionality = "transversal")
	public static void ingresarTarjeta(String tipoTarjeta, String numeroTarjeta, String fechaExpiracion, String CVV, String nombreBanco) {
		try {
						
			if(tipoTarjeta.trim().toLowerCase() == "credito"|| tipoTarjeta.toLowerCase() == "crédito") {
				tipoTarjeta = "credito";
			}
			else if (tipoTarjeta.trim().toLowerCase() == "débito"|| tipoTarjeta.trim().toLowerCase() == "debito") {
				tipoTarjeta = "debito";
			}
			else if (tipoTarjeta.trim().toLowerCase() == "prepago") {
				tipoTarjeta = "prepego";
			}
			else {
				Utils.eventFailed(String.format("El tipo de tarjeta ingresado es inválido, se ingreso %s y se esperaba crédito, débito o prepago", tipoTarjeta));
			}
			Events.clickButton(buttonTipoTarjeta.replace("id-tipotarjeta",tipoTarjeta));
			if(tipoTarjeta.trim().toLowerCase() == "débito"|| tipoTarjeta.trim().toLowerCase() == "debito"||
				tipoTarjeta.trim().toLowerCase() == "prepago") {
				seleccionarBanco(nombreBanco);
			}

			WebElement elementNumeroTarjeta = driver.findElement(By.xpath(inputNumeroTarjetaWebPay));
			elementNumeroTarjeta.sendKeys(numeroTarjeta);
			String numTarj = Events.getValue(inputNumeroTarjetaWebPay);
			Utils.outputInfo("Se ha ingresado el número de tarjeta: "+ numTarj);
			if(tipoTarjeta.trim().toLowerCase() == "credito"|| tipoTarjeta.toLowerCase() == "crédito"||
					tipoTarjeta.trim().toLowerCase() == "prepago") {
					WebElement elementFecha = driver.findElement(By.xpath(inputFechaExpiracionWebPay));
					elementFecha.sendKeys(fechaExpiracion.replace("/", ""));
					String fechaExpiración = Events.getValue(inputFechaExpiracionWebPay);
					Utils.outputInfo("Se ha ingresado el fecha de expiración: "+ fechaExpiración);
					Events.sendKeysWithReturnVariableName(inputCVVWebPay, CVV);
			}
			Events.clickButton(checkBoxConfirmarCorreoWebPay);
			Utils.takeAdditionalScreenshot("datosTarjeta", "extra");
			Events.clickButton(buttonConfirmarPago);
			
			
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}
	
	

	@Context(description = "Seleccionar banco WebPay", page = "WebPay", functionality = "transversal")
	public static void seleccionarBanco(String nombreBanco) {
		try {
			int contador = 0;
			while(true) {
				Events.clickButton(selectBancoWebPay);
				String obtenerClase = Events.getAtributte(selectBancoWebPay, "class");
				if(obtenerClase.trim().toLowerCase().contains("combobox-button--open")) {
					
					break;
				}
				else if (contador == 10) {
					Utils.eventFailed("El campo Seleccionar Banco, no se logro desplegar correctamente");
				}
				else {
					contador++;
				}
			}
			
			
			List<WebElement> bancos = Events.getElementList(selectBancoWebPay.concat("/following-sibling::ul//span"));
			WebElement rsElement = null;
			for (WebElement element: bancos) {
				
				if (element.getAttribute("innerText").toLowerCase().contains(nombreBanco.toLowerCase())) {
					rsElement = element;
					break;
				}
				
			}
			if(rsElement == null) {
				Utils.eventFailed(String.format("No se encontro la opción de banco %s", nombreBanco));
			}
			rsElement.click();
			Utils.outputInfo(String.format("Se ingreso a la opción: '%s'", "No se encontro la opción de banco %s"));
			
			
			
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}

	@Context(step = "aprobar pago en portal Transbank",page = "Transbank", functionality = "Aprobar Pago" )
	public static void aprobarPago(String rutTransbank, String contraseniaTransbank) {
		try {
			Boolean rsDespliegue = validarElementoPantalla(inputRutTransbank,40);
			if(!rsDespliegue) {
				Utils.eventFailed("No se desplego correctamente el portal de Transbank para aprobar el pago.");
			}
			Events.sendKeysWithReturnVariableName(inputRutTransbank, rutTransbank);
			Events.sendKeysWithReturnVariableName(inputContraseniaTransbank, contraseniaTransbank);
			Utils.outputInfo("Información rellenada del aprobador");
			Utils.takeAdditionalScreenshot("infoAprobador", "extra");
			Events.clickButton(buttonAceptarTransbank);
			Events.selectByContainsText(selectOpcionTransbank, "aceptar");
			Utils.outputInfo("Aprobación de pago");
			Utils.takeAdditionalScreenshot("aprobarPago", "extra");
			Events.clickButton(buttpnContinuarTransbank);
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());	
		}	
	}
	
	@Context(step = "Despligue pop-up confirmación contratación", page = "confirmacion", functionality = "transversal")
	public static void confirmacionPopUp() {
		try {
			Boolean rsPopUp = validarElementoPantalla(labelConfirmacionContratacion, 120);
			if (!rsPopUp) {
				Utils.eventFailed("No se desplego el popUp de confirmación de contratación");
			}
			Utils.takeAdditionalScreenshot("desplieguePopUp", "extra");
			Events.clickButton(buttonRevisarDetalle);
		} catch (Exception e) {
			Utils.eventFailed(e.getMessage());
		}
	}
	
	
}

