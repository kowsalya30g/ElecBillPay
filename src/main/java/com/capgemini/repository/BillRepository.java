package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.capgemini.model.Bill;

public interface BillRepository extends JpaRepository<Bill,Long> {

	@Query("select bill from Bill bill where bill.billForReading.consumerNumber=:consumerNumber")
	public Bill findBillByConsumerNumber(@Param("consumerNumber") Long consumerNumber);

	public Bill findBilByBillId(Long billId);

}
