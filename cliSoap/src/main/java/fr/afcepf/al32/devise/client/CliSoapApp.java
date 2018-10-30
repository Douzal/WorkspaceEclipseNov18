package fr.afcepf.al32.devise.client;

import java.net.MalformedURLException;
import java.net.URL;

import fr.afcepf.al32.devise.impl.IServiceDevise;
import fr.afcepf.al32.devise.impl.ServiceDeviseImplService;
import fr.afcepf.al32.devise.itf.Devise;

public class CliSoapApp {

	public static void main(String[] args) {
		// appel du ws soap en s'appuyant sur le code généré par wsimport :
//		String wsdlUrlAsString = "http://localhost:8080/servSoap/serviceDevise?wsdl";
//		final String wsdlUrlAsString = "192.168.102.49:8080/servSoap/serviceDevise?wsdl";
		final String wsdlUrlAsString = "form291:8080/servSoap/serviceDevise?wsdl";
		URL wsdlUrl = null;
		try {
			wsdlUrl = new URL(wsdlUrlAsString); //try catch obligatoire
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		
		// (new ... Service).get...Port();
		IServiceDevise proxySoapServiceDevise = (new ServiceDeviseImplService())
														.getServiceDeviseImplPort();
		Devise yenJaponnais = proxySoapServiceDevise.getDevise("JPY");
		System.out.println("Change du yen japonnais : " + yenJaponnais.getChange());
	}
}
