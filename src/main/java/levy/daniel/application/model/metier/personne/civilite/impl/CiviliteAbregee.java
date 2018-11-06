package levy.daniel.application.model.metier.personne.civilite.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.dto.metier.personne.civilite.ICiviliteDTO;
import levy.daniel.application.model.metier.personne.civilite.AbstractCivilite;
import levy.daniel.application.model.persistence.metier.personne.civilite.entities.jpa.CiviliteEntityJPA;

/**
 * CLASSE CONCRETE <b>CiviliteAbregee</b> :<br/>
 * <p>
 * <span style="text-decoration: underline;">CONCEPT MODELISE</span>
 * </p>
 * <p>
 * <b>CiviliteAbregee</b> Modélise un <i>concept</i> de <b>Civilite</b>, 
 * (M., Mme, Mlle, Me, Dr ...) - dans lequel la civilité est <i>abrégée</i> - 
 * associé de manière unique à une <b>Personne</b>.
 * </p>
 * 
 * 
 * <p>
 * <span style="text-decoration: underline;">DESCRIPTION DE CiviliteAbregee</span>
 * </p>
 * <ul>
 * <li>Classe CONCRETE modélisant une <b>CiviliteAbregee</b> 
 * (M., Mme, Mlle, Me, Dr ...).</li>
 * <li>La civilité ne peut prendre <i>que les valeurs</i> définies dans 
 * l'ENUMERATION <b>CivilitesEnum</b>.</li>
 * <li>"RG_CIVILITEABREGEE_CIVILITESTRING_NOMENCLATURE_01 : 
 * la civilite (M., Mme, ...) doit respecter 
 * un ensemble fini de valeurs (nomenclature)".</li>
 * </ul>
 * 
 * <ul>
 * <li>Implémentation <b>CONCRETE</b> de ICivilite.</li>
 * <li>HERITE de AbstractCivilite.</li>
 * </ul>
 * 
 * <p>
 * <span style="text-decoration: underline;">ATTRIBUTS</span>
 * </p>
 * <ul>
 * <li>Les <b>attributs</b> d'un CiviliteAbregee sont : </li>
 * <ul>
 * <li><b>id</b> pour la mise en base.</li>
 * <li><b>civiliteString</b>.</li>
 * </ul>
 * </ul>
 * 
 * <p>
 * <span style="text-decoration: underline;">EGALITE METIER</span>
 * </p>
 * <ul>
 * <li>L'<b>égalité metier</b> d'un CiviliteAbregee est vérifiée sur :</li>
  * <ul>
 * <li><b>civiliteString</b></li>
 * </ul>
 * </ul>
 * 
 * <p>
 * <span style="text-decoration: underline;">DIAGRAMME DE CLASSES D'IMPLEMENTATION</span>
 * </p>
 * <ul>
 * <li>
 * <img src="../../../../../../../../../../../javadoc/images/classes_implementation_civilite.png" 
 * alt="classes d'implémentation des AbstractCivilite" border="1" align="center" />
 * </li>
 * </ul>
 * 
 * <p>
 * <span style="text-decoration: underline;">
 * ENTITIES JPA
 * </span>
 * </p>
 * <ul>
 * <li>la classe concrète CiviliteAbregee 
 * est transformée en <b>Entity JPA</b> au moyen de 
 * <b>javax.persistence annotations</b>.</li>
 * <li>La <b>stratégie de jointure des tables</b> entre la classe abstraite 
 * et ses descendants concrets est <b>InheritanceType.JOINED</b>.</li>
 * <br/>
 * <li>
 * <img src="../../../../../../../../../../../javadoc/images/implementation_civilite_entities.png" 
 * alt="implémentation des entities de AbstractCivilite" border="1" align="center" />
 * </li>
 * </ul>
 * 
 * <p>
 * <span style="text-decoration: underline;">
 * TABLES
 * </span>
 * </p>
 * <ul>
 * <li>Les <b>tables en base</b> résultantes des entities JPA sont :</li>
 * <br/>
 * <li>
 * <img src="../../../../../../../../../../../javadoc/images/tables-abstract_civilites_civilites.png" 
 * alt="implémentation des tables de AbstractCivilite" border="1" align="center" />
 * </li>
 * </ul>
 * 
 * <br/>
 * <p>
 * <span style="text-decoration: underline;">REGLES DE GESTION</span>
 * </p>
 * <ul>
 * <li>
 * Les <b>Règles de Gestion (RG)</b> applicables aux attributs 
 * d'un CiviliteAbregee sont les suivantes :
 * </li>
 * <br/>
 * <table border="1">
 * <tr>
 * <th>Attribut</th><th>Règle de Gestion</th>
 * </tr>
 * 
 * <tr>
 * <td rowspan="1">
 * civiliteString
 * </td>
 * <td>
 * "RG_CIVILITEABREGEE_CIVILITESTRING_NOMENCLATURE_01 : 
 * la civilite (M., Mme, ...) doit respecter 
 * un ensemble fini de valeurs (nomenclature)"
 * </td>
 * </tr>
 * 
 * </table>
 * </ul>
 * 
 * <br/>
 * 
 *
 * - Exemple d'utilisation :<br/>
 * <code>//Instanciation d'un CiviliteAbregee en lui passant la String 
 * associée à l'abréviation de l'instance MONSIEUR de l'énumération.</code><br/>
 * <code>CiviliteAbregee CIVILITE_M = new 
 * CiviliteAbregee(CivilitesEnum.MONSIEUR.getAbreviationEnum());</code><br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * Enumération, utilisation d'une énumeration dans classe,<br/>
 * enumeration, utilisation enum, <br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author dan Lévy
 * @version 1.0
 * @since 9 déc. 2017
 *
 */
@Entity(name="CiviliteAbregee")
@Table(name="CIVILITES_ABREGEES", schema="PUBLIC")
@PrimaryKeyJoinColumn(name = "ID_CIVILITE"
, foreignKey=@ForeignKey(name="FK_CIVILITEABREGEE_ABSTRACTCIVILITE"))
public class CiviliteAbregee extends AbstractCivilite {

	// ************************ATTRIBUTS************************************/
	
	/**
	 * serialVersionUID : long :<br/>
	 * .<br/>
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	 * M : CiviliteAbregee :<br/>
	 * "M.".<br/>
	 */
	public static final CiviliteAbregee M 
		= new CiviliteAbregee(CivilitesEnum.MONSIEUR.getAbreviationEnum());

	
	/**
	 * MME : CiviliteAbregee :<br/>
	 * "Mme".<br/>
	 */
	public static final CiviliteAbregee MME 
		= new CiviliteAbregee(CivilitesEnum.MADAME.getAbreviationEnum());

	
	/**
	 * MLLE : CiviliteAbregee :<br/>
	 * "Mlle".<br/>
	 */
	public static final CiviliteAbregee MLLE 
		= new CiviliteAbregee(CivilitesEnum.MADEMOISELLE.getAbreviationEnum());


	/**
	 * valeursPossibles : List&lt;String&gt; :<br/>
	 * <ul>
	 * <li>Liste des valeurs possibles pour civiliteString 
	 * fournie par CivilitesEnum.</li>
	 * <li>M., Mme, Mlle.</li>
	 * </ul>
	 */
	private static List<String> valeursPossibles;
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(CiviliteAbregee.class);



	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR CiviliteAbregee() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public CiviliteAbregee() {
		this(null, null);
	} // Fin du CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	 * method CONSTRUCTEUR CiviliteAbregee(
	 * String pCiviliteString) :<br/>
	 * <ul>
	 * <li>CONSTRUCTEUR COMPLET.</li>
	 * <li>SANS ID en base.</li>
	 * </ul>
	 *
	 * @param pCiviliteString : String : 
	 * Civilité abrégée (M., Mme, ...).<br/>
	 */
	public CiviliteAbregee(
			final String pCiviliteString) {
		
		this(null, pCiviliteString);
		
	} // Fin du CONSTRUCTEUR COMPLET.______________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR CiviliteAbregee(
	 * Long pId
	 * , String pCiviliteString) :<br/>
	 * <ul>
	 * <li>CONSTRUCTEUR COMPLET BASE.</li>
	 * <li>AVEC ID en base.</li>
	 * </ul>
	 *
	 * @param pId : Long : ID en base.<br/>
	 * @param pCiviliteString : String : 
	 * Civilité abrégée (M., Mme, ...).<br/>
	 */
	public CiviliteAbregee(
			final Long pId
				, final String pCiviliteString) {
		
		super(pId, pCiviliteString);
		
	} // Fin de CONSTRUCTEUR COMPLET BASE._________________________________

	
	
	/**
	 * CONSTRUCTEUR TRANSFORMATEUR AVEC DTO.<br/>
	 * <b>instancie un objet métier à partir 
	 * d'un contenu de VUE (DTO)</b>.<br/>
	 * </ul>
	 *
	 * @param pDTO : ICiviliteDTO
	 */
	public CiviliteAbregee(
			final ICiviliteDTO pDTO) {
		
		super();
		
		if (pDTO != null) {
			
			final String idString = pDTO.getIdString();
			
			if (!StringUtils.isBlank(idString)) {
				this.id = Long.valueOf(idString);
			} else {
				this.id = null;
			}
			
			this.civiliteString = pDTO.getCiviliteString();
		}
		
	} // Fin de CONSTRUCTEUR TRANSFORMATEUR AVEC DTO.______________________
	
	
	
	 /**
	 * CONSTRUCTEUR TRANSFORMATEUR AVEC JPA.<br/>
	 * <b>instancie un objet métier à partir d'une Entity JPA</b>.<br/>
	 *
	 * @param pEntityJPA : CiviliteEntityJPA.<br/>
	 */
	public CiviliteAbregee(
			final CiviliteEntityJPA pEntityJPA) {
		
		super();
		
		if (pEntityJPA != null) {
			this.id = pEntityJPA.getId();
			this.civiliteString = pEntityJPA.getCiviliteString();
			
		}
		
	} // Fin de CONSTRUCTEUR TRANSFORMATEUR AVEC JPA.______________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String toString() {

		final StringBuilder builder = new StringBuilder();
		
		builder.append("CiviliteAbregee [");
		
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
	 * method getValeursPossibles() :<br/>
	 * <ul>
	 * <li>retourne la Liste des valeurs possibles pour civiliteString 
	 * fournie par CivilitesEnum.</li>
	 * <li>M., Mme, Mlle.</li>
	 * </ul>
	 *
	 * @return : List&lt;String&gt; : valeursPossibles.<br/>
	 */
	public static final List<String> getValeursPossibles() {
		
		synchronized (CiviliteComplete.class) {
			
			if (valeursPossibles == null) {
				
				valeursPossibles = new ArrayList<String>();
				
				final CivilitesEnum[] valeurs = CivilitesEnum.values();
				
				for (int i = 0; i < valeurs.length; i ++) {
					valeursPossibles.add(valeurs[i].getAbreviationEnum());
				}
				
			}
					
			return valeursPossibles;
			
		} // Fin de synchronized._________________________________
				
	} // Fin de getValeursPossibles()._____________________________________
	

	
} // FIN DE LA CLASSE CiviliteAbregee.---------------------------------------
