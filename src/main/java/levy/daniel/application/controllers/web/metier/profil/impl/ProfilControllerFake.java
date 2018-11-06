package levy.daniel.application.controllers.web.metier.profil.impl;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import levy.daniel.application.controllers.web.metier.profil.IProfilController;
import levy.daniel.application.model.metier.profil.IProfil;
import levy.daniel.application.model.persistence.metier.profil.entities.ProfilEntityJPA;
import levy.daniel.application.model.services.metier.profil.impl.IProfilService;

/**
 * CLASSE ProfilControllerFake :<br/>
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
public class ProfilControllerFake implements IProfilController {

	// ************************ATTRIBUTS************************************/

	/**
	 * SERVICE pour les Profil.<br/>
	 */
	@Autowired
	@Qualifier("ProfilServiceFake")
	private transient IProfilService profilServiceFake;
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(ProfilControllerFake.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public ProfilControllerFake() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@PostMapping
	public IProfil create(
			@RequestBody final ProfilEntityJPA pProfil) {
		return this.profilServiceFake.create(pProfil);
	}

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@GetMapping("/{id}")
	public IProfil getById(
			@PathVariable("id") final Long pId) {
		return this.profilServiceFake.getById(pId);
	}
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@GetMapping("/profils")
	public Collection<ProfilEntityJPA> listAll() {
		return this.profilServiceFake.listAll();
	} // Fin de getAllProfilsFake()._______________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@PutMapping("/{id}")
	public IProfil update(
			@PathVariable("id") final Long pId, @RequestBody final ProfilEntityJPA pProfil) {		
		return this.profilServiceFake.update(pId, pProfil);		
	}

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@DeleteMapping("/{id}")
	public boolean deleteById(
			@PathVariable("id") final Long pId) {
		return this.profilServiceFake.deleteById(pId);
	}
	

	
} // FIN DE LA CLASSE ProfilControllerFake.--------------------------------------
