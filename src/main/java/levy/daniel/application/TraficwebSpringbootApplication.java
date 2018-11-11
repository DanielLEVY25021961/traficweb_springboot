package levy.daniel.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import levy.daniel.application.model.metier.country.impl.Country;
import levy.daniel.application.model.services.metier.country.jpaspring.ICountryService;

/**
 * CLASSE TraficwebSpringbootApplication :<br/>
 * LANCEUR SPRING BOOT.<br/>
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
public class TraficwebSpringbootApplication implements CommandLineRunner { // NOPMD by dan on 04/11/18 09:53
	
	/**
	 * SERVICE pour les Country.<br/>
	 */
	@Autowired
	@Qualifier("CountryServiceJPASpring")
	private transient ICountryService countryService;
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.
	 */
	public TraficwebSpringbootApplication() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________

	
	
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
	} // Fin de main(...)._________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run(
			final String... pArgs) throws Exception {
		
		this.countryService.create(new Country("France", "Paris"));
		this.countryService.create(new Country("Inde", "New Delhi"));
		this.countryService.create(new Country("Angleterre", "Londres"));
		this.countryService.create(new Country("Etats-Unis", "Washington"));
		
	} // Fin de run(...).__________________________________________________

	
	
} // FIN DE LA CLASSE TraficwebSpringbootApplication.------------------------
