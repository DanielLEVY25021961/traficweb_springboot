package levy.daniel.application.model.dto.metier.personne.civilite.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.dto.metier.personne.civilite.ICiviliteDTO;
import levy.daniel.application.model.metier.personne.civilite.ICivilite;

/**
 * CLASSE CiviliteDTO :<br/>
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
 * @since 6 nov. 2018
 *
 */
public class CiviliteDTO implements ICiviliteDTO {

	// ************************ATTRIBUTS************************************/

	/**
	 * "Classe CiviliteDTO".<br/>
	 */
	public static final String CLASSE_CIVILITE_DTO 
		= "Classe CiviliteDTO";
	
	/**
	 * identifiant en base sous forme de String.<br/>
	 */
	private String idString;
	
	/**
	 * civiliteString : String :<br/>
	 * civilité (MONSIEUR ou M., MADAME ou Mme, ...).<br/>
	 * <ul>
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
	 */
	protected String civiliteString;
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(CiviliteDTO.class);

	
	// *************************METHODES************************************/


	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public CiviliteDTO() {
		this(null, null);
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	 /**
	 * CONSTRUCTEUR COMPLET.<br/>
	 * <br/>
	 *
	 * @param pIdString
	 * @param pCiviliteString
	 */
	public CiviliteDTO(
			final String pIdString
				, final String pCiviliteString) {
		
		super();
		
		this.idString = pIdString;
		this.civiliteString = pCiviliteString;
		
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________


	
	 /**
	 * CONTROLEUR TRANSFORMATEUR.<br/>
	 * <ul>
	 * <li>Transforme un OBJET METIER en contenu de VUE (DTO) 
	 * pour affichage.</li>
	 * </ul>
	 *
	 * @param pCivilite : ICivilite : Objet métier
	 */
	public CiviliteDTO(
			final ICivilite pCivilite) {
		
		super();
		
		if (pCivilite != null) {
			
			if (pCivilite.getId() != null) {
				this.idString = String.valueOf(pCivilite.getId());
			} else {
				this.idString = null;
			}
			
			this.civiliteString = pCivilite.getCiviliteString();
		}
		
	} // Fin de CONTROLEUR TRANSFORMATEUR._________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getIdString() {
		return this.idString;
	} // Fin de getIdString()._____________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setIdString(
			final String pIdString) {
		this.idString = pIdString;
	} // Fin de setIdString(...).__________________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getCiviliteString() {	
		return this.civiliteString;
	} // Fin de getCiviliteString()._______________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setCiviliteString(
			final String pCivilite) {	
		this.civiliteString = pCivilite;
	} // Fin de setCiviliteString(...).____________________________________


	
} // FIN DE LA CLASSE CiviliteDTO.-------------------------------------------
