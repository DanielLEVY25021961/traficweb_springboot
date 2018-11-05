package levy.daniel.application.model.metier.internaute;

import java.io.Serializable;
import java.util.List;

import levy.daniel.application.model.metier.IExportateurCsv;
import levy.daniel.application.model.metier.IExportateurJTable;
import levy.daniel.application.model.metier.profil.IProfil;


/**
 * INTERFACE IInternaute :<br/>
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
 * @author dan Lévy
 * @version 1.0
 * @since 4 nov. 2018
 *
 */
public interface IInternaute 
					extends IExportateurCsv, IExportateurJTable
						, Comparable<IInternaute>, Cloneable, Serializable {

	/**
	 * ", ".<br/>
	 */
	String VIRGULE_ESPACE = ", ";

	/**
	 * "null".<br/>
	 */
	String NULL = "null";

	/**
	 * " - ".<br/>
	 */
	String TIRET_ESPACE = " - ";

	/**
	 * POINT_VIRGULE : char :<br/>
	 * ';'.<br/>
	 */
	char POINT_VIRGULE = ';';

	/**
	 * SEPARATEUR_MOINS_AERE : String :<br/>
	 * " - ".<br/>
	 */
	String SEPARATEUR_MOINS_AERE = " - ";

	/**
	 * UNDERSCORE : String :<br/>
	 * "_".<br/>
	 */
	String UNDERSCORE = "_";
		
	/**
	 * saut de ligne de la plateforme.<br/>
	 */
	String SAUT_DE_LIGNE = System.lineSeparator();



	/**
	 * {@inheritDoc}
	 */
	@Override
	int hashCode();



	/**
	 * {@inheritDoc}
	 */
	@Override
	boolean equals(Object pObject);



	/**
	 * method compareTo(
	 * IInternaute pObject) :<br/>
	 * <ol>
	 * Comparaison de 2 IInternaute par rapport à :
	 * <li>login.</li>
	 * <li>password.</li>
	 * </ol>
	 *
	 * @param pObject : IInternaute.<br/>
	 * 
	 * @return : int : négatif si la présente instance 
	 * est "avant" pObject.<br/>
	 */
	@Override
	int compareTo(IInternaute pObject);



	/**
	 * method clone() :<br/>
	 * Clone un IInternaute.<br/>
	 * <br/>
	 *
	 * @return IInternaute : clone.<br/>
	 * 
	 * @throws CloneNotSupportedException
	 */
	IInternaute clone() throws CloneNotSupportedException;



	/**
	 * {@inheritDoc}
	 */
	@Override
	String toString();


	
	/**
	 * {@inheritDoc}
	 * <br/>
	 * <b>en-tête csv pour un IInternaute</b> :<br/>
	 * "id;prenom;nom;login;password;profil principal;".<br/>
	 * <br/>
	 */
	@Override
	String getEnTeteCsv();



	/**
	 * {@inheritDoc}
	 * <br/>
	 * <b>ligne csv pour un IInternaute</b> :<br/>
	 * "id;prenom;nom;login;password;profil principal;".<br/>
	 * <br/>
	 */
	@Override
	String toStringCsv();



	/**
	 * {@inheritDoc}
	 * <br/>
	 * <b>en-tête Jtable pour un IInternaute</b> :<br/>
	 * "id;prenom;nom;login;password;profil principal;".<br/>
	 * <br/>
	 */
	@Override
	String getEnTeteColonne(int pI);



	/**
	 * {@inheritDoc}
	 * <br/>
	 * <b>ligne Jtable pour un IInternaute</b> :<br/>
	 * "id;prenom;nom;login;password;profil principal;".<br/>
	 * <br/>
	 */
	@Override
	Object getValeurColonne(int pI);


	
	/**
	 * Ajoute un profil à this.profils.<br/>
	 * <ul>
	 * <li>Ne fait rien si this.profils == null.</li>
	 * </ul>
	 *
	 * @param pProfil : IProfil.<br/>
	 * 
	 * @return : boolean : true si le profil a bien été ajouté.<br/>
	 */
	boolean ajouterProfil(IProfil pProfil);
	

	
	/**
	 * Retire un profil à this.profils.<br/>
	 * <ul>
	 * <li>Ne fait rien si this.profils == null.</li>
	 * </ul>
	 *
	 * @param pProfil : IProfil.<br/>
	 * 
	 * @return : boolean : true si le profil a bien été retiré.<br/>
	 */
	boolean retirerProfil(IProfil pProfil);
	

	
	/**
	 * retourne uune String pour l'affichage de la liste des profils 
	 * de l'internaute sur la console.<br/>
	 * <ul>
	 * <li>retourne "null" si this.profils == null.</li>
	 * </ul>
	 *
	 * @return : String : 
	 * affichage de la liste des profils de l'internaute.<br/>
	 */
	String listerProfils();
	
	
	
	/**
	 * Getter de l'identifiant en base.<br/>
	 * <br/>
	 *
	 * @return this.id : Long.<br/>
	 */
	Long getId();



	/**
	* Setter de l'identifiant en base.<br/>
	* <br/>
	*
	* @param pId : Long : 
	* valeur à passer à this.id.<br/>
	*/
	void setId(Long pId);



	/**
	 * Getter du prénom de l'internaute.<br/>
	 * <br/>
	 *
	 * @return this.prenom : String.<br/>
	 */
	String getPrenom();



	/**
	* Setter du prénom de l'internaute.<br/>
	* <br/>
	*
	* @param pPrenom : String : 
	* valeur à passer à this.prenom.<br/>
	*/
	void setPrenom(String pPrenom);



	/**
	 * Getter du nom de l'internaute.<br/>
	 * <br/>
	 *
	 * @return this.nom : String.<br/>
	 */
	String getNom();



	/**
	* Setter du nom de l'internaute.<br/>
	* <br/>
	*
	* @param pNom : String : 
	* valeur à passer à this.nom.<br/>
	*/
	void setNom(String pNom);



	/**
	 * Getter du login de l'internaute.<br/>
	 * <br/>
	 *
	 * @return this.login : String.<br/>
	 */
	String getLogin();



	/**
	* Setter du login de l'internaute.<br/>
	* <br/>
	*
	* @param pLogin : String : 
	* valeur à passer à this.login.<br/>
	*/
	void setLogin(String pLogin);



	/**
	 * Getter du mot de passe de l'internaute.<br/>
	 * <br/>
	 *
	 * @return this.password : String.<br/>
	 */
	String getPassword();



	/**
	* Setter du mot de passe de l'internaute.<br/>
	* <br/>
	*
	* @param pPassword : String : 
	* valeur à passer à this.password.<br/>
	*/
	void setPassword(String pPassword);



	/**
	 * Getter des profils (ADMINISTRATEUR, CONSULTANT, ...) 
	 * de l'internaute.<br/>
	 * <ul>
	 * <li>le profil PRINCIPAL de l'internaute doit être 
	 * inséré en premier dans la liste.</li>
	 * </ul>
	 *
	 * @return this.profils : List&lt;IProfil&gt;.<br/>
	 */
	List<IProfil> getProfils();



	/**
	* Setter des profils (ADMINISTRATEUR, CONSULTANT, ...) 
	* de l'internaute.<br/>
	* <ul>
	* <li>le profil PRINCIPAL de l'internaute doit être 
	* inséré en premier dans la liste.</li>
	* </ul>
	*
	* @param pProfils : List&lt;IProfil&gt; : 
	* valeur à passer à this.profils.<br/>
	*/
	void setProfils(List<IProfil> pProfils);
	
	
	
} // FIN DE L'INTERFACE IInternaute.-----------------------------------------
