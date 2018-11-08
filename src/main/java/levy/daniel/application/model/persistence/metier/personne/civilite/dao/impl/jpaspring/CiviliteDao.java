package levy.daniel.application.model.persistence.metier.personne.civilite.dao.impl.jpaspring;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import levy.daniel.application.model.metier.personne.civilite.ICivilite;
import levy.daniel.application.model.persistence.daoexceptions.GestionnaireDaoException;
import levy.daniel.application.model.persistence.metier.personne.civilite.entities.jpa.CiviliteEntityJPA;

/**
 * CLASSE CONCRETE <b>CiviliteDao</b> :<br/>
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
 * CiviliteDao</span>
 * </p>
 * <ul>
 * <li>DAO <b>CONCRET</b> pour les <b>Civilite</b>.</li>
 * <li>
 * Implémente l'interface <b>ICiviliteDao</b>.
 * </li>
 * <li>
 * Certaines méthodes (getOne(ID), ...) sont 
 * <b>compatibles SPRING DATA</b>.
 * </li>
 * </ul>
 * 
 * <p>
 * <span style="text-decoration: underline;">IMPLEMENTATION DES CiviliteDao</span>
 * </p>
 * <ul>
 * <li>
 * <img src="../../../../../../../../../../../../../../../javadoc/images/implementation_DAO_Civilite_JpaSpring.png" 
 * alt="implémentation des DAOs Civilite JPA SPRING" border="1" align="center" />
 * </li>
 * </ul>
 * 
 * <p>
 * <span style="text-decoration: underline;">UTILISATION DES CiviliteDao</span>
 * </p>
 * <ul>
 * <li>
 * <img src="../../../../../../../../../../../../javadoc/images/utilisation_CiviliteDao_JpaSpring.png" 
 * alt="utilisation des DAOs CiviliteDao JPA SPRING" border="1" align="center" />
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
@Repository("CiviliteDaoJPASpringSimple")
//@Qualifier("CiviliteDaoJPASpringSimple")
public class CiviliteDao {

	// ************************ATTRIBUTS************************************/
	
	/**
	 * "Classe CiviliteDao".<br/>
	 */
	public static final String CLASSE_SQUELETTEDAO_JPA_SPRING 
		= "Classe CiviliteDao";

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
	@PersistenceContext
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
		= LogFactory.getLog(CiviliteDao.class);

	
	// *************************METHODES************************************/
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public CiviliteDao() {
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
		/* Crée l'Objet en base ou jette une Exception. */
		final ICivilite objectPersistant 
			= this.create(pObject);

		/* retourne null si l'objet pObject n'a pu être créé en base. */
		if (objectPersistant == null) {
			return null;
		}

		/* retourne l'Long de l'objet persistant. */
		return objectPersistant.getId();	

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
						
						ICivilite objectPersistant = null;

						try {

							/* ***************** */
							/* PERSISTE en base. */
							this.entityManager.persist(entity);

							objectPersistant = objet;

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
						if (objectPersistant != null) {

							/* Ajoute à l'iterable resultat. */
							resultat.add(objectPersistant);								
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

		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return null;
		}

		ICivilite objectPersistant = null;

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
			objectPersistant 
				= (ICivilite) requete.getSingleResult();

		}
		catch (NoResultException noResultExc) {

			/* retourne null si l'Objet métier n'existe pas en base. */
			return null;

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
						, "Méthode retrieve(ICivilite pObject)", e);
		}

		return objectPersistant;

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
	 * method findAll(
	 * Iterable&lt;Long&gt; pIds) :<br/>
	 * <ul>
	 * <li>retourne une Collection iterable d'Objets métier 
	 * (List&lt;ICivilite&gt;) dont les IDs appartiennent 
	 * à la Collection itérable d'IDs passée en paramètre.</li>
	 * <li>Inclut dans la liste les sous-classe de ICivilite 
	 * (strategy=InheritanceType.JOINED) 
	 * avec la visibilité (Typé) ICivilite.</li>
	 * </ul>
	 * retourne null si pIds == null.<br/>
	 * ne retourne que les objets de la collection 
	 * effectivement persistés en base.<br/>
	 * <br/>
	 *
	 * @param pIds : Iterable&lt;Long&gt;.<br/>
	 * 
	 * @return Iterable&lt;ICivilite&gt; : List&lt;ICivilite&gt;.<br/>
	 * 
	 * @throws Exception 
	 */
	public final Iterable<ICivilite> findAll(
			final Iterable<Long> pIds) throws Exception {

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
	 * method update(
	 * ICivilite pObject) :<br/>
	 * <ul>
	 * <li><b>Modifie</b> un objet métier <b>persistant</b> 
	 * existant en base.</li>
	 * <li>Retourne l'objet métier pObject <b>modifié en base</b> 
	 * avec la visibilité (Typé) ICivilite.</li>
	 * </ul>
	 * retourne null si pObject == null.<br/>
	 * ne fait rien et retourne l'instance détachée 
	 * si pObject n'est pas déjà persistant en base.<br/>
	 * <br/>
	 * <code>Exemple de code : </code><br/>
	 * <code>// Récupération de l'objet persistant à modifier.</code><br/>
	 * <code>objet1Persistant = this.daoUserSimple.retrieve(objet1);</code><br/>
	 * <code>// Modifications.</code><br/>
	 * <code>objet1Persistant.setPrenom("Jean-Frédéric modifié");</code><br/>
	 * <code>objet1Persistant.setNom("Bôrne modifié");</code><br/>
	 * <code>// Application des modifications en base.</code><br/>
	 * <code>objet1ModifiePersistant = 
	 * this.daoUserSimple.<b>update(objet1Persistant)</b>;</code><br/>
	 * <br/>
	 *
	 * @param pObject : ICivilite : objet métier avec ID 
	 * et comportant les modifications.<br/>
	 * 
	 * @return : T : objet métier de Type paramétré 
	 * T modifié en base.<br/>
	 * 
	 * @throws Exception 
	 */
	public final ICivilite update(
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
		} // Fin de this.entityManager == null.____________


		/* retourne pObject si l'objet n'est pas 
		 * déjà persistant en base. */
		if (!this.exists(pObject)) {
			return pObject;
		}

		ICivilite persistentObject = null;

		try {

			/* Obtention d'une Entity JPA à partir de l'objet métier. */
			final CiviliteEntityJPA entity 
				= new CiviliteEntityJPA(pObject);
			
			/* **************** */
			/* MODIFIE en base. */
			this.entityManager.merge(entity);

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
						, "Méthode update(ICivilite Object)", e);

		}

		/* retourne l'Objet persistant modifié. */
		return persistentObject;

	} // Fin de update(...)._______________________________________________



	/**
	 * <b>modifie dans le stockage 
	 * l'objet d'index (0-based) ou d'identifiant pId 
	 * avec les valeurs 
	 * contenues dans pObjectModifie</b>.<br/>
	 * <ul>
	 * <li><b>pId doit correspondre à l'index (0-based) 
	 * de l'objet métier à modifier</b>.</li>
	 * <li>pObjectModifie est un conteneur contenant les modifications 
	 * à apporter à un objet persistant dans le stockage. 
	 * Il n'a pas besoin d'avoir d'ID.</li>
	 * <li>retourne null s'il n'y a pas d'objet persistant à pId.</li>
	 * <li>retourne null si pId est en dehors des indexes.</li>
	 * </ul>
	 * - retourne null si pId == null.<br/>
	 * - retourne null si pObjectModifie == null.<br/>
	 * <br/>
	 *
	 * @param pId : Long : 
	 * index (0-based) de l'objet métier à modifier.<br/>
	 * @param pObjectModifie : ICivilite : 
	 * Objet métier contenant les modifications 
	 * à apporter à l'objet persistant dans le stockage.<br/>
	 * 
	 * @return ICivilite : objet métier persistant modifié.<br/>
	 * 
	 * @throws Exception
	 */
	public final ICivilite update(
			final Long pId, final ICivilite pObjectModifie) 
												throws Exception {

		/* retourne null si pId == null. */
		if (pId == null) {
			return null;
		}
		
		/* retourne null si pObjectModifie == null. */
		if (pObjectModifie == null) {
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

		/* récupération de l'objet persistant à modifier. */
		final ICivilite objectPersistant = this.findById(pId);
		
		/* retourne null s'il n'y a pas d'objet persistant à pId. */
		if (objectPersistant == null) {
			return null;
		}

		ICivilite persistentObject = null;
		
		try {
			
			final Long id = objectPersistant.getId();
			
			/* Obtention d'une Entity JPA à partir de l'objet métier. */
			final CiviliteEntityJPA entity 
				= new CiviliteEntityJPA(pObjectModifie);
			
			/* Passage de l'ID à l'entity contenant les modifications. */
			entity.setId(id);
			
			/* **************** */
			/* MODIFIE en base. */
			this.entityManager.merge(entity);

			persistentObject = pObjectModifie;
			
		} catch (Exception e) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_SQUELETTEDAO_JPA_SPRING
						, "Méthode update(Long pId"
								+ ", ICivilite Object)", e);
			
		}

		/* retourne l'Objet persistant modifié. */
		return persistentObject;
		
	} // Fin de update(...)._______________________________________________



	/* DELETE *************/


	/**
	 * <b>retire l'objet métier pObject dans le stockage</b>.<br/>
	 * retourne true si le retrait a bien été effectué.<br/>
	 * <ul>
	 * <li>retourne false si pObject n'est pas persisté.</li>
	 * </ul>
	 * - retourne false si pObject == null.<br/>
	 * <br/>
	 *
	 * @param pObject : ICivilite : objet métier à détruire.<br/>
	 * 
	 * @return : boolean : 
	 * true si l'objet métier a été détruit.<br/>
	 * 
	 * @throws Exception
	 */
	public final boolean delete(
			final ICivilite pObject) throws Exception {

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

		/* Vérifie qu'il existe une instance persistante. */
		final ICivilite objectPersistant = this.retrieve(pObject);
		
		/* retourne false si pObject n'est pas persisté. */
		if (objectPersistant == null) {
			return false;
		}

		boolean resultat = false;
		
		try {

			/* Obtention d'une Entity JPA à partir de l'objet métier. */
			final CiviliteEntityJPA entity 
				= new CiviliteEntityJPA(objectPersistant);

			/* merge avant de pouvoir détruire. */
			this.entityManager.merge(entity);

			/* ************ */
			/* DESTRUCTION. */
			this.entityManager.remove(entity);

			resultat = true;

		} catch (Exception e) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_SQUELETTEDAO_JPA_SPRING
						, "Méthode delete(ICivilite pObject)", e);

		}

		return resultat;

	} // Fin de delete(...)._______________________________________________



	/**
	 * <b>retire l'objet métier d'identifiant ou 
	 * d'index (0-based) pId dans le stockage</b>.<br/>
	 * <ul>
	 * <li>ne fait rien si pId est hors indexes.</li>
	 * </ul>
	 * - ne fait rien si pId == null.<br/>
	 * <br/>
	 *
	 * @param pId : Long : 
	 * index (0-based) de l'objet métier à modifier.<br/>
	 * 
	 * @throws Exception
	 */
	public void deleteById(
			final Long pId) throws Exception {

		/* ne fait rien si pId == null. */
		if (pId == null) {
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

		ICivilite objectPersistant = null;

		/* REQUETE HQL PARAMETREE. */
		final String requeteString 
		= SELECT_OBJET 
		+ "where civilite.id = :pId";

		/* Construction de la requête HQL. */
		final Query requete 
			= this.entityManager.createQuery(requeteString);

		/* Passage des paramètres de la requête HQL. */
		requete.setParameter("pId", pId);

		try {
			
			/* Execution de la requete HQL. */
			objectPersistant 
			= (ICivilite) requete.getSingleResult();
		}
		catch (NoResultException noResultExc) {
			objectPersistant = null;
		}

		try {

			if (objectPersistant != null) {

				/* Obtention d'une Entity JPA à partir de l'objet métier. */
				final CiviliteEntityJPA entity 
					= new CiviliteEntityJPA(objectPersistant);

				/* Merge avant destruction. */
				this.entityManager.merge(entity);

				/* ************ */
				/* DESTRUCTION. */
				this.entityManager.remove(entity);

			}

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
						, "Méthode deleteById(Long pId)", e);
		}

	} // Fin de deleteById(...).___________________________________________



	/**
	 * <b>retire l'objet métier d'identifiant ou 
	 * d'index (0-based) pId dans le stockage</b>.<br/>
	 * retourne true si le retrait à bien été effectué.<br/>
	 * <ul>
	 * <li>retourne false si pId est hors indexes.</li>
	 * </ul>
	 * - retourne false si pId == null.<br/>
	 * <br/>
	 *
	 * @param pId : Long : 
	 * index (0-based) de l'objet métier à modifier.<br/>
	 * 
	 * @return boolean : true si le retrait à bien été effectué.<br/>
	 * 
	 * @throws Exception 
	 */
	public boolean deleteByIdBoolean(
			final Long pId) throws Exception {

		/* retourne false si pId == null. */
		if (pId == null) {
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

		ICivilite objectPersistant = null;

		/* REQUETE HQL PARAMETREE. */
		final String requeteString 
		= SELECT_OBJET 
			+ "where civilite.id = :pId";

		/* Construction de la requête HQL. */
		final Query requete 
			= this.entityManager.createQuery(requeteString);

		/* Passage des paramètres de la requête HQL. */
		requete.setParameter("pId", pId);

		try {
			
			/* Execution de la requete HQL. */
			objectPersistant 
			= (ICivilite) requete.getSingleResult();
			
		}
		catch (NoResultException noResultExc) {
			objectPersistant = null;
			resultat = false;
		}

		try {

			if (objectPersistant != null) {

				/* Obtention d'une Entity JPA à 
				 * partir de l'objet métier. */
				final CiviliteEntityJPA entity 
					= new CiviliteEntityJPA(objectPersistant);

				/* Merge avant destruction. */
				this.entityManager.merge(entity);

				/* ************ */
				/* DESTRUCTION. */
				this.entityManager.remove(entity);

				resultat = true;
			}

		}
		catch (Exception e) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(CLASSE_SQUELETTEDAO_JPA_SPRING
						, "Méthode deleteByIdBoolean(Long pId)", e);
		}

		return resultat;

	} // Fin de deleteByIdBoolean(...).____________________________________



	/**
	 * <b>retire tous les objets métier dans le stockage</b>.<br/>
	 *
	 * @throws Exception
	 */
	public final void deleteAll() throws Exception {

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
			= "delete from CiviliteEntityJPA";

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
						CLASSE_SQUELETTEDAO_JPA_SPRING
						, "Méthode deleteAll()", e);

		}

	} // Fin de deleteAll()._______________________________________________



	/**
	 * <b>retire tous les objets métier dans le stockage</b>.<br/>
	 * retourne true si le retrait a bien été effectué.<br/>
	 *
	 * @return : boolean : 
	 * true si le retrait a bien été effectué.<br/>
	 * 
	 * @throws Exception
	 */
	public final boolean deleteAllBoolean() throws Exception {

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
			= "delete from CiviliteEntityJPA";

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
						CLASSE_SQUELETTEDAO_JPA_SPRING
						, "Méthode deleteAllBoolean()", e);

		}

		return resultat;

	} // Fin de deleteAll()._______________________________________________


	
	/**
	 * <b>retire tous les objets de l'itérable pList déjà persistés 
	 * dans le stockage</b>.<br/>
	 * ne retourne rien.<br/>
	 * <ul>
	 * <li>ne fait rien et continue le processus de retrait 
	 * si un objet de l'itérable n'est pas persisté.</li>
	 * </ul>
	 * - ne fait rien si pList == null.<br/>
	 * <br/>
	 *
	 * @param pList : Iterable&lt;ICivilite&gt; : 
	 * itérable d'objets à retirer du stockage.<br/>
	 *  
	 * @throws Exception
	 */
	public void deleteIterable(
			final Iterable<ICivilite> pList) throws Exception {

		/* ne fait rien si pList == null. */
		if (pList == null) {
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

		final Iterator<ICivilite> itePersistants = pList.iterator();
		final List<ICivilite> listePersistants 
			= new ArrayList<ICivilite>();

		/* Récupération préalable des objets persistants en base. */
		while (itePersistants.hasNext()) {
			
			final ICivilite objet = itePersistants.next();
			
			/* récupère l'objet persistant dans le stockage. */
			final ICivilite objectPersistant = this.retrieve(objet);

			if (objectPersistant != null) {
				listePersistants.add(objectPersistant);
			}
		}


		/* Itération uniquement sur la liste des Objets persistants. */
		final Iterator<ICivilite> ite = listePersistants.iterator();

		try {

			while (ite.hasNext()) {

				final ICivilite objectPersistant = ite.next();
				
				/* Obtention d'une Entity JPA à 
				 * partir de l'objet métier. */
				final CiviliteEntityJPA entity 
					= new CiviliteEntityJPA(objectPersistant);
				
				/* Merge avant destruction. */
				this.entityManager.merge(entity);

				/* ************ */
				/* DESTRUCTION. */
				this.entityManager.remove(entity);

			}

		}
		catch (Exception e) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException.gererException(
					CLASSE_SQUELETTEDAO_JPA_SPRING
					, "Méthode deleteIterable(Iterable)", e);

		}

	} // Fin de deleteIterable(...)._______________________________________

	
	
	/**
	 * <b>retire tous les objets de l'itérable pList déjà persistés 
	 * dans le stockage</b>.<br/>
	 * retourne true si le retrait a bien été effectué.<br/>
	 * <ul>
	 * <li>ne fait rien et continue le processus de retrait 
	 * si un objet de l'itérable n'est pas persisté.</li>
	 * </ul>
	 * - retourne false si pList == null.<br/>
	 * <br/>
	 *
	 * @param pList : Iterable&lt;ICivilite&gt; : 
	 * itérable d'objets àretirer du stockage?<br/>
	 * 
	 * @return : boolean : true si le retrait a bien été effectué.<br/>
	 * 
	 * @throws Exception
	 */
	public boolean deleteIterableBoolean(
			final Iterable<ICivilite> pList) throws Exception {

		/* retourne false si pList == null. */
		if (pList == null) {
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

		final Iterator<ICivilite> itePersistants = pList.iterator();
		final List<ICivilite> listePersistants 
			= new ArrayList<ICivilite>();

		/* Récupération préalable des objets persistants en base. */
		while (itePersistants.hasNext()) {
			
			final ICivilite objet = itePersistants.next();
			
			/* récupère l'objet persistant dans le stockage. */
			final ICivilite objectPersistant = this.retrieve(objet);

			if (objectPersistant != null) {
				listePersistants.add(objectPersistant);
			}
		}


		boolean resultat = false;
		
		/* Itération uniquement sur la liste des Objets persistants. */
		final Iterator<ICivilite> ite = listePersistants.iterator();

		try {

			while (ite.hasNext()) {

				final ICivilite objectPersistant = ite.next();
				
				/* Obtention d'une Entity JPA à 
				 * partir de l'objet métier. */
				final CiviliteEntityJPA entity 
					= new CiviliteEntityJPA(objectPersistant);
				
				/* Merge avant destruction. */
				this.entityManager.merge(entity);

				/* ************ */
				/* DESTRUCTION. */
				this.entityManager.remove(entity);

			}
			
			resultat = true;

		}
		catch (Exception e) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException.gererException(
					CLASSE_SQUELETTEDAO_JPA_SPRING
					, "Méthode deleteIterableBoolean(Iterable)", e);

		}
		
		return resultat;

	} // Fin de deleteIterableBoolean(...).________________________________



	/* TOOLS *************/


	/**
	 * <b>retourne true si l'objet métier pObject 
	 * existe dans le stockage</b>.<br/>
	 * - retourne false si pObject == null.<br/>
	 * - retourne false si l'Objet métier pObject n'existe pas en base.<br/>
	 * <br/>
	 *
	 * @param pObject : ICivilite : objet métier à rechercher.<br/>
	 * 
	 * @return boolean : 
	 * true si l'objet métier pObject existe dans le stockage.<br/>
	 * 
	 * @throws Exception
	 */
	public boolean exists(
			final ICivilite pObject) throws Exception {

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
		ICivilite objectPersistant = null;

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
			objectPersistant 
			= (ICivilite) requete.getSingleResult();

			/* retourne true si l'objet existe en base. */
			if (objectPersistant != null) {
				resultat = true;
			}

		}
		catch (NoResultException noResultExc) {

			/* retourne false si l'Objet métier n'existe pas en base. */
			return false;

		}
		catch (Exception e) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(CLASSE_SQUELETTEDAO_JPA_SPRING
						, "Méthode exists(ICivilite pObject)", e);
		}

		return resultat;

	} // Fin de exists(...)._______________________________________________



	/**
	 * <b>retourne true si l'objet métier pObject 
	 * d'identifiant ou d'index (0-based) pId 
	 * existe dans le stockage</b>.<br/>
	 * - retourne false si pId == null.<br/>
	 * <br/>
	 *
	 * @param pId : Long : 
	 * identifiant ou index (0-based) de l'objet métier à 
	 * trouver dans le stockage.<br/>
	 * 
	 * @return boolean : 
	 * true si l'objet métier existe dans le stockage.<br/>
	 * 
	 * @throws Exception
	 */
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
	 * <b>retourne le nombre total d'objets métier</b> 
	 * stockés dans le stockage.<br/>
	 * - retourne 0L si this.findAll() retourne null.<br/>
	 * <br/>
	 *
	 * @return : Long : 
	 * nombre d'enregistrements dans le stockage.<br/>
	 * 
	 * @throws Exception
	 */
	public final Long count() throws Exception {

		/* Récupère la liste d'Objets métier de Type paramétré ICivilite. */
		final List<ICivilite> listObjects = this.findAll();

		if (listObjects != null) {

			/* Retourne la taille de la liste. */
			return Long.valueOf(listObjects.size()) ;
		}

		/* retourne 0L si this.findAll() retourne null. */
		return 0L;

	} // Fin de count().___________________________________________________

	
	
	/**
	 * <b>écrit le contenu du stockage dans la console</b>.<br/>
	 * - ne fait rien si findAll() retourne null.<br/>
	 * <br/>
	 *
	 * @throws Exception
	 */
	public void ecrireStockageDansConsole() throws Exception {
		
		/* récupération de tous les objets métier dans le stockage. */
		final List<ICivilite> contenuStockage = this.findAll();
		
		/* ne fait rien si findAll() retourne null. */
		if (contenuStockage == null) {
			return;
		}
		
		for (final ICivilite objet : contenuStockage) {
			System.out.println(objet.toString());
		}
		
	} // Fin de ecrireStockageDansConsole()._______________________________

	
	
	/**
	 * fournit une String pour l'affichage à la console 
	 * d'une Liste d'Objets métier.<br/>
	 * <br/>
	 * retourne null si pList == null.<br/>
	 * <br/>
	 *
	 * @param pList : List&lt;ICivilite&gt;.<br/>
	 * 
	 * @return : String.<br/>
	 */
	public String afficherListeObjetsMetier(
			final List<ICivilite> pList) {
		
		/* retourne null si pList == null. */
		if (pList == null) {
			return null;
		}
		
		final StringBuilder stb =new StringBuilder();
		
		for (final ICivilite objetMetier : pList) {
			
			stb.append(objetMetier.toString());
			stb.append(SAUT_LIGNE_JAVA);
		}
		
		return stb.toString();
		
	} // Fin de afficherListeObjetsMetier(...).____________________________



} // FIN DE LA CLASSE CiviliteDao.-------------------------------------------
