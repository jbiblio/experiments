package de.jbiblio.serstapa.restapi;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.jbiblio.serstapa.api.LoginService;

@Path("login")
public class LoginRestService implements LoginService {

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Override
	public String login(String userName, String password) {
		return "OK";
	}

}
