package vol.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import vol.model.Adresse;
import vol.model.Aeroport;
import vol.model.ClientPhysique;
import vol.model.CompagnieAerienne;
import vol.model.CompagnieAerienneVol;
import vol.model.Escale;
import vol.model.Login;
import vol.model.Passager;
import vol.model.Reservation;
import vol.model.TitrePhysique;
import vol.model.Ville;
import vol.model.VilleAeroport;
import vol.model.Vol;
import vol.repository.AeroportDao;
import vol.repository.ClientDao;
import vol.repository.CompagnieAerienneDao;
import vol.repository.CompagnieAerienneVolDao;
import vol.repository.EscaleDao;
import vol.repository.LoginDao;
import vol.repository.PassagerDao;
import vol.repository.ReservationDao;
import vol.repository.VilleAeroportDao;
import vol.repository.VilleDao;
import vol.repository.VolDao;

@ContextConfiguration(locations = "classpath:application-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestTPVol {

	@Autowired
	private AeroportDao aeroportDao;
	@Autowired
	private ClientDao clientDao;
	@Autowired
	private CompagnieAerienneDao compagnieAerienneDao;
	@Autowired
	private CompagnieAerienneVolDao compagnieAerienneVolDao;
	@Autowired
	private EscaleDao escaleDao;
	@Autowired
	private LoginDao loginDao;
	@Autowired
	private PassagerDao passagerDao;
	@Autowired
	private ReservationDao reservationDao;
	@Autowired
	private VilleAeroportDao villeAeroportDao;
	@Autowired
	private VilleDao villeDao;
	@Autowired
	private VolDao volDao;

	@Test
	public void populate() {
		Adresse adrClient = new Adresse();
		adrClient.setAdresse("rue de la paix");
		adrClient.setCodePostal("75001");
		adrClient.setPays("France");
		adrClient.setVille("Paris");

		Adresse adrPassager = new Adresse();
		adrPassager.setAdresse("rue des lapins");
		adrPassager.setCodePostal("45000");
		adrPassager.setPays("Orleans");
		adrPassager.setVille("France");

		Passager passager = new Passager();
		passager.setNom("Bunny");
		passager.setPrenom("Bugs");
		passager.setAdresse(adrPassager);

		Ville villeDep = new Ville();
		Ville villeArr = new Ville();
		Ville villeEscale = new Ville();
		villeDep.setNom("Paris");
		villeArr.setNom("Lima");
		villeEscale.setNom("Geneve");

		Aeroport aeroportDep = new Aeroport();
		aeroportDep.setNom("charles de gaulle");

		Aeroport aeroportArr = new Aeroport();
		aeroportArr.setNom("Lima airport");

		Aeroport aeroportEscale = new Aeroport();
		aeroportEscale.setNom("Geneve airport");

		VilleAeroport vaDep = new VilleAeroport();
		VilleAeroport vaArr = new VilleAeroport();
		VilleAeroport vaEsc = new VilleAeroport();
		vaDep.setAeroport(aeroportDep);
		vaDep.setVille(villeDep);
		vaArr.setAeroport(aeroportArr);
		vaArr.setVille(villeArr);
		vaEsc.setAeroport(aeroportEscale);
		vaEsc.setVille(villeEscale);

		Vol vol = new Vol();
		Calendar cal = GregorianCalendar.getInstance();
		cal.set(2014, Calendar.APRIL, 18, 15, 20, 00);
		cal.set(Calendar.MILLISECOND, 0);
		Date dateDepart = cal.getTime();
		Date heureDepart = cal.getTime();
		cal.set(2015, Calendar.MAY, 4, 15, 35, 00);
		cal.set(Calendar.MILLISECOND, 0);
		Date dateArrivee = cal.getTime();
		Date heureArrivee = cal.getTime();

		vol.setDateDepart(dateDepart);
		vol.setDateArrivee(dateArrivee);
		vol.setHeureArrivee(heureArrivee);
		vol.setHeureDepart(heureDepart);
		vol.setDepart(aeroportDep);
		vol.setArrivee(aeroportArr);

		List<Escale> escales = new ArrayList<Escale>();
		Escale escale = new Escale();
		escale.setAeroport(aeroportEscale);
		escale.setVol(vol);
		escales.add(escale);

		CompagnieAerienne ca = new CompagnieAerienne();
		ca.setNom("AirFrance");

		CompagnieAerienneVol cav = new CompagnieAerienneVol(ca, vol);
		cav.setNumero("963");

		ClientPhysique cp = new ClientPhysique();

		Login logClient = new Login();
		logClient.setAdmin(false);
		logClient.setLogin("rd");
		logClient.setMotDePasse("rd");

		cp.setNom("DESTREZ");
		cp.setPrenom("Raphael");
		cp.setTitre(TitrePhysique.MR);
		cp.setEmail("raphael.destrez@sopra.com");
		cp.setNumeroTel("688888888");
		cp.setAdresse(adrClient);
		cp.setLogin(logClient);

		Reservation res = new Reservation();
		res.setNumero(600);
		res.setPassager(passager);
		res.setVol(vol);
		res.setClient(cp);

		passagerDao.save(passager);

		villeDao.save(villeDep);
		villeDao.save(villeArr);
		villeDao.save(villeEscale);

		aeroportDao.save(aeroportDep);
		aeroportDao.save(aeroportArr);
		aeroportDao.save(aeroportEscale);

		villeAeroportDao.save(vaDep);
		villeAeroportDao.save(vaArr);
		villeAeroportDao.save(vaEsc);

		volDao.save(vol);

		escaleDao.save(escale);

		compagnieAerienneDao.save(ca);

		compagnieAerienneVolDao.save(cav);

		loginDao.save(logClient);

		clientDao.save(cp);

		reservationDao.save(res);
	}

}
