package controllers;

import java.util.List;

import models.Professor;
import models.Usuario;
import play.mvc.Controller;

public class Usuarios extends Controller{
	
	public static void listar() {
		List<Usuario> usuarios = Usuario.findAll();
		render(usuarios);
	}
}
