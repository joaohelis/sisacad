package controllers;

import java.util.List;

import models.Departamento;
import models.Professor;
import models.Projeto;
import play.data.validation.Valid;
import play.mvc.Before;
import play.mvc.Controller;

public class Professores extends Controller{
	
	public static void form() {
		List<Departamento> departamentos = Departamento.findAll();
		render(departamentos);
	}
	
	public static void salvar(@Valid Professor professor) {
		
		System.out.println(validation.hasErrors());
		
		if(validation.hasErrors()) {
			validation.keep();
			params.flash();
			form();
		}
		
		if(params.get("excluirFoto") != null) {
			professor.foto.getFile().delete();
		}
		professor.save();
		flash.success("Professor salvo com sucesso!");
		detalhes(professor.id);
	}
	
	public static void editar(Long id) {
		Professor professor = Professor.findById(id);
		List<Departamento> departamentos = Departamento.findAll();
		renderTemplate("Professores/form.html", professor, departamentos);
	}
	
	public static void detalhes(Long id) {
		Professor professor = Professor.findById(id);
		render(professor);
	}
	
	public static void listar() {
		List<Professor> professores = Professor.findAll(); 
		render(professores);
	}
	
	public static void remover(Long id) {
		Professor professor = Professor.findById(id);
		for (Projeto projeto : professor.projetos) {
			projeto.professores.remove(professor);
			projeto.save();
		}
		professor.refresh();
		professor.delete();
		flash.success("Professor removido com sucesso!");
		listar();
	}
	
	public static void buscar(String busca) {
		System.out.println(busca);
		List<Professor> professores = Professor.find("nome like ? or email like ?", "%"+busca+"%", "%"+busca+"%").fetch();
		renderTemplate("Professores/listar.html", professores);
	}
	
	public  static  void  fotoProfessor(Long  id) {
	    Professor professor = Professor.findById(id);
	    notFoundIfNull(professor);
	    response.setContentTypeIfNotSet(professor.foto.type());
	    renderBinary(professor.foto.get());
	}

}