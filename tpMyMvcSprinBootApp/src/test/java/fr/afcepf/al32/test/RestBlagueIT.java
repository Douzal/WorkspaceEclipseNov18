package fr.afcepf.al32.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import fr.afcepf.al32.dto.Blague;

/* IT : Integration Test
 * on teste le comportement de l'ensemble de l'applicatgion avec Web Service déjà démarrés
 */
public class RestBlagueIT {
	private static final String BASE_URL =
			"http://localhost:8080/tpMvcSpringBootApp";
	private static RestTemplate restTemplate;
	
	@BeforeClass
	public static void init() {
		restTemplate = new RestTemplate();
	}
	
	@Test
	public void testGetBlagues() {
		String url = BASE_URL + "/rest/blagues";
		Blague[] tabBlagues = restTemplate.getForObject(url, Blague[].class);
		
		Assert.assertNotNull(tabBlagues);
		// afficher le tableau resultat -->
		for(Blague b : tabBlagues) {
			System.out.println("\t" + b.toString());
		}
	}
	
	@Test
	public void testPostBlague() {
		Blague newJoke = new Blague();
		newJoke.setTitre("Préservez les arbres !");
		newJoke.setTexte( "sauvez un arbre, sauvez Willy, sauvez Ryan !");
		
		String url = BASE_URL+"/rest/blagues";
		Blague blagueAjouteeCoteServeur = restTemplate.postForObject(url, newJoke, Blague.class);
		System.out.println("blagueAjouteeCoteServeur " + blagueAjouteeCoteServeur);
	}
	
}
