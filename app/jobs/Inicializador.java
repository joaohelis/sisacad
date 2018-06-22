package jobs;

import java.util.Arrays;
import java.util.Date;

import enums.Status;
import models.Professor;
import models.Projeto;
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
			
			
			Professor professor = new Professor();
			professor.nome = "João Helis Bernardo";
			professor.email = "joao.helis@ifrn.edu.br";
			professor.dataNascimento = new Date("1993/7/27");
			professor.departamento = d1;
			professor.save();
			
			Professor professor2 = new Professor();
			professor2.nome = "Daniel Aguiar";
			professor2.email = "daniel@ifrn.edu.com";
			professor.dataNascimento = new Date("1988/08/08");
			professor2.departamento = d2;
			professor2.save();
			
			Professor professor3 = new Professor();
			professor3.nome = "Milena Veríssimo Barbosa";
			professor3.email = "milahverissimo@gmail.com";
			professor3.dataNascimento = new Date("1993/12/11");
			professor3.departamento = d2;
			professor3.save();
			
			Projeto projeto = new Projeto();
			projeto.nome = "Projeto Integrador de DSW";
			projeto.descricao = "Projeto interdisciplinar das disciplinas "
					+ "Desenvolvimento de Sistemas Web, Autora Web e Banco de Dados.";
			projeto.professores = Arrays.asList(new Professor[] {professor, professor3});
			projeto.save();
		}
	}
}
