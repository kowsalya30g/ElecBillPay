package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.capgemini.model.BillHistory;

public interface BillHistoryRepository extends JpaRepository<BillHistory,Long> {

	public BillHistory findBillHistoryByConsumerNumber(Long consumerNumber);

}
