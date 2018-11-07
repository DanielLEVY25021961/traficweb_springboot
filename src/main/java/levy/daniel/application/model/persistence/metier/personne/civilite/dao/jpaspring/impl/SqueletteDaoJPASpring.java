package levy.daniel.application.model.persistence.metier.personne.civilite.dao.jpaspring.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.personne.civilite.ICivilite;
import levy.daniel.application.model.persistence.daoexceptions.AbstractDaoException;
import levy.daniel.application.model.persistence.daoexceptions.GestionnaireDaoException;
import levy.daniel.application.model.persistence.metier.personne.civilite.dao.jpaspring.AbstractCiviliteDao;
import levy.daniel.application.model.persistence.metier.personne.civilite.entities.jpa.CiviliteEntityJPA;

/**
 * CLASSE SqueletteDaoJPASpring :<br/>
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
 * @since 7 nov. 2018
 *
 */
public class SqueletteDaoJPASpring {

	// ************************ATTRIBUTS************************************/
	
	/**
	 * "Classe SqueletteDaoJPASpring".<br/>
	 */
	public static final String CLASSE_SQUELETTEDAO_JPA_SPRING 
		= "Classe SqueletteDaoJPASpring";

	/**
	 * SAUT_LIGNE_JAVA : char :<br/>
	 * '\n'.<br/>
	 */
	public static final char SAUT_LIGNE_JAVA = '\n';

	/**
	 * SELECT_OBJET : String :<br/>
	 * "select civilite from 
	 * CiviliteEntityJPA as civilite ".<br/>
	 */
	public static final String SELECT_OBJET 
		= "select civilite from "
				+ "CiviliteEntityJPA as civilite ";
	
	/**
	 * JPA EntityManager injecté par SPRING.<br/>
	 */
	private transient EntityManager entityManager;
	
	/**
	 * gestionnaireException : GestionnaireDaoException :<br/>
	 * Gestionnaire pour les Exceptions de DAO.<br/>
	 */
	private final transient GestionnaireDaoException gestionnaireException 
		= new GestionnaireDaoException();
	
	/**
	 * "this.entityManager est NULL dans le présent DAO".<br/>
	 */
	public static final String MESSAGE_ENTITYMANAGER_NULL 
	= "this.entityManager est NULL dans le présent DAO";


	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(SqueletteDaoJPASpring.class);

	
	// *************************METHODES************************************/
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public SqueletteDaoJPASpring() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	

	/* CREATE ************/

	/**
	 * <b>crée un objet métier pObject dans le stockage 
	 * et retourne l'objet METIER persisté</b>.<br/>
	 * <ul>
	 * <li>ne crée <b>pas de doublon</b>.</li>
	 * <li>retourne null si pObject existe déjà dans le stockage.</li>
	 * </ul>
	 * - retourne null si pObject == null.<br/>
	 * <br/>
	 *
	 * @param pObject : ICivilite : 
	 * l'objet métier à persister dans le stockage.<br/>
	 * 
	 * @return ICivilite : 
	 * l'objet métier persisté dans le stockage.<br/>
	 * 
	 * @throws Exception
	 */
	public final ICivilite create(
			final ICivilite pObject) throws Exception {

		/* retourne null si pObject == null. */
		if (pObject == null) {
			return null;
		}

		ICivilite persistentObject = null;

		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return null;
		}

		/* retourne null si pObject est un doublon. */
		if (this.exists(pObject)) {
			return null;
		}

		try {
			
			/* Obtention d'une Entity JPA à partir de l'objet métier. */
			final CiviliteEntityJPA entity 
				= new CiviliteEntityJPA(pObject);

			/* ***************** */
			/* PERSISTE en base. */
			this.entityManager.persist(entity);

			persistentObject = pObject;

		}
		catch (Exception e) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_SQUELETTEDAO_JPA_SPRING
							, "Méthode create(ICivilite pObject)", e);

		}

		/* retourne l'Objet persistant. */
		return persistentObject;

	} // Fin de create(...)._______________________________________________



	/**
	 * <b>crée un objet métier pObject dans le stockage 
	 * mais ne retourne rien</b>.<br/>
	 * <ul>
	 * <li>ne crée <b>pas de doublon</b>.</li>
	 * <li>ne fait rien si pObject existe déjà dans le stockage.</li>
	 * </ul>
	 * - ne fait rien si pObject == null.<br/>
	 * <br/>
	 *
	 * @param pObject : ICivilite : 
	 * l'objet métier à persister dans le stockage.<br/>
	 * 
	 * @throws Exception
	 */
	public final void persist(
			final ICivilite pObject) throws Exception {

		/* ne fait rien si pObject == null. */
		if (pObject == null) {
			return;
		}

		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return;
		}

		/* ne fait rien si pObject est un doublon. */
		if (this.exists(pObject)) {
			return;
		}


		try {
			
			/* Obtention d'une Entity JPA à partir de l'objet métier. */
			final CiviliteEntityJPA entity 
				= new CiviliteEntityJPA(pObject);

			/* ***************** */
			/* PERSISTE en base. */
			this.entityManager.persist(entity);

		}
		catch (Exception e) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_SQUELETTEDAO_JPA_SPRING
							, "Méthode persist(ICivilite Object)", e);

		}

	} // Fin de persist(...).______________________________________________



	/**
	 * <b>crée un objet métier pObject dans le stockage 
	 * et retourne l'identifiant de l'objet persisté</b>.<br/>
	 * <ul>
	 * <li>ne crée <b>pas de doublon</b>.</li>
	 * <li>retourne null si pObject existe déjà dans le stockage.</li>
	 * </ul>
	 * - retourne null si pObject == null.<br/>
	 * <br/>
	 *
	 * @param pObject : ICivilite : 
	 * l'objet métier à persister dans le stockage.<br/>
	 * 
	 * @return : Long : 
	 * identifiant (ou index 0-based) 
	 * de l'objet persisté dans le stockage.<br/>
	 * 
	 * @throws Exception
	 */
	public final Long createReturnId(
			final ICivilite pObject) throws Exception {

		/* retourne null si pObject == null. */
		if (pObject == null) {
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

		/* retourne null si pObject est un doublon. */
		if (this.exists(pObject)) {
			return null;
		}

		/* ******************************************************* */
		/* Crée l'Objet en base ou jette une AbstractDaoException. */
		final ICivilite objetPersistant 
			= this.create(pObject);

		/* retourne null si l'objet pObject n'a pu être créé en base. */
		if (objetPersistant == null) {
			return null;
		}

		/* retourne l'Long de l'objet persistant. */
		return objetPersistant.getId();	

	} // Fin de createReturnId(...)._______________________________________


	
	/**
	 * <b>crée un iterable d'objets métier pList 
	 * dans le stockage</b> et retourne l'itérable persisté.<br/>
	 * <ul>
	 * <li>ne crée <b>pas de doublon</b>.</li>
	 * <li>ne fait rien et continue la sauvegarde si un objet 
	 * dans l'itérable existe déjà dans le stockage.</li>
	 * <li>ne fait rien et continue la sauvegarde si un objet 
	 * null est contenu dans l'itérable.</li>
	 * </ul>
	 *
	 * @param pList : Iterable&lt;ICivilite&gt; : 
	 * itérable d'objets métier à persister dans le stockage.<br/>
	 * 
	 * @return Iterable&lt;ICivilite&gt; : 
	 * itérable d'objets métier persistés dans le stockage.<br/>
	 * 
	 * @throws Exception
	 */
	public final Iterable<ICivilite> save(
			final Iterable<ICivilite> pList) 
					throws Exception {
		
		/* retourne null si pList == null. */
		if (pList == null) {
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

		final List<ICivilite> resultat = new ArrayList<ICivilite>();

		final Iterator<ICivilite> iteS = pList.iterator();

		try {

			while (iteS.hasNext()) {

				final ICivilite objet = iteS.next();

				/* Passe les doublons existants en base. */
				if (!this.exists(objet)) {

					/* passe un null dans le lot. */
					if (objet != null) {

						/* Obtention d'une Entity JPA à partir 
						 * de l'objet métier. */
						final CiviliteEntityJPA entity 
							= new CiviliteEntityJPA(objet);
						
						ICivilite objetPersistant = null;

						try {

							/* ***************** */
							/* PERSISTE en base. */
							this.entityManager.persist(entity);

							objetPersistant = objet;

						} catch (Exception e) {

							/* LOG. */
							if (LOG.isFatalEnabled()) {
								LOG.fatal(e.getMessage(), e);
							}

							/* Gestion de la DAO Exception. */
							this.gestionnaireException
								.gererException(
										CLASSE_SQUELETTEDAO_JPA_SPRING
											, "Méthode save(Iterable)", e);
						}


						/* ne sauvegarde pas un doublon 
						 * présent dans le lot. */
						if (objetPersistant != null) {

							/* Ajoute à l'iterable resultat. */
							resultat.add(objetPersistant);								
						}						
					}					
				}				
			} // Next._____________________________________

		}
		catch (Exception e) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_SQUELETTEDAO_JPA_SPRING
							, "Méthode save(Iterable)", e);

		}

		/* retourne l'iterable resultat. */
		return resultat;

	} // Fin de save(...)._________________________________________________
	
	


	/* READ *************/


	/**
	 * <b>recherche un objet métier pObject 
	 * dans le stockage</b> et retourne l'objet métier persisté.<br/>
	 * recherche l'objet métier par son égalité métier 
	 * (equals()).<br/>
	 * <ul>
	 * <li>retourne null si l'objet métier 
	 * n'existe pas dans le stockage.</li>
	 * </ul>
	 *
	 * @param pObject : ICivilite : 
	 * objet métier à rechercher.<br/>
	 * 
	 * @return : ICivilite : 
	 * objet métier recherché.<br/>
	 * 
	 * @throws Exception
	 */
	public final ICivilite retrieve(
			final ICivilite pObject) throws Exception {

		/* return null si pObject == null. */
		if (pObject == null) {
			return null;
		}

		ICivilite objetResultat = null;

		/* REQUETE HQL PARAMETREE. */
		final String requeteString 
			= SELECT_OBJET
				+ "where civilite.civiliteString = :pCiviliteString";

		/* Construction de la requête HQL. */
		final Query requete 
			= this.entityManager.createQuery(requeteString);

		/* Passage des paramètres de la requête HQL. */
		requete.setParameter("pCiviliteString", pObject.getCiviliteString());

		try {

			/* Execution de la requete HQL. */
			objetResultat 
				= (ICivilite) requete.getSingleResult();

		}
		catch (NoResultException noResultExc) {

			/* retourne null si l'Objet métier n'existe pas en base. */
			return null;

		}
		catch (Exception e) {

			/* LOG. */
			if (LOG.isDebugEnabled()) {
				LOG.debug(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_SQUELETTEDAO_JPA_SPRING
						, "Méthode retrieve(ICivilite pObject)", e);
		}

		return objetResultat;

	} // Fin de retrieve(...)._____________________________________________


	
	/**
	 * <b>recherche un objet métier pObject via son identifiant (index) 
	 * dans le stockage</b> et retourne l'objet métier persisté.<br/>
	 * <ul>
	 * <li>retourne null si l'objet métier 
	 * n'existe pas dans le stockage.</li>
	 * </ul>
	 *
	 * @param pId : Long : 
	 * index (0-based) ou identifiant en base 
	 * de l'objet métier à rechercher.<br/>
	 * 
	 * @return : ICivilite : objet métier recherché.<br/>
	 * 
	 * @throws Exception
	 */
	public final ICivilite findById(
			final Long pId) throws Exception {

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

			/* ******************** */
			// RECHERCHE EN BASE.
			objetTrouve 
				= this.entityManager
					.find(CiviliteEntityJPA.class, pId);

		}
		catch (Exception e) {

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_SQUELETTEDAO_JPA_SPRING
						, "Méthode findById(Long)", e);

		}

		return objetTrouve;

	} // Fin de findById(...)._____________________________________________

	
	
	/**
	 * <b>retourne l'identifiant ou l'index (0-based) 
	 * de l'objet métier pObject dans le stockage</b>.<br/>
	 *
	 * @param pObject : ICivilite : 
	 * objet métier dont on recherche l'identifiant.<br/>
	 *  
	 * @return Long : 
	 * identifiant ou index (0-based) dans le stockage.<br/>
	 * 
	 * @throws Exception
	 */
	public final Long retrieveId(
			final ICivilite pObject) throws Exception {
		
		final ICivilite object = this.retrieve(pObject);
		
		Long resultat = null;
		
		if (object != null) {
			resultat = object.getId();
		}
		
		return resultat;
		
	} // Fin de retrieveId(...).___________________________________________



	/**
	 * <b>retourne la liste de tous les objets métier 
	 * persistés dans le stockage</b>.<br/>
	 * - peut retourner null si le stockage ne peut être lu.<br/>
	 *
	 * @return : List&lt;ICivilite&gt; : 
	 * liste de tous les objets métier persistés dans le stockage.<br/>
	 * 
	 * @throws Exception
	 */
	public final List<ICivilite> findAll() throws Exception {

		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return null;
		}

		/* Création de la requête HQL sous forme de String. */
		final String requeteString 
			= "from CiviliteEntityJPA";

		List<ICivilite> resultat = null;

		try {

			/* Crée la requête javax.persistence.Query. */
			final Query query 
				= this.entityManager.createQuery(requeteString);

			/* Exécute la javax.persistence.Query. */
			resultat = query.getResultList();

		}
		catch (Exception e) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_SQUELETTEDAO_JPA_SPRING
						, "Méthode findall()", e);

		}

		/* Retourne la liste résultat. */
		return resultat;

	} // Fin de findAll()._________________________________________________



	/**
	 * <b>retourne la liste des pMax objets métier 
	 * persistés dans le stockage</b> à partir de la 
	 * position pStartPosition (0-based).<br/>
	 * <ul>
	 * <li>retourne par exemple les 50 objets métier stockés 
	 * à partir du 100ème.</li>
	 * <li>retourne null si pStartPosition est hors indexes.</li>
	 * </ul>
	 *
	 * @param pStartPosition : int : index (0-based) de départ.<br/>
	 * @param pMaxResult : int : 
	 * nombre maximum d'objets métier à retourner.<br/>
	 * 
	 * @return : List&lt;ICivilite&gt; : 
	 * liste des pMax objets métier persistés dans le stockage 
	 * à partir de pStartPosition (0-based).<br/>
	 * 
	 * @throws Exception
	 */
	public final List<ICivilite> findAllMax(
			final int pStartPosition
				, final int pMaxResult) throws Exception {


		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return null;
		}

		/* Création de la requête HQL sous forme de String. */
		final String requeteString 
			= "from CiviliteEntityJPA";

		List<ICivilite> resultat = null;

		try {

			/* Crée la requête javax.persistence.Query. */
			final Query query 
				= this.entityManager.createQuery(requeteString)
					.setFirstResult(pStartPosition).setMaxResults(pMaxResult);

			/* Exécute la javax.persistence.Query. */
			resultat = query.getResultList();

		}
		catch (Exception e) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_SQUELETTEDAO_JPA_SPRING
						, "Méthode findAllMax(...)", e);

		}

		/* Retourne la liste résultat. */
		return resultat;

	} // Fin de findAllMax(...).___________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Iterable<ICivilite> findAll(
			final Iterable<Long> pIds) throws AbstractDaoException {

		/* retourne null si pIds == null. */
		if (pIds == null) {
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

		final List<ICivilite> resultat = new ArrayList<ICivilite>();		

		final Iterator<Long> iteratorID = pIds.iterator();

		while (iteratorID.hasNext()) {

			final Long id = iteratorID.next();
			/* Recherche en base sur Long. */
			final ICivilite objetEnBase = this.findById(id);

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
	public final ICivilite update(
			final ICivilite pObject) throws AbstractDaoException {

		/* retourne null si pObject == null. */
		if (pObject == null) {
			return null;
		}

		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return null;
		} // Fin de this.entityManager == null.____________


		/* retourne pObject si l'objet n'est pas 
		 * déjà persistant en base. */
		if (!this.exists(pObject)) {
			return pObject;
		}

		ICivilite persistentObject = null;

		try {

			/* MODIFIE en base. */
			this.entityManager.merge(pObject);

			persistentObject = pObject;

		}
		catch (Exception e) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_ABSTRACTDAOGENERIC_JPA_SPRING
						, "Méthode update(ICivilite Object)", e);

		}

		/* retourne l'Objet persistant modifié. */
		return persistentObject;

	} // Fin de update(...)._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public ICivilite update(Long pIndex, ICivilite pObjectModifie) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



	/* DELETE *************/


	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean delete(
			final ICivilite pObject) throws AbstractDaoException {

		/* retourne false si pObject == null. */
		if (pObject == null) {
			return false;
		}

		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return false;
		}

		boolean resultat = false;

		/* Vérifie qu'il existe une instance persistante. */
		final ICivilite persistanceInstance = this.retrieve(pObject);

		try {

			if (persistanceInstance != null) {

				/* merge avant de pouvoir détruire. */
				this.entityManager.merge(persistanceInstance);

				/* DESTRUCTION. */
				this.entityManager.remove(persistanceInstance);

				resultat = true;

			}
			else {
				resultat = false;
			}

		} catch (Exception e) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_ABSTRACTDAOGENERIC_JPA_SPRING
						, "Méthode delete(ICivilite pObject)", e);

		}

		return resultat;

	} // Fin de delete(...)._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract void deleteById(Long pId) throws AbstractDaoException;



	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract boolean deleteByIdBoolean(Long pId) 
			throws AbstractDaoException;



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void deleteAll() throws AbstractDaoException {

		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return;
		}


		/* Création de la requête HQL sous forme de String. */
		final String requeteString 
			= "delete from " + this.classObjetMetier.getName();

		try {

			/* Crée la requête javax.persistence.Query. */
			final Query query 
				= this.entityManager.createQuery(requeteString);

			/* EXECUTION DE LA REQUETE. */
			query.executeUpdate();

		}
		catch (Exception e) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_ABSTRACTDAOGENERIC_JPA_SPRING
						, "Méthode deleteAll()", e);

		}

	} // Fin de deleteAll()._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean deleteAllBoolean() throws AbstractDaoException {

		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return false;
		}


		boolean resultat = false;

		/* Création de la requête HQL sous forme de String. */
		final String requeteString 
			= "delete from " + this.classObjetMetier.getName();

		try {

			/* Crée la requête javax.persistence.Query. */
			final Query query 
				= this.entityManager.createQuery(requeteString);

			/* EXECUTION DE LA REQUETE. */
			query.executeUpdate();

			resultat = true;

		}
		catch (Exception e) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_ABSTRACTDAOGENERIC_JPA_SPRING
						, "Méthode deleteAllBoolean()", e);

		}

		return resultat;

	} // Fin de deleteAll()._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void delete(
			final Iterable<? extends ICivilite> pObjects) 
						throws AbstractDaoException {

		/* ne fait rien si pObjects == null. */
		if (pObjects == null) {
			return;
		}

		final Iterator<? extends ICivilite> itePersistants = pObjects.iterator();
		final List<ICivilite> listePersistants 
			= new ArrayList<ICivilite>();

		/* Récupération préalable des objets persistans en base. */
		while (itePersistants.hasNext()) {
			final ICivilite objet = itePersistants.next();
			final ICivilite objetPersistant = this.retrieve(objet);

			if (objetPersistant != null) {
				listePersistants.add(objetPersistant);
			}
		}


		/* Itération uniquement sur la liste des Objets persistants. */
		final Iterator<? extends ICivilite> ite = listePersistants.iterator();

		try {

			while (ite.hasNext()) {

				final ICivilite objectPersistant = ite.next();

				/* DESTRUCTION. */
				this.entityManager.remove(objectPersistant);

			}

		}
		catch (Exception e) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException.gererException(
					CLASSE_ABSTRACTDAOGENERIC_JPA_SPRING
					, "Méthode delete(Iterable)", e);

		}

	} // Fin de delete(...)._______________________________________________


	
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
	public void deleteAllSousClasse() throws AbstractDaoException {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteAllBooleanSousClasse() throws AbstractDaoException {
		// TODO Auto-generated method stub
		return false;
	}



	/* TOOLS *************/

	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract boolean exists(ICivilite pObject) throws AbstractDaoException;



	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract boolean exists(Long pId) throws AbstractDaoException;



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Long count() throws AbstractDaoException {

		/* Récupère la liste d'Objets métier de Type paramétré ICivilite. */
		final List<ICivilite> listObjects = this.findAll();

		if (listObjects != null) {

			/* Retourne la taille de la liste. */
			return Long.valueOf(listObjects.size()) ;
		}

		return 0L;

	} // Fin de count().___________________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long countSousClasse() throws AbstractDaoException {
		// TODO Auto-generated method stub
		return null;
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



}
