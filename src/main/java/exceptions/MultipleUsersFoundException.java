package exceptions;

public class MultipleUsersFoundException extends RuntimeException{
	public static final String ERR_MSG = "Se detectaron más de un Usuario registrados con el mail [%s]";

	public MultipleUsersFoundException(String mail) {
		super(String.format(ERR_MSG, mail));
	}
}
