package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Departamento extends Model{

	public String nome;
	
	@Override
	public String toString() {
		return nome;
	}

}
