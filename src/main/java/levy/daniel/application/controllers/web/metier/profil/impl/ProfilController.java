package levy.daniel.application.controllers.web.metier.profil.impl;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import levy.daniel.application.model.persistence.metier.profil.entities.ProfilEntityJPA;
import levy.daniel.application.model.services.metier.profil.impl.ProfilService;

/**
 * CLASSE ProfilController :<br/>
 * .<br/>
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
 * @author daniel.levy Lévy
 * @version 1.0
 * @since 5 nov. 2018
 *
 */
@RestController
@RequestMapping("/")
public class ProfilController {

	// ************************ATTRIBUTS************************************/

	/**
	 * SERVICE pour les Profil.<br/>
	 */
	@Autowired
	private transient ProfilService profilService;
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(ProfilController.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public ProfilController() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	 * .<br/>
	 * <ul>
	 * <li></li>
	 * </ul>
	 *
	 * @return : Collection<ProfilEntityJPA> :  .<br/>
	 */
	@GetMapping("/profils")
	public Collection<ProfilEntityJPA> getAllProfilsFake() {
		return this.profilService.getAllProfilsFake();
	} // Fin de getAllProfilsFake()._______________________________________

	
	
} // FIN DE LA CLASSE ProfilController.--------------------------------------
