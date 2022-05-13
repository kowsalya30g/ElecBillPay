package com.capgemini.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.capgemini.model.Connection;
import com.capgemini.model.Customer;

@Repository
public interface ConnectionRepository extends JpaRepository<Connection,Long>{

	@Query("select customer from Customer customer,Connection connection where "
			+ "connection.connectionCustomerId = customer.customerId "
			+ "and connection.consumerNumber=:consumerNumber")
	public Customer readCustomerByConsumerNumber(@Param("consumerNumber") Long consumerNumber);

	public Connection findByConsumerNumber(Long consumerNo);

	@Query("select connection from Connection connection where connection.connectionAddress.village=:villageName and connection.connectionStatus=true")
	public List<Connection> readActiveConnectionsByVillage(@Param("villageName") String villageName);

	@Query("select connection from Connection connection where connection.connectionAddress.taluka=:taluka and connection.connectionStatus=true")
	public List<Connection> readActiveConnectionsByTaluka(@Param("taluka") String taluka);

	@Query("select connection from Connection connection where connection.connectionAddress.district=:districtName and connection.connectionStatus=true")
	public List<Connection> readActiveConnectionsByDistrict(@Param("districtName") String districtName);

	@Query("select connection from Connection connection where connection.connectionAddress.pincode=:pincode and connection.connectionStatus=true")
	public List<Connection> readActiveConnectionsByPincode(@Param("pincode") String pincode);

	@Query("select connection from Connection connection where connection.connectionAddress.village=:villageName and connection.connectionStatus=false")
	public List<Connection> readInactiveConnectionsByVillage(@Param("villageName") String villageName);

	@Query("select connection from Connection connection where connection.connectionAddress.taluka=:taluka and connection.connectionStatus=false")
	public List<Connection> readInactiveConnectionsByTaluka(@Param("taluka") String taluka);

	@Query("select connection from Connection connection where connection.connectionAddress.district=:districtName and connection.connectionStatus=false")
	public List<Connection> readInactiveConnectionsByDistrict(@Param("districtName") String districtName);

	@Query("select connection from Connection connection where connection.connectionAddress.pincode=:pincode and connection.connectionStatus=false")
	public List<Connection> readInactiveConnectionsByPincode(@Param("pincode") String pincode);
}