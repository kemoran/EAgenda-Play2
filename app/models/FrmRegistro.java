package models;

import play.data.validation.Constraints.*;
import play.data.*;
import play.data.Form.*;
import play.data.format.*;

public class FrmRegistro {
	//DATOS DEL USUARIO
	@Required(message="Campo obligatorio")
	public String nombre;
	@Required(message="Campo obligatorio")
	public String genero;
	@Required(message="Campo obligatorio")
	@Formats.DateTime(pattern="dd-MM-yyyy")
	public String fecha_nacimiento;

	//DATOS DE LA CUENTA
	@Required(message="Campo obligatorio")
	public String username;
	@Required(message="Campo obligatorio")
	public String password;
	@Required(message="Campo obligatorio")
	public Long pregunta;
	@Required(message="Campo obligatorio")
	public String respuesta;

}