package levy.daniel.application.model.services.metier.profil.jpaspring;

import java.util.List;

import levy.daniel.application.model.metier.profil.IProfil;


/**
 * INTERFACE IProfilService :<br/>
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
public interface IProfilService {

	
	
	/**
	 * <b>crée un objet métier pObject dans le stockage 
	 * et retourne l'objet METIER persisté</b>.<br/>
	 * <ul>
	 * <li>ne crée <b>pas de doublon</b>.</li>
	 * <li>retourne null si pObject existe déjà dans le stockage.</li>
	 * </ul>
	 * - retourne null si pObject == null.<br/>
	 * <br/>
	 *
	 * @param pObject : IProfil : 
	 * l'objet métier à persister dans le stockage.<br/>
	 * 
	 * @return IProfil : 
	 * l'objet métier persisté dans le stockage.<br/>
	 * 
	 * @throws Exception
	 */
	IProfil create(IProfil pObject) throws Exception;



	/**
	 * <b>recherche un objet métier pObject via son identifiant (index) 
	 * dans le stockage</b> et retourne l'objet métier persisté.<br/>
	 * <ul>
	 * <li>retourne null si l'objet métier 
	 * n'existe pas dans le stockage.</li>
	 * </ul>
	 *
	 * @param pId : Long : 
	 * index (0-based) ou identifiant en base 
	 * de l'objet métier à rechercher.<br/>
	 * 
	 * @return : IProfil : objet métier recherché.<br/>
	 * 
	 * @throws Exception
	 */
	IProfil findById(Long pId) throws Exception;



	/**
	 * <b>retourne la liste de tous les objets métier 
	 * persistés dans le stockage</b>.<br/>
	 * - peut retourner null si le stockage ne peut être lu.<br/>
	 *
	 * @return : List&lt;IProfil&gt; : 
	 * liste de tous les objets métier persistés dans le stockage.<br/>
	 * 
	 * @throws Exception
	 */
	List<IProfil> findAll() throws Exception;


	
	/**
	 * <b>modifie dans le stockage 
	 * l'objet d'index (0-based) ou d'identifiant pId 
	 * avec les valeurs 
	 * contenues dans pObjectModifie</b>.<br/>
	 * <ul>
	 * <li><b>pId doit correspondre à l'index (0-based) 
	 * de l'objet métier à modifier</b>.</li>
	 * <li>pObjectModifie est un conteneur contenant les modifications 
	 * à apporter à un objet persistant dans le stockage. 
	 * Il n'a pas besoin d'avoir d'ID.</li>
	 * <li>retourne null s'il n'y a pas d'objet persistant à pId.</li>
	 * <li>retourne null si pId est en dehors des indexes.</li>
	 * </ul>
	 * - retourne null si pId == null.<br/>
	 * - retourne null si pObjectModifie == null.<br/>
	 * <br/>
	 *
	 * @param pId : Long : 
	 * index (0-based) de l'objet métier à modifier.<br/>
	 * @param pObjectModifie : IProfil : 
	 * Objet métier contenant les modifications 
	 * à apporter à l'objet persistant dans le stockage.<br/>
	 * 
	 * @return IProfil : objet métier persistant modifié.<br/>
	 * 
	 * @throws Exception
	 */
	IProfil update(Long pId, IProfil pObjectModifie) throws Exception;



	/**
	 * <b>retire l'objet métier d'identifiant ou 
	 * d'index (0-based) pId dans le stockage</b>.<br/>
	 * <ul>
	 * <li>ne fait rien si pId est hors indexes.</li>
	 * </ul>
	 * - ne fait rien si pId == null.<br/>
	 * <br/>
	 *
	 * @param pId : Long : 
	 * index (0-based) de l'objet métier à modifier.<br/>
	 * 
	 * @return boolean : true si l'objet a été détruit.<br/>
	 * 
	 * @throws Exception
	 */
	boolean deleteByIdBoolean(Long pId) throws Exception;
	
	
	
} // FIN DE L'INTERFACE IProfilService.--------------------------------------
