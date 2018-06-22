package controllers;

import java.util.List;

import enums.Status;
import models.Departamento;
import models.Professor;
import models.Usuario;
import play.mvc.Controller;

public class Usuarios extends Controller{
	
	
	public static void form(Usuario usuario) {
		Status[] status = Status.values();
		render(usuario, status);
	}
	
	public static void listar() {
		List<Usuario> usuarios = Usuario.findAll();
		render(usuarios);
	}
	
	public static void salvar(Usuario usuario) {
		usuario.save();
		flash.success("Usuário salvo com sucesso!");
		listar();
	}
	
	public static void editar(Long id) {
		Usuario usuario = Usuario.findById(id);
		Status[] status = Status.values();
		renderTemplate("Usuarios/form.html", usuario, status);
	}
	
	public static void remover(Long id) {
		Usuario usuario = Usuario.findById(id);
		usuario.delete();
		flash.success("Usuário removido com sucesso!");
		listar();
	}
}