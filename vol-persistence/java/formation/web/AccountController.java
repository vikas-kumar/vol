package formation.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import formation.model.Utilisateur;

@Controller
@RequestMapping("/account")
public class AccountController {

	@GetMapping("/subscribe")
	public String subscribe(Model model) {
		model.addAttribute("user", new Utilisateur());

		return "subscribe";
	}
	
	@PostMapping("/subscribe")
	public String subscribe(@Valid @ModelAttribute("user") Utilisateur utilisateur, BindingResult errors, Model model) {
//		new UtilisateurValidator().validate(utilisateur, errors);
		
		if(errors.hasErrors()) {
			return "subscribe";
		}
		
		System.out.println(utilisateur);
		
		return "redirect:success";
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(new UtilisateurValidator());
	}
	
	@GetMapping("success")
	public String success() {
		return "success";
	}
}
