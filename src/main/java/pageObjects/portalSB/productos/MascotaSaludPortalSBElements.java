package main.java.pageObjects.portalSB.productos;

public interface MascotaSaludPortalSBElements {

	//RadioButton
	String radioButtonPerro = "//img[contains(@src,'dog')]/following-sibling::div//input";
	String radioButtonGato = "//img[contains(@src,'cat')]/following-sibling::div//input";
	
	//input
	String inputNombreMascota = "(//div[contains(@class,'v-text-field--solo')]//input[@type='text'])[1]";
	
	
	//Select
	String selectRazaMascota = "(//div[@class='v-select__selections']/input)[1]";
	String selectEdadMascota = "(//div[@class='v-select__selections']/input)[2]";
	String selectGeneroMascotaString = "(//div[@class='v-select__selections']/input)[3]";
	
	//Label
	String labelNombreMascotaResumen = "//b[contains(text(),'mascota')]/following-sibling::label[2]";
	String labelEspecieMascotaResumen = "//b[contains(text(),'mascota')]/following-sibling::label[4]";
	String labelRazaMascotaResumen = "//b[contains(text(),'mascota')]/following-sibling::label[6]";
	String labelContratado = "//label[contains(text(),'haz contratado')]";
	String labelMensajeEnvioPol = "//div[contains(@class,'text-center col')]";
	String labelTituloMascotaPolContratado = "//div[contains(@class,'titulo text-center')]";
		
}
