package levy.daniel.application.model.persistence.metier.personne.civilite.entities.jaxb;

import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.personne.civilite.ICivilite;

/**
 * CLASSE CiviliteEntityJAXB :<br/>
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
@XmlRootElement(name = "civilite")
@XmlType(propOrder = {"id", "civiliteString"})
public class CiviliteEntityJAXB implements ICivilite {

	// ************************ATTRIBUTS************************************/

	/**
	 * .<br/>
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * "Classe CiviliteEntityJPA".<br/>
	 */
	public static final String CLASSE_CIVILITE_ENTITY_JPA 
		= "Classe CiviliteEntityJPA";


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
	 * id : Long :<br/>
	 * ID en base.<br/>
	 */
	protected Long id;
	
	
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
		= LogFactory.getLog(CiviliteEntityJAXB.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public CiviliteEntityJAXB() {
		this(null, null);
	} // Fin du CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	 * <ul>
	 * <li>CONSTRUCTEUR COMPLET.</li>
	 * <li>SANS ID en base.</li>
	 * </ul>
	 *
	 * @param pCiviliteString : String : 
	 * civilité (MONSIEUR ou M., MADAME ou Mme, ...).<br/>
	 */
	public CiviliteEntityJAXB(
			final String pCiviliteString) {
		
		this(null, pCiviliteString);
		
	} // Fin du CONSTRUCTEUR COMPLET.______________________________________
	
	
	
	 /**
	 * <ul>
	 * <li>CONSTRUCTEUR COMPLET BASE.</li>
	 * <li>AVEC ID en base.</li>
	 * </ul>
	 *
	 * @param pId : Long : ID en base.<br/>
	 * @param pCiviliteString : String : 
	 * civilité (MONSIEUR ou M., MADAME ou Mme, ...).<br/>
	 */
	public CiviliteEntityJAXB(
			final Long pId
				, final String pCiviliteString) {
		
		super();
		
		this.id = pId;
		this.civiliteString = pCiviliteString;
		
	} // Fin de CONSTRUCTEUR COMPLET BASE._________________________________


	
	 /**
	 * CONSTRUCTEUR TRANSFORMATEUR AVEC OBJET METIER.<br/>
	 * <ul>
	 * <li><b>transforme un Objet Metier en Entité JAXB</b>.</li>
	 * </ul>
	 *
	 * @param pObjetMetier : ICivilite.<br/>
	 */
	public CiviliteEntityJAXB(
			final ICivilite pObjetMetier) {
		
		super();
		
		if (pObjetMetier != null) {
			
			this.id = pObjetMetier.getId();
			this.civiliteString = pObjetMetier.getCiviliteString();
			
		}
		
	} // Fin de CONSTRUCTEUR TRANSFORMATEUR AVEC OBJET METIER._____________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result 
				+ ((this.civiliteString == null) ? 0 
						: this.civiliteString.hashCode());
		return result;
		
	} // Fin de hashCode().________________________________________________



	/**
	 * {@inheritDoc}
	 * <br/>
	 * <ul>
	 * <b>equals(...) pour un AbstractCivilite</b> sur :
	 * <li>civiliteString.</li>
	 *</ul>
	 * <br/>
	 */
	@Override
	public final boolean equals(
			final Object pObjet) {

		if (this == pObjet) {
			return true;
		}
		
		if (pObjet == null) {
			return false;
		}
		
		if (!(pObjet instanceof ICivilite)) {
			return false;
		}
		
		final ICivilite other = (ICivilite) pObjet;
		
		if (this.getCiviliteString() == null) {
			if (other.getCiviliteString() != null) {
				return false;
			}
		}
		else if (!this.getCiviliteString()
				.equalsIgnoreCase(other.getCiviliteString())) {
			return false;
		}
		
		return true;
		
	} // Fin de equals(...)._______________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final int compareTo(
			final ICivilite pObject) {
		
		if (this == pObject) {
			return 0;
		}

		if (pObject == null) {
			return -1;
		}

		int compareCivilite = 0;
		
		if (this.civiliteString == null) {
			if (pObject.getCiviliteString() != null) {
				return +1;
			}
			
			return 0;
		}
		
		if (pObject.getCiviliteString() == null) {
			return -1;
		}
				
		compareCivilite 
			= this.civiliteString
			.compareToIgnoreCase(pObject.getCiviliteString());
		
		return compareCivilite;

	} // Fin de compareTo(...).____________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final CiviliteEntityJAXB clone() throws CloneNotSupportedException {

		final CiviliteEntityJAXB clone = (CiviliteEntityJAXB) super.clone();
		
		clone.setId(this.id);
		clone.setCiviliteString(this.civiliteString);
		
		return clone;
		
	} // Fin de clone().___________________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {

		final StringBuilder builder = new StringBuilder();
		
		builder.append("CiviliteEntityJAXB [");
		
		builder.append("id=");
		if (this.id != null) {
			builder.append(this.id);
		} else {
			builder.append(NULL);			
		}
		
		builder.append(VIRGULE_ESPACE);
		
		builder.append("civilité=");
		if (this.civiliteString != null) {
			builder.append(this.civiliteString);
		} else {
			builder.append(NULL);			
		}
		
		builder.append(']');
		
		return builder.toString();
		
	} // Fin de toString().________________________________________________

	

	/**
	 * {@inheritDoc}
	 * <br/>
	 * <b>en-tête csv pour un AbstractCivilite</b> :<br/>
	 * "id;civilité;".<br/>
	 * <br/>
	 */
	@Transient
	@Override
	public final String fournirEnTeteCsv() {
		return "id;civilité;";
	} // Fin de getEnTeteCsv().____________________________________________



	/**
	 * {@inheritDoc}
	 * <br/>
	 * <b>ligne csv pour un AbstractCivilite</b> :<br/>
	 * "id;civilité;".<br/>
	 * <br/>
	 */
	@Override
	public final String fournirStringCsv() {

		final StringBuilder stb = new StringBuilder();
		
		/* id. */
		stb.append(this.getId());
		stb.append(POINT_VIRGULE);
		
		/* civilite. */
		stb.append(this.getCiviliteString());
		stb.append(POINT_VIRGULE);
		
		return stb.toString();
		
	} // Fin de toStringCsv()._____________________________________________



	/**
	 * {@inheritDoc}
	 * <br/>
	 * <b>en-tête Jtable pour un AbstractCivilite</b> :<br/>
	 * "id;civilité;".<br/>
	 * <br/>
	 */
	@Transient
	@Override
	public final String fournirEnTeteColonne(
			final int pI) {

		String entete = null;

		switch (pI) {

		case 0:
			entete = "id";
			break;
			
		case 1:
			entete = "civilité";
			break;
			
		default:
			entete = "invalide";
			break;

		} // Fin du Switch._________________________________

		return entete;

	} // Fin de getEnTeteColonne(...)._____________________________________



	/**
	 * {@inheritDoc}
	 * <br/>
	 * <b>ligne Jtable pour un AbstractCivilite</b> :<br/>
	 * "id;civilité;".<br/>
	 * <br/>
	 */
	@Transient
	@Override
	public final Object fournirValeurColonne(
			final int pI) {

		Object valeur = null;

		switch (pI) {

		case 0:
			if (this.getId() != null) {
				valeur = String.valueOf(this.getId());
			}
			
			break;

		case 1:
			valeur = this.getCiviliteString();
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
	@XmlElement(name = "id")
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
	@XmlElement(name = "civiliteString")
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

			

} // FIN DE LA CLASSE CiviliteEntityJAXB.------------------------------------
