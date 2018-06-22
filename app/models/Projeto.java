package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

import play.db.jpa.Model;

@Entity
public class Projeto extends Model {
	
	public String nome;
	
	@Lob
	public String descricao;
	
	@ManyToMany
	@JoinTable(name="projetos_professores")
	public List<Professor> professores;

}
