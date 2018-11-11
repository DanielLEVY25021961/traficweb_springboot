package levy.daniel.application.model.dto.metier.profil;

import java.io.Serializable;

/**
 * INTERFACE IProfilDTO :<br/>
 * DTO servant à encapsuler le contenu d'une VUE.<br/>
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
public interface IProfilDTO extends Serializable {

	
	
	/**
	 * Getter de l'identifiant en base sous forme de String.<br/>
	 *
	 * @return  this.idString : String.<br/>
	 */
	String getIdString();

	
	
	/**
	* Setter de l'identifiant en base sous forme de String.<br/>
	*
	* @param pIdString : String : 
	* valeur à passer à this.idString.<br/>
	*/
	void setIdString(String pIdString);

	
	
	/**
	 * Getter de profilStringString.<br/>
	 *
	 * @return : String : this.profilStringString.<br/>
	 */
	String getProfilStringString();
	
	

	/**
	 * Setter de profilStringString.<br/>
	 *
	 * @param pProfilStringString : String : 
	 * valeur à passer à this.profilStringString.<br/>
	 */
	void setProfilStringString(String pProfilStringString);
	
	

	/**
	 * Getter de porteeProfilString.<br/>
	 *
	 * @return : String : this.porteeProfilString.<br/>
	 */
	String getPorteeProfilString();
	
	

	/**
	 * Setter de porteeProfilString.<br/>
	 *
	 * @param pPorteeProfilString : String : 
	 * valeur à passer à this.porteeProfilString.<br/>
	 */
	void setPorteeProfilString(String pPorteeProfilString);
	
	

	/**
	 * Getter de restrictionProfilString.<br/>
	 *
	 * @return : String : this.restrictionProfilString.<br/>
	 */
	String getRestrictionProfilString();

	

	/**
	 * Setter de restrictionProfilString.<br/>
	 *
	 * @param pRestrictionProfilString : String : 
	 * valeur à passer à this.restrictionProfilString.<br/>
	 */
	void setRestrictionProfilString(String pRestrictionProfilString);

	

} // FIN DE L'INTERFACE IProfilDTO.------------------------------------