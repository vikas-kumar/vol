package vol.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "aeroport")
public class Aeroport {

	private Long id;
	private String nom;
	private List<VilleAeroport> villeAeroport;
	private List<Escale> escales;
	private int version;

	public Aeroport() {
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
	//-------------------------------------------------------------------------------------------------------------------------------------------------
	@NotEmpty(message = "{aeroport.edit.nom.required}")
	@Pattern(regexp="^[A-Z].*$", message="{aeroport.edit.nom.pattern}")
	//-------------------------------------------------------------------------------------------------------------------------------------------------
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@OneToMany(mappedBy = "aeroport", fetch = FetchType.LAZY)
	public List<VilleAeroport> getVilleAeroport() {
		return villeAeroport;
	}

	public void setVilleAeroport(List<VilleAeroport> villeAeroport) {
		this.villeAeroport = villeAeroport;
	}

	@OneToMany(mappedBy = "aeroport", fetch = FetchType.LAZY)
	public List<Escale> getEscales() {
		return escales;
	}

	public void setEscales(List<Escale> escales) {
		this.escales = escales;
	}

	@Version
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}


}
