package hotelmanagement.dao;

import java.util.List;

import hotelmanagement.data.Customers;
import hotelmanagement.data.Services;

public interface CustomersDAO {

	public boolean addCustomer(Customers customer);

	public Customers findCustomerByName(String firstName, String lastName);

	public Customers findCustomerByIdCard(String idCard);
	
	public Customers findCustomerByRoomId(int roomId);
	
	public List<Customers> displayAllCustomers();
	
	public boolean deleteCustomer(String idCard);
	
	public boolean updateCustomer(String idCard, List<Services> serviceList);
	
	public boolean setDateOut(String idCard);
	
	public boolean updateCustomerServices(Customers customer);
	
}
