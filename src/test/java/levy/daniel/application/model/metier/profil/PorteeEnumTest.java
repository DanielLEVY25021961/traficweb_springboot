package levy.daniel.application.model.metier.profil;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;


/**
 * CLASSE PorteeEnumTest :<br/>
 * Test JUnit de l'Enumération PorteeEnum.<br/>
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
public class PorteeEnumTest {
	
	// ************************ATTRIBUTS************************************/
	
	/**
	 * AFFICHAGE_GENERAL : Boolean :<br/>
	 * Boolean qui commande l'affichage pour tous les tests.<br/>
	 */
	public static final Boolean AFFICHAGE_GENERAL = true;
	
	/**
	 * "unused".<br/>
	 */
	public static final String UNUSED = "unused";
	
	/**
	 * SAUT_LIGNE_JAVA : char :<br/>
	 * '\n'.<br/>
	 */
	public static final char SAUT_LIGNE_JAVA = '\n';


	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(PorteeEnumTest.class);


	// *************************METHODES************************************/
	
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public PorteeEnumTest() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	 * Teste l'énumération PorteeEnumTest.<br/>
	 * <ul>
	 * <li>garantit que le nom de l'énumération (toString()) est bon.</li>
	 * <li>garantit que getAbreviation() retourne la bonne valeur.</li>
	 * <li>garantit que getNomComplet() retourne la bonne valeur.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testEnum() throws Exception {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE PorteeEnumTest - méthode testEnum() ********** ");
		}
		
		/* Récupération de l'instance d'Enumeration. */
		final PorteeEnum enumeration = PorteeEnum.DIRCO;
		
		final String nomEnumeration = enumeration.toString();
		final String abrevEnumeration = enumeration.getAbreviation();
		final String nomCompletEnumeration = enumeration.getNomComplet();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("Nom de l'Enumeration (toString()) : " + nomEnumeration);
			System.out.println("Abréviation de l'énumération (getAbreviation()) : " + abrevEnumeration);
			System.out.println("Nom complet de l'énumération (getNomComplet()) : " + nomCompletEnumeration);
		}

		/* garantit que le nom de l'énumération est bon. */
		assertEquals("toString() doit retourner DIRCO : "
				, "DIRCO", nomEnumeration);
		
		/* garantit que getAbreviation() retourne la bonne valeur. */
		assertEquals("getAbreviation() doit retourner CO : "
				, "CO", abrevEnumeration);
		
		/* garantit que getNomComplet() retourne la bonne valeur. */
		assertEquals("getNomComplet() doit retourner DIR Centre-Ouest : "
				, "DIR Centre-Ouest", nomCompletEnumeration);
		
	} // Fin de testEnum().________________________________________________
	

	
	/**
	 * Teste l'énumération PorteeEnum.<br/>
	 * <ul>
	 * <li>garantit que fournirListeEnum() 
	 * retourne la liste des instances.</li>
	 * <li>garantit que fournirListeNomsEnum() 
	 * retourne la liste des noms des instances.</li>
	 * <li>garantit que fournirListeAbrevsEnum() 
	 * retourne la liste des abréviations des instances.</li>
	 * <li>garantit que fournirListeNomsCompletsEnum() 
	 * retourne la liste des noms complets des instances.</li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	@SuppressWarnings(UNUSED)
	@Test
	public void testEnumCollection() throws Exception {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE PorteeEnumTest - méthode testEnumCollection() ********** ");
		}

		
		/* Récupération de la liste d'instances d'Enumeration. */
		final List<PorteeEnum> listeInstances 
			= PorteeEnum.fournirListeEnum();
		
		/* Récupération de la liste des noms des instances d'Enumeration. */
		final List<String> listeNomsInstances 
			= PorteeEnum.fournirListeNomsEnum();
		
		/* Récupération de la liste des abréviations des instances d'Enumeration. */
		final List<String> listeAbrevsInstances 
			= PorteeEnum.fournirListeAbrevsEnum();
		
		/* Récupération de la liste des noms complets des instances d'Enumeration. */
		final List<String> listeNomsCompletsInstances = PorteeEnum.fournirListeNomsCompletsEnum();

		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			
			System.out.println("Liste des INSTANCES : ");
			for (final PorteeEnum gestionnaire : listeInstances) {
				System.out.println(gestionnaire.toString());
			}
			
			System.out.println();
			System.out.println("Liste des NOMS DES INSTANCES : ");
			System.out.println(this.afficherListeString(listeNomsInstances));
			
			System.out.println();
			System.out.println("Liste des ABREVIATIONS DES INSTANCES : ");
			System.out.println(this.afficherListeString(listeAbrevsInstances));
			
			System.out.println();
			System.out.println("Liste des NOMS COMPLETS DES INSTANCES : ");
			System.out.println(this.afficherListeString(listeNomsCompletsInstances));
			
		}
		
		/* garantit que fournirListeEnum() 
		 * retourne la liste des instances. */
		assertNotNull(
				"listeInstances ne doit pas être null : "
					, listeInstances);
		
		/* garantit que fournirListeNomsEnum() 
		 * retourne la liste des noms des instances .*/
		assertNotNull(
				"listeNomsInstances ne doit pas être null : "
					, listeNomsInstances);
		
		/* garantit que fournirListeAbrevsEnum() 
		 * retourne la liste des abréviations des instances. */
		assertNotNull(
				"listeAbrevsInstances ne doit pas être null : "
					, listeAbrevsInstances);
		
		/* garantit que fournirListeNomsCompletsEnum() 
		 * retourne la liste des noms complets des instances. */
		assertNotNull(
				"listeNomsCompletsInstances ne doit pas être null : "
					, listeNomsCompletsInstances);
		
	} // Fin de testEnumCollection().______________________________________
	
	
	
	
	/**
	 * Fournit une String pour l'affichage 
	 * d'une List&lt;String&gt;.<br/>
	 * <br/>
	 * - retourne null si pList == null.<br/>
	 * <br/>
	 *
	 * @param pList : List&lt;String&gt;
	 * 
	 * @return : String.<br/>
	 */
	public String afficherListeString(
			final List<String> pList) {
		
		/* retourne null si pList == null. */
		if (pList == null) {
			return null;
		}
		
		final StringBuffer stb = new StringBuffer();
		
		for (final String ligne : pList) {
			stb.append(ligne);
			stb.append(SAUT_LIGNE_JAVA);
		}
		
		return stb.toString();
		
	} // Fin de afficherListeString(...).__________________________________
	

		
} // FIN DE LA CLASSE PorteeEnumTest.----------------------------------------
