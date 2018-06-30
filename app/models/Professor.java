package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import play.data.validation.Email;
import play.data.validation.Required;
import play.db.jpa.Blob;
import play.db.jpa.Model;

@Entity
public class Professor extends Model{
	
	@Required
	public String nome;
	public Blob foto;
	
	@Required
	@Email
	public String email;
	
	@Required
	@Temporal(TemporalType.DATE)
	public Date dataNascimento;
	
	@Required
	@ManyToOne
	@JoinColumn(name="departamento_id")
	public Departamento departamento;
	
	@ManyToMany(mappedBy="professores")
	public List<Projeto> projetos;

	@Override
	public String toString() {
		return "Professor [nome=" + nome + "]";
	}
}
