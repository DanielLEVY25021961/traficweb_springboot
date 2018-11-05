package levy.daniel.application.controllers.web.accueil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * CLASSE AccueilController :<br/>
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
@Controller
public class AccueilController {
	// ************************ATTRIBUTS************************************/

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(AccueilController.class);
	// *************************METHODES************************************/
	
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public AccueilController() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.._______________________________
	

	
	/**
	 * .<br/>
	 * <ul>
	 * <li>.</li>
	 * </ul>
	 * @param pName 
	 * @param pModelMap 
	 *
	 * @return :  :  .<br/>
	 */
	@GetMapping("/")
	public String allerVersPageAccueil(
			@RequestParam(required=false, defaultValue="nom de substitution") final String pName
				, final ModelMap pModelMap) {
		
		pModelMap.put("name", pName);
		
		return "vues/accueil/accueil.html";
	}
	
	
} // FIN DE CLASSE AccueilController.----------------------------------------
