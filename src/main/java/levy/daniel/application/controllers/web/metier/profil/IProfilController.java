package levy.daniel.application.controllers.web.metier.profil;

import java.util.Collection;

import levy.daniel.application.model.metier.profil.IProfil;
import levy.daniel.application.model.persistence.metier.profil.entities.ProfilEntityJPA;

/**
 * INTERFACE IProfilController :<br/>
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
 * @since 6 nov. 2018
 *
 */
public interface IProfilController {

	/**
	 * .<br/>
	 * <ul>
	 * <li>.</li>
	 * </ul>
	 *
	 * @param pProfil
	 * @return :  :  .<br/>
	 */
	IProfil create(ProfilEntityJPA pProfil);



	/**
	 * .<br/>
	 * <ul>
	 * <li>.</li>
	 * </ul>
	 *
	 * @param pId
	 * @return :  :  .<br/>
	 */
	IProfil getById(Long pId);



	/**
	 * .<br/>
	 * <ul>
	 * <li></li>
	 * </ul>
	 *
	 * @return : Collection<ProfilEntityJPA> :  .<br/>
	 */
	Collection<ProfilEntityJPA> listAll();



	/**
	 * .<br/>
	 * <ul>
	 * <li>.</li>
	 * </ul>
	 *
	 * @param pId
	 * @param pProfil
	 * @return :  :  .<br/>
	 */
	IProfil update(Long pId, ProfilEntityJPA pProfil);



	/**
	 * .<br/>
	 * <ul>
	 * <li>.</li>
	 * </ul>
	 *
	 * @param pId
	 * @return :  :  .<br/>
	 */
	boolean deleteById(Long pId);
	
	
	
} // FIN DE L'INTERFACE IProfilController.-----------------------------------
