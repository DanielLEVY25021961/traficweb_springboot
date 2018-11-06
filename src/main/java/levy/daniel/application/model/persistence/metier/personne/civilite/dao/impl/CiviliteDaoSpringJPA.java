package levy.daniel.application.model.persistence.metier.personne.civilite.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.personne.civilite.ICivilite;
import levy.daniel.application.model.metier.profil.IProfil;
import levy.daniel.application.model.persistence.daoexceptions.AbstractDaoException;
import levy.daniel.application.model.persistence.daoexceptions.GestionnaireDaoException;
import levy.daniel.application.model.persistence.metier.personne.civilite.dao.AbstractCiviliteDao;
import levy.daniel.application.model.persistence.metier.personne.civilite.entities.jpa.CiviliteEntityJPA;

/**
 * CLASSE CONCRETE <b>CiviliteDaoSpringJPA</b> :<br/>
 * <p>
 * <span style="text-decoration: underline;">CONCEPT 
 * CONCERNE PAR CE DAO</span>
 * </p>
 * <p>
 * <b>Civilite</b> modélise un un <i>concept</i> 
 * de <b>Civilite</b> avec ********
 * <b>*****</b>  qui identifie <i>une ou plusieurs</i> <b>****</b>.<br/>
 * </p>
 * 
 * <p>
 * <span style="text-decoration: underline;">DESCRIPTION DE 
 * CiviliteDaoSpringJPA</span>
 * </p>
 * <ul>
 * <li>DAO <b>CONCRET</b> pour les <b>Civilite</b>.</li>
 * <li>
 * HERITE DU DAO ABSTRAIT AbstractCiviliteDao.
 * </li>
 * <li>
 * Certaines méthodes (getOne(ID), ...) sont 
 * <b>compatibles SPRING DATA</b>.
 * </li>
 * </ul>
 * 
 * <p>
 * <span style="text-decoration: underline;">IMPLEMENTATION DES CiviliteDaoSpringJPA</span>
 * </p>
 * <ul>
 * <li>
 * <img src="../../../../../../../../../../../../../../../javadoc/images/implementation_DAO_Civilite.png" 
 * alt="implémentation des DAOs Civilite" border="1" align="center" />
 * </li>
 * </ul>
 * 
 * <p>
 * <span style="text-decoration: underline;">UTILISATION DES CiviliteDaoSpringJPA</span>
 * </p>
 * <ul>
 * <li>
 * <img src="../../../../../../../../../../../../javadoc/images/utilisation_DaoProfilCerbere.png" 
 * alt="utilisation des DAOs CiviliteDaoSpringJPA" border="1" align="center" />
 * </li>
 * </ul>
 * 
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
 * @since 01 mars 2018
 *
 */
public class CiviliteDaoSpringJPA 
			extends AbstractCiviliteDao {

	// ************************ATTRIBUTS************************************/


	/**
	 * "Classe CiviliteDaoSpringJPA".<br/>
	 */
	public static final String CLASSE_CIVILITE_DAO_SPRING_JPA 
		= "Classe CiviliteDaoSpringJPA";
	
	/**
	 * entityManager : javax.persistence.EntityManager :<br/>
	 * JPA EntityManager injecté par SPRING.<br/>
	 */
	@PersistenceContext
	protected transient EntityManager entityManager;

	/**
	 * gestionnaireException : GestionnaireDaoException :<br/>
	 * Gestionnaire pour les Exceptions de DAO.<br/>
	 */
	protected transient GestionnaireDaoException gestionnaireException 
		= new GestionnaireDaoException();


	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(CiviliteDaoSpringJPA.class);

	
	// *************************METHODES************************************/
		
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public CiviliteDaoSpringJPA() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ICivilite findById(
			final Long pId) throws AbstractDaoException {

		ICivilite objetTrouve = null;

		/* retourne null si pId == null. */
		if (pId == null) {
			return null;
		}

		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return null;
		}

		try {

			objetTrouve 
				= this.entityManager.find(CiviliteEntityJPA.class, pId);

		}
		catch (Exception e) {

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_CIVILITE_DAO_SPRING_JPA
						, "Méthode findById(ID)", e);

		}

		return objetTrouve;

	} // Fin de findById(...)._____________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ICivilite> findAllSousClasse() 
			throws AbstractDaoException {
		return this.findAll();
	} // Fin de findAllSousClasse()._______________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ICivilite> findAllMaxSousClasse(
			final int pStartPosition, final int pMaxResult) 
					throws AbstractDaoException {
		return this.findAllMax(pStartPosition, pMaxResult);
	} // Fin de findAllMaxSousClasse(...)._________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long retrieveId(
			final ICivilite pObject) throws AbstractDaoException {
		
		final ICivilite object = this.retrieve(pObject);
		
		Long resultat = null;
		
		if (object != null) {
			resultat = object.getId();
		}
		
		return resultat;
		
	} // Fin de retrieveId(...).___________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteAllSousClasse() throws AbstractDaoException {
		this.deleteAll();
	} // Fin de deleteAllSousClasse()._____________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteAllBooleanSousClasse() 
						throws AbstractDaoException {
		return this.deleteAllBoolean();
	} // Fin de deleteAllBooleanSousClasse().______________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long countSousClasse() throws AbstractDaoException {
		return this.count();
	} // Fin de countSousClasse()._________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ICivilite  (Long pIndex, ICivilite pObjectModifie) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteIterable(Iterable<ICivilite> pList) throws Exception {
		// TODO Auto-generated method stub
		
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteIterableBoolean(Iterable<ICivilite> pList) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void ecrireStockageDansConsole() throws Exception {
		// TODO Auto-generated method stub
		
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public String afficherListeObjetsMetier(List<ICivilite> pList) {
		// TODO Auto-generated method stub
		return null;
	}

	

} // FIN DE LA CLASSE CiviliteDaoSpringJPA.-------------------------------------------
