package fr.afcepf.al32.devise.serveur;

import javax.xml.ws.Endpoint;

import fr.afcepf.al32.devise.impl.ServiceDeviseImpl;
import fr.afcepf.al32.devise.itf.IServiceDevise;

public class ServSoapApp {

	public static void main(String[] args) {
		String urlWs = "http://localhost:8080/servSoap/serviceDevise";
		IServiceDevise serviceDevise = new ServiceDeviseImpl();
		
		Endpoint.publish(urlWs, serviceDevise);
		System.out.println("---web service démarré en attente des requêtes");
		System.out.println("---URL description wsdl : " + urlWs + "? : description wsdl");
	}

}
