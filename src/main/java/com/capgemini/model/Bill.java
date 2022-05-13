package com.capgemini.model;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="bill")
public class Bill {
	// should be auto-generated
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long billId;

	@OneToOne(cascade = CascadeType.ALL)
	private Reading billForReading;

	private LocalDate billDate;

	private LocalDate billDueDate;

	private int unitsConsumed;

	private double billAmount;

	public Bill() {}

	public Bill(Long billId, Reading billForReading, LocalDate billDate, LocalDate billDueDate, int unitsConsumed,
			double billAmount) {
		super();
		this.billId = billId;
		this.billForReading = billForReading;
		this.billDate = billDate;
		this.billDueDate = billDueDate;
		this.unitsConsumed = unitsConsumed;
		this.billAmount = billAmount;
	}

	public Long getBillId() {
		return billId;
	}
	public void setBillId(Long billId) {
		this.billId = billId;
	}

	public LocalDate getBillDate() {
		return billDate;
	}
	public void setBillDate(LocalDate billDate) {
		this.billDate = billDate;
	}
	public LocalDate getBillDueDate() {
		return billDueDate;
	}
	public void setBillDueDate(LocalDate billDueDate) {
		this.billDueDate = billDueDate;
	}
	public int getUnitsConsumed() {
		return unitsConsumed;
	}
	public void setUnitsConsumed(int unitsConsumed) {
		this.unitsConsumed = unitsConsumed;
	}
	public double getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}
	public Reading getBillForReading() {
		return billForReading;
	}
	public void setBillForReading(Reading billForReading) {
		this.billForReading = billForReading;
	}

	@Override
	public String toString() {

		return "\n"+"\n"+"Bill ID =  "+billId+"\n"+"\n"+"\n"+
				"Bill Date  =  "+billDate+"\n"+"\n"+"\n"+
				"Bill Due Date  = "+billDueDate+"\n"+"\n"+"\n"+
				"Units Consumed  = "+unitsConsumed+"\n"+"\n"+"\n"+
				"Bill Amount  = "+billAmount;



	}




}