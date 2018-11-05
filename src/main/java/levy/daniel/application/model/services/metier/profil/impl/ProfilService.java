package levy.daniel.application.model.services.metier.profil.impl;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import levy.daniel.application.model.persistence.metier.profil.dao.impl.ProfilDao;
import levy.daniel.application.model.persistence.metier.profil.entities.ProfilEntityJPA;

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
 * @author daniel.levy Lévy
 * @version 1.0
 * @since 5 nov. 2018
 *
 */
@Service
public class ProfilService {

	// ************************ATTRIBUTS************************************/

	/**
	 * DAO pour les IProfil.<br/>
	 */
	@Autowired
	private transient ProfilDao profilDao;
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(ProfilService.class);

	// *************************METHODES************************************/

	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public ProfilService() {
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
	public Collection<ProfilEntityJPA> getAllProfilsFake() {
		return this.profilDao.getAllProfilsFake();
	} // Fin de getAllProfilsFake()._______________________________________
	
	
	
} // FIN DE LA CLASSE ProfilService.-----------------------------------------
