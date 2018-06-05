package vol.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "ville")
public class Ville {

	private Long id;
	private String nom;
	private List<VilleAeroport> villeAeroport;
	private int version;

	public Ville() {
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "nom", length = 50)
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@OneToMany(mappedBy = "ville")
	public List<VilleAeroport> getVilleAeroport() {
		return villeAeroport;
	}

	public void setVilleAeroport(List<VilleAeroport> villeAeroport) {
		this.villeAeroport = villeAeroport;
	}

	@Version
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}
