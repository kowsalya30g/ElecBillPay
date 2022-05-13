package com.capgemini.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="Payment")
public class Payment {

	// should be auto-generated
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long paymentId;
	private Long consumerNumber;
	private LocalDate paymentDate;

	@Email
	@NotBlank(message="Email cannot be Blank")
	@Column(name="email")
	private String email;

	@Enumerated(EnumType.STRING)
	@Column(name="PaymentMode")
	private PaymentMode paymentMode;
	private double latePaymentCharges;
	private double totalPaid;

	@Enumerated(EnumType.STRING)
	@Column(name="PaymentStatus")
	private PaymentStatus status;

	public Long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}
	public Long getConsumerNumber() {
		return consumerNumber;
	}
	public void setConsumerNumber(Long consumerNumber) {
		this.consumerNumber = consumerNumber;
	}
	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
	public PaymentMode getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}
	public double getLatePaymentCharges() {
		return latePaymentCharges;
	}
	public void setLatePaymentCharges(double latePaymentCharges) {
		this.latePaymentCharges = latePaymentCharges;
	}
	public double getTotalPaid() {
		return totalPaid;
	}
	public void setTotalPaid(double totalPaid) {
		this.totalPaid = totalPaid;
	}
	public PaymentStatus getStatus() {
		return status;
	}
	public void setStatus(PaymentStatus status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", consumerNumber=" + consumerNumber+ ", paymentDate=" + paymentDate
				+ ", paymentMode=" + paymentMode + ", latePaymentCharges=" + latePaymentCharges + ", totalPaid="
				+ totalPaid + ", status=" + status + "]";
	}


}
