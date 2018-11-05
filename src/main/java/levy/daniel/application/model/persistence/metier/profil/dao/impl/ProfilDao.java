package levy.daniel.application.model.persistence.metier.profil.dao.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import levy.daniel.application.model.metier.profil.PorteeEnum;
import levy.daniel.application.model.metier.profil.ProfilEnum;
import levy.daniel.application.model.persistence.metier.profil.entities.ProfilEntityJPA;

/**
 * CLASSE ProfilDao :<br/>
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
 * @author daniel.levy Lévy
 * @version 1.0
 * @since 5 nov. 2018
 *
 */
@Repository
public class ProfilDao {

	// ************************ATTRIBUTS************************************/

	/**
	 * .<br/>
	 */
	private static Map<Long, ProfilEntityJPA> fakeBaseProfils;
	
	static {
		
		fakeBaseProfils = new HashMap<Long, ProfilEntityJPA>();
		
		fakeBaseProfils.put(
				1L, new ProfilEntityJPA(
						1L
						, ProfilEnum.ADMINISTRATEUR.toString()
						, PorteeEnum.TOUTRESEAU.toString()
						, null));

		fakeBaseProfils.put(
				2L, new ProfilEntityJPA(
						2L
						, ProfilEnum.ADMINISTRATEUR.toString()
						, PorteeEnum.TOUTRESEAU.toString()
						, "Outre-Mer"));

		fakeBaseProfils.put(
				3L, new ProfilEntityJPA(
						3L
						, ProfilEnum.CHARGEETUDE.toString()
						, PorteeEnum.TOUTRESEAU.toString()
						, null));

		fakeBaseProfils.put(
				4L, new ProfilEntityJPA(
						4L
						, ProfilEnum.EXPLOITANT.toString()
						, PorteeEnum.DARWIN.toString()
						, "Réseau concédé"));

		fakeBaseProfils.put(
				5L, new ProfilEntityJPA(
						5L
						, ProfilEnum.EXPLOITANT.toString()
						, PorteeEnum.DIRA.toString()
						, "France Ouest"));

		fakeBaseProfils.put(
				6L, new ProfilEntityJPA(
						6L
						, ProfilEnum.EXPLOITANT.toString()
						, PorteeEnum.DIRO.toString()
						, "Bretagne"));

		fakeBaseProfils.put(
				7L, new ProfilEntityJPA(
						7L
						, ProfilEnum.CONSULTANT.toString()
						, PorteeEnum.TOUTRESEAU.toString()
						, "Bretagne"));
		
	}
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(ProfilDao.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public ProfilDao() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

	
	/**
	 * .<br/>
	 * <ul>
	 * <li></li>
	 * </ul>
	 *
	 * @return : Collection<ProfilEntityJPA> :  .<br/>
	 */
	public Collection<ProfilEntityJPA> getAllProfilsFake() {
		return fakeBaseProfils.values();
	}

	
} // FIN DE LA CLASSE ProfilDao.---------------------------------------------
