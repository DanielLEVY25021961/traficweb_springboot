package levy.daniel.application.model.persistence.metier.profil.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import levy.daniel.application.model.metier.profil.IProfil;
import levy.daniel.application.model.metier.profil.PorteeEnum;
import levy.daniel.application.model.metier.profil.ProfilEnum;
import levy.daniel.application.model.persistence.metier.profil.dao.IProfilDao;
import levy.daniel.application.model.persistence.metier.profil.entities.jpa.ProfilEntityJPA;

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
@Repository("ProfilDaoFake")
public class ProfilDaoFake implements IProfilDao {

	// ************************ATTRIBUTS************************************/
	
	/**
	 * "Classe ProfilDaoFake".<br/>
	 */
	public static final String CLASSE_PROFILDAO_FAKE 
		= "Classe ProfilDaoFake";

	/**
	 * SAUT_LIGNE_JAVA : char :<br/>
	 * '\n'.<br/>
	 */
	public static final char SAUT_LIGNE_JAVA = '\n';

	/**
	 * .<br/>
	 */
	private static Map<Long, IProfil> fakeBaseProfils;
	
	static {
		
		fakeBaseProfils = new HashMap<Long, IProfil>();
		
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
	

	
	/* CREATE ************/


	/**
	 * {@inheritDoc}
	 */
	@Override
	public IProfil create(
			final IProfil pObject) throws Exception {
		fakeBaseProfils.put(pObject.getId(), pObject);
		return pObject;
	} // Fin de create(...)._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void persist(
			final IProfil pObject) throws Exception {
		fakeBaseProfils.put(pObject.getId(), pObject);		
	} // Fin de persist(...).______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long createReturnId(
			final IProfil pObject) throws Exception {
		final IProfil object = this.create(pObject);
		return object.getId();
	} // Fin de createReturnId(...)._______________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public Iterable<IProfil> save(
			final Iterable<IProfil> pList) throws Exception {
		
		/* retourne null si pList == null. */
		if (pList == null) {
			return null;
		}
		
		final List<IProfil> resultat = new ArrayList<IProfil>();
		
		for (final IProfil profil : pList) {
			
			if (profil != null) {
				fakeBaseProfils.put(profil.getId(), profil);
				resultat.add(profil);
			}
		}
		
		return resultat;
		
	} // Fin de save(...)._________________________________________________



	/* READ *************/


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public IProfil retrieve(
			final IProfil pObject) throws Exception {
		return fakeBaseProfils.get(pObject.getId());
	} // Fin de retrieve(...)._____________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public IProfil findById(
			final Long pId) {
		return fakeBaseProfils.get(pId);
	} // Fin de findById(...)._____________________________________________
	


	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long retrieveId(
			final IProfil pObject) throws Exception {
		
		final IProfil object = this.retrieve(pObject);
		
		if (object != null) {
			return object.getId();
		}
		
		return null;
		
	} // Fin de retrieveId(...).___________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<IProfil> findAll() throws Exception {
		return new ArrayList<>(fakeBaseProfils.values());
	} // Fin de findAll()._________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<IProfil> findAllMax(
			final int pStartPosition
				, final int pMaxResult) throws Exception {
		
		final List<IProfil> resultat = new ArrayList<IProfil>();
		
		for (int i = pStartPosition; i < pStartPosition + pMaxResult; i++) {
			
			final IProfil objet = findById(Long.valueOf(i));
			
			if (objet != null) {
				resultat.add(objet);
			}
		}
				
		return resultat;
		
	} // Fin de findAllMax(...).___________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public Iterable<IProfil> findAll(
			final Iterable<Long> pIds) throws Exception {
		
		final List<IProfil> resultat = new ArrayList<IProfil>();		

		final Iterator<Long> iteratorID = pIds.iterator();

		while (iteratorID.hasNext()) {

			final Long id = iteratorID.next();
			
			/* Recherche en base sur Long. */
			final IProfil objetEnBase = this.findById(id);

			if (objetEnBase != null) {
				resultat.add(objetEnBase);
			}			
		}

		return resultat;
		
	} // Fin de findAll(...).______________________________________________



	/* UPDATE *************/


	/**
	 * {@inheritDoc}
	 */
	@Override
	public IProfil update(
			final IProfil pObject) throws Exception {
		
		/* retourne null si pObject == null. */
		if (pObject == null) {
			return null;
		}

		/* retourne pObject si l'objet n'est pas 
		 * déjà persistant en base. */
		if (!this.exists(pObject)) {
			return pObject;
		}

		final IProfil objetEnBase 
			= this.findById(pObject.getId());
	
		if (objetEnBase != null) {
			
			objetEnBase.setProfilString(
					pObject.getProfilString());
			objetEnBase.setPorteeProfil(
					pObject.getPorteeProfil());
			objetEnBase.setRestrictionProfil(
					pObject.getRestrictionProfil());
			
			fakeBaseProfils.put(pObject.getId(), objetEnBase);
		}
	
		return objetEnBase;
	
	} // Fin de update(...)._______________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public IProfil update(
			final Long pId, final IProfil pObject) {
		
		final IProfil objetEnBase 
			= this.findById(pId);
		
		if (objetEnBase != null) {
			
			objetEnBase.setProfilString(
					pObject.getProfilString());
			objetEnBase.setPorteeProfil(
					pObject.getPorteeProfil());
			objetEnBase.setRestrictionProfil(
					pObject.getRestrictionProfil());
			
			fakeBaseProfils.put(pId, objetEnBase);
		}
		
		return objetEnBase;
		
	} // Fin de update(...)._______________________________________________



	/* DELETE *************/



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean delete(
			final IProfil pObject) throws Exception {
		
		boolean resultat = false;
		
		final Long id = pObject.getId();
		
		if (id != null) {
			resultat = fakeBaseProfils
					.remove(id, fakeBaseProfils.get(id));
		}
		
		return resultat;
		
	} // Fin de delete(...)._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteById(
			final Long pId) throws Exception {
		fakeBaseProfils.remove(pId, fakeBaseProfils.get(pId));		
	} // Fin de deleteById(...).___________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteByIdBoolean(
			final Long pId) throws Exception {
		return fakeBaseProfils.remove(pId, fakeBaseProfils.get(pId));	
	} // Fin de deleteByIdBoolean(...).____________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteAll() throws Exception {
		fakeBaseProfils.clear();		
	} // Fin de deleteAll()._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteAllBoolean() throws Exception {
		
		boolean resultat = false;
		
		try {
			fakeBaseProfils.clear();
			resultat = true;
		} catch (Exception e) {
			resultat = false;
		}
		
		return resultat;
		
	} // Fin de deleteAllBoolean().________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteIterable(
			final Iterable<IProfil> pList) throws Exception {
		
		/* ne fait rien si pList == null. */
		if (pList == null) {
			return;
		}
		
		for (final IProfil profil : pList) {			
			delete(profil);
		}
		
	} // Fin de deleteIterable(...)._______________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteIterableBoolean(
			final Iterable<IProfil> pList) throws Exception {
		
		/* ne fait rien si pList == null. */
		if (pList == null) {
			return false;
		}
		
		for (final IProfil profil : pList) {			
			delete(profil);
		}
		
		return true;
		
	} // Fin de deleteIterableBoolean(...).________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean exists(
			final IProfil pObject) throws Exception {
		
		/* retourne false si pObject == null. */
		if (pObject == null) {
			return false;
		}
		
		final IProfil objetpersistent 
			= fakeBaseProfils.get(pObject.getId());
		
		if (objetpersistent != null) {
			return true;
		}
		
		return false;
		
	} // Fin de exists(...)._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean exists(
			final Long pId) throws Exception {

		/* retourne false si pId == null. */
		if (pId == null) {
			return false;
		}

		/* retourne true si l'objet métier existe en base. */
		if (this.findById(pId) != null) {
			return true;
		}

		return false;

	} // Fin de exists(Long...).___________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long count() throws Exception {

		/* Récupère la liste d'Objets métier de Type paramétré IProfil. */
		final List<IProfil> listObjects = this.findAll();

		if (listObjects != null) {

			/* Retourne la taille de la liste. */
			return Long.valueOf(listObjects.size()) ;
		}

		/* retourne 0L si this.findAll() retourne null. */
		return 0L;

	} // Fin de count().___________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void ecrireStockageDansConsole() throws Exception {
		
		/* récupération de tous les objets métier dans le stockage. */
		final List<IProfil> contenuStockage = this.findAll();
		
		/* ne fait rien si findAll() retourne null. */
		if (contenuStockage == null) {
			return;
		}
		
		for (final IProfil objet : contenuStockage) {
			System.out.println(objet.toString());
		}
		
	} // Fin de ecrireStockageDansConsole()._______________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public String afficherListeObjetsMetier(
			final List<IProfil> pList) {
		
		/* retourne null si pList == null. */
		if (pList == null) {
			return null;
		}
		
		final StringBuilder stb =new StringBuilder();
		
		for (final IProfil objetMetier : pList) {
			
			stb.append(objetMetier.toString());
			stb.append(SAUT_LIGNE_JAVA);
		}
		
		return stb.toString();
		
	} // Fin de afficherListeObjetsMetier(...).____________________________


	
} // FIN DE LA CLASSE ProfilDaoFake.---------------------------------------------
