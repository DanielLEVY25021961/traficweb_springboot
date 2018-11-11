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
import levy.daniel.application.model.dto.metier.profil.impl.ProfilDTO;
import levy.daniel.application.model.metier.profil.IProfil;
import levy.daniel.application.model.metier.profil.impl.Profil;
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
	
	

	/* CREATE ************/

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@PostMapping("/create")
	public IProfil create(
			@RequestBody final ProfilDTO pDTO) throws Exception {
		
		/* retourne null si pDTO == null. */
		if (pDTO == null) {
			return null;
		}
		
		/* instanciation d'un objet métier concret 
		 * (passé avec la visibilité Interface) à partir du DTO. */
		final IProfil profil = new Profil(pDTO);
		
		/* délégation au SERVICE. */
		return this.profilService.create(profil);
		
	} // Fin de create(...)._______________________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void persist(
			final IProfil pObject) throws Exception {
		// TODO Auto-generated method stub
		
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long createReturnId(
			final IProfil pObject) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public Iterable<IProfil> save(
			final Iterable<IProfil> pList) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	
	/* READ *************/


	/**
	 * {@inheritDoc}
	 */
	@Override
	public IProfil retrieve(
			final IProfil pObject) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	
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
	public Long retrieveId(
			final IProfil pObject) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	
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
	public List<IProfil> findAllMax(
			final int pStartPosition, final int pMaxResult) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public Iterable<IProfil> findAll(
			final Iterable<Long> pIds) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



	/* UPDATE *************/


	/**
	 * {@inheritDoc}
	 */
	@Override
	public IProfil update(
			final IProfil pObject) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	
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



	/* DELETE *************/


	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean delete(
			final IProfil pObject) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	@DeleteMapping("/{id}")
	public boolean deleteById(
			@PathVariable("id") final Long pId) throws Exception {
		return this.profilService.deleteByIdBoolean(pId);
	} // Fin de deleteById(...).___________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteByIdBoolean(
			final Long pId) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteAllBoolean() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteIterable(
			final Iterable<IProfil> pList) throws Exception {
		// TODO Auto-generated method stub
		
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteIterableBoolean(
			final Iterable<IProfil> pList) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}


	
	/* TOOLS *************/


	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean exists(
			final IProfil pObject) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean exists(
			final Long pId) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long count() throws Exception {
		return this.profilService.count();
	} // Fin de count().___________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void ecrireStockageDansConsole() throws Exception {
		this.profilService.ecrireStockageDansConsole();		
	} // Fin de ecrireStockageDansConsole().________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public String afficherListeObjetsMetier(
			final List<IProfil> pList) {
		return this.profilService.afficherListeObjetsMetier(pList);
	} // Fin de afficherListeObjetsMetier(...).____________________________


	
} // FIN DE LA CLASSE ProfilController.--------------------------------------
