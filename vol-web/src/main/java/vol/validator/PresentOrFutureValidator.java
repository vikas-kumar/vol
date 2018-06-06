package vol.validator;

import java.util.Calendar;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import vol.model.Reservation;


public class PresentOrFutureValidator implements ConstraintValidator<PresentOrFuture, Date> {

	public boolean supports(Class<?> cls) {
		return Reservation.class.equals(cls);
	}
	
	public final boolean isValid(final Date value, final ConstraintValidatorContext context) {

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);

		Date today = calendar.getTime();

		return !value.before(today) || value.after(today);

	}
}