package hotelmanagement.dao;

import java.util.List;

import hotelmanagement.data.Services;

public interface ServicesDAO {

	public boolean addService(Services service);
	
	public boolean removeService(String serviceName);
	
	public List<Services> displayAllServices();
}
