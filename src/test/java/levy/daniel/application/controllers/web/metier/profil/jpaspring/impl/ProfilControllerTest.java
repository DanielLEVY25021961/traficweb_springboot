package levy.daniel.application.controllers.web.metier.profil.jpaspring.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import levy.daniel.application.controllers.web.metier.profil.jpaspring.IProfilController;
import levy.daniel.application.model.dto.metier.profil.impl.ProfilDTO;
import levy.daniel.application.model.metier.profil.IProfil;
import levy.daniel.application.model.metier.profil.PorteeEnum;
import levy.daniel.application.model.metier.profil.ProfilEnum;
import levy.daniel.application.model.metier.profil.impl.Profil;


/**
 * CLASSE ProfilControllerTest :<br/>
 * Test JUnit de la classe ProfilController.<br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * Test Spring, Test JUnit Spring, SPRING, TEST CONTROLLER SPRING,<br/>
 * fabriquer liste à partir d'un Iterable,<br/>
 * Test Controller, test CONTROLLER, Test persistence avec SPRING BOOT,<br/> 
 * UTILISER LES ANNOTATIONS RunWith(SpringRunner.class), SpringBootTest 
 * et ComponentScan("levy.daniel.application").<br/>
 * ComponentScan("levy.daniel.application") est ESSENTIEL sinon SPRING BOOT 
 * ne résoud pas les dépendances et ne trouve pas 
 * les Beans lors des tests JUnit.<br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author dan Lévy
 * @version 1.0
 * @since 9 nov. 2018
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProfilControllerTest {
	
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
	 * "CONTENU DU STOCKAGE : ".<br/>
	 */
	public static final String CONTENU_STOCKAGE_SIMPLE 
		= "CONTENU DU STOCKAGE : ";
	
	/**
	 * "CONTENU DU STOCKAGE : '".<br/>
	 */
	public static final String CONTENU_STOCKAGE 
		= "CONTENU DU STOCKAGE : '";
		
	/**
	 * "'\n".<br/>
	 */
	public static final String SAUT_APO = "'\n";
	
	/**
	 * "NOMBRE D'ENREGISTREMENTS DANS LE STOCKAGE : ".<br/>
	 */
	public static final String NOMBRE_ENREGISTREMENTS 
		= "NOMBRE D'ENREGISTREMENTS DANS LE STOCKAGE : ";
	
	/**
	 * "Le stockage doit contenir 1 enregistrement : ".<br/>
	 */
	public static final String STOCKAGE_CONTIENT_1_ENREGISTREMENT 
		= "Le stockage doit contenir 1 enregistrement : ";
	
	/**
	 * "Le stockage doit contenir 3 enregistrements : ".<br/>
	 */
	public static final String STOCKAGE_CONTIENT_3_ENEGISTREMENTS 
		= "Le stockage doit contenir 3 enregistrements : ";

	
		
	/**
	 * objet1 métier (vu comme son Interface) 
	 * valable et différent de objet2 et objet3.<br/>
	 */
	private transient IProfil objet1; 
	
	/**
	 * DTO <b>concret</b> de l'objet1.<br/>
	 * objet 1 est valable et différent de objet2 et objet3.<br/>
	 */
	private transient ProfilDTO objet1DTO;
	
	/**
	 * objet2 métier (vu comme son Interface) 
	 * valable et différent de objet1 et objet3.<br/>
	 */
	private transient IProfil objet2;
	
	/**
	 * DTO <b>concret</b> de l'objet2.<br/>
	 * objet 2 est valable et différent de objet1 et objet3.<br/>
	 */
	private transient ProfilDTO objet2DTO;
	
	/**
	 * objet3 métier (vu comme son Interface) 
	 * valable et différent de objet1 et objet2.
	 */
	private transient IProfil objet3;
	
	/**
	 * DTO <b>concret</b> de l'objet3.<br/>
	 * objet 3 est valable et différent de objet1 et objet2.<br/>
	 */
	private transient ProfilDTO objet3DTO;
	

	/**
	 * CONTROLLER à tester.<br/>
	 */
	@Autowired
	private transient IProfilController profilController;
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
	= LogFactory.getLog(ProfilControllerTest.class);

	// *************************METHODES************************************/
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public ProfilControllerTest() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

	/**
	 * <b>teste la méthode create(...)</b>.<br/>
	 * <ul>
	 * <li>vide le stockage (TABLE SGBDR JPA) en début de test.</li>
	 * <li>enregistre un objet dans le stockage (TABLE SGBDR JPA).</li>
	 * <li>garantit que create(...) retourne une 
	 * instance persistée (avec ID).</li>
	 * <li>garantit que l'instance persistée est 
	 * equals à l'objet métier.</li>
	 * <li></li>
	 * <li></li>
	 * </ul>
	 * @throws Exception 
	 */
	@Test
	public void testCreate() throws Exception {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON		
		final boolean affichage = true;
		// **********************************	
				
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("********** CLASSE ProfilControllerTest - méthode testCreate() ********** ");
		}

		
		/* VIDAGE DU STOCKAGE (TABLE SGBDR JPA). */
		this.profilController.deleteAll();
		
		/* garantit que le stockage (TABLE SGBDR JPA) est vide. */
		final List<IProfil> listeEnregistrements 
			= this.profilController.findAll();
		
		assertTrue(
				"le stockage doit être vide : "
					, listeEnregistrements.isEmpty());
		
		
		// *************************************************************
		/* enregistrement d'un objet dans le stockage (TABLE SGBDR JPA). */
		final IProfil objetPersiste = this.profilController.create(this.objet1DTO);
		// *************************************************************
		
				
		/* garantit que create() retourne une instance persistée. */
		assertNotNull(
				"create(...) doit retourner une instance persistée : "
					, objetPersiste);
		
		assertNotNull("l'ID de l'objet persisté par create(...) ne doit pas être null : "
				, objetPersiste.getId());
		
		/* garantit que l'instance persistée est equals à l'objet métier. */
		assertEquals(
				"create(...) doit retourner une instance persistée equals à this.objet1 : "
					, this.objet1 
						, objetPersiste);
		
		System.out.println();
		System.out.println("================================================");
		System.out.println("OBJET PERSISTE : " + objetPersiste.toString());
		System.out.println("================================================");
		System.out.println();
		
		final Long nombreInitial = this.profilController.count();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println(CONTENU_STOCKAGE_SIMPLE + '\n');
			this.profilController.ecrireStockageDansConsole();
			System.out.println();
			System.out.println(NOMBRE_ENREGISTREMENTS + nombreInitial);
			System.out.println();
		}
		
		/* garantit que create() insère un enregistrement dans le stockage. */
		assertEquals(STOCKAGE_CONTIENT_1_ENREGISTREMENT
				, (Long) 1L
					, nombreInitial);
		
		// ******************************************************************
		/* enregistrement d'un DOUBLON dans le stockage (TABLE SGBDR JPA). */
		final IProfil doublon = this.profilController.create(this.objet1DTO);
		// ******************************************************************
		
		final Long nombreApresDoublon = this.profilController.count();
		
		/* garantit que create(Doublon) retourne null. */
		assertNull(
				"create(Doublon) doit retourner null : "
					, doublon);
		
		/* garantit que create(Doublon) ne crée pas de doublon. */
		assertEquals(STOCKAGE_CONTIENT_1_ENREGISTREMENT
				, (Long) 1L
					, nombreApresDoublon);
		
		/* garantit que create(null) retourne null. */
		assertNull(
				"create(null) doit retourner null : "
					, this.profilController.create(null));
		
	} // Fin de testCreate().______________________________________________


	

	/**
	 * Méthode exécutée <b>avant chaque test</b>.<br/>
	 *
	 * @throws Exception
	 */
	@Before
	public void before() throws Exception {
		
		this.objet1 = new Profil(
				ProfilEnum.ADMINISTRATEUR.toString()
					, PorteeEnum.TOUTRESEAU.toString()
						, null);
		
		this.objet1DTO = new ProfilDTO(this.objet1);
		
		this.objet2 = null;
		
		this.objet3 = null;
		
	} // Fin de before().__________________________________________________


	
	
} // FIN DE LA CLASSE ProfilControllerTest.----------------------------------
