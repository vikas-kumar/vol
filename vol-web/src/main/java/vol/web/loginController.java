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

import vol.model.Login;
import vol.repository.LoginDao;

@Controller
@RequestMapping("/login")
public class loginController {
	@Autowired
	private LoginDao loginDao;

	@GetMapping("/")
	public String home() {
		return "forward:list";
	}

	@GetMapping("/list")
	public String list(Model model) {
		List<Login> liste = loginDao.findAll();

		model.addAttribute("logins", liste);

		return "/login/list";
	}

	@GetMapping("/add")
	public ModelAndView add() {
		return new ModelAndView("/login/edit", "login", new Login());
	}

	@GetMapping("/edit")
	public String edit(@RequestParam Long id, Model model) {
		Optional<Login> login = loginDao.findById(id);

		if (login.isPresent()) {
			model.addAttribute("login", login.get());
		} else {
			model.addAttribute("login", new Login());
		}

		return "/login/edit";
	}

	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("login") Login login, BindingResult result) {

		if (result.hasErrors()) {
			return "/login/edit";
		}

		loginDao.save(login);

		return "redirect:list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam Long id) {

		loginDao.deleteById(id);

		return "forward:list";
	}

	@GetMapping("/cancel")
	public String cancel() {
		return "forward:list";
	}
}
