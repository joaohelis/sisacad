package controllers;

import java.util.List;

import models.Departamento;
import play.mvc.Controller;

public class Departamentos extends Controller {
	
	public static void listar() {
		List<Departamento> departamentos = Departamento.findAll();
		render(departamentos);
	}

}
