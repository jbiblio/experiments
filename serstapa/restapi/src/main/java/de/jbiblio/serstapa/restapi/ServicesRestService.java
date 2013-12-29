package de.jbiblio.serstapa.restapi;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import de.jbiblio.serstapa.api.ServicesService;
import de.jbiblio.serstapa.model.Service;

public class ServicesRestService implements ServicesService {

	@Override
	public List<Service> getServices() {
		return Arrays.asList(new Service(UUID.randomUUID(), "Service A",
				"online"), new Service(UUID.randomUUID(), "Service B",
				"offline"));
	}

}
