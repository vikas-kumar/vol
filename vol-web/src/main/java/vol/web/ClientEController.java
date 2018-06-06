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

import vol.model.Client;
import vol.model.ClientEI;
import vol.model.ClientPhysique;
import vol.repository.ClientDao;

@Controller
@RequestMapping("/clientE")
public class ClientEController {
	@Autowired
	private ClientDao clientDao;

	@GetMapping("/")
	public String home() {
		return "forward:list";
	}

	@GetMapping("/list")
	public String list(Model model) {
		List<Client> liste = clientDao.findAll();

		model.addAttribute("Clients", liste);

		return "clientE/list";
	}

	@GetMapping("/add")
	public ModelAndView add() {
		return new ModelAndView("/clientE/edit", "clientE", new ClientEI());
	}

	@GetMapping("/edit")
	public String edit(@RequestParam Long id, Model model) {
		Optional<Client> client = clientDao.findById(id);

		if (client.isPresent()) {
			model.addAttribute("client", client.get());
		} else {
			model.addAttribute("client", new ClientEI() );
		}

		return "/clientE/edit";
	}

	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("clientE") ClientEI client, BindingResult result) {

		if (result.hasErrors()) {
			return "/clientE/edit";
		}

		clientDao.save(client);

		return "redirect:list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam Long id) {

		clientDao.deleteById(id);

		return "forward:list";
	}

	@GetMapping("/cancel")
	public String cancel() {
		return "forward:list";
	}
}
