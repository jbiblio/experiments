package de.jbiblio.serstapa.model.services;

import java.util.UUID;

public class Service {

	private UUID id;

	private String name;

	private String status;

	public Service(UUID id, String name, String status) {
		this.id = id;
		this.name = name;
		this.status = status;
	}

	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getStatus() {
		return status;
	}

}
