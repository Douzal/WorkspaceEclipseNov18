package fr.afcepf.al32.devise.client;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import fr.afcepf.al32.devise.dto.Devise;
import fr.afcepf.al32.devise.itf.IServiceDevise;

public class EjbClientApp {

	public static void main(String[] args) {

		// le code suivant s'appuie sur wildfly-client-all téléchargé par maven
		// si maven télécharge mal certains .jar (invalid LOC header ou...), on peut lancer un maven build...
		// on peut ainsi lancer la commande mvn dependency:purge-local-repository qui, en partant du pom.xml
		// va vérifier que toutes les dépendances utiles du projet dans .m2/repository
		// et provoquer des effacements/re-téléchargements si besoin.
		try {
			// 1. se connecter à la partie "nom JNDI" de JBoss
			Properties props = new Properties(); // de java.util
			// javax.naming.Context
			props.put(Context.INITIAL_CONTEXT_FACTORY,
					"org.wildfly.naming.client.WildFlyInitialContextFactory");
//			props.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
			// par défaut, JBoss ne répond qu'en localhost, il faut le (re-)démarrer
			// avec l'option -b 0.0.0.0 pour qu'il accepte des requêtes provenant d'autres machines
			props.put(Context.PROVIDER_URL, "http-remoting://192.168.102.49:8080");
			// remote://localhost:4447 for Jboss7.1 , http-remoting://localhost:8080 for wildfly 8,9
			props.put(Context.SECURITY_PRINCIPAL, "guest"); // username : "admin" , "guest" , "..."
			props.put(Context.SECURITY_CREDENTIALS, "guest007"); //password : "pwd", "guest007"

			//avec utilisateur ajouté via la commande JBOSS_7_HOME/bin/add-user
			//et roles associés admin,guest,.... sur partie "ApplicationRealm" .
			props.put("jboss.naming.client.ejb.context", true);

			// javax.naming.Context (JNDI)
			Context jndiContext = new InitialContext(props);

			// 2. récupérer le proxy Ejb / Rmi de l'ejb distant qui a un nom logique normalisé et compliqué depuis la V6
			String ejbJndiName = "servEjb-0.0.1-SNAPSHOT/ServiceDeviseImpl!fr.afcepf.al32.devise.itf.IServiceDevise";
			IServiceDevise proxyServiceDevise = (IServiceDevise)  jndiContext.lookup(ejbJndiName);

			// 3. appeler des méthodes distantes : 
			Devise d = proxyServiceDevise.getDevise("USD");
			System.out.println("change de USD = " + d.getChange() + " pour 1€");

			Double sommeConvertie = proxyServiceDevise.convertir(20d, "EUR", "USD");
			System.out.println("La somme convertie est : " + sommeConvertie);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
