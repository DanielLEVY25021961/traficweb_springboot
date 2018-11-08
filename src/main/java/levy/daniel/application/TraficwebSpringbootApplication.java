package levy.daniel.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * CLASSE TraficwebSpringbootApplication :<br/>
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
 * @since 3 nov. 2018
 *
 */
@SpringBootApplication
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class TraficwebSpringbootApplication { // NOPMD by dan on 04/11/18 09:53
	
	
	 /**
	 * .<br/>
	 * <br/>
	 *
	 */
	public TraficwebSpringbootApplication() {
		super();
	}

	
	
	/**
	 * .<br/>
	 * <ul>
	 * <li>.</li>
	 * </ul>
	 *
	 * @param pArgs :  :  .<br/>
	 */
	public static void main(
			final String[] pArgs) {
		SpringApplication.run(TraficwebSpringbootApplication.class, pArgs);
	}
	
}
