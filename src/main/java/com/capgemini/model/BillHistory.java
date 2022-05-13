package com.capgemini.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Service;

@Entity
@Table(name="BillHistory")
@Service
public class BillHistory {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long billHistoryId;
	private Long consumerNumber;
	private double balanceDue;
	private LocalDate LastPaidDate;
	public BillHistory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BillHistory(Long billHistoryId,Long consumerNumber, double balanceDue, LocalDate lastPaidDate) {
		super();
		this.billHistoryId = billHistoryId;
		this.consumerNumber = consumerNumber;
		this.balanceDue = balanceDue;
		LastPaidDate = lastPaidDate;
	}
	public Long getConsumerNumber() {
		return consumerNumber;
	}
	public void setConsumerNumber(Long consumerNumber) {
		this.consumerNumber = consumerNumber;
	}
	public double getBalanceDue() {
		return balanceDue;
	}
	public void setBalanceDue(double balanceDue) {
		this.balanceDue = balanceDue;
	}
	public LocalDate getLastPaidDate() {
		return LastPaidDate;
	}
	public void setLastPaidDate(LocalDate lastPaidDate) {
		LastPaidDate = lastPaidDate;
	}
	@Override
	public String toString() {
		return "BillHistory [billHistoryId=" + billHistoryId + ", consumerNumber=" + consumerNumber + ", balanceDue="
				+ balanceDue + ", LastPaidDate=" + LastPaidDate + "]";
	}

}
