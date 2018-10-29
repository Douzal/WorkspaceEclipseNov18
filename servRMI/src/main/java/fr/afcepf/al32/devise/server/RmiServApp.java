package fr.afcepf.al32.devise.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import fr.afcepf.al32.devise.impl.ServiceDeviseImpl;

public class RmiServApp {

	public static void main(String[] args) {

		// classe de démarrage
		System.out.println("--demarrage de l'application servRMI...");
		
		try {
			// creation d'une instance de la classe qu'on vient de coder
			ServiceDeviseImpl serviceDeviseImpl = new ServiceDeviseImpl();
			
			// on demarre le serveur de nom logique avec le numero de port choisi
			Registry rmiRegistry = LocateRegistry.createRegistry(1099);
			
			// enregistrer l'implementation dans le serveur de noms logiques avec le nom "serviceDevise"
			rmiRegistry.rebind("serviceDevise", serviceDeviseImpl);
			
			System.out.println("---serveur démarré en attente des requêtes");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		// Fin de Main() : le programme continue tout de même de tourner, car Thread démarré en tache de fond
		// qui attend les requêtes
	}

}
