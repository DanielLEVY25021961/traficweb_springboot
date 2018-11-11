package levy.daniel.application.controllers.web.metier.country.springmvc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import levy.daniel.application.model.dto.metier.country.impl.CountryDTO;
import levy.daniel.application.model.metier.country.ICountry;
import levy.daniel.application.model.metier.country.impl.Country;
import levy.daniel.application.model.services.metier.country.jpaspring.ICountryService;


/**
 * CLASSE CountryController :<br/>
 * CONTROLLER SPRING MVC (pas REST).<br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author dan Lévy
 * @version 1.0
 * @since 11 nov. 2018
 *
 */
@Controller("/springmvc/country")
public class CountryController {
	
	// ************************ATTRIBUTS************************************/

	/**
	 * "redirect:/".<br/>
	 */
	public static final String REDIRECT = "redirect:/";
	
	/**
	 * SERVICE injecté par SPRING.<br/>
	 */
	@Autowired
	@Qualifier("CountryServiceJPASpring")
	private transient ICountryService countryService;
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(CountryController.class);
	
	// *************************METHODES************************************/
	
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.
	 */
	public CountryController() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	

	/* CREATE ************/

	
	/**
	 * .<br/>
	 * <ul>
	 * <li>.</li>
	 * </ul>
	 *
	 * @param pDTO
	 * 
	 * @return String
	 * 
	 * @throws Exception
	 */
	@PostMapping("/create")
	public String create(
			final CountryDTO pDTO) 
					throws Exception {
		
		/* retourne null si pDTO == null. */
		if (pDTO == null) {
			return null;
		}
		
		/* instanciation d'un objet métier concret 
		 * (passé avec la visibilité Interface) à partir du DTO. */
		final ICountry objet = new Country(pDTO);
		
		/* délégation au SERVICE. */
		this.countryService.create(objet);
		
		return REDIRECT;
		
	} // Fin de create(...)._______________________________________________


	
	/* READ *************/
	
	
	/**
	 * .<br/>
	 * <ul>
	 * <li>.</li>
	 * </ul>
	 *
	 * @param pId
	 * 
	 * @return String
	 * 
	 * @throws Exception
	 */
	@GetMapping("/find/{id}")
	public String findById(
			@PathVariable("id") final Long pId) 
					throws Exception {
		
		/* retourne null si pId == null. */
		if (pId == null) {
			return null;
		}
		
		/* délégation au SERVICE. */
		this.countryService.findById(pId);
		
		return REDIRECT;
		
	}
	
	

	/**
	 * .<br/>
	 * <ul>
	 * <li>.</li>
	 * </ul>
	 *
	 * @param pDTO
	 * 
	 * @return String
	 * 
	 * @throws Exception
	 */
	@DeleteMapping("/delete")
	public String delete(
			final CountryDTO pDTO) 
					throws Exception {
		
		/* retourne null si pDTO == null. */
		if (pDTO == null) {
			return null;
		}
		
		/* instanciation d'un objet métier concret 
		 * (passé avec la visibilité Interface) à partir du DTO. */
		final ICountry objet = new Country(pDTO);
		
		/* délégation au SERVICE. */
		this.countryService.delete(objet);
		
		return REDIRECT;
		
	} // Fin de delete(...)._______________________________________________
	

	
	/**
	 * .<br/>
	 * <ul>
	 * <li>.</li>
	 * </ul>
	 *
	 * @param pId
	 * 
	 * @return String
	 * 
	 * @throws Exception
	 */
	@DeleteMapping("/delete/{id}")
	public String deleteById(
			@PathVariable("id") final Long pId) 
					throws Exception {
		
		/* retourne null si pId == null. */
		if (pId == null) {
			return null;
		}
		
		/* délégation au SERVICE. */
		this.countryService.deleteById(pId);
		
		return REDIRECT;
		
	} // Fin de deleteById(...).___________________________________________
	

	
	/**
	 * .<br/>
	 * <ul>
	 * <li>.</li>
	 * </ul>
	 *
	 * @param pModelMap
	 * @return :  :  .<br/>
	 * @throws Exception 
	 */
	@GetMapping("/springmvc/country/findAll")
	public String findAll(
			final ModelMap pModelMap) throws Exception {
		
		pModelMap.addAttribute("listCountrys", this.countryService.findAll());
		
		return "vues/web/metier/country/springmvc/listCountrys.html";
	}
	
} // FIN DE LA CLASSE CountryController.-------------------------------------
