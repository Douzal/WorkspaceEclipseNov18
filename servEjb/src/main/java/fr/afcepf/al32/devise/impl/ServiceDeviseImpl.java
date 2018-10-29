package fr.afcepf.al32.devise.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;

import fr.afcepf.al32.devise.dto.Devise;
import fr.afcepf.al32.devise.itf.IServiceDevise;

// univastRemoteObject est une classe prédéfinie de RMI qu'il faut utiliser côté serveur
// via un héritage

@Stateless // et @Remote déjà sur IServiceDevise
public class ServiceDeviseImpl implements IServiceDevise {
	
	private Map<String, Devise> mapDevise = new HashMap<String, Devise>();

	public ServiceDeviseImpl() {
		mapDevise.put("EUR", new Devise("EUR", 1.0));
		mapDevise.put("USD", new Devise("USD", 1.1));
		mapDevise.put("GDP", new Devise("GDP", 1.15));
		mapDevise.put("JPY", new Devise("JPY", 1_120.0));
	}

	public Double convertir(double montant, String monnaieSource, String monnaieCible) {
		Devise dSource = mapDevise.get(monnaieSource);
		Devise dCible = mapDevise.get(monnaieCible);
		return montant * dCible.getChange() / dSource.getChange();
		
	}

	public Devise getDevise(String monnaie) {
		return mapDevise.get(monnaie);
	}

}
