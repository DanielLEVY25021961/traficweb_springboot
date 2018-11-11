package levy.daniel.application.controllers.web.accueil;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import levy.daniel.application.controllers.web.accueil.springmvc.AccueilController;


/**
 * CLASSE AccueilControllerTest :<br/>
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
@RunWith(SpringRunner.class)
@WebMvcTest(AccueilController.class)
public class AccueilControllerTest {
	// ************************ATTRIBUTS************************************/

	/**
	 * .<br/>
	 */
	@Autowired
	private transient MockMvc mockMvc;
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(AccueilControllerTest.class);

	// *************************METHODES************************************/

	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public AccueilControllerTest() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	 * teste la méthode allerVersPageAccueil().<br/>
	 * <ul>
	 * <li>.</li>
	 * </ul>
	 * @throws Exception 
	 */
	@Test
	public void testAllerVersPageAccueil() throws Exception {
		
		/* vérifie que l'URL context sans paramètre name retourne une page contenant "Hello Nom de substitution !"*/
		this.mockMvc.perform(get("/"))
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("Hello Nom de substitution !")));

		/* vérifie que l'URL context avec paramètre sans value name retourne une page contenant "Hello Nom de substitution !"*/
		this.mockMvc.perform(get("/?pName="))
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("Hello Nom de substitution !")));

		/* vérifie que l'URL context avec paramètre name retourne une page contenant "Hello Value !"*/
		this.mockMvc.perform(get("/?pName=zorro"))
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("Hello Zorro !")));

		assertTrue("BIDON : ", 1 == 1);
	}

} // FIN DE LA CLASSE AccueilControllerTest.---------------------------------
