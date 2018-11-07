package levy.daniel.application.model.services.metier.profil.impl;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import levy.daniel.application.model.metier.profil.IProfil;
import levy.daniel.application.model.persistence.metier.profil.dao.IProfilDao;
import levy.daniel.application.model.persistence.metier.profil.entities.jpa.ProfilEntityJPA;

/**
 * CLASSE ProfilServiceFake :<br/>
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
@Service
@Qualifier("ProfilServiceFake")
public class ProfilServiceFake implements IProfilService {

	// ************************ATTRIBUTS************************************/

	/**
	 * DAO pour les IProfil.<br/>
	 */
	@Autowired
	@Qualifier("ProfilDaoFake")
	private transient IProfilDao profilDaoFake;
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(ProfilServiceFake.class);

	// *************************METHODES************************************/

	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public ProfilServiceFake() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public IProfil create(
			final ProfilEntityJPA pProfil) {
		return this.profilDaoFake.create(pProfil);
	}
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public IProfil getById(
			final Long pId) {
		return this.profilDaoFake.getById(pId);
	}
	

		
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<ProfilEntityJPA> listAll() {
		return this.profilDaoFake.listAll();
	} // Fin de getAllProfilsFake()._______________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public IProfil update(
			final Long pId, final IProfil pProfil) {		
		return this.profilDaoFake.update(pId, pProfil);		
	}
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteById(
			final Long pId) {
		return this.profilDaoFake.deleteById(pId);
	}

	
	
} // FIN DE LA CLASSE ProfilServiceFake.-----------------------------------------
