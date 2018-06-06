package formation.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@RequestMapping(value= {"/home/{username}"})
	public String accueil(@PathVariable(name="username") String user, @RequestParam Long idProduit, Model model) {
		model.addAttribute("nomUtilisateur", user);
		model.addAttribute("idProduit", idProduit);
		
		return "accueil";
	}

}
