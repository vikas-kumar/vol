package vol.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "compagnie_aerienne_vol")
public class CompagnieAerienneVol {

	private Long id;
	private String numero;
	private CompagnieAerienne compagnieAerienne;
	private Vol vol;
	private int version;

	public CompagnieAerienneVol() {
	}

	public CompagnieAerienneVol(CompagnieAerienne compagnieAerienne, Vol vol) {
		super();
		this.compagnieAerienne = compagnieAerienne;
		this.vol = vol;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="compagnieaerienne_id")
	public CompagnieAerienne getCompagnieAerienne() {
		return compagnieAerienne;
	}

	public void setCompagnieAerienne(CompagnieAerienne compagnieAerienne) {
		this.compagnieAerienne = compagnieAerienne;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="vol_id")
	public Vol getVol() {
		return vol;
	}

	public void setVol(Vol vol) {
		this.vol = vol;
	}

	@Column(name = "Numero", length = 50)
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Version
	@Column(name = "Version")
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}
