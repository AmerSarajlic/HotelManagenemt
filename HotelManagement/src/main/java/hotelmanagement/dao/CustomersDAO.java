package hotelmanagement.dao;

import java.util.List;

import hotelmanagement.data.Customers;

public interface CustomersDAO {

	public void addCustomer(Customers customer);

	public void removeCustomer(String idCard);

	public double bill(String idCard);

	public List<Customers> displayAllCustomers();
	
}
