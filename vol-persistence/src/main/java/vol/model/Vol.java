package vol.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="Vol")
public class Vol {

	private Long id;
	private Date dateDepart;
	private Date dateArrivee;
	private Date heureDepart;
	private Date heureArrivee;
	private List<Escale> escales;
	private List<Reservation> reservations;
	private Aeroport depart;
	private Aeroport arrivee;
	private List<CompagnieAerienneVol> compagniesAerienneVol;
	private int version;
	
	public Vol() {
	}

	@Id  @GeneratedValue 
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="date_depart")
	@NotNull(message = "{vol.edit.dateDepart.required}")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	
	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	@Column(name="date_arrivee")
	@NotNull(message = "{vol.edit.dateArrivee.required}")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	public Date getDateArrivee() {
		return dateArrivee;
	}

	public void setDateArrivee(Date dateArrivee) {
		this.dateArrivee = dateArrivee;
	}

	@Column(name="heure_depart")
	@NotNull(message = "{vol.edit.heureDepart.required}")
	@DateTimeFormat(pattern="hh:mm")
	@Temporal(TemporalType.TIME)
	public Date getHeureDepart() {
		return heureDepart;
	}

	public void setHeureDepart(Date heureDepart) {
		this.heureDepart = heureDepart;
	}

	@Column(name="heure_arrivee")
	@NotNull(message = "{vol.edit.heureArrivee.required}")
	@DateTimeFormat(pattern="hh:mm")
	@Temporal(TemporalType.TIME)
	public Date getHeureArrivee() {
		return heureArrivee;
	}

	public void setHeureArrivee(Date heureArrivee) {
		this.heureArrivee = heureArrivee;
	}

	@OneToMany(mappedBy="vol",fetch = FetchType.LAZY)
	public List<Escale> getEscales() {
		return escales;
	}

	public void setEscales(List<Escale> escales) {
		this.escales = escales;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "depart_id")
	public Aeroport getDepart() {
		return depart;
	}

	
	public void setDepart(Aeroport depart) {
		this.depart = depart;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "arrivee_id")
	public Aeroport getArrivee() {
		return arrivee;
	}

	public void setArrivee(Aeroport arrivee) {
		this.arrivee = arrivee;
	}

	@Version
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@OneToMany(mappedBy = "vol",fetch = FetchType.LAZY)
	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	@OneToMany(mappedBy="vol",fetch = FetchType.LAZY)
	public List<CompagnieAerienneVol> getCompagniesAerienneVol() {
		return compagniesAerienneVol;
	}

	public void setCompagniesAerienneVol(
			List<CompagnieAerienneVol> compagniesAerienneVol) {
		this.compagniesAerienneVol = compagniesAerienneVol;
	}
	

}
