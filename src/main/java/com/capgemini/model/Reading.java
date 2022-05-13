package com.capgemini.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="reading")
public class Reading {
	// should be auto-generated
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long readingId;

	@Column(nullable = false)
	private Long consumerNumber;

	@Column(nullable = false)
	private int unitsConsumed;

	// you have to decide either to store path of meter reading photo or to store
	// meter reading photo
	private String readingPhoto;

	@Column(nullable = false)
	private LocalDate readingDate;

	public Reading() {
	}

	public Reading(Long readingId, Long consumerNumber, int unitsConsumed, String readingPhoto,
			LocalDate readingDate) {
		super();
		this.readingId = readingId;
		this.consumerNumber = consumerNumber;
		this.unitsConsumed = unitsConsumed;
		this.readingPhoto = readingPhoto;
		this.readingDate = readingDate;
	}



	public Long getReadingId() {
		return readingId;
	}

	public void setReadingId(Long readingId) {
		this.readingId = readingId;
	}

	public Long getConsumerNumber() {
		return consumerNumber;
	}

	public void setConsumerNumber(Long readingConsumerNumber) {
		this.consumerNumber = readingConsumerNumber;
	}

	public int getUnitsConsumed() {
		return unitsConsumed;
	}

	public void setUnitsConsumed(int unitsConsumed) {
		this.unitsConsumed = unitsConsumed;
	}

	public String getReadingPhoto() {
		return readingPhoto;
	}

	public void setReadingPhoto(String readingPhoto) {
		this.readingPhoto = readingPhoto;
	}

	public LocalDate getReadingDate() {
		return readingDate;
	}

	public void setReadingDate(LocalDate readingDate) {
		this.readingDate = readingDate;
	}

	@Override
	public String toString() {
		return "Reading [readingId=" + readingId + ", consumerNumber=" + consumerNumber + ", unitsConsumed="
				+ unitsConsumed + ", readingPhoto=" + readingPhoto + ", readingDate=" + readingDate + "]";
	}



}