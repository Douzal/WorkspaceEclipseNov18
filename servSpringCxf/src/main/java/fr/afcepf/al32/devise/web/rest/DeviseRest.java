package fr.afcepf.al32.devise.web.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.afcepf.al32.devise.dto.Devise;
import fr.afcepf.al32.devise.itf.IServiceDevise;

/* classe java d'implémentation d'un WE REST avec l'api officielle JAX-RS
 * (JAX-RS est dans ce projet géré par CXF)
 * --> pas de "RPC" vu de l'extérieur, juste un paquet d'URLs
 */
@Path("/devise")
@Produces("application/json") // transforme AUTOMATIQUEMENT les valeurs de retour Java en JSon
@Component // permet de lier avec Spring
public class DeviseRest {

	@Autowired // injection de dépendances
	private IServiceDevise serviceDevise; // service métier / business


	/* url : http://localhost:8080/servSpringCxf/services/rest/devise/EUR
	 * où /services est le url-pattern de CxfServlet dans web.xml
	 * /rest est associé à la partie "REST" de beans.xml
	 * /devise/EUR est la concaténation des @Path() de cette classe java
	 */
	@GET // on récupère en get les données de la base
	@Path("/{codeMonnaie}")
	public Devise getDeviseByMonnaie(@PathParam("codeMonnaie")String monnaie) {
		return serviceDevise.getDevise(monnaie);
	}
}
