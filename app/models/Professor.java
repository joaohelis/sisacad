package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import play.db.jpa.Blob;
import play.db.jpa.Model;

@Entity
public class Professor extends Model{
	
	public String nome;
	public Blob foto;
	public String email;
	
	@Temporal(TemporalType.DATE)
	public Date dataNascimento;
	
	@ManyToOne
	public Departamento departamento;
	
	@ManyToMany(mappedBy="professores")
	public List<Projeto> projetos;
}
