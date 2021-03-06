package tp.it;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import tp.web.data.Info;

/*
 * cette classe à un nom qui commence ou se termine par IT (et par par Test)
 * car c'est un Test d'Integration qui ne fonctionne que lorsque toute l'application
 * est entièrement démarrée (avec EmbeddedTomcat)
 */
public class MyWsRestIT {
	
	private static final String BASE_URL = "http://localhost:8080/myMvcSpringBootApp";
	
	private static Logger logger = LoggerFactory.getLogger(MyWsRestIT.class);
	
	private static RestTemplate restTemplate; //objet technique fourni par Spring tester WS REST
	
	//pas de @Autowired ni de @RunWith , @ContextConfiguration
	//car ce test EXTERNE est censé tester le WebService sans connaître sa structure interne
	// (test BOITE_NOIRE)
	@BeforeClass
	public static void init(){
		restTemplate = new RestTemplate();
	}
	
	@Test
	public void testGetInfoById(){
		 final String uri = BASE_URL + "/rest/info/1";
		 String resultAsJsonString = restTemplate.getForObject(uri, String.class);
		 logger.info("json string of info 1 via rest: " + resultAsJsonString);
		 Info i1 = restTemplate.getForObject(uri,Info.class);
		 logger.info("info 1 via rest: " + i1);
		 Assert.assertTrue(i1.getId()==1L);
	}
	/*
	@Test
	public void testListeComptesDuClient(){
		final String villeDepart = "Paris";
		final String dateDepart = "2018-09-20";
	    final String uri = "http://localhost:8080/flight_web/mvc/rest/vols/byCriteria"
	    		+"?villeDepart=" + villeDepart + "&dateDepart=" + dateDepart;
	    String resultAsJsonString = restTemplate.getForObject(uri, String.class);
	    logger.info("json listeVols via rest: " + resultAsJsonString);
	    Vol[] tabVols = restTemplate.getForObject(uri,Vol[].class);
	    logger.info("java listeComptes via rest: "  +tabVols.toString());
	    Assert.assertNotNull(tabVols);   Assert.assertTrue(tabVols.length>=0);
	    for(Vol cpt : tabVols){
	    	System.out.println("\t" + cpt.toString());
	    }
	}*/
	
	/*
	@Test
	public void testVirement(){
		 final String uri = "http://localhost:8080/tpSpringWeb/mvc/rest/compte/virement";
		    //post/envoi:
		    OrdreVirement ordreVirement = new OrdreVirement();
		    ordreVirement.setMontant(50.0);
		    ordreVirement.setNumCptDeb(1L);
		    ordreVirement.setNumCptCred(2L);
		    OrdreVirement savedOrdreVirement =
		    		restTemplate.postForObject(uri, ordreVirement, OrdreVirement.class);
		    logger.info("savedOrdreVirement via rest: " + savedOrdreVirement.toString());
		    Assert.assertTrue(savedOrdreVirement.getOk().equals(true));
	}*/

}
