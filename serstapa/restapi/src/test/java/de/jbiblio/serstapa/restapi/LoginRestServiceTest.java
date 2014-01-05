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

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.Ignore;
import org.junit.Test;

import de.jbiblio.serstapa.model.services.Service;

public class LoginRestServiceTest extends JerseyTest {

	@Consumes(MediaType.APPLICATION_JSON) 
	private final class ServiceTestMessageBodyReader implements
			MessageBodyReader<List<Service>> {
		@Override
		public boolean isReadable(Class<?> type, Type genericType,
				Annotation[] annotations, MediaType mediaType) {
			return true;
		}

		@Override
		public List<Service> readFrom(Class<List<Service>> type,
				Type genericType, Annotation[] annotations,
				MediaType mediaType,
				MultivaluedMap<String, String> httpHeaders,
				InputStream entityStream) throws IOException,
				WebApplicationException {
			// TODO Auto-generated method stub
			return null;
		}
	}

	@Override
	protected Application configure() {
		enable(TestProperties.LOG_TRAFFIC);
		enable(TestProperties.DUMP_ENTITY);
		return new RestApi();
	}

	@Override
	protected void configureClient(ClientConfig config) {
		super.configureClient(config);
		config.register(new ServiceTestMessageBodyReader());
	}

	@Test
	@Ignore
	public void testServices() {
		WebTarget target;
		Client c = ClientBuilder.newClient();
		target = c.target("http://localhost:8080/restapi");
		List<Service> response = target.path("services").request()
				.accept(MediaType.APPLICATION_JSON)
				.acceptEncoding(StandardCharsets.UTF_8.name())
				.get(new GenericType<List<Service>>() {
				});

		assertThat(response.isEmpty(), is(false));
	}
}
