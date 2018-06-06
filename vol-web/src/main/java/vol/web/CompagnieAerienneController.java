package vol.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import vol.model.CompagnieAerienne;
import vol.model.Ville;
import vol.repository.CompagnieAerienneDao;

@Controller
@RequestMapping("/compagnieaerienne")
public class CompagnieAerienneController {

	@Autowired
	private CompagnieAerienneDao caDao;

	@GetMapping("/")
	public String home() {
		return "forward:list";
	}

	@GetMapping("/list")
	public String list(Model model) {
		List<CompagnieAerienne> liste = caDao.findAll();

		model.addAttribute("compagnieaerienne", liste);

		return "/compagnieAerienne/list";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam Long id, Model model) {
		Optional<CompagnieAerienne> compagnie = caDao.findById(id);

		if (compagnie.isPresent()) {
			model.addAttribute("compagnieaerienne", compagnie.get());
		} else {
			model.addAttribute("compagnieaerienne", new CompagnieAerienne());
		}

		return "/compagnieAerienne/edit";
	}

	@GetMapping("/add")
	public ModelAndView add() {
		return new ModelAndView("/compagnieAerienne/edit", "compagnieaerienne", new CompagnieAerienne());
	}

	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("compagnieaerienne") CompagnieAerienne ca, BindingResult result) {

		if (result.hasErrors()) {
			return "/compagnieAerienne/edit";
		}

		caDao.save(ca);

		return "redirect:list";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam Long id) {

		caDao.deleteById(id);

		return "forward:list";
	}

	@GetMapping("/cancel")
	public String cancel() {
		return "forward:list";
	}

}
