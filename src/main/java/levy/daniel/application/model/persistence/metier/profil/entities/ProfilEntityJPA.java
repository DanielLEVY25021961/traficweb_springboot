package levy.daniel.application.model.persistence.metier.profil.entities;

import javax.persistence.Entity;
import javax.persistence.Transient;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.profil.AbstractProfil;
import levy.daniel.application.model.metier.profil.IProfil;

/**
 * CLASSE ProfilEntityJPA :<br/>
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
@Entity
public class ProfilEntityJPA implements IProfil {

	// ************************ATTRIBUTS************************************/

	/**
	 * CLASSE_ABSTRACT_PROFIL : String :<br/>
	 * "Classe AbstractProfil".<br/>
	 */
	public static final String CLASSE_ABSTRACT_PROFIL 
		= "Classe AbstractProfil";


	/**
	 * POINT_VIRGULE : char :<br/>
	 * ';'.<br/>
	 */
	public static final char POINT_VIRGULE = ';';


	/**
	 * VIRGULE_ESPACE : String :<br/>
	 * ", ".<br/>
	 */
	public static final String VIRGULE_ESPACE = ", ";


	/**
	 * SEPARATEUR_MOINS_AERE : String :<br/>
	 * " - ".<br/>
	 */
	public static final String SEPARATEUR_MOINS_AERE = " - ";


	/**
	 * UNDERSCORE : String :<br/>
	 * "_".<br/>
	 */
	public static final String UNDERSCORE = "_";


	/**
	 * NULL : String :<br/>
	 * "null".<br/>
	 */
	public static final String NULL = "null";


	/**
	 * serialVersionUID : long :<br/>
	 * serialVersionUID = 1L.<br/>
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * id : Long :<br/>
	 * ID en base.<br/>
	 */
	protected Long id;


	/**
	 * profilString : String :<br/>
	 * profilString du Profil.<br/>
	 * <ul>
	 * <li>RG_PROFIL_PROFILSTRING_RENSEIGNE_01 : 
	 * le profilString du Profil doit être renseigné (obligatoire).</li>
	 * <li>RG_PROFIL_PROFILSTRING_NOMENCLATURE_02 : 
	 * le profilString du Profil doit respecter un ensemble fini de valeurs (nomenclature).</li>
	 * </ul>
	 */
	protected String profilString;


	/**
	 * porteeProfil : String :<br/>
	 * porteeProfil du Profil.<br/>
	 * <ul>
	 * <li>RG_PROFIL_PORTEEPROFIL_RENSEIGNE_01 : 
	 * le porteeProfil du Profil doit être renseigné (obligatoire).</li>
	 * </ul>
	 */
	protected String porteeProfil;


	/**
	 * restrictionProfil : String :<br/>
	 * restrictionProfil du Profil.<br/>
	 */
	protected String restrictionProfil;


	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(ProfilEntityJPA.class);

	
	// *************************METHODES************************************/



	/**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public ProfilEntityJPA() {

		this(null, null, null, null);

	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________



	/**
	 * <ul>
	 * <li>CONSTRUCTEUR COMPLET.</li>
	 * <li>SANS ID en base.</li>
	 * </ul>
	 * 
	 * @param pProfilString : String : 
	 * profilString du AbstractProfil.<br/>
	 * @param pPorteeProfil : String : 
	 * porteeProfil du AbstractProfil.<br/>
	 * @param pRestrictionProfil : String : 
	 * restrictionProfil du AbstractProfil.<br/>
	 */
	public ProfilEntityJPA(
			final String pProfilString
				, final String pPorteeProfil
					, final String pRestrictionProfil) {

		this(null, pProfilString, pPorteeProfil, pRestrictionProfil);

	} // Fin de CONSTRUCTEUR COMPLET.______________________________________



	/**
	 * <ul>
	 * <li>CONSTRUCTEUR COMPLET BASE.</li>
	 * <li>AVEC ID en base.</li>
	 * </ul>
	 * 
	 * @param pId : Long : ID en base.<br/>
	 * @param pProfilString : String : 
	 * profilString du AbstractProfil.<br/>
	 * @param pPorteeProfil : String : 
	 * porteeProfil du AbstractProfil.<br/>
	 * @param pRestrictionProfil : String : 
	 * restrictionProfil du AbstractProfil.<br/>
	 */
	public ProfilEntityJPA(
			final Long pId
				, final String pProfilString
					, final String pPorteeProfil
						, final String pRestrictionProfil) {

		super();

		this.id = pId;
		this.profilString = pProfilString;
		this.porteeProfil = pPorteeProfil;
		this.restrictionProfil = pRestrictionProfil;

	} // Fin de CONSTRUCTEUR COMPLET BASE._________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {

		final int prime = 31;

		int result = 1;

		result = prime * result 
				+ ((this.profilString == null) 
					? 0 : this.profilString.hashCode());
		result = prime * result 
				+ ((this.porteeProfil == null) 
					? 0 : this.porteeProfil.hashCode());

		return result;

	} // Fin de hashCode().________________________________________________



	/**
	 * {@inheritDoc}
	 * <br/>
	 * <ul>
	 * <b>equals(...) pour un AbstractProfil</b> sur :
	 * <li>profilString.</li>
	 * <li>porteeProfil.</li>
	 * </ul>
	 * <br/>
	 */
	@Override
	public boolean equals(
			final Object pObject) {

		if (this == pObject) {
			return true;
		}

		if (pObject == null) {
			return false;
		}

		if (!(pObject instanceof AbstractProfil)) {
			return false;
		}

		final IProfil other = (IProfil) pObject;

		/* profilString. */
		if (this.getProfilString() == null) {
			if (other.getProfilString() != null) {
				return false;
			}
		}
		else if (!this.getProfilString()
				.equalsIgnoreCase(other.getProfilString())) {
			return false;
		}

		/* porteeProfil. */
		if (this.getPorteeProfil() == null) {
			if (other.getPorteeProfil() != null) {
				return false;
			}
		}
		else if (!this.getPorteeProfil()
				.equalsIgnoreCase(other.getPorteeProfil())) {
			return false;
		}

		return true;

	} // Fin de equals(...)._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compareTo(
			final IProfil pObject) {

		if (this == pObject) {
			return 0;
		}

		if (pObject == null) {
			return -1;
		}

		int compareProfilString;
		int comparePorteeProfil;

		/* profilString. */
		if (this.getProfilString() == null) {
			if (pObject.getProfilString() != null) {
				return +1;
			}
		} else {
			if (pObject.getProfilString() == null) {
				return -1;
			}

			compareProfilString 
				= this.getProfilString()
					.compareTo(pObject.getProfilString());

			if (compareProfilString != 0) {
				return compareProfilString;
			}
		}

		/* porteeProfil. */
		if (this.getPorteeProfil() == null) {
			if (pObject.getPorteeProfil() != null) {
				return +1;
			}
			return 0;
		} 

		if (pObject.getPorteeProfil() == null) {
			return -1;
		}

		comparePorteeProfil 
			= this.getPorteeProfil()
				.compareTo(pObject.getPorteeProfil());

		return comparePorteeProfil;

	} // Fin de compareTo(...).____________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public ProfilEntityJPA clone() throws CloneNotSupportedException {

		final ProfilEntityJPA clone 
				= (ProfilEntityJPA) super.clone();

		clone.setId(this.id);	
		clone.setProfilString(this.profilString);
		clone.setPorteeProfil(this.porteeProfil);
		clone.setRestrictionProfil(this.restrictionProfil);

		return clone;

	} // Fin de clone().___________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {

		final StringBuilder builder = new StringBuilder();

		builder.append("AbstractProfil [");

		builder.append("id=");
		if (this.id != null) {			
			builder.append(this.id);			
		} else {
			builder.append(NULL);
		}

		builder.append(VIRGULE_ESPACE);

		builder.append("profilString=");
		if (this.profilString != null) {			
			builder.append(this.profilString);
		} else {
			builder.append(NULL);
		}

		builder.append(VIRGULE_ESPACE);

		builder.append("porteeProfil=");
		if (this.porteeProfil != null) {			
			builder.append(this.porteeProfil);
		} else {
			builder.append(NULL);
		}

		builder.append(VIRGULE_ESPACE);

		builder.append("restrictionProfil=");
		if (this.restrictionProfil != null) {			
			builder.append(this.restrictionProfil);
		} else {
			builder.append(NULL);
		}

		builder.append(']');

		return builder.toString();

	} // Fin de toString().________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transient
	public String getEnTeteCsv() {
		return "id;profilString;porteeProfil;restrictionProfil;";
	} // Fin de getEnTeteCsv().____________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toStringCsv() {

		final StringBuilder stb = new StringBuilder();

		/* id. */
		stb.append(this.getId());
		stb.append(POINT_VIRGULE);

		/* profilString. */
		stb.append(this.getProfilString());
		stb.append(POINT_VIRGULE);

		/* porteeProfil. */
		stb.append(this.getPorteeProfil());
		stb.append(POINT_VIRGULE);

		/* restrictionProfil. */
		stb.append(this.getRestrictionProfil());
		stb.append(POINT_VIRGULE);

		return stb.toString();

	} // Fin de toStringCsv()._____________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transient
	public String getEnTeteColonne(
			final int pI) {

		String entete = null;

		switch (pI) {

		case 0:
			entete = "id";
			break;

		case 1:
			entete = "profilString";
			break;

		case 2:
			entete = "porteeProfil";
			break;

		case 3:
			entete = "restrictionProfil";
			break;

		default:
			entete = "invalide";
			break;

		} // Fin du Switch._________________________________

		return entete;

	} // Fin de getEnTeteColonne(...)._____________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transient
	public Object getValeurColonne(
			final int pI) {

		Object valeur = null;

		switch (pI) {

		case 0:
			if (this.getId() != null) {
				valeur = String.valueOf(this.getId());
			}
			break;

		case 1:
			valeur = this.getProfilString();		
			break;

		case 2:
			valeur = this.getPorteeProfil();		
			break;

		case 3:
			valeur = this.getRestrictionProfil();		
			break;

		default:
			valeur = "invalide";
			break;

		} // Fin du Switch._________________________________

		return valeur;

	} // Fin de getValeurColonne(...)._____________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long getId() {
		return this.id;
	} // Fin de getId().___________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setId(
			final Long pId) {
		this.id = pId;
	} // Fin de setId(...).________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getProfilString() {
		return this.profilString;
	} // Fin de getProfilString()._________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setProfilString(
			final String pProfilString) {
		this.profilString = pProfilString;
	} // Fin de setProfilString()._________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getPorteeProfil() {
		return this.porteeProfil;
	} // Fin de getPorteeProfil()._________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setPorteeProfil(
			final String pPorteeProfil) {
		this.porteeProfil = pPorteeProfil;
	} // Fin de setPorteeProfil()._________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getRestrictionProfil() {
		return this.restrictionProfil;
	} // Fin de getRestrictionProfil().____________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRestrictionProfil(
			final String pRestrictionProfil) {
		this.restrictionProfil = pRestrictionProfil;
	} // Fin de setRestrictionProfil().____________________________________



}
