package jobs;

import java.util.Date;

import enums.Status;
import models.Professor;
import models.Usuario;
import models.Departamento;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class Inicializador extends Job {
	
	@Override
	public void doJob() throws Exception {
		
		if(Usuario.count() == 0) {
			Usuario usuario = new Usuario();
			usuario.email = "admin@admin.com";
			usuario.senha = "123";
			usuario.status = Status.ATIVO;
			usuario.save();
		}
		
		if(Departamento.count() == 0) {
			Departamento d1 = new Departamento();
			d1.nome = "Departamento de Ciências Exatas";
			d1.save();
			
			Departamento d2 = new Departamento();
			d2.nome = "Departamento de Ciências Humanas";
			d2.save();
		}
	}
}
