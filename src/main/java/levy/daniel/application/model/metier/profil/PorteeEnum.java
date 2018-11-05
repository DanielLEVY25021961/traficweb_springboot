package levy.daniel.application.model.metier.profil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ENUMERATION PorteeEnum :<br/>
 * <ul>
 * <li><b>Enumération</b> permettant de limiter les Gestionnaires 
 * (DARWIN, DIRA, DIRCE, ...) d'un Objet metier Gestionnaire 
 * (fournisseur de données trafic).</li>
 * <li>Le constructeur et les accesseurs permettent 
 * d'accéder aux <b>abréviations</b> des gestionnaires 
 * ("DARWIN" pour DARWIN, "A" pour DIRA, "CE" pour DIRCE, ...).</li>
 * <li>Le constructeur et les accesseurs permettent 
 * d'accéder aux <b>noms complets</b> des gestionnaires 
 * ("Réseau concédé" pour DARWIN, "DIR Atlantique" pour DIRA
 * , "DIR Centre-Est" pour DIRCE, ...).</li>
 * </ul>
 * <br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 * <br/>
 * <code>// Récupération d'une instance d'Enumeration.</code><br/>
 * <code><b>final PorteeEnum enumeration = PorteeEnum.DIRCO;</b></code><br/> 
 * <code>// Récupération du nom de l'instance d'enumeration par toString().</code><br/> 
 * <code><b>final String nomEnumeration = enumeration.toString();</b></code><br/> 
 * <code>// Récupération de l'abréviation de l'instance d'enumeration.</code><br/> 
 * <code><b>final String abrevEnumeration = enumeration.getAbreviation();</b></code><br/> 
 * <code>// Récupération du nom complet de l'instance d'enumeration.</code><br/> 
 * <code><b>final String nomCompletEnumeration = enumeration.getNomComplet();</b></code><br/>
 * <br/> 
 * <code>// Récupération de la liste d'instances d'Enumeration.</code><br/> 
 * <code><b>final List&lt;PorteeEnum&gt; listeInstances 
 * = PorteeEnum.fournirListeEnum();</b></code><br/> 
 * <code>// Récupération de la liste des noms des instances d'Enumeration.</code><br/> 
 * <code><b>final List&lt;String&gt; listeNomsInstances = PorteeEnum.fournirListeNomsEnum();</b></code><br/> 
 * <code>// Récupération de la liste des abréviations des instances d'Enumeration.</code><br/> 
 * <code><b>final List&lt;String&gt; listeAbrevsInstances = PorteeEnum.fournirListeAbrevsEnum();</b></code><br/> 
 * <code>// Récupération de la liste des noms complets des instances d'Enumeration.</code><br/> 
 * <code><b>final List<String> listeNomsCompletsInstances = PorteeEnum.fournirListeNomsCompletsEnum();</b></code><br/> 
 *<br/>
 * 
 * - Mots-clé :<br/>
 * Enumeration, enumeration, enumeration.toString(),<br/>
 * enumeration complexe, enumeration a plusieurs valeurs,<br/>
 * constructeur private, <br/>
 * Enumeration.values(), values,<br/>
 * Tableau en List, tableau en liste, Array.asLIst(...), <br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author dan Lévy
 * @version 1.0
 * @since 26 juin 2018
 *
 */
public enum PorteeEnum {
	
	/**
	 * TOUTRESEAU est l'<b>instance de PorteeEnum</b> 
	 * retournée par <b>PorteeEnum.TOUTRESEAU</b> 
	 * et <code>PorteeEnum.TOUTRESEAU.toString()</code> 
	 * retourne "TOUTRESEAU".<br/>
	 * "RRN" est l'<b>abréviation</b> de l'<b>instance</b> 
	 * de PorteeEnum TOUTRESEAU.<br/>
	 * "Ensemble du Réseau Routier National (RRN)" est 
	 * <b>le nom complet</b> de l'<b>instance</b> 
	 * de PorteeEnum TOUTRESEAU.<br/> 
	 */
	TOUTRESEAU("RRN", "Ensemble du Réseau Routier National (RRN)"),
	
	/**
	 * NONCONCEDE est l'<b>instance de PorteeEnum</b> 
	 * retournée par <b>PorteeEnum.NONCONCEDE</b> 
	 * et <code>PorteeEnum.NONCONCEDE.toString()</code> 
	 * retourne "NONCONCEDE".<br/>
	 * "Non Concédé" est l'<b>abréviation</b> de l'<b>instance</b> 
	 * de PorteeEnum NONCONCEDE.<br/>
	 * "Ensemble du Réseau Routier Non Concédé" est 
	 * <b>le nom complet</b> de l'<b>instance</b> 
	 * de PorteeEnum NONCONCEDE.<br/> 
	 */
	NONCONCEDE("Non Concédé", "Ensemble du Réseau Routier Non Concédé"),
	
	/**
	 * DARWIN est l'<b>instance de PorteeEnum</b> 
	 * retournée par <b>PorteeEnum.DARWIN</b> 
	 * et <code>PorteeEnum.DARWIN.toString()</code> 
	 * retourne "DARWIN".<br/>
	 * "DARWIN" est l'<b>abréviation</b> de l'<b>instance</b> 
	 * de PorteeEnum DARWIN.<br/>
	 * "Réseau concédé" est <b>le nom complet</b> de l'<b>instance</b> 
	 * de PorteeEnum DARWIN.<br/> 
	 */
	DARWIN("DARWIN", "Réseau concédé"),
	
	/**
	 * DIRA est l'<b>instance de PorteeEnum</b> 
	 * retournée par <b>PorteeEnum.DIRA</b> 
	 * et <code>PorteeEnum.DIRA.toString()</code> 
	 * retourne "DIRA".<br/>
	 * "A" est l'<b>abréviation</b> de l'<b>instance</b> 
	 * de PorteeEnum DIRA.<br/>
	 * "DIR Atlantique" est le <b>nom complet</b> de l'<b>instance</b> 
	 * de PorteeEnum DIRA.<br/> 
	 */
	DIRA("A", "DIR Atlantique"),
	
	/**
	 * DIRCE est l'<b>instance de PorteeEnum</b> 
	 * retournée par <b>PorteeEnum.DIRCE</b> 
	 * et <code>PorteeEnum.DIRCE.toString()</code> 
	 * retourne "DIRCE".<br/>
	 * "CE" est l'<b>abréviation</b> de l'<b>instance</b> 
	 * de PorteeEnum DIRCE.<br/>
	 * "DIR Centre-Est" est le <b>nom complet</b> de l'<b>instance</b> 
	 * de PorteeEnum DIRCE.<br/> 
	 */
	DIRCE("CE", "DIR Centre-Est"),
	
	/**
	 * DIRCO est l'<b>instance de PorteeEnum</b> 
	 * retournée par <b>PorteeEnum.DIRCO</b> 
	 * et <code>PorteeEnum.DIRCO.toString()</code> 
	 * retourne "DIRCO".<br/>
	 * "CO" est l'<b>abréviation</b> de l'<b>instance</b> 
	 * de PorteeEnum DIRCO.<br/>
	 * "DIR Centre-Ouest" est le <b>nom complet</b> de l'<b>instance</b> 
	 * de PorteeEnum DIRCO.<br/> 
	 */
	DIRCO("CO", "DIR Centre-Ouest"),
	
	/**
	 * DIRE est l'<b>instance de PorteeEnum</b> 
	 * retournée par <b>PorteeEnum.DIRE</b> 
	 * et <code>PorteeEnum.DIRE.toString()</code> 
	 * retourne "DIRE".<br/>
	 * "E" est l'<b>abréviation</b> de l'<b>instance</b> 
	 * de PorteeEnum DIRE.<br/>
	 * "DIR Est" est le <b>nom complet</b> de l'<b>instance</b> 
	 * de PorteeEnum DIRE.<br/> 
	 */
	DIRE("E", "DIR Est"),
	
	/**
	 * DIRIF est l'<b>instance de PorteeEnum</b> 
	 * retournée par <b>PorteeEnum.DIRIF</b> 
	 * et <code>PorteeEnum.DIRIF.toString()</code> 
	 * retourne "DIRIF".<br/>
	 * "IF" est l'<b>abréviation</b> de l'<b>instance</b> 
	 * de PorteeEnum DIRIF.<br/>
	 * "DIR Ile-de-France" est le <b>nom complet</b> de l'<b>instance</b> 
	 * de PorteeEnum DIRIF.<br/> 
	 */
	DIRIF("IF", "DIR Ile-de-France"),
	
	/**
	 * DIRMC est l'<b>instance de PorteeEnum</b> 
	 * retournée par <b>PorteeEnum.DIRMC</b> 
	 * et <code>PorteeEnum.DIRMC.toString()</code> 
	 * retourne "DIRMC".<br/>
	 * "MC" est l'<b>abréviation</b> de l'<b>instance</b> 
	 * de PorteeEnum DIRMC.<br/>
	 * "DIR Massif-Central" est le <b>nom complet</b> de l'<b>instance</b> 
	 * de PorteeEnum DIRMC.<br/> 
	 */
	DIRMC("MC", "DIR Massif-Central"),
	
	/**
	 * DIRMED est l'<b>instance de PorteeEnum</b> 
	 * retournée par <b>PorteeEnum.DIRMED</b> 
	 * et <code>PorteeEnum.DIRMED.toString()</code> 
	 * retourne "DIRMED".<br/>
	 * "MED" est l'<b>abréviation</b> de l'<b>instance</b> 
	 * de PorteeEnum DIRMED.<br/>
	 * "DIR Méditerrannée" est le <b>nom complet</b> de l'<b>instance</b> 
	 * de PorteeEnum DIRMED.<br/> 
	 */
	DIRMED("MED", "DIR Méditerrannée"),
	
	/**
	 * DIRN est l'<b>instance de PorteeEnum</b> 
	 * retournée par <b>PorteeEnum.DIRN</b> 
	 * et <code>PorteeEnum.DIRN.toString()</code> 
	 * retourne "DIRN".<br/>
	 * "N" est l'<b>abréviation</b> de l'<b>instance</b> 
	 * de PorteeEnum DIRN.<br/>
	 * "DIR Nord" est le <b>nom complet</b> de l'<b>instance</b> 
	 * de PorteeEnum DIRN.<br/> 
	 */
	DIRN("N", "DIR Nord"),
	
	/**
	 * DIRNO est l'<b>instance de PorteeEnum</b> 
	 * retournée par <b>PorteeEnum.DIRNO</b> 
	 * et <code>PorteeEnum.DIRNO.toString()</code> 
	 * retourne "DIRNO".<br/>
	 * "NO" est l'<b>abréviation</b> de l'<b>instance</b> 
	 * de PorteeEnum DIRNO.<br/>
	 * "DIR Nord-Ouest" est le <b>nom complet</b> de l'<b>instance</b> 
	 * de PorteeEnum DIRNO.<br/> 
	 */
	DIRNO("NO", "DIR Nord-Ouest"),
	
	/**
	 * DIRO est l'<b>instance de PorteeEnum</b> 
	 * retournée par <b>PorteeEnum.DIRO</b> 
	 * et <code>PorteeEnum.DIRO.toString()</code> 
	 * retourne "DIRO".<br/>
	 * "O" est l'<b>abréviation</b> de l'<b>instance</b> 
	 * de PorteeEnum DIRO.<br/>
	 * "DIR Ouest" est le <b>nom complet</b> de l'<b>instance</b> 
	 * de PorteeEnum DIRO.<br/> 
	 */
	DIRO("O", "DIR Ouest"),
	
	/**
	 * DIRSO est l'<b>instance de PorteeEnum</b> 
	 * retournée par <b>PorteeEnum.DIRSO</b> 
	 * et <code>PorteeEnum.DIRSO.toString()</code> 
	 * retourne "DIRSO".<br/>
	 * "SO" est l'<b>abréviation</b> de l'<b>instance</b> 
	 * de PorteeEnum DIRSO.<br/>
	 * "DIR Sud-Ouest" est le <b>nom complet</b> de l'<b>instance</b> 
	 * de PorteeEnum DIRSO.<br/> 
	 */
	DIRSO("SO", "DIR Sud-Ouest");
	
	
	
	/**
	 * <b>Abréviation</b> de l'instance de l'Enumération.<br/>
	 * Par exemple "A" pour DIRA, "CE" pour DIRCE.<br/>
	 */
	private String abreviation;

	
	/**
	 * <b>Nom complet</b> de l'instance de l'Enumération.<br/>
	 * Par exemple "DIR Atlantique" pour DIRA
	 * , "DIR Centre-Est" pour DIRCE.<br/>
	 */
	private String nomComplet;
	

		
	 /**
	 * CONSTRUCTEUR COMPLET.<br/>
	 * <ul>
	 * <li>prend en paramètres l'<b>abréviation</b> 
	 * et le <b>nom complet</b> d'une <b>instance</b> 
	 * de PorteeEnum.</li>
	 * <li>forcément <b>private</b> afin de préserver 
	 * les valeurs définies dans l'enum.</li>
	 * </ul>
	 *
	 * @param pAbreviation : String : 
	 * Abréviation de l'instance de l'Enumération.<br/>
	 * Par exemple "A" pour DIRA, "CE" pour DIRCE.<br/>
	 * @param pNomComplet : String : 
	 * Nom complet de l'instance de l'Enumération.<br/>
	 * Par exemple "DIR Atlantique" pour DIRA
	 * , "DIR Centre-Est" pour DIRCE.<br/>
	 */
	PorteeEnum(
			final String pAbreviation
				, final String pNomComplet) {
		
		this.abreviation = pAbreviation;
		this.nomComplet = pNomComplet;
		
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________


	
	/**
	 * retourne la liste des <b>instances de PorteeEnum</b> 
	 * déclarées dans la présente Enumeration 
	 * (DARWIN, DIRA, DIRCE, ...).<br/>
	 * <ul>
	 * <li>récupère le tableau des instances de PorteeEnum 
	 * avec <code>PorteeEnum.values()</code>.</li>
	 * <li>transforme le tableau en List avec 
	 * <code>Arrays.asList(...)</code>.</li>
	 * </ul>
	 *
	 * @return : List&lt;PorteeEnum&gt;.<br/>
	 */
	public static List<PorteeEnum> fournirListeEnum() {
		
		List<PorteeEnum> resultat = null;
		
		/* récupère le tableau des instances de PorteeEnum 
		 * avec PorteeEnum.values(). */
		final PorteeEnum[] valeursTableau = values();
		
		/* transforme le tableau en List 
		 * avec Arrays.asList(...). */
		resultat = Arrays.asList(valeursTableau);
				
		return resultat;
		
	} // Fin de fournirListeEnum().________________________________________
	
	
	
	/**
	 * retourne la liste des <b>noms des instances 
	 * de PorteeEnum</b> <code>(instance.toString())</code>
	 * déclarées dans la présente Enumeration 
	 * (DARWIN, DIRA, DIRCE, ...).<br/>
	 *
	 * @return : List&lt;String&gt;.<br/>
	 */
	public static List<String> fournirListeNomsEnum() {
		
		final List<String> resultat = new ArrayList<String>();
		
		final List<PorteeEnum> listeInstances = fournirListeEnum();
		
		for (final PorteeEnum instance : listeInstances) {
			resultat.add(instance.toString());
		}
		
		return resultat;
		
	} // Fin de fournirListeNomsEnum().____________________________________


	
	/**
	 * retourne la liste des <b>abréviations des instances 
	 * de PorteeEnum</b> <code>(instance.getAbreviation())</code>
	 * déclarées dans la présente Enumeration 
	 * (DARWIN, A, CE, ...).<br/>
	 *
	 * @return : List&lt;String&gt;.<br/>
	 */
	public static List<String> fournirListeAbrevsEnum() {
		
		final List<String> resultat = new ArrayList<String>();
		
		final List<PorteeEnum> listeInstances = fournirListeEnum();
		
		for (final PorteeEnum instance : listeInstances) {
			resultat.add(instance.getAbreviation());
		}
		
		return resultat;
		
	} // Fin de fournirListeAbrevsEnum().__________________________________


	
	/**
	 * retourne la liste des <b>noms complets des instances 
	 * de PorteeEnum</b> <code>(instance.getNomComplet())</code>
	 * déclarées dans la présente Enumeration 
	 * ("Réseau concédé", "DIR Atlantique", "DIR Centre-Est", ...).<br/>
	 *
	 * @return : List&lt;String&gt;.<br/>
	 */
	public static List<String> fournirListeNomsCompletsEnum() {
		
		final List<String> resultat = new ArrayList<String>();
		
		final List<PorteeEnum> listeInstances = fournirListeEnum();
		
		for (final PorteeEnum instance : listeInstances) {
			resultat.add(instance.getNomComplet());
		}
		
		return resultat;
		
	} // Fin de fournirListeNomsCompletsEnum().__________________________________

	
	
	/**
	 * Getter de l'<b>Abréviation</b> de l'instance de l'Enumération.<br/>
	 * Par exemple "A" pour DIRA, "CE" pour DIRCE.<br/>
	 * <br/>
	 *
	 * @return this.abreviation : String.<br/>
	 */
	public final String getAbreviation() {
		return this.abreviation;
	} // Fin de getAbreviation().__________________________________________


	
	/**
	* Setter de l'<b>Abréviation</b> de l'instance de l'Enumération.<br/>
	* Par exemple "A" pour DIRA, "CE" pour DIRCE.<br/>
	* <br/>
	*
	* @param pAbreviation : String : 
	* valeur à passer à this.abreviation.<br/>
	*/
	public final void setAbreviation(
			final String pAbreviation) {
		this.abreviation = pAbreviation;
	} // Fin de setAbreviation(...)._______________________________________


	
	/**
	 * Getter du <b>Nom complet</b> de l'instance de l'Enumération.<br/>
	 * Par exemple "DIR Atlantique" pour DIRA
	 * , "DIR Centre-Est" pour DIRCE.<br/>
	 * <br/>
	 *
	 * @return this.nomComplet : String.<br/>
	 */
	public final String getNomComplet() {
		return this.nomComplet;
	} // Fin de getNomComplet().___________________________________________


	
	/**
	* Getter du <b>Nom complet</b> de l'instance de l'Enumération.<br/>
	* Par exemple "DIR Atlantique" pour DIRA
	* , "DIR Centre-Est" pour DIRCE.<br/>
	*
	* @param pNomComplet : String : 
	* valeur à passer à this.nomComplet.<br/>
	*/
	public final void setNomComplet(
			final String pNomComplet) {
		this.nomComplet = pNomComplet;
	} // Fin de setNomComplet(...).________________________________________
	
	
		
} // FIN DE L'ENUMERATION PorteeEnum.---------------------------------
