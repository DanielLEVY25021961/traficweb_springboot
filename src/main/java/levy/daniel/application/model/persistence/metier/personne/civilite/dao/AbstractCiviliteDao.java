package levy.daniel.application.model.persistence.metier.personne.civilite.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.personne.civilite.ICivilite;
import levy.daniel.application.model.persistence.daoexceptions.AbstractDaoException;
import levy.daniel.application.model.persistence.metier.AbstractDaoGenericJPASpring;

/**
 * CLASSE ABSTRAITE <b>AbstractCiviliteDao</b> :<br/>
 * <p>
 * <span style="text-decoration: underline;">CONCEPT 
 * CONCERNE PAR CE DAO</span>
 * </p>
 * <p>
 * <b>ICivilite</b> Modélise un <i>concept</i> de <b>Civilite</b>, 
 * *********** 
 * associé de manière ***** à une <b>******</b>.
 * </p>
 * 
 * <p>
 * <span style="text-decoration: underline;">DESCRIPTION DE 
 * AbstractCiviliteDao</span>
 * </p>
 * <ul>
 * <li>
 * DAO ABSTRAIT SPRING pour les <b>ICivilite</b>.
 * </li>
 * <li>
 * Comporte l'implémentation des méthodes <b>spécifiques</b> aux 
 * ICivilite.
 * </li>
 * <li>IMPLEMENTE L'INTERFACE IDaoProfil.</li>
 * <li>
 * HERITE DE LA CLASSE ABSTRAITE 
 * AbstractDaoGenericJPASpring&lt;ICivilite, Long&gt;.
 * </li>
 * <li>
 * <b>FACTORISE</b> les attributs et comportements 
 * des <i>descendants concrets</i>.
 * </li>
 * </ul>
 * 
 * <p>
 * <span style="text-decoration: underline;">IMPLEMENTATION DES AbstractCiviliteDao</span>
 * </p>
 * <ul>
 * <li>
 * <img src="../../../../../../../../../../../javadoc/images/implementation_DAO_Civilite.png" 
 * alt="implémentation des DAOs Civilite" border="1" align="center" />
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
 * @since 28 février 2018
 *
 */
public abstract class AbstractCiviliteDao 
		extends AbstractDaoGenericJPASpring<ICivilite, Long> 
										implements ICiviliteDao {

	// ************************ATTRIBUTS************************************/

	/**
	 * "Classe AbstractCiviliteDao".<br/>
	 */
	public static final String CLASSE_ABSTRACT_CIVILITE_DAO 
		= "Classe AbstractCiviliteDao";

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
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(AbstractCiviliteDao.class);

	// *************************METHODES************************************/


	/**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public AbstractCiviliteDao() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________


	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Long createReturnId(
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
		}

		/* retourne null si pObject est un doublon. */
		if (this.exists(pObject)) {
			return null;
		}

		/* Crée l'Objet en base ou jette une AbstractDaoException. */
		final ICivilite objetPersistant 
			= this.create(pObject);

		/* retourne null si l'objet pObject n'a pu être créé en base. */
		if (objetPersistant == null) {
			return null;
		}

		/* retourne l'ID de l'objet persistant. */
		return objetPersistant.getId();	

	} // Fin de createReturnId(...)._______________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public ICivilite retrieve(
			final ICivilite pObject) throws AbstractDaoException {

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
						CLASSE_ABSTRACT_CIVILITE_DAO
						, "Méthode retrieve(ICivilite pObject)", e);
		}

		return objetResultat;

	} // Fin de retrieve(...)._____________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final ICivilite retrieveByIdMetier(
			final ICivilite pObjet) throws AbstractDaoException {
		return this.retrieve(pObjet);	
	} // Fin de retrieveByIdMetier(...).___________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final ICivilite retrieveByAttributs(
			final String pCiviliteString)
					throws AbstractDaoException {

		/* return null si pProfilString est blank. */
		if (StringUtils.isBlank(pCiviliteString)) {
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
		requete.setParameter("pCiviliteString", pCiviliteString);

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
						CLASSE_ABSTRACT_CIVILITE_DAO
						, "Méthode retrieveByAttributs(String pCiviliteString)", e);
		}

		return objetResultat;

	} // Fin de retrieveByAttributs(...).__________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract ICivilite findById(Long pId) 
				throws AbstractDaoException;



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteById(
			final Long pId) throws AbstractDaoException {

		/* ne fait rien si pId == null. */
		if (pId == null) {
			return;
		}

		ICivilite objetPersistant = null;

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
			objetPersistant 
			= (ICivilite) requete.getSingleResult();
		}
		catch (NoResultException noResultExc) {
			objetPersistant = null;
		}


		try {

			if (objetPersistant != null) {

				/* Merge avant destruction. */
				this.entityManager.merge(objetPersistant);

				/* DESTRUCTION. */
				this.entityManager.remove(objetPersistant);

			}

		}
		catch (Exception e) {

			/* LOG. */
			if (LOG.isDebugEnabled()) {
				LOG.debug(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(CLASSE_ABSTRACT_CIVILITE_DAO
						, "Méthode deleteById(Long pId)", e);
		}

	} // Fin de deleteById(...).___________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteByIdBoolean(
			final Long pId) throws AbstractDaoException {

		/* retourne false si pId == null. */
		if (pId == null) {
			return false;
		}

		boolean resultat = false;

		ICivilite objetPersistant = null;

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
			objetPersistant 
			= (ICivilite) requete.getSingleResult();
		}
		catch (NoResultException noResultExc) {
			objetPersistant = null;
			resultat = false;
		}

		try {

			if (objetPersistant != null) {

				/* Merge avant destruction. */
				this.entityManager.merge(objetPersistant);

				/* DESTRUCTION. */
				this.entityManager.remove(objetPersistant);

				resultat = true;
			}

		}
		catch (Exception e) {

			/* LOG. */
			if (LOG.isDebugEnabled()) {
				LOG.debug(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(CLASSE_ABSTRACT_CIVILITE_DAO
						, "Méthode deleteByIdBoolean(Long pId)", e);
		}

		return resultat;

	} // Fin de deleteByIdBoolean(...).____________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean exists(
			final ICivilite pObject) throws AbstractDaoException {

		/* retourne false si pObject == null. */
		if (pObject == null) {
			return false;
		}

		boolean resultat = false;		
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

			/* retourne true si l'objet existe en base. */
			if (objetResultat != null) {
				resultat = true;
			}

		}
		catch (NoResultException noResultExc) {

			/* retourne false si l'Objet métier n'existe pas en base. */
			return false;

		}
		catch (Exception e) {

			/* LOG. */
			if (LOG.isDebugEnabled()) {
				LOG.debug(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(CLASSE_ABSTRACT_CIVILITE_DAO
						, "Méthode exists(ICivilite pObject)", e);
		}

		return resultat;

	} // Fin de exists(...)._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean exists(
			final Long pId) throws AbstractDaoException {

		/* retourne false si pId == null . */
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
	public String afficherListe(
			final List<ICivilite> pListe) {

		/* retourne null si pListe == null. */
		if (pListe == null) {
			return null;
		}

		final StringBuilder stb = new StringBuilder();

		for (final ICivilite objet : pListe) {
			stb.append(objet.toString());
			stb.append(SAUT_LIGNE_JAVA);
		}

		return stb.toString();			

	} // Fin de afficherListe(...).________________________________________



	/**
	 * {@inheritDoc}
	 * <br/>
	 * this.<b>classObjetMetier</b> dans AbstractDaoProfil : 
	 * <b>ICivilite.class</b><br/>
	 * <br/>
	 */
	@Override
	protected final void renseignerClassObjetMetier() {

		this.setClassObjetMetier(ICivilite.class);

	} // Fin de renseignerClassObjetMetier().______________________________

	

} // FIN DE LA CLASSE AbstractCiviliteDao.-----------------------------------
