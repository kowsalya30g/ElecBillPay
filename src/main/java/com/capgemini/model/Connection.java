package com.capgemini.model;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@IdClass(value = ConnectionId.class)
@Table(name="connections")
public class Connection {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="connectionId")
	private Long connectionId;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="consumerNumber")
	private Long consumerNumber;

	private Long connectionCustomerId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="addressId")
	private Address connectionAddress;

	@Enumerated(EnumType.STRING)
	@Column(name="connectionType")
	private ConnectionType connectionType;

	private LocalDate applicationDate;
	private LocalDate connectionDate;

	// connectionStatus will be active or inactive
	private boolean connectionStatus;

	public Connection() {
		super();
	}

	public Connection(Long connectionId, Long consumerNumber, Long connectionCustomerId, Address connectionAddress,
			ConnectionType connectionType, LocalDate applicationDate, LocalDate connectionDate,
			boolean connectionStatus) {
		super();
		this.connectionId = connectionId;
		this.consumerNumber = consumerNumber;
		this.connectionCustomerId = connectionCustomerId;
		this.connectionAddress = connectionAddress;
		this.connectionType = connectionType;
		this.applicationDate = applicationDate;
		this.connectionDate = connectionDate;
		this.connectionStatus = connectionStatus;
	}



	public Long getConnectionId() {
		return connectionId;
	}

	public void setConnectionId(Long connectionId) {
		this.connectionId = connectionId;
	}

	public Long getConsumerNumber() {
		return consumerNumber;
	}

	public void setConsumerNumber(Long consumerNumber) {
		this.consumerNumber = consumerNumber;
	}

	public Address getConnectionAddress() {
		return connectionAddress;
	}

	public Long getConnectionCustomerId() {
		return connectionCustomerId;
	}

	public void setConnectionCustomerId(Long connectionCustomerId) {
		this.connectionCustomerId = connectionCustomerId;
	}

	public void setConnectionAddress(Address connectionAddress) {
		this.connectionAddress = connectionAddress;
	}

	public ConnectionType getConnectionType() {
		return connectionType;
	}

	public void setConnectionType(ConnectionType connectionType) {
		this.connectionType = connectionType;
	}

	public LocalDate getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(LocalDate applicationDate) {
		this.applicationDate = applicationDate;
	}

	public LocalDate getConnectionDate() {
		return connectionDate;
	}

	public void setConnectionDate(LocalDate connectionDate) {
		this.connectionDate = connectionDate;
	}

	public boolean getConnectionStatus() {
		return connectionStatus;
	}

	public void setConnectionStatus(boolean connectionStatus) {
		this.connectionStatus = connectionStatus;
	}

	@Override
	public String toString() {
		return "Connection [connectionId=" + connectionId + ", consumerNumber=" + consumerNumber
				+ ", connectionCustomerId=" + connectionCustomerId + ", connectionAddress=" + connectionAddress
				+ ", connectionType=" + connectionType + ", applicationDate=" + applicationDate + ", connectionDate="
				+ connectionDate + ", connectionStatus=" + connectionStatus + "]";
	}



}