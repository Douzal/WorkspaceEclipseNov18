package fr.afcepf.al32.web.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.afcepf.al32.dto.Blague;

/* WebService Rest sur blagues pourries
 * On va développer le webService en s'appuyant sur le framework SpringMvc
 */

@RestController // @RestController hérite de @Component de Spring
@RequestMapping(value="/rest/blagues", headers="Accept=application/json")
public class BlagueRestCtrl {

	private Map<Long, Blague> mapBlagues = new HashMap<Long, Blague>();
	private Long cptBlagues;
	
	// constructeur vide
	public BlagueRestCtrl() {
		mapBlagues.put(1L, new Blague(1L, "blague sur les juifs",
				"Mr est madame Juif ? --> Gaston", 3.4));
		mapBlagues.put(2L, new Blague(2L, "blague sur les noirs",
				"Jean Negro sur la patate", 4.0));
		mapBlagues.put(3L, new Blague(3L, "blague du mec qui n'a pas de pouce ?",
				"Elle est comme ça", 5.0));
		mapBlagues.put(4L, new Blague(4L, "blague nulle pas très drôle. pas lol.",
				"Pas lol du tout.", 1.0));
		mapBlagues.put(5L, new Blague(5L, "blague drôle sur Zyzman.",
				"Cré cré laul", 4.8));
	}

	// URL = http://localhost:8080/tpMvcSpringBootApp/rest/blagues
	// avec {"titre" : "nouvelleBlague", "texte" : "blague ..." }
	// dans la partie body invisible de la requête HTTP
	@PostMapping("")
	public Blague postBlague(@RequestBody Blague blague) {
		blague.setId(++cptBlagues); // simuler auto_increment
		mapBlagues.put(blague.getId(), blague);
		return blague;
	}
	

	// URL = http://localhost:8080/tpMvcSpringBootApp/rest/blagues
	// URL = http://localhost:8080/tpMvcSpringBootApp/rest/blagues?noteMini=2
	@GetMapping("")
	public List<Blague> getListeBlagues(
			@RequestParam(name="noteMini", required=false)Double noteMini) {
		List<Blague>toutesLesBlagues = new ArrayList<Blague>(mapBlagues.values());
		if(noteMini==null) {
			return new ArrayList<Blague>(mapBlagues.values());
		} else {
			return toutesLesBlagues.stream()
					.filter(
							b -> b.getNote()!=null?b.getNote()>=noteMini:false)
					.collect(Collectors.toList());
		}
		
	}
}