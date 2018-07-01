package controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.ivy.osgi.core.BundleInfoAdapter.ProfileNotFoundException;

import models.Departamento;
import models.Professor;
import models.Projeto;
import play.Play;
import play.mvc.Controller;

public class Departamentos extends Controller {
	
	public static void form() {
		List<Professor> professores = Professor.findAll();
		render(professores);
	}
	
	public static void salvar(Departamento departamento, List<String> professorIDs) {
		
		String IDs = "-1";
		if(professorIDs != null)
			IDs = String.join(", ", professorIDs);
			
		String query = "select p from Professor p where p.id in (" + IDs + ")";			
		List<Professor> professoresAssociados = Professor.find(query).fetch();
		for(Professor professor: professoresAssociados) {
			professor.departamento = departamento;
			professor.save();
		}
		
		query = "select p from Professor p where p.id not in ("+ IDs + ")";	
		System.out.println(query);
		List<Professor> professoresNaoAssociado = Professor.find(query).fetch();
		for(Professor professor: professoresNaoAssociado) {
			if(professor.departamento != null && 
			   professor.departamento.id == departamento.id) {
				professor.departamento = null;
				professor.save();
			}
		}
		departamento.save();
		flash.success("Departamento salvo com sucesso!");
		detalhes(departamento.id);
	}
	
	public static void listar() {
		List<Departamento> departamentos = Departamento.findAll();
		render(departamentos);
	}
	
	public static void detalhes(Long id) {
		Departamento departamento = Departamento.findById(id);
		render(departamento);
	}
	
	public static void editar(Long id) {
		Departamento departamento = Departamento.findById(id);
		List<Professor> professores = Professor.findAll();
		renderTemplate("Departamentos/form.html", departamento, professores);
	}

}
