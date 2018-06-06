package formation.web;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import formation.model.Utilisateur;

public class UtilisateurValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return Utilisateur.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "username.empty",
				"L'utilisateur doit être renseigné");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.empty",
				"Le mot de passe doit être saisi");
	}

}
