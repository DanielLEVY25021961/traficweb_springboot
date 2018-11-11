package levy.daniel.application.model.dto.metier.internaute;

import java.io.Serializable;
import java.util.List;

import levy.daniel.application.model.dto.metier.profil.IProfilDTO;

/**
 * INTERFACE IInternauteDTO :<br/>
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
public interface IInternauteDTO extends Serializable {

	
	
	/**
	 * Getter .<br/>
	 * <br/>
	 *
	 * @return idString : String : this.idString.<br/>
	 */
	String getIdString();

	
	
	/**
	* .<br/>
	* <br/>
	*
	* @param pIdString : String : 
	* valeur à passer à this.idString.<br/>
	*/
	void setIdString(String pIdString);

	
	
	/**
	 * Getter .<br/>
	 * <br/>
	 *
	 * @return prenom : String : this.prenom.<br/>
	 */
	String getPrenom();

	
	
	/**
	* .<br/>
	* <br/>
	*
	* @param pPrenom : String : 
	* valeur à passer à this.prenom.<br/>
	*/
	void setPrenom(String pPrenom);

	
	
	/**
	 * Getter .<br/>
	 * <br/>
	 *
	 * @return nom : String : this.nom.<br/>
	 */
	String getNom();

	
	
	/**
	* .<br/>
	* <br/>
	*
	* @param pNom : String : 
	* valeur à passer à this.nom.<br/>
	*/
	void setNom(String pNom);

	
	
	/**
	 * Getter .<br/>
	 * <br/>
	 *
	 * @return login : String : this.login.<br/>
	 */
	String getLogin();

	
	
	/**
	* .<br/>
	* <br/>
	*
	* @param pLogin : String : 
	* valeur à passer à this.login.<br/>
	*/
	void setLogin(String pLogin);

	
	
	/**
	 * Getter .<br/>
	 * <br/>
	 *
	 * @return password : String : this.password.<br/>
	 */
	String getPassword();

	
	
	/**
	* .<br/>
	* <br/>
	*
	* @param pPassword : String : 
	* valeur à passer à this.password.<br/>
	*/
	void setPassword(String pPassword);

	
	
	/**
	 * Getter .<br/>
	 * <br/>
	 *
	 * @return profilsString : List<IProfilDTO> : this.profilsString.<br/>
	 */
	List<IProfilDTO> getProfilsString();

	
	
	/**
	* .<br/>
	* <br/>
	*
	* @param pProfilsString : List<IProfilDTO> : 
	* valeur à passer à this.profilsString.<br/>
	*/
	void setProfilsString(List<IProfilDTO> pProfilsString);

	
	
} // FIN DE L'INTERFACE IInternauteDTO.--------------------------------------