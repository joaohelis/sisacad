package interceptors;

import annotations.Admin;
import controllers.Login;
import play.mvc.Before;
import play.mvc.Controller;

public class Seguranca extends Controller{
	
	@Before
	static void checarAdministrador() {
		String usuario = session.get("ususario");
//		Admin admin = getControllerAnnotation(Admin.class);
		
		boolean seguranca = getControllerAnnotation(Admin.class) != null ||
				   			getActionAnnotation(Admin.class) != null;
		
		System.out.println(seguranca);
		System.out.println(usuario);
		if(seguranca && usuario == null) {
			flash.error("Por favor, entre com seu login e senha.");
			Login.login();
		}

	}
}
