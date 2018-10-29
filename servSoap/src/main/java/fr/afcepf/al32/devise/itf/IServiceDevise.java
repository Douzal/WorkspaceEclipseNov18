package fr.afcepf.al32.devise.itf;

import javax.jws.WebParam;

//import java.rmi.RemoteException;

import javax.jws.WebService;

import fr.afcepf.al32.devise.dto.Devise;

@WebService 
public interface IServiceDevise {
	// pour ne pas avoir des param générés avec des noms aléatoires
	// on stipule les noms :
	public Double convertir(@WebParam(name="montant") Double montant,
							@WebParam(name="monnaieSource") String monnaieSource,
							@WebParam(name="monnaieCible") String monnaieCible);
	
	public Devise getDevise(@WebParam(name="monnaie") String monnaie); // monnaie ="EUR" ou "USD", etc
}
	