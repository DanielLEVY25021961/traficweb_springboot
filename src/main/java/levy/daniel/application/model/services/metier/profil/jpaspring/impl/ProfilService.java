package levy.daniel.application.model.services.metier.profil.jpaspring.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import levy.daniel.application.model.metier.profil.IProfil;
import levy.daniel.application.model.persistence.metier.profil.dao.jpaspring.IProfilDao;
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
	private transient IProfilDao profilDao;

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
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final IProfil create(
			final IProfil pProfil) throws Exception {
		return this.profilDao.create(pProfil);
	} // Fin de create(...)._______________________________________________
	
	
	
	/**
	 * {@inheritDoc} 
	 */
	@Override
	public final IProfil findById(
			final Long pId) throws Exception {
		return this.profilDao.findById(pId);
	} // Fin de findById(...)._____________________________________________
	

		
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final List<IProfil> findAll() throws Exception {
		return this.profilDao.findAll();
	} // Fin de getAllProfilsFake()._______________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public IProfil update(
			final Long pId, final IProfil pProfil) throws Exception {		
		return this.profilDao.update(pId, pProfil);		
	} // Fin de update(...)._______________________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteByIdBoolean(
			final Long pId) throws Exception  {
		return this.profilDao.deleteByIdBoolean(pId);
	} // Fin de deleteByIdBoolean(...).____________________________________

	
	
} // FIN DE LA CLASSE ProfilService.-----------------------------------------
