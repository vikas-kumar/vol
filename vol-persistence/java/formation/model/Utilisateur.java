package formation.model;

import javax.validation.constraints.NotEmpty;

public class Utilisateur {
	@NotEmpty(message= "Le nom est obligatoire !!!")
	private String nom;
	@NotEmpty(message="Le prénom n'est pas renseigné !")
	private String prenom;
	private String username;
	private String password;

	public Utilisateur() {
		super();
	}

	public Utilisateur(String nom, String prenom, String username, String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.username = username;
		this.password = password;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Utilisateur [nom=" + nom + ", prenom=" + prenom + ", username=" + username + ", password=" + password
				+ "]";
	}

}
