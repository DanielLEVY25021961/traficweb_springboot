package levy.daniel.application.model.services.metier.profil.jpaspring.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import levy.daniel.application.model.metier.profil.IProfil;
import levy.daniel.application.model.persistence.metier.profil.dao.jpaspring.IProfilDAO;
import levy.daniel.application.model.services.metier.profil.jpaspring.IProfilService;



/**
 * CLASSE ProfilService :<br/>
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
@Service("ProfilServiceJPASpring")
public class ProfilService implements IProfilService {
	
	// ************************ATTRIBUTS************************************/

	/**
	 * DAO pour les IProfil.<br/>
	 */
	@Autowired
	@Qualifier("ProfilDaoJPASpring")
	private transient IProfilDAO profilDAO;

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(ProfilService.class);
	
	// *************************METHODES************************************/

	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public ProfilService() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	

	/* CREATE ************/

	
	/**
	 * {@inheritDoc}
	 */
	@Transactional
	@Override
	public IProfil create(
			final IProfil pProfil) throws Exception {
		return this.profilDAO.create(pProfil);
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
	public IProfil findById(
			final Long pId) throws Exception {
		return this.profilDAO.findById(pId);
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
	public List<IProfil> findAll() throws Exception {
		return this.profilDAO.findAll();
	} // Fin de getAllProfilsFake()._______________________________________



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
	public IProfil update(
			final Long pId, final IProfil pProfil) throws Exception {		
		return this.profilDAO.update(pId, pProfil);		
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
	public void deleteById(
			final Long pId) throws Exception {
		// TODO Auto-generated method stub
		
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteByIdBoolean(
			final Long pId) throws Exception  {
		return this.profilDAO.deleteByIdBoolean(pId);
	} // Fin de deleteByIdBoolean(...).____________________________________



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
		return this.profilDAO.exists(pObject);
	} // Fin de exists(...)._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean exists(
			final Long pId) throws Exception {
		return this.profilDAO.exists(pId);
	} // Fin de exists(...)._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long count() throws Exception {
		return this.profilDAO.count();
	} // Fin de count().___________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void ecrireStockageDansConsole() throws Exception {
		this.profilDAO.ecrireStockageDansConsole();		
	} // Fin de ecrireStockageDansConsole()._______________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public String afficherListeObjetsMetier(
			final List<IProfil> pList) {
		return this.profilDAO.afficherListeObjetsMetier(pList);
	} // Fin de afficherListeObjetsMetier(...).____________________________


	
} // FIN DE LA CLASSE ProfilService.-----------------------------------------
