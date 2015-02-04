package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

import models.*;
import play.data.*;
import java.util.List;

import play.data.*;
import play.data.Form.*;
import play.data.DynamicForm;

public class Application extends Controller {

    public static Result index() {
    	Form<FrmLogin> loginForm = Form.form(FrmLogin.class);
    	Form<FrmRegistro> registroForm = Form.form(FrmRegistro.class);
    	//return ok(index.render(loginForm));
    	return ok(index.render(loginForm, registroForm));
    }

    public static Result acceso(){
    	Form<FrmRegistro> registroForm = Form.form(FrmRegistro.class);
    	//SE LLENA EL FORMULARIO CON LOS DATOS OBTENIDOS PARA REALIZAR SU VALIDACIÓN
    	Form<FrmLogin> loginForm = Form.form(FrmLogin.class).bindFromRequest();
    	//SE REALIZA LA VALIDACIÓN CON LOS CONSTRAINT
    	if (loginForm.hasErrors()) {
    		//SI EXISTEN ERRORES, SE DEVUELVEN
    		//return badRequest(index.render(loginForm));
    		return ok(index.render(loginForm, registroForm));
    	}
    	else {
    		//CREO UN FORMULARIO DINÁMICO PARA PODER UTILIZAR LA DATA RECIBIDA Y PROCESARLA
    		DynamicForm requestData = Form.form().bindFromRequest();
    		//ASIGNO LA DATA A VARIABLES
    		String username = requestData.get("username"); //formulario.get().username
    		String password = requestData.get("password");
    		
    		Usuarios usuario = Usuarios.find.where().eq("username", username).eq("password", password).findUnique();
    		if(usuario == null) {
    			flash("userInvalido", "Verifica tu nombre de usuario o contraseña");
    			return badRequest(index.render(loginForm, registroForm));
    		}
    		else{
    			return ok("Usuario ingresado de forma exitosa");
    		}
    	}
    }

    public static Result registro(){
    	Form<FrmLogin> loginForm = Form.form(FrmLogin.class);
    	Form<FrmRegistro> registroForm = Form.form(FrmRegistro.class).bindFromRequest();
    	if (registroForm.hasErrors()) {
    		//SI EXISTEN ERRORES, SE DEVUELVEN
    		return badRequest(index.render(loginForm, registroForm));
    		//return ok(index.render(loginForm, registroForm));
    	}
    	else {
    		Usuarios usuario = new Usuarios();
    		usuario.nombre = registroForm.get().nombre;
    		usuario.genero = registroForm.get().genero;
    		usuario.fecha_nacimiento = new java.util.Date();
    		usuario.username = registroForm.get().username;
    		usuario.password = registroForm.get().password;
    		usuario.preguntas_id = registroForm.get().pregunta;
    		usuario.respuesta = registroForm.get().respuesta;
    		usuario.save();
    		return ok("Usuario almacenado de forma exitosa");
    	}
    }

}
