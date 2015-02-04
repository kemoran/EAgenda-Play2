package models;

import play.data.validation.Constraints.*;
import play.data.*;
import play.data.Form.*;

public class FrmLogin {
	@Required(message="Campo obligatorio")
	public String username;
	@Required(message="Campo obligatorio")
	public String password;
}