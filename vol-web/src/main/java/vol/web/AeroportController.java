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

import vol.model.Aeroport;
import vol.repository.AeroportDao;


@Controller
@RequestMapping("/aeroport")
public class AeroportController {
	@Autowired
	private AeroportDao aeroportDao;
	
	@GetMapping("/")
	public String home() {
		return "forward:list";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		List<Aeroport> liste = aeroportDao.findAll();

		model.addAttribute("aeroports", liste);

		return "/aeroport/list";
	}

	@GetMapping("/add")
	public ModelAndView add() {
		return new ModelAndView("/aeroport/edit", "aeroport", new Aeroport());
	}

	@GetMapping("/edit")
	public String edit(@RequestParam Long id, Model model) {
		Optional<Aeroport> aeroport = aeroportDao.findById(id);

		if (aeroport.isPresent()) {
			model.addAttribute("aeroport", aeroport.get());
		} else {
			model.addAttribute("aeroport", new Aeroport());
		}

		return "/aeroport/edit";
	}

	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("aeroport") Aeroport aeroport, BindingResult result) {

		if (result.hasErrors()) {
			return "/aeroport/edit";
		}

		aeroportDao.save(aeroport);

		return "redirect:list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam Long id) {

		aeroportDao.deleteById(id);

		return "forward:list";
	}

	@GetMapping("/cancel")
	public String cancel() {
		return "forward:list";
	}
}
