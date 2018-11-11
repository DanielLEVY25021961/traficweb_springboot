package levy.daniel.application.model.services.metier.country.jpaspring.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import levy.daniel.application.model.metier.country.ICountry;
import levy.daniel.application.model.persistence.metier.country.dao.jpaspring.ICountryDAO;
import levy.daniel.application.model.services.metier.country.jpaspring.ICountryService;


/**
 * CLASSE CountryService :<br/>
 * SERVICE.<br/>
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
 * @since 11 nov. 2018
 *
 */
@Service("CountryServiceJPASpring")
public class CountryService implements ICountryService {
	
	// ************************ATTRIBUTS************************************/

	/**
	 * DAO pour les IProfil.<br/>
	 * INJECTE PAR SPRING.<br/>
	 */
	@Autowired
	@Qualifier("CountryDaoJPASpring")
	private transient ICountryDAO countryDAO;


	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(CountryService.class);

	// *************************METHODES************************************/

	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.
	 */
	public CountryService() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Transactional
	@Override
	public ICountry create(
			final ICountry pObject) throws Exception {
		return this.countryDAO.create(pObject);
	} // Fin de create(...)._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void persist(
			final ICountry pObject) throws Exception {
		this.countryDAO.persist(pObject);
	} // Fin de persist(...).______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long createReturnId(
			final ICountry pObject) throws Exception {
		return this.countryDAO.createReturnId(pObject);
	} // Fin de createReturnId(...)._______________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public Iterable<ICountry> save(
			final Iterable<ICountry> pList) throws Exception {
		return this.countryDAO.save(pList);
	} // Fin de save(...)._________________________________________________



	/* READ *************/


	/**
	 * {@inheritDoc}
	 */
	@Override
	public ICountry retrieve(
			final ICountry pObject) throws Exception {
		return this.countryDAO.retrieve(pObject);
	} // Fin de retrieve(...)._____________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public ICountry findById(
			final Long pId) throws Exception {
		return this.countryDAO.findById(pId);
	} // Fin de findById(...)._____________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long retrieveId(
			final ICountry pObject) throws Exception {
		return this.countryDAO.retrieveId(pObject);
	} // Fin de retrieveId(...).___________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ICountry> findAll() throws Exception {
		return this.countryDAO.findAll();
	} // Fin de findAll()._________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ICountry> findAllMax(
			final int pStartPosition
				, final int pMaxResult) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public Iterable<ICountry> findAll(
			final Iterable<Long> pIds) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public ICountry update(
			final Long pId
				, final ICountry pObjectModifie) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public ICountry update(
			final ICountry pObject) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean delete(
			final ICountry pObject) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteById(
			final Long pId) throws Exception {
		// TODO Auto-generated method stub
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteByIdBoolean(
			final Long pId) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteAllBoolean() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteIterable(
			final Iterable<ICountry> pList) throws Exception {
		// TODO Auto-generated method stub
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteIterableBoolean(
			final Iterable<ICountry> pList) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean exists(
			final ICountry pObject) throws Exception {
		return this.countryDAO.exists(pObject);
	} // Fin de exists(...)._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean exists(
			final Long pId) throws Exception {
		return this.countryDAO.exists(pId);
	} // Fin de exists(...)._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long count() throws Exception {
		return this.countryDAO.count();
	} // Fin de count().___________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void ecrireStockageDansConsole() throws Exception {
		this.countryDAO.ecrireStockageDansConsole();
	} // Fin de ecrireStockageDansConsole()._______________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public String afficherListeObjetsMetier(
			final List<ICountry> pList) {
		return this.countryDAO.afficherListeObjetsMetier(pList);
	} // Fin de afficherListeObjetsMetier(...).____________________________

	
	
} // FIN DE LA CLASSE CountryService.----------------------------------------
