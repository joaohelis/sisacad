package models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import enums.Status;
import play.db.jpa.Model;

@Entity
public class Usuario extends Model{

	public String email;
	public String senha;
	
	@Enumerated(EnumType.STRING)
	public Status status;

	@Override
	public String toString() {
		return email;
	}
}
