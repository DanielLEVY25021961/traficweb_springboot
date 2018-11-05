package levy.daniel.application.model.metier.internaute.impl;

import static org.junit.Assert.fail;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.BeforeClass;
import org.junit.Test;

import levy.daniel.application.model.metier.internaute.IInternaute;
import levy.daniel.application.model.metier.profil.IProfil;
import levy.daniel.application.model.metier.profil.PorteeEnum;
import levy.daniel.application.model.metier.profil.ProfilEnum;
import levy.daniel.application.model.metier.profil.impl.ProfilCerbere;


/**
 * CLASSE InternauteTest :<br/>
 * Test JUnit de la classe Internaute.<br/>
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
public class InternauteTest {
	
	// ************************ATTRIBUTS************************************/
	
	/**
	 * Boolean qui commande l'affichage pour tous les tests.<br/>
	 */
	public static final Boolean AFFICHAGE_GENERAL = true;

	/**
	 * "unused".<br/>
	 */
	public static final String UNUSED = "unused";
	
	/**
	 * "objet1 : ".<br/>
	 */
	public static final String OBJET1 = "objet1 : ";
	
	/**
	 * "objetNull1 : ".<br/>
	 */
	public static final String OBJETNULL1 = "objetNull1 : ";
	
	/**
	 * "objet1.equals(objet2EqualsObj1) : ".<br/>
	 */
	public static final String OBJET1_EQUALS_OBJET2 
		= "objet1.equals(objet2EqualsObj1) : ";
	
	/**
	 * "avec".<br/>
	 */
	public static final String AVEC = "avec";

	/**
	 * .<br/>
	 */
	public static final List<IProfil> LISTE_PROFILS_ADMIN_SEUL;
	
	/**
	 * .<br/>
	 */
	public static final List<IProfil> LISTE_PROFILS_COMPLEXE;
	
	
	/**
	 * .<br/>
	 */
	public static final List<IProfil> LISTE_PROFILS_EXPLOITANT;
	
	
	/**
	 * .<br/>
	 */
	public static final List<IProfil> LISTE_PROFILS_CONSULTANT;
	
	/**
	 * objet1, objet2EqualsObj1, objet3EqualsObj1 doivent être equals().
	 */
	public static transient IInternaute objet1 
		= new Internaute(1L, "Zorro", "Halliday", "zorro.halliday", "12345", LISTE_PROFILS_ADMIN_SEUL);
	
	/**
	 * objet1MemeInstance doit être la même instance que objet1.<br/>
	 */
	public static transient IInternaute objet1MemeInstance = objet1;
	
	/**
	 * objet1, objet2EqualsObj1, objet3EqualsObj1 doivent être equals().
	 */
	public static transient IInternaute objet2EqualsObj1 
		= new Internaute(2L, "Papy", "Gonzalez", "zorro.halliday", "12345", LISTE_PROFILS_COMPLEXE);
	
	/**
	 * objet1, objet2EqualsObj1, objet3EqualsObj1 doivent être equals().
	 */
	public static transient IInternaute objet3EqualsObj1 
		= new Internaute(3L, "Papy", "Gonzalez", "zorro.halliday", "12345", LISTE_PROFILS_COMPLEXE);
	
	/**
	 * objetNull1 et objetNull2 doivent être instanciés 
	 * avec le constructeur d'arité nulle ou avoir 
	 * tous les attributs aux valeurs par défaut.
	 */
	public static transient IInternaute objetNull1 
		= new Internaute(7L, null, null, null, null, null);
	
	/**
	 * objetNull1 et objetNull2 doivent être instanciés 
	 * avec le constructeur d'arité nulle ou avoir 
	 * tous les attributs aux valeurs par défaut.
	 */
	public static transient IInternaute objetNull2 
		= new Internaute(8L, null, null, null, null, null);
	
	/**
	 * objet1AvecNull et objet2EqualsObjet1AvecNull 
	 * doivent être equals() et avoir certains attributs à null.
	 */
	public static transient IInternaute objet1AvecNull 
		= new Internaute(11L, "Papy", "Gonzalez", "zorro.halliday", null, LISTE_PROFILS_COMPLEXE);
	
	/**
	 * objet1AvecNull et objet2EqualsObjet1AvecNull 
	 * doivent être equals() et avoir certains attributs à null.
	 */
	public static transient IInternaute objet2EqualsObjet1AvecNull 
		= new Internaute(12L, "Papy", "Gonzalez", "zorro.halliday", null, LISTE_PROFILS_COMPLEXE);
	
	/**
	 * objetDiff1 doit être différent de objetDiff2
	 */
	public static transient IInternaute objetDiff1 
		= new Internaute(1L, ProfilEnum.ADMINISTRATEUR.toString(), PorteeEnum.TOUTRESEAU.toString(), null);
	
	/**
	 * objetDiff2 doit être différent de objetDiff1
	 */
	public static transient IInternaute objetDiff2 
		= new Internaute(2L, ProfilEnum.ADMINISTRATEUR.toString(), PorteeEnum.DARWIN.toString(), null);
	
	/**
	 * objetDiff1AvecNull doit être différent de objetDiff2AvecNull.<br/>
	 * objetDiff1AvecNull et objetDiff2AvecNull doivent avoir des attributs null.
	 */
	public static transient IInternaute objetDiff1AvecNull 
		= new Internaute(1L, ProfilEnum.ADMINISTRATEUR.toString(), null, "Savoie");
	
	/**
	 * objetDiff1AvecNull doit être différent de objetDiff2AvecNull.<br/>
	 * objetDiff1AvecNull et objetDiff2AvecNull doivent avoir des attributs null.
	 */
	public static transient IInternaute objetDiff2AvecNull 
		= new Internaute(1L, null, PorteeEnum.TOUTRESEAU.toString(), "Ardèche");
	
	/**
	 * objetCompAvant doit être AVANT objetCompApres.
	 */
	public static transient IInternaute objetCompAvant 
		= new Internaute(1L, ProfilEnum.ADMINISTRATEUR.toString(), PorteeEnum.DIRA.toString(), "Haute-Savoie");
	
	/**
	 * objetCompApres doit être APRES objetCompAvant.
	 */
	public static transient IInternaute objetCompApres 
		= new Internaute(1L, ProfilEnum.ADMINISTRATEUR.toString(), PorteeEnum.DIRCE.toString(), "Isère");
	
	/**
	 * clone de objetNull1.<br/>
	 */
	public static transient IInternaute objetNullClone1;
	
	/**
	 * clone de objet1.<br/>
	 */
	public static transient IInternaute objetClone1;



	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(InternauteTest.class);

	// *************************METHODES************************************/

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	
	/**
	 * method avantTests() :<br/>
	 * <ul>
	 * <li>instructions exécutées <b>avant l'ensemble des tests</b> 
	 * de la classe JUnit.</li>
	 * <li><b>A REMPLIR A LA MAIN</b></li>
	 * </ul>
	 * @throws CloneNotSupportedException 
	 */
	@BeforeClass
    public static void avantTests() throws CloneNotSupportedException {
		
		objetNullClone1 = objetNull1.clone();
		objetClone1 = objet1.clone();
		
		final IProfil profilAdmin 
			= new ProfilCerbere(
					1L
					, ProfilEnum.ADMINISTRATEUR.toString()
					, PorteeEnum.TOUTRESEAU.toString()
					, null);
		
		final IProfil profilCharge1 
			= new ProfilCerbere(
					2L
					, ProfilEnum.CHARGEETUDE.toString()
					, PorteeEnum.TOUTRESEAU.toString()
					, null);

		final IProfil profilCharge2 
			= new ProfilCerbere(
					3L
					, ProfilEnum.CHARGEETUDE.toString()
					, PorteeEnum.TOUTRESEAU.toString()
					, "Vosges");
		
		final IProfil profilExploitantDIRA 
			= new ProfilCerbere(
				4L
				, ProfilEnum.EXPLOITANT.toString()
				, PorteeEnum.DIRA.toString()
				, "Ouest");

		final IProfil profilExploitantDIRO 
			= new ProfilCerbere(
				5L
				, ProfilEnum.EXPLOITANT.toString()
				, PorteeEnum.DIRO.toString()
				, "Bretagne");

		final IProfil profilConsultant1 
			= new ProfilCerbere(
				5L
				, ProfilEnum.CONSULTANT.toString()
				, PorteeEnum.TOUTRESEAU.toString()
				, null);

		LISTE_PROFILS_ADMIN_SEUL.add(profilAdmin);
		
		LISTE_PROFILS_COMPLEXE.add(profilAdmin);
		LISTE_PROFILS_COMPLEXE.add(profilExploitantDIRA);
		LISTE_PROFILS_COMPLEXE.add(profilConsultant1);
		
		LISTE_PROFILS_CONSULTANT.add(profilConsultant1);
		
	} // Fin de avantTests().______________________________________________
	
	
	
} // FIN DE LA CLASSE InternauteTest.----------------------------------------
