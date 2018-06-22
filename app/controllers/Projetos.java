package controllers;

import java.util.List;

import annotations.Admin;
import interceptors.Seguranca;
import models.Professor;
import models.Projeto;
import play.mvc.Controller;
import play.mvc.With;

public class Projetos extends Controller {

	public static void form(Projeto projeto) {
		List<Professor> professores = Professor.findAll();
		render(projeto, professores);
	}
	
	
	public static void salvar(Projeto projeto, List<String> professorIDs) {

		if(professorIDs == null || professorIDs.isEmpty()) {
			projeto.professores = null;
		}else {
			String IDs = "(" + String.join(", ", professorIDs) + ")";		
			String query = "select p from Professor p where p.id in " + IDs;
			List<Professor> professores = Professor.find(query).fetch();
			projeto.professores = professores;
		}
		projeto.save();
		flash.success("Projeto salvo com sucesso!");
		detalhes(projeto.id);
	}
	
	public static void listar() {
		List<Projeto> projetos = Projeto.findAll(); 
		render(projetos);
	}
	
	public static void detalhes(Long id) {
		Projeto projeto = Projeto.findById(id);
		render(projeto);
	}
	
	public static void editar(Long id) {
		Projeto projeto = Projeto.findById(id);
		List<Professor> professores = Professor.findAll();
		renderTemplate("Projetos/form.html", projeto, professores);
	}
	
	public static void remover(Long id) {
		Projeto projeto = Projeto.findById(id);
		projeto.delete();
		flash.success("Projeto removido com sucesso!");
		listar();
	}
}
