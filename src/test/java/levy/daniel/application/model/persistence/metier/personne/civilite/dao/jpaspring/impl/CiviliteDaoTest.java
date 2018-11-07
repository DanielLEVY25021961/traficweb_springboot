package levy.daniel.application.model.persistence.metier.personne.civilite.dao.jpaspring.impl;

import static org.junit.Assert.assertTrue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import levy.daniel.application.model.metier.personne.civilite.ICivilite;
import levy.daniel.application.model.metier.personne.civilite.impl.CiviliteAbregee;
import levy.daniel.application.model.metier.personne.civilite.impl.CiviliteComplete;
import levy.daniel.application.model.metier.personne.civilite.impl.CivilitesEnum;
import levy.daniel.application.model.persistence.AbstractTestDaoGenericJPASpring;
import levy.daniel.application.model.persistence.metier.personne.civilite.dao.jpaspring.ICiviliteDao;

/**
 * CLASSE CiviliteDaoTest :<br/>
 * Test JUnit du DAO CiviliteDao SPRING JPA.<br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * Test Spring, Test JUnit Spring, SPRING, TEST DAO SPRING,<br/>
 * Test SPRING BOOT JPA,<br/>
 * fabriquer liste à partir d'un Iterable,<br/>
 * Test Dao, test DAO, Test persistence avec SPRING BOOT,<br/> 
 * UTILISER LES ANNOTATIONS RunWith(SpringRunner.class), DataJpaTest 
 * et ComponentScan("levy.daniel.application").<br/>
 * ComponentScan("levy.daniel.application") est ESSENTIEL sinon SPRING BOOT 
 * ne résoud pas les dépendances et ne trouve pas 
 * les Beans lors des tests JUnit.<br/>
 * <br/>
 * 
 * - Dépendances :<br/>
 * <br/>
 *
 * @author daniel.levy Lévy
 * @version 1.0
 * @since 7 nov. 2018
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan("levy.daniel.application")
public class CiviliteDaoTest 
	extends AbstractTestDaoGenericJPASpring<ICivilite, Long> {

	// ************************ATTRIBUTS************************************/
	
	/**
	 * AFFICHAGE_GENERAL : Boolean :<br/>
	 * Boolean qui commande l'affichage pour tous les tests.<br/>
	 */
	public static final Boolean AFFICHAGE_GENERAL = true;


 
    /**
     * DAO à tester injecté par SPRING BOOT.<br/>
     */
    @Autowired(required=true)
    @Qualifier("CiviliteDaoJpaSpring")
    private transient ICiviliteDao civiliteDaoSpringJPA;

    
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(CiviliteDaoTest.class);

       
	// *************************METHODES************************************/

	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public CiviliteDaoTest() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

	
	/**
	 * {@inheritDoc}
	 * @throws Exception 
	 */
	@Override
	@Test
	public void testCreate() throws Exception {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON		
		final boolean affichage = true;
		// **********************************	
				
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println();
			System.out.println("********** CLASSE CiviliteDaoTest - méthode testCreate() ********** ");
			System.out.println();
		}
		
		// APPEL DE LA SUPER METHODE
		super.testCreate(AFFICHAGE_GENERAL, affichage);
		
		assertTrue("BIDON : ", 1 == 1);
		
	} // Fin de testCreate().______________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Before
	@Override
	public void before() throws Exception {
		
		this.objet1 = new CiviliteAbregee(CivilitesEnum.MADEMOISELLE.getAbreviationEnum());
		
		this.objet2 = new CiviliteComplete(CivilitesEnum.MADAME.toString());
		
		this.objet3 = new CiviliteAbregee(CivilitesEnum.MONSIEUR.getAbreviationEnum());
		
		this.daoATester = this.civiliteDaoSpringJPA;
		
	} // Fin de before().__________________________________________________

	

}
