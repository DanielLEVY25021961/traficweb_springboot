package levy.daniel.application.model.dto.metier.personne.civilite;

import java.io.Serializable;

/**
 * INTERFACE ICiviliteDTO :<br/>
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
 * @since 6 nov. 2018
 *
 */
public interface ICiviliteDTO extends Serializable {

	
	
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
	 * method getCiviliteString() :<br/>
	 * <ul>
	 * <li>Getter de civiliteString 
	 * (MONSIEUR ou M., MADAME ou Mme, ...).</li>
	 * <li>civiliteString ne peut prendre 
	 * <i>que les valeurs</i> définies dans 
	 * l'ENUMERATION <b>CivilitesEnum</b>.</li>
	 * </ul>
	 * <ul>
	 * <li>"RG_CIVILITE_CIVILITESTRING_NOMENCLATURE_01 : 
	 * la civilite (MONSIEUR ou M., MADAME ou Mme, ...) 
	 * doit respecter 
	 * un ensemble fini de valeurs (nomenclature)".</li>
	 * </ul>
	 *
	 * @return this.civiliteString : String.<br/>
	 */
	String getCiviliteString();

	
	
	/**
	 * method setCiviliteString(
	 * String pCivilite) :<br/>
	 * <ul>
	 * <li>Setter de civiliteString 
	 * (MONSIEUR ou M., MADAME ou Mme, ...).</li>
	 * <li>civiliteString ne peut prendre 
	 * <i>que les valeurs</i> définies dans 
	 * l'ENUMERATION <b>CivilitesEnum</b>.</li>
	 * </ul>
	 * <ul>
	 * <li>"RG_CIVILITE_CIVILITESTRING_NOMENCLATURE_01 : 
	 * la civilite (M., Mme, ...) du Personne doit respecter 
	 * un ensemble fini de valeurs (nomenclature)".</li>
	 * </ul>
	 *
	 * @param pCivilite : String : valeur à passer 
	 * à this.civiliteString.<br/>
	 */
	void setCiviliteString(String pCivilite);
	
	

} // FIN DE L'INTERFACE ICiviliteDTO.----------------------------------------