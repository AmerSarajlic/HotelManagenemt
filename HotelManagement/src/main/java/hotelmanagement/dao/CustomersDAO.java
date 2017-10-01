package hotelmanagement.dao;

import java.util.List;

import hotelmanagement.data.Customers;

public interface CustomersDAO {

	public boolean addCustomer(Customers customer);

	public Customers findCustomerByName(String firstName, String lastName);

	public Customers findCustomerByIdCard(String idCard);
	
	public List<Customers> displayAllCustomers();
	
	public boolean deleteCustomer(String idCard);
	
}
