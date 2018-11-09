package levy.daniel.application.controllers.web.metier.profil.jpaspring.impl;

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

import levy.daniel.application.controllers.web.metier.profil.jpaspring.IProfilController;
import levy.daniel.application.model.dto.metier.profil.impl.ProfilCerbereDTO;
import levy.daniel.application.model.metier.profil.IProfil;
import levy.daniel.application.model.metier.profil.impl.ProfilCerbere;
import levy.daniel.application.model.services.metier.profil.jpaspring.IProfilService;



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
 * @author dan Lévy
 * @version 1.0
 * @since 9 nov. 2018
 *
 */
@RestController
@RequestMapping("/profil")
public class ProfilController implements IProfilController {
	
	// ************************ATTRIBUTS************************************/

	/**
	 * SERVICE pour les Profil.<br/>
	 */
	@Autowired
	@Qualifier("ProfilServiceJPASpring")
	private transient IProfilService profilService;

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
	 * {@inheritDoc}
	 */
	@Override
	@PostMapping("/create")
	public IProfil create(
			@RequestBody final ProfilCerbereDTO pProfil) throws Exception {
		
		System.out.println("DTO : " + pProfil.toString());
		
		final ProfilCerbere profil = new ProfilCerbere(pProfil);
		
		
		System.out.println("PROFIL : " + profil.toString());
		
		return this.profilService.create(profil);
		
	} // Fin de create(...)._______________________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@GetMapping("/{id}")
	public IProfil findById(
			@PathVariable("id") final Long pId) throws Exception {
		return this.profilService.findById(pId);
	} // Fin de findById(...)._____________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@GetMapping("/profils")
	public List<IProfil> findAll() throws Exception {
		return this.profilService.findAll();
	} // Fin de findAll()._________________________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@PutMapping("/{id}")
	public IProfil update(
			@PathVariable("id") final Long pId
				, @RequestBody final IProfil pProfil) 
					throws Exception {		
		return this.profilService.update(pId, pProfil);		
	} // Fin de update(...)._______________________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@DeleteMapping("/{id}")
	public boolean deleteById(
			@PathVariable("id") final Long pId) throws Exception {
		return this.profilService.deleteByIdBoolean(pId);
	} // Fin de deleteById(...).___________________________________________
	
	
	
} // FIN DE LA CLASSE ProfilController.--------------------------------------
