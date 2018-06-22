package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
    	long professoresCount = Professor.count();
    	long usuariosCount = Usuario.count();
    	long projetosCount = Projeto.count();
    	long departamentosCount = Departamento.count();
    	render(professoresCount, usuariosCount, projetosCount, departamentosCount);
    }

}