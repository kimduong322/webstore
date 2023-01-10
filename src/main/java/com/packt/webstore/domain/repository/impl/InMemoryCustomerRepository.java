package com.packt.webstore.domain.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.repository.CustomerRepository;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<Customer> getAllCustomers() {
		Map<String, Object> params = new HashMap<String, Object>();
		List<Customer> result = jdbcTemplate.query("SELECT * FROM customers", params, new CustomerMapper());
		return result;
	}
	
	private static final class CustomerMapper implements RowMapper<Customer> {
		public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
			Customer customer = new Customer();
			customer.setCustomerId(rs.getString("C_ID"));
			customer.setName(rs.getString("C_NAME"));
			customer.setAddress(rs.getString("ADDRESS"));
			customer.setNoOfOrdersMade(rs.getInt("NO_OF_ORDERS_MADE"));
			return customer;
		}
	}

	@Override
	public void addCustomer(Customer customer) {
		String SQL = "INSERT INTO CUSTOMERS (C_ID, "
				+ "C_NAME, "
				+ "ADDRESS, "
				+ "NO_OF_ORDERS_MADE) "
				+ "VALUES (:id, :name, :address, :noOfOrdersMade)";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", customer.getCustomerId());
		params.put("name", customer.getName());
		params.put("address", customer.getAddress());
		params.put("noOfOrdersMade", customer.getNoOfOrdersMade());
		
		jdbcTemplate.update(SQL, params);
	}
	
}
