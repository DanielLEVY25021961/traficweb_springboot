package levy.daniel.application.controllers.web.metier.profil.impl;

import java.util.List;

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
import levy.daniel.application.model.services.metier.profil.IProfilService;

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
@RequestMapping("/profil")
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
			@RequestBody final IProfil pProfil) throws Exception {
		return this.profilServiceFake.create(pProfil);
	}

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@GetMapping("/{id}")
	public IProfil findById(
			@PathVariable("id") final Long pId) throws Exception {
		return this.profilServiceFake.findById(pId);
	}
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@GetMapping("/profils")
	public List<IProfil> findAll() throws Exception {
		return this.profilServiceFake.findAll();
	} // Fin de findAll()._________________________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@PutMapping("/{id}")
	public IProfil update(
			@PathVariable("id") final Long pId, @RequestBody final IProfil pProfil) 
					throws Exception {		
		return this.profilServiceFake.update(pId, pProfil);		
	}

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@DeleteMapping("/{id}")
	public boolean deleteById(
			@PathVariable("id") final Long pId) throws Exception {
		return this.profilServiceFake.deleteByIdBoolean(pId);
	}
	

	
} // FIN DE LA CLASSE ProfilControllerFake.--------------------------------------
