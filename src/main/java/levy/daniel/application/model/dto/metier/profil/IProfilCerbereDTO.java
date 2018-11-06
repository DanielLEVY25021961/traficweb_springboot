package levy.daniel.application.model.dto.metier.profil;

/**
 * INTERFACE IProfilCerbereDTO :<br/>
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
public interface IProfilCerbereDTO {

	
	
	/**
	 * Getter de l'identifiant en base sous forme de String.<br/>
	 *
	 * @return  this.idString : String.<br/>
	 */
	String getIdString();

	
	
	/**
	* Setter de l'identifiant en base sous forme de String.<br/>
	* <br/>
	*
	* @param pIdString : String : 
	* valeur à passer à this.idString.<br/>
	*/
	void setIdString(String pIdString);

	
	
	/**
	 * method getProfilStringString() :<br/>
	 * Getter de profilStringString.<br/>
	 * <br/>
	 *
	 * @return : String : this.profilStringString.<br/>
	 */
	String getProfilStringString();
	
	

	/**
	 * method setProfilStringString(
	 * String pProfilStringString) :<br/>
	 * Setter de profilStringString.<br/>
	 * <br/>
	 *
	 * @param pProfilStringString : String : 
	 * valeur à passer à this.profilStringString.<br/>
	 */
	void setProfilStringString(String pProfilStringString);
	
	

	/**
	 * method getPorteeProfilString() :<br/>
	 * Getter de porteeProfilString.<br/>
	 * <br/>
	 *
	 * @return : String : this.porteeProfilString.<br/>
	 */
	String getPorteeProfilString();
	
	

	/**
	 * method setPorteeProfilString(
	 * String pPorteeProfilString) :<br/>
	 * Setter de porteeProfilString.<br/>
	 * <br/>
	 *
	 * @param pPorteeProfilString : String : 
	 * valeur à passer à this.porteeProfilString.<br/>
	 */
	void setPorteeProfilString(String pPorteeProfilString);
	
	

	/**
	 * method getRestrictionProfilString() :<br/>
	 * Getter de restrictionProfilString.<br/>
	 * <br/>
	 *
	 * @return : String : this.restrictionProfilString.<br/>
	 */
	String getRestrictionProfilString();

	

	/**
	 * method setRestrictionProfilString(
	 * String pRestrictionProfilString) :<br/>
	 * Setter de restrictionProfilString.<br/>
	 * <br/>
	 *
	 * @param pRestrictionProfilString : String : 
	 * valeur à passer à this.restrictionProfilString.<br/>
	 */
	void setRestrictionProfilString(String pRestrictionProfilString);

	

} // FIN DE L'INTERFACE IProfilCerbereDTO.------------------------------------