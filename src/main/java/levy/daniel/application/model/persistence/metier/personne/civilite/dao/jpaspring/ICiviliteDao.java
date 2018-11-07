package levy.daniel.application.model.persistence.metier.personne.civilite.dao.jpaspring;

import levy.daniel.application.model.metier.personne.civilite.ICivilite;
import levy.daniel.application.model.persistence.daoexceptions.AbstractDaoException;
import levy.daniel.application.model.persistence.metier.IDaoGenericJPASpring;


/**
 * INTERFACE <b>ICiviliteDao</b> :<br/>
 * <ul>
 * <li>Interface des DAOs pour les <b>Civilite</b>.</li>
 * <li>
 * HERITE DE L'INTERFACE GENERIQUE 
 * IDaoGenericJPASpring&lt;T, ID extends Serializable&gt;.
 * </li>
 * <li>
 * Définit les méthodes <i>spécifiques</i> aux Civilite.
 * </li>
 * <li>
 * Définit en particulier la méthode de <b>recherche 
 * par identifiant métier</b>.
 * </li>
 * <br/>
 * <li>
 * <img src="../../../../../../../../../../javadoc/images/implementation_Dao_Civilite.png" 
 * alt="implémentation des DAOs des Civilite" border="1" align="center" />
 * </li>
 * </ul>
 * <br/>
 * 
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
 * @since 27 février 2018
 *
 */
public interface ICiviliteDao 
			extends IDaoGenericJPASpring<ICivilite, Long> {


	
	/**
	 * method retrieveByIdMetier(
	 * ICivilite pObjet) :<br/>
	 * <ul>
	 * <li>Recherche un ICivilite pObjet en base 
	 * via son identifiant métier.</li>
	 * <li>Retourne ICivilite trouvé en base.</li>
	 * </ul> 
	 * <br/>
	 *
	 * @param pObjet : ICivilite : 
	 * Objet à rechercher en base.<br/>
	 * 
	 * @return : ICivilite : 
	 * L'Objet trouvé en base.<br/>
	 * 
	 * @throws AbstractDaoException 
	 */
	ICivilite 
		retrieveByIdMetier(ICivilite pObjet) 
				throws AbstractDaoException;



	/**
	 * method retrieveByAttributs(
	 * String pCiviliteString) :
	 * <ul>
	 * <li>Recherche en base un ICivilite ayant 
	 * pour attributs ceux passés en paramètre.</li>
	 * <li>Les attributs sont ceux de equals(...) et doivent 
	 * identifier un objet unique.</li>
	 * </ul>
	 * return null le paramètre est blank.<br/>
	 * <br/>
	 *
	 * @param pCiviliteString : String : civiliteString du ICivilite.<br/>
	 * 
	 * @return ICivilite.<br/>
	 * 
	 * @throws AbstractDaoException
	 */
	ICivilite retrieveByAttributs(
			String pCiviliteString)
					throws AbstractDaoException;

		
	
} // FIN DE L'INTERFACE ICiviliteDao.----------------------------------------
