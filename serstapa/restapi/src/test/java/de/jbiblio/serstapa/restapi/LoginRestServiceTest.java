/*
 *    Copyright 2013 Michael Holtermann
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.jbiblio.serstapa.restapi;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
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
	@Ignore
	public void testLogin() {
		String response = target.path("login").request().get(String.class);
		
		MatcherAssert.assertThat(response, Is.is("OK"));
	}
	
	
}
