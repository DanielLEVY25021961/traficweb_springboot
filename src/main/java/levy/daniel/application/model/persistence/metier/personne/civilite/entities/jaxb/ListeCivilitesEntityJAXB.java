package levy.daniel.application.model.persistence.metier.personne.civilite.entities.jaxb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.personne.civilite.ICivilite;

/**
 * CLASSE ListeCivilitesEntityJAXB :<br/>
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
public class ListeCivilitesEntityJAXB {

	// ************************ATTRIBUTS************************************/

	/**
	 * Liste d'entities simulant une table dans un SGBDR.<br/>
	 */
	private List<CiviliteEntityJAXB> listeEntities;
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(ListeCivilitesEntityJAXB.class);

	// *************************METHODES************************************/
		
	 /**
	 * method CONSTRUCTEUR ContactsEntityJAXB() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public ListeCivilitesEntityJAXB() {
		this(null);
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	 /**
	 * CONSTRUCTEUR COMPLET.<br/>
	 * <br/>
	 *
	 * @param pListeEntities : List&lt;CiviliteEntityJAXB&gt;.<br/> 
	 */
	public ListeCivilitesEntityJAXB(
			final List<CiviliteEntityJAXB> pListeEntities) {
		
		super();
		
		this.listeEntities = pListeEntities;
		
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________
	

	
	/**
	 * method convertirListModelEnEntities(
	 * List&lt;ICivilite&gt; pList) :<br/>
	 * convertit une Liste d'Objets Metier en liste 
	 * d'Entities JAXB.<br/>
	 * <br/>
	 *
	 * @param pList : List&lt;ICivilite&gt;
	 * 
	 * @return : List&lt;CiviliteEntityJAXB&gt;.<br/>
	 */
	private List<CiviliteEntityJAXB> convertirListModelEnEntities(
			final List<ICivilite> pList) {
		
		if (pList == null) {
			return null;
		}
		
		final List<CiviliteEntityJAXB> resultat 
			= new ArrayList<CiviliteEntityJAXB>();
		
		for (final ICivilite objetMetier : pList) {
			
			if (objetMetier != null) {
				
				final CiviliteEntityJAXB entiteJAXB 
					= new CiviliteEntityJAXB(objetMetier);
				
				resultat.add(entiteJAXB);
				
			}
		}
		
		return resultat;
		
	} // Fin de convertirListModelEnEntities(...)._________________________



	/**
	 * Getter de la liste d'entités.<br/>
	 * <br/>
	 *
	 * @return this.listeEntities : List&lt;CiviliteEntityJAXB&gt;.<br/>
	 */
	// XmLElementWrapper generates a wrapper element around XML representation
	@XmlElementWrapper(name = "civilites")
    @XmlElement(name = "civilite")
	public List<CiviliteEntityJAXB> getListeEntities() {
		return this.listeEntities;
	} // Fin de getListeEntities().________________________________________



	/**
	* Setter de la liste d'entités.<br/>
	* <br/>
	*
	* @param pListeEntities : List&lt;CiviliteEntityJAXB&gt; : 
	* valeur à passer à this.listeEntities.<br/>
	*/
	public void setListeEntities(
			final List<CiviliteEntityJAXB> pListeEntities) {
		this.listeEntities = pListeEntities;
	} // Fin de setListeEntities(...)._____________________________________
	


} // FIN DE LA CLASSE ListeCivilitesEntityJAXB.------------------------------
