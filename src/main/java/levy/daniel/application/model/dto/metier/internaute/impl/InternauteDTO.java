package levy.daniel.application.model.dto.metier.internaute.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.dto.metier.internaute.IInternauteDTO;
import levy.daniel.application.model.metier.internaute.IInternaute;
import levy.daniel.application.model.metier.profil.IProfil;

/**
 * CLASSE InternauteDTO :<br/>
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
public class InternauteDTO implements IInternauteDTO {

	// ************************ATTRIBUTS************************************/
	/**
	 * "Classe InternauteDTO".<br/>
	 */
	public static final String CLASSE_INTERNAUTE_DTO 
		= "Classe InternauteDTO";

	/**
	 * identifiant en base sous forme de String.<br/>
	 */
	private String idString;
	
	/**
	 * prénom de l'internaute.<br/>
	 */
	private String prenom;
	
	/**
	 * nom de l'internaute.<br/>
	 */
	private String nom;
	
	/**
	 * login de l'internaute.<br/>
	 */
	private String login;
	
	/**
	 * mot de passe de l'internaute.<br/>
	 */
	private String password;
		
	/**
	 * profils (ADMINISTRATEUR, CONSULTANT, ...) de l'internaute.<br/>
	 */
	private List<String> profilsString;
	

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(InternauteDTO.class);

	
	// *************************METHODES************************************/

	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public InternauteDTO() {
		this(null, null, null, null, null, null);
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	 /**
	 * CONSTRUCTEUR COMPLET.<br/>
	 * <br/>
	 *
	 * @param pIdString : String :
	 * @param pPrenom : String :
	 * @param pNom : String :
	 * @param pLogin : String :
	 * @param pPassword : String :
	 * @param pProfilsString : String :
	 */
	public InternauteDTO(
			final String pIdString
			, final String pPrenom, final String pNom
			, final String pLogin, final String pPassword
			, final List<String> pProfilsString) {
		
		super();
		
		this.idString = pIdString;
		this.prenom = pPrenom;
		this.nom = pNom;
		this.login = pLogin;
		this.password = pPassword;
		this.profilsString = pProfilsString;
		
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________


	
	 /**
	 * CONTROLEUR TRANSFORMATEUR.<br/>
	 * <ul>
	 * <li>Transforme un OBJET METIER en contenu de VUE (DTO) 
	 * pour affichage.</li>
	 * </ul>
	 *
	 * @param pInternaute : IInternaute : Objet métier.<br/> 
	 */
	public InternauteDTO(
			final IInternaute pInternaute) {
		
		super();
		
		if (pInternaute != null) {
			
			if (pInternaute.getId() != null) {
				this.idString = String.valueOf(pInternaute.getId());
			} else {
				this.idString = null;
			}
			
			this.prenom = pInternaute.getPrenom();
			this.nom = pInternaute.getNom();
			this.login = pInternaute.getLogin();
			this.password = pInternaute.getPassword();
			
			if (pInternaute.getProfils() != null) {
				
				this.profilsString = new ArrayList<String>();
				
				for (final IProfil profil : pInternaute.getProfils()) {
					this.profilsString.add(profil.toString());
				}
			} else {
				this.profilsString = null;
			}
			
		}
		
	} // Fin de CONTROLEUR TRANSFORMATEUR._________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getIdString() {
		return this.idString;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setIdString(
			final String pIdString) {
		this.idString = pIdString;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getPrenom() {
		return this.prenom;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setPrenom(
			final String pPrenom) {
		this.prenom = pPrenom;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getNom() {
		return this.nom;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setNom(
			final String pNom) {
		this.nom = pNom;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getLogin() {
		return this.login;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setLogin(
			final String pLogin) {
		this.login = pLogin;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getPassword() {
		return this.password;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setPassword(
			final String pPassword) {
		this.password = pPassword;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<String> getProfilsString() {
		return this.profilsString;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setProfilsString(
			final List<String> pProfilsString) {
		this.profilsString = pProfilsString;
	}


	
	

} // FIN DE LA CLASSE InternauteDTO.-----------------------------------------
