package de.jbiblio.serstapa.restapi;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LoginRestServiceTest {

	private HttpServer server;
	private WebTarget target;

	@Before
	public void setUp() {
		server = HttpServer.createSimpleServer();
		Client c = ClientBuilder.newClient();
		target = c.target("http://localhost:8080/status/api/rest");
	}
	
	@After
	public void tearDown() {
		server. shutdown();
	}
	
	@Test
	public void testLogin() {
		String response = target.path("login").request().get(String.class);
		
		MatcherAssert.assertThat(response, Is.is("OK"));
	}
	
	
}
