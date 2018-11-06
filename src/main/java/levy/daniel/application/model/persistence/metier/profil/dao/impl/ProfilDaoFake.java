package levy.daniel.application.model.persistence.metier.profil.dao.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import levy.daniel.application.model.metier.profil.IProfil;
import levy.daniel.application.model.metier.profil.PorteeEnum;
import levy.daniel.application.model.metier.profil.ProfilEnum;
import levy.daniel.application.model.persistence.metier.profil.dao.IProfilDao;
import levy.daniel.application.model.persistence.metier.profil.entities.ProfilEntityJPA;

/**
 * CLASSE ProfilDaoFake :<br/>
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
@Qualifier("ProfilDaoFake")
public class ProfilDaoFake implements IProfilDao {

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
		= LogFactory.getLog(ProfilDaoFake.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public ProfilDaoFake() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public IProfil create(
			final ProfilEntityJPA pProfil) {
		fakeBaseProfils.put(pProfil.getId(), pProfil);
		return pProfil;
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public IProfil getById(
			final Long pId) {
		return fakeBaseProfils.get(pId);
	}
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<ProfilEntityJPA> listAll() {
		return fakeBaseProfils.values();
	}

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public IProfil update(
			final Long pId, final IProfil pProfil) {
		
		final ProfilEntityJPA objetEnBase 
			= (ProfilEntityJPA) this.getById(pId);
		
		if (objetEnBase != null) {
			
			objetEnBase.setProfilString(pProfil.getProfilString());
			objetEnBase.setPorteeProfil(pProfil.getPorteeProfil());
			objetEnBase.setRestrictionProfil(pProfil.getRestrictionProfil());
			
			fakeBaseProfils.put(pId, objetEnBase);
		}
		
		return objetEnBase;
	}


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteById(
			final Long pId) {
		return fakeBaseProfils.remove(pId, fakeBaseProfils.get(pId));
	}


	
} // FIN DE LA CLASSE ProfilDaoFake.---------------------------------------------
