package levy.daniel.application.model.metier.internaute.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.internaute.IInternaute;
import levy.daniel.application.model.metier.profil.IProfil;


/**
 * CLASSE Internaute :<br/>
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
 * @since 4 nov. 2018
 *
 */
public class Internaute implements IInternaute {
	
	// ************************ATTRIBUTS************************************/

	/**
	 * .<br/>
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * identifiant en base.<br/>
	 */
	private Long id;
	
	/**
	 * prénom de l'internaute.<br/>
	 */
	private String prenom;
	
	/**
	 * nom de l'internaute.<br/>
	 */
	private String nom;
	
	/**
	 * login de l'internaute.<br/>
	 */
	private String login;
	
	/**
	 * mot de passe de l'internaute.<br/>
	 */
	private String password;
		
	/**
	 * profils (ADMINISTRATEUR, CONSULTANT, ...) de l'internaute.<br/>
	 */
	private List<IProfil> profils;
	
		
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(Internaute.class);
	
	// *************************METHODES************************************/
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public Internaute() {
		this(null, null, null, null, null, null);
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	 /**
	 * CONSTRUCTEUR COMPLET.<br/>
	 * <br/>
	 *
	 * @param pPrenom : String : prénom de l'internaute.
	 * @param pNom : String : nom de l'internaute.
	 * @param pLogin : String : login de l'internaute.
	 * @param pPassword : String : mot de passe de l'internaute.
	 * @param pProfils : List&lt;IProfil&gt; : 
	 * profils (ADMINISTRATEUR, CONSULTANT, ...).
	 */
	public Internaute(
			final String pPrenom, final String pNom
				, final String pLogin, final String pPassword
				, final List<IProfil> pProfils) {
		this(null, pPrenom, pNom, pLogin, pPassword, pProfils);
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________

	
	
	 /**
	 * CONSTRUCTEUR COMPLET BASE.<br/>
	 * <br/>
	 *
	 * @param pId : Long : identifiant en base.
	 * @param pPrenom : String : prénom de l'internaute.
	 * @param pNom : String : nom de l'internaute.
	 * @param pLogin : String : login de l'internaute.
	 * @param pPassword : String : mot de passe de l'internaute.
	 * @param pProfils : List&lt;IProfil&gt; : 
	 * profils (ADMINISTRATEUR, CONSULTANT, ...).
	 */
	public Internaute(
			final Long pId
				, final String pPrenom, final String pNom
				, final String pLogin, final String pPassword
				, final List<IProfil> pProfils) {
		
		super();
		
		this.id = pId;
		this.prenom = pPrenom;
		this.nom = pNom;
		this.login = pLogin;
		this.password = pPassword;
		this.profils = pProfils;
		
	} // FIN DE CONSTRUCTEUR COMPLET BASE._________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.login == null) 
				? 0 : this.login.hashCode());
		result = prime * result + ((this.password == null) 
				? 0 : this.password.hashCode());
		
		return result;
		
	} // Fin de hashCode().________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean equals(
			final Object pObject) {
		
		if (this == pObject) {
			return true;
		}
		if (pObject == null) {
			return false;
		}
		if (!(pObject instanceof Internaute)) {
			return false;
		}
		
		final IInternaute other = (IInternaute) pObject;
		
		/* 1 - login. */
		if (this.login == null) {
			if (other.getLogin() != null) {
				return false;
			}
		}
		else if (!this.login.equalsIgnoreCase(other.getLogin())) {
			return false;
		}
		
		/* 2 - password. */
		if (this.password == null) {
			if (other.getPassword() != null) {
				return false;
			}
		}
		else if (!this.password.equalsIgnoreCase(other.getPassword())) {
			return false;
		}
		
		return true;
		
	} // Fin de equals(...)._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final int compareTo(
			final IInternaute pObject) {
		
		if (this == pObject) {
			return 0;
		}

		if (pObject == null) {
			return -1;
		}

		int compareLogin;
		int comparePassword;

		/* 1-login. */
		if (this.getLogin() == null) {
			if (pObject.getLogin() != null) {
				return +1;
			}
		} else {
			if (pObject.getLogin() == null) {
				return -1;
			}

			compareLogin 
				= this.getLogin()
					.compareTo(pObject.getLogin());

			if (compareLogin != 0) {
				return compareLogin;
			}
		}

		/* 2-password. */
		if (this.getPassword() == null) {
			if (pObject.getPassword() != null) {
				return +1;
			}
			return 0;
		} 

		if (pObject.getPassword() == null) {
			return -1;
		}

		comparePassword 
			= this.getPassword()
				.compareTo(pObject.getPassword());

		return comparePassword;

	} // Fin de compareTo(...).____________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Internaute clone() throws CloneNotSupportedException {

		final Internaute clone 
				= (Internaute) super.clone();

		clone.setId(this.id);
		clone.setPrenom(this.getPrenom());
		clone.setNom(this.getNom());
		clone.setLogin(this.getLogin());
		clone.setPassword(this.getPassword());
		
		/* clonage profond. */
		final List<IProfil> profilsClone 
			= new ArrayList<>(this.getProfils());
		clone.setProfils(profilsClone);

		return clone;

	} // Fin de clone().___________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String toString() {
		
		final StringBuilder builder = new StringBuilder();
		
		builder.append("Internaute [");
		
		builder.append("id=");
		if (this.id != null) {			
			builder.append(this.id);			
		} else {
			builder.append(NULL);
		}
		builder.append(VIRGULE_ESPACE);
		
		builder.append("prenom=");
		if (this.prenom != null) {			
			builder.append(this.prenom);
		} else {
			builder.append(NULL);
		}
		builder.append(VIRGULE_ESPACE);
		
		builder.append("nom=");
		if (this.nom != null) {			
			builder.append(this.nom);
		} else {
			builder.append(NULL);
		}
		builder.append(VIRGULE_ESPACE);
		
		builder.append("login=");
		if (this.login != null) {			
			builder.append(this.login);
		} else {
			builder.append(NULL);
		}
		builder.append(VIRGULE_ESPACE);
		
		builder.append("password=");
		if (this.password != null) {			
			builder.append(this.password);
		} else {
			builder.append(NULL);
		}
		builder.append(VIRGULE_ESPACE);
		
		builder.append("profils=");
		if (this.profils != null) {
			
			int i = 0;
			
			for (final IProfil profil : this.profils) {
				
				i++;
				builder.append("profil-");
				builder.append(i);
				builder.append(" [");
				builder.append(profil.toString());
				builder.append(']');
				
				if (i < this.profils.size()) {
					builder.append(TIRET_ESPACE);
				}
			}
			
		} else {
			builder.append(NULL);
		}
				
		builder.append(']');
		
		return builder.toString();
		
	} // Fin de toString().________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transient
	public final String getEnTeteCsv() {
		return "id;prenom;nom;login;password;profil principal;";
	} // Fin de getEnTeteCsv().____________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String toStringCsv() {

		final StringBuilder stb = new StringBuilder();

		/* id. */
		stb.append(this.getId());
		stb.append(POINT_VIRGULE);

		/* prenom. */
		stb.append(this.getPrenom());
		stb.append(POINT_VIRGULE);

		/* nom. */
		stb.append(this.getNom());
		stb.append(POINT_VIRGULE);
		
		/* login. */
		stb.append(this.getLogin());
		stb.append(POINT_VIRGULE);
		
		/* password. */
		stb.append(this.getPassword());
		stb.append(POINT_VIRGULE);

		/* profil principal. */
		IProfil profilPrincipal = null;
		if (this.profils != null) {
			profilPrincipal = this.profils.get(0);
		} 
		stb.append(profilPrincipal);
		stb.append(POINT_VIRGULE);

		return stb.toString();

	} // Fin de toStringCsv()._____________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transient
	public final String getEnTeteColonne(
			final int pI) {

		String entete = null;

		switch (pI) {

		case 0:
			entete = "id";
			break;

		case 1:
			entete = "prenom";
			break;

		case 2:
			entete = "nom";
			break;

		case 3:
			entete = "login";
			break;
			
		case 4:
			entete = "password";
			break;
			
		case 5:
			entete = "profil principal";
			break;

		default:
			entete = "invalide";
			break;

		} // Fin du Switch._________________________________

		return entete;

	} // Fin de getEnTeteColonne(...)._____________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transient
	public final Object getValeurColonne(
			final int pI) {

		Object valeur = null;

		switch (pI) {

		case 0:
			if (this.getId() != null) {
				valeur = String.valueOf(this.getId());
			}
			break;

		case 1:
			valeur = this.getPrenom();		
			break;

		case 2:
			valeur = this.getNom();		
			break;

		case 3:
			valeur = this.getLogin();		
			break;
			
		case 4:
			valeur = this.getPassword();
			break;
			
		case 5:
			
			IProfil profilPrincipal = null;
			String profilStringPrincipal = null;
			
			if (this.profils != null) {
				
				profilPrincipal = this.profils.get(0);
				profilStringPrincipal = profilPrincipal.getProfilString();
				
				if (!StringUtils.isBlank(profilStringPrincipal)) {
					valeur = profilStringPrincipal;
				}
			}
			break;

		default:
			valeur = "invalide";
			break;

		} // Fin du Switch._________________________________

		return valeur;

	} // Fin de getValeurColonne(...)._____________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean ajouterProfil(
			final IProfil pProfil) {
		
		if (this.profils != null) {
			
			return this.profils.add(pProfil);
		}
		
		return false;
		
	} // Fin de ajouterProfil(...).________________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean retirerProfil(
			final IProfil pProfil) {
		
		if (this.profils != null) {
			
			return this.profils.remove(pProfil);
		}
		
		return false;
		
	} // Fin de retirerProfil(...).________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String listerProfils() {
		
		if (this.profils != null) {
			
			final StringBuilder stb = new StringBuilder();
			
			for (final IProfil profil : this.profils) {
				stb.append(profil.toString());
				stb.append(SAUT_DE_LIGNE);
			}
			
			return stb.toString();
		}
		
		return NULL;
		
	} // Fin de listerProfils().___________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long getId() {
		return this.id;
	} // Fin de getId().___________________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setId(
			final Long pId) {
		this.id = pId;
	} // Fin de setId(...).________________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getPrenom() {
		return this.prenom;
	} // Fin de getPrenom()._______________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setPrenom(
			final String pPrenom) {
		this.prenom = pPrenom;
	} // Fin de setPrenom(...).____________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getNom() {
		return this.nom;
	} // Fin de getNom().__________________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setNom(
			final String pNom) {
		this.nom = pNom;
	} // Fin de setNom(...)._______________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getLogin() {
		return this.login;
	} // Fin de getLogin().________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setLogin(
			final String pLogin) {
		this.login = pLogin;
	} // Fin de setLogin(...)._____________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getPassword() {
		return this.password;
	} // Fin de getPassword()._____________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setPassword(
			final String pPassword) {
		this.password = pPassword;
	} // Fin de setPassword(...).__________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<IProfil> getProfils() {
		return this.profils;
	} // Fin de getProfils().______________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setProfils(
			final List<IProfil> pProfils) {
		this.profils = pProfils;
	} // Fin de setProfils(...).___________________________________________


	
} // FIN DE LA CLASSE Internaute.--------------------------------------------
