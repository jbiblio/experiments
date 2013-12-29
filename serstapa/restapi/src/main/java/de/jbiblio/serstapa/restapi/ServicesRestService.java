package de.jbiblio.serstapa.restapi;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.jbiblio.serstapa.api.ServicesService;
import de.jbiblio.serstapa.model.services.Service;

@Path("services")
public class ServicesRestService implements ServicesService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<Service> getServices() {
		return Arrays.asList(new Service(UUID.randomUUID(), "Service A",
				"online"), new Service(UUID.randomUUID(), "Service B",
				"offline"));
	}
}
