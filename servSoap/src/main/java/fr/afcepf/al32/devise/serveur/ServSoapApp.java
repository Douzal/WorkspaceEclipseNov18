package fr.afcepf.al32.devise.serveur;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.xml.ws.Endpoint;

import fr.afcepf.al32.devise.impl.ServiceDeviseImpl;
import fr.afcepf.al32.devise.itf.IServiceDevise;

public class ServSoapApp {

	public static void main(String[] args) {
//		String urlWs = "http://localhost:8080/servSoap/serviceDevise";
//		IServiceDevise serviceDevise = new ServiceDeviseImpl();
		String urlWs = "";
		
		try {
			String localHostName = InetAddress.getLocalHost().getHostName();
			urlWs = "http://"+localHostName+":8080/servSoap/serviceDevise";
			IServiceDevise serviceDevise = new ServiceDeviseImpl();
			Endpoint.publish(urlWs, serviceDevise);
			System.out.println("---web service démarré en attente des requêtes");
			System.out.println("---URL description wsdl : " + urlWs + "?wsdl : description wsdl");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}

}
