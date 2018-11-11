package levy.daniel.application.model.dto.metier.profil.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.dto.metier.profil.IProfilDTO;
import levy.daniel.application.model.metier.profil.IProfil;

/**
 * CLASSE ProfilDTO :<br/>
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
public class ProfilDTO implements IProfilDTO {

	// ************************ATTRIBUTS************************************/

	/**
	 * .<br/>
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * "Classe ProfilDTO".<br/>
	 */
	public static final String CLASSE_PROFIL_CERBERE_DTO 
		= "Classe ProfilDTO";
	
	/**
	 * identifiant en base sous forme de String.<br/>
	 */
	private String idString;

	/**
	 * profilString du Profil.<br/>
	 * <ul>
	 * <li>RG_PROFIL_PROFILSTRING_RENSEIGNE_01 : 
	 * le profilString du Profil doit être renseigné (obligatoire).</li>
	 * <li>RG_PROFIL_PROFILSTRING_NOMENCLATURE_02 : 
	 * le profilString du Profil doit respecter un ensemble fini de valeurs (nomenclature).</li>
	 * </ul>
	 */
	protected String profilStringString;

	/**
	 * porteeProfil du Profil.<br/>
	 * <ul>
	 * <li>RG_PROFIL_PORTEEPROFIL_RENSEIGNE_01 : 
	 * le porteeProfil du Profil doit être renseigné (obligatoire).</li>
	 * </ul>
	 */
	protected String porteeProfilString;

	/**
	 * restrictionProfil du Profil.<br/>
	 */
	protected String restrictionProfilString;


	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(ProfilDTO.class);

	// *************************METHODES************************************/
	

	/**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public ProfilDTO() {

		this(null, null, null, null);

	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________



	/**
	 * <ul>
	 * <li>CONSTRUCTEUR COMPLET.</li>
	 * <li>SANS ID en base.</li>
	 * </ul>
	 * 
	 * @param pIdString : String :
	 * @param pProfilStringString : String : 
	 * profilStringString du ProfilCerbereForm.<br/>
	 * @param pPorteeProfilString : String : 
	 * porteeProfilString du ProfilCerbereForm.<br/>
	 * @param pRestrictionProfilString : String : 
	 * restrictionProfilString du ProfilCerbereForm.<br/>
	 */
	public ProfilDTO(
			final String pIdString
				, final String pProfilStringString
					, final String pPorteeProfilString
						, final String pRestrictionProfilString) {

		super();

		this.idString = pIdString;
		this.profilStringString = pProfilStringString;
		this.porteeProfilString = pPorteeProfilString;
		this.restrictionProfilString = pRestrictionProfilString;

	} // Fin de CONSTRUCTEUR COMPLET.______________________________________


	
	 /**
	 * CONTROLEUR TRANSFORMATEUR.<br/>
	 * <ul>
	 * <li>Transforme un OBJET METIER en contenu de VUE (DTO) 
	 * pour affichage.</li>
	 * </ul>
	 *
	 * @param pProfil : IProfil : Objet métier.<br/>
	 */
	public ProfilDTO(
			final IProfil pProfil) {
		
		super();
		
		if (pProfil != null) {
			
			if (pProfil.getId() != null) {
				this.idString = String.valueOf(pProfil.getId());
			} else {
				this.idString = null;
			}
			
			this.profilStringString = pProfil.getProfilString();
			this.porteeProfilString = pProfil.getPorteeProfil();
			this.restrictionProfilString = pProfil.getRestrictionProfil();
			
		}
		
	} // Fin de CONTROLEUR TRANSFORMATEUR._________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		
		final StringBuilder builder = new StringBuilder();
		
		builder.append("ProfilDTO [");
		if (this.idString != null) {
			builder.append("idString=");
			builder.append(this.idString);
			builder.append(", ");
		}
		if (this.profilStringString != null) {
			builder.append("profilStringString=");
			builder.append(this.profilStringString);
			builder.append(", ");
		}
		if (this.porteeProfilString != null) {
			builder.append("porteeProfilString=");
			builder.append(this.porteeProfilString);
			builder.append(", ");
		}
		if (this.restrictionProfilString != null) {
			builder.append("restrictionProfilString=");
			builder.append(this.restrictionProfilString);
		}
		builder.append(']');
		
		return builder.toString();
		
	} // Fin de toString().________________________________________________



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
	public String getProfilStringString() {
		return this.profilStringString;
	} // Fin de getProfilStringString().___________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setProfilStringString(
			final String pProfilStringString) {
		this.profilStringString = pProfilStringString;
	} // Fin de setProfilStringString().___________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getPorteeProfilString() {
		return this.porteeProfilString;
	} // Fin de getPorteeProfilString().___________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setPorteeProfilString(
			final String pPorteeProfilString) {
		this.porteeProfilString = pPorteeProfilString;
	} // Fin de setPorteeProfilString().___________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getRestrictionProfilString() {
		return this.restrictionProfilString;
	} // Fin de getRestrictionProfilString().______________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRestrictionProfilString(
			final String pRestrictionProfilString) {
		this.restrictionProfilString = pRestrictionProfilString;
	} // Fin de setRestrictionProfilString().______________________________

	

} // FIN DE LA CLASSE ProfilDTO.--------------------------------------
