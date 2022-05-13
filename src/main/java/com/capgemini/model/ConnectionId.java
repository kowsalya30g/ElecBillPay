package com.capgemini.model;

import java.io.Serializable;
import java.util.Objects;

public class ConnectionId implements Serializable{

	Long connectionId;
	Long consumerNumber;

	public ConnectionId() {}

	public ConnectionId(Long connectionId, Long consumerNumber) {
		super();
		this.connectionId = connectionId;
		this.consumerNumber = consumerNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(connectionId, consumerNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConnectionId other = (ConnectionId) obj;
		return Objects.equals(connectionId, other.connectionId) && Objects.equals(consumerNumber, other.consumerNumber);
	}



}